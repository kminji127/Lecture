import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RacingTest extends JFrame {
	JPanel contentPane, menuPanel, centerPanel;
	JButton startBt, stopBt, suspendBt, resumeBt; // 시작, 종료, 일시정지, 다시시작 버튼
	Thread[] ths;
	Car21[] cars = new Car21[] {
		new Car21(new ImageIcon("car1.png"), 0, 10),
		new Car21(new ImageIcon("car2.png"), 0, 10),
		new Car21(new ImageIcon("car3.png"), 0, 10),
		new Car21(new ImageIcon("car1.png"), 0, 10),
		new Car21(new ImageIcon("car2.png"), 0, 10),
	};
	
	public RacingTest() {
		super("김민지: Runnable Test");
		ths = new Thread[cars.length]; // Car 개수만큼 스레드 만듦
		
		setBounds(100, 10, 1024, 800);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		menuPanel = new JPanel();
		menuPanel.setLayout(new GridLayout(1, 4, 5, 5)); // 1행 4열 5개로 나눈 위치
		startBt = new JButton(new ImageIcon("play.gif"));
		stopBt = new JButton(new ImageIcon("stop.png"));
		suspendBt = new JButton(new ImageIcon("suspend.png"));
		resumeBt = new JButton(new ImageIcon("resume.png"));
		menuPanel.add(startBt);
		menuPanel.add(stopBt);
		menuPanel.add(suspendBt);
		menuPanel.add(resumeBt);
		contentPane.add("North", menuPanel);
		
		centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(cars.length, 1, 5, 5));
		contentPane.add("Center", centerPanel);
		
		startBt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<cars.length; i++) {
					centerPanel.add(cars[i].lane);
				}
				centerPanel.updateUI();
				Car21.rank1 = 0; // 등수 초기화
				game_play();
			}
		});
		
		stopBt.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Thread t:ths) {
					t.stop();
				}
			}
		});
		
		suspendBt.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				for(Thread t:ths) {
					t.suspend();
				}
			}
		});
		
		resumeBt.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<cars.length; i++) { // for(Thread t:ths)와 같은 코드
					ths[i].resume();
				}
			}
		});
	}
	
	// start를 눌렀을 때 시작하는 메소드
	public void game_play() {
		makeThread();
		for(int i=0; i<cars.length; i++) {
			ths[i].start(); // 스레드 시작
		}
	}

	public void makeThread() {
		for(int i=0; i<cars.length; i++) {
			ths[i] = new Thread(cars[i]); // cars[i] = Runnable
		}
	}

}
