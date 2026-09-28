package aula12;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        try {
            System.out.println("Informe um numero inteiro: ");
            int numero = scanner.nextInt();
            System.out.println("Voce digitou: " + numero);
        } catch (InputMismatchException e) {
            System.out.println("Eroo: Você deve digitir um numero  inteiro!");
        }
        












    }
}
