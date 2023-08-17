/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import DBConnection.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import model.*;
/**
 *
 * @author ASUS
 */
public class Controller {
    private static Student student;
    
    public static boolean addStudent(Student student) throws Exception{
        Connection connection=DBConnection.getInctence().getConnection();
        Statement stm=connection.createStatement();
        int x= stm.executeUpdate("INSERT INTO registation VALUES('"+student.getCourseId()+"','"+student.getFullName()+"','"+student.getNicNumber()+"','"+student.getTelNumber()+"','"+student.getAddress()+"','"+student.getCourses()+"')");
            
        return (x>0);  
        
    }
    
    public static Student searchStudent(String studentId) throws Exception{
        Connection connection=DBConnection.getInctence().getConnection();
        Statement stm=connection.createStatement();
        ResultSet rst= stm.executeQuery("SELECT *FROM registation WHERE id='"+studentId+"'");
        
        while(rst.next()){
         student=new Student(studentId,rst.getString("fullName"), rst.getString("nic"), rst.getString("tel"), rst.getString("address"), rst.getString("course"));
         
        }
        return student;
    }
    
    public static boolean deleteStudent(String studentId) throws Exception{
        Connection connection=DBConnection.getInctence().getConnection();
        Statement stm=connection.createStatement();
        int x=stm.executeUpdate("DELETE FROM registation WHERE id='"+studentId+"'");
        
        return x>0;
    }
    
    public static boolean updateStudent(Student student) throws Exception{
        Connection connection=DBConnection.getInctence().getConnection();
        Statement stm=connection.createStatement();
        int x =stm.executeUpdate("UPDATE registation SET id='"+student.getCourseId()+"',fullName='"+student.getFullName()+"',nic='"+student.getNicNumber()+"',tel='"+student.getTelNumber()+"',address='"+student.getAddress()+"',course='"+student.getCourses()+"' WHERE id='"+student.getCourseId()+"'");
       System.out.println(x);
        return x>0;
    }
}
