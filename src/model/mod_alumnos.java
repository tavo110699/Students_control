/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import views.alumnos;

/**
 *
 * @author gustavo
 */
public class mod_alumnos {

String valor;
    String sql;

      alumnos alumno;
    public void insertar(String txtid, String txtnombre, String txtapellidoP, String txtapellidoM, String txtSemestre, String txtcarrera, String txtgrupo, String cadena) {
        try {
            Connection con = Conexion.getConnection();

            PreparedStatement pst = con.prepareStatement("INSERT INTO alumno(id,nombre,apellidoP,apellidoM,Semestre,Carrera,Grupo) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1, txtid);

            pst.setString(2, txtnombre);
            pst.setString(3, txtapellidoP);
            pst.setString(4, txtapellidoM);
            pst.setString(5, txtSemestre);
            pst.setString(6, txtcarrera);
            pst.setString(7, txtgrupo);

            pst.executeUpdate();
            valor = cadena;
            mostrardatos();
             valor = "";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    public void buscar(String txtbuscar) {
        valor = txtbuscar;
        mostrardatos();
        

    }


    public DefaultTableModel mostrardatos() {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("nombre");
        modelo.addColumn("apellido Paterno");
        modelo.addColumn("apellido Materno");
        modelo.addColumn("semestre");
        modelo.addColumn("carrera");
        modelo.addColumn("grupo");
        
 
             valor = "";
        if (valor.equals("")) {
            sql = "SELECT * FROM alumno";
        } else {
            sql = "SELECT * FROM alumno WHERE nombre='" + valor + "'";
        }

        String[] datos = new String[7];
        try {
            Connection con = Conexion.getConnection();
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                modelo.addRow(datos);
                     
            }
 
            return modelo;

        } catch (SQLException ex) {
            Logger.getLogger(alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    public void eliminar(int fila, String id) {
        // int fila = tbproductos.getSelectedRow();
        //  String id = "";
        // id = "";
//    id = tbproductos.getValueAt(fila, 0).toString();

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pst = con.prepareStatement("DELETE FROM alumno WHERE  id='" + id + "'");
            pst.executeUpdate();
            mostrardatos();
            valor = "";
        } catch (Exception e) {
        }
    }

    public void actualizar(String txtid, String txtnombre, String txtapellidoP, String txtapellidoM, String txtSemestre, String txtcarrera, String txtgrupo, String cadena) {
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement pst = con.prepareStatement("UPDATE alumno SET id='" + txtid + "', nombre='" + txtnombre + "', apellidoP='" + txtapellidoP + "', apellidoM='" + txtapellidoM + "', Semestre='" + txtSemestre + "', Carrera='" + txtcarrera + "', Grupo='" + txtgrupo + "' WHERE id='" + txtid + "'");
            pst.executeUpdate();
            valor = cadena;
            mostrardatos();
            valor= "";
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

}
