/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sort;

import data.User;
import java.util.List;

/**
 *
 * @author Ventsislav Peychev
 */
public class Sort {
    public static <T extends User> List <T> get(List <T> arr)
    {
        Heap <T> h = new Heap<>();
        for (int i = 0; i < arr.size(); ++i)
        {
            h.add(arr.get(i));
        }
        return Heap.sorted(h);
    }
}
