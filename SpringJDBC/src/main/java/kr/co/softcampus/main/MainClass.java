package kr.co.softcampus.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import kr.co.softcampus.beans.JdbcBean;
import kr.co.softcampus.config.BeanConfigClass;
import kr.co.softcampus.db.JdbcDAO;

public class MainClass {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfigClass.class);
		
		//dao 가져오기
		JdbcDAO dao = ctx.getBean(JdbcDAO.class);
		
		//insert
//		JdbcBean bean1 = new JdbcBean();
//		bean1.setInt_data(1);
//		bean1.setStr_data("안녕하세요");
//		dao.insert_data(bean1);
//		
//		JdbcBean bean2 = new JdbcBean();
//		bean2.setInt_data(2);
//		bean2.setStr_data("안녕하세요2");
//		dao.insert_data(bean2);
//		
//		System.out.println("저장완료");
		
		// update
//		JdbcBean bean4 = new JdbcBean();
//		bean4.setInt_data(1);
//		bean4.setStr_data("문자열2");
//		dao.update_data(bean4);
		
		// delete
		dao.delete_data(1);
		
		
		// select
		List<JdbcBean> list = dao.select_data();
		
		for(JdbcBean bean3 : list ) {
			System.out.printf("int_data : %d\n", bean3.getInt_data());
			System.out.printf("str_data : %s\n", bean3.getStr_data());
			System.out.println("=========================================");
		}
		
	
		
		ctx.close();
	}

}













