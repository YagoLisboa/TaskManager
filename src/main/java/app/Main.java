package app;

import controller.TaskManager;
import java.util.Scanner;
import model.Tarefa;

public class Main {
    public static void main(String[] args) {
        // Inicializa o Scanner para leitura do console e o TaskManager para controle das tarefas
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        int opcao = 0;

        // O menu funciona em loop até que o usuário selecione a opção 5 (Sair)
        do {
            System.out.println("\n===== GERENCIADOR DE TAREFAS =====");
            System.out.println("1. Criar nova tarefa");
            System.out.println("2. Listar tarefas");
            System.out.println("3. Marcar tarefa como concluida");
            System.out.println("4. Remover tarefa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opcao: ");

            // Tratamento básico inicial para evitar que o programa quebre se o usuário digitar letras
            if (!scanner.hasNextInt()) {
                System.out.println("Por favor, digite um numero valido.");
                scanner.next(); // Limpa a entrada inválida do scanner
                continue;
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a quebra de linha deixada pelo nextInt()

            switch (opcao) {
                case 1:
                    System.out.print("Digite o titulo da tarefa: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite a descricao da tarefa: ");
                    String descricao = scanner.nextLine();
                    
                    Tarefa novaTarefa = new Tarefa(titulo, descricao);
                    manager.adicionarTarefa(novaTarefa);
                    break;

                case 2:
                    manager.listarTarefas();
                    break;

                case 3:
                    manager.listarTarefas();
                    System.out.print("Digite o numero da tarefa que deseja concluir: ");
                    if (scanner.hasNextInt()) {
                        int idxConcluir = scanner.nextInt();
                        manager.concluirTarefa(idxConcluir);
                    } else {
                        System.out.println("Entrada invalida.");
                    }
                    scanner.nextLine(); // Limpa o buffer
                    break;

                case 4:
                    manager.listarTarefas();
                    System.out.print("Digite o numero da tarefa que deseja remover: ");
                    if (scanner.hasNextInt()) {
                        int idxRemover = scanner.nextInt();
                        manager.removerTarefa(idxRemover);
                    } else {
                        System.out.println("Entrada invalida.");
                    }
                    scanner.nextLine(); // Limpa o buffer
                    break;

                case 5:
                    System.out.println("Saindo do sistema... Ate logo!");
                    break;

                default:
                    System.out.println("Opcao invalida! Escolha uma opção de 1 a 5.");
                    break;
            }

        } while (opcao != 5);

        scanner.close(); // Fecha o recurso do scanner de forma segura
    }
}