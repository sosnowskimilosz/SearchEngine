package search.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AllResults implements PrintingResultMethod {

    Set<Integer> set = new HashSet<>();

    @Override
    public void printResult(List<String> list, Map<String, HashSet<Integer>> orderedPhrasesToSearch) {
        for (int i = 0; i < list.size(); i++) {
            this.set.add(i);
        }
        for (HashSet<Integer> x : orderedPhrasesToSearch.values()) {
            this.set.retainAll(x);
        }
        print(list);
    }

    void print(List<String> list) {
        if (!set.isEmpty()) {
            for (Integer result : set) {
                System.out.println(list.get(result));
            }
        } else {
            System.out.println("No matching people found.");
        }
    }
}
