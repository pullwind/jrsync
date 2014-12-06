package jrsync;



import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.input.KeyCode.T;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListModel;
import javax.swing.plaf.OptionPaneUI;
import sun.security.krb5.Confounder;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
public class MJFrame extends javax.swing.JFrame {
    
    //private ArrayList<HostWork> hostworks = new ArrayList<HostWork>();
    DefaultListModel<HostWork> dlmhostworks; // = new DefaultListModel<HostWork>();
   
    
    /**
     * Creates new form MJFrame
     */
    public MJFrame() {
        initComponents();
            MyOutputStream myout = new MyOutputStream(cmdLog);
            PrintStream ps;
            ps = new PrintStream(myout,rootPaneCheckingEnabled);
            //ps = new PrintStream(myout, true);
            System.setOut(ps); 
            
            dlmhostworks = new DefaultListModel<HostWork>();
            
        try {
            
            LoadFile();
            cmdLog.append("hostwork2.txt load ");
        } catch (Exception e) {
           cmdLog.append("can't load hostwork2.txt");
        }
        
        jListHost.setModel(dlmhostworks); //set model
        //
       // for(int i=0; i< this.dlmhostworks.size(); i++){
       //     this.dlmhostworks.get(i).ScheduledFutureCacel();
        //}
        
 
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jListHost = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rsyncLog = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cmdLog = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaHost = new javax.swing.JTextArea();
        jButtonStart = new javax.swing.JButton();
        jButtonStop = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        restore = new javax.swing.JMenuItem();
        Stoprestore = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mHelp = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Host", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 15), new java.awt.Color(0, 51, 204))); // NOI18N

        jListHost.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jListHost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListHostMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(jListHost);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Save.setText("Save to File");
        Save.setToolTipText("save to file \"host.txt\"");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(Save)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Save, jButton1, jButton2});

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "RsyncLog", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 15), new java.awt.Color(0, 51, 153))); // NOI18N

        rsyncLog.setEditable(false);
        rsyncLog.setColumns(20);
        rsyncLog.setRows(5);
        jScrollPane1.setViewportView(rsyncLog);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "cmdLog    check the terminal window。", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 15), new java.awt.Color(0, 51, 153))); // NOI18N

        cmdLog.setEditable(false);
        cmdLog.setColumns(20);
        cmdLog.setRows(5);
        jScrollPane3.setViewportView(cmdLog);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        jTextAreaHost.setColumns(20);
        jTextAreaHost.setRows(5);
        jTextAreaHost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextAreaHostMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTextAreaHost);

        jButtonStart.setText("Start Rsync");
        jButtonStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStartActionPerformed(evt);
            }
        });

        jButtonStop.setText("Stop Rsync");
        jButtonStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButtonStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonStop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(359, 359, 359))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonStop)
                    .addComponent(jButtonStart)))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 43, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenu1.add(jSeparator1);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Restore");

        restore.setText("Restore");
        restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreActionPerformed(evt);
            }
        });
        jMenu4.add(restore);

        Stoprestore.setText("Stop");
        Stoprestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoprestoreActionPerformed(evt);
            }
        });
        jMenu4.add(Stoprestore);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("Help");

        mHelp.setText("Help");
        mHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHelpActionPerformed(evt);
            }
        });
        jMenu3.add(mHelp);

        jMenuItem5.setText("About");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStopActionPerformed
         
        //mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().destroyForcibly();
        // ((HostWork)jListHost.getSelectedValue()).getTimer().cancel();
                
       // ArrayList<Process> processList =((HostWork)jListHost.getSelectedValue()).getHost().getProcessList();
        ((HostWork)jListHost.getSelectedValue()).ScheduledFutureCacel();
        ((HostWork)jListHost.getSelectedValue()).setScheduledThreadPoolExecutor(10);
       // ArrayList<ScheduledFuture<?>> scheduledfutureList = new ArrayList<ScheduledFuture<?>>();
         //   hostwork.setScheduledFutureList(scheduledfutureList); 
       // ((HostWork)jListHost.getSelectedValue()).setScheduledFutureList(scheduledfutureList);
       
        /*
        for(int i=0; i< processList.size(); i++){
           // process.destroyForcibly();
            processList.get(i).destroyForcibly();
           // cmdLog.append("停止进程" + process.toString());
            cmdLog.append("停止进程:   " + processList.get(i).toString());
        }
        */
        //cmdLog.append("停止进程" + process.toString()); // mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().toString() + "\n");
                
                    
    }//GEN-LAST:event_jButtonStopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        HostWork hostwork = new HostWork();
        AddHostWork addhost = new AddHostWork(this.dlmhostworks, hostwork);
        addhost.setVisible(rootPaneCheckingEnabled);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int si = jListHost.getSelectedIndex(); //.getSelectedRow(); //.getSelectedIndex();
            //lm.remove(si);            
            //mytablemodel.deleteHost(si);
            this.dlmhostworks.remove(si);
            //mytablemodel.fireTableDataChanged();
            //SaveFile();
        }catch (ArrayIndexOutOfBoundsException e) {
          rsyncLog.append(e.toString());
        } catch (Exception e) {
            
        }

        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LoadFile(){
        RFile rfile = new RFile("hostwork2.txt");
       
        rfile.openFile();
       // lm =  (DefaultListModel<Host>) rfile.readFile();
      //  mytablemodel = (myTableModel) rfile.readFile();
        //ArrayList<HostWork> arraylisthw = (ArrayList<HostWork>)rfile.readFile();
        try {
             DefaultListModel<HostWork> dlm = (DefaultListModel<HostWork>)rfile.readFile();
            for(int i=0; i< dlm.getSize(); i++){
                this.dlmhostworks.addElement(dlm.elementAt(i));
                this.dlmhostworks.get(i).setupHostWork(); //init hostwork
            }
             
            //this.dlmhostworks = dlm;
        } catch (Exception e) {
        }
       
        //hosts.addAll(ah);
        //hosts = (ArrayList<Host>)rfile.readFile();
        //mytablemodel.fireTableDataChanged();
         
        rfile.closeFile();
    }
       
    
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        WFile wfile = new WFile("hostwork2.txt");
        wfile.openFile();
        wfile.WtoFile(this.dlmhostworks);
        wfile.closeFile();
        
    }//GEN-LAST:event_SaveActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        
        for(int i=0; i< this.dlmhostworks.size(); i++){
            this.dlmhostworks.get(i).ScheduledFutureCacel();
        }
        
        System.exit(0);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void mHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHelpActionPerformed
        // TODO add your handling code here:
        Help help = new Help();
        help.setVisible(rootPaneCheckingEnabled);
       // help.Showtxt();
        
    }//GEN-LAST:event_mHelpActionPerformed

    private void restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreActionPerformed
        // TODO add your handling code here:
       
        
      try {  
         
          if(jListHost.getSelectedIndex() == -1){
              cmdLog.append("请选择列表中的一行以进行还原作业 \n");
             
          }
          else{
            // int re =  JOptionPane.showConfirmDialog(rootPane, "Please confirm that the selections are correct before restore", "restore", JOptionPane.YES_NO_OPTION);
              
            // if(re ==0){
                 
            // }else if(re ==1){
             //    throw new Exception("no");
             //}
            
            HostWorkRestore hwr = new HostWorkRestore(this.dlmhostworks.get(this.jListHost.getSelectedIndex()));
            hwr.setVisible(rootPaneCheckingEnabled);
            
          }
      }catch(Exception e) {
            rsyncLog.append(e.toString());
        }
      
    }//GEN-LAST:event_restoreActionPerformed

    private void StoprestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoprestoreActionPerformed
        // TODO add your handling code here:
        //mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().destroyForcibly();
       this.dlmhostworks.get(this.jListHost.getSelectedIndex()).ScheduledFutureCacel();
      
    }//GEN-LAST:event_StoprestoreActionPerformed

    private void jListHostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListHostMouseClicked
        // TODO add your handling code here:
       
        HostWork hostwork = this.dlmhostworks.get(this.jListHost.getSelectedIndex());
        
        Host host = hostwork.getHost();
        
        jTextAreaHost.setText(" ");
        jTextAreaHost.append("\n username:  " + host.getrhostUser());
        jTextAreaHost.append("\n remote host:   " + host.getrhost());
        jTextAreaHost.append("\n remote directory:  " + host.getrhostDir());
        jTextAreaHost.append("\n local directory:   " + host.getlhostDir());
        jTextAreaHost.append("\n rsync cmd: " + host.getrsyncCmd());
        jTextAreaHost.append("\n backup rsync cmd:  " + host.getbackupCmdString());
        jTextAreaHost.append("\n restore rsync cmd: " + host.getrecoverCmdString());
        jTextAreaHost.append("\n ############################################");
        
        Long delay = hostwork.gettimerdelay();
        Long period = hostwork.gettimerperiod();
        
        jTextAreaHost.append("\n delay:  "+ delay + " minutes" );
        jTextAreaHost.append("\n period:  " +period + " minutes ( hours: "  + (period/60) + ")");
       
        ArrayList<Process> processlist = hostwork.getHost().getProcessList();
        
        
        
        try{
            jTextAreaHost.append("\n now ScheduleFuture :  " + hostwork.getScheduledFutureList().size() );
        }catch (NullPointerException e2) {
              ArrayList<ScheduledFuture<String>> scheduledfutureList = new ArrayList<ScheduledFuture<String>>();
            hostwork.setScheduledFutureList(scheduledfutureList); 
           //e2.printStackTrace();             
        }
        
        //hostwork.getScheduledThreadPoolExecutor().getQueue().
       
         
        try{
            String taskcount = String.valueOf(hostwork.getScheduledThreadPoolExecutor().getTaskCount());
          jTextAreaHost.append("\n  All Taskcount : " +taskcount);
            String activetask = String.valueOf( hostwork.getScheduledThreadPoolExecutor().getActiveCount());
            jTextAreaHost.append("\n Now Active task: " + activetask);
            
            
            for(int i=0; i< hostwork.getScheduledFutureList().size(); i++){
                String a=   String.valueOf(hostwork.getScheduledFutureList().get(i).isDone());
                //String b=   String.valueOf(hostwork.getScheduledFutureList().get(i).isCancelled());
               // String result =hostwork.getScheduledFutureList().get(i).get();
                jTextAreaHost.append("\n scheduledfuture isdone " + String.valueOf(i) + " : " + a);
               // jTextAreaHost.append("\n scheduledfuture caceled " + String.valueOf(i) + " : " + b);
                
            }
            
          } catch (NullPointerException e3) {
            hostwork.setScheduledThreadPoolExecutor(10); 
           //e3.printStackTrace();             
        }
        
        try{
        jTextAreaHost.append("\n now runing process : " + processlist.size());
        }catch (NullPointerException e1) {           
            hostwork.getHost().setProcessList();
          // e1.printStackTrace();             
        }
        
        try{
            jTextAreaHost.append("\n Last time : " +hostwork.getHost().getLastTime().toString());
        }catch(Exception e){
            
        }
        
        //hostwork.getTimer().
        /*
        if(!host.getProcessList().isEmpty()){
            jButtonStart.setEnabled(false);
            jButtonStop.setEnabled(true);
            
        }else{
            jButtonStop.setEnabled(false);
            jButtonStart.setEnabled(true);
        }
        */
    }//GEN-LAST:event_jListHostMouseClicked

    private void jButtonStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonStartActionPerformed
        // TODO add your handling code here:
       // Calendar cStart = Calendar.getInstance();    
       //Calendar cEnd;               
        //cmdLog.append("开始时间：" + cStart.getTime().toString() + "\n");
        //cmdLog.validate();
        
      try {  
          // host
         // if(//jList1.getSelectedIndex() == -1){
         if( false){
              cmdLog.append("请选择列表中的一行以进行备份 \n");
             
          }
          else{
              
               int row = jListHost.getSelectedIndex(); //.getSelectedRow();             
               HostWork nowhostwork = dlmhostworks.get(row); // .get(row); // .getSelectHost(row);
               
               
           // cmdLog.append(nowhostwork.toString() + "\n");
            //cmdLog.append("设置period参数......\n");
           //nowhostwork.hostRsync();
            
            //set delay and period
            HostWorkPeriod hwp = new HostWorkPeriod(nowhostwork);
            hwp.setVisible(rootPaneCheckingEnabled);
            
           // this.wait();
           //cmdLog.append("已设置period参数， 开始调用线程......\n");
           // nowhostwork.hostRsyncTimer();
            
          }
        
      
        } catch (Exception e) {
            rsyncLog.append(e.toString());
        }
                    
                    
          // run thread
    }//GEN-LAST:event_jButtonStartActionPerformed

    private void jTextAreaHostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextAreaHostMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jTextAreaHostMouseClicked

    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        // If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
        // For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MJFrame().setVisible(true);
                
            }
        });
    }


    
    public void rsyncRun(String args) throws IOException, InterruptedException{
        //ProcessBuilder pbProc =  new ProcessBuilder("ifconfig");
        ProcessBuilder pbProc =  new ProcessBuilder(args);
        pbProc.redirectErrorStream();
        //pbProc.re        
        Process proc = pbProc.start();
        //Process proc = Runtime.getRuntime().exec(args);
         
        
         rsyncLog.append(args + "\n");
         
       // System.out.println("waiting for end...");
        BufferedReader all; //br, berr;
        //br = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        //berr = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
        all = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        
        //String strErr = null;
        String line = null;
        while((line = all.readLine()) != null){
            rsyncLog.append(line + "\n");
            
           // if((strErr = berr.readLine()) != null){
           // errLog.append(strErr + "\n");
            //}
            
            //System.out.println(line);
        }
        
        //while((strErr = berr.readLine()) != null){
         //   errLog.append(strErr + "\n");
        //}
        all.close();
        //berr.close();
        //br.close();
        int exitValue =0;
        if((exitValue = proc.waitFor()) != 0 ){
            rsyncLog.append("exitValue: " + exitValue);
            //System.out.println("exitValue: " + exitValue);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Save;
    private javax.swing.JMenuItem Stoprestore;
    private javax.swing.JTextArea cmdLog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonStart;
    private javax.swing.JButton jButtonStop;
    private javax.swing.JList jListHost;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextArea jTextAreaHost;
    private javax.swing.JMenuItem mHelp;
    private javax.swing.JMenuItem restore;
    private javax.swing.JTextArea rsyncLog;
    // End of variables declaration//GEN-END:variables
}
