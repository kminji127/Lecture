import java.awt.*;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class TreeTest1 {

	JFrame jf;
	JScrollPane sp;
	JTree tree;
	DefaultMutableTreeNode jcomponent, jpanel, jtextcomponent, jtree, jtextarea, jtextfield;
	
	public TreeTest1(String msg) {
		jf = new JFrame(msg);
		jf.setSize(300, 200);
		jf.setVisible(true);
		
		jcomponent = new DefaultMutableTreeNode("JComponent");
		
		jpanel = new DefaultMutableTreeNode("JPanel");
		jtextcomponent = new DefaultMutableTreeNode("JTextComponent");
		jtree = new DefaultMutableTreeNode("Jtree");
		
		jcomponent.add(jpanel);
		jcomponent.add(jtextcomponent);
		jcomponent.add(jtree);
		
		jtextarea = new DefaultMutableTreeNode("JTextArea");
		jtextfield = new DefaultMutableTreeNode("JTextField");
		
		jtextcomponent.add(jtextarea);
		jtextcomponent.add(jtextfield);
		
		tree = new JTree(jcomponent);
		sp = new JScrollPane(tree);
		
		jf.getContentPane().add(sp, BorderLayout.CENTER);
	}

}
