package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class Result extends JFrame {

	private LineBorder RB = new LineBorder(new Color(213, 47, 117), 2, true);
	private LineBorder BB = new LineBorder(new Color(63, 108, 198), 2, true);
	private LineBorder BlackB = new LineBorder(Color.LIGHT_GRAY, 1, true);
	private LineBorder WB = new LineBorder(Color.WHITE, 1, true);
	protected static final String panel_3 = null;
	protected static final Object List = null;
	protected static final Object String = null;
	protected static Vector<Integer> purchase = new Vector<>();
	protected static int purchaseindex = 1;
	protected static int numberOfPurchases = 1; // 구매장수
	private JTextField textField;
	protected ArrayList<Integer> keysList;
	protected JLabel[] imageLabels;
	protected TreeMap<Integer, String> imageMap;
	protected int icon;
	private String imageList;
	protected static JLabel lblNewLabel_9;
	static JPanel panel_2;
	static JLabel lblNewLabel_10;
	private JToggleButton[][] lottoNumbers;
	private ImageIcon ballIcon;
	private JLabel lbl;
	private AbstractButton model;
	private FlowLayout flowLayout;
	protected static List<JLabel> purchaseNumber1 = new ArrayList<>();
	protected static List<JLabel> purchaseNumber2 = new ArrayList<>();
	protected static List<JLabel> purchaseNumber3 = new ArrayList<>();
	protected static Map<String, List<JLabel>> pnlpurchaseString = new HashMap<>();
	protected static Map<String, List<JLabel>> purchaseNumList = new HashMap<>();
	private int showBallselectedCount;
	protected static String numberOfOne = "첫번째 장";
	protected static String numberOfTwo = "두번째 장";
	protected static String numberOfThree = "세번째 장";
	protected Component lbl2;
	protected int index;
	protected Component lbl1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private Object pnlwinningNumber;
	private Object selectedNumber;
	private Set<Integer> selectedNumber2 = new LinkedHashSet<>();
	private int Vector;
	private AbstractButton btnNewButton;
	private List<Set<Integer>> intSetList;
	private int tfIndex;
	private JComboBox<Integer> comboBox;
	private List<JTextField> tfList;
	private JPanel panel_4;
	private JPanel panel_4_1;
	private JPanel panel_4_1_1;
	private JPanel panel_4_1_1_1;
	private JPanel panel_4_1_1_1_1;
	private int amount;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_4;

	public Result() {
		getContentPane().setBackground(SystemColor.window);
//		selectedNumber2 = new ArrayList<>();

		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);

		JButton btnBack = new JButton("\uB4A4\uB85C\uAC00\uAE30");
		btnBack.setBackground(UIManager.getColor("Button.disabledForeground"));
		springLayout.putConstraint(SpringLayout.SOUTH, btnBack, -10, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnBack, -10, SpringLayout.EAST, getContentPane());
		getContentPane().add(btnBack);

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIMain guimain = new GUIMain();
				guimain.setVisible(true);
				setVisible(false);
			}
		});

		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.EAST, panel, -518, SpringLayout.EAST, getContentPane());
		panel.setBorder(RB);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -89, SpringLayout.SOUTH, getContentPane());
		panel.setBackground(SystemColor.textHighlightText);
		getContentPane().add(panel);

		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 69, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 30, SpringLayout.EAST, panel);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -56, SpringLayout.NORTH, btnBack);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, -27, SpringLayout.EAST, getContentPane());
		panel_1.setBorder(BB);
		panel_1.setBackground(SystemColor.textHighlightText);

		String[] menus = new String[] { "차수를 선택하세요", "-----", "1회차", "2회차", "3회차" };
		JComboBox<String> combo = new JComboBox<>();
		combo.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		combo.setModel(new DefaultComboBoxModel<>(menus));

		combo.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					int index = combo.getSelectedIndex();

					if (index == 0 || index == 1) {
						textField.setText("");
						lblNewLabel_9.setText("");
						panel_2.removeAll();
						panel_2.revalidate();
						panel_2.repaint();

					} else if (index == 2) {
						lblNewLabel_4.setText("250.000.000 원");
						lblNewLabel_9.setText("");
						textField.setText("2023.08.16");
						TreeMap<Integer, String> imageMap3 = new TreeMap<>();
						imageMap3.put(4, "ball_4.png");
						imageMap3.put(5, "ball_5.png");
						imageMap3.put(10, "ball_10.png");
						imageMap3.put(12, "ball_12.png");
						imageMap3.put(22, "ball_22.png");
						imageMap3.put(34, "ball_34.png");
						imageMap3.put(41, "ball_41.png");
						List<Integer> keysList = new ArrayList<>(imageMap3.keySet());
						for (int j = 0; j < 8; j++) {
							if (j == 6) {
//								imageLabels[j].setText("+");
							} else if (j <= 5) {
								imageList = imageMap3.get(keysList.get(j));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							} else {
								imageList = imageMap3.get(keysList.get(6));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							}
							panel_2.add(imageLabels[j]);
						}
						panel_2.revalidate();
						panel_2.repaint();
					} else if (index == 3) {
						lblNewLabel_4.setText("150.000.000 원");

						lblNewLabel_9.setText("");
						textField.setText("2024.01.11");

						TreeMap<Integer, String> imageMap2 = new TreeMap<>();
						imageMap2.put(2, "ball_2.png");
						imageMap2.put(11, "ball_11.png");
						imageMap2.put(12, "ball_12.png");
						imageMap2.put(19, "ball_19.png");
						imageMap2.put(21, "ball_21.png");
						imageMap2.put(33, "ball_33.png");
						imageMap2.put(36, "ball_36.png");
						List<Integer> keysList = new ArrayList<>(imageMap2.keySet());
						for (int j = 0; j < 8; j++) {
							if (j == 6) {
//								imageLabels[j].setText("+");
							} else if (j <= 5) {
								imageList = imageMap2.get(keysList.get(j));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							} else {
								imageList = imageMap2.get(keysList.get(6));
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[j].setIcon(icon);
							}
							panel_2.add(imageLabels[j]);
						}
						panel_2.revalidate();
						panel_2.repaint();

					} else if (index == 4) {
						lblNewLabel_4.setText("450.000.000 원");

						lblNewLabel_9.setText("");
						textField.setText("2024.01.25");

						TreeMap<Integer, String> shuffledTreeMap = new TreeMap<>();
						for (Integer key : keysList) {
							shuffledTreeMap.put(key, imageMap.get(key));
						}

						// List<JLabel> imageLabelsList = new ArrayList<>();

						Random random = new Random();

						// 6개의 무작위 숫자 뽑기
						while (selectedNumber2.size() < 6) {
							int randomIndex = random.nextInt(keysList.size());
							selectedNumber2.add(keysList.get(randomIndex));
						}

						// 중복되지 않는 추가적인 숫자 뽑기
						int additionalNumber;
						do {
							additionalNumber = random.nextInt(45) + 1;
						} while (selectedNumber2.contains(additionalNumber));

						// 선택된 숫자 정렬
						List<Integer> sortedNumbers = new ArrayList<>(selectedNumber2);
						Collections.sort(sortedNumbers);

						// 정렬된 숫자 출력
						int i = 0;

						for (Integer currentNumber : sortedNumbers) {
							if (i == 6) {
//								imageLabels[i].setText("+");
							} else {
								String imageList = shuffledTreeMap.get(currentNumber);
								ImageIcon icon = new ImageIcon(imageList);
								imageLabels[i].setIcon(icon);
							}
							panel_2.add(imageLabels[i]);
							i++;
						}

						// 추가적인 숫자 출력
						String additionalImageList = shuffledTreeMap.get(additionalNumber);
						ImageIcon additionalIcon = new ImageIcon(additionalImageList);
						imageLabels[7].setIcon(additionalIcon);
						panel_2.add(imageLabels[7]);
						panel_2.revalidate();
						panel_2.repaint();
					}
				}
			}
		});

		SpringLayout sl_panel = new SpringLayout();
		sl_panel.putConstraint(SpringLayout.NORTH, combo, 5, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, combo, 96, SpringLayout.WEST, panel);
		panel.setLayout(sl_panel);

		panel.add(combo);
		JLabel lblNewLabel = new JLabel("\uD68C \uB2F9\uCCA8\uACB0\uACFC");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel, 3, SpringLayout.NORTH, combo);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel, 6, SpringLayout.EAST, combo);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBackground(Color.WHITE);
		textField.setBorder(BlackB);
		sl_panel.putConstraint(SpringLayout.NORTH, textField, 6, SpringLayout.SOUTH, combo);
		sl_panel.putConstraint(SpringLayout.EAST, textField, -5, SpringLayout.EAST, combo);
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("당첨번호 공개 날짜");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 15, SpringLayout.SOUTH, lblNewLabel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 10, SpringLayout.EAST, textField);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_7 = new JLabel("총 당첨금액");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_7, 88, SpringLayout.WEST, panel);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("내가 받을 금액");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 311, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_7, -30, SpringLayout.NORTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_7);
		panel.add(lblNewLabel_8);
		getContentPane().add(panel_1);
		SpringLayout sl_panel_1 = new SpringLayout();
		panel_1.setLayout(sl_panel_1);

		JLabel lblNewLabel_3 = new JLabel("나의 번호");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 178, SpringLayout.WEST, panel_1);
		panel_1.add(lblNewLabel_3);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(BlackB);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4, 58, SpringLayout.WEST, panel_1);
		panel_1.add(panel_4);

		panel_4_1 = new JPanel();
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBorder(BlackB);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, panel_4_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_4_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1, 115, SpringLayout.NORTH, panel_1);
		panel_1.add(panel_4_1);

		panel_4_1_1 = new JPanel();
		panel_4_1_1.setBackground(Color.WHITE);
		panel_4_1_1.setBorder(BlackB);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1_1, 186, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1, -6, SpringLayout.NORTH, panel_4_1_1);
		panel_1.add(panel_4_1_1);

		panel_4_1_1_1 = new JPanel();
		panel_4_1_1_1.setBackground(Color.WHITE);
		panel_4_1_1_1.setBorder(BlackB);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1_1_1, 257, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1_1_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1_1_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1_1, -6, SpringLayout.NORTH, panel_4_1_1_1);
		panel_1.add(panel_4_1_1_1);

		panel_4_1_1_1_1 = new JPanel();
		panel_4_1_1_1_1.setBackground(Color.WHITE);
		panel_4_1_1_1_1.setBorder(BlackB);
		sl_panel_1.putConstraint(SpringLayout.WEST, panel_4_1_1_1_1, 58, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, panel_4_1_1_1_1, -10, SpringLayout.EAST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1_1_1, -6, SpringLayout.NORTH, panel_4_1_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4_1_1_1_1, 328, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, panel_4_1_1_1_1, -10, SpringLayout.SOUTH, panel_1);
		panel_1.add(panel_4_1_1_1_1);

		comboBox = new JComboBox<>(PurchaseHistory.purchase);
		comboBox.setBackground(UIManager.getColor("ComboBox.disabledForeground"));
		sl_panel_1.putConstraint(SpringLayout.NORTH, comboBox, 7, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.NORTH, panel_4, 9, SpringLayout.SOUTH, comboBox);
		sl_panel_1.putConstraint(SpringLayout.WEST, comboBox, 100, SpringLayout.EAST, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.EAST, comboBox, -43, SpringLayout.EAST, panel_1);
		panel_1.add(comboBox);

		JLabel lblNewLabel_5 = new JLabel("장");
		sl_panel_1.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 10, SpringLayout.NORTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.WEST, lblNewLabel_5, 7, SpringLayout.EAST, comboBox);
		panel_1.add(lblNewLabel_5);

		textField_2 = new JTextField();
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_2, 28, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_2, 0, SpringLayout.SOUTH, panel_4);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_2, -6, SpringLayout.WEST, panel_4);
		textField_2.setBackground(SystemColor.textHighlightText);
		textField_2.setBorder(WB);
		textField_2.setEditable(false);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		textField_5 = new JTextField();
		textField_5.setBackground(SystemColor.textHighlightText);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_5, 28, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_5, 0, SpringLayout.SOUTH, panel_4_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_5, -6, SpringLayout.WEST, panel_4_1);
		textField_5.setBorder(WB);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		panel_1.add(textField_5);

		textField_6 = new JTextField();
		textField_6.setBackground(SystemColor.textHighlightText);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_6, 0, SpringLayout.WEST, textField_5);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_6, 0, SpringLayout.SOUTH, panel_4_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_6, -6, SpringLayout.WEST, panel_4_1_1);
		textField_6.setBorder(WB);
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		panel_1.add(textField_6);

		textField_7 = new JTextField();
		textField_7.setBackground(SystemColor.textHighlightText);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_7, 28, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_7, 0, SpringLayout.SOUTH, panel_4_1_1_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_7, -6, SpringLayout.WEST, panel_4_1_1_1);
		textField_7.setBorder(WB);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		panel_1.add(textField_7);

		textField_8 = new JTextField();
		textField_8.setBackground(SystemColor.textHighlightText);
		sl_panel_1.putConstraint(SpringLayout.WEST, textField_8, 28, SpringLayout.WEST, panel_1);
		sl_panel_1.putConstraint(SpringLayout.SOUTH, textField_8, -10, SpringLayout.SOUTH, panel_1);
		sl_panel_1.putConstraint(SpringLayout.EAST, textField_8, -6, SpringLayout.WEST, panel_4_1_1_1_1);
		textField_8.setBorder(WB);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		panel_1.add(textField_8);

		JButton btnNewButton = new JButton("나의 등수 확인!");
		btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		sl_panel_1.putConstraint(SpringLayout.NORTH, btnNewButton, -4, SpringLayout.NORTH, lblNewLabel_3);
		sl_panel_1.putConstraint(SpringLayout.WEST, btnNewButton, 8, SpringLayout.WEST, panel_1);
		panel_1.add(btnNewButton);
		
		comboBox.setSelectedItem(1);
		updateResult(1);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tfList = Arrays.asList(textField_2, textField_5, textField_6, textField_7, textField_8);
				for (int i = 0; i < tfList.size(); i++) {
					tfList.get(i).setText("");
				}
				int index = combo.getSelectedIndex();
				if (index == 4) {
				MN();
				}
				lblNewLabel_2.setText(Integer.toString(amount) + "원") ;
				amount = 0;
				
			}
		});
		
		comboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Integer selectedValue = (Integer) comboBox.getSelectedItem();

				// 선택된 값이 null이 아닐 때 처리
				if (selectedValue != null) {
					// 패널 내부의 모든 컴포넌트 제거
					panel_4.removeAll();
					panel_4_1.removeAll();
					panel_4_1_1.removeAll();
					panel_4_1_1_1.removeAll();
					panel_4_1_1_1_1.removeAll();
					textField_2.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					// 선택된 값에 대한 처리
					for (Integer i : PurchaseHistory.pnlpurchaseNumber.keySet()) {
						if (i.equals(selectedValue)) {
							PurchaseHistory.pnlpurchaseNumber.get(i);
							for (JLabel lbl : PurchaseHistory.pnlpurchaseNumber.get(i))
								if (panel_4.getComponentCount() <= 5) {
									panel_4.add(lbl);
								} else if (panel_4_1.getComponentCount() <= 5) {
									panel_4_1.add(lbl);
								} else if (panel_4_1_1.getComponentCount() <= 5) {
									panel_4_1_1.add(lbl);
								} else if (panel_4_1_1_1.getComponentCount() <= 5) {
									panel_4_1_1_1.add(lbl);
								} else if (panel_4_1_1_1_1.getComponentCount() <= 5) {
									panel_4_1_1_1_1.add(lbl);

								}
						}
					}

					// 패널 리레이아웃 갱신
					panel_4.revalidate();
					panel_4.repaint();
					panel_4_1.revalidate();
					panel_4_1.repaint();
					panel_4_1_1.revalidate();
					panel_4_1_1.repaint();
					panel_4_1_1_1.revalidate();
					panel_4_1_1_1.repaint();
					panel_4_1_1_1_1.revalidate();
					panel_4_1_1_1_1.repaint();

				}

			}

		});

		JLabel lblNewLabel_6 = new JLabel("당첨 결과");
		springLayout.putConstraint(SpringLayout.NORTH, panel, 25, SpringLayout.SOUTH, lblNewLabel_6);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, lblNewLabel_6);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(BlackB);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 37, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, 156, SpringLayout.SOUTH, textField);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -10, SpringLayout.EAST, panel);
		panel.add(panel_2);

		lblNewLabel_6.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 21));
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 10, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_6, 47, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, 44, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_6, 159, SpringLayout.WEST, getContentPane());
		getContentPane().add(lblNewLabel_6);

		lblNewLabel_9 = new JLabel();
		panel_2.add(lblNewLabel_9);
		
		lblNewLabel_2 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 0, SpringLayout.NORTH, lblNewLabel_8);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_2, 31, SpringLayout.EAST, lblNewLabel_8);
		panel.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("");
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_4, 6, SpringLayout.EAST, lblNewLabel_7);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, 0, SpringLayout.SOUTH, lblNewLabel_7);
		panel.add(lblNewLabel_4);

		imageMap = new TreeMap<>();
		imageMap.put(1, "ball_1.png");
		imageMap.put(2, "ball_2.png");
		imageMap.put(3, "ball_3.png");
		imageMap.put(4, "ball_4.png");
		imageMap.put(5, "ball_5.png");
		imageMap.put(6, "ball_6.png");
		imageMap.put(7, "ball_7.png");
		imageMap.put(8, "ball_8.png");
		imageMap.put(9, "ball_9.png");
		imageMap.put(10, "ball_10.png");
		imageMap.put(11, "ball_11.png");
		imageMap.put(12, "ball_12.png");
		imageMap.put(13, "ball_13.png");
		imageMap.put(14, "ball_14.png");
		imageMap.put(15, "ball_15.png");
		imageMap.put(16, "ball_16.png");
		imageMap.put(17, "ball_17.png");
		imageMap.put(18, "ball_18.png");
		imageMap.put(19, "ball_19.png");
		imageMap.put(20, "ball_20.png");
		imageMap.put(21, "ball_21.png");
		imageMap.put(22, "ball_22.png");
		imageMap.put(23, "ball_23.png");
		imageMap.put(24, "ball_24.png");
		imageMap.put(25, "ball_25.png");
		imageMap.put(26, "ball_26.png");
		imageMap.put(27, "ball_27.png");
		imageMap.put(28, "ball_28.png");
		imageMap.put(29, "ball_29.png");
		imageMap.put(30, "ball_30.png");
		imageMap.put(31, "ball_31.png");
		imageMap.put(32, "ball_32.png");
		imageMap.put(33, "ball_33.png");
		imageMap.put(34, "ball_34.png");
		imageMap.put(35, "ball_35.png");
		imageMap.put(36, "ball_36.png");
		imageMap.put(37, "ball_37.png");
		imageMap.put(38, "ball_38.png");
		imageMap.put(39, "ball_39.png");
		imageMap.put(40, "ball_40.png");
		imageMap.put(41, "ball_41.png");
		imageMap.put(42, "ball_42.png");
		imageMap.put(43, "ball_43.png");
		imageMap.put(44, "ball_44.png");
		imageMap.put(45, "ball_45.png");

		keysList = new ArrayList<>(imageMap.keySet());

		Collections.shuffle(keysList);

		imageLabels = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			imageLabels[i] = new JLabel();
		}

		setSize(1000, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

//	public void MN() {
//		 List<JTextField> tfList = Arrays.asList(textField_2, textField_5, textField_6, textField_7, textField_8);
//	    tfIndex = 0;
//	    Integer selectedValue = (Integer) comboBox.getSelectedItem();
//
//	    if (Purchase.intSetList != null && selectedNumber2 != null) {
//
//	        if (selectedValue != null) {
//	            for (int k = 0; k < 5; k++) {
//	                int count = 0;
//
//	                for (Integer a : selectedNumber2) {
//	                    for (Set<Integer> c : Purchase.purchaseNumList.get(selectedValue)) {
//	                        for (Integer b : c) {
//	                            if (a.equals(b)) {
//	                                count++;
//	                            }
//	                        }
//	                    }
//	                }
//	                
//	                switch (count) {
//	                    case 4:
//	                        tfList.get(tfIndex).setText("2");
//	                        break;
//	                    case 3:
//	                        tfList.get(tfIndex).setText("3");
//	                        break;
//	                    case 2:
//	                        tfList.get(tfIndex).setText("4");
//	                        break;
//	                    case 1:
//	                        tfList.get(tfIndex).setText("5");
//	                        break;
//	                    default:
//	                        tfList.get(tfIndex).setText("꽝");
//	                        break;
//	                }
//
//	                tfIndex++;
//	            }
//	        } else {
//	            // 선택된 아이템이 없을 때의 처리
//	            // 예: 적절한 디폴트 값 설정 또는 사용자에게 메시지 표시 등
//	        }
//	    }
//	}

	public void MN() {
		Integer selectedValue = (Integer) comboBox.getSelectedItem();

		if (Purchase.intSetList != null && selectedNumber2 != null) {
			if (selectedValue != null) {
				for (int k = 0; k < Purchase.purchaseNumList.get(selectedValue).size(); k++) {
					int count = 0;

					for (Integer a : selectedNumber2) {
						for (Integer c : Purchase.purchaseNumList.get(selectedValue).get(k)) {
							if (a.equals(c)) {
								count++;
							}
						}
					}
					switch (count) {
					case 4:
						tfList.get(k).setText("2등");
						amount += 5800000;
						break;
					case 3:
						tfList.get(k).setText("3등");
						amount += 150000;
						break;
					case 2:
						tfList.get(k).setText("4등");
						amount += 50000;
						break;
					case 1:
						tfList.get(k).setText("5등");
						amount += 5000;
						break;
					default:
						tfList.get(k).setText("낙첨");
						break;
					}
				}
			}
		}
	}

	private void updateResult(int selectedValue) {
		// 해당 값에 대한 처리
		for (Integer i : Purchase.purchaseNumList.keySet()) {
			if (i.equals(selectedValue)) {
				Purchase.purchaseNumList.get(i);
				for (JLabel lbl : PurchaseHistory.pnlpurchaseNumber.get(i))
					if (panel_4.getComponentCount() <= 5) {
						panel_4.add(lbl);
					} else if (panel_4_1.getComponentCount() <= 5) {
						panel_4_1.add(lbl);
					} else if (panel_4_1_1.getComponentCount() <= 5) {
						panel_4_1_1.add(lbl);
					} else if (panel_4_1_1_1.getComponentCount() <= 5) {
						panel_4_1_1_1.add(lbl);
					} else if (panel_4_1_1_1_1.getComponentCount() <= 5) {
						panel_4_1_1_1_1.add(lbl);
					}
			}
		}
	}
	// private void updateTextField(List<JTextField> tfList, String rank) {
//		tfList.get(tfIndex).setText(rank);
	// tfIndex++;
	// }

	public static void purchaseAdd() {
		purchase.add(purchaseindex);
		purchaseindex++;
	}

	public static void main(String[] args) {
		new Result();

	}
}
