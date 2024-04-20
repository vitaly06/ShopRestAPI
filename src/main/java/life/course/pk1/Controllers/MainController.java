package life.course.pk1.Controllers;


import life.course.pk1.DAO.*;
import life.course.pk1.Models.*;
import life.course.pk1.Utill.StudentErrorResponse;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class MainController {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    EstablishmentDAO establishmentDAO;
    @Autowired
    DepartmentDAO departmentDAO;
    @Autowired
    FacultyDAO facultyDAO;
    @Autowired
    AdminDAO adminDAO;

    // регистрация пользователя
    @PostMapping("/regUser")
    public ResponseEntity<HttpStatus> regUser(@RequestBody Student student){
        studentDAO.addStudent(student);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    // информация о пользователе
    @GetMapping("/getUser/{id}")
    public Student getUser(@PathVariable("id") int id){
        Student student = studentDAO.getUser(id);
        return student;
    }

    // информация о вузе
    @GetMapping("/getEstablishment/{id}")
    public Establishment getEstablishment(@PathVariable("id") int id){
        Establishment establishment = establishmentDAO.getEstablishment(id);
        return establishment;
    }
    // информация о кафедрах
    @GetMapping("/getDepartment/{id}")
    public Department getDepartment(@PathVariable("id") int id){
        Department department = departmentDAO.getDepartment(id);
        return department;
    }
    // информация о факультетах
    @GetMapping("/getFaculty/{id}")
    public Faculty getFaculty(@PathVariable("id") int id){
        Faculty faculty = facultyDAO.getFaculty(id);
        return faculty;
    }

    // получение данных об админе
    @GetMapping("/getAdmin/{id}")
    public Admin admin(@PathVariable("id") int id){
        Admin admin = adminDAO.getAdmin(id);
        return admin;
    }

    // добавить админа
    @PostMapping("/regAdmin")

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        StudentErrorResponse response = new StudentErrorResponse(
                "Студент с таким id не существует",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404
    }
}
