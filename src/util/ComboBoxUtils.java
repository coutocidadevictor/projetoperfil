/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import models.Cliente;
import models.Colaborador;
import models.Servico;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

public class ComboBoxUtils {

    public static DefaultComboBoxModel<Servico> criarComboBoxServicos(List<Servico> servicos) {
        DefaultComboBoxModel<Servico> model = new DefaultComboBoxModel<>();
        for (Servico servico : servicos) {
            model.addElement(servico);
        }
        return model;
    }

    public static DefaultComboBoxModel<Cliente> criarComboBoxClientes(List<Cliente> clientes) {
        DefaultComboBoxModel<Cliente> model = new DefaultComboBoxModel<>();
        for (Cliente cliente : clientes) {
            model.addElement(cliente);
        }
        return model;
    }

    public static DefaultComboBoxModel<Colaborador> criarComboBoxColaboradores(List<Colaborador> colaboradores) {
        DefaultComboBoxModel<Colaborador> model = new DefaultComboBoxModel<>();
        for (Colaborador colaborador : colaboradores) {
            model.addElement(colaborador);
        }
        return model;
    }
}