import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


class SignupDatabaseService{

static String SignUp(String u, String e, String p) {

try{

Class.forName("com.mysql.cj.jdbc.Driver");

String url = "jdbc:mysql://localhost:3306/users_database";
String name = "username"; // replace with your MySQL username
String pass = "password"; // replace with your MySQL password
String query = "Insert into users values ('" +u+ "','" +e+ "','"+p+"') ";

Connection con = DriverManager.getConnection(url,name,pass);
Statement stmt = con.createStatement();

int insert = stmt.executeUpdate(query);
stmt.close();
con.close();
if (insert == 1)
return "Successfully inserted";
else
return "Insertion Unsuccessful";
}catch(Exception ex){return ex.getMessage();}



}



}


class SignupWindow extends JFrame{

 JTextField username_;
 JTextField email_;
JTextField password_;
JTextField confirm_;

public static void main(String[] args){
SignupWindow ob = new SignupWindow();
}

SignupWindow(){
setTitle("Signup Form");
setSize(400,300);
setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel username = new JLabel("Username:"); username.setBounds(30,30,100,25); add(username);
JLabel email = new JLabel("Email:"); email.setBounds(30,70,100,25); add(email);
JLabel Password = new JLabel("Password:"); Password.setBounds(30,110,100,25); add(Password);
JLabel confirm = new JLabel("Confirm Password:"); confirm.setBounds(30,150,120,25); add(confirm);

username_ = new JTextField(); username_.setBounds(150,30,200,25); add(username_);
email_ = new JTextField(); email_.setBounds(150,70,200,25); add(email_);
password_ = new JTextField(); password_.setBounds(150,110,200,25); add(password_);
confirm_ = new JTextField(); confirm_.setBounds(150,150,200,25); add(confirm_);

JButton signup = new JButton("Sign up"); signup.setBounds(150,200,100,30); add(signup);
signup.addActionListener(new eventHandler());
setVisible(true);
}

class eventHandler implements ActionListener{

public void actionPerformed(ActionEvent ae){

String u = username_.getText();
String e = email_.getText();
String p = password_.getText();
String c = confirm_.getText();

if (p.equals(c)){
String message = SignupDatabaseService.SignUp(u,e,p);
System.out.println(message);
}

}
}




}