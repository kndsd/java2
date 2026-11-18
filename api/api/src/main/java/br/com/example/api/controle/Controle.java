package br.com.example.api.controle;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.example.api.modelo.Pessoa;
import br.com.example.api.prepositorio.Repositorio;

@RestController
public class Controle {

    private final Repositorio acao;

    public Controle(Repositorio acao) {
        this.acao = acao;
    }

    @PostMapping("/api")
    public Pessoa cadastrar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }   

    @GetMapping("/api/{codigo}")
    public Pessoa selecionarpelocodigo(@PathVariable Integer codigo) {
        return acao.findByCodigo(codigo); // Corrigido para findByCodigo
    }

    @GetMapping("")
    public String mensagen() {
        return "ola mundo";
    }

    @GetMapping("/boasVindas")
    public String boasVindas() {
        return "Bem vindo ";
    }

    @GetMapping("/boasVindas/{nome}")
    public String boasVindas(@PathVariable String nome) {
        return "Bem vindo " + nome;
    }

    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        return p;
    }
}