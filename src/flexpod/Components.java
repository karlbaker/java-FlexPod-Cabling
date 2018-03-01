/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is to 
 * @author 028861
 */
public class Components extends main{

    public static void main (String[] args){
        
        
    }
    
   public static FI_Define[] Fabric_Interconnect(){
        FI_Define[] fiList = new FI_Define[3];
            fiList[0] = new FI_Define("UCS 6296","Eth","1/",2,48,3,9.2,new ArrayList(Arrays.asList("FCoE","FC","ISCSI")));
            fiList[1] = new FI_Define("UCS 6324","Eth","1/",0,4,0,0.0,new ArrayList(Arrays.asList("FCoE","FC","ISCSI")));
            fiList[2] = new FI_Define("UCS 6248UP","Eth","1/",1,32,1,9.2,new ArrayList(Arrays.asList("FCoE","FC","ISCSI")));
        
        return fiList;
    }
    
    public static Nexus_Define[] Nexus_Switch(){
              
        Nexus_Define[] nexusList = new Nexus_Define[6];
        //Nexus_Define (String cName, int cUSpace, int cRJ45Count, String cRJ45Suffix, int cSFPCount, String cSFPSuffix, 
        //              int cQSFPCount, String cQSFPSuffix, int cSlotCount, int cComputeStartingPort, int cFabricStartingPort, int cNexusStartingPort)
                nexusList[0] = new Nexus_Define("Nexus 5548UP", 1, 0, "", 32, "Eth1/", 0, "", 1, 1, 31, 15);
                nexusList[1] = new Nexus_Define("Nexus 5596UP", 2, 0, "", 48, "Eth1/", 0, "", 3, 1, 31, 15);
                nexusList[2] = new Nexus_Define("Nexus 9396PX", 2, 0, "", 48, "Eth1/", 0, "", 1, 1, 31, 15);
                nexusList[3] = new Nexus_Define("Nexus 9396TX", 2, 48, "Eth1/", 0, "", 0, "", 1, 1, 31, 15);
                nexusList[4] = new Nexus_Define("Nexus 9372PX", 1, 0, "", 48, "Eth1/", 6, "Eth1/", 0, 1, 31, 15);
                nexusList[5] = new Nexus_Define("Nexus 3524", 1, 0, "", 48, "Eth1/", 0, "", 0, 1, 31, 15);

        return nexusList;
    }
    
