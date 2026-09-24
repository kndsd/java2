package f3;
public class ProdutoFisico extends Produto implements Venda {
    private double frete;

    public ProdutoFisico(int codigo, String nome, double preco, double frete) {
        super(codigo, nome, preco);
        this.frete = frete;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    @Override
    public double calcularVenda(int quantidade) {
        return (getPreco() * quantidade) + this.frete;
    }

    @Override
    public double calcularVenda(int quantidade, double percentualDesconto) {
        double subtotal = getPreco() * quantidade;
        double valorDesconto = subtotal * (percentualDesconto / 100.0);
        return (subtotal - valorDesconto) + this.frete;
    }

    @Override
    public void exibirDados() {
        super.exibirDados();
        System.out.println("Frete: R$ " + this.frete);
    }
}