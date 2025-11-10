/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import dao.ServicoDAO;
import models.Servico;
import java.sql.SQLException;
import java.util.List;

public class ServicoService {
    private ServicoDAO servicoDAO;
    
    public ServicoService() {
        this.servicoDAO = new ServicoDAO();
    }
    
    public void salvarServico(Servico servico) throws SQLException {
        validarServico(servico);
        
        if (servico.getIdServico() == 0) {
            servicoDAO.inserir(servico);
        } else {
            servicoDAO.atualizar(servico);
        }
    }
    
    public void excluirServico(int idServico) throws SQLException {
        servicoDAO.excluir(idServico);
    }
    
    public List<Servico> listarTodosServicos() throws SQLException {
        return servicoDAO.listarTodos();
    }
    
    public Servico buscarServicoPorId(int idServico) throws SQLException {
        return servicoDAO.buscarPorId(idServico);
    }
    
    private void validarServico(Servico servico) {
        if (servico.getNome() == null || servico.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do serviço é obrigatório");
        }
        if (servico.getValor() == null || servico.getValor().trim().isEmpty()) {
            throw new IllegalArgumentException("Valor do serviço é obrigatório");
        }
    }
}
