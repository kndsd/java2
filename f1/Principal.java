package f1;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Funcionario funcionarioLogado = null;
        Pagamento pagamento = null;

        while (true) {
            System.out.println("1 - Cadastrar CLT");
            System.out.println("2 - Cadastrar Freelancer");
            System.out.println("3 - Calcular Pagamento Base");
            System.out.println("4 - Calcular Pagamento com Bônus");
            System.out.println("5 - Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nomeClt = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfClt = scanner.nextLine();
                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    
                    FuncionarioCLT clt = new FuncionarioCLT(nomeClt, cpfClt, salario);
                    funcionarioLogado = clt;
                    pagamento = clt;
                    break;
                case 2:
                    System.out.print("Nome: ");
                    String nomeFree = scanner.nextLine();
                    System.out.print("CPF: ");
                    String cpfFree = scanner.nextLine();
                    System.out.print("Valor Hora: ");
                    double vh = scanner.nextDouble();
                    System.out.print("Horas: ");
                    int ht = scanner.nextInt();
                    
                    FuncionarioFreelancer free = new FuncionarioFreelancer(nomeFree, cpfFree, vh, ht);
                    funcionarioLogado = free;
                    pagamento = free;
                    break;
                case 3:
                    if (pagamento != null) {
                        System.out.println("Total: " + pagamento.calcularPagamento());
                    }
                    break;
                case 4:
                    if (pagamento != null) {
                        System.out.print("Bônus: ");
                        double b = scanner.nextDouble();
                        System.out.println("Total: " + pagamento.calcularPagamento(b));
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
    }
}