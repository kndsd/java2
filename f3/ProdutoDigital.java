package f3;

public class ProdutoDigital extends Produto implements Venda {

    public ProdutoDigital(int codigo, String nome, double preco) {
        super(codigo, nome, preco);
    }

    @Override
    public double calcularVenda(int quantidade) {
        return getPreco() * quantidade;
    }

    @Override
    public double calcularVenda(int quantidade, double percentualDesconto) {
        double subtotal = getPreco() * quantidade;
        double valorDesconto = subtotal * (percentualDesconto / 100.0);
        return subtotal - valorDesconto;
    }
}