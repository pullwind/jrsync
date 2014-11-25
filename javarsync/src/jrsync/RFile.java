/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class RFile {
    String filename;
    //"host.txt"
    
    public RFile(String filename) {
        this.filename = filename;
    }
    
    
    
    ObjectInputStream inputStream;
    
    public void openFile(){
        try {
            inputStream = new ObjectInputStream(new FileInputStream(filename));
        } catch (IOException ex) {
            Logger.getLogger(RFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  Object readFile(){
        try {
            return inputStream.readObject();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(RFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
    
    public void closeFile(){
        try {
            inputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(RFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
