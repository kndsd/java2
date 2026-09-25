package funcionarios;
public class FuncionarioFreelancer extends Funcionario implements Pagamento {

    private double horasTrabalhadas;
    private double valorHora;

    public FuncionarioFreelancer(String nome, String cpf, double salario,
                                 double horasTrabalhadas, double valorHora) {

        super(nome, cpf, salario);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public double calcularPagamento(double bonus) {
        return (horasTrabalhadas * valorHora) + bonus;
    }

    @Override
    public void mostrarDados() {
        super.mostrarDados();
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
        System.out.println("Valor por hora: R$ " + valorHora);
    }
}