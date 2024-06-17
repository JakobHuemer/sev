package schuli.stack;

public class CustomStack<T> {

    private Node<T> top;

    public T push( T element ) {

        var node = new Node<T>();
        node.setNext( top );
        node.setData( element );

        top = node;

        return element;
    }

    public T pop() {
        if (top == null) return null;
        var topVal = top.getData();
        top = top.getNext();

        return topVal;
    }

    public T peek() {
        return top == null ? null : top.getData();
    }

    public boolean isEmpty() {
        return top == null;
    }

}
