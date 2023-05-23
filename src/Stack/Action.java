/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package queue;

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
        this.x = x;
        this.y = y;
        setNumberArr(numberArr);
        this.isNote = isNote;
        this.type = type;
    }

    public static enum ActionType {
        ADD, DELETE, DELETE_CELL
    }

    // <editor-fold defaultstate="collapsed" desc="getters and setters">
    public void setNumberArr(boolean[] numberArr)
    {
        for (int i = 0; i < numberArr.length; i++) {
            this.numberArr[i] = numberArr[i];
        }
    }
    
    public boolean[] getNumberArr()
    {
        return numberArr;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isIsNote() {
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

}
