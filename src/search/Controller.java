package search;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Controller {

    String fileName = "noFile";
    Data data;
    OrderedDataFromList orderedDataFromList;
    SearchItems searchItems;
    boolean isAppTurnOn = true;

    Controller(String[] args) throws FileNotFoundException {
        getFileNameFromArgs(args);
        collectData();
        collectDataToMap(data.getData());
        controllByMenu();
    }

    public void getFileNameFromArgs(String[] tableFromConsole) {
        for (int i = 0; i < tableFromConsole.length; i++) {
            if ("--data".equals(tableFromConsole[i])) {
                this.fileName = tableFromConsole[i + 1];
            }
        }
    }

    public void collectData() throws FileNotFoundException {
        if ("noFile".equals(this.fileName)) {
            data = new Data();
        } else {
            data = new Data(fileName);
        }
    }

    public void collectDataToMap(List<String> list) {
        orderedDataFromList = new OrderedDataFromList(list);
    }

    public void controllByMenu() {
        while (isAppTurnOn) {
            showMenu();
            switch (getChoiceFromUser()) {
                case "1":
                    searchItems = new SearchItems(orderedDataFromList.getOrderedData());
                    searchItems.printerResult.print(data.getData(), searchItems.orderedPhrasesToSearch);
                    break;
                case "2":
                    data.showListOfRecord();
                    break;
                case "0":
                    isAppTurnOn = false;
                    System.out.println("\nBye!");
                    break;
                default:
                    System.out.println("\nIncorrect option! Try again.!");
                    break;
            }
        }
    }

    public void showMenu() {
        System.out.println("\n=== Menu ===");
        System.out.println("1. Find a person");
        System.out.println("2. Print all people");
        System.out.println("0. Exit");
    }

    public String getChoiceFromUser() {
        Scanner in4 = new Scanner(System.in);
        return in4.nextLine();
    }
}
