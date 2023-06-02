/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sort;

import Data.User;

/**
 *
 * @author Ventsislav Peychev
 */
public abstract class Sort {
    public static <T extends User> Object[] get(T[] arr)
    {
        Heap <T> h = new Heap<>();
        for (int i = 0; i < arr.length; ++i)
        {
            h.add(arr[i]);
        }
        return Heap.sorted(h);
    }
}
