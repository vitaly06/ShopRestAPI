package life.course.pk1.DAO;

import life.course.pk1.Mappers.AdminMapper;
import life.course.pk1.Mappers.FacultyMapper;
import life.course.pk1.Models.Admin;
import life.course.pk1.Models.Faculty;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class AdminDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AdminDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public AdminDAO(){
        jdbcTemplate = null;
    }

    /*public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO students(email, fio, faculty, department, groupe, password) VALUES(?, ?, ?, ?, ?, ?)",
                student.getEmail(), student.getFio(), student.getFaculty(), student.getDepartment(), student.getGroupe(), student.getPassword());
    }*/
    public Admin getAdmin(int id){
        return jdbcTemplate.query("SELECT * FROM admins WHERE id = ?",  new Object[]{id}, new AdminMapper())
                .stream().findAny().orElseThrow(StudentNotFoundException::new);
    }
}
