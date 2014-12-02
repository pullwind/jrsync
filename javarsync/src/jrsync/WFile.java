/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class WFile {
    String filename;
    ObjectOutputStream outputStream;

    public WFile(String filename) {
        this.filename = filename;
    }
    
    
    
    public void openFile(){
        
        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(filename));
        } catch (IOException ex) {
            Logger.getLogger(WFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void WtoFile(Object o){
        try {
            outputStream.writeObject(o);
            
        } catch (IOException ex) {
            Logger.getLogger(WFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void closeFile(){
        
        if(outputStream != null){
            try {
                //outputStream.
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(WFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
