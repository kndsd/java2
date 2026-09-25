package pedidos;

public class PedidoLocal extends Pedido implements Pagamento {

    public PedidoLocal(
            int numero,
            String nomeCliente,
            double valor) {

        super(numero, nomeCliente, valor);
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
}