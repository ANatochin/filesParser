package classes.parsers;

import abstractClasses.AbstractParser;
import classes.operationalHelpers.FileReader;
import classes.items.SimpleResultItem;
import interfaces.ResultItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TxtParser extends AbstractParser {
    private FileReader fileReader;

    public TxtParser(List<String> list){
        super(list);
        this.fileReader = new FileReader();
    }

    public List<ResultItem> parse(File file, String str){
        List<String> readerResult = this.fileReader.readLines(file);

        List<ResultItem> resultsList = new ArrayList<>();

        for(int i = 0; i< readerResult.size();i++){
            if (readerResult.get(i).equals(str)){
                SimpleResultItem simpleRes = new SimpleResultItem(i+1,readerResult.get(i));
                resultsList.add(simpleRes);
            }
        }

        return resultsList;
    }

    @Override
    public String toString(){
        return "txtParser supports " + this.getSupportedExtensions().toString();
    }

}
