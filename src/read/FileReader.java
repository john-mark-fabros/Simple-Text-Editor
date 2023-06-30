package read;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void readFile() {
        try {
            File fileObj = new File(filename +".txt");
            Scanner scan = new Scanner(fileObj);
            while(scan.hasNextLine()) {
                String read = scan.nextLine();
                System.out.println(read);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
        }
    }
}
