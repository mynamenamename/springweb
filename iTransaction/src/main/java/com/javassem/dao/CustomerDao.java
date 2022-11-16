package com.javassem.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javassem.vo.CustomerVO;

@Repository
public class CustomerDao {
	@Autowired
	private SqlSessionTemplate ss;
	
	public void insertCustomer(CustomerVO vo){
		ss.insert("customer.insertCustomer", vo);
	}
}
