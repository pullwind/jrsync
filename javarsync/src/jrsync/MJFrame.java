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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
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
    String rsynccmd;
    static public ArrayList<Host> hosts = new ArrayList<Host>();
    static public myTableModel mytablemodel;
    static MJFrame mjframe;
    //static public myTableModel mytm2;
    
   //static DefaultListModel<Host> lm;
    
    
    
    /**
     * Creates new form MJFrame
     */
    public MJFrame() {
        initComponents();
        mjframe = this ;
        mytablemodel = new myTableModel(hosts);
        //mytm2 = new myTableModel(hosts);
        jTable1.setModel(mytablemodel);
        //jTable2.setModel(mytm2);
        
        //lm = new DefaultListModel<Host>();
        //jList1.setModel(lm);
        try {
            LoadFile();
            cmdLog.append("load host.txt");
        } catch (Exception e) {
           cmdLog.append("can't load host.txt");
        }
        
        //
        MyOutputStream myout = new MyOutputStream(cmdLog);
            PrintStream ps;
            ps = new PrintStream(myout,rootPaneCheckingEnabled);
            //ps = new PrintStream(myout, true);
            System.setOut(ps); 
 
    }
    
     public void update(){
        mytablemodel.fireTableDataChanged();
        
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
        jButton1 = new javax.swing.JButton();
        b_start = new javax.swing.JButton();
        b_stop = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Load = new javax.swing.JButton();
        Save = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        rsyncLog = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        cmdLog = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemAdd = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        recover = new javax.swing.JMenuItem();
        Stoprecover = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mHelp = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Rsync", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("宋体", 0, 15), new java.awt.Color(0, 51, 204))); // NOI18N

        jButton1.setText("add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        b_start.setText("Start");
        b_start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_startActionPerformed(evt);
            }
        });

        b_stop.setText("Stop");
        b_stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_stopActionPerformed(evt);
            }
        });

        jButton2.setText("del");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Load.setText("load");
        Load.setToolTipText("load from file \"host.txt\"");
        Load.setEnabled(false);
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });

        Save.setText("save");
        Save.setToolTipText("save to file \"host.txt\"");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(b_start, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(b_stop, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Load)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Save)
                .addGap(0, 216, Short.MAX_VALUE))
            .addComponent(jScrollPane4)
            .addComponent(jScrollPane2)
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {Load, Save, b_start, b_stop, jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(b_start)
                    .addComponent(b_stop)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(Load)
                    .addComponent(Save))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {Load, Save, b_start, b_stop, jButton1, jButton2});

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

        jMenu1.setText("File");

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Load");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Save");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);
        jMenu1.add(jSeparator1);

        jMenuItem3.setText("Exit");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        jMenuItemAdd.setText("Add");
        jMenuItemAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemAdd);

        jMenuItem7.setText("Delete");
        jMenu2.add(jMenuItem7);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("restore");

        recover.setText("restore");
        recover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recoverActionPerformed(evt);
            }
        });
        jMenu4.add(recover);

        Stoprecover.setText("stop");
        Stoprecover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StoprecoverActionPerformed(evt);
            }
        });
        jMenu4.add(Stoprecover);

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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b_startActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_startActionPerformed
              
       Calendar cStart = Calendar.getInstance();    
       //Calendar cEnd;               
        cmdLog.append("开始时间：" + cStart.getTime().toString() + "\n");
        cmdLog.validate();
        
      try {  
          // host
         // if(//jList1.getSelectedIndex() == -1){
          if(jTable1.getSelectedRow() == -1){
              cmdLog.append("请选择列表中的一行以进行备份 \n");
             
          }
          else{
              
               int row = jTable1.getSelectedRow();
             
               Host nowhost = mytablemodel.getSelectHost(row);
             
            // int selecti = jTable1.getSelectedRow();
            // Host nowhost = mytablemodel.getSelectHost(selecti);
             
             //Host nowhost = lm.get(jList1.getSelectedIndex());          
            //ArrayList<String> alist1 = nowhost.getRcmd();             
            
            cmdLog.append(nowhost.toString() + "\n");
            cmdLog.append("开始执行备份线程......\n");
            
            RsyncSwingWorker rsw = new RsyncSwingWorker(row,cmdLog,hosts,nowhost.getbackupCmdList(),cStart);
           mytablemodel.getSelectHost(row).setHostRsyncSwingWorker(rsw);
           
           mytablemodel.setSelectHost(row, mytablemodel.getSelectHost(row));
           cmdLog.append("hostRsyncSwingWorker :" + mytablemodel.getSelectHost(row).getHostRsyncSwingWorker().toString() + "\n");
           rsw.execute();
           
            
          }
        
      
        } catch (Exception e) {
            rsyncLog.append(e.toString());
        }
                    
                    
          // run thread
        
        
    }//GEN-LAST:event_b_startActionPerformed

   public void ishasNext(){
       /* 
       if(jCheckBoxhasNext.isSelected())
        {
            int row = jTable1.getSelectedRow();
            row++;
            if(row <= jTable1.getRowCount()){
                jTable1.setRowSelectionInterval(row, row);
            
                b_startActionPerformed(null);
                //mytablemodel.
            }
        }
       */
    }
    static public void addNewHost(Host host){
       
        hosts.add(host);
        mytablemodel.fireTableDataChanged();
        
        
    }
    
    private void b_stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_stopActionPerformed
         
        mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().destroyForcibly();
        cmdLog.append("停止进程" +  mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().toString() + "\n");
                
                    
    }//GEN-LAST:event_b_stopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       // jTable1.validate();
        
        AddHost addhost = new AddHost();
        addhost.setVisible(rootPaneCheckingEnabled);
       
        //addhost.setEnabled(rootPaneCheckingEnabled);
        
        /*
        String str =JOptionPane.showInputDialog(this, "rsync -a --delete root@192.168.0.250:/home /data1/250", "add", JOptionPane.WARNING_MESSAGE);
        String[] strarray = str.split(" ");
        ArrayList<String> alist = new ArrayList<String>();
        
        for( int i=0 ; i< strarray.length; i++){
            alist.add(strarray[i]);            
        }        
        Host hostnew = new Host(alist, str);        
        //hosts.add(hostnew);        
        // show txt in rsyncLog
        rsyncLog.append(hostnew.getRcmdstr());
        // show in jlist              
        lm.addElement(hostnew); 
        */
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            int si = jTable1.getSelectedRow(); //.getSelectedIndex();
            //lm.remove(si);            
            mytablemodel.deleteHost(si);
            mytablemodel.fireTableDataChanged();
            //SaveFile();
        }catch (ArrayIndexOutOfBoundsException e) {
          rsyncLog.append(e.toString());
        } catch (Exception e) {
            
        }

        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        // TODO add your handling code here:
        RFile rfile = new RFile("host.txt");
        rfile.openFile();
       // lm =  (DefaultListModel<Host>) rfile.readFile();
      //  mytablemodel = (myTableModel) rfile.readFile();
        ArrayList<Host> ah = (ArrayList<Host>)rfile.readFile();
        hosts.addAll(ah);
        //hosts = (ArrayList<Host>)rfile.readFile();
        mytablemodel.fireTableDataChanged();
        
        
        rfile.closeFile();
        
        // mytm2 = new myTableModel(hosts);
        //jTable2.setModel(mytm2);
        
        
        //jList1.setModel(lm);
       // jList1.validate();
       // jTable1.setModel(mytablemodel);
       // mytablemodel.fireTableDataChanged();
        //jTable1.validate();
    }//GEN-LAST:event_LoadActionPerformed
    
    private void SaveFile(){
        WFile wfile = new WFile();
        wfile.openFile();
        wfile.WtoFile(hosts);
        wfile.closeFile();
    }
    
    private void LoadFile(){
       RFile rfile = new RFile("host.txt");
        rfile.openFile();
       // lm =  (DefaultListModel<Host>) rfile.readFile();
      //  mytablemodel = (myTableModel) rfile.readFile();
        ArrayList<Host> ah = (ArrayList<Host>)rfile.readFile();
        hosts.addAll(ah);
        //hosts = (ArrayList<Host>)rfile.readFile();
        mytablemodel.fireTableDataChanged();
        rfile.closeFile(); 
        
    }
    
    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // TODO add your handling code here:
        WFile wfile = new WFile();
        wfile.openFile();
        wfile.WtoFile(hosts);
        wfile.closeFile();
        
    }//GEN-LAST:event_SaveActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        System.exit(WIDTH);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
         RFile rfile = new RFile("host.txt");
        rfile.openFile();
      //  lm =  (DefaultListModel<Host>) rfile.readFile();
        rfile.closeFile();
     //   jList1.setModel(lm);
       // jList1.validate();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        WFile wfile = new WFile();
        wfile.openFile();
        //wfile.WtoFile(lm);
        wfile.closeFile();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItemAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddActionPerformed
        // TODO add your handling code here:
       AddHost addhost = new AddHost();
      // addhost.sete
       addhost.setVisible(rootPaneCheckingEnabled);
       // NewJFrameTest njt = new NewJFrameTest();
        //njt.setv
    }//GEN-LAST:event_jMenuItemAddActionPerformed

    private void mHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHelpActionPerformed
        // TODO add your handling code here:
        Help help = new Help();
        help.setVisible(rootPaneCheckingEnabled);
       // help.Showtxt();
        
    }//GEN-LAST:event_mHelpActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow();
        Host nowselectHost = hosts.get(row);
        ArrayList<String> backupcmdlistnow = nowselectHost.getbackupCmdList();
        myTableModel_str mytm2 = new myTableModel_str(backupcmdlistnow);
        jTable2.setModel(mytm2);
        
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void recoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recoverActionPerformed
        // TODO add your handling code here:
         Calendar cStart = Calendar.getInstance();    
       //Calendar cEnd;               
        cmdLog.append("开始时间：" + cStart.getTime().toString() + "\n");
        cmdLog.validate();
        
      try {  
          // host
         // if(//jList1.getSelectedIndex() == -1){
          if(jTable1.getSelectedRow() == -1){
              cmdLog.append("请选择列表中的一行以进行还原作业 \n");
             
          }
          else{
              
             int re =  JOptionPane.showConfirmDialog(rootPane, "Select the row to restore", "restore", JOptionPane.YES_NO_OPTION);
              
             if(re ==0){
                 
             }else if(re ==1){
                 throw new Exception("no ");
             }
              
               int row = jTable1.getSelectedRow();
               Host nowhost = mytablemodel.getSelectHost(row);
             
            // int selecti = jTable1.getSelectedRow();
            // Host nowhost = mytablemodel.getSelectHost(selecti);
             //Host nowhost = lm.get(jList1.getSelectedIndex());          
            //ArrayList<String> alist1 = nowhost.getRcmd();             
            
            cmdLog.append(nowhost.toString() + "\n");
            cmdLog.append("开始执行 线程......\n");
            
            
          //  RsyncSwingWorker rsw = new RsyncSwingWorker(row,cmdLog,hosts,nowhost.getbackupCmdList(),cStart);
            RsyncSwingWorker rsw = new RsyncSwingWorker(row,cmdLog,hosts,nowhost.getrecoverCmdList(),cStart);
           mytablemodel.getSelectHost(row).setHostRsyncSwingWorker(rsw);
           
           mytablemodel.setSelectHost(row, mytablemodel.getSelectHost(row));
           cmdLog.append("线程 :" + mytablemodel.getSelectHost(row).getHostRsyncSwingWorker().toString() + "\n");
           rsw.execute();
            //rsw.
            //rsw.w
            //rsw.
            
          }
      }catch(Exception e) {
            rsyncLog.append(e.toString());
        }
      
    }//GEN-LAST:event_recoverActionPerformed

    private void StoprecoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StoprecoverActionPerformed
        // TODO add your handling code here:
        mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().destroyForcibly();
        cmdLog.append("停止所调用的rsync进程" +  mytablemodel.getSelectHost(jTable1.getSelectedRow()).getHostProcess().toString() + "\n");
    }//GEN-LAST:event_StoprecoverActionPerformed

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
    private javax.swing.JButton Load;
    private javax.swing.JButton Save;
    private javax.swing.JMenuItem Stoprecover;
    private javax.swing.JButton b_start;
    private javax.swing.JButton b_stop;
    private javax.swing.JTextArea cmdLog;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItemAdd;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JMenuItem mHelp;
    private javax.swing.JMenuItem recover;
    private javax.swing.JTextArea rsyncLog;
    // End of variables declaration//GEN-END:variables
}
