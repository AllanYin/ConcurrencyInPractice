package com.AllanYin.ConcurrencyInPractice.ReaderWriter;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by allan on 18/01/17.
 */
public class TestFileData {

    @Test
    public void testRead(){
        FileData fileData = new FileData();
        testConsistency(fileData.read());
   }

    public void testConsistency(String[] content) {
        Assert.assertTrue(content.length > 0);
        final String originalStr  = content[0];
        for (int i = 0 ; i < content.length; i++) {
            Assert.assertEquals(content[i], originalStr);
        }
    }
}
