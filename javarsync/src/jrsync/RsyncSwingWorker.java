/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.File;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;


/**
 *
 * @author Administrator
 */
public class RsyncSwingWorker extends SwingWorker<Object, Object>{
    private JTextArea cmdlog;
    private ArrayList<String> cmdlist;
    private Calendar tStart;
    private Calendar tEnd;
    private Host host;
    
    
    
    public RsyncSwingWorker(JTextArea showtxt, ArrayList<String> cmdlist, Host host ) {
        cmdlog = showtxt;       
        this.cmdlist = cmdlist;
        this.host = host;
        
    }

    
    
    @Override
    protected Object doInBackground() throws Exception {
        tStart = Calendar.getInstance();
     
        try {          
            
             ProcessBuilder pb = new ProcessBuilder(this.cmdlist);            
           
             //之前用的
          // pb.redirectError(Redirect.INHERIT);
          // pb.redirectInput(Redirect.INHERIT);
          // pb.redirectOutput(Redirect.INHERIT);
           
            //pbProc.re
          //  File log = new File("log.txt");
          //  pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
            Process p =  pb.start();
            // set host process
            host.setProcess(p);
            //hosts.get(selectRow).setHostProcess(p);
          //  PrintStream ps = null;
            //  System.setOut(ps);
         
            //Thread for get inputStream.
            InputStream errin = p.getErrorStream();
            StreamDrainer errsd = new StreamDrainer(p,errin);            
            Thread terr = new Thread(errsd);
            terr.start();   
            
            InputStream ins = p.getInputStream();
            StreamDrainer sd = new StreamDrainer(p,ins);                 
            Thread tin= new Thread(sd);
            tin.start();
            
             return  p.waitFor();
           
           // p.
          // assert pb.redirectInput() == Redirect.PIPE;
          //  assert pb.redirectOutput().file() == log;
           // assert p.getInputStream().read() == -1;
            
            
            
            /*
             //转换为相对时间
                   long t1 = c1.getTimeInMillis();
                   long t2 = c2.getTimeInMillis();
                   //计算天数
                   long days = (t2 - t1)/(24 * 60 * 60 * 1000);
            */
            
            /* old  runTask 
            runTask rtask = new runTask(rsyncLog, al1);
            ExecutorService threadExecutor = Executors.newCachedThreadPool();
            threadExecutor.execute(rtask);
            // add to cmdlog
            cmdLog.append(nowhost.getOriginalString());
           // threadExecutor.
            */
        } catch (Exception e) {
            cmdlog.append(e.toString());
        }
        
        
        return 0 ;
               
    }

    @Override
    protected void done() {
        try {
            cmdlog.append("exit code: " + this.get().toString() + " \n");
            tEnd = Calendar.getInstance();
            //cEnd = (Calendar) future.get();
            long t1 = tStart.getTimeInMillis();
            long t2 = tEnd.getTimeInMillis();
            long sec = (t2 -t1)/1000;
            long hour = (t2 -t1)/(60*60*1000);
            cmdlog.append("用时: " + String.valueOf(hour) + "\n");
            cmdlog.append("用秒: " + String.valueOf(sec) + "\n");
            
            // next
          //  MJFrame.mjframe.ishasNext();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(RsyncSwingWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ExecutionException ex) {
            Logger.getLogger(RsyncSwingWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
