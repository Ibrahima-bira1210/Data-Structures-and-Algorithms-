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


// queue
public class Queue<T> {
    private Node<T> head;
    private Node<T> tail;
    private int maxSize = 0 ;
    private int size= 0 ;

    public Queue(Node<T> head, Node<T> tail, int maxSize, int size) {
        this.head = head;
        this.tail = tail;
        this.maxSize = maxSize;
        this.size = size;
    }

    public Queue() {
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean hasSpace(){
        if(getMaxSize() == 0){
            return true;
        }else{
            return getMaxSize() > getSize();
        }
    }

    public boolean isEmpty(){
        return getSize() == 0 ;
    }

    public void enqueue(T value){
        if(hasSpace()){
            Node<T> item_to_add = new Node<T>(value);
            System.out.println("adding " + value + " to the queue");
            if(isEmpty()){
                setHead(item_to_add);
                setTail(item_to_add);
            }
            else{
                getTail().setNext_node(item_to_add);
                setTail(item_to_add);
            }
            setSize(getSize() + 1);
        }
        else {
            System.out.printf("Sorry, no more room!");
        }
    }

    public void dequeue(){
        if(getSize() > 0){
            Node<T> item_to_remove = getHead();
            System.out.println(item_to_remove.getValue() + " is served!");
            if(getSize() == 1 ){
                setTail(null);
                setHead(null);
            }
            else{
                setHead(getHead().getNext_node());
            }
            setSize(getSize()-1);
        }
        else{
            System.out.println("The queue is totally empty!");
        }
    }

    public void peek(){
        if(getSize() > 0){
            System.out.println(getHead().getValue());
        }
        else{
            System.out.println("No orders waiting!");
        }
    }
}

//main

public class Main {

    public static void main(String[] args) {
	// write your code here
        Queue<String> deli_line = new Queue<String>(10);

        deli_line.enqueue("egg and cheese on a roll");
        deli_line.enqueue("bacon, egg, and cheese on a roll");
        deli_line.enqueue("toasted sesame bagel with butter and jelly");
        deli_line.enqueue("toasted roll with butter");
        deli_line.enqueue("bacon, egg, and cheese on a plain bagel");
        deli_line.enqueue("two fried eggs with home fries and ketchup");
        deli_line.enqueue("egg and cheese on a roll with jalapeos");
        deli_line.enqueue("plain bagel with plain cream cheese");
        deli_line.enqueue("blueberry muffin toasted with butter");
        deli_line.enqueue("bacon, egg, and cheese on a roll");


        deli_line.enqueue("western omelet with home fries");

        System.out.println("------------\nOur first order will be ");
        deli_line.peek();
        System.out.println("------------\nNow serving...\n------------");
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();
        deli_line.dequeue();

        deli_line.dequeue();


    }
}
