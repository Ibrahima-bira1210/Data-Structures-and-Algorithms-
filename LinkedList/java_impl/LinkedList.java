public class Node<T>{
    private T value;
    private Node next_node;

    public Node() {
    }

    public Node(T value, Node next_node) {
        this.value = value;
        this.next_node = next_node;
    }

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node getNext_node() {
        return next_node;
    }

    public void setNext_node(Node next_node) {
        this.next_node = next_node;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value  + '}';
    }
}



//Linked List


public class LinkedList<T>{
    private Node<T> headNode;

    public LinkedList(Node<T> headNode) {
        this.headNode = headNode;
    }

    public LinkedList() {
    }

    public Node<T> getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node<T> headNode) {
        this.headNode = headNode;
    }

    public void insertBeginning(T value){
        Node<T> newNode = new Node<T>(value);
        newNode.setNext_node(getHeadNode());
        setHeadNode(newNode);
    }


    @Override
    public String toString(){
        String str = "";
        Node<T> currentNode = getHeadNode();
        while (currentNode != null){
            if (currentNode.getValue() != null){
                str= str + currentNode.toString() + "\n";
            }
            currentNode = currentNode.getNext_node();
        }
        return str;
    }

    public void removeNode(T value_to_remove) {
        Node<T> currentNode = getHeadNode();
        if(currentNode.getValue() == value_to_remove){
            setHeadNode(currentNode.getNext_node());
        }
        else{
            while(currentNode != null){
                Node<T> nextNode = currentNode.getNext_node();
                if(nextNode.getValue() == value_to_remove){
                    currentNode.setNext_node(nextNode.getNext_node());
                    currentNode = null;
                }
                else{
                    currentNode = nextNode;
                }
            }
        }
    }

    public void swapNode(T val1, T val2){
        System.out.println("swapping " + val1 + " to " + val2);
        Node<T> node1Prev = new Node<T>();
        Node<T> node2Prev = new Node<T>();
        Node<T> node1 = getHeadNode();
        Node<T> node2 = getHeadNode();

        if (val1 == val2){
            System.out.println("Elements are same no swap needed ");
            return;
        }

        while (node1 != null){
            if (node1.getValue() == val1){
                break;
            }
            node1Prev = node1;
            node1 = node1.getNext_node();
        }

        while (node2 != null){
            if (node2.getValue() == val2){
                break;
            }
            node2Prev = node2;
            node2 = node2.getNext_node();
        }

        if(node1 == null || node2 == null){
            System.out.println("Swap not possible - one or more element is not in the list");
            return;
        }
        if (node1Prev == null ){
            setHeadNode(node2);
        }
        else{
            node1Prev.setNext_node(node2);
        }
        if (node2Prev == null ){
            setHeadNode(node1);
        }
        else{
            node2Prev.setNext_node(node1);
        }

        Node<T> temp = node1.getNext_node();
        node1.setNext_node(node2.getNext_node());
        node2.setNext_node(temp);
    }


}


// Main Class

public class Main {

    public static void main(String[] args) {
        // write your code here
        LinkedList<Integer> list = new LinkedList<Integer>();


        list.insertBeginning(1);
        list.insertBeginning(2);
        list.insertBeginning(3);
        list.insertBeginning(4);

        System.out.println(list.toString());
        list.removeNode(2);
        System.out.println(list.toString());


        list.swapNode(3,1);

        System.out.println(list.toString());
    }
}