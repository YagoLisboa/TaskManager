package app;

import controller.TaskManager;
import java.util.Scanner;
import model.Tarefa;
import model.TarefaPrioritaria;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int opcao = 0;

        do {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluida");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um numero valido.");
                scanner.next(); 
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Digite o titulo da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descricao da tarefa: ");
                    String descricao = scanner.nextLine();
                    
                    // Submenu para escolher o tipo de tarefa (Polimorfismo na prática)
                    System.out.println("Tipo de tarefa: [1] Comum | [2] Prioritaria");
                    System.out.print("Escolha o tipo: ");
                    int tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpa o buffer
                    
                    if (tipo == 2) {
                        System.out.print("Digite a prioridade (Alta/Media/Baixa): ");
                        String prioridade = scanner.nextLine();
                        
                        // Instancia a subclasse
                        TarefaPrioritaria novaPrioritaria = new TarefaPrioritaria(titulo, descricao, prioridade);
                        manager.adicionarTarefa(novaPrioritaria);
                    } else {
                        // Instancia a classe mãe padrão
                        Tarefa novaComum = new Tarefa(titulo, descricao);
                        manager.adicionarTarefa(novaComum);
                    }
                    break;

                case 2:
                    manager.listarTarefas();
                    break;

//                case 3:
//                    manager.listarTarefas();
//                    System.out.print("Digite o numero da tarefa que deseja concluir: ");
//                    if (scanner.hasNextInt()) {
//                        int idxConcluir = scanner.nextInt();
//                        manager.concluirTarefa(idxConcluir);
//                    } else {
//                        System.out.println("Entrada invalida.");
//                    }
//                    scanner.nextLine(); 
//                    break;
//
//                case 4:
//                    manager.listarTarefas();
//                    System.out.print("Digite o numero da tarefa que deseja remover: ");
//                    if (scanner.hasNextInt()) {
//                        int idxRemover = scanner.nextInt();
//                        manager.removerTarefa(idxRemover);
//                    } else {
//                        System.out.println("Entrada invalida.");
//                    }
//                    scanner.nextLine(); 
//                    break;
                    
                case 3:
                    manager.listarTarefas();
                    System.out.print("Digite o numero da tarefa que deseja concluir: ");
                    if (scanner.hasNextInt()) {
                        int idxConcluir = scanner.nextInt();
                        // O bloco try tenta executar o código que pode falhar
                        try {
                            manager.concluirTarefa(idxConcluir);
                        } catch (exceptions.TarefaInvalidaException e) {
                            // O catch captura a nossa exceção customizada e exibe a mensagem amigável
                            System.err.println("Erro de Operacao: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Por favor, insira um numero inteiro.");
                    }
                    scanner.nextLine(); 
                    break;

                case 4:
                    manager.listarTarefas();
                    System.out.print("Digite o numero da tarefa que deseja remover: ");
                    if (scanner.hasNextInt()) {
                        int idxRemover = scanner.nextInt();
                        try {
                            manager.removerTarefa(idxRemover);
                        } catch (exceptions.TarefaInvalidaException e) {
                            System.err.println("Erro de Operacao: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Por favor, insira um numero inteiro.");
                    }
                    scanner.nextLine(); 
                    break;

                case 5:
                    System.out.println("Saindo do sistema... Ate logo!");
                    break;

                default:
                    System.out.println("Opcao invalida! Escolha uma opcao de 1 a 5.");
                    break;
            }

        } while (opcao != 5);

        scanner.close();
    }
}