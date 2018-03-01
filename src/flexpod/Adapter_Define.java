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
public class Adapter_Define {
    private int id;
    private String name;
    private int portCount;
    private List<String> supportedDevice;
    private String portType;
    
    private static int numberofDevice = 0;
    
    public Adapter_Define(String cName, String cPortType, int cPortCount, List<String> cSupportedDevice){
        this.name = cName;
        this.portCount = cPortCount;
        this.supportedDevice = cSupportedDevice;
        this.portType = cPortType;
        
        numberofDevice++;
        id = numberofDevice;
    }
    
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public int getPortCount(){return portCount;}
    public void setPortCount(int portCount){this.portCount = portCount;}
    
    public List<String> getSupportedDevice(){return supportedDevice;}
    public void setSupportedServer(List<String> supportedServer){this.supportedDevice = supportedDevice;}
    
    public String getPortType(){return portType;}
    public void setPortType(String portType){this.portType = portType;}
    
    public static int getNumberofDevice(){ return numberofDevice;}
}
