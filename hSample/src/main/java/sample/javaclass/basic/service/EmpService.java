package sample.javaclass.basic.service;

import java.util.HashMap;
import java.util.List;

import sample.javaclass.basic.domain.EmpVO;

public interface EmpService {
   
	//목록보기
	List<EmpVO> empSelect();
    
	//조인한 목록보기
	public List<HashMap> empDept();
	
}