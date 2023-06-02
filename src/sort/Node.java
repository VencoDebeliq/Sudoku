/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

/**
 *
 * @author ventsislavlp
 */
public class Node <T> {
    private Node <T> left;
    private Node <T> right;
    private T value;
    
    public void setLeft(Node<T> left)
    {
        this.left = left;
    }
    public void setRight(Node<T> right)
    {
        this.right = right;
    }
    public void setValue(T value)
    {
        this.value = value;
    }

    public Node<T> getLeft()
    {
        return left;
    }
    public Node<T> getRight()
    {
        return right;
    }
    public T getValue()
    {
        return value;
    }
    
    public Node()
    {
        this(null);
    }
    
    public Node(T value)
    {
        setValue(value);
        setLeft(null);
        setRight(null);
    }
    
    public String toString()
    {
        if (getValue() == null) return "null";
        return getValue() + "";
    }
}
