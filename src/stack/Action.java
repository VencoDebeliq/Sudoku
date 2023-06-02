/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stack;

/**
 *
 * @author Damyan
 */
public class Action {

    private int x, y;
    private boolean[] numberArr = new boolean[10];
    private boolean isNote;
    private ActionType type;

    public Action(int x, int y, boolean[] numberArr, boolean isNote, ActionType type) {
        setX(x);
        setY(y);
        setNumberArr(numberArr);
        setIsNote(isNote);
        setType(type);
    }
    
    public Action(int x, int y, boolean isNote, ActionType type) {
        setX(x);
        setY(y);
        setIsNote(isNote);
        setType(type);
    }
    
    public Action(int x, int y, int ind, boolean value, boolean isNote, ActionType type) {
        setX(x);
        setY(y);
        setNumber(ind, value);
        setIsNote(isNote);
        setType(type);
    }
    
    public Action()
    {
        this(-1, -1, new boolean[10], false, null);
    }

    public static enum ActionType {
        ADD, DELETE_NUMBER, DELETE_CELL
    }

    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    public void setNumberArr(boolean[] numberArr)
    {
        if (numberArr.length != 10) return;
        for (int i = 0; i < numberArr.length; i++) {
            this.numberArr[i] = numberArr[i];
        }
    }
    
    public void setNumber(int ind, boolean value)
    {
        if (ind < 0 || ind > 9) return;
        numberArr[ind] = value;
    }
    
    public boolean[] getNumberArr()
    {
        return numberArr;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        if (x < 0) return;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if (y < 0) return;
        this.y = y;
    }
    
    public void setPosition(int x, int y)
    {
        if (x < 0 || y < 0) return;
        this.x = x;
        this.y = y;
    }

    public boolean isNote() {
        return isNote;
    }

    public void setIsNote(boolean isNote) {
        this.isNote = isNote;
    }

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }
    // </editor-fold>

    @Override
    public String toString()
    {
        String array = "[";
        int i = 0;
        for (boolean b : getNumberArr())
        {
            array += i++ + ": " + (b ? "T" : "F") + ", ";
        }
        array += "]";
        return String.format("Action type:%s\nPosition: %d, %d\nIs note: %b\nNumber array: %s",
                this.type == ActionType.ADD ? "ADD" : this.type == ActionType.DELETE_CELL ? "DELETE_CELL" : "DELETE_NUMBER",
                getX(), getY(), isNote(), array);
    }
}
