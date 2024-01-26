package project;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

public class Purchase extends JFrame {
	private JToggleButton[][] lottoNumbers;
//	private List<JLabel> registeredLabels = new ArrayList<>();
	private JButton btnNewButton_1;
	private ImageIcon[][] originalIcons;
	private JPanel pnl;
	protected static JPanel pnlBall1;
	protected static JPanel pnlBall2;
	protected static JPanel pnlBall3;
	protected static JPanel pnlBall4;
	protected static JPanel pnlBall5;
	private JLabel lbl;
	private ImageIcon ballIcon;
	private JButton btnRegistration;
	private JButton btnDel1;
	private JButton btnDel2;
	private JButton btnDel3;
	private JButton btnDel4;
	private JButton btnDel5;
	private List<JLabel> registeredLabels;
	private int rows = 7; // 행
	private int cols = 7; // 열
	private int showBallselectedCount = 0;
	private JLabel lblAmount;
	private int amount = 0;
	public static List<Set<Integer>> intSetList;
	private Set<Integer> intSet;
	protected static Map<Integer, List<Set<Integer>>> purchaseNumList = new HashMap<>();

	public Purchase() {
		setBackground(Color.WHITE);
		setTitle("구매 화면");
		getContentPane().setBackground(Color.WHITE);
		intSetList = new ArrayList<>();
		intSet = new TreeSet<>();
		pnl = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				BufferedImage image = null;
				Image scaledImage = null;
				try {
					image = ImageIO.read(new File("구매창배경.png"));
					scaledImage = image.getScaledInstance(970, 550, Image.SCALE_DEFAULT);
				} catch (IOException e) {
					e.printStackTrace();
				}

				g.drawImage(scaledImage, 0, 0, null);

				super.paintComponents(g);

				g.dispose();
			}
		};
		pnl.setBackground(Color.WHITE);
		getContentPane().add(pnl);
//		setLocationRelativeTo(null);
		setResizable(false);
		SpringLayout springLayout = new SpringLayout();
		pnl.setLayout(springLayout);

//		String gifFilePath = "구매창.png";
//        ImageIcon imageIcon = new ImageIcon(gifFilePath);
//        Image image = imageIcon.getImage().getScaledInstance(970, 550, Image.SCALE_DEFAULT);
//        setComponentZOrder(pnl, 0);
//		
//        JLabel gifLabel = new JLabel(new ImageIcon(image));
//        gifLabel.setBackground(Color.WHITE);
//        pnl.add(gifLabel);

		int checkboxMargin = 1; // 버튼 간격

		originalIcons = new ImageIcon[rows][cols]; // 버튼 누르고 다시 눌럿을때 복구 사진 저장
		lottoNumbers = new JToggleButton[rows][cols];
//		
//		String gifFilePath = "구매창배경.png";
//		ImageIcon imageIcon = new ImageIcon(gifFilePath);
//		Image image = imageIcon.getImage().getScaledInstance(970, 550, Image.SCALE_DEFAULT);
//		JLabel gifLabel = new JLabel(new ImageIcon(image));
//		gifLabel.setLayout(springLayout);
//		JLayeredPane layeredPane = new JLayeredPane();
//		layeredPane.setPreferredSize(new Dimension(970, 550));
//		layeredPane.add(gifLabel, 0);

