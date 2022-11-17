package com.javassem.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Data 인자 없는 생성자 함수만 생성
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SampleVO {

	private String name;
	private Integer age;
	private String message;
	
}
