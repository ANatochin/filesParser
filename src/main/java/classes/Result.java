package classes;

import interfaces.ResultItem;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {
    private Map<File, List<ResultItem>> matches;

    public Result(){
        this.matches = new HashMap<>();
    }

    public void addMatches(File file, List<ResultItem> list){
        this.matches.put(file,list);
    }

    public Map<File, List<ResultItem>> getMatches(){
        return this.matches;
    }

    public boolean isEmpty(){
        boolean checkResult = (this.matches.isEmpty())? true : false;

        return checkResult;
    }


}