    public static FAS_Define[] NetApp_Filer(){
        FAS_Define[] fasList = new FAS_Define[10];
            fasList[0] = new FAS_Define("FAS2552", 2, 0, new ArrayList(Arrays.asList("iSCSI", "FCoE")), new ArrayList(Arrays.asList("DS2246", "DS4246", "DS4243")), 
                    new ArrayList(Arrays.asList("e0e", "e0f")), new ArrayList(Arrays.asList("")), new ArrayList(Arrays.asList("e0c", "e0d")), new ArrayList(Arrays.asList("")),
                    new ArrayList(Arrays.asList("0a")), new ArrayList(Arrays.asList("0b")), "e0P", 0.0, 5, 5, 5, 0);

            fasList[1] = new FAS_Define("FAS2554", 4, 0, new ArrayList(Arrays.asList("iSCSI", "FCoE")), new ArrayList(Arrays.asList("DS2246", "DS4246", "DS4243")), 
                    new ArrayList(Arrays.asList("e0e", "e0f")), new ArrayList(Arrays.asList("")), new ArrayList(Arrays.asList("e0c", "e0d")), new ArrayList(Arrays.asList("")),
                    new ArrayList(Arrays.asList("0a")), new ArrayList(Arrays.asList("0b")), "e0P", 0.0, 5, 5, 5, 0);

            fasList[2] = new FAS_Define("FAS8020", 3, 2, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246", "DS4246", "DS4243", "DS4486")), 
                    new ArrayList(Arrays.asList("e0a", "e0b")), new ArrayList(Arrays.asList("")), new ArrayList(Arrays.asList("e0c", "e0d")), new ArrayList(Arrays.asList("e0c", "e0d")),
                    new ArrayList(Arrays.asList("0a")), new ArrayList(Arrays.asList("0b")), "e0P", 0.0, 20, 20, 20, 10);

            fasList[3] = new FAS_Define("FAS8040", 6, 4, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246", "DS4246", "DS4243", "DS4486")), 
                    new ArrayList(Arrays.asList("e0a", "e0c")), new ArrayList(Arrays.asList("e0b", "e0d")), new ArrayList(Arrays.asList("e0e", "e0g")), new ArrayList(Arrays.asList("e0f", "e0h")),
                    new ArrayList(Arrays.asList("0a", "0c")), new ArrayList(Arrays.asList("0b", "0d")), "e0P", 0.0, 30, 30, 30, 15);

            fasList[4] = new FAS_Define("FAS8060", 6, 4, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246", "DS4246", "DS4243", "DS4486")), 
                    new ArrayList(Arrays.asList("e0a", "e0c")), new ArrayList(Arrays.asList("e0b", "e0d")), new ArrayList(Arrays.asList("e0e", "e0g")), new ArrayList(Arrays.asList("e0e", "e0g")),
                    new ArrayList(Arrays.asList("0a", "0c")), new ArrayList(Arrays.asList("0b", "0d")), "e0P", 0.0, 50, 50, 50, 25);

            fasList[5] = new FAS_Define("FAS8080", 12, 12, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246", "DS4246", "DS4243", "DS4486")), 
                    new ArrayList(Arrays.asList("e0a", "e0b","e0c", "e0d")), new ArrayList(Arrays.asList("")), new ArrayList(Arrays.asList("e0e", "e0g")), new ArrayList(Arrays.asList("e0e", "e0g")),
                    new ArrayList(Arrays.asList("0a", "0c")), new ArrayList(Arrays.asList("0b", "0d")), "e0P", 0.0, 60, 0, 0, 0);
            
            fasList[6] = new FAS_Define("AFF8020", 3, 2, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246")), 
                    new ArrayList(Arrays.asList("e0a", "e0b")), new ArrayList(Arrays.asList("")), new ArrayList(Arrays.asList("e0c", "e0d")), new ArrayList(Arrays.asList("e0c", "e0d")),
                    new ArrayList(Arrays.asList("0a")), new ArrayList(Arrays.asList("0b")), "e0P", 0.0, 10, 0, 0, 0);
            
            fasList[7] = new FAS_Define("AFF8040", 6, 4, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246")), 
                    new ArrayList(Arrays.asList("e0a", "e0c")), new ArrayList(Arrays.asList("e0b", "e0d")), new ArrayList(Arrays.asList("e0e", "e0g")), new ArrayList(Arrays.asList("e0e", "e0g")),
                    new ArrayList(Arrays.asList("0a", "0c")), new ArrayList(Arrays.asList("0b", "0d")), "e0P", 0.0, 12, 0, 0, 0);

            fasList[8] = new FAS_Define("AFF8060", 6, 4, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246")), 
                    new ArrayList(Arrays.asList("e0a", "e0c")), new ArrayList(Arrays.asList("e0b", "e0d")), new ArrayList(Arrays.asList("e0e", "e0g")), new ArrayList(Arrays.asList("e0e", "e0g")),
                    new ArrayList(Arrays.asList("0a", "0c")), new ArrayList(Arrays.asList("0b", "0d")), "e0P", 0.0, 20, 0, 0, 0);

            fasList[9] = new FAS_Define("AFF8080", 12, 12, new ArrayList(Arrays.asList("iSCSI", "FCoE", "FC")), new ArrayList(Arrays.asList("DS2246")), 
                    new ArrayList(Arrays.asList("e0a", "e0b","e0c", "e0d")), new ArrayList(Arrays.asList("")), new ArrayList(Arrays.asList("e0e", "e0g")), new ArrayList(Arrays.asList("e0e", "e0g")),
                    new ArrayList(Arrays.asList("0a", "0c")), new ArrayList(Arrays.asList("0b", "0d")), "e0P", 0.0, 20, 0, 0, 0);
            
        return fasList;
    }
    
    public static DS_Define[] Disk_Shelf(){
        DS_Define[] dsList = new DS_Define[4];
            dsList[0] = new DS_Define("DS2246", 2, 30, 2);
            dsList[1] = new DS_Define("DS4246", 4, 30, 4);
            dsList[2] = new DS_Define("DS4486", 4, 30, 4);
            dsList[3] = new DS_Define("DS4243", 4, 30, 4);
        
        return dsList;
    }
    
    public static Adapter_Define[] CSeries_Adapter(){
        Adapter_Define[] CSeries_Adapter = new Adapter_Define[5];
            CSeries_Adapter[0] = new Adapter_Define("VIC1227", "SFP", 2, new ArrayList(Arrays.asList("C220 M4", "C240 M4")));
            CSeries_Adapter[1] = new Adapter_Define("VIC1225", "SFP", 2, new ArrayList(Arrays.asList("C220 M4", "C240 M4")));
            CSeries_Adapter[2] = new Adapter_Define("VIC1227T", "RJ45",2, new ArrayList(Arrays.asList("C220 M4", "C240 M4", "C460 M4")));
            CSeries_Adapter[3] = new Adapter_Define("VIC1225T", "RJ45", 2, new ArrayList(Arrays.asList("C220 M4", "C240 M4", "C460 M4")));
            CSeries_Adapter[4] = new Adapter_Define("VIC1385", "QSFP", 2, new ArrayList(Arrays.asList("C220 M4", "C240 M4", "C460 M4")));
    
    return CSeries_Adapter;
    }   
    
