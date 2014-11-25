/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class myTableModel extends  AbstractTableModel implements Serializable{
   private ArrayList<Host> hosts;
    
   // final private int strNum = 7;
    final private String[] columnName = {"rsync","target","local","rsync cmd",
        "restore cmd"
    };
   // final private String[] columnName = {"备份命令","目标主机","本地目录","备份命令",
    //    "还原命令"
    //};
   //         "rsyncCmd","backupCmd","recoverCmd"
   // };
    
  
    
    public myTableModel(ArrayList<Host> hosts){
        this.hosts = hosts;
    }

    public Host getSelectHost(int select) {
        return hosts.get(select);
    }
    
    public void setSelectHost(int select ,Host host){
        hosts.set(select, host);
    }
    
    public void deleteHost(int row){
        hosts.remove(row);
    }
    
    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return hosts.size();
    }

    @Override
    public int getColumnCount() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // try {
      return Host.column;
       // return hosts.get(index)
        /*
        try {
            return MJFrame.hosts.get(0).getfixedCmdList().size();
        } catch (Exception e) {
            return 0;
        }
                */
          // return 8; 
           // int max = MJFrame.hosts.size();
           // return   MJFrame.hosts.get(max).getbackupCmdList().size();
        //} catch (Exception e) {
        //    return 1;
        //}
        
        
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       // return MJFrame.hosts.get(rowIndex).getbackupCmdList().get(columnIndex);
        return hosts.get(rowIndex).getfixedCmdList().get(columnIndex);
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getColumnName(int column) {
       
        return columnName[column];
        //return super.getColumnName(column); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
