package pix;

public class Conta {

    private int numero;
    private String titular;
    private double saldo;
    private Agencia agencia;

    public Conta(int numero, String titular, double saldo, Agencia agencia) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void depositar(double valor) {

        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }

        saldo += valor;

        System.out.printf("Depósito realizado!%n");
        System.out.printf("Novo saldo: R$ %.2f%n", saldo);
    }

    public void consultarSaldo() {
        System.out.printf("Saldo disponível: R$ %.2f%n", saldo);
    }

    public void mostrarDados() {

        System.out.println("\n===== DADOS DA CONTA =====");

        agencia.mostrarDados();

        System.out.println("Número da conta: " + numero);
        System.out.println("Titular: " + titular);

        System.out.printf("Saldo: R$ %.2f%n", saldo);
    }
}