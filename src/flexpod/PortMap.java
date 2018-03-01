/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 *
 * @author 028861
 */
public class PortMap extends main {
    

    public static void main (String[] args){
        
        //System.out.println(Nexus_PortMap("Nexus 9396TX", 2));
       // System.out.println(Fabric_PortMap("UCS 6248", 2, "module"));
        //System.out.println(BSeries_PortMap("UCS 5108", 1, 4));
        
        //ArrayList<String> bSeries = new PortMap().BSeriesDataList("UCS 5108", 2, "2204XP FEX", "UCS 6248UP", 2);
        //ArrayList<String> fabric = new PortMap().FabricDataList("UCS 6248UP", 2, "None");
        
        //ArrayList<String> nexus = new PortMap().NexusDataList ("Nexus 9396PX", 2);
        ArrayList<String> netappData = new PortMap().NetAppFilerDataList("FAS2552", "Dual Controller", 1);
        //ArrayList<String> netAppSAS = new PortMap().NetAppSASList("FAS8040", "Dual Controller", 1);
        //ArrayList<String> bSeriesPower = new PortMap().BSeriesPowerList("UCS 5108", 2);
        //ArrayList<String> cSeriesPower = new PortMap().CSeriesPowerList("C220 M4", 2);
        //ArrayList<String> nexusPower = new PortMap().NexusPowerList("Nexus 5548UP",2);
        //ArrayList<String> fabricPower = new PortMap().FabricPowerList("UCS 6248UP",2);
        //ArrayList<String> netAppPower = new PortMap().NetAppShelfPowerList("DS2246", 3);
        //ArrayList<String> netAppShelfSAS = new PortMap().NetAppShelfSASList("DS2246", 2);
        ArrayList<String> SASlist = new PortMap().SASCableList("FAS2552", "Dual Controller", 2, 1, "DS2246", 4);
        ArrayList<String> apcList = new PortMap().APCCableList("FAS2552", "Dual Controller", 1, 1, "DS2246", 4);
        //ArrayList<String> fabricNexusVPCList = new PortMap().FabricNexusVPCList("UCS 6248UP", 2, "None", "Nexus 5548UP", 2, 2);/*
        //ArrayList<String> fabricNexusVPCList = new PortMap().NexustoNexusList("Nexus 5548UP", 2);
        //ArrayList<String> powerList = new PortMap().powerList("UCS 5108", 2, "C220 M4",2,"Nexus 5548UP",2, "UCS 6248UP",2, "FAS2552", 1, "DS2246",2,"RP208-30-1P-U-2",2,"RP208-30-1P-U-2",2);
        
        ArrayList<String> cSeries = new PortMap().CSeriesDataList("C220 M4", 4, false, "mLOM", "SFP", 2);
        ArrayList<String> master = new PortMap().MasterPortMap("4324243","UCS 5108",1,"None","C220 M4",4,true,
                "mLOM","SFP+",4,"UCS 6324",2,"None","Nexus 5548UP",2,
                8,2,"iSCSI","FAS2552","Dual Controller",2,"Switchless",
                false,1,"DS2246",2,"RP208-30-1P-U-2",2,"RP208-30-1P-U-1",2);
        
        System.out.println(netappData);
        //System.out.println(cSeries);
        //System.out.println("Total size of the Master list: " + master.size());

    }
    
