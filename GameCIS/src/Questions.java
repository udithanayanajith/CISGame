
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Questions implements ActionListener{

String[] Questions = 	{
					
						"If 1=3,  2=3,  3=5,  4=4,  5=4,  Then, 6=?",
						"What comes next?   3, 6, 18, 72, _____",
						"Solve The Pattern Below, 4^1 = 4,  4^2 = 16,  4^3 =64, 4^4 = ?",
						"How many times does the digit 5 occur in the numbers from 1 to 100?",
						" A + B = 76    A - B = 38     A / B =?",
						"What is 1.92 divided by 3?",
						"A + A + A = 60,  A + B +B = 30, B - 2C = 3 , A + B + C = ?",
						" If 1= 5, 2= 25, 3= 325, 4 = 4325,Then 5 = ",
					};
String[][] Options = 	{
	
						{"1","2","3","4"},
						{"360","362","350","340"},
						{"255","256","257","258"},
						{"15","22","30","20"},
						{"1","3","8","2"},
						{"0.6","0.62","0.63","0.64"},
						{"18","26","33","24"},
						{" 54325"," 52325"," 56325"," 55325"},
						
					};
char[] Answers = 		{
						
						'C',
						'A',
						'B',
						'D',
						'A',
						'D',
						'B',
						'A',
						
						
						
						
					};
char guess;
char Answer;
int index;
int correct_guesses =0;
int TotalQues = Questions.length;
int Result;
int seconds=10;

JFrame Frame = new JFrame();
JTextField Textfield = new JTextField();
JTextArea Textarea = new JTextArea();
JButton buttonA = new JButton();
JButton buttonB = new JButton();
JButton buttonC = new JButton();
JButton buttonD = new JButton();
JLabel AnslabelA = new JLabel();
JLabel AnslabelB = new JLabel();
JLabel AnslabelC = new JLabel();
JLabel AnslabelD = new JLabel();
JLabel Timelabel = new JLabel();
JLabel Secleft = new JLabel();
JTextField CorrectAns = new JTextField();
JTextField Percentage = new JTextField();

Timer timer = new Timer(1000, new ActionListener() {

@Override
public void actionPerformed(ActionEvent e) {
	seconds--;
	Secleft.setText(String.valueOf(seconds));
	if(seconds<=0) {
		displayAnswer();
	}
	}
});

public Questions() {
Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
Frame.setBounds(100, 100, 630, 480);
Frame.getContentPane().setBackground(new Color(102, 205, 170));
Frame.setLayout(null);
Frame.setResizable(false);
JLabel lblNewLabel_1 = new JLabel("");
lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\dewanmini\\Downloads\\4-49183_our-mission-children-first-early-learning-center-math.png"));
lblNewLabel_1.setBounds(100, 100, 630, 480);


Textfield.setBounds(223, 11, 248, 29);
Textfield.setBackground(new Color(5,5,50));
Textfield.setForeground(new Color(244, 164, 96));
Textfield.setFont(new Font("Tahoma", Font.BOLD, 16));
Textfield.setBorder(BorderFactory.createBevelBorder(1));
Textfield.setHorizontalAlignment(JTextField.CENTER);
Textfield.setEditable(false);

Textarea.setBounds(94, 54, 610, 42);
Textarea.setBackground(new Color(102, 205,170));
Textarea.setForeground(new Color(240, 240, 240));
Textarea.setFont(new Font("Yu Gothic", Font.BOLD, 15));


buttonA.setBounds(22, 105, 43, 29);
buttonA.setFont(new Font("Tahoma", Font.BOLD, 12));
buttonA.setFocusable(false);
buttonA.addActionListener(this);
buttonA.setText("A");

buttonB.setBounds(22, 145, 43, 29);
buttonB.setFont(new Font("Tahoma", Font.BOLD, 12));
buttonB.setFocusable(false);
buttonB.addActionListener(this);
buttonB.setText("B");

buttonC.setBounds(22, 185, 43, 29);
buttonC.setFont(new Font("Tahoma", Font.BOLD, 12));
buttonC.setFocusable(false);
buttonC.addActionListener(this);
buttonC.setText("C");

buttonD.setBounds(22, 225, 43, 29);
buttonD.setFont(new Font("Tahoma", Font.BOLD, 12));
buttonD.setFocusable(false);
buttonD.addActionListener(this);
buttonD.setText("D");

AnslabelA.setBounds(90, 112, 200, 22);
AnslabelA.setBackground(new Color(50,50,50));
AnslabelA.setForeground(new Color(0, 0, 128));
AnslabelA.setFont(new Font("Tahoma", Font.BOLD, 15));

AnslabelB.setBounds(93, 152, 104, 22);
AnslabelB.setBackground(new Color(50,50,50));
AnslabelB.setForeground(new Color(0, 0, 128));
AnslabelB.setFont(new Font("Tahoma", Font.BOLD, 15));

AnslabelC.setBounds(93, 192, 104, 22);
AnslabelC.setBackground(new Color(50,50,50));
AnslabelC.setForeground(new Color(0, 0, 128));
AnslabelC.setFont(new Font("Tahoma", Font.BOLD, 15));

AnslabelD.setBounds(93, 232, 104, 22);
AnslabelD.setBackground(new Color(50,50,50));
AnslabelD.setForeground(new Color(0, 0, 128));
AnslabelD.setFont(new Font("Tahoma", Font.BOLD, 15));

Secleft.setBounds(492, 251, 68, 59);
Secleft.setBackground(new Color(25,25,25));
Secleft.setForeground(new Color(139, 0, 0));
Secleft.setFont(new Font("Segoe UI Black", Font.ITALIC, 20));
Secleft.setHorizontalAlignment(JTextField.CENTER);
Secleft.setText(String.valueOf(seconds));


Timelabel.setBounds(492, 281, 68, 59);
Timelabel.setBackground(new Color(50,50,50));
Timelabel.setForeground(new Color(139, 0, 0));
Timelabel.setFont(new Font("Segoe UI Black", Font.ITALIC, 16));
Timelabel.setHorizontalAlignment(JTextField.CENTER);
Timelabel.setText("TIMER");

CorrectAns.setBounds(225,225,200,100);
CorrectAns.setBackground(new Color(25,25,25));
CorrectAns.setForeground(new Color(25,255,0));
CorrectAns.setFont(new Font("Tohoma",Font.BOLD,50));
CorrectAns.setBorder(BorderFactory.createBevelBorder(1));
CorrectAns.setHorizontalAlignment(JTextField.CENTER);
CorrectAns.setEditable(false);

Percentage.setBounds(225,325,200,100);
Percentage.setBackground(new Color(25,25,25));
Percentage.setForeground(new Color(255,0,0));
Percentage.setFont(new Font("Tohoma",Font.BOLD,50));
Percentage.setBorder(BorderFactory.createBevelBorder(1));
Percentage.setHorizontalAlignment(JTextField.CENTER);
Percentage.setEditable(false);

Frame.add(Timelabel);
Frame.add(Secleft);
Frame.add(AnslabelA);
Frame.add(AnslabelB);
Frame.add(AnslabelC);
Frame.add(AnslabelD);
Frame.add(buttonA);
Frame.add(buttonB);
Frame.add(buttonC);
Frame.add(buttonD);
Frame.add(Textarea);
Frame.add(Textfield);
Frame.setVisible(true);

nextQuestion();
}
public void nextQuestion() {

if(index>=TotalQues) {
	results();
}
else {
	Textfield.setText("Question "+(index+1));
	Textarea.setText(Questions[index]);
	AnslabelA.setText(Options[index][0]);
	AnslabelB.setText(Options[index][1]);
	AnslabelC.setText(Options[index][2]);
	AnslabelD.setText(Options[index][3]);
	timer.start();
}
}
@Override
public void actionPerformed(ActionEvent e) {

	buttonA.setEnabled(false);
	buttonB.setEnabled(false);
	buttonC.setEnabled(false);
	buttonD.setEnabled(false);
	
	if(e.getSource()==buttonA) {
		Answer= 'A';
		if(Answer == Answers[index]) {
			correct_guesses++;
		}
	}
	if(e.getSource()==buttonB) {
		Answer= 'B';
		if(Answer == Answers[index]) {
			correct_guesses++;
		}
	}
	if(e.getSource()==buttonC) {
		Answer= 'C';
		if(Answer == Answers[index]) {
			correct_guesses++;
		}
	}
	if(e.getSource()==buttonD) {
		Answer= 'D';
		if(Answer == Answers[index]) {
			correct_guesses++;
		}
	}
	displayAnswer();
}
public void displayAnswer() {

timer.stop();

buttonA.setEnabled(false);
buttonB.setEnabled(false);
buttonC.setEnabled(false);
buttonD.setEnabled(false);

if(Answers[index] != 'A')
	AnslabelA.setForeground(new Color(220,20,60));
if(Answers[index] != 'B')
	AnslabelB.setForeground(new Color(220,20,60));
if(Answers[index] != 'C')
	AnslabelC.setForeground(new Color(220,20,60));
if(Answers[index] != 'D')
	AnslabelD.setForeground(new Color(220,20,60));

Timer pause = new Timer(2000, new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		AnslabelA.setForeground(new Color(0, 0, 128));
		AnslabelB.setForeground(new Color(0, 0, 128));
		AnslabelC.setForeground(new Color(0, 0, 128));
		AnslabelD.setForeground(new Color(0, 0, 128));
		
		Answer = ' ';
		seconds=10;
		Secleft.setText(String.valueOf(seconds));
		buttonA.setEnabled(true);
		buttonB.setEnabled(true);
		buttonC.setEnabled(true);
		buttonD.setEnabled(true);
		index++;
		nextQuestion();
	}
});
pause.setRepeats(false);
pause.start();
}
public void results(){

buttonA.setEnabled(false);
buttonB.setEnabled(false);
buttonC.setEnabled(false);
buttonD.setEnabled(false);

Result = (int)((correct_guesses/(double)TotalQues)*100);

Textfield.setText("RESULTS!");
Textarea.setText("");
AnslabelA.setText("");
AnslabelB.setText("");
AnslabelC.setText("");
AnslabelD.setText("");

CorrectAns.setText("("+correct_guesses+"/"+TotalQues+")");
Percentage.setText(Result+"%");

Frame.add(CorrectAns);
Frame.add(Percentage);

}
}
