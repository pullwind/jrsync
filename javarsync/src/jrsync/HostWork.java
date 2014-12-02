/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class HostWork implements Serializable{
       
        private Host host = new Host();
        private transient JTextArea cmdlog;
        private long timerperiod;
        private long timerdelay;
        
       // private transient Timer timer = new Timer();
        private transient ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        private transient ArrayList<ScheduledFuture<?>> scheduledfutureList = new ArrayList<ScheduledFuture<?>>();
        
       
       private static final long serialVersionUID=-1 ;
        

    public HostWork(JTextArea cmdlog) {
        this.cmdlog = cmdlog;
       // lasttime = this.getLastTime();
        
    }
      
    
    public ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(){
        return this.scheduledThreadPoolExecutor;
    }
    
    public void setScheduledThreadPoolExecutor(int n){
       this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(n);
    }
    
    public Timer getTimer(){
        return new Timer(); //timer;
    }
    
    public void settimerperiod(Long period){
        this.timerperiod = period;
    }    
    
    public Long gettimerperiod(){
        return timerperiod;
    }
        
    public void settimerdelay(Long delay){
        this.timerdelay = delay;
    }
    
    public Long gettimerdelay(){
        return timerdelay;
    }
    
    /**
     * Get the value of host
     *
     * @return the value of host
     */
    public Host getHost() {
        return host;
    }

    /**
     * Set the value of host
     *
     * @param host new value of host
     */
    public void setHost(Host host) {
        this.host = host;
    }
    
   
    public ArrayList<ScheduledFuture<?>> getScheduledFutureList(){
        return this.scheduledfutureList;
    }
    
    public void setScheduledFutureList(ArrayList<ScheduledFuture<?>> sche){
        this.scheduledfutureList = sche;
    }
   
    public void hostRsyncOnce(){
        //RsyncSwingWorker rsw = new RsyncSwingWorker(this.cmdlog, host.getbackupCmdList(),host);
        //rsw.execute();
        //Timer timer  = new Timer();
        //timer.schedule(this, timerdelay);
        //System.out.println("call hostRsyncOnce");
        ScheduledFuture<?> scheduledfuture = null;       
       try{
        scheduledfuture = this.scheduledThreadPoolExecutor.schedule(new MyRunnable(host.getbackupCmdList(), host), timerdelay, TimeUnit.MINUTES);
        
       }catch (NullPointerException e){
           e.printStackTrace();
           //this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);           
           //scheduledfuture = this.scheduledThreadPoolExecutor.schedule(new MyRunnable(host.getbackupCmdList(), host), timerdelay, TimeUnit.MINUTES);
           
       }
       
       try{ 
            this.scheduledfutureList.add(scheduledfuture);
       }catch(NullPointerException enull){
          enull.printStackTrace();
            // this.scheduledfutureList = new ArrayList<ScheduledFuture<?>>();
          // this.scheduledfutureList.add(scheduledfuture);
       }
      
      // System.out.println(this.scheduledThreadPoolExecutor.getPoolSize());
       // System.out.println("\n now runing process : " + this.host.getProcessList().size());
       // System.out.println("\n now ScheduleFuture :  " + this.getScheduledFutureList().size() );
       //  String taskcount = String.valueOf(this.getScheduledThreadPoolExecutor().getTaskCount());
       //   System.out.println("\n Taskcount : " +taskcount);
                
    }
    
    public static String caculateTime(Calendar tStart){
        //cmdlog.append("exit code: " + this.get().toString() + " \n");
            Calendar tEnd = Calendar.getInstance();
            //cEnd = (Calendar) future.get();
            long t1 = tStart.getTimeInMillis();
            long t2 = tEnd.getTimeInMillis();
            long seconds = (t2 -t1)/1000;
            long minitues = (t2 -t1)/1000/60;
            long hours = (t2 -t1)/(60*60*1000);
            
            return " seconds: " + seconds +  " , (minitues: " + String.valueOf(minitues) + "), (hours: " + String.valueOf(hours) + ")";            
    }
    
    public void ScheduledFutureCacel(){
        try{
            for(int i=0; i < host.getProcessList().size(); i++){
            host.getProcessList().get(i).destroyForcibly();
            
             for(int j=0; j< this.scheduledfutureList.size(); j++){
            this.scheduledfutureList.get(j).cancel(true);
            }
             
            this.scheduledThreadPoolExecutor.shutdownNow();
        
            
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void hostRestore(){
        //RsyncSwingWorker restore = new RsyncSwingWorker(this.cmdlog, host.getrecoverCmdList(), host);
        //restore.execute();
        //stop scheduled task first;
        
        this.ScheduledFutureCacel();
        
        this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
        
        
        ScheduledFuture<?> scheduledfuture = null;       
       try{
        scheduledfuture = this.scheduledThreadPoolExecutor.schedule(new MyRunnable(host.getrecoverCmdList(), host), timerdelay, TimeUnit.MINUTES);
        
       }catch (NullPointerException e){
           e.printStackTrace();
           //this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);           
           //scheduledfuture = this.scheduledThreadPoolExecutor.schedule(new MyRunnable(host.getbackupCmdList(), host), timerdelay, TimeUnit.MINUTES);
           
       }
       
       try{ 
            this.scheduledfutureList.add(scheduledfuture);
       }catch(NullPointerException enull){
          enull.printStackTrace();
            // this.scheduledfutureList = new ArrayList<ScheduledFuture<?>>();
          // this.scheduledfutureList.add(scheduledfuture);
       }
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return this.getHost().getbackupCmdString();
    }
    
    
    
    public void hostRsyncRepeat(){
        
        //MyTimerTask mytimerTask = new MyTimerTask();   
        //Timer timer  = new Timer();
        //timer.schedule(this, this.timerdelay, this.timerperiod); 
       // System.out.println("call hostRsyncRepeat ");
      //   this.setScheduledThreadPoolExecutor();
         ScheduledFuture<?> scheduledfuture = null;
        try{
            scheduledfuture =
               this.scheduledThreadPoolExecutor.scheduleWithFixedDelay(new MyRunnable(this.host.getbackupCmdList(), host), timerdelay, this.timerperiod, TimeUnit.MINUTES); 
            
       }catch (NullPointerException e){
           e.printStackTrace();
          // this.scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(10);
          // scheduledfuture =
           //    this.scheduledThreadPoolExecutor.scheduleWithFixedDelay(new MyRunnable(this.host.getbackupCmdList(), host), timerdelay, this.timerperiod, TimeUnit.MINUTES); 
       }
           try {
               this.scheduledfutureList.add(scheduledfuture);           
           }catch(NullPointerException enull){
               enull.printStackTrace();
              // this.scheduledfutureList = new ArrayList<ScheduledFuture<?>>();
               //this.scheduledfutureList.add(scheduledfuture);
           }
       }
        
        
   
   
    
}
