/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package util;

import models.Cliente;
import java.util.List;
import models.Colaborador;
import models.Servico;

public class TabelaUtils {
    public static Tabela criarTabelaClientes(List<Cliente> clientes) {
        java.util.ArrayList dados = new java.util.ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome", "Telefone"};
        
        for (Cliente cliente : clientes) {
            dados.add(new Object[]{
                String.valueOf(cliente.getIdCliente()),
                cliente.getNome(),
                cliente.getTelefone()
            });
        }
        
        return new Tabela(dados, colunas);
    }
    
    public static Tabela criarTabelaColaboradores(List<Colaborador> colaboradores) {
        java.util.ArrayList dados = new java.util.ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome", "Telefone"};
        
        for (Colaborador colaborador : colaboradores) {
            dados.add(new Object[]{
                String.valueOf(colaborador.getIdColaboradores()),
                colaborador.getNome(),
                colaborador.getTelefone()
            });
        }
        
        return new Tabela(dados, colunas);
    }

    public static Tabela criarTabelaServicos(List<Servico> servicos) {
        java.util.ArrayList dados = new java.util.ArrayList<>();
        String[] colunas = new String[]{"Id", "Nome", "Valor"};
        
        for (Servico servico : servicos) {
            dados.add(new Object[]{
                String.valueOf(servico.getIdServico()),
                servico.getNome(),
                servico.getValor()
            });
        }
        
        return new Tabela(dados, colunas);
    }
}