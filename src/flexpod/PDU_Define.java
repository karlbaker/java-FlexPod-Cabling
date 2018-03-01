/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 028861
 */
public class PDU_Define {
    /*
    This is a list of attributes (variables) for the PDU object. 
    Any added attributes must also be added to the PDU Constructor
    in order for it to take effect.
    */
    private int id;
    private String name;
    private double maxAMP;
    private int c13Count;
    private int c19Count;
    private int uSpace;
    
    private static int numberofDevice = 0;
    
    // PDU Constructor
    public PDU_Define(String cName, int cMaxAMP, int cC13Count, int cC19Count, int cUSpace){
       
        this.name = cName;
        this.maxAMP = cMaxAMP;
        this.c13Count = cC13Count;
        this.c19Count = cC19Count;
        this.uSpace = cUSpace;
    }
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public double getMaxAMP(){return maxAMP;}
    public void setMaxAMP(double maxAMP){this.maxAMP = maxAMP;}
    
    public int getC13Count(){return c13Count;}
    public void setC13Count(int c13Count){this.c13Count = c13Count;}
    
    public int getC19Count(){return c19Count;}
    public void setC19Count(int c19Count){this.c19Count = c19Count;}
    
    public int getUSpace(){return uSpace;}
    public void setUSpace(int uSpace){this.uSpace = uSpace;}
    
    public static int getNumberofDevice(){ return numberofDevice;}
}
