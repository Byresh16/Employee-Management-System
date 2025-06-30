package dao;

import model.Employee;
import util.DBConnection;

import java.sql.*;
import javafx.collections.*;

public class EmployeeDAO {
    public ObservableList<Employee> getAll(){
        ObservableList<Employee> data=FXCollections.observableArrayList();
        try(Connection c=DBConnection.getConnection();
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from employees")){
            while(rs.next()){
                data.add(new Employee(rs.getInt("id"),rs.getString("name"),
                                      rs.getString("department"),rs.getDouble("salary")));
            }
        }catch(Exception e){e.printStackTrace();}
        return data;
    }
    public void add(Employee e){
        String sql="insert into employees values(?,?,?,?)";
        try(Connection c=DBConnection.getConnection();
            PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,e.getId());
            ps.setString(2,e.getName());
            ps.setString(3,e.getDepartment());
            ps.setDouble(4,e.getSalary());
            ps.executeUpdate();
        }catch(Exception ex){ex.printStackTrace();}
    }
}
