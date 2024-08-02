package life.course.pk1.Mappers;

import life.course.pk1.Models.Product;
import life.course.pk1.Models.Student;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PrdouctMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        try{
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setImage(resultSet.getBlob("image"));
            product.setDescription(resultSet.getString("description"));
        }
        catch (Exception e){
            return new Product();
        }
        return product;
    }
}
