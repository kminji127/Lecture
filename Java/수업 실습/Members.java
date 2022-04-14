
public class Members {
	
	String name;
	String dept;
	String major;
	int id;
	
	public Members(String name, String dept) {
		this.name = name;
		this.dept = dept;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setMajor(String major) {
		this.major = major;
	}
	
	public void work() {
		System.out.println("\t Student: \"" + name + "\" does his best.");
	}

}
