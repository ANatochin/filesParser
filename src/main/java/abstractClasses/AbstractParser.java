package abstractClasses;

import interfaces.Parser;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractParser implements Parser {
    private List<String> supportedExtensions;

    public AbstractParser(List<String>list){
        this.supportedExtensions = list;
    }

    public List<String> getSupportedExtensions(){
        return this.supportedExtensions;
    }

    public boolean isSupportFile(String str){
        for (String extension : this.getSupportedExtensions()){
            if(str.equals(extension)){
                return true;
            }
        }
        return false;
    }

}
