

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FallingTest extends JFrame {
	GamePanel panel; // 게임 패널
	GameThread gThread; // 게임 스레드
	
	// JFrame의 크기
	static final int JFRAME_WIDTH = 600;
	static final int JFRAME_HEIGHT = 650;
	
	Random random = new Random(); // 랜덤 함수
	
	// 폰트
	File font_file = new File("neodgm.ttf");
	Font font = Font.createFont(Font.TRUETYPE_FONT, font_file);
	Font font_s = font.deriveFont(20f); // 작은 폰트
	Font font_l = font.deriveFont(40f); // 큰 폰트
	
	public FallingTest() throws FontFormatException, IOException {
		super("눈송이는 배고프숙");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		setResizable(false); // 크기 변경 못 하게 설정
		setLocationRelativeTo(null); // 가운데 나타나게
		
		panel = new GamePanel();
		add(panel, BorderLayout.CENTER);
		setVisible(true);

		gThread = new GameThread();
		gThread.start(); // 스레드 시작 : run() 메소드 자동실행
		
		// 키보드 이벤트 리스너
		addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					panel.dx -= 10; // 왼쪽 키를 누르면 눈송이 x좌표가 -10씩 이동함.
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
					panel.dx = 0; // 키보드 이벤트가 멈추면 멈추면 변화량 0
					break;
				case KeyEvent.VK_RIGHT:
					panel.dx = 0; // 키보드 이벤트가 멈추면 변화량 0
					break;
				}
			}
			
			@Override
			public void keyTyped(KeyEvent e) {	}
		});
	}
	
	class GamePanel extends JPanel implements ActionListener { // 게임 패널
		Image backImg, nunsong, bomb;
		int width, height;
		int x, y, w, h; // 눈송이 좌표 및 이미지 절반 폭
		int dx = 0; // 눈송이 이동 방향
		int score; // 점수
		int heart; // 생명
		
		JButton button, sbutton;
		JButton bt1, bt2;
		JDialog stop;
		JPanel bts, btp;
		JLabel label;
		
		// 음식 이미지를 저장하기 위한 ArrayList
		ArrayList<Food> foodList = new ArrayList<Food>();
		ArrayList<Image> foodarr = new ArrayList<Image>(); // 음식 7가지 받는 arraylist
		ArrayList<Image> Heartarr = new ArrayList<Image>();	// 생명 리스트
		ArrayList<Food> BombList = new ArrayList<Food>();	// 폭탄 리스트

		public GamePanel() throws FontFormatException, IOException {
			setLayout(null);
			button = new JButton("||"); // 게임 멈춤 팝업 버튼
			button.setBounds(500, 20, 50, 30);
			button.addActionListener(this);
			button.setFocusable(false); // 눈송이 키가 작동할 수 있도록 버튼에 포커싱을 하지 않음.
			add(button);
			
			width = getWidth();
			height = getHeight();
			
			backImg = Toolkit.getDefaultToolkit().getImage("Images/backimg.png");
			nunsong = Toolkit.getDefaultToolkit().getImage("Images/nunsong.png");
			bomb = Toolkit.getDefaultToolkit().getImage("Images/bomb.png");
			for (int i=0; i<7; i++) { // 음식 이미지
				foodarr.add(Toolkit.getDefaultToolkit().getImage("Images/sushi" + i + ".png"));
			}
			
			// 생명
			heart = 3;
			for (int i = 0; i < 3; i++) { // 하트(생명) 이미지
				Heartarr.add(Toolkit.getDefaultToolkit().getImage("Images/heart_left.png"));
			}
			
			// 일시정지 팝업
			stop = new JDialog();
			stop.setTitle("일시정지");
			stop.setSize(400, 250);
			stop.setLocationRelativeTo(null);

			// 일시정지 팝업 속에서 계속하기, 나가기 버튼이 있을 Panel
			bts = new JPanel();
			bts.setLayout(new GridLayout(2, 0));

			label = new JLabel("게임을 다시 시작하시겠습니까?");
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setFont(font_s);
			bts.add(label);

			btp = new JPanel();
			bt1 = new JButton("계속하기"); // 계속하기 버튼
			bt1.addActionListener(this);

			bt2 = new JButton("나가기"); // 나가기 버튼
			bt2.addActionListener(this);

			btp.add(bt1);
			btp.add(bt2);
			bts.add(btp);
			stop.add(bts);
			stop.setVisible(false); // 우선 일시정지 팝업이 안보이게 한 후 ||버튼을 누르면 보이도록 함.
		}
		
		@Override
		public void paintComponent(Graphics g) { // 이미지 출력
			super.paintComponent(g);
			if(width == 0 || height == 0) {
				width = getWidth();
				height = getHeight();
				backImg = backImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
				nunsong = nunsong.getScaledInstance(70, 90, Image.SCALE_SMOOTH);
				x = width/2;
				y = 475;
				w = 35;
				h = 45;
			}
			
			g.drawImage(backImg, 0, 0, this); // 배경
			
			for(Food f : foodList) { // 음식
				g.drawImage(f.img, f.x-f.w, f.y-f.h, this);
			}
			
			g.drawImage(nunsong, x-w, y-h, this); // 눈송이
			
			g.setFont(font_s);
			g.drawString("Score : " + score, 10, 30); // 점수
			
			for (int i = 0; i < Heartarr.size(); i++) { // 생명
				g.drawImage(Heartarr.get(i), 255 + i*30, 10, 30, 30, this);
			}
			
			for (Food b : BombList) { // 폭탄
				g.drawImage(b.img, b.x - b.w, b.y - b.h, this);
			}
		}
		
		void move() { // 음식, 눈송이 움직이는 메소드
			
			for (int i = BombList.size() - 1; i >= 0; i--) {
				Food b = BombList.get(i);
				b.move();
				if (b.isDead) {
					BombList.remove(i);
					Heartarr.remove(--heart); // 생명 1 감소
					if (heart == 0) { // 생명이 0이 되면
						gThread.stop(); // 스레드 종료
					}
				}
			}
			
			for (int i=foodList.size()-1; i>=0; i--) {
				Food f = foodList.get(i);
				f.move();
				if(f.isDead) foodList.remove(i);
			}
			
			x += dx;
			
			// 화면 밖으로 나가지 않도록 설정
			if(x < w) x = w;
			if(x > width-w) x = width-w;
		}
		
		void makeFood() { // 음식 생성
			if(width == 0 || height == 0) return;
			int n = random.nextInt(20);
			if(n == 0) {
				foodList.add(new Food(foodarr.get(random.nextInt(7)), width, height));
			}
		}
		
		void makeBomb() {
			if (width == 0 || height == 0)
				return;
			int n = new Random().nextInt(150);
			if (n == 0) {
				BombList.add(new Food(bomb, width, height));
			}
		}
		
		void checkCollision() { // 충돌 여부
			for(Food f : foodList) { // 음식 먹었을 때
				int left = f.x - f.w;
				int right = f.x + f.w;
				int top = f.y - f.x;
				int bottom = f.y + f.h;
				
				if(x>left && x<right && y>top && y<bottom) {
					f.isDead = true; // 충돌
					score += random.nextInt(10); // 점수 증가
				}
			}
			
			for (Food b : BombList) { // 폭탄 먹었을 때
				int left = b.x - b.w;
				int right = b.x + b.w;
				int top = b.y - b.x;
				int bottom = b.y + b.h;
				if (x > left && x < right && y > top && y < bottom) {
					b.isDead = true; // 충돌
					score -= 50; // 충돌했을 경우 점수 감소
				}
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button) {
				gThread.suspend(); // ||버튼을 누르면 Thread가 suspend되고 일시정지 팝업이 뜸.
				stop.setVisible(true);
			} else if (e.getSource() == bt1) {
				stop.setVisible(false); // 계속하기 버튼을 누르면 일시정지 팝업이 사라지고 Thread가 resume됨.
				gThread.resume();
				button.setFocusable(false);
			} else if (e.getSource() == bt2) {
				System.exit(0); // 나가기 버튼을 누르면 창이 종료됨.
			}
		}
	}
	
	class GameThread extends Thread { // 게임 스레드
		int speed = 40; // 떨어지는 속도
		
		@Override
		public void run() {
			while(true) {
				panel.makeFood();
				panel.makeBomb();
				panel.move();
				panel.checkCollision();
				panel.repaint(); // 화면 갱신
				try {
					sleep(speed);
				} catch(InterruptedException e) {
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
			
			x = random.nextInt(width - 2*w) + w; // 25 ~ 575
			y = -h;
		}
		
		void move() { // 음식 떨어지는 효과
			y += 5;
			if(y > height+h) {
				isDead = true;
			}
		}
	}
	
	public static void main(String[] args) throws FontFormatException, IOException {
		new FallingTest();
	}

}
