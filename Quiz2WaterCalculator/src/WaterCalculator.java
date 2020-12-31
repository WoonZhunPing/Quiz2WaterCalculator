import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class WaterCalculator {

	private JFrame frmWaterCalculator;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WaterCalculator window = new WaterCalculator();
					window.frmWaterCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WaterCalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWaterCalculator = new JFrame();
		frmWaterCalculator.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmWaterCalculator.setTitle("Water Calculator");
		frmWaterCalculator.setBounds(100, 100, 450, 300);
		frmWaterCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWaterCalculator.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("How much water should you drink?");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(64, 25, 343, 47);
		frmWaterCalculator.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("My weight (kg):");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(58, 84, 150, 55);
		frmWaterCalculator.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(218, 95, 96, 41);
		frmWaterCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Tell Me");
		btnNewButton.setBackground(new Color(250, 128, 114));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				double weight,waterDrinkInOunces,waterDrinkInLitres;
				try {
					weight = Double.parseDouble(textField.getText());
					if(weight>0) {
					waterDrinkInOunces = Math.round(weight*2/3*100)/100.0;
					waterDrinkInLitres = Math.round(waterDrinkInOunces*0.0295735296*100)/100.0;
					JOptionPane.showMessageDialog(null, "Buddy, you should drink minimum "+ waterDrinkInLitres +"L of water per day!!");
					}else if(weight<0) {
						JOptionPane.showMessageDialog(null, "Please enter a positive value!");
					}else if(weight ==0) {
						JOptionPane.showMessageDialog(null, "Please enter a value that bigger than 0!");
					}
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Please enter a valid value!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(147, 172, 136, 47);
		frmWaterCalculator.getContentPane().add(btnNewButton);
	}
}
