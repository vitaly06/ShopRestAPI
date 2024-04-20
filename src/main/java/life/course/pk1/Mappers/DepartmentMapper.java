package life.course.pk1.Mappers;

import life.course.pk1.Models.Department;
import life.course.pk1.Models.Establishment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DepartmentMapper implements RowMapper<Department> {
    @Override
    public Department mapRow(ResultSet resultSet, int i) throws SQLException {
        Department department = new Department();
        try{
            department.setName(resultSet.getString("name"));
            department.setEstablishmentId(resultSet.getInt("department"));
        }
        catch (Exception e){
            return new Department();
        }
        return department;
    }
}