//		lbl = new JLabel(new ImageIcon("회색공.png"));

		for (int i = 0; i <= 45; i++) { // 7x7 45 버튼으로 표현
			int row = i / cols;
			int col = i % cols;

			ImageIcon toggleIcon = new ImageIcon("num" + (i + 1) + ".png");

			lottoNumbers[row][col] = new JToggleButton();
			lottoNumbers[row][col].setIcon(toggleIcon);
			lottoNumbers[row][col].setActionCommand(Integer.toString(i + 1));// 버튼 이미지 크기 텍스트 때문에 안맞아서 커맨드로 바꿈
			lottoNumbers[row][col].setBorderPainted(false);
			lottoNumbers[row][col].setFocusPainted(false);
			lottoNumbers[row][col].setContentAreaFilled(false);

//			lottoNumbers[row][col].setText(Integer.toString(i + 1));
//			lottoNumbers[row][col].setHideActionText(true);
			lottoNumbers[row][col].setPreferredSize(new Dimension(28, 28)); // 버튼 사이즈

//			layeredPane.add(lottoNumbers[row][col], 0);
//			gifLabel.setBackground(Color.WHITE);
//			pnl.add(gifLabel);
			pnl.add(lottoNumbers[row][col]);

			// 첫 번째 열은 왼쪽에 고정
			if (col == 0) {
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], 224, SpringLayout.WEST, pnl);
			} else {
				pnl.add(lottoNumbers[row][col]);
				// 나머지 열은 이전 체크박스를 기준으로 위치 조정 (가로로 배치)
				springLayout.putConstraint(SpringLayout.WEST, lottoNumbers[row][col], checkboxMargin, SpringLayout.EAST,
						lottoNumbers[row][col - 1]);
			}

			// 첫 번째 행은 상단에 고정
			if (row == 0) {
				springLayout.putConstraint(SpringLayout.NORTH, lottoNumbers[row][col], 150, SpringLayout.NORTH, pnl);
			} else {
				// 나머지 행은 이전 행의 첫 번째 열을 기준으로 위치 조정 (세로로 배치)
				springLayout.putConstraint(SpringLayout.NORTH, lottoNumbers[row][col], checkboxMargin,
						SpringLayout.SOUTH, lottoNumbers[row - 1][0]);
			}

			lottoNumbers[row][col].addItemListener(new ItemListener() {

				@Override
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {
						ImageIcon clickIcon = new ImageIcon("clicknum.png");
						lottoNumbers[row][col].setIcon(clickIcon);
					} else if (e.getStateChange() == ItemEvent.DESELECTED) {
						ImageIcon toggleIcon = new ImageIcon("num" + (row * cols + col + 1) + ".png");
						lottoNumbers[row][col].setIcon(toggleIcon);
					}

				}
			});
		}

		JButton btnNewButton = new JButton("자동 선택");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));

		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				ranSelect();

			}

			public void ranSelect() {
				List<JToggleButton> allButton = new ArrayList<>();
				for (int i = 0; i < 45; i++) {
					int row = i / cols;
					int col = i % cols;
					allButton.add(lottoNumbers[row][col]);

					ImageIcon toggleIcon = new ImageIcon("num" + (i + 1) + ".png");
					originalIcons[row][col] = toggleIcon;
				}

				Collections.shuffle(allButton);
				int count = 0;
				for (JToggleButton button : allButton) {
					if (count < 6) {
						ImageIcon clickIcon = new ImageIcon("clicknum.png");
						button.setIcon(clickIcon);
						button.setSelected(true);
						count++;
					} else if (count >= 6) {
						if (button.isSelected()) {
							int row = (count - 6) / cols;
							int col = (count - 6) % cols;
							button.setIcon(originalIcons[row][col]);
							button.setSelected(false);
						}
					} else {
						break;
					}
				}
			}
		});

		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 200, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 80, SpringLayout.WEST, pnl);
		pnl.add(btnNewButton);

		btnNewButton_1 = new JButton("반 자동");
		btnNewButton_1.setBackground(UIManager.getColor("Button.disabledForeground"));
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_1, 38, SpringLayout.SOUTH, btnNewButton);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, btnNewButton);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_1, 0, SpringLayout.EAST, btnNewButton);
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				halfRandom();
				int count = 0;
				for (int i = 0; i < 45; i++) {
					int row = i / cols;
					int col = i % cols;
					if (lottoNumbers[row][col].isSelected()) {
						count++;
					}
				}
				if (count <= 0 || count > 6) {
					PurchaseDialog3 dialog = new PurchaseDialog3(Purchase.this);
					dialog.setVisible(true);
				}
			}

			public void halfRandom() {
				List<JToggleButton> allButton = new ArrayList<>();
				int selectedCount = 0;

				// 모든 버튼을 리스트에 추가
				for (int i = 0; i < 45; i++) {
					int row = i / cols;
					int col = i % cols;
					allButton.add(lottoNumbers[row][col]);

					// 수동으로 선택한 버튼의 개수를 카운트
					if (lottoNumbers[row][col].isSelected()) {
						selectedCount++;
					}
				}

				Collections.shuffle(allButton);
				for (JToggleButton button : allButton) {
					if (selectedCount == 1) {
						if (!button.isSelected()) {
							button.setSelected(true);
							selectedCount++;
						}
					} else if (selectedCount >= 2 && selectedCount <= 5) {
						if (!button.isSelected()) {
							button.setSelected(true);
							selectedCount++;
						}

						if (selectedCount >= 6) {
							break;
						}
					}
				}
			}
		});
		pnl.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setIcon(new ImageIcon("구매하기.png"));
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if (pnlBall1.getComponentCount() == 0 && pnlBall2.getComponentCount() == 0
						&& pnlBall3.getComponentCount() == 0 && pnlBall4.getComponentCount() == 0
						&& pnlBall5.getComponentCount() == 0) {
					PurchaseDialog2 dialog = new PurchaseDialog2(Purchase.this);
					dialog.setVisible(true);
				} else {
					PurchaseDialog dialog = new PurchaseDialog(Purchase.this);
					dialog.setVisible(true);
					PurchaseHistory.purchaseAdd();
					PurchaseHistory.pnlpurchaseNumber.put(PurchaseHistory.numberOfPurchases,
							new ArrayList<>(PurchaseHistory.pnlwinningNumber));
					PurchaseHistory.numberOfPurchases++;
					amount = 0;
					lblAmount.setText(Integer.toString(amount) + "원");
					intSetList.clear();

				}

				PurchaseHistory.pnlwinningNumber.clear();
				removeComponentFromPanel(pnlBall1);
				pnlBall1.revalidate();
				pnlBall1.repaint();
				removeComponentFromPanel(pnlBall2);
				pnlBall2.revalidate();
				pnlBall2.repaint();
				removeComponentFromPanel(pnlBall3);
				pnlBall3.revalidate();
				pnlBall3.repaint();
				removeComponentFromPanel(pnlBall4);
				pnlBall4.revalidate();
				pnlBall4.repaint();
				removeComponentFromPanel(pnlBall5);
				pnlBall5.revalidate();
				pnlBall5.repaint();
			}
		});
		pnl.add(btnNewButton_2);

		JButton btnGoBack = new JButton("뒤로가기");
		btnGoBack.setBackground(UIManager.getColor("Button.disabledForeground"));
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -82, SpringLayout.NORTH, btnGoBack);
		springLayout.putConstraint(SpringLayout.SOUTH, btnGoBack, -22, SpringLayout.SOUTH, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnGoBack, -34, SpringLayout.EAST, pnl);
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMain guimain = new GUIMain();
				guimain.setVisible(true);
				setVisible(false);
			}
		});
		pnl.add(btnGoBack);

		btnRegistration = new JButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnRegistration, 367, SpringLayout.WEST, pnl);
		btnRegistration.setIcon(new ImageIcon("확인 버튼.png"));
		btnRegistration.setBorderPainted(false);
		btnRegistration.setFocusPainted(false);
		btnRegistration.setContentAreaFilled(false);
		springLayout.putConstraint(SpringLayout.SOUTH, btnRegistration, -126, SpringLayout.SOUTH, pnl);
		btnRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showBall();

				if (showBallselectedCount < 6 || showBallselectedCount > 6) {
					InputDialog dialog = new InputDialog(Purchase.this);
					dialog.setVisible(true);
				}
			}
		});
		pnl.add(btnRegistration);

		JButton btnNewButton_3 = new JButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_3, 349, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_3, -598, SpringLayout.EAST, pnl);
		btnNewButton_3.setIcon(new ImageIcon("초기화.png"));
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setContentAreaFilled(false);
		springLayout.putConstraint(SpringLayout.NORTH, btnRegistration, 36, SpringLayout.SOUTH, btnNewButton_3);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_3, 353, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -185, SpringLayout.SOUTH, pnl);
