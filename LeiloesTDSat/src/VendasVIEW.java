import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VendasVIEW extends JFrame {
    
    private JTable tabelaVendas;  // Para exibir os produtos vendidos
    private ProdutosDAO produtosDAO;  // Acesso aos dados

    public VendasVIEW() {
    // Inicializando a interface gráfica
    setTitle("Vendas - Produtos Vendidos");
    setSize(500, 400);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Fecha a janela, mas mantém a aplicação em execução
    setLocationRelativeTo(null);

    produtosDAO = new ProdutosDAO();  // Inicializa o DAO para acessar os produtos

    // Criando um layout de tabela para exibir os produtos
    tabelaVendas = new JTable();
    JScrollPane scrollPane = new JScrollPane(tabelaVendas);
    add(scrollPane, BorderLayout.CENTER);  // Adiciona a tabela ao centro da janela

    // Carrega os produtos vendidos na tabela
    carregarProdutosVendidos();
}

private void carregarProdutosVendidos() {
    ArrayList<ProdutosDTO> produtosVendidos = produtosDAO.listarProdutosVendidos();  // Chama o método DAO para listar os vendidos

    // Definir o modelo da tabela
    String[] colunas = {"ID", "Nome", "Valor", "Status"};
    Object[][] dados = new Object[produtosVendidos.size()][4];

    for (int i = 0; i < produtosVendidos.size(); i++) {
        ProdutosDTO produto = produtosVendidos.get(i);
        dados[i][0] = produto.getId();
        dados[i][1] = produto.getNome();
        dados[i][2] = produto.getValor();
        dados[i][3] = produto.getStatus();
    }

    // Define os dados na tabela
    tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
}
