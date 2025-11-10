package util;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class Tabela extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;

    public Tabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] nomes) {
        colunas = nomes;
    }

    public int getColumnCount() {
        return colunas.length;
    }

    public int getRowCount() {
        return linhas.size();
    }

    public String getColumnName(int numCol) {
        return colunas[numCol];
    }

    public Object getValueAt(int lins, int cols) {
        Object[] linha = (Object[]) getLinhas().get(lins);
        return linha[cols];

    }
}
