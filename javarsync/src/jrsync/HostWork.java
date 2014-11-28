/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.Serializable;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class HostWork implements Serializable{
       
        private Host host = new Host();

   
        
        
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
    
    public void hostRsync(JTextArea jtextarea){
        RsyncSwingWorker rsw = new RsyncSwingWorker(jtextarea, host.getbackupCmdList(),host);
        rsw.execute();
                
    }

    public void hostRestore(JTextArea jtextarea){
        RsyncSwingWorker restore = new RsyncSwingWorker(jtextarea, host.getrecoverCmdList(), host);
        restore.execute();
    }

    @Override
    public String toString() {
        //return super.toString(); //To change body of generated methods, choose Tools | Templates.
        return this.getHost().getbackupCmdString();
    }
    
    
    
    
    
    
}
