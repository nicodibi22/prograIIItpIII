package formularios;

import java.awt.EventQueue;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import negocio.Universidad;

public class MainForm {

	private JFrame frame;

	private JFileChooser fileChooser = new JFileChooser();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnElegirArchivo = new JButton("Elegir Archivo");
		btnElegirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        int returnVal = fileChooser.showOpenDialog(frame);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
		            
		            Universidad uni = new Universidad();
		            try {
						uni.agregarMaterias(file.getPath());
						uni.procesar();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		            //This is where a real application would open the file.
		            //log.append("Opening: " + file.getName() + "." + newline);
		        } else {
		            //log.append("Open command cancelled by user." + newline);
		        }
		   
			
			}
		});
		btnElegirArchivo.setBounds(266, 203, 118, 23);
		frame.getContentPane().add(btnElegirArchivo);
	}
}
