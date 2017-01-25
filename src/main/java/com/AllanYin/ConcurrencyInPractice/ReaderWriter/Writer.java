package com.AllanYin.ConcurrencyInPractice.ReaderWriter;

/**
 * Created by allan on 19/01/17.
 */
public class Writer implements Runnable {
    private final FileData fileData;

    public Writer( FileData fileData) {
        this.fileData = fileData;
    }

    /**
     * will write the data.
     */
    public void run() {
        long time = System.currentTimeMillis();
        String content = Thread.currentThread().getName().substring(7);
        fileData.write(content);
        long mil = System.currentTimeMillis() - time;
        System.out.println(String.format("Writing (%s) into fileData is %.3fs; Thread name is %s", content, (double) mil / 1000, Thread.currentThread().getName()));
    }
}
