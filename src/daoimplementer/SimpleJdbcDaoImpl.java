package daoimplementer;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by Dhaval on 4/9/2016.
 */
public class SimpleJdbcDaoImpl extends JdbcDaoSupport {
    public int getCircleCount(){
        String sql = "SELECT COUNT(*) FROM CIRCLE";
        return this.getJdbcTemplate().queryForObject(sql,new Object[]{}, Integer.class);
    }
}
