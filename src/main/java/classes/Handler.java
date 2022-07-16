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
    }

    public List<ResultItem> handle(File file, String str){

        this.parsers.add(new TxtParser(List.of("txt")));
        this.parsers.add(new XmlParser(List.of("xml")));

        List<ResultItem> result = new ArrayList<>();

        String [] pathParts = file.toString().split("\\.");

//        System.out.println("=========pathParts=======");
//        System.out.println(Arrays.toString(pathParts));

        for(Parser p : parsers){
            for(String pathPart : pathParts){
                if(p.isSupportFile(pathPart)){
                    result = p.parse(file,str);
                }
            }
        }
        return result;
    }
}
