/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import sudoku.SudokuLevels;

/**
 *
 * @author Ventsislav Peychev
 */
public class Data implements ManipulateData
{
    private ArrayList<User> user = new ArrayList<>();

    public Data()
    {
        collectData();
    }
    
    @Override
    public void collectData() // collecting Data from txt file 
    {
        try
        {    
            //prihvashtane na faila za scorevoard-a
            File file = new File("src/Scoreboard/scoreboard.csv");
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
            List<String> s = new LinkedList<>();
            s = reader.lines().collect(Collectors.toCollection(LinkedList::new));
            s.remove(0);
            for (String line: s)
            {
                addToUser(line);
            }
            reader.close();
        } 
        catch (IOException e)
        {
            System.out.println("Exception occured while displaying scoreboard");
            e.printStackTrace();
        }
    }

    @Override
    public void saveData(String toSave)
    {
        try {
            File file = new File("src/Scoreboard/scoreboard.csv");
            //pisane na poslednia pobeditel v scoreboarda
            FileWriter fileWriter = new FileWriter(file.getPath(), true);
            BufferedWriter out = new BufferedWriter(fileWriter);
            out.write(toSave);
            out.close();
            addToUser(toSave);
        } catch (IOException e) {
            System.out.println("Exception occured while saving to scoreboard");
            e.printStackTrace();
        }
    }

    @Override
    public List <User> returnData()
    {
        return user;
    }
    
    
    private void addToUser(String line)
    {
        String []values = line.split(",");
        User u = new User(values[0], Integer.parseInt(values[2].trim()));

        switch (values[1])
        {
            case "EASY":
                u.setDifficulty(SudokuLevels.EASY);
                break;
            case "MEDIUM":
                u.setDifficulty(SudokuLevels.MEDIUM);
                break;
            case "HARD":
                u.setDifficulty(SudokuLevels.HARD);
                break;
            case "EXPERT":
                u.setDifficulty(SudokuLevels.EXPERT);
                break;
        }

        user.add(u);
    }   
}
