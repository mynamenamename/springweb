package sample.javaclass.basic.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sample.javaclass.basic.domain.EmpVO;

@Repository
public class EmpDAOImpl implements EmpDAO {
    //DB 연결
	@Autowired
	private SqlSessionTemplate sqlSess;
	
	@Override
	public List<EmpVO> empSelect() {
		return sqlSess.selectList("EmpDao.empSelect"); //mapper에서 이름 찾기
	}
	
	public List<HashMap> empDept() { //interface > public
		return sqlSess.selectList("EmpDao.empDept");   //mapper에서 이름 찾기
		
	}
	
	
	
	
}
