package f3;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto produto = null;
        Venda venda = null;
        int quantidade = 0;
        double valorFinal = 0.0;

        while (true) {
            System.out.println("\n--- SISTEMA DE PRODUTOS E VENDAS ---");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Mostrar Dados do Produto");
            System.out.println("3 - Informar Quantidade");
            System.out.println("4 - Realizar Venda");
            System.out.println("5 - Realizar Venda com Desconto");
            System.out.println("6 - Mostrar Valor Final");
            System.out.println("7 - Encerrar Programa");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Selecione o tipo (1 - Produto Físico | 2 - Produto Digital): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Preço Unitário: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    if (tipo == 1) {
                        System.out.print("Valor do Frete: ");
                        double frete = scanner.nextDouble();
                        scanner.nextLine();

                        ProdutoFisico pf = new ProdutoFisico(codigo, nome, preco, frete);
                        produto = pf;
                        venda = pf;
                        System.out.println("Produto Físico cadastrado!");
                    } else if (tipo == 2) {
                        ProdutoDigital pd = new ProdutoDigital(codigo, nome, preco);
                        produto = pd;
                        venda = pd;
                        System.out.println("Produto Digital cadastrado!");
                    } else {
                        System.out.println("Tipo inválido!");
                    }
                    break;

                case 2:
                    if (produto != null) {
                        produto.exibirDados();
                    } else {
                        System.out.println("Nenhum produto cadastrado.");
                    }
                    break;

                case 3:
                    System.out.print("Informe a quantidade desejada: ");
                    quantidade = scanner.nextInt();
                    System.out.println("Quantidade de " + quantidade + " unidade(s) salva.");
                    break;

                case 4:
                    if (venda != null && quantidade > 0) {
                        valorFinal = venda.calcularVenda(quantidade);
                        System.out.println("Venda calculada com sucesso!");
                    } else if (venda == null) {
                        System.out.println("Cadastre um produto primeiro.");
                    } else {
                        System.out.println("Informe a quantidade (Opção 3) antes de realizar a venda.");
                    }
                    break;

                case 5:
                    if (venda != null && quantidade > 0) {
                        System.out.print("Informe a porcentagem de desconto (%): ");
                        double pct = scanner.nextDouble();
                        valorFinal = venda.calcularVenda(quantidade, pct);
                        System.out.println("Venda com desconto calculada com sucesso!");
                    } else if (venda == null) {
                        System.out.println("Cadastre um produto primeiro.");
                    } else {
                        System.out.println("Informe a quantidade (Opção 3) antes de realizar a venda.");
                    }
                    break;

                case 6:
                    if (valorFinal > 0.0) {
                        System.out.println("Valor Final da Operação: R$ " + valorFinal);
                    } else {
                        System.out.println("Nenhuma venda realizada ou valor zerado.");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}