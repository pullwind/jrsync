package jrsync;


import java.io.Serializable;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class Host implements  Serializable{
    private  ArrayList<String> backupCmdList = new ArrayList<String>();
    private ArrayList<String> recoverCmdList = new ArrayList<String>();
    
    private String rhostUser;
    private String rhostName;
    private String rhostDir;
    private String rhostAll;
    
    private String lhostDir;    
    private String rsyncCmd;
    
    private String backupCmd;
    private String recoverCmd;
    
    private ArrayList<String> fixedCmdList = new ArrayList<String>();
    
    static public  int column = 5; //column
   // static public int column = fixedCmdList.size();
    
        private RsyncSwingWorker hostRsyncSwingWorker = null;

    /**
     * Get the value of hostRsyncSwingWorker
     *
     * @return the value of hostRsyncSwingWorker
     */
    public RsyncSwingWorker getHostRsyncSwingWorker() {
        return hostRsyncSwingWorker;
    }

    /**
     * Set the value of hostRsyncSwingWorker
     *
     * @param hostRsyncSwingWorker new value of hostRsyncSwingWorker
     */
    public void setHostRsyncSwingWorker(RsyncSwingWorker hostRsyncSwingWorker) {
        this.hostRsyncSwingWorker = hostRsyncSwingWorker;
    }

    private Process hostProcess = null;

    /**
     * Get the value of hostProcess
     *
     * @return the value of hostProcess
     */
    public Process getHostProcess() {
        return hostProcess;
    }

    /**
     * Set the value of hostProcess
     *
     * @param hostProcess new value of hostProcess
     */
    public void setHostProcess(Process hostProcess) {
        this.hostProcess = hostProcess;
    }

    
    public void setfixedCmdList(){
      //  fixedCmdList.clear();
    fixedCmdList.add(rsyncCmd);
    fixedCmdList.add(rhostAll);
    fixedCmdList.add(lhostDir);
    fixedCmdList.add(backupCmd);
    fixedCmdList.add(recoverCmd);
    //fixedCmdList.add(getHostRsyncSwingWorker().toString());
    //fixedCmdList.add(getHostProcess().toString());
    
    }
    
    public ArrayList<String>  getfixedCmdList(){
      
    return fixedCmdList;
}
    
    public void  setrhostUser(String rhostUserName){
        rhostUser = rhostUserName;
    }
    
    public String getrhostUser(){
        return rhostUser;
    }
    
    public void setrhost(String rhost){
        this.rhostName = rhost;
    }
    
    public String getrhost(){
        return rhostName;
    }
    
    
    public void setrhostDir(String rhostDir){
        this.rhostDir = rhostDir;
    }
    
    public String getrhostDir(){
        return rhostDir;
    }
    
    public void setrhostAll(){
        rhostAll =  rhostUser+ "@" + rhostName + ":" + rhostDir;
    }
    
    public void setrecoverCmdList(){
        recoverCmdList.clear(); //clear first
        String[] rsync = rsyncCmd.split(" ");
        for(String rstr:rsync){
            recoverCmdList.add(rstr);
        }        
        this.setrhostAll(); 
        recoverCmdList.add(lhostDir);
        
        recoverCmdList.add(rhostAll);
    }
    public ArrayList<String> getrecoverCmdList(){
        //setfixedCmdList();      
        
        return recoverCmdList;
    }
    
    public void setbackupCmdList(){
        backupCmdList.clear();
        String[] rsync = rsyncCmd.split(" ");
        for(String rstr:rsync){
            backupCmdList.add(rstr);
        }        
        this.setrhostAll(); 
        
        backupCmdList.add(rhostAll);
        backupCmdList.add(lhostDir);
    }
    public ArrayList<String> getbackupCmdList(){
       // setfixedCmdList();
        return backupCmdList;
        
    }
    
    
    public void setlhostDir(String lhostDir){
        this.lhostDir = lhostDir;
    }
    
    public String getlhostDir(){
        return lhostDir;
    }
    
    public void setrsyncCmd(String rsyncCmd){
        this.rsyncCmd = rsyncCmd;
    }
    
    public String getrsyncCmd(){
        return rsyncCmd;
    }
    
 
    public void setbackupCmd(){
         backupCmdList = this.getbackupCmdList();
       //String str =null;
        backupCmd ="";
       // backupCmd = backupCmdList.get(0) + " ";
        
       for(int i=0; i< backupCmdList.size(); i++){
           backupCmd += backupCmdList.get(i);
           backupCmd += " ";
           
          
       }
    }
    
    public String getbackupCmd(){
        
       
        return backupCmd;
    }
    
    public void setrecoverCmd(){
        // recoverCmd = null;
        recoverCmdList = this.getrecoverCmdList();
        recoverCmd = ""; // recoverCmdList.get(0)+"";
        //String s = null;
        
        for(int i=0; i< recoverCmdList.size(); i++){
            recoverCmd += recoverCmdList.get(i);
            recoverCmd += " ";
            
        }
    }
    
    public String getrecoverCmd(){
       
        return recoverCmd;
    }    

    public void updatetheHost(){
        // create other values
        setbackupCmdList();
        setrecoverCmdList();
        setbackupCmd();
        setrecoverCmd();
        setfixedCmdList();
        
    }

    public void Host() {
        //String str =JOptionPane.showInputDialog(this, "rsync -a --delete root@192.168.0.250:/home /data1/250", "add", JOptionPane.WARNING_MESSAGE);
         
    }
    
    
}
