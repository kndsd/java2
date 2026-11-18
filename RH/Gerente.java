package RH;

public class Gerente extends Funcionario {
    
    public Gerente(String nome, double salario) {
        // 'super' chama o construtor da classe Pai (Funcionario)
        super(nome, salario); 
    }

    // @Override avisa o Java que estamos substituindo (Polimorfismo) o método original
    @Override
    public void calcularBonus() {
        System.out.println(this.nome + " - Bônus de Gerente: R$ " + (this.salario * 0.20));
    }
}
