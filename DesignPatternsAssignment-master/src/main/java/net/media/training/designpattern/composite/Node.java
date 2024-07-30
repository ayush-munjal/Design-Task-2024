package net.media.training.designpattern.composite;

import java.util.List;

public interface Node {
    public void setParent(Node node);
    public String getName();
    public int getSize();
    public Node getParent();
    public void remove(Node node);
    public boolean fileExists(String name);
    public List<Node> getNodes();
}
