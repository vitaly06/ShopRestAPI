package life.course.pk1.Mappers;

import life.course.pk1.Models.Admin;
import life.course.pk1.Models.Faculty;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminMapper implements RowMapper<Admin> {
    @Override
    public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
        Admin admin = new Admin();
        try{
            admin.setId(resultSet.getInt("id"));
            admin.setLogin(resultSet.getString("login"));
            admin.setPassword(resultSet.getString("password"));
            admin.setEstablishmentId(resultSet.getInt("establishmentId"));
        }
        catch (Exception e){
            return new Admin();
        }
        return admin;
    }
}
