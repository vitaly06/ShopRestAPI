package life.course.pk1.Mappers;

import life.course.pk1.Models.Product;
import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PrdouctMapper implements RowMapper<Product> {
    @Override
    @Primary
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        /*Product product = new Product();
        String fileName = resultSet.getString("file");
        product.setDescription(resultSet.getString("description"));
        product.setId(resultSet.getInt("id"));
        product.setName(resultSet.getString("name"));
        try {
            File file = new File("./src/main/resources/static/data/" + fileName);
            if (file.exists()) {
                System.out.println("File Exist => " + file.getName() + " :: " + file.getAbsolutePath());
            }
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
                    IOUtils.toByteArray(input));
            product.setFile(multipartFile);
        } catch (IOException e) {
            System.out.println("Exception => " + e.getLocalizedMessage());
        }
        return product;*/
        Product product = new Product();
        String fileName = resultSet.getString("file");
        try {
            File file = new File("./src/main/resources/static/data/" + fileName);
            /*if (file.exists()) {
                //System.out.println("File Exist => " + file.getName() + " :: " + file.getAbsolutePath());
            }*/
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
                    IOUtils.toByteArray(input));
            product.setFile(multipartFile);
        } catch (IOException e) {
            System.out.println("Exception => " + e.getLocalizedMessage());
        }
        try{
            product.setId(resultSet.getInt("id"));
            product.setName(resultSet.getString("name"));
            product.setDescription(resultSet.getString("description"));
        }
        catch (Exception e){
            return new Product();
        }
        return product;
    }
}
