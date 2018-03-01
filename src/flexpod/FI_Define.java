package flexpod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 028861 on 2/9/2016.
 */
public class FI_Define {
    private int id;
    private String name;                    // Name of the equipment; UCS 6248, UCS 6324, etc
    private String prefix;
    private String infix;
    private int uSpace;                     // The Rack Unit size of the equipment
    private int portCount;                  // This is for the number ports avaliable (not including any expansion).
    private int slotCount;                  // This is for the number of expansion slots avaliable.
    private double ampCount;                // Amperage is based on the power usage.
    private List<String> supportedProtocol; // Supported storage protocols.
    
    private static int numberofDevice = 0;

    public FI_Define(String cName, String cPrefix, String cInfix, int cUSpace, int cPortCount, int cSlotCount, double cAmpCount, List<String> cSupportedProtocol){
           this.name = cName;
           this.prefix = cPrefix;
           this.infix = cInfix;
           this.uSpace = cUSpace;
           this.portCount = cPortCount;
           this.slotCount = cSlotCount; 
           this.ampCount = cAmpCount;
           this.supportedProtocol = cSupportedProtocol;
           numberofDevice++;
           id = numberofDevice;
    }
    
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    
    public String getPrefix(){return prefix;}
    public void setPrefix(String prefix){this.prefix = prefix;}
    
    public String getInfix(){return infix;}
    public void setInfix(String infix){this.infix = infix;}
    
    public int getuSpace(){return uSpace;}
    public void setuSpace(int uSpace){this.uSpace = uSpace;}

    public int getPortCount(){return portCount;}
    public void setPortCount(int portCount){this.portCount = portCount;}

    public int getSlotCount(){return slotCount;}
    public void setSlotCount(int slotCount){this.slotCount = slotCount;}
    
    public double getAMPCount(){return ampCount;}
    public void setAMPCount(double ampCount){this.ampCount = ampCount;}
    
    public List<String> getSupportedProtocol(){return supportedProtocol;}
    public void setSupportedProtocol(List<String> supportedProtocol){this.supportedProtocol = supportedProtocol;}
    
    public static int getNumberofDevice(){ return numberofDevice;}
    
           
}
