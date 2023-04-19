/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku.exception;

import java.util.InputMismatchException;

/**
 *
 * @author Ventsislav Peychev
 */
public class InvalidSudokuException extends InputMismatchException {
    
    public InvalidSudokuException()
    {
        super();
    }
    
    public InvalidSudokuException(String s)
    {
        super(s);
    }
    
}
