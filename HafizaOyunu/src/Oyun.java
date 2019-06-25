import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Oyun extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Oyun frame = new Oyun();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	ImageIcon box = new ImageIcon(Oyun.class.getResource("/images/box.png"));
	ImageIcon block = new ImageIcon(Oyun.class.getResource("/images/block.png"));
	ImageIcon coin = new ImageIcon(Oyun.class.getResource("/images/coin.png"));
	ImageIcon luigi = new ImageIcon(Oyun.class.getResource("/images/luigi.png"));
	ImageIcon mario = new ImageIcon(Oyun.class.getResource("/images/mario.png"));
	ImageIcon pirana = new ImageIcon(Oyun.class.getResource("/images/piranha1.png"));
	ImageIcon peach = new ImageIcon(Oyun.class.getResource("/images/peach.png"));
	ImageIcon star = new ImageIcon(Oyun.class.getResource("/images/star1.png"));
	ImageIcon yoshi = new ImageIcon(Oyun.class.getResource("/images/yoshi1.png"));
	
	//ImageIcon[] icon = new ImageIcon[] {block,coin,luigi,mario,pirana,peach,star,yoshi};
	
	ImageIcon[] btnicons = new ImageIcon[] {block,coin,luigi,mario,pirana,peach,star,yoshi,block,coin,luigi,mario,pirana,peach,star,yoshi};
	
	JButton[] btn = new JButton[16];
	
	int bekle = 3;
	boolean basladi = false;
	JLabel sure ;
	boolean AcikKartVar = false;
	JButton AcikKart;
	JPanel OYUN_PNL;
	JPanel kazandin;
	JLabel lblSure;
	
	JButton btnKolay,btnOrta,btnZor;
	
	
	
	public Oyun() {
		
		setResizable(false);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 520);
		//setBackground(new Color(69, 232, 11));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(117, 239, 148));
		
		JLabel Xdistance = new JLabel("");
		Xdistance.setBounds(0, -20, 46, 14);
		contentPane.add(Xdistance);
		
		JLabel Ydistance = new JLabel("");
		Ydistance.setBounds(50, -20, 46, 14);
		contentPane.add(Ydistance);
		
		btnOrta = new JButton("orta");
		btnOrta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bekle = 3;
				btnOrta.setVisible(false);
				btnZor.setVisible(false);
				btnKolay.setVisible(false);
			}
		});
		btnOrta.setFont(new Font("ObelixPro", Font.PLAIN, 10));
		btnOrta.setBackground(new Color(189, 128, 242));
		btnOrta.setBounds(305, 56, 65, 25);
		btnOrta.setFocusable(false);
		contentPane.add(btnOrta);
		
		btnZor = new JButton("ZOR");
		btnZor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				bekle = 0;
				btnOrta.setVisible(false);
				btnZor.setVisible(false);
				btnKolay.setVisible(false);
			}
		});
		btnZor.setFont(new Font("ObelixPro", Font.PLAIN, 10));
		btnZor.setBackground(new Color(255,0,0));
		btnZor.setBounds(343, 26, 65, 25);
		contentPane.add(btnZor);
		btnZor.setFocusable(false);
		
		btnKolay = new JButton("KOLAY");
		btnKolay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				bekle = 6;
				btnOrta.setVisible(false);
				btnZor.setVisible(false);
				btnKolay.setVisible(false);
			}
		});
		btnKolay.setFont(new Font("ObelixPro", Font.PLAIN, 10));
		btnKolay.setFocusable(false);
		btnKolay.setBackground(new Color(0,255,0));
		btnKolay.setBounds(250, 28, 83, 25);
		contentPane.add(btnKolay);
		
		JPanel TitleBar_PNL = new JPanel();
		TitleBar_PNL.setBounds(0, 0, 450, 25);
		contentPane.add(TitleBar_PNL);
		TitleBar_PNL.setBackground(new Color(0,0,0,0));
		TitleBar_PNL.setLayout(null);
		
		JButton CloseButton = new JButton("");
		CloseButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				dispose();
			}
		});
		CloseButton.setBounds(405, 0, 25, 25);
		TitleBar_PNL.add(CloseButton);
		CloseButton.setIcon(new ImageIcon(Oyun.class.getResource("/images/Close.png")));
		CloseButton.setFocusable(false);
		
		
		
		JLabel TitleBar = new JLabel("");
		TitleBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent ev) {
				Xdistance.setText(""+ (ev.getXOnScreen() - getX()));
				Ydistance.setText(""+(ev.getYOnScreen()-getY()));
			}
		});
		TitleBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {		
				int xdis = Integer.parseInt(Xdistance.getText());
				int ydis = Integer.parseInt(Ydistance.getText());
				setLocation(e.getXOnScreen()-xdis,e.getYOnScreen()-ydis);
			
			}
		});
		
		JLabel lblHafzaOyunu = new JLabel("HAFIZA OYUNU");
		lblHafzaOyunu.setHorizontalAlignment(SwingConstants.CENTER);
		lblHafzaOyunu.setHorizontalTextPosition(SwingConstants.LEADING);
		lblHafzaOyunu.setFont(new Font("ObelixPro", Font.BOLD, 11));
		lblHafzaOyunu.setForeground(Color.WHITE);
		lblHafzaOyunu.setBounds(0, 0, 119, 25);
		TitleBar_PNL.add(lblHafzaOyunu);
		TitleBar.setIcon(new ImageIcon(Oyun.class.getResource("/images/TitleBar.png")));
		TitleBar.setBounds(0, 0, 430, 25);
		TitleBar_PNL.add(TitleBar);
		
		kazandin = new JPanel();
		kazandin.setVisible(false);
		kazandin.setBounds(10, 75, 413, 420);
		kazandin.setBackground(new Color(117, 239, 148));
		contentPane.add(kazandin);
		kazandin.setLayout(null);
		
		JLabel lblTebrikler = new JLabel("OYUNU KAZANDINIZ !");
		lblTebrikler.setFont(new Font("ObelixPro", Font.PLAIN, 30));
		lblTebrikler.setHorizontalAlignment(SwingConstants.CENTER);
		lblTebrikler.setBounds(0, 83, 413, 82);
		kazandin.add(lblTebrikler);
		
		JLabel label = new JLabel("TEBRIKLER !!!");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("ObelixPro", Font.PLAIN, 30));
		label.setBounds(0, 0, 413, 82);
		kazandin.add(label);
		
		lblSure = new JLabel("SURE: ");
		lblSure.setHorizontalAlignment(SwingConstants.LEFT);
		lblSure.setFont(new Font("ObelixPro", Font.PLAIN, 30));
		lblSure.setBounds(0, 187, 413, 82);
		kazandin.add(lblSure);
		
		
		
		
		
		OYUN_PNL = new JPanel();
		OYUN_PNL.setBounds(10, 75, 413, 420);
		contentPane.add(OYUN_PNL);
		OYUN_PNL.setLayout(null);
		
		
		
		
		JButton button = new JButton("");
		button.setFont(new Font("Agency FB", Font.PLAIN, 11));
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clicked(button, 0);
			}
		});
		btn[0] = button;
		button.setIcon(btnicons[0]);
		button.setBounds(10, 11, 90, 90);
		OYUN_PNL.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setFont(new Font("Algerian", Font.PLAIN, 11));
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				clicked(button_1, 1);
			}
		});
		btn[1] = button_1;
		button_1.setIcon(btnicons[1]);
		button_1.setBounds(110, 11, 90, 90);
		OYUN_PNL.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setFont(new Font("AmazDooMLeft", Font.PLAIN, 11));
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_2, 2);
			}
		});
		btn[2] = button_2;
		button_2.setIcon(btnicons[2]);
		button_2.setBounds(210, 11, 90, 90);
		OYUN_PNL.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setFont(new Font("Arial", Font.PLAIN, 11));
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_3, 3);
			}
		});
		btn[3] = button_3;
		button_3.setIcon(btnicons[3]);
		button_3.setBounds(310, 11, 90, 90);
		OYUN_PNL.add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setFont(new Font("Auto Mode", Font.PLAIN, 11));
		button_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_4, 4);
			}
		});
		btn[4] = button_4;
		button_4.setIcon(btnicons[4]);
		button_4.setBounds(10, 112, 90, 90);
		OYUN_PNL.add(button_4);
		
		JButton button_5 = new JButton("");
		button_5.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_5, 5);
			}
		});
		btn[5] = button_5;
		button_5.setIcon(btnicons[5]);
		button_5.setBounds(110, 112, 90, 90);
		OYUN_PNL.add(button_5);
		
		JButton button_6 = new JButton("");
		button_6.setFont(new Font("Baskerville Old Face", Font.PLAIN, 11));
		button_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_6, 6);
			}
		});
		btn[6] = button_6;
		button_6.setIcon(btnicons[6]);
		button_6.setBounds(210, 112, 90, 90);
		OYUN_PNL.add(button_6);
		
		JButton button_7 = new JButton("");
		button_7.setFont(new Font("Bauhaus 93", Font.PLAIN, 11));
		button_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_7, 7);
			}
		});
		btn[7] = button_7;
		button_7.setIcon(btnicons[7]);
		button_7.setBounds(310, 112, 90, 90);
		OYUN_PNL.add(button_7);
		
		JButton button_8 = new JButton("");
		button_8.setFont(new Font("Bebas Neue", Font.PLAIN, 11));
		button_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_8, 8);
			}
		});
		btn[8] = button_8;
		button_8.setIcon(btnicons[8]);
		button_8.setBounds(10, 213, 90, 90);
		OYUN_PNL.add(button_8);
		
		JButton button_9 = new JButton("");
		button_9.setFont(new Font("Bell MT", Font.PLAIN, 11));
		button_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_9, 9);
			}
		});
		btn[9] = button_9;
		button_9.setIcon(btnicons[9]);
		button_9.setBounds(110, 213, 90, 90);
		OYUN_PNL.add(button_9);
		
		JButton button_10 = new JButton("");
		button_10.setFont(new Font("Berlin Sans FB", Font.PLAIN, 11));
		button_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_10, 10);
			}
		});
		btn[10] = button_10;
		button_10.setIcon(btnicons[10]);
		button_10.setBounds(210, 213, 90, 90);
		OYUN_PNL.add(button_10);
		
		JButton button_11 = new JButton("");
		button_11.setFont(new Font("Calibri", Font.PLAIN, 11));
		button_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_11, 11);
			}
		});
		btn[11] = button_11;
		button_11.setIcon(btnicons[11]);
		button_11.setBounds(310, 213, 90, 90);
		OYUN_PNL.add(button_11);
		
		JButton button_12 = new JButton("");
		button_12.setFont(new Font("Century", Font.PLAIN, 11));
		button_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_12, 12);
			}
		});
		btn[12] = button_12;
		button_12.setIcon(btnicons[12]);
		button_12.setBounds(10, 314, 90, 90);
		OYUN_PNL.add(button_12);
		
		JButton button_13 = new JButton("");
		button_13.setFont(new Font("Eras Light ITC", Font.PLAIN, 11));
		button_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_13, 13);
			}
		});
		btn[13] = button_13;
		button_13.setIcon(btnicons[13]);
		button_13.setBounds(110, 314, 90, 90);
		OYUN_PNL.add(button_13);
		
		JButton button_14 = new JButton("");
		button_14.setFont(new Font("Forte", Font.PLAIN, 11));
		button_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_14, 14);
			}
		});
		btn[14] = button_14;
		button_14.setIcon(btnicons[14]);
		button_14.setBounds(210, 314, 90, 90);
		OYUN_PNL.add(button_14);
		
		JButton button_15 = new JButton("");
		button_15.setFont(new Font("Garamond", Font.PLAIN, 11));
		button_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				clicked(button_15, 15);
			}
		});
		btn[15] = button_15;
		button_15.setIcon(btnicons[15]);
		button_15.setBounds(310, 314, 90, 90);
		OYUN_PNL.add(button_15);
		
		sure = new JLabel("");
		sure.setFont(new Font("ObelixPro", Font.PLAIN, 15));
		sure.setHorizontalAlignment(SwingConstants.CENTER);
		sure.setBounds(274, 36, 46, 28);
		contentPane.add(sure);
		
		JButton btnNewButton = new JButton("TEKRAR OYNA");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Oyun oy=new Oyun();
				oy.setVisible(true);
				oy.setLocation(getLocation());
				dispose();
			}
		});
		btnNewButton.setVisible(false);
		btnNewButton.setFont(new Font("ObelixPro", Font.PLAIN, 11));
		btnNewButton.setBounds(10, 36, 130, 34);
		btnNewButton.setFocusable(false);
		btnNewButton.setBackground(new Color(65, 224, 168));
		contentPane.add(btnNewButton);
		
		JButton btnBasla = new JButton("BASLA");
		btnBasla.setBackground(new Color(4, 165, 15));
		btnBasla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				btnNewButton.setVisible(true);
				btnBasla.setVisible(false);
				try {
					baslat();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBasla.setFont(new Font("ObelixPro", Font.PLAIN, 11));
		btnBasla.setBounds(150, 36, 90, 28);
		btnBasla.setFocusable(false);
		contentPane.add(btnBasla);
		
		
		
	}
	
	int saniye;
	Timer sayac = new Timer();
	TimerTask task = new TimerTask() {
		public void run() {
				if(saniye==bekle && !basladi) {
					saniye = 0;
					basladi = true;
					kartKapa();
				}
				if(!basladi)	sure.setText(""+(bekle-saniye));
				if(basladi)	sure.setText(""+saniye);
				saniye++;	
		}
	};
	
	
	public void baslat() throws InterruptedException{
		
		btnKolay.setVisible(false);
		btnOrta.setVisible(false);
		btnZor.setVisible(false);
		
		ImageIcon hafiza;
		int rndm;
		for(int i = 0;i<btnicons.length;i++) {     //btnicons array'ýný karýþtýrýyor
			rndm = new Random().nextInt(btnicons.length);
			hafiza = btnicons[rndm];
			btnicons[rndm] = btnicons[i];
			btnicons[i] = hafiza;
		}
		IconKoy();
		saniye = 0;
		
		sayac.scheduleAtFixedRate(task, 0, 1000);
		
		
		
	}
	
	
	public void IconKoy() {
		for(int a=0;a<16;a++) {
			btn[a].setIcon(btnicons[a]);
		}
	}
	public void kartKapa() {
		for(int a=0;a<16;a++) {
			btn[a].setIcon(box);
		}
	}
	
	
	JButton k1,k2;
	Boolean kapa = false;
	int bulunan = 0;
	public void clicked(JButton buton,int ArrayNumarasi) {
		if(basladi) {
			if(kapa == true) {
				k1.setIcon(box);
				k2.setIcon(box);
				kapa = false;
			}
			buton.setIcon(btnicons[ArrayNumarasi]);
			if(AcikKartVar) {
				if(AcikKart.getFont() != buton.getFont()) {
					if(AcikKart.getIcon() == buton.getIcon() ) {
						k1 = null;
						k2 = null;
						AcikKart.setEnabled(false);
						buton.setEnabled(false);
						AcikKartVar = false;
						bulunan++;
						if(bulunan == 8) {
							OYUN_PNL.setVisible(false);
							kazandin.setVisible(true);
							lblSure.setText("SURE:  "+sure.getText()+" saniye");
							sure.setVisible(false);
						}
						
					}else {
						AcikKartVar=false;
						k1 = AcikKart;
						k2 = buton;
						kapa = true;
					
					}
				}
			}else {
				AcikKart = buton;
				AcikKartVar = true;
			}
		}
	}
}
