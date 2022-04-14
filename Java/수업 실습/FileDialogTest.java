import java.awt.*;

public class FileDialogTest extends Frame {

	FileDialog fd;
	
	public FileDialogTest(String title) {
		super(title);
		setSize(300, 200);
		setVisible(true);
		
		fd = new FileDialog(this, "FileDialog");
		fd.setVisible(true);
	}
	
	public static void main(String[] args) {
		new FileDialogTest("FileDialogTest");
	}

}
