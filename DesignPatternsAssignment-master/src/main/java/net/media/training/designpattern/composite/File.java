package net.media.training.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:04 PM
 * To change this template use pre_refactoring.File | Settings | pre_refactoring.File Templates.
 */
public class File implements Node{
    private final String name;
    private int size;
    private Node parent;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public Node getParent() {
        return parent;
    }

    public void remove(Node node){
        node = null;
        System.gc();
    }

    public List<Node> getNodes(){
        List<Node> nodeList = new ArrayList<>();
        nodeList.add(this);
        return nodeList;
    }

    public boolean fileExists(String name){
        return name == this.name;
    }
}
