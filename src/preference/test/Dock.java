/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preference.test;

import java.io.* ;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Zbz
 */
public class Dock {
    
    DockFrame dockFrame;
    Map<String, List<String>> words = new HashMap<String, List<String>>(); //filename, words in it
    
    public Dock(){
        dockFrame = new DockFrame(this);
        dockFrame.show();
    }
    
    //Load the words from a text file and pass it into the DockFrame class to be displayed
    public void load(String address, String name){ 
        
        // The name of the file to open.
        String fileName = address;

        // This will reference one line at a time
        String line = null;
        List<String> lines = new ArrayList<>();

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = 
                new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        dockFrame.displayItems(name);
        words.put(name, lines);
        
    }
    
    //Start the test
    public void start(String item0, String item1){
        
        if(dockFrame.getSelectedItem().equals("error")){
            return;
        }
        
        List<String> words = this.words.get(dockFrame.getSelectedItem());
        
        List<String> goodWords = new ArrayList<>();
        List<String> badWords = new ArrayList<>();
        
        boolean goodBadBoundaryFlag = false;
        int indexBoundary = 0;
        
        for(int i = 0; i < words.size(); i++){
            
            if(words.get(i).contains("-----")){
                goodBadBoundaryFlag = true;
                indexBoundary = i;
                continue;
            }
            
            if(goodBadBoundaryFlag == false){
                goodWords.add(words.get(i));
            }
            else{
                badWords.add(words.get(i));
            }
            
        }
        
        words.remove(indexBoundary);
        
        Test test = new Test(item0, item1, words.toArray(new String[0]), goodWords.toArray(new String[goodWords.size()]), badWords.toArray(new String[badWords.size()]));
        
    }
    
}
