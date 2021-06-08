package kr.co.softcampus.db;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kr.co.softcampus.beans.JdbcBean;

@Component
public class JdbcDAO {
	
	//jdbc 관리 객체를 주입 받는다.
	
	@Autowired
	private JdbcTemplate db;
	
	
	// Mapper 주입받는다
	@Autowired
	private MapperClass mapper;
	
	
	//저장
	public void insert_data(JdbcBean bean1) {
		String sql="insert into jdbc_table (int_data,str_data) values (?, ?)";
		db.update(sql, bean1.getInt_data(), bean1.getStr_data());
		
	}
	//가져오기 
	public List<JdbcBean> select_data(){
		String sql= "select int_data, str_data from jdbc_table";
		List<JdbcBean> list = db.query(sql,mapper);
		return list;
	}
	
	// 수정
	public void update_data(JdbcBean bean){
		String sql = "update jdbc_table set str_data = ? where int_data = ?";
		db.update(sql, bean.getStr_data(), bean.getInt_data());
	}
	
	public void delete_data(int int_data) {
		String sql = "delete from jdbc_table where int_data = ?";
		db.update(sql, int_data);
	}
	

}
