import classes.Dispatcher;
import exceptions.DispathExceptions;

public class Main {
    public Main(){

    }
    public static void main(String[] args) throws DispathExceptions {

//        {"text for search", "D:/folder/warAndPeace.txt"};
//        {"text for search", "D:/folder"};
//        {"text for search", "D:/folder/something.xml"};

        Dispatcher disp = new Dispatcher(args);
        disp.dispatch();

    }
}
