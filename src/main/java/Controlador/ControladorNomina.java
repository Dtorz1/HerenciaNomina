package Controlador;

import Modelo.Nomina;
import Vista.Formulario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ControladorNomina implements ActionListener {

    Formulario objetoVista;
    Nomina objetoModelo;

    public ControladorNomina() {
        objetoModelo = new Nomina();
        objetoVista = new Formulario();
        objetoVista.setVisible(true);
        objetoVista.getBotonnomina().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == objetoVista.getBotonnomina()) {
            DecimalFormat formato = new DecimalFormat("###,###.##");
            objetoModelo.setNombre(objetoVista.getTxtnombre().getText());
            objetoModelo.setId(objetoVista.getTxtidentificacion().getText());
            objetoModelo.setSalariobasico(Long.parseLong(
                    objetoVista.getListasalarios().getSelectedItem().toString()));
            objetoModelo.setDias(Integer.parseInt(objetoVista.getTxtdias().getText()));
            objetoVista.getTxtnomina().setText("");
            objetoVista.getTxtnomina().append("Información Nomina: \n");
            objetoVista.getTxtnomina().append("=================================\n");
            objetoVista.getTxtnomina().append("Nombre Empleado:"
                    + objetoModelo.getNombre() + "\n");
            objetoVista.getTxtnomina().append("Id. Empleado:" + objetoModelo.getId() + "\n");
            objetoVista.getTxtnomina().append("Salario Básico:"
                    + formato.format(objetoModelo.getSalariobasico()) + "\n");
            objetoVista.getTxtnomina().append("Dias Trabajados:" + objetoModelo.getDias() + "\n");
            objetoVista.getTxtnomina().append("+ Auxilio de transporte:"
                    + formato.format(objetoModelo.getAuxilioTransporte()) + "\n");
            objetoVista.getTxtnomina().append("- Salud:"
                    + formato.format(objetoModelo.getSalud()) + "\n");
            objetoVista.getTxtnomina().append("- Pensión::"
                    + formato.format(objetoModelo.getPension()) + "\n");
            objetoVista.getTxtnomina().append("=================================\n");
            objetoVista.getTxtnomina().append("Neto a Pagar:"
                    + formato.format(objetoModelo.calcularsalario()) + "\n");
        }
    }
}
