package simple;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class priya {
    public static void main(String[] args) {
        File file = new File("testFile.txt");

        try {
            // Create the file
            if (file.createNewFile()) {
                System.out.println("File created: ");
            } else {
                System.out.println("File already exists.");
            }

            // Restrict permissions to simulate write error
            if (file.setReadOnly()) {
                System.out.println("File permissions changed to read-only.");
            } else {
                System.out.println("Failed to change file permissions.");
            }

            // Attempt to write to the file
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("This will fail due to write restrictions.");
            } catch (IOException e) {
                System.out.println("Caught IOException: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}