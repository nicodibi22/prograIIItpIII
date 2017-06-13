package formularios;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import negocio.Asignacion;
import negocio.LectorArchivo;
import negocio.SolverGoloso;
import negocio.Universidad;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;


public class MainForm {

	private JFrame frame;
	private JPanel ctrlPane;
	private JFileChooser fileChooser;
	private JTable table;
	private JScrollPane tableScrollPane;
	private JLabel lblNombreArchivo;
	private JLabel lblCantidadAulas;
	
	private String pathArchivo;
	
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
	
		CustomModel model = new CustomModel(new ArrayList<Asignacion>());
		table = new JTable(model);		
		tableScrollPane = new JScrollPane(table);		
		tableScrollPane.setPreferredSize(new Dimension(700, 200));
		lblNombreArchivo = new JLabel("");				
		lblNombreArchivo.setBounds(10, 9, 327, 19);
		JLabel lblTotalAulasNecesarias = new JLabel("Total Aulas Necesarias:");
        lblTotalAulasNecesarias.setHorizontalAlignment(SwingConstants.LEFT);               
        lblCantidadAulas = new JLabel("");
        lblCantidadAulas.setHorizontalAlignment(SwingConstants.LEFT);		
		ctrlPane = new JPanel();
		ctrlPane.setLayout(null);				
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                ctrlPane, tableScrollPane);                           
        ctrlPane.add(lblNombreArchivo);
        splitPane.setDividerLocation(35);
        splitPane.setEnabled(false);
        frame = new JFrame("Al SUM de la biblioteca");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(splitPane);        
        JPanel panel = new JPanel();        
        frame.getContentPane().add(panel, BorderLayout.SOUTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panel.add(lblTotalAulasNecesarias);        
        panel.add(lblCantidadAulas);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);        
        modificarTamanioColumnas();
             
        cargarBotones();
	}
	
	private void cargarBotones() {
		JButton btnElegirArchivo = new JButton("Elegir Archivo");
		btnElegirArchivo.setBounds(347, 5, 135, 23);
		btnElegirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				fileChooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON FILES", "json", "json");
				fileChooser.setFileFilter(filter);
		        int returnVal = fileChooser.showOpenDialog(frame);
		        
		        
		        
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();		       		           
		            pathArchivo = file.getPath();
		            lblNombreArchivo.setText(pathArchivo);
		            
		        } else {
		        	pathArchivo = null;
		        }
			}
		});
		ctrlPane.add(btnElegirArchivo);
		
		JButton btnProcesar = new JButton("Procesar");        
        btnProcesar.setBounds(492, 5, 89, 23);
        ctrlPane.add(btnProcesar);      
        btnProcesar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		CustomModel model;
        		Universidad uni = new Universidad();
        		try {	            
	            	if(hayArchivoSeleccionado()) {
	            		uni.cargarMaterias(LectorArchivo.getContenido(pathArchivo));
						SolverGoloso solucion =  new SolverGoloso(uni);
						model = new CustomModel(solucion.resolver());
						lblCantidadAulas.setText(String.valueOf(uni.cantidadAulas()));
						table.setModel(model);
						modificarTamanioColumnas();
	            	} else {
	            		JOptionPane.showMessageDialog(frame, "Elija un archivo a procesar.", "",
	            			    JOptionPane.INFORMATION_MESSAGE);
	            	}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Error al procesar el archivo. Verifique su contenido.",
							"Error Archivo", JOptionPane.ERROR_MESSAGE);
				}	
        	}			
        });
	}
	
	private void modificarTamanioColumnas() {
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
	}
	
	private boolean hayArchivoSeleccionado() {
		return pathArchivo != null;
	}
}