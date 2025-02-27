package just_writing_code.threading.downloader;

public class DownloadTask {
    private final String filename;
    private final int estimatedEffort;


    public DownloadTask( String filename, int estimatedEffort ) {
        this.filename = filename;
        this.estimatedEffort = estimatedEffort;
    }



    public String getFilename() {
        return filename;
    }

    public int getEstimatedEffort() {
        return estimatedEffort;
    }
}
