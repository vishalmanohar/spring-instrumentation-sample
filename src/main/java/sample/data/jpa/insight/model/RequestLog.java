package sample.data.jpa.insight.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestLog {
    private String path;
    private LocalDateTime dateTime;
    private Node rootNode;
    private Node currentNode;

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public RequestLog(String path) {
        this.dateTime = LocalDateTime.now();
        this.path = path;
        this.rootNode = this.currentNode = new Node(path, null);
    }

    public Node startNode(String path) {
        Node node = new Node(path, currentNode);
        if (rootNode == null) {
            rootNode = node;
        }
        currentNode.addChild(node);
        currentNode = node;
        return node;
    }

    public void endNode(long totalTimeMillis) {
        currentNode.setTimeTaken(totalTimeMillis);
        currentNode = currentNode.getParentNode();
    }

    public String getPath() {
        return path;
    }

    public String getDateTime() {
        return formatter.format(dateTime);
    }

    public Node getRootNode() {
        return rootNode;
    }

    @JsonIgnore
    public Node getCurrentNode() {
        return currentNode;
    }
}
