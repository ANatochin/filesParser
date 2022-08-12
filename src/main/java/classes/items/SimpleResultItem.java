package classes.items;

import interfaces.ResultItem;

public class SimpleResultItem implements ResultItem {
    private String line;
    private int lineNumber;

    public SimpleResultItem(int number, String str){
        this.line = str;
        this.lineNumber = number;
    }

    @Override
    public String getFormatted() {
        StringBuilder resStr = new StringBuilder();
        resStr.append(lineNumber).append(" -> ").append(line);
        return resStr.toString();
    }
}
