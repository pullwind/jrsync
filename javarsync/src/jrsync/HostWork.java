/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class HostWork {
        private JTextArea jtextarea;
        private Host host;
        //private 

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
    
    public void hostRsync(){
        RsyncSwingWorker rsw = new RsyncSwingWorker(jtextarea, host.getbackupCmdList(),host);
        rsw.execute();
                
    }

    public void hostRestore(){
        
    }
    
    
    
    
    
}
