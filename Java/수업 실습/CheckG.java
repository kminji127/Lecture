import java.awt.*;

public class CheckG {
	
	Checkbox check1, check2, check3;
	Checkbox freshman, sophomore, junior, senior;
	CheckboxGroup grade;

	public CheckG(String msg) {
		Frame f = new Frame(msg);
		f.setLayout(new FlowLayout());
		f.setSize(400, 400);
		f.setVisible(true);
		
		check1 = new Checkbox("One");
		check2 = new Checkbox("Two");
		check3 = new Checkbox("Three");
		
		grade = new CheckboxGroup();
		freshman = new Checkbox("1학년", grade, true);
		sophomore = new Checkbox("2학년", grade, false);
		junior = new Checkbox("3학년", grade, false);
		senior = new Checkbox("4학년", grade, false);
		
		f.add(check1);
		f.add(check2);
		f.add(check3);
		
		f.add(freshman);
		f.add(sophomore);
		f.add(junior);
		f.add(senior);

	}

}
