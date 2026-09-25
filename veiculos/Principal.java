package veiculos;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Veiculo veiculo = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE LOCAÇÃO =====");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Mostrar dados");
            System.out.println("3 - Informar quantidade de dias");
            System.out.println("4 - Calcular aluguel");
            System.out.println("5 - Calcular aluguel com desconto");
            System.out.println("6 - Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Carro");
                    System.out.println("2 - Moto");
                    System.out.print("Escolha: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Placa: ");
                    String placa = sc.nextLine();

                    System.out.print("Modelo: ");
                    String modelo = sc.nextLine();

                    System.out.print("Ano: ");
                    int ano = sc.nextInt();

                    System.out.print("Valor da diária: ");
                    double diaria = sc.nextDouble();

                    if (tipo == 1) {

                        veiculo = new Carro(
                                placa,
                                modelo,
                                ano,
                                diaria
                        );

                        System.out.println("Carro cadastrado!");

                    } else if (tipo == 2) {

                        veiculo = new Moto(
                                placa,
                                modelo,
                                ano,
                                diaria
                        );

                        System.out.println("Moto cadastrada!");

                    } else {
                        System.out.println("Tipo inválido!");
                    }

                    break;

                case 2:

                    if (veiculo != null) {
                        veiculo.mostrarDados();
                    } else {
                        System.out.println("Nenhum veículo cadastrado.");
                    }

                    break;

                case 3:

                    if (veiculo != null) {

                        System.out.print("Quantidade de dias: ");
                        int dias = sc.nextInt();

                        System.out.println(
                                "Valor: R$ " +
                                ((Aluguel) veiculo).calcularAluguel(dias)
                        );

                    } else {
                        System.out.println("Nenhum veículo cadastrado.");
                    }

                    break;

                case 4:

                    if (veiculo != null) {

                        System.out.print("Quantidade de dias: ");
                        int dias = sc.nextInt();

                        Aluguel aluguel = (Aluguel) veiculo;

                        System.out.println(
                                "Aluguel: R$ " +
                                aluguel.calcularAluguel(dias)
                        );

                    } else {
                        System.out.println("Nenhum veículo cadastrado.");
                    }

                    break;

                case 5:

                    if (veiculo != null) {

                        System.out.print("Quantidade de dias: ");
                        int dias = sc.nextInt();

                        System.out.print("Desconto: R$ ");
                        double desconto = sc.nextDouble();

                        Aluguel aluguel = (Aluguel) veiculo;

                        System.out.println(
                                "Valor final: R$ " +
                                aluguel.calcularAluguel(dias, desconto)
                        );

                    } else {
                        System.out.println("Nenhum veículo cadastrado.");
                    }

                    break;

                case 6:

                    System.out.println("Programa encerrado.");
                    sc.close();
                    return;

                default:

                    System.out.println("Opção inválida!");
            }
        }
    }
}