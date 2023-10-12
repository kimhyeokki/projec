package com.khk11.mybatis;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MybatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/khk11/mybatis/config.xml";  //config 파일 위치
			InputStream inputStream = Resources.getResourceAsStream(resource);  //try catch해야함
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		//commit 설정   auto-commit하려면 true, default값은 false임
		return sqlSessionFactory.openSession(true);
	}
}
