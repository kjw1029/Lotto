package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.SystemColor;
import javax.swing.UIManager;

public class PurchaseHistory extends JFrame {
	private JPanel contentPane;
	private LineBorder BB = new LineBorder(new Color(63, 108, 198), 2, true);
//	protected static Vector<Integer> round = new Vector<>(); // 회차 리스트
	protected static Vector<Integer> purchase = new Vector<>(); // 구매 리스트
//	protected static int index = 1; // 회차콤보박스
	protected static int purchaseindex = 1; // 구매콤보박스
	protected static int numberOfPurchases = 1; // 구매장수
	protected static List<JLabel> pnlwinningNumber = new ArrayList<>();;
	protected static Map<Integer, List<JLabel>> pnlpurchaseNumber = new HashMap<>();;
//	protected static ArrayList<Integer> winningNumber = new ArrayList<>(); // 당첨번호
//	protected static ArrayList<ArrayList<Integer>> purchaseNumber = new ArrayList<>(); // 구매번호
	private JComboBox comboBox_1;
	private FlowLayout flowLayout;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PurchaseHistory frame = new PurchaseHistory();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PurchaseHistory() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		setTitle("로또 구매내역");
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);

		JButton btnNewButton = new JButton("뒤로 가기");
		sl_panel.putConstraint(SpringLayout.WEST, btnNewButton, 354, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, btnNewButton, -62, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, btnNewButton, -10, SpringLayout.EAST, panel);
		btnNewButton.setBackground(UIManager.getColor("Button.disabledForeground"));
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 14));
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GUIMain().setVisible(true);
				dispose();

			}
		});
		panel.add(btnNewButton);

		comboBox_1 = new JComboBox(purchase);
		sl_panel.putConstraint(SpringLayout.NORTH, comboBox_1, 38, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, comboBox_1, 186, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, comboBox_1, -483, SpringLayout.SOUTH, panel);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setFont(new Font("굴림", Font.BOLD, 25));
		panel.add(comboBox_1);


		panel_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.WEST, panel_1, 108, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_1, -71, SpringLayout.EAST, panel);
		panel.add(panel_1);
		panel_1.setBorder(BB);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_1.setBackground(Color.WHITE);

		panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_1, -6, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, 0, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 168, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -323, SpringLayout.SOUTH, panel);
		panel.add(panel_2);
		panel_2.setBorder(BB);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_2.setBackground(Color.WHITE);
		
		panel_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_3, 6, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, panel_3, 0, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_3, 0, SpringLayout.EAST, panel_1);
		panel.add(panel_3);
		panel_3.setBorder(BB);
		panel_3.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_3.setBackground(Color.WHITE);

		panel_4 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_4, 300, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_3, -6, SpringLayout.NORTH, panel_4);
		sl_panel.putConstraint(SpringLayout.EAST, panel_4, 0, SpringLayout.EAST, panel_1);
		panel.add(panel_4);
		panel_4.setBorder(BB);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_4.setBackground(Color.WHITE);

		panel_5 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 244, SpringLayout.SOUTH, panel_5);
		sl_panel.putConstraint(SpringLayout.NORTH, btnNewButton, 33, SpringLayout.SOUTH, panel_5);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_4, -6, SpringLayout.NORTH, panel_5);
		sl_panel.putConstraint(SpringLayout.WEST, panel_5, 0, SpringLayout.WEST, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_5, 0, SpringLayout.EAST, panel_1);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_5, 366, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_5, -125, SpringLayout.SOUTH, panel);
		panel.add(panel_5);
		panel_5.setBorder(BB);
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
		panel_5.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("장");
		sl_panel.putConstraint(SpringLayout.NORTH, panel_1, 26, SpringLayout.SOUTH, lblNewLabel_1);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_1, -480, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 38, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 263, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, comboBox_1, -6, SpringLayout.WEST, lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 25));
		panel.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6, 97, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_6, -23, SpringLayout.WEST, panel_1);
		panel_6.setBackground(Color.WHITE);
		panel.add(panel_6);
		
		JPanel panel_6_1 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6, -6, SpringLayout.NORTH, panel_6_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 23, SpringLayout.EAST, panel_6_1);
		sl_panel.putConstraint(SpringLayout.EAST, panel_6_1, 0, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6_1, 168, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6_1, 30, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6_1, -323, SpringLayout.SOUTH, panel);
		panel_6_1.setBackground(Color.WHITE);
		panel.add(panel_6_1);
		
		JPanel panel_6_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.EAST, panel_6_2, 0, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6_2, 6, SpringLayout.SOUTH, panel_6_1);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6_2, 30, SpringLayout.WEST, panel);
		panel_6_2.setBackground(Color.WHITE);
		SpringLayout sl_panel_6_1 = new SpringLayout();
		panel_6_1.setLayout(sl_panel_6_1);
		
		JLabel lblNewLabel_3 = new JLabel("B");
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 25));
		sl_panel_6_1.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 5, SpringLayout.NORTH, panel_6_1);
		sl_panel_6_1.putConstraint(SpringLayout.WEST, lblNewLabel_3, 7, SpringLayout.WEST, panel_6_1);
		sl_panel_6_1.putConstraint(SpringLayout.SOUTH, lblNewLabel_3, -10, SpringLayout.SOUTH, panel_6_1);
		sl_panel_6_1.putConstraint(SpringLayout.EAST, lblNewLabel_3, -7, SpringLayout.EAST, panel_6_1);
		panel_6_1.add(lblNewLabel_3);
		panel.add(panel_6_2);
		
		JPanel panel_6_3 = new JPanel();
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6_2, -6, SpringLayout.NORTH, panel_6_3);
		sl_panel.putConstraint(SpringLayout.WEST, panel_4, 23, SpringLayout.EAST, panel_6_3);
		sl_panel.putConstraint(SpringLayout.EAST, panel_6_3, 0, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.NORTH, panel_6_3, 300, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_6_3, -191, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_6_3, 30, SpringLayout.WEST, panel);
		panel_6_3.setBackground(Color.WHITE);
		SpringLayout sl_panel_6_2 = new SpringLayout();
		panel_6_2.setLayout(sl_panel_6_2);
		
		JLabel lblNewLabel_4 = new JLabel("C");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 25));
		sl_panel_6_2.putConstraint(SpringLayout.NORTH, lblNewLabel_4, 5, SpringLayout.NORTH, panel_6_2);
		sl_panel_6_2.putConstraint(SpringLayout.WEST, lblNewLabel_4, 7, SpringLayout.WEST, panel_6_2);
		sl_panel_6_2.putConstraint(SpringLayout.SOUTH, lblNewLabel_4, -10, SpringLayout.SOUTH, panel_6_2);
		sl_panel_6_2.putConstraint(SpringLayout.EAST, lblNewLabel_4, -10, SpringLayout.EAST, panel_6_2);
		panel_6_2.add(lblNewLabel_4);
		panel.add(panel_6_3);
		SpringLayout sl_panel_6_3 = new SpringLayout();
		panel_6_3.setLayout(sl_panel_6_3);
		
		JLabel lblNewLabel_5 = new JLabel("D");
		lblNewLabel_5.setFont(new Font("굴림", Font.BOLD, 25));
		sl_panel_6_3.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 5, SpringLayout.NORTH, panel_6_3);
		sl_panel_6_3.putConstraint(SpringLayout.WEST, lblNewLabel_5, 7, SpringLayout.WEST, panel);
		sl_panel_6_3.putConstraint(SpringLayout.SOUTH, lblNewLabel_5, -10, SpringLayout.SOUTH, panel_6_3);
		sl_panel_6_3.putConstraint(SpringLayout.EAST, lblNewLabel_5, -10, SpringLayout.EAST, panel_6_3);
		panel_6_3.add(lblNewLabel_5);
		SpringLayout sl_panel_6 = new SpringLayout();
		panel_6.setLayout(sl_panel_6);
		
		JLabel lblNewLabel_2 = new JLabel("A");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 25));
		sl_panel_6.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 5, SpringLayout.NORTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.WEST, lblNewLabel_2, 7, SpringLayout.WEST, panel_6);
		sl_panel_6.putConstraint(SpringLayout.SOUTH, lblNewLabel_2, -10, SpringLayout.SOUTH, panel_6);
		sl_panel_6.putConstraint(SpringLayout.EAST, lblNewLabel_2, -7, SpringLayout.EAST, panel_6);
		panel_6.add(lblNewLabel_2);
		
		JPanel panel_7 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_7, 6, SpringLayout.SOUTH, panel_6_3);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_7, -125, SpringLayout.SOUTH, panel);
		sl_panel.putConstraint(SpringLayout.EAST, panel_7, 0, SpringLayout.EAST, panel_6);
		sl_panel.putConstraint(SpringLayout.WEST, panel_7, 30, SpringLayout.WEST, panel);
		panel_7.setBackground(Color.WHITE);
		panel.add(panel_7);
		SpringLayout sl_panel_7 = new SpringLayout();
		panel_7.setLayout(sl_panel_7);
		
		JLabel lblNewLabel = new JLabel("E");
		sl_panel_7.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, panel_7);
		sl_panel_7.putConstraint(SpringLayout.SOUTH, lblNewLabel, -5, SpringLayout.SOUTH, panel_7);
		sl_panel_7.putConstraint(SpringLayout.EAST, lblNewLabel, 44, SpringLayout.WEST, panel_7);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		panel_7.add(lblNewLabel);
		
		JLabel lblNewLabel_6 = new JLabel("구매내역");
		sl_panel.putConstraint(SpringLayout.NORTH, lblNewLabel_6, 0, SpringLayout.NORTH, comboBox_1);
		sl_panel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 0, SpringLayout.WEST, panel_6);
		sl_panel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -29, SpringLayout.NORTH, panel_1);
		sl_panel.putConstraint(SpringLayout.EAST, lblNewLabel_6, -46, SpringLayout.WEST, comboBox_1);
		lblNewLabel_6.setFont(new Font("휴먼둥근헤드라인", Font.PLAIN, 25));
		panel.add(lblNewLabel_6);
		
		// 초기값 설정 및 해당 값에 대한 처리
	    comboBox_1.setSelectedItem(1);
	    updatePurchaseHistory(1);
	    
		// 여러장 구매했을시 내가 구매한 로또내역 출력
		comboBox_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 선택된 값 가져오기
				Integer selectedValue = (Integer) comboBox_1.getSelectedItem();

				// 선택된 값이 null이 아닐 때 처리
				if (selectedValue != null) {
					// 패널 내부의 모든 컴포넌트 제거
					panel_1.removeAll();
					panel_2.removeAll();
					panel_3.removeAll();
					panel_4.removeAll();
					panel_5.removeAll();

					// 선택된 값에 대한 처리
					updatePurchaseHistory(selectedValue);

					// 패널 리레이아웃 갱신
					panel_1.revalidate();
					panel_1.repaint();
					panel_2.revalidate();
					panel_2.repaint();
					panel_3.revalidate();
					panel_3.repaint();
					panel_4.revalidate();
					panel_4.repaint();
					panel_5.revalidate();
					panel_5.repaint();
				}
			}
		});
	}


	// 구매시 장수 올려주는 메소드
	public static void purchaseAdd() {
		purchase.add(purchaseindex);
		purchaseindex++;
	}
	private void updatePurchaseHistory(int selectedValue) {
	    // 해당 값에 대한 처리
	    for (Integer i : pnlpurchaseNumber.keySet()) {
	        if (i.equals(selectedValue)) {
	            pnlpurchaseNumber.get(i);
	            for (JLabel lbl : pnlpurchaseNumber.get(i))
	                if (panel_1.getComponentCount() <= 5) {
	                    panel_1.add(lbl);
	                } else if (panel_2.getComponentCount() <= 5) {
	                    panel_2.add(lbl);
	                } else if (panel_3.getComponentCount() <= 5) {
	                    panel_3.add(lbl);
	                } else if (panel_4.getComponentCount() <= 5) {
	                    panel_4.add(lbl);
	                } else if (panel_5.getComponentCount() <= 5) {
	                    panel_5.add(lbl);
	                }
	        }
	    }
	}
}
