package pedidos;

public class PedidoDelivery extends Pedido implements Pagamento {

    private String endereco;
    private double taxaEntrega;

    public PedidoDelivery(
            int numero,
            String nomeCliente,
            double valor,
            String endereco,
            double taxaEntrega) {

        super(numero, nomeCliente, valor);

        this.endereco = endereco;
        this.taxaEntrega = taxaEntrega;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getTaxaEntrega() {
        return taxaEntrega;
    }

    public void setTaxaEntrega(double taxaEntrega) {
        this.taxaEntrega = taxaEntrega;
    }

    @Override
    public double getValor() {
        return super.getValor() + taxaEntrega;
    }

    @Override
    public void pagar(double valor) {

        System.out.println(
                "Pagamento em dinheiro realizado."
        );

        System.out.println(
                "Valor pago: R$ " + valor
        );
    }

    @Override
    public void pagar(double valor, String chavePix) {

        System.out.println(
                "Pagamento via PIX realizado."
        );

        System.out.println(
                "Chave PIX: " + chavePix
        );

        System.out.println(
                "Valor pago: R$ " + valor
        );
    }

    @Override
    public void pagar(double valor, int parcelas) {

        System.out.println(
                "Pagamento com cartão realizado."
        );

        System.out.println(
                "Parcelas: " + parcelas
        );

        System.out.println(
                "Valor pago: R$ " + valor
        );
    }

    @Override
    public void mostrarDados() {

        super.mostrarDados();

        System.out.println(
                "Endereço: " + endereco
        );

        System.out.println(
                "Taxa de entrega: R$ " + taxaEntrega
        );

        System.out.println(
                "Valor total: R$ " + getValor()
        );
    }
}