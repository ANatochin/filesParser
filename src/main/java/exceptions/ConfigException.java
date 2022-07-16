package exceptions;

public class ConfigException extends Exception{

    public ConfigException(){
        super.getStackTrace();
    }

    public ConfigException(String msg){
        super(msg);
        super.getStackTrace();
    }
}
