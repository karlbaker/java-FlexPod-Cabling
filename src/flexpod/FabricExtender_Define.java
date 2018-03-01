/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;

import java.util.List;

/**
 *
 * @author 028861
 */
public class FabricExtender_Define {
    private int id;
    private String name;
    private int portCount;
    private static int numberofDevice = 0;
    
    
    public FabricExtender_Define(String cName, int cPortCount) {
        this.name = cName;
        this.portCount = cPortCount;
        
        numberofDevice++;
        id = numberofDevice;
    }
    
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public int getPortCount(){return portCount;}
    public void setPortCount(int portCount){this.portCount = portCount;}
    
    public static int getNumberofDevice(){ return numberofDevice;}
}
