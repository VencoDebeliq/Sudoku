/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

/**
 *
 * @author Ventsislav Peychev
 */
public class Pair <F, S> extends Object
{
    private F first;
    private S second;

    public F getFirst()
    {
        return first;
    }
    
    public void setFirst(F first)
    {
        this.first = first;
    }
    
    public S getSecond()
    {
        return second;
    }

    public void setSecond(S second)
    {
        this.second = second;
    }
    
    public Pair(F first, S second)
    {
        setFirst(first);
        setSecond(second);
    }
    
    public Pair()
    {}
    
}
