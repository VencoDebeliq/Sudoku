/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;


/**
 *
 * @author Ventsislav Peychev
 */
public abstract class Data {
    private String name;
    private int score;

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        if (score < 0) return;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
    
    public Data()
    {
        this("", 0);
    }
    
    public Data(String name, int score)
    {
        setName(name);
        setScore(score);
    }
    
    public abstract void collectData();
    
    public abstract void editData();
    
    @Override
    public String toString()
    {
        return String.format("Name: %s Score: %d", getName(), getScore());
    }
}
