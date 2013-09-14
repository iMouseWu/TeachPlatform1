import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.json.annotations.JSON;
public class testjson extends ActionSupport {
	private Student student;
	private String name;
	
	@JSON(serialize=false) 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	public String execute(){
		student = new Student();
		student.setName(name);
		return this.SUCCESS;
	}

}
