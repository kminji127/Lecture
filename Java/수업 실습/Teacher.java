
public class Teacher extends Members {
	
	String dept;

	public Teacher(String name, String idnum, String dept) {
		super(name, idnum);
		this.dept = dept;
	}
	
	public void work() {
		System.out.println("Teacher: \"" + name + "\" studies hard with his students in " + dept + " dept.");
	}

}
