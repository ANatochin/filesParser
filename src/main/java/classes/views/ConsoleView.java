package classes.views;

import interfaces.View;

public class ConsoleView implements View {

    public ConsoleView(){
    }

    @Override
    public void print(String str) {
        System.out.println(str);
    }
}
