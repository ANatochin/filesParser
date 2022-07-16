package classes;

import exceptions.ConfigException;

import java.io.File;

public class Config {
    private File destination;
    private String text4Search;

    public Config(String[] arr) {
        try{
            this.parseArgs(arr);
        } catch(ConfigException e){
            System.out.println(e);
        }
    }

    public File getDestination(){
        return this.destination;
    }

    public String getText4Search(){
        return this.text4Search;
    }

    private void parseArgs(String[] arr) throws ConfigException {
        int arrSize = arr.length;

        this.text4Search = arr[arrSize-2];

        File file = new File(arr[arrSize-1]);

        if(!file.exists()){
            throw new ConfigException("FILE WITH PATH " + arr[arrSize-1] + " IS NOT FOUND");
        } else {
            this.destination = file;
        }
    }
}
