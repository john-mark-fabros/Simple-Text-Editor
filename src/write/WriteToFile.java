package write;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WriteToFile {

    private String filename;

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return this.filename;
    }

    public void writeToFile() {
        Scanner scan = new Scanner(System.in);

        try {
            FileWriter fileObj = new FileWriter(filename + ".txt", true);
            String input = scan.nextLine();
            fileObj.write(input);
            fileObj.close();
        } catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }

    }
}
