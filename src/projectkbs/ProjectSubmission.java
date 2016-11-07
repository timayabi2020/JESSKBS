/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. runners
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

public class ProjectSubmission extends JFrame  {
private String staffId;
private String name;
private String projectame;
public  void  ProjectSubmission(String name,String staffId) {
this.staffId = staffId;
this.name = name;
ProjectSubmission frameTabel = new ProjectSubmission(name,staffId);
}
String[] brd = new String[] {"No", "Yes"};
String[] nda = new String[] {"No", "Yes"};
String[] intDoc = new String[] {"No", "Yes"};
String[] uatPlan = new String[] {"No", "Yes"};
String[] category = new String[] {"Internal", "Vendor"};
JButton blogin = new JButton("Confirm");


JPanel panel = new JPanel();

JComboBox<String> brdAvailable = new JComboBox<>(brd);
JComboBox<String> ndaAvailable = new JComboBox<>(nda);
JComboBox<String> intDocAvailable = new JComboBox<>(intDoc);
JComboBox<String> uatPlanAvailable = new JComboBox<>(uatPlan);
JComboBox<String> categorySelect = new JComboBox<>(category);


String checkBRD = "Business Requirement Document";
String checkNDA = "Non-Disclosure Agreement";
String checkUat = "UAT/Pilot plan Document";
String checkIntDoc = "Integration Document";
String checkCategory = "Select Project Category";
String projectName = "Enter project name";
JTextField projectField = new JTextField(15);
JLabel txuser3 = new JLabel(checkBRD);
JLabel txuser4 = new JLabel(checkNDA);
JLabel txuser5 = new JLabel(checkUat);
JLabel txuser6 = new JLabel(checkIntDoc);
JLabel txuser7 = new JLabel(checkCategory);
JLabel txuser8 = new JLabel(projectName);


ProjectSubmission(String name, String staffId){
super("Check list");
    setName(name);
setLayout(new BorderLayout());
JLabel background = new JLabel(new ImageIcon("download.png"));
add(background);
setSize(800,500);
setLocation(300,100);
panel.setLayout (null); 
String labelText ="<html><font color='#996633'>Welcome "+name+" Kindly confirm the availability of the documented requirements</font></html>";
JLabel txuser2 = new JLabel(labelText);
background.setBounds(50, 5,700,50);
txuser2.setBounds(300, 25,300, 100);
brdAvailable.setBounds(100,150,150,20);
txuser3.setBounds(100,100,300,20);
txuser4.setBounds(500,100,300,20);
ndaAvailable.setBounds(500,150,150,20);
txuser5.setBounds(100,200,300,20);
uatPlanAvailable.setBounds(100,250,150,20);
txuser6.setBounds(500,200,300,20);
intDocAvailable.setBounds(500,250,150,20);
txuser7.setBounds(100,315,150,20);
categorySelect.setBounds(100,345,80,20);
txuser8.setBounds(330,315,150,20);
projectField.setBounds(330,345,150,20);
blogin.setBounds(500,385,80,20);
blogin.setSize(200,50);





 
panel.add(blogin);
panel.add(txuser2);
panel.add(brdAvailable);
panel.add(txuser3);
panel.add(txuser4);
panel.add(ndaAvailable);
panel.add(txuser5);
panel.add(uatPlanAvailable);
panel.add(txuser6);
panel.add(intDocAvailable);
panel.add(txuser7);
panel.add(categorySelect);
panel.add(txuser8);
panel.add(projectField);
panel.add(background);
getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

actionlogin(getName());
}

public void actionlogin(String myName){
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
    int myProjectName;
//check rules from clips
if(categorySelect.getSelectedItem().equals("Internal")){
  try {
        //Get information from the knowledge base
        //Check for empty project name
        
       setProjectame(projectField.getText());
      
       
       if(getProjectame()==null || getProjectame().equals("") || getProjectame().isEmpty()
          &&!brdAvailable.getSelectedItem().equals("No")&&!uatPlanAvailable.getSelectedItem().equals("No")
               &&!ndaAvailable.getSelectedItem().equals("No")&&!intDocAvailable.getSelectedItem().equals("No")){
      //getName();
      
       System.out.println("ONE");
        String s = "(assert (Internal (name 0)))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();
       }else if(brdAvailable.getSelectedItem().equals("No")){
           
           
        String s = "(assert (InternalBRD (brddoc 0)))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();
           
           
       }else if(uatPlanAvailable.getSelectedItem().equals("No")){
            System.out.println("TWO");
           String s = "(assert (InternalUAT (uatdoc 0)))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();
           
       }else{
           String s = "(assert (Confirmed (name "+myName+")(project "+getProjectame()+")))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose(); 
       }
    } catch (JessException ex) {
        Logger.getLogger(NonICTDept.class.getName()).log(Level.SEVERE, null, ex);
    }
  
}else{
    try {
        if(ndaAvailable.getSelectedItem().equals("No")){
         
           String s = "(assert (InternalNDA (ndadoc 0)))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();
           
       }else if(intDocAvailable.getSelectedItem().equals("No")){
           
           String s = "(assert (InternalInt (intdoc 0)))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();
           
       }else{
        String s = "(assert (Confirmed (name "+getName()+")))";
        Engine query = new Engine();
        query.queryInferenceEngine(s);
        dispose();   
       }
    } catch (JessException ex) {
        Logger.getLogger(NonICTDept.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
dispose();
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

    public String getProjectame() {
        return projectame;
    }

    public void setProjectame(String projectame) {
        this.projectame = projectame;
    }

}








 

 
