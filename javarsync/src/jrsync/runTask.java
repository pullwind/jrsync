package jrsync;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class runTask implements Runnable {
    final JTextArea rLog;
    String line;
    ArrayList cmdlist;
    
    public runTask(JTextArea rLog, ArrayList<String> alist) {
        this.rLog = rLog;
        cmdlist = alist;
    }
    
    
    @Override
    public void run() {
        
        try {
            //processBuilder
            /*
            String[] rcmd = new String[]{
                "rsync", "-a","--progress","--delete",
                "root@192.168.0.250:/home",
                "/data1/250"
            };    
            */
            /*
            // -r前面有空格， 导致运行时 exitValue:1  , 不能正常运行
            // -r没空格， 则 exitValue:23  ， 可以运行
            String[] rcmd = new String[]{
            "rsync", " -r", "root@192.168.0.250:/home","/data1/250"
            };
            */
            ProcessBuilder processBuilder = new ProcessBuilder(cmdlist);            
            
            // rcmdstr.setText(processBuilder.toString());
            
            processBuilder.redirectErrorStream(true);
            //pbProc.re
            Process proc =  processBuilder.start();
            
            // process
            //is, isr, br
            InputStream is = proc.getInputStream();
            
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader all; 
            all = new BufferedReader(isr);
            //all = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            
            //String strErr = null;           
            
            while((line = all.readLine()) != null){
                     rLog.append(line + "\n");
                     /*
                     //重复生成行
                SwingUtilities.invokeLater(new Runnable(){                    
                    @Override
                    public void run() {
                        //update ui
                       // rLog.append(line);                        
                        rLog.append(line + "\n");
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                    
                });       
                             */
                
            }
            
            all.close();
            rLog.append("exitValue: " + proc.waitFor());
            
            
           // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(runTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(runTask.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
