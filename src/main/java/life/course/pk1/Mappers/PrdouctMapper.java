package life.course.pk1.Mappers;

import life.course.pk1.Models.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PrdouctMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        try{
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
            product.setPhoto(resultSet.getString("photo"));
            product.setPrice(resultSet.getInt("price"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return new Product();
        }
        return product;
    }
}
