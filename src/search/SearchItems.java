package search;

import search.strategy.AllResults;
import search.strategy.AnyResults;
import search.strategy.NoneResults;

import java.util.*;

public class SearchItems {
    List<String> phrasesToSearch = new ArrayList<>();
    Map<String, HashSet<Integer>> orderedPhrasesToSearch = new HashMap<>();
    PrinterResult printerResult = new PrinterResult();

    SearchItems(Map<String, HashSet<Integer>> orderedData) {
        setSearchType();
        String[] itemsToSearch = getSearchItemFromUser().split(" ");
        for (String item : itemsToSearch) {
            phrasesToSearch.add(item.trim().toLowerCase());
        }
        catalogPhrasesToSearch(orderedData);
    }

    public String getSearchItemFromUser() {
        System.out.println("Enter a name or email to search all suitable people.");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void setSearchType() {
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        switch (getChoiceOfSearchTypeFromUser().toUpperCase()) {
            case "ALL":
                printerResult.setMethod(new AllResults());
                break;
            case "ANY":
                printerResult.setMethod(new AnyResults());
                break;
            case "NONE":
                printerResult.setMethod(new NoneResults());
                break;
        }
    }

    public String getChoiceOfSearchTypeFromUser() {
        Scanner in4 = new Scanner(System.in);
        return in4.nextLine();
    }

    public void catalogPhrasesToSearch(Map<String, HashSet<Integer>> orderedData) {
        for (String record : this.phrasesToSearch) {
            if (orderedData.containsKey(record)) {
                orderedPhrasesToSearch.put(record, orderedData.get(record));
            } else {
                orderedPhrasesToSearch.put(record, new HashSet<>());
            }
        }
    }
}
