package pedidos;


import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Pedido pedido = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE PEDIDOS =====");
            System.out.println("1 - Cadastrar pedido");
            System.out.println("2 - Mostrar dados do pedido");
            System.out.println("3 - Escolher forma de pagamento");
            System.out.println("4 - Pagar em dinheiro");
            System.out.println("5 - Pagar via PIX");
            System.out.println("6 - Pagar com cartão");
            System.out.println("7 - Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Pedido local");
                    System.out.println("2 - Pedido delivery");
                    System.out.print("Escolha: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Número do pedido: ");
                    int numero = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome do cliente: ");
                    String cliente = sc.nextLine();

                    System.out.print("Valor do pedido: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {

                        pedido = new PedidoLocal(
                                numero,
                                cliente,
                                valor
                        );

                        System.out.println(
                                "Pedido local cadastrado!"
                        );

                    } else if (tipo == 2) {

                        System.out.print("Endereço: ");
                        String endereco = sc.nextLine();

                        System.out.print("Taxa de entrega: ");
                        double taxa = sc.nextDouble();

                        pedido = new PedidoDelivery(
                                numero,
                                cliente,
                                valor,
                                endereco,
                                taxa
                        );

                        System.out.println(
                                "Pedido delivery cadastrado!"
                        );

                    } else {

                        System.out.println(
                                "Tipo inválido!"
                        );
                    }

                    break;

                case 2:

                    if (pedido != null) {

                        pedido.mostrarDados();

                    } else {

                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 3:

                    System.out.println(
                            "\n--- FORMAS DE PAGAMENTO ---"
                    );

                    System.out.println(
                            "1 - Dinheiro"
                    );

                    System.out.println(
                            "2 - PIX"
                    );

                    System.out.println(
                            "3 - Cartão"
                    );

                    System.out.print(
                            "Escolha: "
                    );

                    int forma = sc.nextInt();

                    if (forma == 1) {

                        System.out.println(
                                "Pagamento escolhido: dinheiro."
                        );

                    } else if (forma == 2) {

                        System.out.println(
                                "Pagamento escolhido: PIX."
                        );

                    } else if (forma == 3) {

                        System.out.println(
                                "Pagamento escolhido: cartão."
                        );

                    } else {

                        System.out.println(
                                "Forma inválida."
                        );
                    }

                    break;

                case 4:

                    if (pedido != null) {

                        System.out.print(
                                "Valor pago: "
                        );

                        double valorDinheiro =
                                sc.nextDouble();

                        Pagamento pagamento =
                                (Pagamento) pedido;

                        pagamento.pagar(
                                valorDinheiro
                        );

                    } else {

                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 5:

                    if (pedido != null) {

                        System.out.print(
                                "Valor: "
                        );

                        double valorPix =
                                sc.nextDouble();

                        sc.nextLine();

                        System.out.print(
                                "Chave PIX: "
                        );

                        String chave =
                                sc.nextLine();

                        Pagamento pagamento =
                                (Pagamento) pedido;

                        pagamento.pagar(
                                valorPix,
                                chave
                        );

                    } else {

                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 6:

                    if (pedido != null) {

                        System.out.print(
                                "Valor: "
                        );

                        double valorCartao =
                                sc.nextDouble();

                        System.out.print(
                                "Quantidade de parcelas: "
                        );

                        int parcelas =
                                sc.nextInt();

                        Pagamento pagamento =
                                (Pagamento) pedido;

                        pagamento.pagar(
                                valorCartao,
                                parcelas
                        );

                    } else {

                        System.out.println(
                                "Nenhum pedido cadastrado."
                        );
                    }

                    break;

                case 7:

                    System.out.println(
                            "Programa encerrado."
                    );

                    sc.close();
                    return;

                default:

                    System.out.println(
                            "Opção inválida!"
                    );
            }
        }
    }
}