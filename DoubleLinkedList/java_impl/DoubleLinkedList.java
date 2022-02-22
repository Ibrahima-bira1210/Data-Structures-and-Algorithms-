public class Node2<T> {
    private T value;
    private Node2<T> next_node;
    private Node2<T> prev_node;

    public Node2(T value, Node2<T> next_node, Node2<T> prev_node) {
        this.value = value;
        this.next_node = next_node;
        this.prev_node = prev_node;
    }

    public Node2() {
    }

    public Node2(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node2<T> getNext_node() {
        return next_node;
    }

    public void setNext_node(Node2<T> next_node) {
        this.next_node = next_node;
    }

    public Node2<T> getPrev_node() {
        return prev_node;
    }

    public void setPrev_node(Node2<T> prev_node) {
        this.prev_node = prev_node;
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value  + '}';
    }
}


// double linked list

public class DoubleLinkedList<T> {
    private Node2<T> head_node;
    private Node2<T> tail_node;

    public DoubleLinkedList(Node2<T> head_node, Node2<T> tail_node) {
        this.head_node = head_node;
        this.tail_node = tail_node;
    }

    public DoubleLinkedList() {
    }

    public Node2<T> getHead_node() {
        return head_node;
    }

    public void setHead_node(Node2<T> head_node) {
        this.head_node = head_node;
    }

    public Node2<T> getTail_node() {
        return tail_node;
    }

    public void setTail_node(Node2<T> tail_node) {
        this.tail_node = tail_node;
    }

    public void add_to_head(T new_value){
        System.out.println("Add value :" + new_value + " to head!");
        Node2<T> new_node = new Node2<>(new_value);
        Node2<T> current_head = getHead_node();
        if (current_head != null){
            current_head.setPrev_node(new_node);
            new_node.setNext_node(current_head);
        }
        setHead_node(new_node);
        if (getTail_node() == null){
            setTail_node(new_node);
        }
    }

    public void add_to_tail(T new_value){
        System.out.println("Add value :" + new_value + " to tail!");
        Node2<T> new_node = new Node2<>(new_value);
        Node2<T> current_tail = getTail_node();
        if (current_tail != null){
            current_tail.setNext_node(new_node);
            new_node.setPrev_node(current_tail);
        }
        setTail_node(new_node);
        if (getHead_node() == null){
            setHead_node(new_node);
        }
    }

    public void remove_from_head(){
        System.out.println("Remove value :" + getHead_node().getValue() + " from head");
        Node2<T> removed_head = getHead_node();
        if (removed_head == null){
            return;
        }
        setHead_node(removed_head.getNext_node());
        if(getHead_node() != null){
            getHead_node().setPrev_node(null);
        }
        if(removed_head == getTail_node()){
            remove_from_tail();
        }
    }

    public void remove_from_tail(){
        System.out.println("Remove value :" + getTail_node().getValue() + " from tail");
        Node2<T> removed_tail = getTail_node();
        if (removed_tail == null){
            return;
        }
        setTail_node(removed_tail.getPrev_node());
        if(getTail_node() != null){
            getTail_node().setNext_node(null);
        }
        if(removed_tail == getHead_node()){
            remove_from_head();
        }
    }

    public void remove_by_value(T value_to_remove){
        System.out.println("remove node with value:" +value_to_remove);
        Node2<T> node_to_remove = new Node2<T>();
        Node2<T> current_node = getHead_node();
        while(current_node != null){
            if(current_node.getValue() == value_to_remove){
                node_to_remove = current_node;
                break;
            }
            current_node = current_node.getNext_node();
        }
        if (node_to_remove == null){
            return;
        }
        if(node_to_remove == getHead_node()){
            remove_from_head();
        }
        else if(node_to_remove == getTail_node()) {
            remove_from_tail();
        }
        else{
            Node2<T> nextNode = node_to_remove.getNext_node();
            Node2<T> prevNode = node_to_remove.getPrev_node();
            nextNode.setPrev_node(prevNode);
            prevNode.setNext_node(nextNode);
        }
    }

    @Override
    public String toString(){
        String str = "";
        Node2<T> currentNode = getHead_node();
        while (currentNode != null){
            if (currentNode.getValue() != null){
                str= str + currentNode.toString() + "\n";
            }
            currentNode = currentNode.getNext_node();
        }
        return str;
    }

}


// main

public class Main {

    public static void main(String[] args) {
	// write your code here
        DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();


        list.add_to_head(1);
        list.add_to_head(2);
        list.add_to_head(3);
        list.add_to_tail(4);
        list.add_to_tail(5);
        list.add_to_tail(6);


        System.out.println(list.toString());
        list.remove_from_head();
        System.out.println(list.toString());
        list.remove_from_tail();
        System.out.println(list.toString());
        list.remove_by_value(1);
        System.out.println(list.toString());

    }
}
