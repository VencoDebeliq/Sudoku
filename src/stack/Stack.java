package stack;

/**
 *
 * @author damyanlh
 * @param <T>
 */
public class Stack<T> {

    private Node <T> top = new Node<>(null);
    private int size = 0;
    
    public void push(T data) {
        Node toAdd = new Node(data);
        toAdd.next = top.next;
        top.next = toAdd;
        size++;
    }

    public T pop() {
        T data = (T) top.next.getData();
        if (top.next.next != null) {
            top.next = top.next.next;
        } else {
            top.next = null;
        }
        size--;
        
        return data;
    }

    public T peek() {
        return (T) top.next.getData();
    }

    public boolean isEmpty() {
        return top.next == null;
    }
    
    public int size()
    {
        return size;
    }

    
    
    @Override
    public String toString()
    {
        String ans = "";
        Node <T> curr = top.next;
        while (curr != null)
        {
            ans += curr.getData() + "\n";
            curr = curr.next;
        }
        
        return ans;
    }

}