    public ArrayList MasterPortMap(String salesOrder, String BSeriesType,int BSeriesCount,String FabricExtender,String  CSeriesType,int CSeriesCount,boolean CSeriesFI,
            String CSeriesSlot,String CSeriesAdapterType,int CSeriesPortCount,String FabricType,int FabricCount,String FabricModule,String NexusType,int NexusCount,
            int FINexusUplink,int FIIOMUplink,String ProtocolType,String NetAppFilerType,String NetAppFilerController,int NetAppFilerCount,String NetAppClusterType,
            boolean SSDShelfCheck,int NetAppStackCount,String NetAppShelfType,int NetAppShelfCount,String PDU1Type,int PDU1Count,String PDU2Type,int PDU2Count){


    // Adding Component Lists
    ArrayList<String> bSeriesDataList = BSeriesDataList(BSeriesType, BSeriesCount, FabricExtender, FabricType, FIIOMUplink);
    ArrayList<String> fabricDataList = FabricDataList(FabricType, FabricCount);
    ArrayList<String> cSeriesDataList = CSeriesDataList(CSeriesType, CSeriesCount, CSeriesFI, CSeriesSlot, CSeriesAdapterType, CSeriesPortCount);
    ArrayList<String> nexusDataList = NexusDataList (NexusType, NexusCount);
    ArrayList<String> netAppFilerDataList = NetAppFilerDataList(NetAppFilerType, NetAppFilerController, NetAppFilerCount);
    ArrayList<String> netAppAPCList = APCCableList(NetAppFilerType, NetAppFilerController, NetAppFilerCount, NetAppStackCount, NetAppShelfType, NetAppShelfCount);
    ArrayList<String> netAppSASList = SASCableList(NetAppFilerType, NetAppFilerController, NetAppFilerCount, NetAppStackCount, NetAppShelfType, NetAppShelfCount);
    ArrayList<String> bSeriesPowerList = BSeriesPowerList(BSeriesType, BSeriesCount);
    ArrayList<String> cSeriesPowerList = CSeriesPowerList(CSeriesType, CSeriesCount);
    ArrayList<String> fabricPowerList = FabricPowerList(FabricType, FabricCount);
    ArrayList<String> nexusPowerList = NexusPowerList(NexusType, NexusCount);
    ArrayList<String> netAppFilerPowerList = NetAppFilerPowerList(NetAppFilerType, NetAppFilerCount);
    ArrayList<String> netAppShelfPowerList = NetAppShelfPowerList(NetAppShelfType, NetAppShelfCount);
    ArrayList<String> fabricnexusVPCList = FabricNexusVPCList(FabricType, FabricCount, FabricModule, NexusType, NexusCount, FINexusUplink);
    ArrayList<String> NexustoNexusList = NexustoNexusList(NexusType, NexusCount);
    ArrayList<String> powerList = powerList(BSeriesType, BSeriesCount, CSeriesType, CSeriesCount, NexusType, NexusCount, FabricType, 
            FabricCount, NetAppFilerType, NetAppFilerCount, NetAppShelfType, NetAppShelfCount, PDU1Type, PDU1Count, PDU2Type, PDU2Count);
    
    // Create Master Port List
    ArrayList<String> masterPortList = new ArrayList();
    
    // Define Iterators for Master Port List
    FI_Define[] fabricList = Components.Fabric_Interconnect();
    Nexus_Define[] nexusList = Components.Nexus_Switch();
    
    Iterator<String> BSeriesIteratorList = bSeriesDataList.iterator();
    Iterator<String> FabricIteratorList = fabricDataList.iterator();
    Iterator<String> CSeriesIteratorList = cSeriesDataList.iterator();
    Iterator<String> NexusIteratorList = nexusDataList.iterator();
    Iterator<String> netAppFilerDataIteratorList = netAppFilerDataList.iterator();
    Iterator<String> netAppAPCIteratorList = netAppAPCList.iterator();
    Iterator<String> netAppFilerSASIteratorList = netAppSASList.iterator();
    Iterator<String> bSeriesPowerIteratorList = bSeriesPowerList.iterator();
    Iterator<String> cSeriesPowerIteratorList = cSeriesPowerList.iterator();
    Iterator<String> fabricPowerIteratorList = fabricPowerList.iterator();
    Iterator<String> nexusPowerIteratorList = nexusPowerList.iterator();
    Iterator<String> netAppFilerPowerIteratorList = netAppFilerPowerList.iterator();
    Iterator<String> netAppShelfPowerIteratorList = netAppShelfPowerList.iterator();

    
    /***********************************************************
      POINT-TO-POINT ASSIGNMENT TO THE MASTER LIST STARTS HERE
    ************************************************************/
    
    // Create Master Port List - B-Series Equipment - Data
    int inc;
    int nexusCounter = 0;
    int fabricCounter = 0;
    
    if (!"UCS 6324".equals(FabricType)){
        for (inc=0;inc < ((FIIOMUplink * BSeriesCount));inc++){
            masterPortList.add(fabricDataList.get(0) + "," + bSeriesDataList.get(0) + "\n");
            bSeriesDataList.remove(0);
            fabricDataList.remove(0);
            fabricCounter++;
        }
        for (FI_Define fabric: fabricList){
            if (fabric.getName().equalsIgnoreCase(FabricType)) {
                for (inc=0;inc < ((FIIOMUplink * BSeriesCount));inc++){
                    masterPortList.add(fabricDataList.get(fabric.getPortCount() - fabricCounter) + "," + bSeriesDataList.get(0) + "\n");
                    bSeriesDataList.remove(0);
                    fabricDataList.remove(fabric.getPortCount()/2);
                }
            }
        }
    }

    // Create Master Port List - C-Series Equipment - Data  
     if (!"UCS 6324".equals(FabricType) && CSeriesFI == true && cSeriesDataList.isEmpty() == false){
        for (inc=0;inc < ((CSeriesPortCount*CSeriesCount)/2);inc++){
            masterPortList.add(fabricDataList.get(0) + "," + cSeriesDataList.get(0) + "\n");
            cSeriesDataList.remove(0);
            fabricDataList.remove(0);
            fabricCounter++;
        }
        for (FI_Define fabric: fabricList){
            if (fabric.getName().equalsIgnoreCase(FabricType)) {
                for (inc=0;inc < ((CSeriesPortCount*CSeriesCount)/2);inc++){
                    masterPortList.add(fabricDataList.get(fabric.getPortCount()-fabricCounter) + "," + cSeriesDataList.get(0) + "\n");
                    cSeriesDataList.remove(0);
                    fabricDataList.remove(fabric.getPortCount()-fabricCounter);
                }
            }
        }
    }else if (CSeriesFI == true && FabricType.equalsIgnoreCase("UCS 6324") && cSeriesDataList.isEmpty() == false && CSeriesCount <= 4 && CSeriesCount > 0){ 
        final int listSize = (cSeriesDataList.size() /2);
        for (inc=0;inc < listSize;inc++){ 
            masterPortList.add("Fabric-A Eth1/5" + "," + cSeriesDataList.get(0) + "\n");
            cSeriesDataList.remove(0);
        }
        for (inc=0;inc < listSize;inc++){ 
            masterPortList.add("Fabric-B Eth1/5" + "," + cSeriesDataList.get(0) + "\n");
            cSeriesDataList.remove(0);
        }
    }else if (CSeriesFI == false && cSeriesDataList.isEmpty() == false){
       
        for (inc=0;inc < ((CSeriesPortCount * CSeriesCount) / 2);inc++){
            masterPortList.add(nexusDataList.get(0) + "," + cSeriesDataList.get(0) + "\n");
            cSeriesDataList.remove(0);
            nexusDataList.remove(0);
            nexusCounter++;
        }
        for (Nexus_Define nexus: nexusList){
            if (nexus.getName().equalsIgnoreCase(NexusType)) { 
                for (inc=0;inc < ((CSeriesPortCount*CSeriesCount)/2);inc++){ 
                    masterPortList.add(nexusDataList.get((nexus.getRj45Count() + nexus.getSfpCount() + nexus.getQsfpCount())-nexusCounter) + "," + cSeriesDataList.get(0) + "\n");
                    cSeriesDataList.remove(0);
                    nexusDataList.remove((nexus.getRj45Count() + nexus.getSfpCount() + nexus.getQsfpCount())-nexusCounter);
                }
            }
        }
    }
    // Create Master Port List - vPC Peer - Nexus Switch
    for (int vPCPort = 0; vPCPort < NexustoNexusList.size(); vPCPort++){
        masterPortList.add(NexustoNexusList.get(vPCPort));
    }
    
    // Create Master Port List - Fabric to Nexus vPC
    for (int fiNexusVPC = 0; fiNexusVPC < fabricnexusVPCList.size();fiNexusVPC++){
        masterPortList.add(fabricnexusVPCList.get(fiNexusVPC));
    }
    
    // Create Master Port List - vPC Peer - Fabric Interconnect
    if (!"UCS 6324".equals(FabricType)){
    char c = 'A';
    char d = 'B';
        for (int fiCount = 0; fiCount < (FabricCount/2);fiCount++){ // Divide by 2 because the FIs are in pairs
            for (int pCount = 1; pCount < 3;pCount++){
                masterPortList.add("Nexus-" + c + " L" + pCount + "," + "Nexus-" + d + " L" + pCount + "\n");
            }
            c++;
            d++;
        }
    }
    
    // Create Master Port List - NetApp Filer to Nexus
    
    for (int netappData = 0; netappData < netAppFilerDataList.size(); netappData++){
        masterPortList.add(nexusDataList.get(netappData) + "," + netAppFilerDataList.get(netappData) + "\n");
    }

    // Create Master Port List - NetApp Filer to Disk Shelves - APC
    for (int netAppAPC = 0; netAppAPC < netAppAPCList.size(); netAppAPC++ ){
        masterPortList.add(netAppAPCList.get(netAppAPC));
    }

    // Create Master Port List - NetApp Filer SAS
    do{
        masterPortList.add(netAppFilerSASIteratorList.next());
    }while (netAppFilerSASIteratorList.hasNext());
    
    // Create Master Port List - Power
    for (int i = 0; i < powerList.size();i++){
        masterPortList.add(powerList.get(i));
    }
        return masterPortList;
    }
    
