package f1;

public class FuncionarioFreelancer extends Funcionario implements Pagamento {
    private double valorHora;
    private int horasTrabalhadas;

    public FuncionarioFreelancer(String nome, String cpf, double valorHora, int horasTrabalhadas) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    @Override
    public double calcularPagamento() {
        return this.valorHora * this.horasTrabalhadas;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return (this.valorHora * this.horasTrabalhadas) + bonus;
    }
}