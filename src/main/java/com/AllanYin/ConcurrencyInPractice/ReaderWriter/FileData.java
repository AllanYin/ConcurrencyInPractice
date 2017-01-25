package com.AllanYin.ConcurrencyInPractice.ReaderWriter;

/**
 * Created by allan on 18/01/17.
 */
public class FileData {
    private final int size = 10;
    private final String[] content;
    public static final String EMPTYSTRING = ".";

    public FileData () {
        this.content = new String[size];
        this.writeContent(EMPTYSTRING);
    }

    /**
     *
     * @return content in the fileData
     */
    public String[] read() {
        final String[] result = new String[size];
        for (int i = 0 ;i < size; i++) {
            result[i] = content[i];
        }
        return result;
    }

    /**
     * write new content into the fileData repeatedly
     * @param content
     */
    public void write(String content) {
        this.writeContent(content);
        //System.out.println("Wrote (" + content + ")");
    }

    private void writeContent (String str) {
        for (int i = 0; i < size; i ++) {
            content[i] = str;
        }
    }
}
