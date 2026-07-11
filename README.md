# 🚀 TaskManager - Gerenciador de Tarefas (Console)

[![Java Version](https://img.shields.io/badge/Java-17%2B-orange.svg)](https://www.oracle.com/java/)
[![Architecture](https://img.shields.io/badge/Architecture-MVC%20/%20Layered-blue.svg)](#-arquitetura-e-estrutura-de-pacotes)
[![Conventional Commits](https://img.shields.io/badge/Conventional%20Commits-1.0.0-yellow.svg)](https://www.conventionalcommits.org/)

O **TaskManager** é um sistema de gerenciamento de tarefas robusto desenvolvido em Java puro para rodar diretamente no terminal. O projeto foi concebido como parte do módulo prático do curso básico de FullStack Java, servindo como uma base arquitetural sólida para futuras evoluções em interfaces gráficas (JavaFX) e APIs Web (Spring Boot).

---

## 🛠️ Recursos e Funcionalidades

- **CRUD de Tarefas em Memória:** Criação, listagem, conclusão e remoção de tarefas em tempo de execução.
- **Polimorfismo de Tipos:** Suporte a tarefas comuns e tarefas prioritárias com herança dinâmica.
- **Robustez contra Falhas:** Tratamento customizado de exceções (`try/catch`) para blindar o sistema contra entradas inválidas do usuário.
- **Menu Interativo Resiliente:** Fluxo contínuo baseado em estruturas de repetição (`do-while`) com validação de buffer do `Scanner`.

---

## 📐 Arquitetura e Estrutura de Pacotes

O projeto adota uma arquitetura em camadas bem definida para garantir alta coesão e baixo acoplamento, facilitando a substituição da camada de visualização no futuro:

```text
src/
├── app/          # Camada de Apresentação (Interface de texto e Menu)
│   └── Main.java
├── controller/   # Camada de Negócio (Lógica de gerenciamento do ArrayList)
│   └── TaskManager.java
├── exceptions/   # Camada de Tratamento de Erros Customizados
│   └── TarefaInvalidaException.java
└── model/        # Camada de Domínio (Entidades de dados encapsuladas)
    ├── Tarefa.java
    └── TarefaPrioritaria.java
```
## 🧠 Conceitos de POO Aplicados
Este projeto demonstra maturidade técnica ao aplicar os principais pilares da Programação Orientada a Objetos:

1. Encapsulamento: Todos os atributos das entidades são private, sendo expostos estritamente via métodos acessores (getters e setters).

2. Herança: A classe TarefaPrioritaria estende Tarefa, herdando a estrutura base e adicionando atributos específicos (prioridade) de forma limpa.

3. Polimorfismo: Uso de coleções genéricas (List<Tarefa>) que aceitam tanto a classe mãe quanto as subclasses. Sobrescrita (@Override) do método toString() para renderização customizada.

4. Tratamento de Exceções: Implementação de Checked Exceptions customizadas para garantir que erros de regra de negócio sejam propagados e tratados adequadamente na camada visual.

## 🚀 Como Executar o Projeto
Pré-requisitos
- Java JDK 17 ou superior instalado.

- IDE de sua preferência (Desenvolvido utilizando Apache NetBeans).

Passos para Execução
1. Clone este repositório:

git clone [https://github.com/seu-usuario/TaskManager.git](https://github.com/seu-usuario/TaskManager.git)

2. Abra o projeto em sua IDE (NetBeans, IntelliJ ou Eclipse).

3. Navegue até o pacote app.

4. Execute o arquivo Main.java.

### 📈 Próximos Passos (Roadmap de Evolução)
Este projeto foi desenhado de forma extensível para suportar as seguintes evoluções de arquitetura:

- [ ] Fase 2: Substituição da interface de console por uma interface gráfica rica utilizando JavaFX.

- [ ] Fase 3: Implementação de persistência de dados utilizando o ecossistema Spring Boot e bancos de dados relacionais (PostgreSQL/H2).

*Desenhado com ☕ e dedicação* _para o meu portfólio profissional._