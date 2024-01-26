package project;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class ImageDisplayApp extends JFrame {

	public static JLabel[] imageLabels;
	private JButton displayButton;
	private static List<Integer> keysList;
	private static TreeMap<Integer, String> imageMap;
	public static List<StringBuilder> listnumber;
	private static Component lblNewLabel_9;

	public ImageDisplayApp() {

		setTitle("로또 랜덤 번호");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

		displayButton = new JButton("번호 돌리기");

		displayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayRandomImages();
			}
		});

		setLayout(new FlowLayout());
		add(new JLabel("당첨 번호를 확인하세요"));
		add(displayButton);
		for (int i = 0; i < 8; i++) {
			add(imageLabels[i]);
		}

		setSize(500, 500);
		dispose();
		setVisible(true);
	}

	public void displayRandomImages() {
		TreeMap<Integer, String> shuffledTreeMap = new TreeMap<>();
		for (Integer key : keysList) {
			shuffledTreeMap.put(key, imageMap.get(key));
		}

		List<Integer> selectedNumber = keysList.subList(0, 8);
		Collections.sort(selectedNumber);

		for (int i = 0; i < 8; i++) {
			if (i == 6) {
				imageLabels[i].setText("+");
			} else {
				String imageList = shuffledTreeMap.get(selectedNumber.get(i));
				ImageIcon icon = new ImageIcon(imageList);
				imageLabels[i].setIcon(icon);
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new ImageDisplayApp();
			}
		});
	}

}

//Set<Integer> setOfSix = new TreeSet<>();
//Random random = new Random();
//while (setOfSix.size() < 6) {
//	setOfSix.add(random.nextInt(45) + 1);
//}
//StringBuilder result = new StringBuilder();
//for (int number : setOfSix) {
//	result.append(number).append(" ");
//}
//panel_2.setToolTipText(result.toString());
//
//Set<Integer> setOfOne = new HashSet<>();
//Random random2 = new Random();
//
//while (setOfOne.size() < 1) {
//	setOfOne.add(random2.nextInt(45) + 1);
//}
//
//result.append(" + ").append(setOfOne.iterator().next());
//
//panel_2.setToolTipText(result.toString());
