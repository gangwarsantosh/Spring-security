package spring.security.SpringSecurity.student;

public class Student {
	
	
	private Integer id;
	private String name;
	private Integer marks;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getMarks() {
		return marks;
	}


	public void setMarks(Integer marks) {
		this.marks = marks;
	}


	public Student(Integer id, String name, Integer marks) {
		super();
		this.id = id;
		this.name = name;
		this.marks = marks;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", marks=" + marks + "]";
	}
	

}
