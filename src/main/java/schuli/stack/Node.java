package schuli.stack;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node( T data, schuli.stack.Node<T> next ) {
        this.data = data;
        this.next = next;
    }

    public Node() {

    }

    public T getData() {
        return data;
    }

    public void setData( T data ) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext( Node<T> next ) {
        this.next = next;
    }
}
