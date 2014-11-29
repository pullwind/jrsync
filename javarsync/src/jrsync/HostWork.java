/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.Serializable;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class HostWork  extends TimerTask implements Serializable{
       
        private Host host = new Host();
        private JTextArea cmdlog;
        private long timerperiod;
        private long timerdelay;
       // private transient Timer timer = new Timer();
        

    public HostWork(JTextArea cmdlog) {
        this.cmdlog = cmdlog;
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
    
    public void hostRsyncOnce(){
        //RsyncSwingWorker rsw = new RsyncSwingWorker(this.cmdlog, host.getbackupCmdList(),host);
        //rsw.execute();
        
        Timer timer  = new Timer();
        timer.schedule(this, timerdelay);
        System.out.println("hostRsyncOnce");
                
    }

    public void hostRestore(){
        RsyncSwingWorker restore = new RsyncSwingWorker(this.cmdlog, host.getrecoverCmdList(), host);
        restore.execute();
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return this.getHost().getbackupCmdString();
    }
    
    
    
    public void hostRsyncRepeat(){
        
        //MyTimerTask mytimerTask = new MyTimerTask();   
        Timer timer  = new Timer();
        timer.schedule(this, this.timerdelay, this.timerperiod); 
        System.out.println("hostRsyncRepeat");
        
    }

    @Override
    public void run() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        RsyncSwingWorker rsw = new RsyncSwingWorker(this.cmdlog, host.getbackupCmdList(),host);
        rsw.execute();
        System.out.println("run of hostwork");
        //可能会有多个process, 而只保存了一个， 后期改用arraylist保存process.
    }
    
    
    
    
    
}
