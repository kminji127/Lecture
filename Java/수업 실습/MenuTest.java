import java.awt.*;

public class MenuTest extends Frame {

	MenuBar mb;
	
	public MenuTest() {
		super("MenuBar Test");
		setSize(200, 200);
		setVisible(true);
		
		mb = new MenuBar();
		setMenuBar(mb);
		
		Menu file = new Menu("File");
		MenuItem fileNew = new MenuItem("New");
		MenuItem fileOpen = new MenuItem("Open");		
		MenuItem fileExit = new MenuItem("Exit");
		file.add(fileNew);
		file.addSeparator();
		file.add(fileOpen);
		file.addSeparator();
		file.add(fileExit);
		
		Menu edit = new Menu("Edit");
		Menu sort = new Menu("Sort"); // Edit의 하위 메뉴
		CheckboxMenuItem byname = new CheckboxMenuItem("by Name");
		CheckboxMenuItem bysize = new CheckboxMenuItem("by Size");
		sort.add(byname);
		sort.add(bysize); // Sort 메뉴에 아이템 추가
		edit.add(sort); // Edit에 Sort 메뉴 추가
		
		Menu help = new Menu("Help");
		
		mb.add(file);
		mb.add(edit);
		mb.add(help);
	}

}
