package life.course.pk1.Models;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;


public class Product {
    private int id;
    private String name;
    private MultipartFile image;
    private String description;
    private String file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFile() {
        return file;
    }
    public void setFile(String file) {
        this.file = file;
    }
}
