package model;

// A palavra 'extends' indica que TarefaPrioritaria herda de Tarefa
public class TarefaPrioritaria extends Tarefa {
    private String prioridade; // Atributo exclusivo desta subclasse (ex: Alta, Média, Baixa)

    // O construtor precisa chamar o construtor da classe mãe usando 'super'
    public TarefaPrioritaria(String titulo, String descricao, String prioridade) {
        super(titulo, descricao); // Repassa o título e a descrição para a classe base
        this.prioridade = prioridade;
    }

    // Getter e Setter exclusivo para a prioridade
    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    // Polimorfismo: Sobrescrevemos o método toString para incluir a prioridade
    @Override
    public String toString() {
        // super.toString() reaproveita a formatação de status, título e descrição da classe mãe
        return super.toString() + " [Prioridade: " + prioridade + "]";
    }
}