/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.util.List;

/**
 *
 * @author Ventsislav Peychev
 */
public interface ManipulateData {

    public void collectData();

    public void saveData(String data);

    public List returnData();
}
