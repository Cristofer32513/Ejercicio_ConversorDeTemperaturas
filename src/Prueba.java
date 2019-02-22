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