package controller;

import java.util.ArrayList;
import java.util.List;
import model.Tarefa;

public class TaskManager {
    // Encapsula a lista de tarefas usando a estrutura de dados solicitada
    private List<Tarefa> listaDeTarefas;

    // Construtor que inicializa a lista na memória
    public TaskManager() {
        this.listaDeTarefas = new ArrayList<>();
    }

    // Método para adicionar uma nova tarefa
    public void adicionarTarefa(Tarefa tarefa) {
        listaDeTarefas.add(tarefa);
        System.out.println("Tarefa '" + tarefa.getTitulo() + "' adicionada com sucesso!");
    }

    // Método para listar todas as tarefas com seus respectivos índices
    public void listarTarefas() {
        if (listaDeTarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada ate o momento.");
            return;
        }
        
        System.out.println("\n--- LISTA DE TAREFAS ---");
        for (int i = 0; i < listaDeTarefas.size(); i++) {
            // Exibe o ID amigável (começando em 1) e o status/conteúdo da tarefa
            System.out.println((i + 1) + ". " + listaDeTarefas.get(i));
        }
    }

//    // Método para marcar uma tarefa específica como concluída baseado no índice do menu
//    public boolean concluirTarefa(int indice) {
//        int indiceReal = indice - 1; // Ajusta a lógica de 1-based para 0-based do ArrayList
//        
//        if (validarIndice(indiceReal)) {
//            listaDeTarefas.get(indiceReal).setConcluida(true);
//            System.out.println("Tarefa '" + listaDeTarefas.get(indiceReal).getTitulo() + "' marcada como concluída!");
//            return true;
//        }
//        
//        System.out.println("Erro: Índice de tarefa invalido.");
//        return false;
//    }
//
//    // Método para remover uma tarefa da lista baseado no índice
//    public boolean removerTarefa(int indice) {
//        int indiceReal = indice - 1; // Ajusta para o padrão do ArrayList
//        
//        if (validarIndice(indiceReal)) {
//            Tarefa removida = listaDeTarefas.remove(indiceReal);
//            System.out.println("Tarefa '" + removida.getTitulo() + "' removida com sucesso!");
//            return true;
//        }
//        
//        System.out.println("Erro: Indice de tarefa invalido.");
//        return false;
//    }
    
    // Método atualizado para lançar a exceção customizada
    public void concluirTarefa(int indice) throws exceptions.TarefaInvalidaException {
        int indiceReal = indice - 1;
        
        if (!validarIndice(indiceReal)) {
            throw new exceptions.TarefaInvalidaException("O numero de tarefa " + indice + " nao existe na lista!");
        }
        
        listaDeTarefas.get(indiceReal).setConcluida(true);
        System.out.println("Tarefa '" + listaDeTarefas.get(indiceReal).getTitulo() + "' marcada como concluida!");
    }

    // Método atualizado para lançar a exceção customizada
    public void removerTarefa(int indice) throws exceptions.TarefaInvalidaException {
        int indiceReal = indice - 1;
        
        if (!validarIndice(indiceReal)) {
            throw new exceptions.TarefaInvalidaException("Nao foi possível remover: o numero " + indice + " eh invalido!");
        }
        
        Tarefa removida = listaDeTarefas.remove(indiceReal);
        System.out.println("Tarefa '" + removida.getTitulo() + "' removida com sucesso!");
    }

    // Método auxiliar (privado) para validar se o índice existe na lista
    private boolean validarIndice(int indice) {
        return indice >= 0 && indice < listaDeTarefas.size();
    }
}