/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import service.AtendimentoService;
import models.Atendimento;
import models.Cliente;
import models.Colaborador;
import models.Servico;
import java.sql.SQLException;
import java.util.List;

public class AtendimentoController {
    private AtendimentoService atendimentoService;
    
    public AtendimentoController() {
        this.atendimentoService = new AtendimentoService();
    }
    
    public boolean salvar(String idServico, String idCliente, String idColaborador, String dataAtendimento, String idAtendimento) throws SQLException {
        try {
            Atendimento atendimento = new Atendimento();
            atendimento.setIdServico(Integer.parseInt(idServico));
            atendimento.setIdClientes(Integer.parseInt(idCliente));
            atendimento.setIdColaboradores(Integer.parseInt(idColaborador));
            atendimento.setDataAtendimentos(dataAtendimento);
            
            if (idAtendimento != null && !idAtendimento.isEmpty()) {
                atendimento.setIdAtendimentos(Integer.parseInt(idAtendimento));
            }
            
            atendimentoService.salvarAtendimento(atendimento);
            return true;
            
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    public boolean excluir(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do atendimento é obrigatório para exclusão");
        }
        
        atendimentoService.excluirAtendimento(Integer.parseInt(id));
        return true;
    }
    
    public List<Atendimento> listarTodos() throws SQLException {
        return atendimentoService.listarTodosAtendimentos();
    }
    
    public Atendimento buscarPorId(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return atendimentoService.buscarAtendimentoPorId(Integer.parseInt(id));
    }
    
    // Métodos para os combos
    public List<Cliente> listarClientes() throws SQLException {
        return atendimentoService.listarTodosClientes();
    }
    
    public List<Servico> listarServicos() throws SQLException {
        return atendimentoService.listarTodosServicos();
    }
    
    public List<Colaborador> listarColaboradores() throws SQLException {
        return atendimentoService.listarTodosColaboradores();
    }
}
