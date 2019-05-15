import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Categories {

    private static List<Category> listOfCategories() {

        List<Category> tempList = new ArrayList<>();
        Scanner read = null;
        try {
            read = new Scanner(new File("src\\main\\resources\\categories.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (read.hasNextLine()) {
            String line = read.nextLine();
            String[] categoriesData = line.split(";");

            String name = categoriesData[1];
            String priority = categoriesData[2];

           Category category = new Category (name, priority);
           tempList.add(category);

        }
        return tempList;

    }
}
