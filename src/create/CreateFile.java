package create;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void createFile() {
        try{
            /*
            * for learning purpose this will create a text file
            * */
            File file = new File(this.filename +".txt");

            if(file.createNewFile()) {
                System.out.println("File create: " + this.filename);
            } else {
                System.out.println(this.filename + " already exist");
            }
        } catch(IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

}
