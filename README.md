# Broken Minimum Spanning Tree

## Informações Gerais
- **Link do Problema:** [https://open.kattis.com/problems/brokenminimumspanningtree](https://open.kattis.com/problems/brokenminimumspanningtree)
- **Integrantes do Grupo:** [Inserir Nomes dos Integrantes]
- **Linguagem Utilizada:** Java (JDK 11+)

## Como Executar
1. Certifique-se de que todos os arquivos `.java` estão no mesmo diretório.
2. Compile o projeto:
   ```bash
   javac *.java
   ```
3. Execute passando o arquivo de entrada:
   ```bash
   java Main < input.txt
   ```

## Modelagem do Problema
O problema foi modelado como um **Grafo Ponderado Não Direcionado** utilizando listas de adjacência. A entidade principal é a classe `Edge`, que armazena:
- `id`: Identificador único da aresta (essencial para o output do Kattis).
- `weight`: Peso da aresta.
- `isEthan`: Flag booleana que identifica se a aresta pertencia à árvore geradora inicial.
A estrutura do grafo utiliza a estratégia `V + 1` para mapear vértices de 1 a V sem necessidade de ajustes constantes de índice.

## Estratégia Algorítmica
A solução utiliza uma abordagem combinada:
1. **Kruskal's Algorithm:** Para identificar a MST ideal do grafo completo.
2. **DFS (Depth-First Search):** Para encontrar caminhos na árvore atual e identificar ciclos, permitindo realizar os swaps de arestas necessários.

### Papel do Union-Find (DSU)
Utilizado dentro do algoritmo de Kruskal para gerenciar a conectividade dos componentes de forma eficiente ($O(\alpha(V))$). Implementa união por rank e compressão de caminho para evitar a degradação da estrutura.

### Ordenação e Fila de Prioridade
As arestas são ordenadas primeiramente pelo peso. Em caso de empate, a aresta que já pertence à árvore do Ethan (`isEthan = true`) tem prioridade. Isso garante que o número de trocas seja minimizado.

### Variação de MST
Foi aplicada a **MST com Desempate Lexicográfico**. Ao priorizar arestas originais em empates de peso, construímos a MST que possui a maior interseção possível com a árvore inicial.

## Análise de Complexidade
- **Tempo:** $O(M \log M + V^2)$. Onde $M \log M$ domina a ordenação e $V^2$ representa o pior caso das trocas com DFS.
- **Espaço:** $O(V + M)$ para armazenar as listas de adjacência e estruturas auxiliares.

## Casos Especiais Relevantes
- **Pesos Idênticos:** Tratados via critério de desempate na ordenação.
- **Arestas Paralelas:** Diferenciadas pelo ID único.
- **Self-loops:** Ignorados naturalmente pelo Union-Find no Kruskal.

## Comprovação de Sucesso
[Link ou Imagem comprovando o status **Accepted** no Kattis]