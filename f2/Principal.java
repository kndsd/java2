package f2;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Veiculo veiculoCadastrado = null;
        Aluguel aluguel = null;
        int dias = 0;

        while (true) {
            System.out.println("\n--- SISTEMA DE LOCAÇÃO DE VEÍCULOS ---");
            System.out.println("1 - Cadastrar Veículo");
            System.out.println("2 - Mostrar Dados do Veículo");
            System.out.println("3 - Informar Quantidade de Dias");
            System.out.println("4 - Calcular Valor do Aluguel");
            System.out.println("5 - Calcular Aluguel com Desconto");
            System.out.println("6 - Encerrar Programa");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Tipo de veículo (1 - Carro | 2 - Moto): ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Placa: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Ano: ");
                    int ano = scanner.nextInt();
                    System.out.print("Valor da Diária: ");
                    double valorDiaria = scanner.nextDouble();
                    scanner.nextLine();

                    if (tipo == 1) {
                        Carro carro = new Carro(placa, modelo, ano, valorDiaria);
                        veiculoCadastrado = carro;
                        aluguel = carro;
                        System.out.println("Carro cadastrado com sucesso!");
                    } else if (tipo == 2) {
                        Moto moto = new Moto(placa, modelo, ano, valorDiaria);
                        veiculoCadastrado = moto;
                        aluguel = moto;
                        System.out.println("Moto cadastrada com sucesso!");
                    } else {
                        System.out.println("Tipo inválido.");
                    }
                    break;

                case 2:
                    if (veiculoCadastrado != null) {
                        veiculoCadastrado.exibirDados();
                    } else {
                        System.out.println("Nenhum veículo cadastrado.");
                    }
                    break;

                case 3:
                    System.out.print("Informe a quantidade de dias de locação: ");
                    dias = scanner.nextInt();
                    System.out.println("Quantidade de " + dias + " dia(s) registrada.");
                    break;

                case 4:
                    if (aluguel != null && dias > 0) {
                        double valorTotal = aluguel.calcularAluguel(dias);
                        System.out.println("Valor total do aluguel: R$ " + valorTotal);
                    } else if (aluguel == null) {
                        System.out.println("Cadastre um veículo primeiro.");
                    } else {
                        System.out.println("Informe os dias de locação (Opção 3) antes de calcular.");
                    }
                    break;

                case 5:
                    if (aluguel != null && dias > 0) {
                        System.out.print("Informe o valor do desconto: ");
                        double desconto = scanner.nextDouble();
                        double valorFinal = aluguel.calcularAluguel(dias, desconto);
                        System.out.println("Valor final com desconto: R$ " + valorFinal);
                    } else if (aluguel == null) {
                        System.out.println("Cadastre um veículo primeiro.");
                    } else {
                        System.out.println("Informe os dias de locação (Opção 3) antes de calcular.");
                    }
                    break;

                case 6:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}