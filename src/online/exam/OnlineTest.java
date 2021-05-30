package online.exam;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class OnlineTest extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	JLabel label;
	JRadioButton radioButton[] = new JRadioButton[5];
	JButton btnNext, btnBookmark;
	ButtonGroup bg;
	int count = 0, current = 0, x = 1, y = 1, now = 0;
	int m[] = new int[10];

	// create jFrame with radioButton and JButton
	OnlineTest(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		btnNext = new JButton("Next");
                btnNext.setBackground(Color.cyan);
		btnBookmark = new JButton("Bookmark");
                btnBookmark.setBackground(Color.orange);
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 100, 30);
		btnBookmark.setBounds(270, 240, 100, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(600, 350);
	}

	// handle all actions based on event
        @Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (check())
				count = count + 1;
			current++;
			set();
			if (current == 9) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		if (e.getActionCommand().equals("Bookmark")) {
			JButton bk = new JButton("Bookmark" + x);
			bk.setBounds(480, 20 + 30 * x, 100, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 9)
				btnBookmark.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (check())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (check())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this, "correct answers= " + count);
			System.exit(0);
		}
	}

	// SET Questions with options
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("Question 1:  Which of the following is not a Java feature?");
			radioButton[0].setText("Architecture neutral");
			radioButton[1].setText("Dynamic");
			radioButton[2].setText("Object oriented");
			radioButton[3].setText("Pointers");
		}
		if (current == 1) {
			label.setText("Question 2:  What is the return type of the hashCode() method in the Object class?");
			radioButton[0].setText("long");
			radioButton[1].setText("void");
			radioButton[2].setText("int");
			radioButton[3].setText("default");
		}
		if (current == 2) {
			label.setText("Question 3: Which of the following is a valid declaration of a char?");
			radioButton[0].setText("char ch = '\\utea'");
			radioButton[1].setText("char ca = 'tea'");
			radioButton[2].setText("char cr = \\u0223");
			radioButton[3].setText("char cc = '\\itea'");
		}
		if (current == 3) {
			label.setText("Question 4: Which is the new method introduced in java 8 to iterate over a collection?");
			radioButton[0].setText("for (String i : StringList)");
			radioButton[1].setText("foreach (String i : StringList)");
			radioButton[2].setText("StringList.forEach()");
			radioButton[3].setText("List.for()");
		}
		if (current == 4) {
			label.setText("Question 5:  Which of the following is a valid long literal?");
			radioButton[0].setText("ABH8097");
			radioButton[1].setText("L990023");
			radioButton[2].setText("904423");
			radioButton[3].setText("0xnf029L");
		}
		if (current == 5) {
			label.setText("Question 6: How to read entire file in one line using java 8?");
			radioButton[0].setText("Files.readAllLines()");
			radioButton[1].setText("Files.read()");
			radioButton[2].setText("Files.readFile()");
			radioButton[3].setText("Files.lines()");
		}
		if (current == 6) {
			label.setText("Question 7: What does the expression float a = 35 / 0 return?");
			radioButton[0].setText("0");
			radioButton[1].setText("NaN");
			radioButton[2].setText("Infinity");
			radioButton[3].setText("Run time exception");
		}
		if (current == 7) {
			label.setText("Question 8: Evaluate the following Java expression, if x=3, y=5, and z=10:\n" + "\n" + "++z + y - y + z + x++");
			radioButton[0].setText("22");
			radioButton[1].setText("23");
			radioButton[2].setText("24");
			radioButton[3].setText("25");
		}
		if (current == 8) {
			label.setText("Question 9: Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?");
			radioButton[0].setText("javadoc tool");
			radioButton[1].setText("javap tool");
			radioButton[2].setText("javaw command");
			radioButton[3].setText("javah command");
		}
		if (current == 9) {
			label.setText("Question 10: Which of the following creates a List of 3 visible items and multiple selections abled?");
			radioButton[0].setText("new List(3, true)");
			radioButton[1].setText("new List(true, 3)");
			radioButton[2].setText("new List(3, false)");
			radioButton[3].setText("new List(false, 3)");
		}
		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	// declare right answers.
	boolean check() {
		if (current == 0)
			return (radioButton[3].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[0].isSelected());
		if (current == 3)
			return (radioButton[2].isSelected());
		if (current == 4)
			return (radioButton[3].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[2].isSelected());
		if (current == 7)
			return (radioButton[2].isSelected());
		if (current == 8)
			return (radioButton[0].isSelected());
		if (current == 9)
			return (radioButton[0].isSelected());
		return false;
	}

	public static void main(String s[]) {
		new OnlineTest("Online Test App");
	}

}