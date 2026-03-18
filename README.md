# **Java how to program**

---
## Capítulo 16 aborda as coleções no java
- Um capítulo mais focado em mostrar como usar, e vários métodos úteis, a proposta aqui não é se aprofundar em detalhes de implementação, 
o aprofundamento será abordado no capítulo 21.
- Para não confundir, existe a interface **Collection** que as outras interfaces do pacote de coleções implementam, 
e tem a classe utilitária **Collections**, que oferece uma série de métodos **static** prontos para uso.
---

## Capítulo 17 aborda funções lambdas
- Um capítulo focado em descrever a sintaxe e o uso das expressões lambdas, uma evolução a partir das classes anônimas
### Alguns métodos comuns
#### Operações intermediárias
- **filter** Resulta em um fluxo contendo apenas os elementos que atendem uma condição.
- **distinct** Resulta em um fluxo que contém somente os elementos únicos.
- **limit** Resulta em um fluxo com o número especificado de elementos a partir do início do fluxo original.
- **map** Resulta em um fluxo em que cada elemento do fluxo original é mapeado para um novo valor (possivelmente
  de um tipo diferente) — por exemplo, mapear valores numéricos para as raízes quadradas dos valores
  numéricos. O novo fluxo tem o mesmo número de elementos que o fluxo original.
- **sorted** Resulta em um fluxo em que os elementos estão em ordem classificada. O novo fluxo tem o mesmo número
  de elementos que o fluxo original.

#### Operações terminais
- **forEach** Realiza o processamento em cada elemento em um fluxo (por exemplo, exibir cada elemento).
- `Operações de redução — recebem todos os valores no fluxo e retornam um único valor`
  - **average** Calcula a média dos elementos em um fluxo numérico.
  - **count** Retorna o número de elementos no fluxo.
  - **max** Localiza o maior valor em um fluxo numérico.
  - **min** Localiza o menor valor em um fluxo numérico.
  - **reduce** Reduz os elementos de uma coleção a um único valor usando uma função de acumulação
  associativa (por exemplo, uma lambda que adiciona dois elementos).
- `Operações de redução mutáveis — criam um contêiner (como uma coleção ou um StringBuilder)`
  - **collect** Cria uma nova coleção dos elementos contendo os resultados das operações anteriores do fluxo.
  - **toArray** Cria um array contendo os resultados das operações anteriores do fluxo.
- `Operações de pesquisa`
  - **findFirst** Localiza o primeiro elemento no fluxo com base nas operações intermediárias anteriores; termina
  imediatamente o processamento do pipeline do fluxo depois que esse elemento é encontrado.
  - **findAny** Localiza qualquer elemento no fluxo com base nas operações intermediárias anteriores; termina
  imediatamente o processamento do pipeline do fluxo depois que esse elemento é encontrado.
  - **anyMatch** Determina se quaisquer elementos no fluxo correspondem a uma condição especificada; termina
  imediatamente o processamento do pipeline do fluxo se um elemento corresponde.
  - **allMatch** Determina se todos os elementos no fluxo correspondem a uma condição especificada.

