package life.course.pk1.Controllers;


import jakarta.servlet.http.HttpServletRequest;
import life.course.pk1.DAO.*;
import life.course.pk1.Models.*;
import life.course.pk1.Utill.StudentErrorResponse;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@RestController
@CrossOrigin
public class MainController {
    @Autowired
    StudentDAO studentDAO;
    @Autowired
    ProductDAO productDAO;

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

    // информация о товаре
    @GetMapping("/getProduct/{id}")
    public Product getProduct(@PathVariable("id") int id){
        Product product = productDAO.getProduct(id);
        return product;
    }

    @GetMapping("/getProducts")
    public List<Product> getProducts(){
        List<Product> products = productDAO.getProducts();
        return products;
    }


    @PostMapping("/addProduct")
    public String addImagePost(HttpServletRequest request,
                               @RequestParam("name") String name, @RequestPart("photo") MultipartFile photo,
                               @RequestParam("description") String description,
                               @RequestParam("price") int price) throws IOException, SQLException, SQLException
    {
        Product product = new Product();

        byte[] imageData = photo.getBytes();
        product.setPhoto(imageData);
        product.setDescription(description);
        product.setName(name);
        product.setPrice(price);
        productDAO.addProduct(product);

        return "redirect:/";
    }

    @ExceptionHandler
    private ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException e){
        StudentErrorResponse response = new StudentErrorResponse(
                "Студент с таким id не существует",
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND); // 404
    }
}
