package activities;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Activity14 {

    public static void main(String[] args) {
        try{
            File file = new File("src/main/resources/testFile.txt");
            file.createNewFile();
            FileWriter fw = new FileWriter(file, false);

            fw.write("Asha\n");
            fw.write("Anna\n");
            fw.write("Thomas");
            fw.close();

            File fileUtil = FileUtils.getFile(file);
            System.out.println("Data in the file : " + FileUtils.readFileToString(fileUtil, "UTF-8"));

            File destDir = new File("src/main/resources/newDirectory/");
            //copy the file to another destination
            FileUtils.copyFileToDirectory(file, destDir);

            File newFile = FileUtils.getFile(destDir, "testFile.txt");
            System.out.println("Data from the new file : " + FileUtils.readFileToString(newFile, "UTF-8"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
