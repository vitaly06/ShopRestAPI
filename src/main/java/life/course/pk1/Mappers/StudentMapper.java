package life.course.pk1.Mappers;

import life.course.pk1.Models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet resultSet, int i) throws SQLException {
        Student student = new Student();
        try{
            student.setId(resultSet.getInt("id"));
            student.setEmail(resultSet.getString("email"));
            student.setFio(resultSet.getString("fio"));
            student.setFaculty(resultSet.getString("faculty"));
            student.setDepartment(resultSet.getString("department"));
            student.setGroupe(resultSet.getString("groupe"));
            student.setPassword(resultSet.getString("password"));
            student.setAbout(resultSet.getString("about"));
            student.setPhoto(resultSet.getString("photo"));
        }
        catch (Exception e){
            return new Student();
        }
        return student;
    }
}
