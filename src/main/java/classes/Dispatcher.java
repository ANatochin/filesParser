package classes;

import classes.operationalHelpers.ViewResolver;
import classes.views.ConsoleView;
import exceptions.DispathExceptions;
import interfaces.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dispatcher {
    private Config config;
    private Handler handler;
    private List<View> views;
    private ViewResolver viewResolver;

    public Dispatcher(String [] arr) {
        this.config = new Config(arr);
        this.handler = new Handler();
        this.views = new ArrayList<>();
        this.viewResolver = new ViewResolver();
    }

    public void dispatch() throws DispathExceptions {
        File dest = this.config.getDestination();
        String text = this.config.getText4Search();

        Result result = new Result();

        if(dest.isFile()){
            result.addMatches(dest,this.handler.handle(dest,text));
        } else if(dest.isDirectory()){
            List<File> list = Arrays.asList(dest.listFiles());

            for(File f : list){
                result.addMatches(f,this.handler.handle(f,text));
            }
        }

        ViewResolver vr = new ViewResolver();

        views.add(new ConsoleView());
        for (View v : views){
            v.print(vr.resolve(result));
        }
    }
}
