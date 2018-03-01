package flexpod;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by 028861 on 2/9/2016.
 */
public class FAS_Define {
    private int id;
    private String name;
    private int uSpace;
    private int pciSlot;
    private List<String> supportedProtocol; // Supported storage protocols.
    private List<String> supportedDiskShelf;
    private List<String> switchlessClusterPorts;
    private List<String> switchedClusterPorts;
    private List<String> ethernetDataPorts;
    private List<String> fibreDataPorts;
    private List<String> fsSasPorts;
    private List<String> lsSasPorts;
    private String apcPort;
    private double ampCount;
    private int maxDS2246;
    private int maxDS4243;
    private int maxDS4246;
    private int maxDS4486;
    
    private static int numberofDevice = 0;

    // This is the blueprint of the FAS Device which defines what is needed for the FAS objects.
    public FAS_Define(String cName,  int cUSpace, int cPCISlot, ArrayList<String> cSupportedProtocol, 
            ArrayList<String> cSupportedDiskShelf, ArrayList<String> cSwitchlessClusterPorts, ArrayList<String> cswitchedClusterPorts,
            ArrayList<String> cEthernetDataPorts, ArrayList<String> cFibreDataPorts, ArrayList<String> cFSSasPorts, ArrayList<String> cLSSasPorts,
            String cApcPort, double cAmpCount, int cMaxDS2246, int cMaxDS4243, int cMaxDS4246, int cMaxDS4486){
        this.name = cName;
        this.uSpace = cUSpace;
        this.pciSlot = cPCISlot;
        this.supportedProtocol = cSupportedProtocol;
        this.supportedDiskShelf = cSupportedDiskShelf;
        this.switchlessClusterPorts = cSwitchlessClusterPorts;
        this.switchedClusterPorts = cswitchedClusterPorts;
        this.ethernetDataPorts = cEthernetDataPorts;
        this.fibreDataPorts = cFibreDataPorts;
        this.fsSasPorts = cFSSasPorts;
        this.lsSasPorts = cLSSasPorts;
        this.apcPort = cApcPort;
        this.ampCount = cAmpCount;
        this.maxDS2246 = cMaxDS2246;
        this.maxDS4243 = cMaxDS4243;
        this.maxDS4246 = cMaxDS4246;
        this.maxDS4486 = cMaxDS4486;
        
        numberofDevice++;
        id = numberofDevice;
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}
      
    public int getuSpace(){return uSpace;}
    public void setuSpace(int uSpace){this.uSpace = uSpace;}

    public int getPciSlot(){return pciSlot;}
    public void setPciSlot(int pciSlot){this.pciSlot = pciSlot;}

    public List<String> getSupportedProtocol(){return supportedProtocol;}
    public void setSupportedProtocol(List<String> supportedProtocol){this.supportedProtocol = supportedProtocol;}
    
    public List<String> getSupportedDiskShelf(){return supportedDiskShelf;}
    public void setSupportedDiskShelf(List<String> supportedDiskShelf){this.supportedDiskShelf = supportedDiskShelf;}
    
    public List<String> getSwitchlessClusterPorts(){return switchlessClusterPorts;}
    public void setSwitchlessClusterPorts (List<String> switchlessClusterPorts){this.switchlessClusterPorts = switchlessClusterPorts;}
    
    public List<String> getSwitchedClusterPorts(){return switchedClusterPorts;}
    public void setSwitchedClusterPorts (List<String> switchedClusterPorts){this.switchedClusterPorts = switchedClusterPorts;}
    
    public List<String> getEthernetDataPorts(){return ethernetDataPorts;}
    public void setEthernetDataPorts(List<String> ethernetDataPorts){this.ethernetDataPorts = ethernetDataPorts;}
    
    public List<String> getFibreDataPorts(){return fibreDataPorts;}
    public void setFibreDataPorts(List<String> fibreDataPorts){this.fibreDataPorts = fibreDataPorts;}
    
    public List<String> getFSSasPorts(){return fsSasPorts;}
    public void setFSSasPorts(List<String> fsSasPorts){this.fsSasPorts = fsSasPorts;}
    
    public List<String> getLSSasPorts(){return lsSasPorts;}
    public void setLSSasPorts(List<String> lsSasPorts){this.lsSasPorts = lsSasPorts;}
    
    public String getApcPort(){return apcPort;}
    public void setApcPort(String apcPort){this.apcPort = apcPort;}
    
    public double getAmpCount(){return ampCount;}
    public void setAmpCount(double ampCount){this.ampCount = ampCount;}
    
    public static int getNumberofDevice(){ return numberofDevice;}


}