    public ArrayList BSeriesDataList(String BSeriesType, int BSeriesCount, String FabricExtender, String FabricType, int FIIOMUplink){
        ArrayList<String> BSeriesDataList = new ArrayList<>();
        int pCount=1;
        char c='A';
        for(int iomCount=1; iomCount < 3; iomCount++){                                             // For loop will loop through both IOM modules to create the list. 
            for (int dCount=0; dCount < BSeriesCount; dCount++){                                   // For each Chassis the letter (c) increments with the c++ command 
                    do{
                            BSeriesDataList.add(BSeriesType.substring(4, 8) + "-" + c + " IOM-" + iomCount + " P" + pCount);
                            pCount++; 
                        } 
                    while (pCount < (FIIOMUplink + 1));
                    pCount=1; 
                    c++; 
                 } 
                c='A';
            }
        
        return BSeriesDataList;
    }
   
    public ArrayList CSeriesDataList(String CSeriesType, int CSeriesCount, boolean CSeriesFI, String CSeriesSlot, String CSeriesAdapterType, int CSeriesPortCount){ 
        ArrayList<String> CSeriesDataList = new ArrayList<>();
        int pCount=1; 
        int cCount=0; 
        char c='A'; 

        for (int y=0; y < CSeriesPortCount; y++){ 
                do{
                        CSeriesDataList.add(CSeriesType.substring(0, 4) + "-" + c + " " + CSeriesSlot + " P" + pCount);
                        c++; 
                        cCount++; 
                } 
                while (cCount < CSeriesCount);
                // Start over for next port
                c='A'; 
                cCount=0; 
                pCount++; 
        }
        
        return CSeriesDataList;
    } 
    
    public ArrayList FabricDataList(String FabricType, int FabricCount){
        ArrayList<String> FabricDataList = new ArrayList<>();
        FI_Define[] fabricList = Components.Fabric_Interconnect();
        
        int pCount=1;
        char c='A';
        
        for (FI_Define fabric : fabricList) {
            if (fabric.getName().equalsIgnoreCase(FabricType)) {
                //if (fabricList1.getPortCount() > 0) {
                    for (int dCount = 0; dCount < FabricCount; dCount++) {
                        do {
                            FabricDataList.add("Fabric" + "-"+ c + " " + fabric.getPrefix() + fabric.getInfix() + pCount);
                            pCount++;
                        } while (pCount < (fabric.getPortCount() + 1));
                        pCount=1;
                        c++;
                    }
                    //break;
                //}
            }
        }
        
        
        return FabricDataList;
    }
    
