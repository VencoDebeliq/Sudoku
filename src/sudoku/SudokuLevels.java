/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package sudoku;

/**
 *
 * @author Ventsislav Peychev
 */
public enum SudokuLevels
{
    EASY(36),
    MEDIUM(30),
    HARD(28),
    EXPERT(23);
    
    public final int numbers;
    
    SudokuLevels (int numbers)
    {
        this.numbers = numbers;
    }
}
