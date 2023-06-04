/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import screens.EndScreen;
import screens.Game;
import sudoku.SudokuLevels;

/**
 *
 * @author Ventsislav Peychev
 */
public class Main
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        new EndScreen(SudokuLevels.EASY, 0, 0).setVisible(true);
    }
}
