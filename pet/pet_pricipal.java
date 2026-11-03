public class pet_pricipal {
    // 2. O OBJETO (A criação)

    public static void main(String[] args) {
        // Criando o objeto na memória a partir do molde
        pet_clace meuCachorro = new pet_clace();

        // Preenchendo as características (Atributos)
        meuCachorro.nome = "Rex";
        meuCachorro.cor = "Marrom";

        // Fazendo o objeto executar uma ação (Método)
        meuCachorro.latir(); // Vai imprimir: Rex está latindo: Au au!
    }
}

