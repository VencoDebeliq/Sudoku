/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import sudoku.SudokuLevels;


/**
 *
 * @author Ventsislav Peychev
 */
public class User
{
    private String name;
    private int score;
    private SudokuLevels difficulty;

    public void setName(String name)
    {
        this.name = name;
    }

    public void setScore(int score)
    {
        if (score < 0) return;
        this.score = score;
    }

    public void setDifficulty(SudokuLevels difficulty)
    {
        this.difficulty = difficulty;
    }
    
    public String getName()
    {
        return name;
    }

    public int getScore()
    {
        return score;
    }
    
    public SudokuLevels getDifficulty()
    {
        return difficulty;
    }
    
    public User()
    {
        this("", 0);
    }
    
    public User(String name)
    {
        this(name, 0);
    }
    
    public User(String name, int score)
    {
        setName(name);
        setScore(score);
    }
    
    @Override
    public String toString()
    {
        return String.format("Name: %s Score: %d", getName(), getScore());
    }
}
