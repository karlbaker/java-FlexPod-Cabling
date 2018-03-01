/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 028861
 */
public class SwitchModule_Define {
    String name;
    String portType;
    int portCount;
    private List<String> supportedSwitch;
    
    public SwitchModule_Define(String cName, String cPortType, int cPortCount, ArrayList<String> cSupportedSwitch){
    this.name = cName;
    this.portType = cPortType;
    this.portCount = cPortCount;
    this.supportedSwitch = cSupportedSwitch;
    
    }
    
    
    
}
