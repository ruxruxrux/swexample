package dao;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.util.List;


public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void selectUser() {
		System.out.println(jdbcTemplate);
		List<User> results=jdbcTemplate.query("select * from user",
				(ResultSet rs,int rowNum)->{
					User user=new User(rs.getString("user_id"),rs.getString("user_pw"));
			
					return user;
				});
		
		for(User user: results) {
			System.out.println(user.getUserId());
			System.out.println(user.getUserPw());
		}
	}
}
