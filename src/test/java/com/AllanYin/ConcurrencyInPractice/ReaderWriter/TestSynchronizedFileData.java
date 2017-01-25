package com.AllanYin.ConcurrencyInPractice.ReaderWriter;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.lang.Thread.sleep;

/**
 * Created by allan on 25/01/17.
 */
public class TestSynchronizedFileData extends TestFileData{
    final int count = 10;
    final FileData fileData = new SynchronizedFileData();
    final List<Thread> threads = new LinkedList<Thread>();

    @Before
    public void init () {
        for (int i = 0; i < count; i++) {
            threads.add(new Thread(new Reader(count, fileData)));
            threads.add(new Thread(new Writer(fileData)));
            Collections.shuffle(threads);// better interleaving
        }
    }

    @Test
    public void run() throws InterruptedException {
        long time = System.currentTimeMillis();
        for (Thread thread: threads) {
            thread.start();
        }
        // wait to finish all;
        for (Thread thread: threads) {
            thread.join();
        }
        long mil = System.currentTimeMillis() - time;
        System.out.println(String.format("Test for %s took %.3fs", this.getClass().getSimpleName(), (double) mil / 1000 ));
    }
}
