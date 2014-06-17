package com.joerajeev.carsales.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.joerajeev.carsales.service.Seller;

@Component("sellerDao")
public class SellerDao {

	Logger logger = Logger.getLogger(SellerDao.class.getName());
	
	private NamedParameterJdbcTemplate jdbc;
	
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
		
		String insertSql = "insert into users(name, phone, address, email, password, enabled) "
				+ "values (:name , :phone, :address, :email, :password, 1)"; 

			BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(seller);
			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbc.update(insertSql, source, keyHolder);
			return keyHolder.getKey().intValue();
		
	}
	
	public Seller read(String username) {
		String sql = "select * from users where email = :email";
		Map<String, String> map = new HashMap<String, String>();
		map.put("email", username);
		return (Seller)jdbc.queryForObject(sql, map, new BeanPropertyRowMapper<Seller>(Seller.class));
	}
}
