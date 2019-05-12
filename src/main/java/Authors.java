import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Authors {

    private static List<Authors> listOfAuthors() {

        List<Authors> tempList = new ArrayList<>();
        Scanner read = null;
        try {
            read = new Scanner(new File("src\\main\\resources\\authors.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] authorsData = line.split(";");
            String name = authorsData[1];
            String age = authorsData[2];

            Author author = new Author(name, age);

        }
        return tempList;

    }
}
