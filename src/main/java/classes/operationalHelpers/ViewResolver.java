package classes.operationalHelpers;

import classes.Result;
import interfaces.ResultItem;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ViewResolver {

    public ViewResolver(){
    }

    public String resolve(Result res){

        StringBuilder toView = new StringBuilder("=============\n");

        Map<File, List<ResultItem>> map = res.getMatches();

        for(Map.Entry<File, List<ResultItem>> entry: map.entrySet()){
            File key = entry.getKey();
            List<ResultItem> value = entry.getValue();

            toView.append("FILE: ").append(key.toString()).append("\n");
            toView.append("Has ").append(value.size()).append(" matches:\n").append("=============\n");

            for(ResultItem item : value){
                toView.append(item.getFormatted()).append("\n");
            }
            toView.append("=============\n").append("\n");
        }
        return toView.toString();
    }

}
