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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Log extends JFrame  {

public  void  Login() {
Log frameTabel = new Log();
}
String[] bookTitles = new String[] {"ICT Developer", "Processes",
                                    "Operations", "Marketting"};
JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JTextField txuser = new JTextField(15);
JTextField pass = new JTextField(15);
JComboBox<String> bookList = new JComboBox<>(bookTitles);


Log(){
super("Login Autentification");
setLayout(new BorderLayout());
JLabel background = new JLabel(new ImageIcon("download.png"));
add(background);
setSize(800,300);
setLocation(300,100);
panel.setLayout (null); 
background.setBounds(50, 5,700,50);
txuser.setBounds(300,90,150,20);
JLabel txuser1 = new JLabel("Enter name");
JLabel txuser2 = new JLabel("Enter staff id");
JLabel txuser3 = new JLabel("Department");
JLabel txuser4 = new JLabel("Welcome to National Bank's ICT Projects Knowledge Base System");
txuser1.setBounds(200,90,150,20);
pass.setBounds(300,145,150,20);
txuser2.setBounds(200,145,150,20);
bookList.setBounds(300,175,150,20);
txuser3.setBounds(200,175,150,20);
txuser4.setBounds(200,40,700,50);
blogin.setBounds(330,215,80,20);





 
panel.add(blogin);
panel.add(txuser);
panel.add(pass);
panel.add(txuser1);
panel.add(txuser2);
panel.add(bookList);
panel.add(txuser3);
panel.add(txuser4);
panel.add(background);
getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
}

public void actionlogin(){
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String puname = txuser.getText();
String ppaswd = pass.getText();
String selectedUnit = (String) bookList.getSelectedItem();
System.out.println("You seleted the book: " + selectedUnit);
//if(puname.equals("test") && ppaswd.equals("12345")) {
//NewFrame regFace =new NewFrame();
//regFace.setVisible(true);

if(!selectedUnit.equals("ICT Developer")){
    //call class to start a new window
    NonICTDept dept = new NonICTDept(puname,ppaswd);

//dispose();
} else {

  JOptionPane.showMessageDialog(null, "You are not allowed to access this system. Login as a user form a non-ICT department");
/*JOptionPane.showMessageDialog(null,"Wrong Password / Username");
txuser.setText("");
pass.setText("");
txuser.requestFocus();*/
}
dispose();
}
});
}
}








 

 
