package com.AllanYin.ConcurrencyInPractice.ReaderWriter;

/**
 * Created by allan on 19/01/17.
 */
public class Reader implements Runnable {
    private final int readTimes;
    private final FileData fileData;

    public Reader (int readTimes, FileData fileData) {
        this.readTimes = readTimes;
        this.fileData = fileData;
    }

    /**
     * will read data readTimes times and measure the time cost.
     */
    public void run() {
        long time = System.currentTimeMillis();
        for (int j = 0; j < readTimes; j++) {
            String[] content = fileData.read();
        }
        long mil = System.currentTimeMillis() - time;
        System.out.println(String.format("Reading fileData %d times is %.3fs; Thread name is %s", readTimes, (double) mil / 1000, Thread.currentThread().getName()));
    }
}
