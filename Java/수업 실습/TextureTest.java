import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import javax.swing.*;

public class TextureTest extends JFrame {

	public TextureTest() {
		setSize(900, 900);
		setTitle("김민지: Java 2D Texture Rendering Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new TexturePanel();
		add(panel);
		setVisible(true);
	}
	
	class TexturePanel extends JPanel {
		Rectangle2D.Double rect;
		BufferedImage img;
		TexturePaint texture;
		Rectangle imgRect;

		public TexturePanel() {
			rect = new Rectangle2D.Double(10, 10, 800, 800);
			
			// Get image : im
			Toolkit tk = Toolkit.getDefaultToolkit();
			Image im = tk.getImage("cat.JPG");
			MediaTracker t = new MediaTracker(this);
			t.addImage(im, 0);
			try {
				t.waitForAll();
			} catch(Exception e) {
				System.out.println("MediaTracker Error");
			}
			
			// Making Texture : texture
			img = new BufferedImage(im.getWidth(this), im.getHeight(this), BufferedImage.TYPE_INT_RGB);
			Graphics2D d2 = img.createGraphics();
			d2.drawImage(img, 0, 0, this);
			imgRect = new Rectangle(0, 0, im.getWidth(this), im.getHeight(this));
			texture = new TexturePaint(img, imgRect);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D) g;
			g2.setPaint(texture);
			
			Ellipse2D.Double circle = new Ellipse2D.Double(20, 20, 160, 160);
			g2.fill(circle);
			Ellipse2D.Double circle2 = new Ellipse2D.Double(200, 20, 160, 160);
			g2.fill(circle2);
			
			Rectangle2D rect2 = new Rectangle2D.Double(200, 200, 600, 600);
			g2.fill(rect2);
		}
	}

	public static void main(String[] args) {
		new TextureTest();
	}

}
