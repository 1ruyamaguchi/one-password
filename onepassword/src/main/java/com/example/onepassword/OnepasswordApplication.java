package com.example.onepassword;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
@MapperScan(basePackages = "com.example.onepassword.mapper")
public class OnepasswordApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnepasswordApplication.class, args);
	}

	// MyBatisの設定
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		// コンフィグファイルの読み込み
		sessionFactory.setConfigLocation(new ClassPathResource("/mybatis-config.xml"));

		return sessionFactory.getObject();
	}
}