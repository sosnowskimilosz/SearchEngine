package search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Data {
    private List<String> data = new ArrayList<>();

    Data() {
        addDataFromUser();
    }

    Data(String fileName) throws FileNotFoundException {
        loadPeopleFromFile(fileName);
    }

    private void addDataFromUser() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of people:");
        int numberRecordsToAdd = in.nextInt();
        Scanner in2 = new Scanner(System.in);
        System.out.println("Enter all people:");
        for (int i = 0; i < numberRecordsToAdd; i++) {
            data.add(in2.nextLine());
        }
    }

    private void loadPeopleFromFile(String fileName) throws FileNotFoundException {
        File fileWithData = new File(fileName);
        Scanner in3 = new Scanner(fileWithData);
        while (in3.hasNext()) {
            data.add(in3.nextLine());
        }
        in3.close();
    }

    public void showListOfRecord() {
        for (String record : data) {
            System.out.println(record);
        }
    }

    public List<String> getData() {
        return data;
    }
}
