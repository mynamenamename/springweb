package myclass.model;

public class MemberVO {
    
	private String id;
	private String name;
	private int age;
	
	private boolean state;
	
	
	
	//setter, getter > getter가 is로 생성됨
	//boolean이기 때문에~~
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	
	
	//setter, getter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