    public ArrayList NexusDataList (String NexusType, int NexusCount){
        Nexus_Define[] nexusList = Components.Nexus_Switch(); // Call the Nexus List from the Component class
        ArrayList<String> nexusDataList = new ArrayList(Arrays.asList()); // This will be the list created for the CSV file
        
        int pCount=1;
        char c='A';
        
        for (Nexus_Define nexusList1 : nexusList) {
            // Run through the Nexus List
            if (nexusList1.getName().equalsIgnoreCase(NexusType)) {
                // Find the entry that matches the selected Nexus device
                if (nexusList1.getRj45Count() > 0) {
                    // If selected device has using RJ45 ports create a list
                    for (int dCount = 0; dCount < NexusCount; dCount++) {
                        // While count is less than the number of devices run through the port assignment then increment by a letter
                        do {
                            nexusDataList.add("Nexus" + "-" + c + " " + nexusList1.getRj45Suffix() + pCount);
                            pCount++;
                        } while (pCount < (nexusList1.getRj45Count() + 1)); // While port count is less than the number of ports do the following
                        pCount=1;
                        c++;
                    }
                } else if(nexusList1.getSfpCount() > 0){
                    // If selected device has using SFP ports create a list
                    for (int dCount = 0; dCount < NexusCount; dCount++) {
                        // While count is less than the number of devices run through the port assignment then increment by a letter
                        do {
                            nexusDataList.add("Nexus" + "-" + c + " " + nexusList1.getSfpSuffix() + pCount);
                            pCount++;
                        } while (pCount < (nexusList1.getSfpCount() + 1)); // While port count is less than the number of ports do the following
                        pCount=1;
                        c++;
                    }
                } else if (nexusList1.getQsfpCount() > 0){
                    // If selected device has using QSFP ports create a list
                    for (int dCount = 0; dCount < NexusCount; dCount++) {
                        // While count is less than the number of devices run through the port assignment then increment by a letter
                        do {
                            nexusDataList.add("Nexus" + "-" + c + " " + nexusList1.getQsfpSuffix() + pCount);
                            pCount++;
                        } while (pCount < (nexusList1.getQsfpCount() + 1)); // While port count is less than the number of ports do the following
                        pCount=1;
                        c++;
                    }
                }
                break;
            }
        }  
      
        return nexusDataList;
    }
    
    public ArrayList NetAppFilerDataList(String NetAppFilerType, String NetAppFilerController, int NetAppFilerCount){
        ArrayList<String> netAppFilerDataList = new ArrayList();
        FAS_Define[] fasDataList = Components.NetApp_Filer();
        
        // Essentially converting Single/Dual Controller to a controller count.
        
        
        int ctrlCount = 1;      // Single Controller
        if ("Dual Controller".equals(NetAppFilerController)){
            ctrlCount = 2;      // Dual Controller
        }

        int pCount;
        char c = 'A';
      
        for (FAS_Define filer: fasDataList){                                        // Cycle through the NetApp Filer Type name list
            if (filer.getName().equalsIgnoreCase(NetAppFilerType)){                 // If filer from the list matches the selected Filer from the form
                for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){   // Count how many units 
                    for (int ctrlInt=0; ctrlInt < ctrlCount; ctrlInt++){
                        pCount=0;
                        do{
                            netAppFilerDataList.add("NetApp" + "-" + unitInt + " CTRL " + c + " " + filer.getEthernetDataPorts().get(pCount));
                            pCount++;
                        }while (pCount < filer.getEthernetDataPorts().size());
                        
                        pCount=0;
                        do{
                            if(!filer.getFibreDataPorts().get(pCount).equalsIgnoreCase("")){
                                netAppFilerDataList.add("NetApp" + "-" + unitInt + " CTRL " + c + " " + filer.getFibreDataPorts().get(pCount));
                            }
                            pCount++;
                        }while (pCount < filer.getFibreDataPorts().size());
                        c++;
                    }
                    c = 'A';
                }
            }
        }
        
