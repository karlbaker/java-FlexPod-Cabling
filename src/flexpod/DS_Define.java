package flexpod;
/**
 * Created by 028861 on 2/12/2016.
 */
public class DS_Define {
    private int id;
    private String name;
    private int uSpace;
    private int maxNumberofStack;
    private int powerCount;
    
    private static int numberofDevice = 0;

    public DS_Define(String cName, int cUSpace, int cMaxNumberofStack, int cPowerCount){
        this.name = cName;
        this.uSpace = cUSpace;
        this.maxNumberofStack = cMaxNumberofStack;
        this.powerCount = cPowerCount;
        numberofDevice++;
        id = numberofDevice;
    }
    public int getID(){return id;}
    public void setID(int id){this.id = id;}
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public int getuSpace(){return uSpace;}
    public void setuSpace(int uSpace){this.uSpace = uSpace;}

    public int getmaxNumberofStack(){return maxNumberofStack;}
    public void setMaxNumberofStack(int maxNumberofStack){this.maxNumberofStack = maxNumberofStack;}
    
    public static int getNumberofDevice(){ return numberofDevice;}
}
