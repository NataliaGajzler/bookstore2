import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;

public class ListOfBooks {

    private static List<String> booksList() {
        List<String> tempList = new ArrayList<>();
        Scanner read = null;
        try {
            read = new Scanner(new File("src\\main\\resources\\books.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(read.hasNextLine()) {
            String line = read.nextLine();
            tempList.add(line);
        }
        return tempList;
    }

    void readAllLines() {
        System.out.println(booksList());
    }



}
