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


public class Stack<T> {
    private int limit=1000;
    private int size=0;
    private Node<T> top_item;

    public Stack(int limit) {
        this.limit = limit;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> getTop_item() {
        return top_item;
    }

    public void setTop_item(Node<T> top_item) {
        this.top_item = top_item;
    }

    public boolean is_empty(){
        return getSize() == 0;
    }

    public boolean has_space() {
        return getLimit() > getSize();
    }

    public void peek(){
        if(is_empty()){
            System.out.println("Nothing to see here");
        }
        else{
            System.out.println(getTop_item().getValue());
        }
    }

    public void push(T value){
        if(has_space()){
            Node<T> item = new Node<T>(value);
            item.setNext_node(getTop_item());
            setTop_item(item);
            setSize(getSize() + 1);
            System.out.println("Adding {} to the stack!" + value);
        }
        else{
            System.out.println("This stack is full no room for :"+ value);
        }
    }

    public void pop(){
        if(is_empty()){
            System.out.println("This Stack is totally empty");
        }
        else{
            Node<T> item_to_remove = getTop_item();
            setTop_item(item_to_remove.getNext_node());
            setSize(getSize()+1);
            System.out.println("Delivering" + item_to_remove.getValue());
        }
    }

}
