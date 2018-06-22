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
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Gui {

	private JFrame Window;
	private JTextField Dividend;
	private JTextField Divisor;
	private JScrollPane A;
	private JTextPane A_out;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
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
	public Gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Window = new JFrame();
		Window.getContentPane().setForeground(Color.LIGHT_GRAY);
		Window.setTitle("Non-Restoring Unsigned Binary Division");
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
		
		JTextPane Q_out = new JTextPane();
		Q.setViewportView(Q_out);
		
		JLabel lblQ = new JLabel("Q");
		lblQ.setHorizontalAlignment(SwingConstants.CENTER);
		Q.setColumnHeaderView(lblQ);
		
		textField = new JTextField();
		textField.setBounds(43, 519, 189, 33);
		Output.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("M");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 19));
		lblNewLabel.setBounds(17, 527, 16, 20);
		Output.add(lblNewLabel);
		
		JPanel Space = new JPanel();
		Space.setForeground(Color.WHITE);
		Space.setBounds(0, 16, 934, 67);
		Window.getContentPane().add(Space);
		Space.setLayout(new CardLayout(0, 0));
		
		JLabel Title = new JLabel("Non-Restoring \r\n\r\nUnsigned Binary Division");
		Space.add(Title, "name_945317721088902");
		Title.setLabelFor(Input);
		
		JTextPane Instructions = new JTextPane();
		Instructions.setFont(new Font("OCR A Extended", Font.PLAIN, 16));
		Instructions.setBackground(Color.LIGHT_GRAY);
		Instructions.setEditable(false);
		Instructions.setText("Please enter the numbers to divide below.\r\n(Accepts both binary and decimal)\r\nPlease note that the maximum input is up to 32-bits.\r\n(Or 4,294,967,295 in decimal)\r\nEnjoy!");
		Instructions.setBounds(15, 16, 259, 181);
		Input.add(Instructions);
		
		JComboBox InputType = new JComboBox();
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
		Reset.setFont(new Font("OCR A Extended", Font.PLAIN, 22));
		Reset.setBounds(148, 493, 126, 59);
		Input.add(Reset);
		Title.setToolTipText("");
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		Title.setFont(new Font("OCR A Extended", Font.PLAIN, 24));
	}
}
