/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Arrays;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author 028861
 */
public class Validation extends main {

    private static ArrayList list;
    private static String salesOrder;
    
    private static String BSeriesType;
    private static int BSeriesCount;
    private static String FabricExtender;
    private static String CSeriesType;
    private static int CSeriesCount;
    private static boolean CSeriesFI;
    private static String CSeriesSlot; 
    private static String CSeriesAdapterType; 
    private static int CSeriesPortCount; 
    private static String FabricType; 
    private static int FabricCount; 
    private static String FabricModule; 
    private static String NexusType; 
    private static int NexusCount;
    private static int FINexusUplink; 
    private static int FIIOMUplink; 
    private static String ProtocolType; 
    private static String NetAppFilerType; 
    private static String NetAppFilerController;
    private static int NetAppFilerCount;
    private static String NetAppClusterType;
    private static boolean SSDShelfCheck; 
    private static int NetAppStackCount; 
    private static String NetAppShelfType;
    private static int NetAppShelfCount; 
    private static String PDU1Type; 
    private static int PDU1Count; 
    private static String PDU2Type; 
    private static int PDU2Count;
    
    
    private int i = 0;
    
    public static void main(String[] args) {
    }
    //Create variables for all items on form
    public void Validation(String salesOrder, String BSeriesType, int BSeriesCount, String FabricExtender, String  CSeriesType, int CSeriesCount, boolean CSeriesFI,
            String CSeriesSlot, String CSeriesAdapterType, int CSeriesPortCount, String FabricType, int FabricCount, String FabricModule, String NexusType, int NexusCount,
            int FINexusUplink, int FIIOMUplink, String ProtocolType, String NetAppFilerType, String NetAppFilerController, int NetAppFilerCount, String NetAppClusterType,
            boolean SSDShelfCheck, int NetAppStackCount, String NetAppShelfType, int NetAppShelfCount, String PDU1Type, int PDU1Count, String PDU2Type, int PDU2Count){
        
        Validation.salesOrder =salesOrder;
        Validation.BSeriesType =BSeriesType;
        Validation.BSeriesCount =BSeriesCount;
        Validation.FabricExtender =FabricExtender;
        Validation.CSeriesType =CSeriesType;
        Validation.CSeriesCount =CSeriesCount;
        Validation.CSeriesFI =CSeriesFI;
        Validation.CSeriesSlot  =CSeriesSlot ;
        Validation.CSeriesAdapterType  =CSeriesAdapterType ;
        Validation.CSeriesPortCount  =CSeriesPortCount ;
        Validation.FabricType  =FabricType ;
        Validation.FabricCount  =FabricCount ;
        Validation.FabricModule  =FabricModule ;
        Validation.NexusType  =NexusType ;
        Validation.NexusCount =NexusCount;
        Validation.FINexusUplink  =FINexusUplink ;
        Validation.FIIOMUplink  =FIIOMUplink ;
        Validation.ProtocolType  =ProtocolType ;
        Validation.NetAppFilerType  =NetAppFilerType ;
        Validation.NetAppFilerController =NetAppFilerController;
        Validation.NetAppFilerCount =NetAppFilerCount;
        Validation.NetAppClusterType =NetAppClusterType;
        Validation.SSDShelfCheck  =SSDShelfCheck ;
        Validation.NetAppStackCount  =NetAppStackCount ;
        Validation.NetAppShelfType =NetAppShelfType;
        Validation.NetAppShelfCount  =NetAppShelfCount ;
        Validation.PDU1Type  =PDU1Type ;
        Validation.PDU1Count  =PDU1Count ;
        Validation.PDU2Type  =PDU2Type ;
        Validation.PDU2Count =PDU2Count;
        
        
        
        
        // List of Components; NetApp Filer, Nexus Switches, Fabric Interconnects
        Components f = new Components();
        f.NetApp_Filer();
        Components n = new Components();
        n.NetApp_Filer();

        
    // Verify the SO textbox field is filled in.
        if ((salesOrder.isEmpty() || salesOrder.trim().equals("")) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Please fill in a valid sales order number.", "Missing SO Number", JOptionPane.ERROR_MESSAGE);
            i++;
            
        }
        
    // Verify B-Series or C-Series options are selected
        if ((BSeriesType.equalsIgnoreCase("None") && CSeriesType.equalsIgnoreCase("None")) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a Cisco Compute Type.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }    
        
    // Validate the B Series Compute Section
        ValidateBSeriesCompute(BSeriesType, BSeriesCount, FabricExtender, CSeriesFI, FabricType, FabricCount);
    
    // Validate the C Series Compute Section    
        ValidateCSeriesCompute(CSeriesType, CSeriesCount, CSeriesFI, CSeriesSlot, CSeriesAdapterType, CSeriesPortCount);
        if (CSeriesFI == true && FabricType.equalsIgnoreCase("UCS 6324") && CSeriesCount > 4){
            JOptionPane.showMessageDialog(new JFrame(),"Too many C-Series servers are selected for this type of Fabric Interconnect.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
    // Verify selected Nexus switch
        if ((NexusType.equalsIgnoreCase("None") || NexusCount == 0) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a valid Nexus Switch Configuration. Double check what is selected.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
       }

    // Validate the FI to Nexus Uplinks
        if ((!FabricType.equalsIgnoreCase("None") && FINexusUplink == 0) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a number of Uplinks between the Nexus Switch and Fabric Interconnect.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
       }
        
    // Validate the FI to IOM Uplinks
        if ((BSeriesCount > 0 && (FIIOMUplink == 0 && !FabricType.equalsIgnoreCase("UCS 6324"))) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a number of Uplinks between the B-Series IOM to Fabric Interconnect.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
       }
        
    // Verify the Protocol is compatible with the NetApp Filer.
        if(true){
            ValidateProtocolCompatiblity(f.NetApp_Filer(), NetAppFilerType, ProtocolType);
        }
    
    // Verify the NetApp filer is compatiable with the Disk Storage unit.
        if(true){
        ValidateFilerDiskShelfCompatiblity(f.NetApp_Filer(), NetAppFilerType, NetAppShelfType);
        }
    
    // Validate a Cluster Switch Type is selected.
        if ((NetAppClusterType.equalsIgnoreCase("None")) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a Cluster Switch Type..", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
       }
        
 
    // Verify if there is there is a a solid state disk storage unit on the order then the maximum of (4) disk shelves is supported per stack.
        if ((SSDShelfCheck = true && NetAppShelfCount > 5) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"The maximum number of shelves that has an SSD shelf is 4.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
    System.out.println("This is the value for i: " + i);
    
    // Verify the PDU information is filled out
        if ( PDU1Type.equalsIgnoreCase("None") || PDU1Count == 0 && i == 0 ){
            JOptionPane.showMessageDialog(new JFrame(),"Please select a PDU for the solution.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
    
    
    
    /************************
    Execute Save DialogBox
    ************************/
    if (i == 0) {
        ExecuteSaveDialogBox(salesOrder);
            }
    }
    
    public void ValidateBSeriesCompute(String BSeriesType, int BSeriesCount, String FabricExtender, boolean CSeriesFI, String FabricType, int FabricCount){
    // Verify B-Series Chassis Type is valid
        if (((!BSeriesType.equalsIgnoreCase("None")) && BSeriesCount == 0) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Adjust the B-Series Chassis quantity.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
    // Verify B-Series Chassis has either a FEX or UCS 6234 on the order.
        if ((FabricExtender.equalsIgnoreCase("None") && !FabricType.equalsIgnoreCase("UCS 6324") && !BSeriesType.equalsIgnoreCase("None")) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a valid B-Series FEX Module or B-Series Chassis Fabric Interconnect", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
   
    // Verify selected FI adapter(s) is compatible with the selected FI.
       if (((FabricType.equalsIgnoreCase("None") && FabricCount >= 0) && (BSeriesCount > 0 || CSeriesFI == true)) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a valid Fabric Interconnect Configuration. Double check what is selected.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
       }
    
    }
    
    public void ValidateCSeriesCompute(String  CSeriesType, int CSeriesCount, boolean CSeriesFI, String CSeriesSlot, String CSeriesAdapterType, int CSeriesPortCount){
    // Verify the selected C-Series equipment
        if (((!CSeriesType.equalsIgnoreCase("None") && CSeriesCount == 0)) && i == 0){
            JOptionPane.showMessageDialog(new JFrame(),"Select a valid C-Series Configuration. Double check what is selected.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
    // Verify C-Series Adapter
        if ((!CSeriesType.equalsIgnoreCase("None") && (CSeriesSlot.equalsIgnoreCase("None") || CSeriesAdapterType.equalsIgnoreCase("None") || CSeriesPortCount == 0)) && i == 0){
        JOptionPane.showMessageDialog(new JFrame(),"Select a valid C-Series Adapter.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
            i++;
        }
    }
    
    public void ValidateProtocolCompatiblity(FAS_Define[] faslist, String NetAppFilerType, String ProtocolType){
    // Verify the NetApp Filer can be found in the list.
        List<String> fasNameList = new ArrayList<>();
        
        for (int index=0; index < faslist.length ;index++){
            fasNameList.add(faslist[index].getName());
        }
        if (fasNameList.contains(NetAppFilerType)){

        }else if (i==0){
        JOptionPane.showMessageDialog(new JFrame(),"Unable to find NetApp filer. Verify you have selected a NetApp filer.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
        i++;
        }
             
    //Verify the NetApp Filer is compatible with the selected Protcol
        List<String> fasProtocolList = new ArrayList<>();
      
        for (int index=0; index < faslist.length;index++){
            if (faslist[index].getName().equals(NetAppFilerType)){
                fasProtocolList.addAll(faslist[index].getSupportedProtocol());
                break;
            }
        for (int j=0; j < faslist[index].getSupportedProtocol().size();j++){       //LOCATION OF FAILURE - getSupportedProtocol is not pull correct size
            fasProtocolList.addAll(faslist[index].getSupportedProtocol());
        }
        }

        Iterator<String> it = fasProtocolList.iterator();
        while (it.hasNext()){
            if (it.next().contains(ProtocolType)){
                break;
            }
            else if (i==0){
                JOptionPane.showMessageDialog(new JFrame(),"The protocol isn't supported by the selected NetApp filer.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
                i++;
                break;
            }
        }
    }
    
    public void ValidateFilerDiskShelfCompatiblity(FAS_Define[] faslist, String NetAppFilerType, String NetAppShelfType){
        // Verify the NetApp Filer can be found in the list.
        List<String> fasNameList = new ArrayList<>();
        
        for (int index=0; index < faslist.length ;index++){
            fasNameList.add(faslist[index].getName());
        }
             
        //Verify the NetApp Filer is compatible with the selected Disk Shelf
        List<String> fasProtocolList = new ArrayList<>();
      
        for (int index=0; index < faslist.length;index++){
            if (faslist[index].getName().equals(NetAppFilerType)){
                fasProtocolList.addAll(faslist[index].getSupportedDiskShelf());
                break;
            }
        for (int j=0; j < faslist[index].getSupportedDiskShelf().size();j++){       //LOCATION OF FAILURE - getSupportedProtocol is not pull correct size
            fasProtocolList.addAll(faslist[index].getSupportedDiskShelf());
        }
        }

        Iterator<String> it = fasProtocolList.iterator();
        while (it.hasNext()){
            if (it.next().contains(NetAppShelfType)){
                break;
            }
            else if (!NetAppFilerType.equalsIgnoreCase("FAS2552") && i==0){
                JOptionPane.showMessageDialog(new JFrame(),"The NetApp filer isn't compatible with the selected disk shelf.", "Incompatible Configuration", JOptionPane.ERROR_MESSAGE);
                i++;
                break;
            }
        }
    }
    
    public void ExecuteSaveDialogBox(String salesOrder){
        File Filename = new File(salesOrder);
            JFileChooser filesave = new JFileChooser();
            
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Separated Values(*.csv)", "csv");
            filesave.setFileFilter(filter);
            filesave.setSelectedFile(Filename);
            GenerateCSV csvfile = new GenerateCSV();
            int returnVal = filesave.showSaveDialog(Validation.this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = filesave.getSelectedFile();
                csvfile.generateCsvFile(file.toString() + ".csv"); // This is name of the file that the program will save. The extension is automatically added.
            }
    
    }

    public static ArrayList getMasterList(){
    
        list = new PortMap().MasterPortMap(salesOrder, BSeriesType, BSeriesCount, FabricExtender, CSeriesType, CSeriesCount, CSeriesFI,
                        CSeriesSlot, CSeriesAdapterType, CSeriesPortCount, FabricType, FabricCount, FabricModule, NexusType, NexusCount,
                        FINexusUplink, FIIOMUplink, ProtocolType, NetAppFilerType, NetAppFilerController, NetAppFilerCount, NetAppClusterType,
                        SSDShelfCheck, NetAppStackCount, NetAppShelfType, NetAppShelfCount, PDU1Type, PDU1Count, PDU2Type, PDU2Count);
        
        return list;
    }
}