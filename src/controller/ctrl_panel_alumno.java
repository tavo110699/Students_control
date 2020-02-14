/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.alumnos;
import model.mod_alumnos;
import views.home;

/**
 *
 * @author gustavo
 */
public class ctrl_panel_alumno {

    alumnos alumno;
    mod_alumnos mod;

    public ctrl_panel_alumno() {
        alumno = new alumnos();
        mod = new mod_alumnos();

        actions();
        alumno.setVisible(true);
        consultardatos();

    }

    public void consultardatos() {
        try {
            alumno.tbproductos.setModel(mod.mostrardatos());
        } catch (Exception e) {
        }
    }

    public void actions() {
        alumno.btngrabar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.insertar(alumno.txtid.getText(), alumno.txtnombre.getText(), alumno.txtapellidoP.getText(), alumno.txtapellidoM.getText(), alumno.txtSemestre.getText(), alumno.txtcarrera.getText(), alumno.txtgrupo.getText(), "");
    alumno.tbproductos.setModel(mod.mostrardatos());
            }
        });

        alumno.jButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.actualizar(alumno.txtid.getText(), alumno.txtnombre.getText(), alumno.txtapellidoP.getText(), alumno.txtapellidoM.getText(), alumno.txtSemestre.getText(), alumno.txtcarrera.getText(), alumno.txtgrupo.getText(), "");
                    alumno.tbproductos.setModel(mod.mostrardatos());
            }
        });

        alumno.jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.buscar(alumno.txtbuscar.getText());
    alumno.tbproductos.setModel(mod.mostrardatos());
            }
        });

        alumno.jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mod.buscar("");
    alumno.tbproductos.setModel(mod.mostrardatos());
            }
        });

        alumno.btnhome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                home ho = new home();
                ho.setVisible(true);
                ho.dispose();
            }
        });
        alumno.jMenuItem1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = alumno.tbproductos.getSelectedRow();
                if (fila >= 0) {
                    alumno.txtid.setText(alumno.tbproductos.getValueAt(fila, 0).toString());
                    alumno.txtnombre.setText(alumno.tbproductos.getValueAt(fila, 1).toString());
                    alumno.txtapellidoP.setText(alumno.tbproductos.getValueAt(fila, 2).toString());
                    alumno.txtapellidoM.setText(alumno.tbproductos.getValueAt(fila, 3).toString());
                    alumno.txtSemestre.setText(alumno.tbproductos.getValueAt(fila, 4).toString());
                    alumno.txtcarrera.setText(alumno.tbproductos.getValueAt(fila, 5).toString());
                    alumno.txtgrupo.setText(alumno.tbproductos.getValueAt(fila, 6).toString());

                } else {
                    JOptionPane.showMessageDialog(null, "no seleciono fila");
                }
            }
        });

        alumno.jMenuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int fila = alumno.tbproductos.getSelectedRow();

                String id = alumno.tbproductos.getValueAt(fila, 0).toString();
                mod.eliminar(fila, id);
   alumno.tbproductos.setModel(mod.mostrardatos());
            }
        });

    }

}
