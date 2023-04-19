/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku;

import java.util.ArrayList;
import java.util.Random;
import sudoku.exception.InvalidSudokuException;
import java.util.Scanner;

/**
 *
 * @author Ventsislav Peychev
 */

public class Sudoku
{
    public static final int GRID_SIZE = 9;
    private SudokuLevels level;
    
    private int[][] grid = new int[GRID_SIZE][GRID_SIZE];
    
    public void setGrid(int grid[][])
    {
        if (grid.length != GRID_SIZE || grid[0].length != GRID_SIZE) return;
        
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            for (int j = 0; j < GRID_SIZE; ++j)
            {
                this.grid[i][j] = grid[i][j];
            }
        }
    }
    
    public int[][] getGrid()
    {
        return grid;
    }
    
    public int getNumberAt(int i, int j)
    {
        if (i >= 0 && i < GRID_SIZE && j >= 0 && j < GRID_SIZE)
            return grid[i][j];
        else
            return -1;
    }
    
    public void setNumberAt(int i, int j, int value)
    {
        if (i >= 0 && i < GRID_SIZE && j >= 0 && j < GRID_SIZE)
            grid[i][j] = value;
    }
    
    public void setLevel(SudokuLevels level)
    {
        this.level = level;
    }
    
    public SudokuLevels getLevel()
    {
        return level;
    }
    
    public Sudoku()
    {
        setLevel(SudokuLevels.EASY);
        generateGrid();
    }
    
    public Sudoku(SudokuLevels level)
    {
        setLevel(level);
        generateGrid();
    }
    
    public Sudoku(int[][] grid)
    {
        setLevel(SudokuLevels.EASY);
        setGrid(grid);
    }
    
    public Sudoku(int[][] grid, SudokuLevels level)
    {
        setGrid(grid);
        setLevel(level);
    }
    
    public Sudoku(Sudoku obj)
    {
        this(obj.getGrid(), obj.getLevel());
    }
    
    public void inputGrid()
    {
        grid = getInputGrid();
    }
    
    public static int[][] getInputGrid()
    {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            for (int j = 0; j < GRID_SIZE; ++j)
            {
                String a;
                a = in.next();
                try
                {
                    grid[i][j] = Integer.parseInt(a);
                }
                catch (NumberFormatException e)
                {
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }
    
    public void generateGrid()
    {
        grid = getGeneratedGrid(level);
    }
    
    public static int[][] getGeneratedGrid(SudokuLevels level)
    {
        int[][] grid = new int[GRID_SIZE][GRID_SIZE];
        
        Random rand = new Random();
        
        int upperbound = GRID_SIZE;
        
        for (int k = 0; k < level.numbers; ++k)
        {
            int i, j;
            do
            {
                i = rand.nextInt(upperbound);
                j = rand.nextInt(upperbound);
                if (grid[i][j] == 0)
                {
                    ArrayList <Integer> list = new ArrayList<>();
                    
                    for (int num = 1; num <= 9; ++num)
                    {
                        if (isPlaceable(grid, j, i, num))
                        {
                            list.add(num);
                        }
                    }
                    
                    if (!list.isEmpty())
                    {
                        grid[i][j] = list.get(rand.nextInt(list.size()));
                    }
                }
            }
            while (grid[i][j] == 0);
        }
        if (numberOfSolutions(grid) == 0) return getGeneratedGrid(level);
        return grid;
    }
    
    private static boolean isPlaceableOnRow(int[][] grid, int row, int number)
    {
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            if (grid[row][i] == number) return false;
        }
        return true;
    }
    
    private static boolean isPlaceableOnColumn(int[][] grid, int column, int number)
    {
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            if (grid[i][column] == number) return false;
        }
        return true;
    }
    
    private static boolean isPlaceableInTable(int[][] grid, int column, int row, int number)
    {
        int baseRow = row - row % 3;
        int baseColumn = column - column % 3;
        for (int i = baseRow; i < baseRow + 3; ++i)
        {
            for (int j = baseColumn; j < baseColumn + 3; ++j)
            {
                if (grid[i][j] == number) return false;
            }
        }
        return true;
    }
    
    public static boolean isPlaceable(int[][] grid, int column, int row, int number)
    {
        return isPlaceableInTable(grid, column, row, number) &&
                isPlaceableOnColumn(grid, column, number) &&
                isPlaceableOnRow(grid, row, number);
    }
    
    private static boolean solveTry(int[][] grid)
    {
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            for (int j = 0; j < GRID_SIZE; ++j)
            {
                if (grid[i][j] == 0)
                {
                    for (int number = 1; number <= 9; ++number)
                    {
                        if (isPlaceable(grid, j, i, number))
                        {
                            grid[i][j] = number;
                            if (!solveTry(grid)) grid[i][j] = 0;
                            else return true;
                        }
                    }
                    if (grid[i][j] == 0) return false;
                }
            }
        }
        return isSolved(grid);
    }
    
    public void solve()
    {
        solve(grid);
    }
    
    public static void solve(int[][] grid)
    {
        if (!solveTry(grid)) throw new InvalidSudokuException();
    }
    
    public static int numberOfSolutions(int[][] grid)
    {
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            for (int j = 0; j < GRID_SIZE; ++j)
            {
                if (grid[i][j] == 0)
                {
                    int ans = 0;
                    for (int num = 1; num <= 9; ++num)
                    {
                        if (isPlaceable(grid, j, i, num))
                        {
                            grid[i][j] = num;
                            ans += numberOfSolutions(grid);
                            grid[i][j] = 0;
                        }
                    }
                    return ans;
                }
            }
        }
        if (!isSolved(grid)) return 0;
        return 1;
    }
    
    public int numberOfSolutions()
    {
        return numberOfSolutions(grid);
    }
    
    public static boolean isSolved(int[][] grid)
    {
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            for (int j = 0; j < GRID_SIZE; ++j)
            {
                int value = grid[i][j];
                grid[i][j] = 0;
                if (value == 0)
                {
                    return false;
                }
                if (!isPlaceable(grid, j, i, value))
                {
                    return false;
                }
                grid[i][j] = value;
            }
        }
        return true;
    }
    
    public boolean isSolved()
    {
        return isSolved(grid);
    }
    
    public void print()
    {
        print(grid);
    }
    
    public static void print(int[][] grid)
    {
        for (int i = 0; i < GRID_SIZE; ++i)
        {
            if (i % 3 == 0 && i != 0) System.out.println("---------------");
            for (int j = 0; j < GRID_SIZE; j++)
            {
                if (j % 3 == 0 && j != 0) System.out.print(" | ");
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
