public class Node {
    private string value;
    private Node link_node;

    public Node(string value, Node link_node) {
        this.value = value;
        this.link_node = link_node;
    }

    public Node(string value) {
        this.value = value;
    }

    public Node() {
    }

    public string getValue() {
        return value;
    }

    public void setValue(string value) {
        this.value = value;
    }

    public Node getLink_node() {
        return link_node;
    }

    public void setLink_node(Node link_node) {
        this.link_node = link_node;
    }
}