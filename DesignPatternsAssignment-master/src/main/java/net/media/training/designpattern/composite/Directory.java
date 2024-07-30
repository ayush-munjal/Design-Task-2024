package net.media.training.designpattern.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: joelrosario
 * Date: Jul 19, 2011
 * Time: 9:18:51 PM
 * To change this template use pre_refactoring.File | Settings | pre_refactoring.File Templates.
 */
public class Directory implements Node{
    private final String name;
    private final List<Node> nodes = new ArrayList<>();
    private Node parent;

    public String getName() {
        return name;
    }

    public Directory(String name, List<File> files, List<Directory> directories) {
        this.name = name;
        this.nodes.addAll(files);
        this.nodes.addAll(directories);

        for (Node directory : directories) {
            directory.setParent(this);
        }

        for (Node file : files) {
            file.setParent(this);
        }
    }

    public int getSize() {
        int sum = 0;

        for (Node node : nodes) {
            sum += node.getSize();
        }

        return sum;
    }

    public List<Node> getNodes(){
        return nodes;
    }

    public void setParent(Node directory) {
        this.parent = directory;
    }

    public void delete() {
        while (nodes.size() > 0) {
            Node file = nodes.get(0);
            file.getParent().remove(file);
        }
        parent.remove(this);
    }


    public void remove(Node node) {
        nodes.remove(node);
    }

    public void add(Node node) {
        nodes.add(node);
    }

    private boolean fileExists(String name, Node directoryToSearch) {
        for (Node node : directoryToSearch.getNodes()) {
            if(node instanceof File){
                if (node.getName().equals(name)) {
                    return true;
                }
            }
            else{
                if (fileExists(name, node))
                return true;
            }
        }
        return false;
    }

    public boolean fileExists(String name) {
        return fileExists(name, this);
    }

    public boolean directoryExists(String name) {
        if (this.name.equals(name))
            return true;

        for (Node node : this.getDirectories()) {
            if (node.getName().equals(name)) {
                return true;
            }
        }

        for (Node node : nodes) {
            if (node.fileExists(name)) {
                return true;
            }
        }

        return false;
    }

    public List<Node> getFiles() {
        List<Node> filesList = new ArrayList<>();
        for(Node node: nodes){
            if(node instanceof File){
                filesList.add(node);
            }
        }
        return filesList;
    }

    public List<Node> getDirectories() {
        List<Node> directoryList = new ArrayList<>();
        for(Node node: nodes){
            if(node instanceof Directory){
                directoryList.add(node);
            }
        }
        return directoryList;
    }

    public Node getParent() {
        return parent;
    }
}
