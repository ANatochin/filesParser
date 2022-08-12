package classes.parsers;

import abstractClasses.AbstractParser;
import classes.items.XmlResultItem;
import interfaces.ResultItem;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlParser extends AbstractParser {

    public XmlParser(List<String> list) {
        super(list);
    }

    public List<ResultItem> parse(File file, String str){

        List<ResultItem> list = new ArrayList<>();

        try{

            DocumentBuilderFactory docBuilderFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFact.newDocumentBuilder();
            Document document = docBuilder.parse(file); // creating DOM tree of document

            Node rootElem = document.getDocumentElement(); // get root element of the document

            NodeList nodes = rootElem.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                Node node = nodes.item(i);

                if(node.getNodeType() != Node.TEXT_NODE){
                    NodeList nodesInternal = node.getChildNodes();

                    for (int j = 0; j < nodesInternal.getLength(); j++) {
                        Node internalNode = nodesInternal.item(j);

                        if(internalNode.getNodeType() != Node.TEXT_NODE){
                            if(internalNode.getChildNodes().item(0).getTextContent().contains(str)){

                                list.add(new XmlResultItem(internalNode.getNodeName(),internalNode.getChildNodes().item(0).getTextContent()));

                            }
                        }
                    }
                }
            }
        } catch (javax.xml.parsers.ParserConfigurationException e){
            throw new RuntimeException();
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list;
    }
}
