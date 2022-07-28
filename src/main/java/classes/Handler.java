package classes;

import classes.parsers.TxtParser;
import classes.parsers.XmlParser;
import interfaces.Parser;
import interfaces.ResultItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Handler {
    private List<Parser> parsers;

    public Handler(){
        this.parsers = new ArrayList<>();
        this.parsers.add(new TxtParser(List.of("txt")));
        this.parsers.add(new XmlParser(List.of("xml")));
    }

    public List<ResultItem> handle(File file, String str){

        List<ResultItem> result = new ArrayList<>();

        for(Parser p : parsers){

            if(p.isSupportFile(file.toString())){
                result = p.parse(file,str);

            }
        }
        return result;
    }
}

/*
        String [] pathParts = file.toString().split("\\.");
        for(Parser p : parsers){
            for(String pathPart : pathParts){
                if(p.isSupportFile(pathPart)){
                    result = p.parse(file,str);
                }
            }
        }
 */
