package produto;

public class ProdutoDigital extends Produto implements Venda {

    public ProdutoDigital(
            int codigo,
            String nome,
            double preco) {

        super(codigo, nome, preco);
    }

    @Override
    public double realizarVenda(int quantidade) {
        return getPreco() * quantidade;
    }

    @Override
    public double realizarVenda(int quantidade, double desconto) {

        double total = realizarVenda(quantidade);

        return total - (total * desconto / 100);
    }
}