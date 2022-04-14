

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.io.*;
import java.sql.*;

public class MainPage extends JFrame implements ActionListener{
	JPanel p1, p2, p3;
	JLabel title, imglabel, label;
	JRadioButton[] option;
	ImageIcon pre;
//	ButtonChange type1, type2;
//	Start s = new Start();
	Color backcolor, fontcolor;
	static final int JFRAME_WIDTH = 600;
	static final int JFRAME_HEIGHT = 650;
	static Statement statement;
	public static String foodtype;
	
	public MainPage() throws FontFormatException, IOException {
		// 색 -----------------------------------------------------------------
		fontcolor = new Color(249,247,248);
		backcolor = new Color(64,114,175);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		setResizable(false); // 크기 변경 못 하게 설정
		setLocationRelativeTo(null); // 가운데 나타나게 설정
		
		// 폰트 -----------------------------------------------------------------
		File font_file = new File("neodgm.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
		Font font_s = font.deriveFont(20f); // 작은 폰트
		Font font_l = font.deriveFont(40f); // 큰 폰트
				
		setTitle("눈송이는 배고프숙");
		setLayout(null);
		getContentPane().setBackground(backcolor);
		
		// 메인 타이틀 -----------------------------------------------------------------
		title = new JLabel("눈송이는 배고프숙");
		title.setFont(font_l);
		title.setForeground(fontcolor); // 글씨 색 설정
		title.setBounds(120, 80, 600, 50);
		add(title);
		
		// 음식 종류 선택 -----------------------------------------------------------------
		p1 = new JPanel();
		p1.setLayout(new GridLayout(4, 0));
		
		option = new JRadioButton[4];
		ButtonGroup options = new ButtonGroup();
		
		option[0] = new JRadioButton(" 패스트푸드", true);
		option[1] = new JRadioButton(" 일식");
		option[2] = new JRadioButton(" 과일");
		option[3] = new JRadioButton(" 디저트");
		
		
		for (int i = 0; i < 4; i ++) {
			option[i].addActionListener(this);
			option[i].setFont(font_s); // 폰트 설정
			option[i].setForeground(fontcolor); // 글씨 색
			option[i].setBackground(backcolor); // option 배경색
			options.add(option[i]);
		}
		
		for (int i = 0; i < 4; i ++) {
			p1.add(option[i]);
		}
		
		p1.setBounds(30, 200, 150, 200);
		add(p1);
		
		// 게임 프리뷰 -----------------------------------------------------------------
		p2 = new JPanel();
		pre = new ImageIcon("Images/fastfoodpreview.gif");
		imglabel = new JLabel(pre);
		p2.setBounds(220, 200, 300, 300);
		p2.setBackground(backcolor);
		p2.add(imglabel);
		add(p2);
		
		// 게임 옵션 버튼 -----------------------------------------------------------------
		p3 = new JPanel();
		p3.setBackground(backcolor);
		p3.setBounds(300, 550, 250, 50);
		
//		type1 = new ButtonChange("타임어택");
//		type1.addActionListener(this);
//		type1.setFont(font_s);
//		type2 = new ButtonChange("무기한");
//		type2.addActionListener(this);
//		type2.setFont(font_s);
//		
//		p3.add(type1);
//		p3.add(type2);
//		add(p3);
	}
	
/*
	protected void paintComponent(Graphics g) {
		super.paintComponents(g);
        Color bc = new Color(218,226,239); //배경색 결정
        
        Graphics2D g2 = (Graphics2D) g; 
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        					RenderingHints.VALUE_ANTIALIAS_ON); 
        g2.fill(new RoundRectangle2D.Float(10,10,70,80,20,20));
        g2.setPaint(bc); 
     }
	
	public class ButtonChange extends JButton {
	      public ButtonChange(String text) { 
	    	  super(text); 
	    	  decorate(); 
	      }
	      
	      protected void decorate() { // 버튼 초기값 초기화
	    	  setBorderPainted(false); 
	    	  setOpaque(false); 
	      } 
	     
	      @Override 
	      protected void paintComponent(Graphics g) {
	         Color bc = new Color(218,226,239); //배경색 결정
	         
	         Graphics2D graphics = (Graphics2D) g; 
	         int w = getWidth(); 
	         int h = getHeight(); 
	         
	         // 글씨의 외곽 부드럽게 
	         // 해도 되고 안해도 될듯!
	         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
	     
	         if (getModel().isArmed()) { // 버튼을 누르면 어둡게
	        	 graphics.setColor(bc.darker());
	         } else if (getModel().isRollover()) { // 버튼 위에 올리면 밝게
	        	 graphics.setColor(bc.brighter()); 
	         } else { 
	        	 graphics.setColor(bc); 
	         }
	       
	         graphics.fillRoundRect(0, 0, w, h, 10, 10); // 버튼 모양
	         
	         FontMetrics fontMetrics = graphics.getFontMetrics(); // 현재 설정된 폰트의 정보 가짐
	         Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds(); // 범위 
	         
	         int textX = (w - stringBounds.width) / 2; // 텍스트의 x축 위치 설정
	         int textY = (h - stringBounds.height) / 2 + fontMetrics.getAscent(); // 텍스트의 y축 위치 설정
	         
	         graphics.setColor(fontcolor); // 색 설정
	         graphics.drawString(getText(), textX, textY); // 텍스트 배치
	         graphics.dispose(); 
	         
	         super.paintComponent(g); 
	       }
	 }
	 */
	/*
	// 시작하시겠습니까 페이지 ---------------------------------------------------------------------
	public class Start extends JFrame implements ActionListener {

		JPanel p1, p2, p3;
		JLabel userName, alert;
		JTextField name;
		ButtonChange yes, no;
		//Falling2 f2 = new Falling2();
		
		public Start() throws FontFormatException, IOException {
			super();
			setTitle("게임시작");
			setSize(400, 250);
			
			// 폰트
			File font_file = new File("neodgm.ttf");
			Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
			Font font_s = font.deriveFont(20f);
			
			// 패널 1
			p1 = new JPanel();
			userName = new JLabel("User Name");
			userName.setFont(font_s);
			name = new JTextField(20);
			name.setFont(font_s);
		
			p1.add(userName);
			p1.add(name);
			
			
			// 패널 2
			p2 = new JPanel();
			alert = new JLabel("게임을 시작하시겠습니까?");
			alert.setFont(font_s);
			p2.add(alert);
		
			// 패널 3
			p3 = new JPanel();
			yes = new ButtonChange("예");
			yes.setFont(font_s);
			yes.addActionListener(this); // 게임 화면으로 이동하도록 설정해야 함
		
			no = new ButtonChange("아니오");
			no.setFont(font_s);
			no.addActionListener(this);
		
			p3.add(yes);
			p3.add(no);
		
			add(p1, "North");
			add(p2, "Center");
			add(p3, "South");
		}
		// 옵션 123 바꿔야됨
		public void actionPerformed(ActionEvent e) {
			user = name.getText(); // textfield에서 입력받은 값 가져오기
			if(e.getSource() == yes ) {
				try {
					Falling2 f2 = new Falling2(foodtype);
					f2.setVisible(true);
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				setVisible(false);
			} else if(e.getSource() == no) {
				dispose();
				setVisible(false);
					
			}
		}
	}
	*/
	public static void main (String args[]) throws FontFormatException, IOException {
		statement = checkdb();
		MainPage mp = new MainPage();
		mp.setVisible(true);
	}
	
	public static Statement checkdb() {
		Connection con = null;
		 Statement st = null;
		 
		try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://us-cdbr-east-04.cleardb.com/heroku_f91ffea5f7054c5";
            con = DriverManager.getConnection(url, "bcb459354f7338", "eaaea278");
            st = con.createStatement();
            System.out.println("연결 성공");
        }
        catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
        }
        catch(SQLException e){
            System.out.println("에러: " + e);
        }
		return st;
	}
	
	// 옵션 별로 프리뷰 이미지 다르게 설정
	@Override
	public void actionPerformed(ActionEvent e) {
		if (option[0].isSelected()==true) {
			imglabel.setIcon(new ImageIcon("Images/fastfoodpre.gif"));
			foodtype = "fastfood";
		} else if (option[1].isSelected()==true) {
			imglabel.setIcon(new ImageIcon("Images/japanesepre.gif"));
			foodtype = "sushi";
		} else if (e.getSource() == option[2]) {
			imglabel.setIcon(new ImageIcon("Images/fruitpre.gif"));
			foodtype = "fruit";
		} else if (e.getSource() == option[3]) {
			imglabel.setIcon(new ImageIcon("Images/dessertpre.gif"));
			foodtype = "dessert";
		}
		
//		if (e.getSource() == type1) {
//			s.setVisible(true);
//		} else if (e.getSource() == type2) {
//			s.setVisible(true);
//		}
	}
}