//			btnNewButton_3.setBorderPainted(false); // 나중에
//			btnNewButton_3.setFocusPainted(false);
//			btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		pnl.add(btnNewButton_3);

		btnDel1 = new JButton("");
		springLayout.putConstraint(SpringLayout.WEST, btnDel1, 838, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnDel1, -123, SpringLayout.EAST, pnl);
		btnDel1.setIcon(new ImageIcon("삭제.png"));
		btnDel1.setBorderPainted(false);
		btnDel1.setFocusPainted(false);
		btnDel1.setContentAreaFilled(false);
		btnDel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//					pnlBall1.removeAll();
				removeComponentFromPanel(pnlBall1);
				pnlBall1.revalidate();
				pnlBall1.repaint();
				if (amount >= 1000) {
					amount -= 1000;
				} else {
					amount = 0;
				}
				lblAmount.setText(Integer.toString(amount) + "원");
				btnRegistration.setEnabled(true);
				btnDel1.setEnabled(false);
			}
		});
		pnl.add(btnDel1);

		btnDel2 = new JButton("");
		springLayout.putConstraint(SpringLayout.EAST, btnDel2, -123, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDel1, -14, SpringLayout.NORTH, btnDel2);
		springLayout.putConstraint(SpringLayout.NORTH, btnDel2, 191, SpringLayout.NORTH, pnl);
		btnDel2.setIcon(new ImageIcon("삭제.png"));
		btnDel2.setBorderPainted(false);
		btnDel2.setFocusPainted(false);
		btnDel2.setContentAreaFilled(false);
		btnDel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					pnlBall2.removeAll();
				removeComponentFromPanel(pnlBall2);
				pnlBall2.revalidate();
				pnlBall2.repaint();
				if (amount >= 1000) {
					amount -= 1000;
				} else {
					amount = 0;
				}
				lblAmount.setText(Integer.toString(amount) + "원");
				btnRegistration.setEnabled(true);
				btnDel2.setEnabled(false);
			}
		});
		pnl.add(btnDel2);

		btnDel3 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnDel3, 238, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnDel3, -123, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDel2, -15, SpringLayout.NORTH, btnDel3);
		btnDel3.setIcon(new ImageIcon("삭제.png"));
		btnDel3.setBorderPainted(false);
		btnDel3.setFocusPainted(false);
		btnDel3.setContentAreaFilled(false);
		btnDel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					pnlBall3.removeAll();
				removeComponentFromPanel(pnlBall3);
				pnlBall3.revalidate();
				pnlBall3.repaint();
				if (amount >= 1000) {
					amount -= 1000;
				} else {
					amount = 0;
				}
				lblAmount.setText(Integer.toString(amount) + "원");
				btnRegistration.setEnabled(true);
				btnDel3.setEnabled(false);
			}
		});
		pnl.add(btnDel3);

		btnDel4 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnDel4, 277, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDel4, -262, SpringLayout.SOUTH, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnDel4, -123, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, btnDel3, -6, SpringLayout.NORTH, btnDel4);
		btnDel4.setIcon(new ImageIcon("삭제.png"));
		btnDel4.setBorderPainted(false);
		btnDel4.setFocusPainted(false);
		btnDel4.setContentAreaFilled(false);
		btnDel4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//					pnlBall4.removeAll();
				removeComponentFromPanel(pnlBall4);
				pnlBall4.revalidate();
				pnlBall4.repaint();
				if (amount >= 1000) {
					amount -= 1000;
				} else {
					amount = 0;
				}
				lblAmount.setText(Integer.toString(amount) + "원");
				btnRegistration.setEnabled(true);
				btnDel4.setEnabled(false);
			}
		});
		pnl.add(btnDel4);

		btnDel5 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_2, 44, SpringLayout.SOUTH, btnDel5);
		springLayout.putConstraint(SpringLayout.NORTH, btnDel5, 6, SpringLayout.SOUTH, btnDel4);
		springLayout.putConstraint(SpringLayout.WEST, btnDel5, 0, SpringLayout.WEST, btnDel1);
		springLayout.putConstraint(SpringLayout.EAST, btnDel5, -123, SpringLayout.EAST, pnl);
		btnDel5.setIcon(new ImageIcon("삭제.png"));
		btnDel5.setBorderPainted(false);
		btnDel5.setFocusPainted(false);
		btnDel5.setContentAreaFilled(false);
		btnDel5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeComponentFromPanel(pnlBall5);
				pnlBall5.revalidate();
				pnlBall5.repaint();
				if (amount >= 1000) {
					amount -= 1000;
				} else {
					amount = 0;
				}
				lblAmount.setText(Integer.toString(amount) + "원");
				btnRegistration.setEnabled(true);
				btnDel5.setEnabled(false);
			}
		});
		pnl.add(btnDel5);

		pnlBall1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, pnlBall1, 135, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, pnlBall1, 0, SpringLayout.SOUTH, btnDel1);
		springLayout.putConstraint(SpringLayout.EAST, pnlBall1, -205, SpringLayout.EAST, pnl);
		pnlBall1.setBackground(Color.WHITE);
		pnl.add(pnlBall1);
		SpringLayout sl_pnlBall1 = new SpringLayout();
		pnlBall1.setLayout(sl_pnlBall1);

		pnlBall2 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, pnlBall1, 0, SpringLayout.WEST, pnlBall2);
		springLayout.putConstraint(SpringLayout.WEST, btnDel2, 49, SpringLayout.EAST, pnlBall2);
		springLayout.putConstraint(SpringLayout.EAST, pnlBall2, -205, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.WEST, pnlBall2, 374, SpringLayout.EAST, btnNewButton);
		springLayout.putConstraint(SpringLayout.NORTH, pnlBall2, 177, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.SOUTH, pnlBall2, -352, SpringLayout.SOUTH, pnl);
		pnlBall2.setBackground(Color.WHITE);
		pnl.add(pnlBall2);
		pnlBall2.setLayout(new SpringLayout());

		pnlBall3 = new JPanel();
		springLayout.putConstraint(SpringLayout.WEST, btnDel3, 49, SpringLayout.EAST, pnlBall3);
		springLayout.putConstraint(SpringLayout.NORTH, pnlBall3, 0, SpringLayout.SOUTH, pnlBall2);
		springLayout.putConstraint(SpringLayout.EAST, pnlBall3, -205, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.WEST, pnlBall3, 374, SpringLayout.EAST, btnNewButton);
		pnlBall3.setBackground(Color.WHITE);
		pnl.add(pnlBall3);
		pnlBall3.setLayout(new SpringLayout());

		pnlBall4 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, pnlBall3, 0, SpringLayout.NORTH, pnlBall4);
		springLayout.putConstraint(SpringLayout.WEST, btnDel4, 49, SpringLayout.EAST, pnlBall4);
		springLayout.putConstraint(SpringLayout.EAST, pnlBall4, -205, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.WEST, pnlBall4, 374, SpringLayout.EAST, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.NORTH, pnlBall4, 0, SpringLayout.NORTH, btnNewButton_1);
		springLayout.putConstraint(SpringLayout.SOUTH, pnlBall4, -50, SpringLayout.NORTH, btnNewButton_3);
		pnlBall4.setBackground(Color.WHITE);
		pnl.add(pnlBall4);
		pnlBall4.setLayout(new SpringLayout());

		pnlBall5 = new JPanel();
		springLayout.putConstraint(SpringLayout.SOUTH, btnDel5, 0, SpringLayout.SOUTH, pnlBall5);
		springLayout.putConstraint(SpringLayout.NORTH, pnlBall5, 1, SpringLayout.SOUTH, pnlBall4);
		springLayout.putConstraint(SpringLayout.WEST, pnlBall5, 0, SpringLayout.WEST, pnlBall1);
		springLayout.putConstraint(SpringLayout.EAST, pnlBall5, -8, SpringLayout.WEST, btnNewButton_2);

		JLabel lblNewLabel = new JLabel();
		sl_pnlBall1.putConstraint(SpringLayout.NORTH, lblNewLabel, 26, SpringLayout.NORTH, pnlBall1);
		sl_pnlBall1.putConstraint(SpringLayout.WEST, lblNewLabel, 140, SpringLayout.WEST, pnlBall1);
		pnlBall5.setBackground(Color.WHITE);
		pnl.add(pnlBall5);
		pnlBall5.setLayout(new SpringLayout());

		JButton btnNewButton_4 = new JButton("");
		springLayout.putConstraint(SpringLayout.NORTH, btnDel1, 33, SpringLayout.SOUTH, btnNewButton_4);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_2, 12, SpringLayout.EAST, btnNewButton_4);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNewButton_4, -459, SpringLayout.SOUTH, pnl);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton_4, 80, SpringLayout.NORTH, pnl);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_4, 833, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton_4, -75, SpringLayout.EAST, pnl);
		btnNewButton_4.setIcon(new ImageIcon("초기화2.png"));
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setFocusPainted(false);
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeComponentFromPanel(pnlBall1);
				pnlBall1.revalidate();
				pnlBall1.repaint();
				removeComponentFromPanel(pnlBall2);
				pnlBall2.revalidate();
				pnlBall2.repaint();
				removeComponentFromPanel(pnlBall3);
				pnlBall3.revalidate();
				pnlBall3.repaint();
				removeComponentFromPanel(pnlBall4);
				pnlBall4.revalidate();
				pnlBall4.repaint();
				removeComponentFromPanel(pnlBall5);
				pnlBall5.revalidate();
				pnlBall5.repaint();
				amount = 0;
				lblAmount.setText(Integer.toString(amount) + "원");
				btnRegistration.setEnabled(true);

			}
		});
		pnl.add(btnNewButton_4);

		lblAmount = new JLabel("0 원");
		springLayout.putConstraint(SpringLayout.SOUTH, pnlBall5, -74, SpringLayout.NORTH, lblAmount);
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton_2, 18, SpringLayout.EAST, lblAmount);
		springLayout.putConstraint(SpringLayout.EAST, btnRegistration, -267, SpringLayout.WEST, lblAmount);
		springLayout.putConstraint(SpringLayout.WEST, lblAmount, 716, SpringLayout.WEST, pnl);
		springLayout.putConstraint(SpringLayout.EAST, lblAmount, -215, SpringLayout.EAST, pnl);
		springLayout.putConstraint(SpringLayout.NORTH, lblAmount, 0, SpringLayout.NORTH, btnRegistration);
		pnl.add(lblAmount);

		showGUI();

