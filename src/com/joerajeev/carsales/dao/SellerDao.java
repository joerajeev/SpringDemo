package com.joerajeev.carsales.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.joerajeev.carsales.service.Seller;

@Component("sellerDao")
public class SellerDao {

	Logger logger = Logger.getLogger(SellerDao.class.getName());
	
	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	/**
	 * 
	 * @param seller
	 * @return id of the user created
	 * @throws DataAccessException
	 */
	public int create(Seller seller) throws DataAccessException {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", seller.getName());
		params.addValue("phone", seller.getPhone());
		params.addValue("address", seller.getAddress());
		params.addValue("email", seller.getEmail());
		params.addValue("password", passwordEncoder.encode(seller.getPassword()));
		params.addValue("enabled", 1);
		
		String insertSql = "insert into users(name, phone, address, email, password, enabled) "
				+ "values (:name , :phone, :address, :email, :password, :enabled)"; 

			//BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(seller);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbc.update(insertSql, params, keyHolder);
			return keyHolder.getKey().intValue();
		
	}
	
	public Seller read(String username) {
		String sql = "select * from users where email = :email";
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", username);
		Seller seller =  (Seller)jdbc.queryForObject(sql, map, new BeanPropertyRowMapper<Seller>(Seller.class));
		
		//Decode the password
		//seller.setPassword(passwordEncoder.);
		return seller;
	}
}
