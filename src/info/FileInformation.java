package info;

import java.io.File;

public class FileInformation {

    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void checkFileInformation() {
        File file = new File(filename +".txt");
        if(file.exists()) {
            // check all necessary information
            System.out.println("Filename: "+ file.getName());
            System.out.println("Absolute Path: "+ file.getAbsolutePath());
            System.out.println("Write: "+ file.canWrite());
            System.out.println("Read: "+ file.canRead());
            System.out.println("File Size:"+ file.length());
        } else {
            System.out.println("File does not exist...");
        }
    }
}
