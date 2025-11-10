/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.sql.SQLException;
import java.util.List;
import models.Colaborador;
import service.ColaboradorService;

public class ColaboradorController {
    private ColaboradorService colaboradorService;
    
    public ColaboradorController() {
        this.colaboradorService = new ColaboradorService();
    }
    
    public boolean salvar(String nome, String telefone, String id) throws SQLException {
        try {
            Colaborador colaborador = new Colaborador();
            colaborador.setNome(nome);
            colaborador.setTelefone(telefone);
            
            if (id != null && !id.isEmpty()) {
                colaborador.setIdColaboradores(Integer.parseInt(id));
            }
            
            colaboradorService.salvarColaborador(colaborador);
            return true;
            
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    public boolean excluir(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID do colaborador é obrigatório para exclusão");
        }
        
        colaboradorService.excluirColaborador(Integer.parseInt(id));
        return true;
    }
    
    public List<Colaborador> listarTodos() throws SQLException {
        return colaboradorService.listarTodosColaboradores();
    }
    
    public Colaborador buscarPorId(String id) throws SQLException {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return colaboradorService.buscarColaboradorPorId(Integer.parseInt(id));
    }
}