        return netAppFilerDataList;
    }
    
    public ArrayList SASCableList(String NetAppFilerType, String NetAppFilerController, int NetAppFilerCount, int NetAppStackCount, String NetAppShelfType, int NetAppShelfCount){
        
        ArrayList<String> SASCableList = new ArrayList();
        FAS_Define[] netAppFilerList = Components.NetApp_Filer();
        DS_Define[] netAppShelfList = Components.Disk_Shelf();
        Adapter_Define[] netAppAdapter = Components.NetApp_Adapter();

        // Essentially converting Single/Dual Controller to a controller count.
        int ctrlCount = 1;      // Single Controller
        if ("Dual Controller".equals(NetAppFilerController)){
            ctrlCount = 2;      // Dual Controller
        }
        
        int lastShelf = (NetAppShelfCount - 1);
        
        // NetApp Filer Two SAS Port Configuration
        if ((!"FAS2552".equals(NetAppFilerType) || !"FAS2554".equals(NetAppFilerType)) && NetAppStackCount == 1 && this.chkNetAppAdapter.isSelected() == true && ctrlCount == 2 && NetAppShelfCount > 0){
            for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){
                for (FAS_Define filer : netAppFilerList){
                    if (filer.getName().equalsIgnoreCase(NetAppFilerType) && filer.getFSSasPorts().size() == 1 && filer.getLSSasPorts().size() == 1){
                            String shelfFormat = String.format("%02d", lastShelf);
                            SASCableList.add("NetApp-" + unitInt + " CTRL A 0a" + "," + "SHELF 00 IOM A SQ" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL B 0a" + "," + "SHELF 00 IOM B SQ" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL A 0b" + "," + "SHELF " + shelfFormat + " IOM A CIR" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL B 0b" + "," + "SHELF " + shelfFormat + " IOM B CIR" + "," + "," + "SAS" + "\n");
                    }
                }
            }
        }
        
        // NetApp Filer Four SAS Port Configuration
        if ((!"FAS2552".equals(NetAppFilerType) || !"FAS2554".equals(NetAppFilerType)) && NetAppStackCount == 1 && this.chkNetAppAdapter.isSelected() == true && ctrlCount == 2 && NetAppShelfCount > 0){
            for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){
                for (FAS_Define filer : netAppFilerList){
                    if (filer.getName().equalsIgnoreCase(NetAppFilerType) && filer.getFSSasPorts().size() == 2 && filer.getLSSasPorts().size() == 2){
                            String shelfFormat = String.format("%02d", lastShelf);
                            SASCableList.add("NetApp-" + unitInt + " CTRL A 0a" + "," + "SHELF 00 IOM A SQ" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL B 0a" + "," + "SHELF 00 IOM B SQ" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL A 0d" + "," + "SHELF " + shelfFormat + " IOM A CIR" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL B 0d" + "," + "SHELF " + shelfFormat + " IOM B CIR" + "," + "," + "SAS" + "\n");
                    }
                }
            }
        }
        
        // NetApp FAS2552/FAS2554 - Zero Disk Shelf SAS Port Configuration
        if ((!"FAS2552".equals(NetAppFilerType) || !"FAS2554".equals(NetAppFilerType)) && NetAppStackCount == 1 && this.chkNetAppAdapter.isSelected() == true && ctrlCount == 2 && NetAppShelfCount == 0){
            for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){
                for (FAS_Define filer : netAppFilerList){
                    if (filer.getName().equalsIgnoreCase(NetAppFilerType) && filer.getFSSasPorts().size() == 1 && filer.getLSSasPorts().size() == 1){
                            SASCableList.add("NetApp-" + unitInt + " CTRL A 0a" + "," + "NetApp-" + unitInt + " CTRL B 0b" + "," + "," + "SAS" + "\n");
                            SASCableList.add("NetApp-" + unitInt + " CTRL B 0a" + "," + "NetApp-" + unitInt + " CTRL A 0b" + "," + "," + "SAS" + "\n");
                    }
                }
            }
        }
        
        // Create a temp list of the Disk Shelves if there is more than (1) Disk Shelf
        if (NetAppShelfCount > 1){
            ArrayList<String> shelftoshelf = new ArrayList();
            int shelfInt = 0;
            char c = 'A';
            do{
                do{
                String shelfFormat = String.format("%02d", shelfInt);
                shelftoshelf.add("SHELF " + shelfFormat + " IOM " + c + " SQ");
                shelftoshelf.add("SHELF " + shelfFormat + " IOM " + c + " CIR");
                shelfInt++;
                }while(shelfInt < NetAppShelfCount);
                c++;
                shelfInt=0;
            }while(c != 'C');

            
            if (NetAppShelfCount >= 2){
            // Trim the First/Last Shelf Ports - The remove step needs to be in this order to ensure the division is done with even numbers.
            shelftoshelf.remove(0);                                         // Remove Connection to Filer's First Shelf Port
            shelftoshelf.remove(shelftoshelf.size()-1);                     // Remove Connection to Filer's Last Shelf Port
            shelftoshelf.remove((shelftoshelf.size()/2));
            shelftoshelf.remove(((shelftoshelf.size()+1)/2)-1);
            
            }

            // Add Shelf to Shelf list to the SASCableList list. Add the list multiple times dependent on the number of NetApp filers.
            for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){
                Iterator shelfItr = shelftoshelf.iterator();
                do{
                    SASCableList.add(shelfItr.next() + "," + shelfItr.next() + "," + "," + "SAS" + "\n");
                }while (shelfItr.hasNext());
            }
        }

        return SASCableList;
    }
    
    public ArrayList APCCableList(String NetAppFilerType, String NetAppFilerController, int NetAppFilerCount, int NetAppStackCount, String NetAppShelfType, int NetAppShelfCount){
        ArrayList<String> apcCableList = new ArrayList();
                
        // Essentially converting Single/Dual Controller to a controller count.
        int lastShelf = (NetAppShelfCount-1);
        for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){
            if ("Single Controller".equals(NetAppFilerController) && NetAppShelfCount > 0){
                apcCableList.add("NetApp-" + unitInt + " CTRL A " + "e0P" + "," + "SHELF 00 IOM A SQ" + "," + "," + "CAT6" + "\n");
            }else if ("Dual Controller".equals(NetAppFilerController)){
                String shelfFormat = String.format("%02d", lastShelf);
                apcCableList.add("NetApp-" + unitInt + " CTRL A " + "e0P" + "," + "SHELF 00 IOM A SQ" + "," + "," + "CAT6" + "\n");
                apcCableList.add("NetApp-" + unitInt + " CTRL B " + "e0P" + "," + "SHELF " + shelfFormat + " IOM A SQ" + "," + "," + "CAT6" + "\n");
            }
        }
        
        
        
        // Create a temp list of the Disk Shelves if there is more than (1) Disk Shelf
        if (NetAppShelfCount > 1){
            ArrayList<String> shelftoshelf = new ArrayList();
            int shelfInt = 0;
            char c = 'A';
            do{
                do{
                String shelfFormat = String.format("%02d", shelfInt);
                shelftoshelf.add("SHELF " + shelfFormat + " IOM " + c + " SQ");
                shelftoshelf.add("SHELF " + shelfFormat + " IOM " + c + " CIR");
                shelfInt++;
                }while(shelfInt < NetAppShelfCount);
                c++;
                shelfInt=0;
            }while(c != 'C');

            
            if (NetAppShelfCount >= 2){
            // Trim the First/Last Shelf Ports - The remove step needs to be in this order to ensure the division is done with even numbers.
            shelftoshelf.remove(0);                                         // Remove Connection to Filer's First Shelf Port
            shelftoshelf.remove(shelftoshelf.size()-1);                     // Remove Connection to Filer's Last Shelf Port
           
            }

            // Add Shelf to Shelf list to the SASCableList list. Add the list multiple times dependent on the number of NetApp filers.
            for (int unitInt=1; unitInt < (NetAppFilerCount + 1); unitInt++){
                Iterator shelfItr = shelftoshelf.iterator();
                do{
                    apcCableList.add(shelfItr.next() + "," + shelfItr.next() + "," + "," + "CAT6" + "\n");
                }while (shelfItr.hasNext());
            }
        }

        return apcCableList;
    }
    
    public ArrayList BSeriesPowerList(String BSeriesType, int BSeriesCount){
        ArrayList<String> bSeriesPowerList = new ArrayList();
        PDU_Define[] pduList = Components.Power_Distrubtion_Unit();
        
        int pCount = 1;
        char c = 'A';
        for (int dCount = 0; dCount < BSeriesCount; dCount++){
            do{ 
                bSeriesPowerList.add(BSeriesType + "-" + c + " " + "PS" + pCount);
                pCount++;
            }while (pCount < 5);
            c++;
            pCount=1;
        }
        
        return bSeriesPowerList;
    }
    
    public ArrayList CSeriesPowerList(String  CSeriesType, int CSeriesCount){
        ArrayList<String> cSeriesPowerList = new ArrayList();
        Server_Define[] cSeriesComponentPowerList = Components.CSeries_Server();
        
        int pCount=1;
        char c = 'A';
        for (Server_Define cSeriesComponentPowerList1 : cSeriesComponentPowerList) {
            if (cSeriesComponentPowerList1.getName().equalsIgnoreCase(CSeriesType)) {
                for (int dCount = 0; dCount < CSeriesCount; dCount++) {
                    
                    do {
                        cSeriesPowerList.add(CSeriesType.substring(0, 4) + "-" + c + " " + "PS" + pCount);
                        pCount++;
                    } while (pCount < (cSeriesComponentPowerList1.getPowerSupplyCount() + 1));
                    pCount=1;
                    c++;
                }
            }
        }

        return cSeriesPowerList;
    }
    
    public ArrayList FabricPowerList(String FabricType, int FabricCount){
    ArrayList<String> fabricPowerList = new ArrayList();
    FI_Define[] fabricDefineList = Components.Fabric_Interconnect();
    int pCount = 1;
    char c = 'A';
    
        for (FI_Define fabric : fabricDefineList) {
            if (fabric.getName().equalsIgnoreCase(FabricType)) {
                for (int dCount = 0; dCount < FabricCount; dCount++){
                    do{
                        fabricPowerList.add("Fabric" + "-" + c + " " + "PS" + pCount);
                        pCount++;
                    }while(pCount < 3);
                    pCount=1;
                    c++;
                }
            }
        }
    
    
    return fabricPowerList;
    }
    
    public ArrayList NexusPowerList(String NexusType, int NexusCount){
        ArrayList<String> nexusPowerList = new ArrayList();
        Nexus_Define[] nexusDefineList = Components.Nexus_Switch();
        
        int pCount = 1;
        char c = 'A';
        
        for (Nexus_Define nexus : nexusDefineList) {
            if (nexus.getName().equalsIgnoreCase(NexusType)) {
                for(int dCount = 0; dCount < NexusCount; dCount++){
                    do{
                        nexusPowerList.add("Nexus" + "-" + c + " " + "PS" + pCount);
                        pCount++;
                    }while(pCount < 3);
                    pCount=1;
                    c++;
                }
            }
        }
        
        return nexusPowerList;
    }
    
    public ArrayList NetAppFilerPowerList(String NetAppFilerType, int NetAppFilerCount){
        ArrayList<String> netAppFilerPowerList = new ArrayList();
        int pCount = 1;
        int s = 1;
        
        for (int dCount=0; dCount < NetAppFilerCount; dCount++){
            do{
                netAppFilerPowerList.add("NetApp" + "-" + s + " " + "PS" + pCount);
                pCount++;
            }while(pCount < 3);
            pCount=1;
            s++;
        }

        return netAppFilerPowerList;
    }
    
    public ArrayList NetAppShelfPowerList(String NetAppShelfType, int NetAppShelfCount){
        ArrayList<String> netAppShelfPowerList = new ArrayList();
        int pCount = 1;
        int s = 0;
        
        for (int dCount=0; dCount < NetAppShelfCount; dCount++){
            String shelfFormat = String.format("%02d", s);
            do{
                netAppShelfPowerList.add("Shelf" + ":" + shelfFormat + " " + "PS" + pCount);
                pCount++;
            }while(pCount < 3);
            pCount = 1;
            s++;
        }
        
        return netAppShelfPowerList;
    }
    
    public ArrayList FabricNexusVPCList(String FabricType, int FabricCount, String FabricModule, String NexusType, int NexusCount, int FINexusUplink){
        ArrayList<String> FabricNexusvPCList = new ArrayList();
        ArrayList fabricList = FabricDataList(FabricType, FabricCount);
        ArrayList nexusList = NexusDataList (NexusType, NexusCount);

        int fabricAvPCStart = 0;
        int fabricBvPCStart = 0;
        int nexusAvPCStart = 0;
        int nexusBvPCStart = 0;
        int i=0;
        
        // Finding the starting index for Fabric Interconnects
        for (FI_Define fabric : Components.Fabric_Interconnect()){
            if (fabric.getName().equalsIgnoreCase(FabricType)){
                do{
                    if (fabricList.get(i).equals("Fabric-A Eth1/19")){
                        fabricAvPCStart = i;
                    }
                    if (fabricList.get(i).equals("Fabric-B Eth1/19")){
                        fabricBvPCStart = i;
                    }
                    i++;
                }while (i < fabricList.size());
            }
        }    
        i=0;
        // Finding the starting index for Nexus Switches
        for (Nexus_Define nexus : Components.Nexus_Switch()){
            if (nexus.getName().equalsIgnoreCase(NexusType)){
                do{
                    if (nexusList.get(i).equals("Nexus-A Eth1/11")){
                        nexusAvPCStart = i;
                    }
                    if (nexusList.get(i).equals("Nexus-B Eth1/11")){
                        nexusBvPCStart = i;
                    }
                    i++;
                }while (i < nexusList.size());
            }
        }    
        
        // Assigning Uplink Connections - Fabric A to Nexus Switches
        for (int uplinkCount = 0; uplinkCount < (FINexusUplink /4); uplinkCount++){

            FabricNexusvPCList.add(fabricList.get(fabricAvPCStart) + "," + nexusList.get(nexusAvPCStart) + "\n");

            fabricList.remove(fabricAvPCStart);

            FabricNexusvPCList.add(fabricList.get(fabricAvPCStart) + "," + nexusList.get(nexusBvPCStart) + "\n");

            fabricList.remove(fabricAvPCStart);
            nexusList.remove(nexusAvPCStart);
        }
        i=0;
        // Finding the starting index for Fabric Interconnects
        for (FI_Define fabric : Components.Fabric_Interconnect()){
            if (fabric.getName().equalsIgnoreCase(FabricType)){
                do{
                    if (fabricList.get(i).equals("Fabric-A Eth1/19")){
                        fabricAvPCStart = i;
                    }
                    if (fabricList.get(i).equals("Fabric-B Eth1/19")){
                        fabricBvPCStart = i;
                    }
                    i++;
                }while (i < fabricList.size());
            }
        }    
        
        // Assigning Uplink Connections - Fabric B to Nexus Switches
        for (int uplinkCount = 0; uplinkCount < (FINexusUplink /4); uplinkCount++){

            FabricNexusvPCList.add(fabricList.get(fabricBvPCStart) + "," + nexusList.get(nexusAvPCStart) + "\n");

            fabricList.remove(fabricBvPCStart);

            FabricNexusvPCList.add(fabricList.get(fabricBvPCStart) + "," + nexusList.get(nexusBvPCStart) + "\n");

            fabricList.remove(fabricBvPCStart);
            nexusList.remove(nexusAvPCStart);
        }

        return FabricNexusvPCList;
    }
    
    public ArrayList NexustoNexusList(String NexusType, int NexusCount){
        ArrayList<String> NexustoNexusList = new ArrayList();
        
        for (Nexus_Define nexus: Components.Nexus_Switch()){
            if (nexus.getName().equalsIgnoreCase(NexusType)){
                int port = nexus.getNexusStartingPort();
                for (int i = 0; i < 2; i++){
                    NexustoNexusList.add("Nexus-A Eth1/" + port + "," + "Nexus-B Eth1/" + port + "\n");
                    port++;
                }
            }
        }
        
        return NexustoNexusList;
    }
    
    public ArrayList powerList(String BSeriesType, int BSeriesCount, String  CSeriesType, int CSeriesCount, String NexusType, int NexusCount, String FabricType, 
            int FabricCount,String NetAppFilerType, int NetAppFilerCount, String NetAppShelfType, int NetAppShelfCount,String PDU1Type,int PDU1Count,String PDU2Type,int PDU2Count){
        ArrayList<String> powerList = new ArrayList();

        // Create Lists for each device -- Hell of a lot easier to manage then lines of complex code assigning avaiable PDU plugs to devices.
        ArrayList<String> PDU1C19List = new ArrayList();
        ArrayList<String> PDU2C19List = new ArrayList();
        ArrayList<String> PDU3C19List = new ArrayList();
        ArrayList<String> PDU4C19List = new ArrayList();
        
        ArrayList<String> PDU1C13List = new ArrayList();
        ArrayList<String> PDU2C13List = new ArrayList();
        ArrayList<String> PDU3C13List = new ArrayList();
        ArrayList<String> PDU4C13List = new ArrayList();
        
        ArrayList<String> BSeriesList = BSeriesPowerList(BSeriesType, BSeriesCount);
        ArrayList<String> CSeriesList = CSeriesPowerList(CSeriesType, CSeriesCount);
        ArrayList<String> NexusList = NexusPowerList(NexusType, NexusCount);
        ArrayList<String> FabricList = FabricPowerList(FabricType, FabricCount);
        
        ArrayList<String> NetAppFilerList = NetAppFilerPowerList(NetAppFilerType, NetAppFilerCount);
        ArrayList<String> NetAppShelfList = NetAppShelfPowerList(NetAppShelfType, NetAppShelfCount);
        
        
        for (PDU_Define pdu : Components.Power_Distrubtion_Unit()){
            // Internal PDU (PDU 3 & 4) List
            if ((pdu.getName().equalsIgnoreCase(PDU1Type) || pdu.getName().equalsIgnoreCase(PDU2Type)) && pdu.getUSpace() == 1){
                for (int i = 0; i < pdu.getC19Count();i++){
                    PDU3C19List.add("PDU 3");
                    PDU4C19List.add("PDU 4");
                }
                for (int i = 0; i < pdu.getC13Count();i++){
                    PDU3C13List.add("PDU 3");
                    PDU4C13List.add("PDU 4");
                }
            }
            // External PDU (PDU 1 & 2) List
            if ((pdu.getName().equalsIgnoreCase(PDU1Type) || pdu.getName().equalsIgnoreCase(PDU2Type)) && pdu.getUSpace() == 0){
                for (int i = 0; i < pdu.getC19Count();i++){
                    PDU1C19List.add("PDU 1");
                    PDU2C19List.add("PDU 2");
                }
                for (int i = 0; i < pdu.getC13Count();i++){
                    PDU1C13List.add("PDU 1");
                    PDU2C13List.add("PDU 2");
                }
            }
        }
        
        // B-Series List       
        // PDU 3 & 4 Assignemnet (If Applicable)
        if (!PDU3C19List.isEmpty()){
            for (int i = 1; i < BSeriesCount+1;i++){ // Loop through the list based on the number of B-Series Chassis
                if ( i <= 2){
                powerList.add(BSeriesList.get(0) + "," + PDU4C19List.get(0) + "\n");
                BSeriesList.remove(0);
                PDU4C19List.remove(0);
                powerList.add(BSeriesList.get(0) + "," + PDU4C19List.get(0) + "\n");
                BSeriesList.remove(0);
                PDU4C19List.remove(0);
                powerList.add(BSeriesList.get(0) + "," + PDU3C19List.get(0) + "\n");
                BSeriesList.remove(0);
                PDU3C19List.remove(0);
                powerList.add(BSeriesList.get(0) + "," + PDU3C19List.get(0) + "\n");
                BSeriesList.remove(0);
                PDU3C19List.remove(0);
                }
                if (i > 2){
                    powerList.add(BSeriesList.get(0) + "," + PDU2C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU2C19List.remove(0);
                    powerList.add(BSeriesList.get(0) + "," + PDU2C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU2C19List.remove(0);
                    powerList.add(BSeriesList.get(0) + "," + PDU1C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU1C19List.remove(0);
                    powerList.add(BSeriesList.get(0) + "," + PDU1C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU1C19List.remove(0);
                }
            }
        }else if (PDU3C19List.isEmpty()){
            for (int i = 1; i < BSeriesCount+1;i++){ // Loop through the list based on the number of B-Series Chassis
                if ( i <= 2){
                    powerList.add(BSeriesList.get(0) + "," + PDU2C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU2C19List.remove(0);
                    powerList.add(BSeriesList.get(0) + "," + PDU2C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU2C19List.remove(0);
                    powerList.add(BSeriesList.get(0) + "," + PDU1C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU1C19List.remove(0);
                    powerList.add(BSeriesList.get(0) + "," + PDU1C19List.get(0) + "\n");
                    BSeriesList.remove(0);
                    PDU1C19List.remove(0);
                }
            }
        }
        // C-Series List
        for(int assignCount = 0; assignCount < CSeriesCount; assignCount++){
            do{
            powerList.add(CSeriesList.get(0) + "," + PDU1C13List.get(0) + "\n");
            CSeriesList.remove(0);
            PDU1C13List.remove(0);
            powerList.add(CSeriesList.get(0) + "," + PDU2C13List.get(0) + "\n");
            CSeriesList.remove(0);
            PDU2C13List.remove(0);
            }while (CSeriesList.size() == -1);
        }

        // Nexus Switch List
        for(int assignCount = 0; assignCount < NexusCount; assignCount++){
            powerList.add(NexusList.get(0) + "," + PDU1C13List.get(0) + "\n");
            NexusList.remove(0);
            PDU1C13List.remove(0);
            powerList.add(NexusList.get(0) + "," + PDU2C13List.get(0) + "\n");
            NexusList.remove(0);
            PDU2C13List.remove(0);
        }
        
        // Fabric Interconnect List
        for(int assignCount = 0; assignCount < FabricCount; assignCount++){
            do{
            powerList.add(FabricList.get(0) + "," + PDU1C13List.get(0) + "\n");
            FabricList.remove(0);
            PDU1C13List.remove(0);
            powerList.add(FabricList.get(0) + "," + PDU2C13List.get(0) + "\n");
            FabricList.remove(0);
            PDU2C13List.remove(0);
            }while (FabricList.size() == -1);
        }
        
        // NetApp Filer List
        for(int assignCount = 0; assignCount < NetAppFilerCount; assignCount++){
            do{
            powerList.add(NetAppFilerList.get(0) + "," + PDU1C13List.get(0) + "\n");
            NetAppFilerList.remove(0);
            PDU1C13List.remove(0);
            powerList.add(NetAppFilerList.get(0) + "," + PDU2C13List.get(0) + "\n");
            NetAppFilerList.remove(0);
            PDU2C13List.remove(0);
            }while (NetAppFilerList.size() == -1);
        }
        
        // NetApp Shelf List
        for(int assignCount = 0; assignCount < NetAppShelfCount; assignCount++){
            do{
            powerList.add(NetAppShelfList.get(0) + "," + PDU1C13List.get(0) + "\n");
            NetAppShelfList.remove(0);
            PDU1C13List.remove(0);
            powerList.add(NetAppShelfList.get(0) + "," + PDU2C13List.get(0) + "\n");
            NetAppShelfList.remove(0);
            PDU2C13List.remove(0);
            }while (NetAppShelfList.size() == -1);
        }
        
        return powerList;
    }
}
