/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectkbs;

/**
 *
 * @author Administrator
 */
import InferenceEngine.Engine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jess.JessException;

public class NonICTDept extends JFrame  {
private String staffId;
private String name;
public  void  NonICTDept(String name,String staffId) {
this.staffId = staffId;
this.name = name;
NonICTDept frameTabel = new NonICTDept(name, staffId);
}

JButton binfo = new JButton("General Project Information");
JButton bcheck = new JButton("New Project");
JPanel panel = new JPanel();



NonICTDept(String name,String staffId){
super("Actions");
    setName(name);
    setStaffId(staffId);
setLayout(new BorderLayout());
JLabel background = new JLabel(new ImageIcon("download.png"));
add(background);
setSize(800,300);
setLocation(300,100);
panel.setLayout (null); 
String labelText ="<html><font color='#996633'>Welcome "+name+" Select one of the options below</font></html>";
JLabel txuser2 = new JLabel(labelText);
txuser2.setVisible(true);
txuser2.setBounds(300, 10,300, 100);
binfo.setBounds(100,70,150,20);
binfo.setSize(200,80);
bcheck.setBounds(500,70,150,20);
bcheck.setSize(200,80);
background.setBounds(50, 150,700,50);




 
panel.add(binfo);
panel.add(txuser2);
panel.add(bcheck);
panel.add(background);
getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
}

public void actionlogin(){
binfo.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
    try {
        //Get information from the knowledge base
        String myName = getName();
        String s = "(assert (Information (name "+myName+")))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();
    } catch (JessException ex) {
        Logger.getLogger(NonICTDept.class.getName()).log(Level.SEVERE, null, ex);
    }
} 





});

bcheck.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
 //start another dialog  
ProjectSubmission submit = new ProjectSubmission(getName(),getStaffId());
}
});

}

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}








 

 
