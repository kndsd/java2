package f1;

public class FuncionarioCLT extends Funcionario implements Pagamento {
    private double salarioMensal;

    public FuncionarioCLT(String nome, String cpf, double salarioMensal) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularPagamento() {
        return this.salarioMensal;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return this.salarioMensal + bonus;
    }
}