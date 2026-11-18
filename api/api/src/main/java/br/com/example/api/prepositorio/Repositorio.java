package br.com.example.api.prepositorio;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.example.api.modelo.Pessoa;


public interface Repositorio extends JpaRepository<Pessoa, Integer> {
    
    // Exemplo de método personalizado de busca por código
    Pessoa findByCodigo(Integer codigo);

}    