//		getContentPane().add(layeredPane);
	}

	private void reset() {
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (lottoNumbers[i][j] != null) {
					lottoNumbers[i][j].setSelected(false);
				} else {
					lottoNumbers[i][j] = new JToggleButton();
				}
			}
		}
	}

	private void showBall() {
		lblAmount.setText("");
		FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
		registeredLabels = new ArrayList<>();
		pnlBall1.setLayout(flowLayout);
		pnlBall2.setLayout(flowLayout);
		pnlBall3.setLayout(flowLayout);
		pnlBall4.setLayout(flowLayout);
		pnlBall5.setLayout(flowLayout);

		showBallselectedCount = 0;
		int count = 0;
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				int number = 0;
				if (lottoNumbers[i][j] != null && lottoNumbers[i][j].isSelected()) {
					number = Integer.parseInt(lottoNumbers[i][j].getActionCommand());
//					number = Integer.parseInt(lottoNumbers[i][j].getText()); // 버튼 이미지 크기 텍스트 때문에 안맞아서 커맨드로 바꿈
//					if (intSet.size() < 6) { // 변경: 더 이상 숫자를 추가하지 않도록 수정
//						intSet.add(number);
//					} if (intSet.size() == 5) {
//						intSetList.add(new TreeSet<>(intSet));
//						intSet.clear();
//					}
					String file = "ball_" + number + ".png";
					ballIcon = new ImageIcon(file);

					// 이미지 크기 조절
					Image originalImage = ballIcon.getImage();
					Image resizedImage = originalImage.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
					ballIcon = new ImageIcon(resizedImage);

					lbl = new JLabel(ballIcon);
					registeredLabels.add(lbl);
					PurchaseHistory.pnlwinningNumber.add(lbl);
					showBallselectedCount++;
				}
				if (number != 0) {
					intSet.add(number);
					count++;
				}
				if (count == 6) {
					Set<Integer> tempSet = new TreeSet<>();
					for (Integer k : intSet) {
						tempSet.add(k);
					}
					intSetList.add(tempSet);
					purchaseNumList.put(PurchaseHistory.numberOfPurchases, new ArrayList<Set<Integer>>(intSetList));
					intSet.clear();
					count = 0;
				}
			}
		}
		
		

		// 각 패널에 이미지 추가
		if (showBallselectedCount == 6) {
			for (JLabel registeredLabel : registeredLabels) {
				if (pnlBall1.getComponentCount() <= 5) {
					pnlBall1.add(registeredLabel);
					if (pnlBall1.getComponentCount() == 6) {
						amount += 1000;
						btnDel1.setEnabled(true);
					}
					lblAmount.setText(Integer.toString(amount) + "원");
				} else if (pnlBall2.getComponentCount() <= 5) {
					pnlBall2.add(registeredLabel);
					if (pnlBall2.getComponentCount() == 6) {
						amount += 1000;
						btnDel2.setEnabled(true);
					}
					lblAmount.setText(Integer.toString(amount) + "원");
				} else if (pnlBall3.getComponentCount() <= 5) {
					pnlBall3.add(registeredLabel);
					if (pnlBall3.getComponentCount() == 6) {
						amount += 1000;
						btnDel3.setEnabled(true);
					}
					lblAmount.setText(Integer.toString(amount) + "원");
				} else if (pnlBall4.getComponentCount() <= 5) {
					pnlBall4.add(registeredLabel);
					if (pnlBall4.getComponentCount() == 6) {
						amount += 1000;
						btnDel4.setEnabled(true);
					}
					lblAmount.setText(Integer.toString(amount) + "원");
				} else if (pnlBall5.getComponentCount() <= 5) {
					pnlBall5.add(registeredLabel);
					if (pnlBall5.getComponentCount() == 6) {
						amount += 1000;
						btnDel5.setEnabled(true);
					}
					lblAmount.setText(Integer.toString(amount) + "원");
				}
				if (pnlBall1.getComponentCount() == 6 && pnlBall2.getComponentCount() == 6
						&& pnlBall3.getComponentCount() == 6 && pnlBall4.getComponentCount() == 6
						&& pnlBall5.getComponentCount() == 6) {
					btnRegistration.setEnabled(false);
				}
			}
		}
		pnlBall1.revalidate();
		pnlBall1.repaint();
		pnlBall2.revalidate();
		pnlBall2.repaint();
		pnlBall3.revalidate();
		pnlBall3.repaint();
		pnlBall4.revalidate();
		pnlBall4.repaint();
		pnlBall5.revalidate();
		pnlBall5.repaint();

	}
