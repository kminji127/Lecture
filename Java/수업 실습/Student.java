
public class Student extends Members {
	
	Members students[];
	
	public Student(String name, String idnum) {
		super(name, idnum);
	}
	
	public void setStudents(Members sub[]) {
		students = sub;
	}
	

}
