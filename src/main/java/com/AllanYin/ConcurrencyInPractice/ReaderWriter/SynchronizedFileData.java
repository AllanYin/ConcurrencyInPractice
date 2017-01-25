package com.AllanYin.ConcurrencyInPractice.ReaderWriter;

import static java.lang.Thread.sleep;

/**
 * Created by allan on 19/01/17.
 */
public class SynchronizedFileData extends FileData {
    private final static int READTIMEMILL = 300;
    private final static int WRITETIMEMILL = 1000;

    @Override
    public String[] read() {
        synchronized(this) {
            wait(READTIMEMILL);
            return super.read();
        }
    }
    @Override
    public void write(String content) {
        synchronized(this) {
            wait(WRITETIMEMILL);
            super.write(content);
        }
    }

    private void wait(int millSecond) {
        try {
            sleep(millSecond);
        } catch (InterruptedException e) {
            e.printStackTrace(); //TODO: error handling
        }
    }

}
