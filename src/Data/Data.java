/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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
            File file = new File("src/Scoreboard/scoreboard.txt");
            //vzimane na poslednite 10 pobeditelia ot scoreboard-a i slagane v saotvetnia label
            BufferedReader reader = new BufferedReader(new FileReader(file.getPath()));
            reader.mark(10000);
            List <String> s = new LinkedList<>();
            s = reader.lines().collect(Collectors.toCollection(LinkedList::new));
            for (String Line: s)
            {
                user.add(new User(Line));
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
    public void addData(String data)
    {
        
    }

    @Override
    public List returnData() // to be finished
    {
        return null;
    }
    
    @Override
    public void saveData()
    {
        
    }
    
    
    
}
