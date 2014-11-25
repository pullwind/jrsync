/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jrsync;

import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author Administrator
 */
public class MyOutputStream extends OutputStream{
    private JTextArea jtextarea;

    public MyOutputStream(JTextArea jtextarea) {
        this.jtextarea = jtextarea;
    }

    @Override
    public void flush() throws IOException {
        super.flush(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        //super.write(b, off, len); //To change body of generated methods, choose Tools | Templates.
        //new String(b, null)
        String s = new String(b,off,len);
        jtextarea.append(s);
        //jtextarea.append(new String(b,off,len,"GBK"));
    }

    @Override
    public void write(byte[] b) throws IOException {
        //super.write(b); //To change body of generated methods, choose Tools | Templates.
        String s = new String(b);
        jtextarea.append(s);
        //jtextarea.append(new String(b,"GBK"));
    }

    @Override
    public void write(int b) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       // String s = Byte.toString(b);
        String s = Integer.toString(b);
        
        //String s = new String((byte)b);
        jtextarea.append(s);
        
    }
    
    
    
    
    
   
    
}
