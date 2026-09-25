package cursos;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Curso curso = null;
        String aluno = null;

        while (true) {

            System.out.println("\n===== SISTEMA DE CURSOS =====");
            System.out.println("1 - Cadastrar curso");
            System.out.println("2 - Cadastrar aluno");
            System.out.println("3 - Realizar matrícula");
            System.out.println("4 - Matrícula com desconto");
            System.out.println("5 - Mostrar dados do curso");
            System.out.println("6 - Mostrar dados da matrícula");
            System.out.println("7 - Encerrar");
            System.out.print("Escolha: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Curso presencial");
                    System.out.println("2 - Curso online");
                    System.out.print("Escolha: ");

                    int tipo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Código: ");
                    int codigo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Carga horária: ");
                    int carga = sc.nextInt();

                    System.out.print("Valor: ");
                    double valor = sc.nextDouble();
                    sc.nextLine();

                    if (tipo == 1) {

                        System.out.print("Nome da sala: ");
                        String sala = sc.nextLine();

                        System.out.print("Turno: ");
                        String turno = sc.nextLine();

                        curso = new CursoPresencial(
                                codigo,
                                nome,
                                carga,
                                valor,
                                sala,
                                turno
                        );

                        System.out.println("Curso presencial cadastrado!");

                    } else if (tipo == 2) {

                        System.out.print("Plataforma: ");
                        String plataforma = sc.nextLine();

                        System.out.print("Código de acesso: ");
                        String acesso = sc.nextLine();

                        curso = new CursoOnline(
                                codigo,
                                nome,
                                carga,
                                valor,
                                plataforma,
                                acesso
                        );

                        System.out.println("Curso online cadastrado!");

                    } else {

                        System.out.println("Tipo inválido!");
                    }

                    break;

                case 2:

                    if (curso != null) {

                        System.out.print("Nome do aluno: ");
                        aluno = sc.nextLine();

                        System.out.println("Aluno cadastrado!");

                    } else {

                        System.out.println("Cadastre um curso primeiro.");
                    }

                    break;

                case 3:

                    if (curso != null && aluno != null) {

                        Matricula matricula = (Matricula) curso;

                        double valorMatricula =
                                matricula.realizarMatricula(aluno);

                        System.out.println(
                                "Matrícula realizada!"
                        );

                        System.out.println(
                                "Valor: R$ " + valorMatricula
                        );

                    } else {

                        System.out.println(
                                "Cadastre o curso e o aluno primeiro."
                        );
                    }

                    break;

                case 4:

                    if (curso != null && aluno != null) {

                        System.out.print("Desconto: R$ ");
                        double desconto = sc.nextDouble();

                        Matricula matricula = (Matricula) curso;

                        double valorFinal =
                                matricula.realizarMatricula(
                                        aluno,
                                        desconto
                                );

                        System.out.println(
                                "Matrícula com desconto!"
                        );

                        System.out.println(
                                "Valor final: R$ " + valorFinal
                        );

                    } else {

                        System.out.println(
                                "Cadastre o curso e o aluno primeiro."
                        );
                    }

                    break;

                case 5:

                    if (curso != null) {

                        curso.mostrarDados();

                    } else {

                        System.out.println(
                                "Nenhum curso cadastrado."
                        );
                    }

                    break;

                case 6:

                    if (curso != null && aluno != null) {

                        System.out.println(
                                "\n--- DADOS DA MATRÍCULA ---"
                        );

                        System.out.println(
                                "Aluno: " + aluno
                        );

                        System.out.println(
                                "Curso: " + curso.getNome()
                        );

                        System.out.println(
                                "Valor: R$ " + curso.getValor()
                        );

                    } else {

                        System.out.println(
                                "Nenhuma matrícula realizada."
                        );
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