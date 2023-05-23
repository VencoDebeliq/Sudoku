package queue;

/**
 *
 * @author damyanlh
 * @param <T>
 */
public class Stack<T> {

    private Node top = new Node(null);

    public void push(T data) {
        Node toAdd = new Node(data);
        toAdd.next = top.next;
        top.next = toAdd;
    }

    public T pop() {
        T data = (T) top.next.getData();
        if (top.next.next != null) {
            top.next = top.next.next;
        } else {
            top.next = null;
        }

        return data;
    }

    public T peek() {
        return (T) top.next.getData();
    }

    public boolean isEmpty() {
        return top.next == null;
    }

    public class Node<T> {

        private T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }

}
