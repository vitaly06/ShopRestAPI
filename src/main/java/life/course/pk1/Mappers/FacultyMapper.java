package life.course.pk1.Mappers;

import life.course.pk1.Models.Department;
import life.course.pk1.Models.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FacultyMapper implements RowMapper<Faculty> {
    @Override
    public Faculty mapRow(ResultSet resultSet, int i) throws SQLException {
        Faculty faculty = new Faculty();
        try{
            faculty.setName(resultSet.getString("name"));
            faculty.setEstablishmentId(resultSet.getInt("Department"));
        }
        catch (Exception e){
            return new Faculty();
        }
        return faculty;
    }
}
