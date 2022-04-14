

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.util.*;
import javax.swing.*;

//import MainPage;

import java.io.*;
import java.sql.*;
import javax.sound.sampled.*;

public class Falling2 extends JFrame {
	GamePanel panel; // 게임 패널
	GameThread gThread; // 게임 Thread
	// JFrame의 크기
	static final int JFRAME_WIDTH = 600;
	static final int JFRAME_HEIGHT = 650;
	
	Font font_s;
	Font font_m;
	Font font_l;
	
	Clip clip;	// 오디오
	String Foodtype;
	
	public static int finalscore;
	
	public Falling2(String foodtype) throws FontFormatException, IOException {
		super("눈송이는 배고프숙");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		setResizable(false); // 크기 변경 못 하게 설정
		setLocationRelativeTo(null); // 가운데 나타나게 설정
		Foodtype = foodtype;
		//setVisible(true);

		// 폰트 설정
		File font_file = new File("neodgm.ttf");
		Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
		font_s = font.deriveFont(20f); // 작은 폰트
		font_m = font.deriveFont(30f);
		font_l = font.deriveFont(40f); // 큰 폰트
		
		panel = new GamePanel();
		add(panel, BorderLayout.CENTER);
		//setVisible(true);
		
		gThread = new GameThread(); // Thread생성
		gThread.start(); // Thread 시작하여 run() 메소드 자동실행

		loadAudio("retrogame.wav");	// 오디오
		clip.start();
		
		// 키보드 이벤트 -------------------------------------------------------------------------
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT: // 왼쪽 키를 누르면 눈송이 x좌표가 -10씩 이동함.
					panel.dx -= 10;
					break;
				case KeyEvent.VK_RIGHT:
					panel.dx += 10; // 오른쪽 키를 누르면 눈송이 x좌표가 +10씩 이동함.
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					panel.dx = 0;
					break;
				case KeyEvent.VK_RIGHT:
					panel.dx = 0;
					break;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	private void loadAudio(String pathName) {	// 오디오 설정
		try {
			clip = AudioSystem.getClip();
			File audioFile = new File(pathName);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			clip.open(audioStream);
			clip.loop(clip.LOOP_CONTINUOUSLY); // 반복 재생
			
		} 
		catch (LineUnavailableException e) {e.printStackTrace();}
		catch (UnsupportedAudioFileException e) {e.printStackTrace();}
		catch (IOException e) {e.printStackTrace();}
	}
	
	// 게임 패널 --------------------------------------------------------------------------------
	class GamePanel extends JPanel implements ActionListener { 
		Image backImg, nunsong, bomb;
		int width, height;
		int x, y, w, h; // 눈송이 좌표 및 이미지 절반 폭
		int dx = 0; // 눈송이 이동 방향
		int score; // 점수
		int heart; // 생명
		StopButton button;
		Random random = new Random();

		JButton bt1, bt2;
		JDialog stop;
		JPanel bts, btp;
		JLabel label;

		// 음식 이미지를 저장하기 위한 ArrayList
		ArrayList<Food> foodList = new ArrayList<Food>(); // 랜덤한 음식 받는 arraylist
		ArrayList<Image> foodarr = new ArrayList<Image>(); // 음식 7가지 받는 arraylist
		ArrayList<Image> Heartarr = new ArrayList<Image>();	
		ArrayList<Image> DeadHeartarr = new ArrayList<Image>(); // 생명 리스트
		ArrayList<Food> BombList = new ArrayList<Food>();	// 폭탄 리스트

		public GamePanel() throws FontFormatException, IOException {
			setLayout(null);
			button = new StopButton("||"); // 게임 멈춤 팝업 버튼
			button.setFont(font_m);
			button.setBounds(500, 20, 50, 50);
			button.addActionListener(this);
			button.setFocusable(false); // 눈송이 키가 작동할 수 있도록 버튼에 포커싱을 하지 않음.
			add(button);

			width = getWidth();
			height = getHeight();

			backImg = Toolkit.getDefaultToolkit().getImage("Images/backimg.png"); // 배경 이미지
			nunsong = Toolkit.getDefaultToolkit().getImage("Images/nunsong.png");// 눈송이 이미지
			bomb = Toolkit.getDefaultToolkit().getImage("Images/Bomb.png");
			
			for (int i = 0; i < 7; i++) { // 음식 이미지
				foodarr.add(Toolkit.getDefaultToolkit().getImage("Images/" + Foodtype + i + ".png"));
			}

			//생명부분 총 4번의 기회
			heart = 3;
			for (int i = 0; i < 3; i++) { // 하트(생명) 이미지
				Heartarr.add(Toolkit.getDefaultToolkit().getImage("Images/heart_left.png"));
				DeadHeartarr.add(Toolkit.getDefaultToolkit().getImage("Images/heart_dead.png"));
			}
			
			// 일시정지 팝업 -----------------------------------------------------------------------------------------
			stop = new JDialog();
			stop.setTitle("일시정지");
			stop.setSize(400, 250);
			stop.setLocationRelativeTo(null); // 가운데 나타나게 설정
			stop.setForeground(new Color(249,247,248)); // 배경적용이 안됨..! ?????????????????????????????????????????
			
			// 일시정지 팝업 속에서 계속하기, 나가기 버튼이 있을 Panel
			bts = new JPanel();
			bts.setLayout(new GridLayout(2, 0));

			label = new JLabel("게임을 다시 시작하시겠습니까?");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setFont(font_s);
			bts.add(label);

			btp = new JPanel();
			bt1 = new ButtonChange("계속하기"); // 계속하기 버튼
			bt1.setFont(font_s);
			bt1.addActionListener(this);

			bt2 = new ButtonChange("나가기"); // 나가기 버튼
			bt2.setFont(font_s);
			bt2.addActionListener(this);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			btp.add(bt1);
			btp.add(bt2);
			bts.add(btp);
			stop.add(bts);
			stop.setVisible(false); // 우선 일시정지 팝업이 안보이게 한 후 ||버튼을 누르면 보이도록 함.
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			// 화면에 보여질 부분
			if (width == 0 || height == 0) { // 처음 호출시엔 느려서 보이지 않다가 이후 보임.
				width = getWidth();
				height = getHeight();
				backImg = backImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				nunsong = nunsong.getScaledInstance(70, 90, Image.SCALE_SMOOTH);
				x = width / 2;
				y = 475;
				w = 35;
				h = 25;
			}
			g.drawImage(backImg, 0, 0, this); // 배경 이미지 그리기
			for (Food f : foodList) {
				g.drawImage(f.img, f.x - f.w, f.y - f.h, this); // 음식 이미지 그리기
			}
			
			g.drawImage(nunsong, x - w, y - h, this); // 눈송이 이미지 그리기
			if (score <= 0 ) {
				score = 0;
			}
			g.setFont(font_m);
			g.drawString("Score : " + score, 10, 30); // 점수 표시 나타내기
			for (int i=0; i<3;i++) {
				g.drawImage(DeadHeartarr.get(i), 255 + (i)*30, 10, 30, 30, this);
			}
			for (int i = 0; i < Heartarr.size(); i++) {
				g.drawImage(Heartarr.get(i), 255 + i*30, 10, 30, 30, this); // 생명 이미지 그리기
			}
			
			for (Food b : BombList) {
				g.drawImage(b.img, b.x - b.w, b.y - b.h, this);
			}
		
		}

		// 눈송이 이동 -------------------------
		void move() { 
			x += dx;
			// 눈송이 이미지가 화면 밖으로 나가지 않도록 설정
			if (x < w) // 왼쪽 끝
				x = w;
			if (x > width - w) // 오른쪽 끝
				x = width - w;
		}

		// 음식 생성 --------------------------
		void makeFood() { 
			if (width == 0 || height == 0)
				return;
			
			// 음식 리스트에 넣기
			int n = new Random().nextInt(20);
			if (n == 0) {
				foodList.add(new Food(foodarr.get(random.nextInt(7)), width, height)); // 음식 랜덤으로 떨어지도록 함.
			}
			for (int i = foodList.size() - 1; i >= 0; i--) {
				Food f = foodList.get(i);
				f.move();
				if (f.isDead)
					foodList.remove(i);
			}
		}
		
		// 폭탄 생성 --------------------------
		void makeBomb() throws FontFormatException, IOException {
			if (width == 0 || height == 0)
				return;
			// 폭탄 리스트에 넣기, 생명 설정
			int n = new Random().nextInt(70);
			if (n == 0) {
				BombList.add(new Food(bomb, width, height));
			}
			for (int i = BombList.size() - 1; i >= 0; i--) {
				Food b = BombList.get(i);
				b.move();
				if (b.isDead) {
					
					BombList.remove(i);
					
				}
			}
		}
		
		// 충돌 여부 ------------------------------
		void checkCollision() { 
			for (Food b : BombList) {
				int left = b.x - b.w;
				int right = b.x + b.w;
				int top = b.y - b.x;
				int bottom = b.y + b.h;
				if (x > left && x < right && y > top && y < bottom) {
					b.isDead = true; // 충돌
					
					if (heart == 0) {
						finalscore = score;
						System.out.println(finalscore);
						try {
							clip.stop();
							adddb();
							dispose();
//							new GameOverPage(finalscore);
						} catch (FontFormatException | IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						gThread.stop();
						//new GameOverPage();
					}
					
					System.out.println(""+heart);
					score -= 50; // 충돌했을 경우 점수 감소
					
					Heartarr.remove(--heart);
					System.out.println("Bomb");
				}
			}
			
			for (Food f : foodList) {
				int left = f.x - f.w;
				int right = f.x + f.w;
				int top = f.y - f.x;
				int bottom = f.y + f.h;
				if (x > left && x < right && y > top && y < bottom) {
					f.isDead = true; // 충돌
					score += 10*(random.nextInt(3)+1); // 충돌했을 경우 점수 증가
				}
			}
		}

		// 일시정지 ----------------------------------------------------------------------
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				clip.stop();
				gThread.suspend(); // ||버튼을 누르면 Thread가 suspend되고 일시정지 팝업이 뜸.
				stop.setVisible(true);
			} else if (e.getSource() == bt1) {
				stop.setVisible(false); // 계속하기 버튼을 누르면 일시정지 팝업이 사라지고 Thread가 resume됨.
				clip.start();
				gThread.resume();
				button.setFocusable(false);
			} else if (e.getSource() == bt2) {
				System.exit(0); // 나가기 버튼을 누르면 창이 종료됨.
			}
		}
	}

