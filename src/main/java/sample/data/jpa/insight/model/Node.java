package sample.data.jpa.insight.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private String path;
    private Node parentNode;
    private List<Node> children;
    private long timeTaken;

    public Node(String path, Node parentNode) {
        this.path = path;
        this.parentNode = parentNode;
        this.children = new ArrayList<>();
    }


    public void addChild(Node node) {
        children.add(node);
    }

    public void setTimeTaken(long timeTaken) {
        this.timeTaken = timeTaken;
    }

    public long getTimeTaken() {
        return timeTaken;
    }

    @JsonIgnore
    public Node getParentNode() {
        return parentNode;
    }

    public String getPath() {
        return path;
    }

    public List<Node> getChildren() {
        return children;
    }
}
