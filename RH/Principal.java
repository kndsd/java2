package RH;

// 3. EXECUTANDO O CÓDIGO
public class Principal {
    public static void main(String[] args) {
        
        // Objeto normal
        Funcionario dev = new Funcionario("Ana", 3000.0);
        
        // POLIMORFISMO NA PRÁTICA: 
        // A variável é do tipo Funcionario, mas guarda um Gerente
        Funcionario chefe = new Gerente("Carlos", 8000.0);

        // O Java chama a versão correta do método para cada objeto automaticamente
        dev.calcularBonus();   // Saída: Ana - Bônus padrão: R$ 300.0
        chefe.calcularBonus(); // Saída: Carlos - Bônus de Gerente: R$ 1600.0
    }
}
