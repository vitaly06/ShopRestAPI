package life.course.pk1.DAO;

import life.course.pk1.Mappers.PrdouctMapper;
import life.course.pk1.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


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

    public int addProduct(Product product) throws IOException, SQLException {
        assert jdbcTemplate != null;
        return jdbcTemplate.update("INSERT INTO products(name, description, file) VALUES(?, ?, ?)",
                product.getName(), product.getDescription(), product.getPhoto());
    }

    public Product getProduct(int id){
        assert jdbcTemplate != null;
        return jdbcTemplate.query("SELECT * FROM products WHERE id = ?",  new Object[]{id}, new PrdouctMapper())
                .stream().findAny().orElse(null);
    }
    public List<Product> getProducts(){
        assert jdbcTemplate != null;
        return jdbcTemplate.query("SELECT * FROM products", new PrdouctMapper());
    }
}
