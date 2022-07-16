package classes.items;

import interfaces.ResultItem;

public class XmlResultItem implements ResultItem {
    private String node;
    private String text;


    public XmlResultItem(String node, String text){
        this.node = node;
        this.text = text;
    }

    @Override
    public String getFormatted() {
        StringBuilder resStr = new StringBuilder();
        resStr.append(this.node).append(" -> ").append(this.text);
        return resStr.toString();
    }
}
