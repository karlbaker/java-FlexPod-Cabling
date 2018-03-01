package flexpod;

/**
 * Created by 028861 on 2/12/2016.
 */
public class ClusterSwitch_Define {
    private String name;
    private String portType;
    private int portCount;
    
    private static int numberofDevice = 0;

    public ClusterSwitch_Define(String cName, String cPortType, int cPortCount){
        this.name = cName;
        this.portType = cPortType;
        this.portCount = cPortCount;
    }

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public String getPortType(){return portType;}
    public void setPortType(String portType){this.portType = portType;}

    public int getPortCount(){return portCount;}
    public void setPortCount(int portCount){this.portCount = portCount;}
}
