package com.javatpoint.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import com.javatpoint.Employee;

public class EmployeeDAO {
	JdbcTemplate template;  

	public void setTemplate(JdbcTemplate template) {  
		this.template = template;  
	}

	public void save(final org.hibernate.Employee emp) {
		Session session = new Configuration().configure().buildSessionFactory().openSession();
		Transaction t = session.beginTransaction();
		//session.persist(emp);
	    session.save(emp);//persisting the object  
	      
	    t.commit();//transaction is commited  
	    session.close();
	    
		/*int status = 0;
		String query = "insert into employee(name, salary, designation) values(?,?,?)";
		return template.execute(query, new PreparedStatementCallback<Boolean>(){
			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setString(1, emp.getName());
				ps.setFloat(2, emp.getSalary());
				ps.setString(3, emp.getDesignation());
				return ps.execute();
			}

		});*/
	}
	
	public List getEmployee() {
		return template.query("select * from employee", new RowMapper<Employee>() {

			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));  
		        emp.setSalary(rs.getFloat(3));  
		        emp.setDesignation(rs.getString(4)); 
				return emp;
			}
		});		
	}
	
	public Employee getUserById(int id) {
		String query = "select * from employee where id = ?";
		return template.queryForObject(query, new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
	}
	
	public int updateEmployeeById(Employee p){  
	    String sql="update employee set name='"+p.getName()+"', salary="+p.getSalary()+",designation='"+p.getDesignation()+"' where id="+p.getId()+"";  
	    return template.update(sql);  
	} 
	
	public int deleteEmployeeById(int id) {
		String sql="delete from employee where id="+id+"";  
	    return template.update(sql);
	}
}
