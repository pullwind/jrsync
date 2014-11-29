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
public class Host implements Serializable{
    private  ArrayList<String> backupCmdList = new ArrayList<String>();
    private ArrayList<String> recoverCmdList = new ArrayList<String>();
    
    private String rhostUser;
    private String rhostName;
    private String rhostDir;
    private String rhostAll;
    
    private String lhostDir;    
    private String rsyncCmd;
    
    private String backupCmdString;
    private String recoverCmdString;   
    
   private transient ArrayList<Process> processList = new ArrayList<Process>();
   
   
    public ArrayList<Process> getProcessList() {
        return processList;
    }

    public void addProcesstoList(Process process) {
       // this.process = process;
        this.processList.add(process);
        
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
        backupCmdList.clear(); //clear old first
        
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
    
 
    public void setbackupCmdString(){
        // backupCmdList = this.getbackupCmdList();
       //String str =null;
        backupCmdString ="";
       // backupCmd = backupCmdList.get(0) + " ";
        
       for(int i=0; i< backupCmdList.size(); i++){
           backupCmdString += backupCmdList.get(i);
           backupCmdString += " ";
           
          
       }
    }
    
    public String getbackupCmdString(){
        
       
        return backupCmdString;
    }
    
    public void setrecoverCmdString(){
        // recoverCmd = null;
        //recoverCmdList = this.getrecoverCmdList();
        recoverCmdString = ""; // recoverCmdList.get(0)+"";
        //String s = null;
        
        for(int i=0; i< recoverCmdList.size(); i++){
            recoverCmdString += recoverCmdList.get(i);
            recoverCmdString += " ";
            
        }
    }
    
    public String getrecoverCmdString(){
       
        return recoverCmdString;
    }    

    public void upDateHost(){
        setbackupCmdList();
        setbackupCmdString();
        setrecoverCmdList();
        setrecoverCmdString();
        
    }
    
}
