import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class TreeTest2 {

	JFrame jf;
	JScrollPane sp;
	JTree tree;
	DefaultMutableTreeNode root, parent, child1, child2;
	DefaultTreeCellRenderer renderer;
	
	public TreeTest2(String msg) {
		jf = new JFrame(msg);
		jf.setSize(300, 200);
		jf.setVisible(true);
		
		root = new DefaultMutableTreeNode("ROOT");
		parent = new DefaultMutableTreeNode("PARENT");
		child1 = new DefaultMutableTreeNode("CHILD1");
		child2 = new DefaultMutableTreeNode("CHILD2");
		
		root.add(parent);
		parent.add(child1);
		parent.add(child2);
		
		tree = new JTree(root);
		sp = new JScrollPane(tree);
		
		renderer = new DefaultTreeCellRenderer();
		renderer.setLeafIcon(new ImageIcon("Document.png"));
		renderer.setClosedIcon(new ImageIcon("Folder.png"));
		renderer.setOpenIcon(new ImageIcon("FolderOpen.png"));
		tree.setCellRenderer(renderer);
		tree.setEditable(true);
		
		jf.getContentPane().add(sp, "Center");
		
		// Event for Tree Node : 현재 경로와 위치를 출력하는 함수
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode node = (DefaultMutableTreeNode)(e.getPath().getLastPathComponent());
				Object nodeObj = node.getUserObject();
				System.out.println("Path = " + e.getPath());
				System.out.println("Object = " + nodeObj);
			}
		});
	}

}
