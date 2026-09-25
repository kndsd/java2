package produto;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Produto produto = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE PRODUTOS =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Mostrar dados");
            System.out.println("3 - Informar quantidade");
            System.out.println("4 - Realizar venda");
            System.out.println("5 - Realizar venda com desconto");
            System.out.println("6 - Mostrar valor final");
            System.out.println("7 - Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Produto físico");
                    System.out.println("2 - Produto digital");
                    System.out.print("Escolha: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    if (tipo == 1) {

                        System.out.print("Valor do frete: ");
                        double frete = sc.nextDouble();

                        produto = new ProdutoFisico(
                                codigo,
                                nome,
                                preco,
                                frete
                        );

                        System.out.println("Produto físico cadastrado!");

                    } else if (tipo == 2) {

                        produto = new ProdutoDigital(
                                codigo,
                                nome,
                                preco
                        );

                        System.out.println("Produto digital cadastrado!");

                    } else {
                        System.out.println("Tipo inválido!");
                    }

                    break;

                case 2:

                    if (produto != null) {
                        produto.mostrarDados();
                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }

                    break;

                case 3:

                    if (produto != null) {

                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        Venda venda = (Venda) produto;

                        System.out.println(
                                "Valor: R$ " +
                                venda.realizarVenda(quantidade)
                        );

                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }

                    break;

                case 4:

                    if (produto != null) {

                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        Venda venda = (Venda) produto;

                        System.out.println(
                                "Valor da venda: R$ " +
                                venda.realizarVenda(quantidade)
                        );

                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }

                    break;

                case 5:

                    if (produto != null) {

                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        System.out.print("Desconto (%): ");
                        double desconto = sc.nextDouble();

                        Venda venda = (Venda) produto;

                        System.out.println(
                                "Valor com desconto: R$ " +
                                venda.realizarVenda(
                                        quantidade,
                                        desconto
                                )
                        );

                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }

                    break;

                case 6:

                    if (produto != null) {

                        System.out.print("Quantidade: ");
                        int quantidade = sc.nextInt();

                        Venda venda = (Venda) produto;

                        System.out.println(
                                "Valor final: R$ " +
                                venda.realizarVenda(quantidade)
                        );

                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }

                    break;

                case 7:

                    System.out.println("Programa encerrado.");
                    sc.close();
                    return;

                default:

                    System.out.println("Opção inválida!");
            }
        }
    }
}
