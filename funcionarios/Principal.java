package funcionarios;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE FUNCIONÁRIOS =====");
            System.out.println("1 - Cadastrar funcionário");
            System.out.println("2 - Mostrar dados");
            System.out.println("3 - Calcular pagamento");
            System.out.println("4 - Calcular pagamento com bônus");
            System.out.println("5 - Consultar dados");
            System.out.println("6 - Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Funcionário CLT");
                    System.out.println("2 - Funcionário Freelancer");
                    System.out.print("Escolha o tipo: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("CPF: ");
                    String cpf = sc.nextLine();

                    if (tipo == 1) {

                        System.out.print("Salário mensal: ");
                        double salario = sc.nextDouble();

                        funcionario = new FuncionarioCLT(nome, cpf, salario);

                        System.out.println("Funcionário CLT cadastrado!");

                    } else if (tipo == 2) {

                        System.out.print("Horas trabalhadas: ");
                        double horas = sc.nextDouble();

                        System.out.print("Valor por hora: ");
                        double valorHora = sc.nextDouble();

                        funcionario = new FuncionarioFreelancer(
                                nome,
                                cpf,
                                0,
                                horas,
                                valorHora
                        );

                        System.out.println("Funcionário Freelancer cadastrado!");

                    } else {
                        System.out.println("Tipo inválido!");
                    }

                    break;

                case 2:

                    if (funcionario != null) {
                        funcionario.mostrarDados();
                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }

                    break;

                case 3:

                    if (funcionario != null) {

                        Pagamento pagamento = (Pagamento) funcionario;

                        System.out.println(
                                "Pagamento: R$ " +
                                pagamento.calcularPagamento()
                        );

                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }

                    break;

                case 4:

                    if (funcionario != null) {

                        System.out.print("Informe o bônus: ");
                        double bonus = sc.nextDouble();

                        Pagamento pagamento = (Pagamento) funcionario;

                        System.out.println(
                                "Pagamento com bônus: R$ " +
                                pagamento.calcularPagamento(bonus)
                        );

                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
                    }

                    break;

                case 5:

                    if (funcionario != null) {

                        System.out.println("\n--- CONSULTA ---");
                        System.out.println("Nome: " + funcionario.getNome());
                        System.out.println("CPF: " + funcionario.getCpf());

                    } else {
                        System.out.println("Nenhum funcionário cadastrado.");
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