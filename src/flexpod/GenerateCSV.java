/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flexpod;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Karl
 */
public class GenerateCSV extends Validation {
    public static void main (String[] args){

    }
    public void generateCsvFile(String sFileName){
        try
        {
            FileWriter writer = new FileWriter(sFileName);
            //Create Header - To & From
            writer.append("Line 1");
            writer.append(',');
            writer.append("Line 2");
            writer.append(',');
            writer.append("Length");
            writer.append(',');
            writer.append("Port Type");
            writer.append('\n');

            // Add Generated Point to Point based on interface
            int i = 0;
            do {
                writer.append(Validation.getMasterList().get(i).toString());
                i++;
            }while (i < Validation.getMasterList().size());
      
            writer.flush();
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}