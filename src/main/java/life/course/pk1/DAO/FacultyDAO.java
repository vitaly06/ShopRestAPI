package life.course.pk1.DAO;

import life.course.pk1.Mappers.DepartmentMapper;
import life.course.pk1.Mappers.FacultyMapper;
import life.course.pk1.Models.Department;
import life.course.pk1.Models.Faculty;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FacultyDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public FacultyDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public FacultyDAO(){
        jdbcTemplate = null;
    }

    /*public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO students(email, fio, faculty, department, groupe, password) VALUES(?, ?, ?, ?, ?, ?)",
                student.getEmail(), student.getFio(), student.getFaculty(), student.getDepartment(), student.getGroupe(), student.getPassword());
    }*/
    public Faculty getFaculty(int id){
        return jdbcTemplate.query("SELECT * FROM facultys WHERE id = ?",  new Object[]{id}, new FacultyMapper())
                .stream().findAny().orElseThrow(StudentNotFoundException::new);
    }
}
