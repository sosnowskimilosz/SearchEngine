package search.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnyResults implements PrintingResultMethod {

    Set<Integer> set = new HashSet<>();

    @Override
    public void printResult(List<String> list, Map<String, HashSet<Integer>> orderedPhrasesToSearch) {

        for (HashSet<Integer> x : orderedPhrasesToSearch.values()) {
            this.set.addAll(x);
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
