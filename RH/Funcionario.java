
package RH;
// 1. CLASSE PAI (A base)
public class Funcionario {
    // 'protected' permite que as classes filhas acessem essas variáveis
    protected String nome;
    protected double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    // Ação padrão para qualquer funcionário
    public void calcularBonus() {
        System.out.println(this.nome + " - Bônus padrão: R$ " + (this.salario * 0.10));
    }
}