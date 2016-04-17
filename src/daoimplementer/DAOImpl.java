package daoimplementer;

import org.dhaval.model.Circle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dhaval on 4/8/2016.
 */

@Component

public class DAOImpl {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

//    public Circle getCircle(int circleId) {
//
//        Connection con = null;
//        Circle circle = null;
//        try {
//            //String driv = "org.apache.derby.jdbc.ClientDriver";
//            //Class.forName(driv).newInstance();
//            //con = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
//            con = dataSource.getConnection();
//            PreparedStatement ps = con.prepareStatement("SELECT * FROM circle WHERE id = ?");
//            ps.setInt(1, circleId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                circle = new Circle(circleId, rs.getString("name"));
//            }
//            rs.close();
//            ps.close();
//            return circle;
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//        finally {
//            try{
//                if(con != null) {
//                    con.close();
//                }
//            }
//            catch (SQLException ex){
//                ex.printStackTrace();
//            }
//        }
//        return circle;
//    }

    public int getCircleCount(){
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return jdbcTemplate.queryForObject(sql,new Object[]{}, Integer.class);
    }

    public Circle getCircleById(int id){
        String sql = "SELECT * FROM CIRCLE WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new CircleMapper());
    }

    public List<Circle> getAllCircles(){
        String sql = "SELECT * FROM CIRCLE";
        return jdbcTemplate.query(sql, new CircleMapper());
    }

//    public void insertCircle(Circle circle){
//        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (?, ?)";
//        jdbcTemplate.update(sql, new Object[]{circle.getId(), circle.getName()});
//    }

    public void insertCircle(Circle circle){
        String sql = "INSERT INTO CIRCLE (ID, NAME) VALUES (:id, :name)";
        SqlParameterSource namedParameter = new MapSqlParameterSource("id", circle.getId())
                                                    .addValue("name", circle.getName());
        namedParameterJdbcTemplate.update(sql, namedParameter);

    }

    private static final class CircleMapper implements RowMapper<Circle>{

        @Override
        public Circle mapRow(ResultSet rs, int rowNum) throws SQLException {
            Circle circle = new Circle(rs.getInt("id"), rs.getString("name"));
            return circle;
        }
    }
    public DataSource getDataSource() {
        return dataSource;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
