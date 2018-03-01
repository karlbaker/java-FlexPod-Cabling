/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;

/**
 *
 * @author 028861
 */
public class Server_Define {
    private int id;
    private String name;
    private int mgmtPortCount;
    private int dataPortCount;
    private String dataPortType;
    private int powerSupplyCount;
    
    private static int numberofDevice = 0;
    
    public Server_Define(String cName, int cMgmtPortCount, int cDataPortCount, String cDataPortType, int cPowerSupplyCount){
        this.name = cName;
        this.mgmtPortCount = cMgmtPortCount;
        this.dataPortCount = cDataPortCount;
        this.dataPortType = cDataPortType;
        this.powerSupplyCount = cPowerSupplyCount;
        
        numberofDevice++;
        id = numberofDevice;
    }
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public int getMgmtPortCount(){return mgmtPortCount;}
    public void setMgmtPortCount(int mgmtPortCount){this.mgmtPortCount = mgmtPortCount;}
    
    public int getDataPortCount(){return dataPortCount;}
    public void setDataPortCount(int dataPortCount){this.dataPortCount = dataPortCount;}
    
    public int getPowerSupplyCount(){return powerSupplyCount;}
    public void setPowerSupplyCount(int powerSupplyCount){this.powerSupplyCount = powerSupplyCount;}
    
    public static int getNumberofDevice(){ return numberofDevice;}
}
