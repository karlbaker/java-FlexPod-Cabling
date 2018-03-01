   package flexpod;
/**
 * Created by 028861 on 2/9/2016.
 */
public class Nexus_Define {
    private String name;
    private int uSpace;
    private int rj45Count;
    private String rj45Suffix;
    private int sfpCount;
    private String sfpSuffix;
    private int qsfpCount;
    private String qsfpSuffix;
    private int slotCount;
    private int computeStartingPort;
    private int fabricStartingPort;
    private int nexusStartingPort;

    
    private static int numberofDevice = 0;

    public Nexus_Define (String cName, int cUSpace, int cRJ45Count, String cRJ45Suffix, int cSFPCount, String cSFPSuffix, 
    int cQSFPCount, String cQSFPSuffix, int cSlotCount, int cComputeStartingPort, int cFabricStartingPort, int cNexusStartingPort){
        this.name = cName;
        this.uSpace = cUSpace;
        this.rj45Count = cRJ45Count;
        this.rj45Suffix = cRJ45Suffix;
        this.sfpCount = cSFPCount;
        this.sfpSuffix = cSFPSuffix;
        this.qsfpCount = cQSFPCount;
        this.slotCount = cSlotCount;
        this.computeStartingPort = cComputeStartingPort;
        this.fabricStartingPort = cFabricStartingPort;
        this.nexusStartingPort = cNexusStartingPort;

    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public int getuSpace(){return uSpace;}
    public void setuSpace(int uSpace){this.uSpace = uSpace;}

    public int getRj45Count(){return rj45Count;}
    public void setRj45Count(int rj45Count){this.rj45Count = rj45Count;}
    
    public String getRj45Suffix(){return rj45Suffix;}
    public void setRj45Suffix(String rj45Suffix){this.rj45Suffix = rj45Suffix;}

    public int getSfpCount(){return sfpCount;}
    public void setSfpCount(int sfpCount){this.sfpCount = sfpCount;}
    
    public String getSfpSuffix(){return sfpSuffix;}
    public void setSfpSuffix(String sfpSuffix){this.sfpSuffix = sfpSuffix;}

    public int getQsfpCount(){return qsfpCount;}
    public void setQsfpCount(int qsfpCount){this.qsfpCount = qsfpCount;}
    
    public String getQsfpSuffix(){return qsfpSuffix;}
    public void setQsfpSuffix(String qsfpSuffix){this.qsfpSuffix = qsfpSuffix;}

    public int getSlotCount(){return slotCount;}
    public void setSlotCount(int slotCount){this.slotCount = slotCount;}
    
    public int getComputeStartingPort(){return computeStartingPort;}
    public void setComputeStartingPort(int computeStartingPort){this.computeStartingPort = computeStartingPort;}
    
    public int getFabricStartingPort(){return fabricStartingPort;}
    public void setFabricStartingPort(int fabricStartingPort){this.fabricStartingPort = fabricStartingPort;}
    
    public int getNexusStartingPort(){return nexusStartingPort;}
    public void setNexusStartingPort(int nexusStartingPort){this.nexusStartingPort = nexusStartingPort;} 
    
    public static int getNumberofDevice(){ return numberofDevice;}
}
