import java.util.ArrayList;
import java.util.Scanner;

public class SweetFlight {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Utilização de ArrayList para permitir cadastro e exclusão dinâmica
        ArrayList<Integer> numerosAvioes = new ArrayList<>();
        ArrayList<Integer> assentosDisponiveis = new ArrayList<>();
        ArrayList<String> nomesPassageiros = new ArrayList<>();
        ArrayList<Integer> avioesReservas = new ArrayList<>();

        int opcao = 0;

        while (opcao != 10) {
            System.out.println("\n=========================================");
            System.out.println("      SWEET FLIGHT – SISTEMA DE RESERVAS");
            System.out.println("=========================================");
            System.out.println("1  - Cadastrar 1 avião");
            System.out.println("2  - Cadastrar/Alterar assentos de um avião");
            System.out.println("3  - Listar aviões");
            System.out.println("4  - Realizar reserva");
            System.out.println("5  - Consultar reservas de um avião");
            System.out.println("6  - Pesquisar passageiro");
            System.out.println("7  - Excluir um avião");
            System.out.println("8  - Excluir uma reserva");
            System.out.println("9  - Mostrar resumo");
            System.out.println("10 - Sair");
            System.out.print("\nEscolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1:
                    // CADASTRAR 1 AVIÃO
                    if (numerosAvioes.size() >= 4) {
                        System.out.println("Limite máximo de 4 aviões já atingido!");
                        break;
                    }

                    System.out.print("Informe o número do avião a ser cadastrado: ");
                    int numAviao = 0;
                    if (scanner.hasNextInt()) {
                        numAviao = scanner.nextInt();
                        scanner.nextLine();

                        if (numerosAvioes.contains(numAviao)) {
                            System.out.println("Este avião já está cadastrado!");
                        } else {
                            numerosAvioes.add(numAviao);
                            assentosDisponiveis.add(0); // Inicia com 0 assentos até que a opção 2 seja usada
                            System.out.println("Avião cadastrado com sucesso!");
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Número inválido!");
                    }
                    break;

                case 2:
                    // CADASTRAR/ALTERAR ASSENTOS DE UM AVIÃO
                    if (numerosAvioes.isEmpty()) {
                        System.out.println("Nenhum avião cadastrado.");
                        break;
                    }

                    System.out.print("Informe o número do avião: ");
                    int aviaoAssento = 0;
                    if (scanner.hasNextInt()) {
                        aviaoAssento = scanner.nextInt();
                        scanner.nextLine();

                        int index = numerosAvioes.indexOf(aviaoAssento);
                        if (index == -1) {
                            System.out.println("Este avião não existe!");
                        } else {
                            System.out.print("Informe a quantidade de assentos disponíveis (0 a 20): ");
                            int qtdAssentos = -1;
                            if (scanner.hasNextInt()) {
                                qtdAssentos = scanner.nextInt();
                                scanner.nextLine();
                            } else {
                                scanner.nextLine();
                            }

                            while (qtdAssentos < 0 || qtdAssentos > 20) {
                                System.out.print("Quantidade inválida! Digite um valor entre 0 e 20: ");
                                if (scanner.hasNextInt()) {
                                    qtdAssentos = scanner.nextInt();
                                    scanner.nextLine();
                                } else {
                                    scanner.nextLine();
                                }
                            }

                            assentosDisponiveis.set(index, qtdAssentos);
                            System.out.println("Assentos cadastrados com sucesso!");
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Número inválido!");
                    }
                    break;

                case 3:
                    // LISTAR AVIÕES
                    if (numerosAvioes.isEmpty()) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        for (int i = 0; i < numerosAvioes.size(); i++) {
                            System.out.println("Avião: " + numerosAvioes.get(i) + " | Assentos disponíveis: " + assentosDisponiveis.get(i));
                        }
                    }
                    break;

                case 4:
                    // REALIZAR RESERVA
                    if (numerosAvioes.isEmpty()) {
                        System.out.println("Nenhum avião cadastrado.");
                        break;
                    }

                    if (nomesPassageiros.size() >= 20) {
                        System.out.println("Limite de 20 reservas atingido!");
                        break;
                    }

                    System.out.print("Informe o número do avião desejado: ");
                    int aviaoDesejado = 0;
                    if (scanner.hasNextInt()) {
                        aviaoDesejado = scanner.nextInt();
                        scanner.nextLine();

                        int indexAviao = numerosAvioes.indexOf(aviaoDesejado);

                        if (indexAviao == -1) {
                            System.out.println("Este avião não existe!");
                        } else if (assentosDisponiveis.get(indexAviao) <= 0) {
                            System.out.println("Não há assentos disponíveis para este avião!");
                        } else {
                            String nomePassageiro = "";
                            while (nomePassageiro.trim().isEmpty()) {
                                System.out.print("Informe o nome do passageiro: ");
                                nomePassageiro = scanner.nextLine();
                                if (nomePassageiro.trim().isEmpty()) {
                                    System.out.println("O nome não pode ficar vazio!");
                                }
                            }

                            nomesPassageiros.add(nomePassageiro);
                            avioesReservas.add(aviaoDesejado);
                            assentosDisponiveis.set(indexAviao, assentosDisponiveis.get(indexAviao) - 1);

                            System.out.println("Reserva realizada com sucesso!");
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Número inválido!");
                    }
                    break;

                case 5:
                    // CONSULTAR RESERVAS DE UM AVIÃO
                    if (numerosAvioes.isEmpty()) {
                        System.out.println("Nenhum avião cadastrado.");
                        break;
                    }

                    System.out.print("Informe o número do avião: ");
                    int aviaoConsulta = 0;
                    if (scanner.hasNextInt()) {
                        aviaoConsulta = scanner.nextInt();
                        scanner.nextLine();

                        if (!numerosAvioes.contains(aviaoConsulta)) {
                            System.out.println("Este avião não existe!");
                        } else {
                            boolean encontrouReserva = false;
                            for (int i = 0; i < avioesReservas.size(); i++) {
                                if (avioesReservas.get(i) == aviaoConsulta) {
                                    System.out.println("Passageiro: " + nomesPassageiros.get(i));
                                    encontrouReserva = true;
                                }
                            }

                            if (!encontrouReserva) {
                                System.out.println("Não há reservas realizadas para este avião!");
                            }
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Número inválido!");
                    }
                    break;

                case 6:
                    // PESQUISAR PASSAGEIRO
                    if (nomesPassageiros.isEmpty()) {
                        System.out.println("Não há nenhuma reserva cadastrada.");
                        break;
                    }

                    System.out.print("Informe o nome do passageiro: ");
                    String nomePesquisa = scanner.nextLine();

                    boolean passageiroEncontrado = false;
                    for (int i = 0; i < nomesPassageiros.size(); i++) {
                        if (nomesPassageiros.get(i).equalsIgnoreCase(nomePesquisa)) {
                            System.out.println("Passageiro encontrado | Avião reservado: " + avioesReservas.get(i));
                            passageiroEncontrado = true;
                        }
                    }

                    if (!passageiroEncontrado) {
                        System.out.println("Não há reservas realizadas para este passageiro!");
                    }
                    break;

                case 7:
                    // EXCLUIR UM AVIÃO
                    if (numerosAvioes.isEmpty()) {
                        System.out.println("Nenhum avião cadastrado.");
                        break;
                    }

                    System.out.print("Informe o número do avião que deseja excluir: ");
                    int aviaoExcluir = 0;
                    if (scanner.hasNextInt()) {
                        aviaoExcluir = scanner.nextInt();
                        scanner.nextLine();

                        int indexExcluir = numerosAvioes.indexOf(aviaoExcluir);
                        if (indexExcluir == -1) {
                            System.out.println("Este avião não existe!");
                        } else {
                            // Remove o avião e seus assentos
                            numerosAvioes.remove(indexExcluir);
                            assentosDisponiveis.remove(indexExcluir);

                            // Remove todas as reservas atreladas a este avião
                            for (int i = avioesReservas.size() - 1; i >= 0; i--) {
                                if (avioesReservas.get(i) == aviaoExcluir) {
                                    avioesReservas.remove(i);
                                    nomesPassageiros.remove(i);
                                }
                            }

                            System.out.println("Avião e suas reservas associadas foram excluídos com sucesso!");
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Número inválido!");
                    }
                    break;

                case 8:
                    // EXCLUIR UMA RESERVA
                    if (nomesPassageiros.isEmpty()) {
                        System.out.println("Não há reservas cadastradas para excluir.");
                        break;
                    }

                    System.out.println("\n--- RESERVAS REGISTRADAS ---");
                    for (int i = 0; i < nomesPassageiros.size(); i++) {
                        System.out.println((i + 1) + " - Passageiro: " + nomesPassageiros.get(i) + " | Avião: " + avioesReservas.get(i));
                    }

                    System.out.print("Escolha o número da reserva que deseja cancelar: ");
                    int numReserva = 0;
                    if (scanner.hasNextInt()) {
                        numReserva = scanner.nextInt();
                        scanner.nextLine();

                        if (numReserva >= 1 && numReserva <= nomesPassageiros.size()) {
                            int indexReserva = numReserva - 1;
                            int aviaoAssociado = avioesReservas.get(indexReserva);

                            // Devolve o assento para o avião correspondente (se ele ainda existir)
                            int indexAviao = numerosAvioes.indexOf(aviaoAssociado);
                            if (indexAviao != -1) {
                                assentosDisponiveis.set(indexAviao, assentosDisponiveis.get(indexAviao) + 1);
                            }

                            nomesPassageiros.remove(indexReserva);
                            avioesReservas.remove(indexReserva);

                            System.out.println("Reserva cancelada com sucesso!");
                        } else {
                            System.out.println("Número de reserva inválido!");
                        }
                    } else {
                        scanner.nextLine();
                        System.out.println("Entrada inválida!");
                    }
                    break;

                case 9:
                    // MOSTRAR RESUMO
                    if (numerosAvioes.isEmpty()) {
                        System.out.println("Nenhum avião cadastrado.");
                    } else {
                        int totalAssentosDisponiveis = 0;
                        int avioesComAssentos = 0;
                        int avioesSemAssentos = 0;
                        int maiorAssentos = -1;
                        int aviaoMaiorAssentos = -1;

                        for (int i = 0; i < numerosAvioes.size(); i++) {
                            int qtdAssentos = assentosDisponiveis.get(i);
                            totalAssentosDisponiveis += qtdAssentos;

                            if (qtdAssentos > 0) {
                                avioesComAssentos++;
                            } else {
                                avioesSemAssentos++;
                            }

                            if (qtdAssentos > maiorAssentos) {
                                maiorAssentos = qtdAssentos;
                                aviaoMaiorAssentos = numerosAvioes.get(i);
                            }
                        }

                        System.out.println("\n--- RESUMO DO SISTEMA ---");
                        System.out.println("Quantidade de aviões cadastrados: " + numerosAvioes.size());
                        System.out.println("Quantidade total de reservas realizadas: " + nomesPassageiros.size());
                        System.out.println("Quantidade total de assentos disponíveis: " + totalAssentosDisponiveis);
                        System.out.println("Quantidade de aviões com assentos disponíveis: " + avioesComAssentos);
                        System.out.println("Quantidade de aviões sem assentos disponíveis: " + avioesSemAssentos);
                        System.out.println("Avião com maior quantidade de assentos disponíveis: " + aviaoMaiorAssentos + " (" + maiorAssentos + " assentos)");
                    }
                    break;

                case 10:
                    // SAIR
                    System.out.println("Sistema encerrado. Até logo!");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}
