package search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class OrderedDataFromList {

    Map<String, HashSet<Integer>> orderedData = new HashMap<>();

    OrderedDataFromList(List<String> data) {
        makeMapFromList(data);
    }

    public void makeMapFromList(List<String> people) {
        for (int i = 0; i < people.size(); i++) {
            String[] arrayFromLine = people.get(i).split(" ");
            for (int j = 0; j < arrayFromLine.length; j++) {
                if (orderedData.containsKey(arrayFromLine[j].toLowerCase())) {
                    orderedData.get(arrayFromLine[j].toLowerCase()).add(i);
                } else {
                    orderedData.put(arrayFromLine[j].toLowerCase(), new HashSet<>());
                    orderedData.get(arrayFromLine[j].toLowerCase()).add(i);
                }
            }
        }
    }

    public Map<String, HashSet<Integer>> getOrderedData() {
        return orderedData;
    }
}
