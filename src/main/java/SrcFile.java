import java.net.MalformedURLException;
import java.net.URL;

public class SrcFile {

    private URL url;
    private String md5;
    private String md5check;

    public SrcFile(String str) throws MalformedURLException {
        String[] tmp = str.split(",");
        if(tmp.length<2) throw new IllegalArgumentException("Wrong string format for download file");
        url = new URL(tmp[0]);
        md5 = tmp[1];
    }

    public URL getURL() {
        return url;
    }

    public String getMd5() {
        return md5;
    }

    public String getMd5check() {
        return md5check;
    }

    public void setMd5check(String md5check) {
        this.md5check = md5check.toLowerCase();
    }

    public String getFileName(){
        return url.getPath().substring(url.getPath().lastIndexOf('/') + 1);
    }

    @Override
    public String toString() {
        return String.format("Downloaded file: %s, expected md5: %s, received md5: %s",getFileName(),md5,md5check);
    }
}
