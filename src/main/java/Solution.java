import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Solution{

    public static void main(String[] args) throws IOException {
        if(args.length<1) throw new IllegalArgumentException("URL Required as parameter!");

        DownloadManager downloadManager = new DownloadManager();

        try(BufferedReader r = new BufferedReader(new InputStreamReader(new BufferedInputStream(new URL(args[0]).openStream())))){
            String str = null;
            while ((str=r.readLine())!=null){
                downloadManager.addToDownload(new SrcFile(str));
            }
        }

        downloadManager.process();
    }
}

