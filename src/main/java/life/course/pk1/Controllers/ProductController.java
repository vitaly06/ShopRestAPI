package life.course.pk1.Controllers;


import life.course.pk1.DAO.ProductDAO;
import life.course.pk1.Models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin()
public class ProductController {
    @Autowired
    ProductDAO productDAO;

    private final Path uploadDir = Paths.get("uploads");
    public ProductController() throws IOException {
        Files.createDirectories(uploadDir);
    }

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
    public ResponseEntity<String> addProduct(@RequestParam("name") String name,
                                             @RequestParam("description") String description,
                                             @RequestPart("photo") MultipartFile photo,
                                       @RequestParam("price") int price) throws IOException, SQLException
    {
        try {
            String filename = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
            Path filePath = uploadDir.resolve(filename);
            Files.copy(photo.getInputStream(), filePath);

            Product product = new Product();
            product.setName(name);
            product.setDescription(description);
            product.setPrice(price);
            product.setPhoto(filename);

            productDAO.addProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body("Товар успешно добавлен");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Не удалось загрузить фото");
        }
    }

    @GetMapping("/images/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> getImage(@PathVariable String filename) {
        try {
            Path file = uploadDir.resolve(filename);
            Resource resource = new UrlResource(file.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, Files.probeContentType(file))
                        .body(resource);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
