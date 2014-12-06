/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class StreamDrainer implements Runnable{
    private InputStream is;
    private Process p;

    public StreamDrainer(Process p, InputStream is) {
        this.is = is;
        this.p = p;
    }
    
    
    
    @Override
    public void run() {
        try {
            //thow new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //BufferedReader br = new BufferedReader(new InputStreamReader(is,"GBK"));
             BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line =null;
            while(p.isAlive()){
                
                try{
                     while((line = br.readLine()) != null ){
                    System.out.println(line);
                    }
                }catch(IOException io){
                   
                }finally{
                    try {
                        is.close();
                         } catch (IOException ex) {
                        Logger.getLogger(StreamDrainer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
                
            }
           
         
        }finally{
            try {
                is.close();
            } catch (IOException ex) {
                Logger.getLogger(StreamDrainer.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        
        
    }
    
}
