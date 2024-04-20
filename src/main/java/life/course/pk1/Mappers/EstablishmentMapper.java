package life.course.pk1.Mappers;

import life.course.pk1.Models.Establishment;
import life.course.pk1.Models.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstablishmentMapper implements RowMapper<Establishment>{
    @Override
    public Establishment mapRow(ResultSet resultSet, int i) throws SQLException {
        Establishment establishment = new Establishment();
        try{
            establishment.setId(resultSet.getInt("id"));
            establishment.setDescription(resultSet.getString("description"));
        }
        catch (Exception e){
            return new Establishment();
        }
        return establishment;
    }
}
