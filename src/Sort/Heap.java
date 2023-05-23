/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Sort;

import java.util.*;

/**
 *
 * @author ventsislavlp
 */
public class Heap <T extends Integer>
{
    private Node <T> tree = new Node<>();
    private int size = 0;
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    public void add(T value)
    {
        addPerform(value, tree);
        size++;
    }
    
    private void addPerform(T value, Node <T> curr)
    {
        if (curr == null || curr.getValue() == null)
        {
            if (curr.getValue() == null)
            {
                curr.setLeft(new Node<>());
                curr.setRight(new Node<>());
            }
            curr.setValue(value);
            return;
        }
        
        
        Node <T> next = pickAWay(curr);
        addPerform(value, next);
        if (next.getValue() > curr.getValue())
        {
            T cp = next.getValue();
            next.setValue(curr.getValue());
            curr.setValue(cp);
        }
    }
    
    public T poll()
    {
        if (isEmpty()) return null;
        T ans = tree.getValue();
        popPerform(tree);
        size--;
        return ans;
    }
    
    private void popPerform(Node <T> curr)
    {
        if (curr.getLeft().getValue() == null && curr.getRight().getValue() == null) 
        {
            curr.setValue(null);
            return;
        }
        if (curr.getLeft().getValue() == null)
        {
            curr.setValue(curr.getRight().getValue());
            popPerform(curr.getRight());
            return;
        }
        if (curr.getRight().getValue() == null)
        {
            curr.setValue(curr.getLeft().getValue());
            popPerform(curr.getLeft());
            return;
        }
        Node <T> max = 
                (curr.getLeft().getValue() > curr.getRight().getValue()
                ? curr.getLeft() 
                : curr.getRight());
        curr.setValue(max.getValue());
        popPerform(max);
    }
    
    private Node <T> pickAWay(Node <T> p)
    {
        Random r = new Random();
        boolean leftOrRight = r.nextBoolean();
        
        if (p.getLeft().getValue() == null && p.getRight().getValue() != null) return p.getLeft();
        if (p.getRight().getValue() == null && p.getLeft().getValue() != null) return p.getRight();
        return leftOrRight ? p.getLeft() : p.getRight();
    }
    
    public static <P extends Integer> Object[] sorted(Heap <P> h)
    {
        Object arr[] = new Object[h.size()];
        int i = 0;
        while (!h.isEmpty())
        {
            arr[i++] = h.poll();
        }
        return arr;
    }
    
    private String print(Node <T> root)
    {
        String ans = "";
        List<List<String>> lines = new ArrayList<List<String>>();

        List<Node <T>> level = new ArrayList<Node <T>>();
        List<Node <T>> next = new ArrayList<Node <T>>();

        level.add(root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<String>();

            nn = 0;

            for (Node <T> n : level) {
                if (n == null) {
                    line.add(null);

                    next.add(null);
                    next.add(null);
                } else {
                    String aa = n.getValue() + "";
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;
                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<Node <T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perpiece = lines.get(lines.size() - 1).size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perpiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '┴' : '┘';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '└';
                        }
                    }
                    ans += c;

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perpiece - 1; k++) {
                            ans += " ";
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            ans += j % 2 == 0 ? " " : "─";
                        }
                        ans += j % 2 == 0 ? "┌" : "┐";
                        for (int k = 0; k < hpw; k++) {
                            ans += j % 2 == 0 ? "─" : " ";
                        }
                    }
                }
                ans += "\n";
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    ans += " ";
                }
                ans += f;
                for (int k = 0; k < gap2; k++) {
                    ans += " ";
                }
            }
            ans += "\n";

            perpiece /= 2;
        }
        return ans;
    }
    
    public String toString()
    {
        return print(tree);
    }
    
}