    public static Adapter_Define[] NetApp_Adapter(){
    Adapter_Define[] NetApp_Adapter = new Adapter_Define[6];
            NetApp_Adapter[0] = new Adapter_Define("X2069-R6",  "SAS",  4, new ArrayList(Arrays.asList("AFF8020", "AFF8040", "AFF8060", "AFF8080EX", "FAS8020", "FAS8040", "FAS8060", "FAS8080EX")));
            NetApp_Adapter[1] = new Adapter_Define("X2065A-R6", "SAS",  4, new ArrayList(Arrays.asList("AFF8020", "AFF8040", "AFF8060", "AFF8080EX", "FAS8020", "FAS8040", "FAS8060", "FAS8080EX")));
            NetApp_Adapter[2] = new Adapter_Define("X1143A-R6", "SFP",  2, new ArrayList(Arrays.asList("AFF8020", "AFF8040", "AFF8060", "AFF8080EX", "FAS8020", "FAS8040", "FAS8060", "FAS8080EX")));
            NetApp_Adapter[3] = new Adapter_Define("X1132A-R6", "SFP",  2, new ArrayList(Arrays.asList("AFF8020", "AFF8040", "AFF8060", "AFF8080EX", "FAS8020", "FAS8040", "FAS8060", "FAS8080EX")));
            NetApp_Adapter[4] = new Adapter_Define("X2065A-R6", "SAS",  4, new ArrayList(Arrays.asList("AFF8020", "AFF8040", "AFF8060", "AFF8080EX", "FAS8020", "FAS8040", "FAS8060", "FAS8080EX")));
            NetApp_Adapter[5] = new Adapter_Define("X2054A-R6", "SAS",  4, new ArrayList(Arrays.asList("AFF8020", "AFF8040", "AFF8060", "AFF8080EX", "FAS8020", "FAS8040", "FAS8060", "FAS8080EX")));
    
    return NetApp_Adapter;
    
    }
  
    public static ClusterSwitch_Define[] Cluster_Switch(){
        ClusterSwitch_Define[] clusterSwitchList = new ClusterSwitch_Define[2];
            clusterSwitchList[0] = new ClusterSwitch_Define("CN1610", "SFP", 16);
            clusterSwitchList[1] = new ClusterSwitch_Define("CN1601", "RJ45", 16);
        
        return clusterSwitchList;
    }
    
    public static  FabricExtender_Define[] Fabric_Extender(){
        FabricExtender_Define[] fabricExtenderList = new FabricExtender_Define[2];
            fabricExtenderList[0] = new FabricExtender_Define("2204XP FEX", 4);
            fabricExtenderList[1] = new FabricExtender_Define("2208 FEX", 8);
            
        return fabricExtenderList;
    }
    
    public static SwitchModule_Define[] Nexus_Module(){ // Check the End of Life for Products. Looks like there is a series of products for the 5k that is EOL as of 03/29/2016
        SwitchModule_Define[] nexusModuleList = new SwitchModule_Define[4];
            nexusModuleList[0] = new SwitchModule_Define("N55-M16P", "SFP", 16, new ArrayList(Arrays.asList("Nexus 5548P", "Nexus 5548UP", "Nexus 5596UP", "Nexus 5596T")));
            nexusModuleList[1] = new SwitchModule_Define("N55-M12T", "RJ45", 12, new ArrayList(Arrays.asList("Nexus 5596T")));
            nexusModuleList[2] = new SwitchModule_Define("N55-M8P8FP", "RJ45", 12, new ArrayList(Arrays.asList("Nexus 5596T")));
            
        return nexusModuleList;
    }
    
    public static SwitchModule_Define[] Fabric_Module(){
        SwitchModule_Define[] fabricModuleList = new SwitchModule_Define[0];
            fabricModuleList[0] = new SwitchModule_Define("", "", 0, new ArrayList(Arrays.asList("")));
            
            
        return fabricModuleList;
    }
    
    public static Server_Define[] CSeries_Server(){
        Server_Define[] cSeriesServerList = new Server_Define[3];
            cSeriesServerList[0] = new Server_Define("C220 M4", 1, 2, "RJ45", 2);
            cSeriesServerList[1] = new Server_Define("C240 M4", 1, 2, "RJ45", 2);
            cSeriesServerList[2] = new Server_Define("C460 M4", 1, 2, "RJ45", 4);
        
        return cSeriesServerList;
    }
    
    public static PDU_Define[] Power_Distrubtion_Unit(){
        PDU_Define[] pduList = new PDU_Define[4];
            //PDU_Define(int cID, String cName, int cMaxAMP, int cC13Count, int cC19Count)
            pduList[0] = new PDU_Define("PW105MI1U165", 24, 6, 4, 1);
            pduList[1] = new PDU_Define("EMI104-10", 24, 36, 6, 0);
            pduList[2] = new PDU_Define("RP208-30-1P-U-1", 24, 2, 4, 1);
            pduList[3] = new PDU_Define("RP208-30-1P-U-2", 24, 20, 4, 0);
      
        
        
        return pduList;
    }
}