/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;


/**
 *
 * @author Administrator
 */
public class MyRunnable implements Runnable{
    private ArrayList<String> cmdlist;
    private Calendar tStart;
   // private Calendar tEnd;
    private Host host;

    public MyRunnable(ArrayList<String> cmdlist, Host host) {
        this.cmdlist = cmdlist;
        this.host = host;
    }
    
    
    
    @Override
    public void run() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         tStart = Calendar.getInstance();     
        try {     
            
            //System.out.println("Create PorcessBuilder : " );
             ProcessBuilder pb = new ProcessBuilder(this.cmdlist);  
            String s="";
             for(int i=0; i< this.cmdlist.size(); i++){
                 s+= ( this.cmdlist.get(i) + " ");
             }
             System.out.println("Begin time :" +Calendar.getInstance().getTime().toString());
             
             System.out.println("Create PorcessBuilder from : " + s );
             //之前用的
          // pb.redirectError(Redirect.INHERIT);
          // pb.redirectInput(Redirect.INHERIT);
          // pb.redirectOutput(Redirect.INHERIT);
            //pbProc.re
          //  File log = new File("log.txt");
          //  pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
            //Process p =  pb.start();
             Process p = pb.start();
            //p.
            // set host process
            host.addProcesstoList(p);
            //host.setProcess(p);
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
            
            p.waitFor();
            
            host.getProcessList().remove(p);
            String useTime =HostWork.caculateTime(tStart);
                   
            host.setLastTime(); //update lasttime of rsync
            System.out.println("finish time :" +Calendar.getInstance().getTime().toString());
             System.out.println("Task done :" + useTime);    
          // System.out.println("Lastcomplete time of rsync: " + host.getLastTime().toString());
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
           //.append(e.toString());
        }
    }
    
    
    
}
