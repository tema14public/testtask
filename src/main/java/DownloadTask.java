import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DownloadTask implements Runnable {

    private SrcFile file;

    public DownloadTask(SrcFile file) {
        this.file = file;
    }

    @Override
    public void run() {
        try {

            //download file
            try(ReadableByteChannel rbc = Channels.newChannel(file.getURL().openStream());FileOutputStream fos = new FileOutputStream(file.getFileName())) {
                fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            }

            //get md5 of downloaded file
            file.setMd5check(getMD5File(file.getFileName()));

            //print result of downloaded file
            System.out.println(file);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private String getMD5File(String fileName) throws IOException, NoSuchAlgorithmException {
        String md5 = null;
        try(FileInputStream is = new FileInputStream(file.getFileName())){
            MessageDigest md = MessageDigest.getInstance("MD5");
            FileChannel channel = is.getChannel();
            ByteBuffer buff = ByteBuffer.allocate(2048);
            while(channel.read(buff) != -1)
            {
                buff.flip();
                md.update(buff);
                buff.clear();
            }
            byte[] hashValue = md.digest();
            md5 = DatatypeConverter
                    .printHexBinary(hashValue);

        }
        return md5;
    }
}
