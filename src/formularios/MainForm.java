package formularios;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import negocio.Asignacion;
import negocio.Materia;
import negocio.Universidad;

import java.awt.BorderLayout;

public class MainForm {

	private JFrame frame;

	private JFileChooser fileChooser = new JFileChooser();
	private JTable table;
	private JScrollPane tableScrollPane;
	
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
	
		CustomModel model = new CustomModel(new ArrayList<Asignacion>());
		table = new JTable(model);

		tableScrollPane = new JScrollPane(table);
		
		        tableScrollPane.setPreferredSize(new Dimension(250, 200));
		
		 
				
		JButton btnElegirArchivo = new JButton("Elegir Archivo");
		btnElegirArchivo.setBounds(38, 114, 231, 78);
		btnElegirArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        int returnVal = fileChooser.showOpenDialog(frame);

		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fileChooser.getSelectedFile();
		            
		            Universidad uni = new Universidad();
		            try {
						uni.cargarMaterias(file.getPath());
						uni.procesar();
						CustomModel model = new CustomModel(uni.getAsignaciones());
						table.setModel(model);
						//showDataInTable(uni.getAsignaciones(), table);
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
		//frame.getContentPane().add(btnElegirArchivo);	

		JPanel ctrlPane = new JPanel();
		ctrlPane.add(btnElegirArchivo);
		        
		 
		
		        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
		
		                ctrlPane, tableScrollPane);
		
		        splitPane.setDividerLocation(35);
		
		        splitPane.setEnabled(false);
		
		        frame = new JFrame("Swing JTable Demo");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		        frame.add(splitPane);

		        frame.pack();

		        frame.setLocationRelativeTo(null);

		        frame.setVisible(true);

		
	}
	
	public void showDataInTable(ArrayList<Asignacion> listOfBooks, JTable table){
	     DefaultTableModel model = new DefaultTableModel(new Object[]{"Title", "Author"}, 0);
	     for(Asignacion book:listOfBooks){
	          model.addRow(new Object[]{book.getMateriaCodigo(), book.getMateriaNombre()});
	     }
	     table.setModel(model);
	}
}

class CustomModel extends AbstractTableModel {

    List<Asignacion> data;
    String[] columnNames = {"Name", "Age"};

    public CustomModel(ArrayList<Asignacion> listOfBooks) {
        data = listOfBooks;

        


    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asignacion student = data.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return student.getMateriaCodigo();
        case 1:
            return student.getMateriaNombre();
        default:
            return null;
        }
    }

}


