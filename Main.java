import java.util.*;
import java.awt.EventQueue;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.math.BigInteger;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Main {
		Input input;
		String Divisortext;
		String Dividendtext;
		int inputtype;
		JFrame Window;
		JTextField Dividend;
		JTextField Divisor;
		JScrollPane A;
		JTextPane A_out;
		JTextField M_out;
		JTextPane Q_out;
		JComboBox InputType;
		private JTextField M_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.Window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Window = new JFrame();
		Window.getContentPane().setForeground(Color.LIGHT_GRAY);
		Window.setTitle("Restoring Unsigned Binary Division");
		Window.setResizable(false);
		Window.setBounds(100, 100, 940, 700);
		Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Window.getContentPane().setLayout(null);
		
		JPanel Input = new JPanel();
		Input.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		Input.setBounds(0, 92, 289, 568);
		Window.getContentPane().add(Input);
		Input.setLayout(null);
		
		Dividend = new JTextField("Dividend");
		Dividend.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	            Dividend.setText("");
	        }

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
		Dividend.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		Dividend.setHorizontalAlignment(SwingConstants.CENTER);
		Dividend.setText("Dividend");
		Dividend.setBounds(15, 323, 259, 51);
		Input.add(Dividend);
		Dividend.setColumns(10);
		
		Divisor = new JTextField("Divisor");
		Divisor.addFocusListener(new FocusListener(){
	        @Override
	        public void focusGained(FocusEvent e){
	            Divisor.setText("");
	        }

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
	    });
		Divisor.setHorizontalAlignment(SwingConstants.CENTER);
		Divisor.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		Divisor.setBounds(15, 426, 259, 51);
		Input.add(Divisor);
		Divisor.setColumns(10);
		
		JButton Submit = new JButton("Divide");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//////////////////////////////
				checkValid();
			}
		});
		Submit.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		Submit.setBounds(15, 493, 126, 59);
		Input.add(Submit);
		
		JPanel Output = new JPanel();
		Output.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.DARK_GRAY));
		Output.setBounds(292, 92, 642, 568);
		Window.getContentPane().add(Output);
		Output.setLayout(null);
		
		A = new JScrollPane();
		A_out = new JTextPane();
		A_out.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		A_out.setEditable(false);
		A_out.setBounds(15, 36, 220, 516);
		A.setViewportView(A_out);
		A.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		A.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		A.setBounds(7, 16, 310, 495);
		Output.add(A);
		
		JLabel lblA = new JLabel("A");
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		A.setColumnHeaderView(lblA);
		
		JScrollPane Q = new JScrollPane();
		Q.setViewportBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		Q.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		Q.setBounds(317, 16, 310, 495);
		Output.add(Q);
		
		Q_out = new JTextPane();
		Q_out.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		Q_out.setEditable(false);
		Q.setViewportView(Q_out);
		
		JLabel lblQ = new JLabel("Q");
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		Q.setColumnHeaderView(lblQ);
		
		M_out = new JTextField();
		M_out.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		M_out.setEditable(false);
		M_out.setBounds(43, 519, 189, 33);
		Output.add(M_out);
		M_out.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("M");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		lblNewLabel.setBounds(17, 527, 16, 20);
		Output.add(lblNewLabel);
		
		M_2 = new JTextField();
		M_2.setFont(new Font("OCR A Extended", Font.PLAIN, 17));
		M_2.setEditable(false);
		M_2.setColumns(10);
		M_2.setBounds(366, 519, 189, 33);
		Output.add(M_2);
		
		JLabel lblM = new JLabel("M 2's ");
		lblM.setHorizontalAlignment(SwingConstants.CENTER);
		lblM.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		lblM.setBounds(288, 524, 71, 20);
		Output.add(lblM);
		
		JPanel Space = new JPanel();
		Space.setForeground(Color.WHITE);
		Space.setBounds(0, 16, 934, 67);
		Window.getContentPane().add(Space);
		Space.setLayout(new CardLayout(0, 0));
		
		JLabel Title = new JLabel("Restoring \r\n\r\nUnsigned Binary Division");
		Space.add(Title, "name_945317721088902");
		Title.setLabelFor(Input);
		
		JTextPane Instructions = new JTextPane();
		Instructions.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		Instructions.setBackground(Color.LIGHT_GRAY);
		Instructions.setEditable(false);
		Instructions.setText("Please enter the numbers to divide below.\r\n(Accepts both binary and decimal)\r\nPlease note that the maximum input is up to 32-bits.\r\n(Or 4,294,967,295 in decimal)\r\nEnjoy!");
		Instructions.setBounds(15, 16, 259, 181);
		Input.add(Instructions);
		
		InputType = new JComboBox();
		InputType.setToolTipText("");
		InputType.setModel(new DefaultComboBoxModel(new String[] {"Binary", "Decimal"}));
		InputType.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		InputType.setBounds(72, 246, 132, 51);
		Input.add(InputType);
		
		JLabel lbl1 = new JLabel("Input Type");
		lbl1.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setBounds(72, 213, 132, 30);
		Input.add(lbl1);
		
		JLabel lbl2 = new JLabel("/");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("OCR A Extended", Font.BOLD, 22));
		lbl2.setBounds(104, 380, 69, 40);
		Input.add(lbl2);
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Lets start again!", "Yay", 1);
				Divisor.setText("Divisor");
				Dividend.setText("Dividend");
				A_out.setText("");
				Q_out.setText("");
				M_out.setText("");
				M_2.setText("");
				InputType.setSelectedIndex(0);
				input.reset();
			}
		});
		Reset.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		Reset.setBounds(148, 493, 126, 59);
		Input.add(Reset);
		Title.setToolTipText("");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
	}
	
	public void checkValid(){
		int check = 1;
		String d_dend = Dividend.getText();
		String d_sor = Divisor.getText();
		int inptype = InputType.getSelectedIndex();
		
		//check inputs if valid here
		if(inptype == 0){
			if(!d_dend.matches("[01]+") || !d_sor.matches("[01]+")){
				check = 0;
			}
			if(d_dend.length() > 32 || d_sor.length() > 32){
				check = 0;
			}
		}
		else{
			if(!d_dend.matches("[0-9]+") || !d_sor.matches("[0-9]+")){
				check = 0;
			}
			if(Long.parseLong(d_dend) > Long.parseLong("4294967295") || Long.parseLong(d_dend) < 0 || Long.parseLong(d_sor) > Long.parseLong("4294967295") || Long.parseLong(d_sor) < 0){
				check = 0;
			}
		}
		
		//refresh jframe or add values to input and carry on with process.
		switch(check){
		case 0:
			JOptionPane.showMessageDialog(null, "Your input is invalid or out of bounds or not matching. \nPlease try again.", "Error!", 1);
			break;
			
		case 1:
			JOptionPane.showMessageDialog(null, "Yay! Lets divide.", "Successful!", 1);
			
			if(inptype == 1){
				d_dend = toBinary(d_dend);
				d_sor = toBinary(d_sor);
			}
			
			input = new Input(d_dend, d_sor);
			divideDisp();
		}
	}
	
	public void divideDisp(){
		int loop = input.getCycle();
		input.getComplement();
		M_out.setText(input.getM());
		M_2.setText(input.getMtwo());
		A_out.setText("Intial value: " + input.getA() + "\n\n");
		Q_out.setText("Intial value: " + input.getQ() + "\n\n");
		
		for(int i = 0; i <= loop; i++){
			input.shiftAQ();
			A_out.setText(A_out.getText() + "Cycle # " + (i+1) + ":\n" + input.getAshift() + "\n");
			Q_out.setText(Q_out.getText() + "Cycle # " + (i+1) + ":\n" + input.getQshift() + "\n");
			input.subtract();
			A_out.setText(A_out.getText() + input.getAsub());
			if(input.rest() == 1)
				A_out.setText(A_out.getText() + " Restore\n");
			else 
				A_out.setText(A_out.getText() + "\n");
			input.checkRestore();
			A_out.setText(A_out.getText() + input.getA() + "\n\n");
			Q_out.setText(Q_out.getText() + input.getQ() + "\n\n");
		}
		
		A_out.setText(A_out.getText() + "\nFinal Answer (remainder): " + input.getA() + "\n" + input.toDecimal(input.getA()));
		Q_out.setText(Q_out.getText() + "\nFinal Answer (quotient): " + input.getQ() + "\n" + input.toDecimal(input.getQ()));
		
		JOptionPane.showMessageDialog(null, "All done!", "Yay!", 1);
	}
	
	public String toBinary(String i){
		/*double temp = Double.parseDouble(i);
		if (temp == 0) {
	           return "0";
	       }
	       String binary = "";
	       while (temp > 0) {
	           int rem = (int) (temp % 2);
	           binary = rem + binary;
	           temp = temp / 2;
	       }
	       return binary;
	       */
		return Long.toString(Long.parseLong(i), 2);
	}
}