//	

	private void showGUI() {
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	class InputDialog extends JDialog {
		public InputDialog(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("6개의 번호를 등록해주세요.");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);

				}
			});
		}
	}

	class PurchaseDialog extends JDialog {
		public PurchaseDialog(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("구매완료");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);
					btnRegistration.setEnabled(true);

				}
			});
		}
	}

	class PurchaseDialog2 extends JDialog {
		public PurchaseDialog2(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("등록된 번호가 없습니다.");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);

				}
			});
		}
	}

	class PurchaseDialog3 extends JDialog {
		public PurchaseDialog3(Purchase main) {
			super(main);

			setModal(true);

			JPanel pnl = new JPanel();
			JLabel lbl = new JLabel("1~5개 숫자 눌러주셈.");
			JButton btn = new JButton("뒤로가기");

			pnl.add(lbl);
			pnl.add(btn);

			setSize(200, 100);
			setLocationRelativeTo(main);

			add(pnl);

			addWindowListener(new WindowAdapter() {

				@Override
				public void windowClosing(WindowEvent e) {
					btnNewButton_1.setEnabled(true);
				}

			});

			btn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
					btnNewButton_1.setEnabled(true);

				}
			});
		}
	}

	private void removeComponentFromPanel(JPanel panel) {
		Component[] components = panel.getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components.length > 0) {
				panel.remove(components[i]); // 패널의 첫 번째 컴포넌트를 제거합니다.
				PurchaseHistory.pnlwinningNumber.remove(components[i]); // 리스트에서도 제거합니다.
			}
		}
	}

	public static void main(String[] args) {
		new Purchase();
	}
}