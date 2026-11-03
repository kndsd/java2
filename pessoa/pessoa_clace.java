public class pessoa_clace {
    String nome;
    int idade ;
     
    public pessoa_clace(String nome_at , int idade_at){
        nome = nome_at;
        idade = idade_at;
    }
    public void dados() {
        System.out.println("o nome e "+ this.nome+ " e a idade e"+ this.idade);
    }
}
