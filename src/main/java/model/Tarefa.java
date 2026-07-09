package model;

public class Tarefa {
    // Atributos privados (Encapsulamento)
    private String titulo;
    private String descricao;
    private boolean concluida;

    // Construtor para inicializar uma nova tarefa
    public Tarefa(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.concluida = false; // Toda tarefa nova começa como não concluída
    }

    // Getters e Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }

    // Método auxiliar para exibir a tarefa formatada
    @Override
    public String toString() {
        String status = concluida ? "[Concluída]" : "[Pendente]";
        return status + " " + titulo + " - " + descricao;
    }
}