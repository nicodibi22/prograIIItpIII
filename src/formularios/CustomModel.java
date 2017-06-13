package formularios;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import negocio.Asignacion;

class CustomModel extends AbstractTableModel {


	private static final long serialVersionUID = 1L;
	List<Asignacion> data;
    String[] columnNames = {"Aula", "Código Materia", "Nombre Materia", "Hora Inicio", "Hora Fin"};

    public CustomModel(ArrayList<Asignacion> asignaciones) {
        data = asignaciones;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Asignacion asignacion = data.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return asignacion.getAula();
        case 1:
            return asignacion.getMateriaCodigo();
        case 2:
            return asignacion.getMateriaNombre();
        case 3:
            return asignacion.getMateriaHoraInicio();
        case 4:
            return asignacion.getMateriaHoraFin();
        default:
            return null;
        }
    }

}

