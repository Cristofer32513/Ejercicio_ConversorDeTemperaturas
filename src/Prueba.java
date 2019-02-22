import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class Ventana extends JFrame {
	
	JTextField txtFTempEntrada, txtFTempSalida;
	JComboBox<String> comboEntrada, comboSalida;
	
	public Ventana() {
		getContentPane().setLayout(new FlowLayout());
		setTitle("Conversor Temperaturas");
		setSize(290, 170);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		
		JLabel lblConvertir=new JLabel("Convertir");
			lblConvertir.setFont(new Font("Arial", 3, 15));
		add(lblConvertir);
		
		txtFTempEntrada=new JTextField(5);
			txtFTempEntrada.setFont(new Font("Time New Romans", 0, 15));
		add(txtFTempEntrada);
		
		comboEntrada=new JComboBox<String>();
			comboEntrada.addItem("-------------------");
			comboEntrada.addItem("° Centigrados");
			comboEntrada.addItem("° Fahrenheit");
			comboEntrada.addItem("° Kelvil");
			comboEntrada.addItem("° Rankine");
			comboEntrada.setFont(new Font("Time New Romans", 0, 15));
		add(comboEntrada);
		
		JLabel lblA=new JLabel("A    ");
			lblA.setFont(new Font("Arial", 3, 15));
		add(lblA);
		
		comboSalida=new JComboBox<String>();
			comboSalida.addItem("-------------------");
			comboSalida.setFont(new Font("Time New Romans", 0, 15));
			comboSalida.setEnabled(false);
		add(comboSalida);
		
		JLabel lblIgual=new JLabel("   =   ");
			lblIgual.setFont(new Font("Arial", 3, 15));
		add(lblIgual);
		
		txtFTempSalida=new JTextField(5);
			txtFTempSalida.setFont(new Font("Time New Romans", 0, 15));
			txtFTempSalida.setEditable(false);
		add(txtFTempSalida);
	}
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