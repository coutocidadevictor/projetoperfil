/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package service;

import models.Servico;
import org.junit.Test;
import static org.junit.Assert.*;

public class ServicoServiceTest {

    private ServicoService servicoService = new ServicoService();

    @Test
    public void testValidarValorServico_ValorPositivo() {
        // Teste com valor positivo válido
        assertTrue(servicoService.validarValorServico("100.50"));
    }

    @Test
    public void testValidarValorServico_ValorComVirgula() {
        // Teste com valor usando vírgula (formato brasileiro)
        assertTrue(servicoService.validarValorServico("150,75"));
    }

    @Test
    public void testValidarValorServico_ValorZero() {
        // Teste com zero - deve ser inválido
        assertFalse(servicoService.validarValorServico("0"));
    }

    @Test
    public void testValidarValorServico_ValorNegativo() {
        // Teste com valor negativo - deve ser inválido
        assertFalse(servicoService.validarValorServico("-50"));
    }

    @Test
    public void testValidarValorServico_ValorVazio() {
        // Teste com string vazia - deve ser inválido
        assertFalse(servicoService.validarValorServico(""));
    }

    @Test
    public void testValidarValorServico_ValorNulo() {
        // Teste com null - deve ser inválido
        assertFalse(servicoService.validarValorServico(null));
    }

    @Test
    public void testValidarValorServico_ValorComTexto() {
        // Teste com texto - deve ser inválido
        assertFalse(servicoService.validarValorServico("abc"));
    }

    @Test
    public void testValidarValorServico_ValorComEspacos() {
        // Teste com espaços - deve ser inválido
        assertFalse(servicoService.validarValorServico("   "));
    }
    
    @Test
    public void testValidarServico_ValorValido() {
        Servico servico = new Servico();
        servico.setNome("Corte de Cabelo");
        servico.setValor("50.00");
        
        // Não deve lançar exceção
        try {
            // Precisamos acessar via reflection ou criar método público para teste
            servicoService.salvarServico(servico);
            
            // Se chegou aqui, passou na validação
            assertTrue(true);
        } catch (Exception e) {
            fail("Não deveria lançar exceção para valor válido");
        }
    }

    @Test
    public void testValidarServico_ValorInvalidoLancaExcecao() {
        Servico servico = new Servico();
        servico.setNome("Corte de Cabelo");
        servico.setValor("abc"); // Valor inválido
        
        try {
            servicoService.salvarServico(servico);
            fail("Deveria ter lançado exceção para valor inválido");
        } catch (Exception e) {
            // Esperado que lance exceção
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Valor do serviço"));
        }
    }

    @Test
    public void testValidarServico_NomeVazioLancaExcecao() {
        Servico servico = new Servico();
        servico.setNome(""); // Nome vazio
        servico.setValor("50.00");
        
        try {
            servicoService.salvarServico(servico);
            fail("Deveria ter lançado exceção para nome vazio");
        } catch (Exception e) {
            assertTrue(e instanceof IllegalArgumentException);
            assertTrue(e.getMessage().contains("Nome do serviço"));
        }
    }
}