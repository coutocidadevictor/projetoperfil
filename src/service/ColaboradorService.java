/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.ColaboradorDAO;
import models.Colaborador;
import java.sql.SQLException;
import java.util.List;

public class ColaboradorService {
    private ColaboradorDAO colaboradorDAO;
    
    public ColaboradorService() {
        this.colaboradorDAO = new ColaboradorDAO();
    }
    
    public void salvarColaborador(Colaborador colaborador) throws SQLException {
        validarColaborador(colaborador);
        
        if (colaborador.getIdColaboradores() == 0) {
            colaboradorDAO.inserir(colaborador);
        } else {
            colaboradorDAO.atualizar(colaborador);
        }
    }
    
    public void excluirColaborador(int idColaborador) throws SQLException {
        colaboradorDAO.excluir(idColaborador);
    }
    
    public List<Colaborador> listarTodosColaboradores() throws SQLException {
        return colaboradorDAO.listarTodos();
    }
    
    public Colaborador buscarColaboradorPorId(int idColaborador) throws SQLException {
        return colaboradorDAO.buscarPorId(idColaborador);
    }
    
    private void validarColaborador(Colaborador colaborador) {
        if (colaborador.getNome() == null || colaborador.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do colaborador é obrigatório");
        }
    }
}
