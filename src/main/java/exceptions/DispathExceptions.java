package exceptions;

public class DispathExceptions extends Exception {
    public DispathExceptions(){
        super.getStackTrace();
    }

    public DispathExceptions(String msg){
        super(msg);
        super.getStackTrace();
    }
}
