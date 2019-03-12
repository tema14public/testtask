import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DownloadManager {

    private List<SrcFile> itemsToDownload = new ArrayList();
    private List<Future> results = new ArrayList();

    public void addToDownload(SrcFile file){
        itemsToDownload.add(file);
    }

    public void process(){

        //create threadpool for each file
        ExecutorService service = Executors.newFixedThreadPool(itemsToDownload.size());
        itemsToDownload.forEach(i->results.add(service.submit(new DownloadTask(i))));
        service.shutdown();
    }

}
