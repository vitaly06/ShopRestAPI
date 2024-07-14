package life.course.pk1.DAO;

import life.course.pk1.Mappers.PrdouctMapper;
import life.course.pk1.Mappers.StudentMapper;
import life.course.pk1.Models.Product;
import life.course.pk1.Models.Student;
import life.course.pk1.Utill.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProductDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public ProductDAO(){
        jdbcTemplate = null;
    }

    public int addProduct(Product product){
        return jdbcTemplate.update("INSERT INTO products(name, image, description) VALUES(?, ?, ?)",
                product.getName(), product.getImage(), product.getDescription());
    }
    public Product getProduct(int id){
        return jdbcTemplate.query("SELECT * FROM products WHERE id = ?",  new Object[]{id}, new PrdouctMapper())
                .stream().findAny().orElseThrow();
    }
}