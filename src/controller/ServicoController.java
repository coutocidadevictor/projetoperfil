/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import service.ServicoService;
import models.Servico;
import java.sql.SQLException;
import java.util.List;

public class ServicoController {
    private ServicoService servicoService;
    
    public ServicoController() {
        this.servicoService = new ServicoService();
    }
    
    public boolean salvar(String nome, String valor, String id) throws SQLException {
        try {
            Servico servico = new Servico();
            servico.setNome(nome);
            servico.setValor(valor);
            
            if (id != null && !id.isEmpty()) {
                servico.setIdServico(Integer.parseInt(id));
            }
            
            servicoService.salvarServico(servico);
            return true;
            
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    public boolean excluir(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do serviço é obrigatório para exclusão");
        }
        
        servicoService.excluirServico(Integer.parseInt(id));
        return true;
    }
    
    public List<Servico> listarTodos() throws SQLException {
        return servicoService.listarTodosServicos();
    }
    
    public Servico buscarPorId(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return servicoService.buscarServicoPorId(Integer.parseInt(id));
    }
}
