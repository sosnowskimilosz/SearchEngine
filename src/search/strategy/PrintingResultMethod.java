package search.strategy;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public interface PrintingResultMethod {

    void printResult(List<String> list, Map<String, HashSet<Integer>> orderedPhrasesToSearch);

}
