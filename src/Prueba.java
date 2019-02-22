import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;

@SuppressWarnings("serial")
class Ventana extends JFrame implements ActionListener, KeyListener {
	
	JTextField txtFTempEntrada, txtFTempSalida;
	JComboBox<String> comboEntrada, comboSalida;
	DecimalFormat redondear =new DecimalFormat("###,###,##0.####");
	String respaldo="";
	
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());
		setTitle("Conversor Temperaturas");
		setSize(355, 170);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		JLabel lblSeparador1=new JLabel("                               "
				+ "                                                     ");
			lblSeparador1.setFont(new Font("Arial", 3, 15));
		add(lblSeparador1);
		
		
		JLabel lblConvertir=new JLabel("Convertir");
			lblConvertir.setFont(new Font("Arial", 3, 15));
		add(lblConvertir);
		
		
		txtFTempEntrada=new JTextField(10);
			txtFTempEntrada.setFont(new Font("Time New Romans", 0, 15));
			txtFTempEntrada.setHorizontalAlignment((int) CENTER_ALIGNMENT);
			txtFTempEntrada.addKeyListener(new KeyListener() {
				@Override
				public void keyTyped(KeyEvent e) {}
				
				@Override
				public void keyReleased(KeyEvent e) {
					if(!Character.isDigit(e.getKeyCode()) && e.getKeyCode()!=8 && e.getKeyCode()!=46){
						JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar numeros.");
						if(txtFTempEntrada.getText().length()==0)
							txtFTempEntrada.setText("");
						else{
							//txtFTempEntrada.setText(txtFTempEntrada.getText().substring(0, txtFTempEntrada.getText().length()-1));	
							txtFTempEntrada.setText(respaldo);	
						}
					}
					else
						respaldo=txtFTempEntrada.getText();
				}
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode()==46){
						if(txtFTempEntrada.getText().contains(".")){
							JOptionPane.showMessageDialog(rootPane, "Solo puedes ingresar valores reales.");
							txtFTempEntrada.setText(respaldo);
						}
					}
				}
			});
		add(txtFTempEntrada);
		
		
		comboEntrada=new JComboBox<String>();
			comboEntrada.addItem("-------------------");
			comboEntrada.addItem("° Centigrados");
			comboEntrada.addItem("° Fahrenheit");
			comboEntrada.addItem("° Kelvil");
			comboEntrada.addItem("° Rankine");
			comboEntrada.setFont(new Font("Time New Romans", 0, 15));
			comboEntrada.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(comboEntrada.getSelectedItem().equals("-------------------")){
						txtFTempSalida.setText("");
						comboSalida.removeAllItems();
						comboSalida.addItem("-------------------");
						comboSalida.setEnabled(false);
					}
					else if(comboEntrada.getSelectedItem().equals("° Centigrados")){
						comboSalida.removeAllItems();
						comboSalida.setEnabled(true);
						comboSalida.addItem("-------------------");
						comboSalida.addItem("° Fahrenheit");
						comboSalida.addItem("° Kelvil");
						comboSalida.addItem("° Rankine");
					}
					else if(comboEntrada.getSelectedItem().equals("° Fahrenheit")){
						comboSalida.removeAllItems();
						comboSalida.setEnabled(true);
						comboSalida.addItem("-------------------");
						comboSalida.addItem("° Centigrados");
						comboSalida.addItem("° Kelvil");
						comboSalida.addItem("° Rankine");
					}
					else if(comboEntrada.getSelectedItem().equals("° Kelvil")){
						comboSalida.removeAllItems();
						comboSalida.setEnabled(true);
						comboSalida.addItem("-------------------");
						comboSalida.addItem("° Centigrados");
						comboSalida.addItem("° Fahrenheit");
						comboSalida.addItem("° Rankine");
					}
					else if(comboEntrada.getSelectedItem().equals("° Rankine")){
						comboSalida.removeAllItems();
						comboSalida.setEnabled(true);
						comboSalida.addItem("-------------------");
						comboSalida.addItem("° Centigrados");
						comboSalida.addItem("° Fahrenheit");
						comboSalida.addItem("° Kelvil");
					}
				}
			});
		add(comboEntrada);
		
		
		JLabel lblSeparador2=new JLabel("                               "
				+ "                                                     ");
			lblSeparador2.setFont(new Font("Arial", 3, 15));
		add(lblSeparador2);
		
		
		JLabel lblA=new JLabel("A    ");
			lblA.setFont(new Font("Arial", 3, 15));
		add(lblA);
		
		
		comboSalida=new JComboBox<String>();
			comboSalida.addItem("-------------------");
			comboSalida.setFont(new Font("Time New Romans", 0, 15));
			comboSalida.setEnabled(false);
			comboSalida.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					double tempEntrada=Double.parseDouble(txtFTempEntrada.getText());
					double tempSalida=0;
					
					
					if(comboSalida.getSelectedItem()==null)
						txtFTempSalida.setText("");
					else{
						if(comboSalida.getSelectedItem().equals("-------------------"))
							txtFTempSalida.setText("");
						else{
							if(comboEntrada.getSelectedItem().equals("° Centigrados") &&
									comboSalida.getSelectedItem().equals("° Fahrenheit"))
								tempSalida=(tempEntrada*1.8)+32;
							else if(comboEntrada.getSelectedItem().equals("° Centigrados") &&
									comboSalida.getSelectedItem().equals("° Kelvil"))
								tempSalida=tempEntrada+273.15;
							else if(comboEntrada.getSelectedItem().equals("° Centigrados") &&
									comboSalida.getSelectedItem().equals("° Rankine"))
								tempSalida=(tempEntrada*1.8)+491.67;
							
							
							
							else if(comboEntrada.getSelectedItem().equals("° Fahrenheit") &&
									comboSalida.getSelectedItem().equals("° Centigrados"))
								tempSalida=(tempEntrada-32)/1.8;
							else if(comboEntrada.getSelectedItem().equals("° Fahrenheit") &&
									comboSalida.getSelectedItem().equals("° Kelvil"))
								tempSalida=(tempEntrada+459.67)/1.8;
							else if(comboEntrada.getSelectedItem().equals("° Fahrenheit") &&
									comboSalida.getSelectedItem().equals("° Rankine"))
								tempSalida=tempEntrada+459.67;
							
							
							
							else if(comboEntrada.getSelectedItem().equals("° Kelvil") &&
									comboSalida.getSelectedItem().equals("° Centigrados"))
								tempSalida=tempEntrada-273.15;
							else if(comboEntrada.getSelectedItem().equals("° Kelvil") &&
									comboSalida.getSelectedItem().equals("° Fahrenheit"))
								tempSalida=((tempEntrada-273.15)*1.8)+32;
							else if(comboEntrada.getSelectedItem().equals("° Kelvil") &&
									comboSalida.getSelectedItem().equals("° Rankine"))
								tempSalida=tempEntrada*1.8;
							
							
							
							else if(comboEntrada.getSelectedItem().equals("° Rankine") &&
									comboSalida.getSelectedItem().equals("° Centigrados"))
								tempSalida=(tempEntrada-491.67)/1.8;
							else if(comboEntrada.getSelectedItem().equals("° Rankine") &&
									comboSalida.getSelectedItem().equals("° Fahrenheit"))
								tempSalida=tempEntrada-459.67;
							else if(comboEntrada.getSelectedItem().equals("° Rankine") &&
									comboSalida.getSelectedItem().equals("° Kelvil"))
								tempSalida=tempEntrada/1.8;
							
							txtFTempSalida.setText(redondear.format(tempSalida));
						}
					}
				}
			});
		add(comboSalida);
		
		
		JLabel lblIgual=new JLabel("   =   ");
			lblIgual.setFont(new Font("Arial", 3, 15));
		add(lblIgual);
		
		
		txtFTempSalida=new JTextField(10);
			txtFTempSalida.setFont(new Font("Time New Romans", 0, 15));
			txtFTempSalida.setEditable(false);
			txtFTempSalida.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		add(txtFTempSalida);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {}
	@Override
	public void keyPressed(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
}
public class Prueba {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Ventana();
			}
		});
	}
}