package com.javassem.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//VO(Value Object)


@Data     //SETTER,GETTER,인자없는 생성0자 만들어줌
//@Setter //lombok이가 만들어준다
//@Getter 
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class BoardVO {

	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;


	

}