package search;

import search.strategy.PrintingResultMethod;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class PrinterResult {

    PrintingResultMethod method;

    public void setMethod(PrintingResultMethod method) {
        this.method = method;
    }

    public void print(List<String> list, Map<String, HashSet<Integer>> orderedPhrasesToSearch) {
        this.method.printResult(list, orderedPhrasesToSearch);
    }


}
