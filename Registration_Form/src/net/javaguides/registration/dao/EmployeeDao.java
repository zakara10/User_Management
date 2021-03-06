package net.javaguides.registration.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;

import net.javaguides.registration.model.Employee;

public class EmployeeDao {
	
	public int registerEmployee(Employee employee) throws ClassNotFoundException{
		String INSERT_USER_SQL="insert into employee (id,first_name,last_name,username,password,address,contact) values (?,?,?,?,?,?,?)";
		int result = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			String url="jdbc:oracle:thin:@localhost:1521:xe";
			Connection con = DriverManager.getConnection(url, "system","roshan");
			PreparedStatement pst= con.prepareStatement(INSERT_USER_SQL);
			pst.setString(1,employee.getId());
			pst.setString(2,employee.getFirstName());
			pst.setString(3,employee.getLastName());
			pst.setString(4,employee.getUsername());
			pst.setString(5,employee.getPassword());
			pst.setString(6,employee.getAddress());
			pst.setString(7,employee.getContact());
			
			System.out.println(pst);
			result = pst.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
