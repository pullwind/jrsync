/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Callable;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class Call implements Callable<Object>{
     
    final JTextArea rLog;
    String line;
    ArrayList<String> cmdlist;

    public Call(JTextArea rLog, ArrayList<String> cmdlist) {
        this.rLog = rLog;        
        this.cmdlist = cmdlist;
    }
    
    
    
    @Override
    public Object call() throws Exception {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
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
            ProcessBuilder pb = new ProcessBuilder(cmdlist);            
            
            // rcmdstr.setText(processBuilder.toString());
            
            pb.redirectErrorStream(true);
            //pbProc.re
            File log = new File("log.txt");
            pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
            
            Process p =  pb.start();
            
            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == log;
            assert p.getInputStream().read() == -1;
            
           /*
                    
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
                          
                
            }
            
            all.close();
            
            */
            rLog.append("exitValue: " + p.waitFor() + "\n");
            
            Calendar calendar = Calendar.getInstance();
        
            // return 
        return (calendar);
    }
    
    
}
