package stuff.mylinkedlist;

public class Node<T> {

    private Node<T> next;
    private Node<T> pev;

    T data;

    public Node() {
    }

    public Node( T data, Node<T> next, Node<T> pev ) {
        this.next = next;
        this.pev = pev;
        this.data = data;
    }


    public Node<T> getNext() {
        return next;
    }

    public void setNext( Node<T> next ) {
        this.next = next;
    }

    public Node<T> getPev() {
        return pev;
    }

    public void setPev( Node<T> pev ) {
        this.pev = pev;
    }

    public T getData() {
        return data;
    }

    public void setData( T data ) {
        this.data = data;
    }
}
