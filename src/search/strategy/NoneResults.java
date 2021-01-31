package search.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class NoneResults implements PrintingResultMethod {

    Set<Integer> set = new HashSet<>();

    @Override
    public void printResult(List<String> list, Map<String, HashSet<Integer>> orderedPhrasesToSearch) {
        for (HashSet<Integer> x : orderedPhrasesToSearch.values()) {
            this.set.addAll(x);
        }
        print(list);
    }

    void print(List<String> list) {
        if (set.size() == list.size()) {
            System.out.println("No matching people found.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (!set.contains(i)) {
                    System.out.println(list.get(i));
                }
            }
        }
    }
}