	// 게임 스레드 ----------------------------------------------------------------------------
	class GameThread extends Thread { 
		int speed = 20; // 떨어지는 속도

		@Override
		public void run() { // 음식이 떨어지는 부분
			while (true) {
				panel.repaint(); // 화면 갱신
				panel.makeFood();
				try {
					panel.makeBomb();
				} catch (FontFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				panel.move();
				panel.checkCollision();
				try {
					sleep(speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public class Food {
		Image img;
		int x, y, w, h;
		int width, height;
		boolean isDead = false; // 생존 여부

		public Food(Image foodImg, int width, int height) {
			this.width = width;
			this.height = height;
			img = foodImg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			w = 25;
			h = 25;
			x = new Random().nextInt(width - 2 * w) + w; // 25 ~ 575
			y = -h;
		}

		void move() { // 음식이 떨어지는 효과
			y += 5;
			if (y > height + h) {
				isDead = true;
			}
		}
	}

	public void adddb() throws FontFormatException, IOException {
		MainPage mp = new MainPage();
//		Start s = new Start();
//		Ranking r = new Ranking(mp.statement);
		
//		System.out.println("유저이름 : " + s.user);
		System.out.println("최종점수  : " + finalscore);
//		r.scoreadd(s.user,finalscore);
//		r.dbconnection();
	}
	
	// 일시정지 팝업 2개 버튼 레이아웃 ----------------------------------------------------------------------------------------
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
	         Color fontcolor = new Color(64,114,175);
	         
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
	
	// 일시정지 버튼 레이아웃 ----------------------------------------------------------------------------------------
		public class StopButton extends JButton {
		      public StopButton(String text) { 
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
		         Color fontcolor = new Color(64,114,175);
		         
		         Graphics2D g2 = (Graphics2D) g; 
		     
		         if (getModel().isArmed()) { // 버튼을 누르면 어둡게
		        	 g2.setColor(bc.darker());
		         } else if (getModel().isRollover()) { // 버튼 위에 올리면 밝게
		        	 g2.setColor(bc.brighter()); 
		         } else { 
		        	 g2.setColor(bc); 
		         }
		         
		         g2.fillOval(0, 0, 50, 50); // 버튼 모양
		         g2.setColor(fontcolor); // 색 설정
		         g2.draw(new Ellipse2D.Float(0,0,50,50));
		         g2.drawString(getText(), 11, 33); // 텍스트 배치
		         g2.dispose(); 
		         
		         super.paintComponent(g); 
		       }
		 }
		/*
	public static void main(String[] args) throws FontFormatException, IOException {
		new Falling2();
	}*/
}