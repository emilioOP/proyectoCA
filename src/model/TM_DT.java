/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Emilio
 */
public class TM_DT implements TableModel{
    private List<DT> dts;

    public TM_DT(List<DT> dts) {
        this.dts = dts;
    }

    @Override
    public int getRowCount() {
        return dts.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String nombre=null;
        switch(columnIndex){
            case 0:
                nombre="ID";
                break;
            case 1:
                nombre="Nombre";
                break;
            case 2:
                nombre="Apellido";
                break;
            case 3:
                nombre="Edad";
                break;
            case 4:
                nombre="Nacionalidad";
                break;
            case 5:
                nombre="Club Deportivo";
                break;
            case 6:
                nombre="Años como DT";
                break;
            case 7:
                nombre="Sueldo Fifa";
                break;
        }
        
        return nombre;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object o=null;
        DT dt=dts.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                o=dt.getId();
                break;
            case 1:
                o=dt.getNombre();
                break;
            case 2:
                o=dt.getApellido();
                break;
            case 3:
                o=dt.getEdad();
                break;
            case 4:
                o=dt.getNacionalidad();
                break;
            case 5:
                o=dt.getClubDeportivo();
                break;
            case 6:
                o=dt.getAniosDT();
                break;
            case 7:
                o=dt.getSueldoFifa();
                break;      
        }
        return o;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    
}