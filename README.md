# Sistema de Cardápio — Restaurante Piquiras

Atividade prática de Programação Orientada a Objetos em Java aplicando **Collections Framework** e **Tratamento de Exceções**.

## Descrição da Entidade e Funcionalidades

A entidade escolhida foi **`Prato`**, baseada no cardápio real do **Restaurante Piquiras**, contendo os atributos:
- `codigo` (identificador único do prato)
- `categoria` (ex.: Saladas, Carnes, Peixes e Frutos do Mar, Massas, Risottos)
- `titulo` (nome do prato)
- `descricao` (detalhes e porção)
- `valor` (preço em reais)

Na classe **`CardapioPiquiras`**, foram implementadas as seguintes funcionalidades:
- **Adicionar prato:** cadastra um novo item após validar seus dados e verificar duplicidade.
- **Listar pratos:** retorna todos os itens armazenados no cardápio.
- **Buscar por código:** localiza um prato pelo seu atributo identificador (`codigo`).
- **Remover prato:** exclui um item do cardápio a partir de seu código.

## Coleção Utilizada e Justificativa

Foi utilizada a estrutura **`ArrayList<Prato>`** do pacote `java.util`.
- **Justificativa:** Diferente dos arrays tradicionais de tamanho fixo, o `ArrayList` cresce dinamicamente conforme novos pratos são inseridos ou removidos. Além disso, preserva a ordem de cadastro dos itens e facilita a listagem sequencial e a busca por atributos específicos usando laços simples.

## Exceções Tratadas

O projeto utiliza `throw`, `throws` e blocos `try-catch` para impedir falhas inesperadas e manter a integridade dos dados:
1. **`CadastroDuplicadoException` (Exceção Personalizada):** lançada ao tentar cadastrar um prato com um `codigo` que já existe na coleção.
2. **`PratoNaoEncontradoException` (Exceção Personalizada):** lançada ao tentar buscar ou remover um prato cujo `codigo` não está cadastrado.
3. **`IllegalArgumentException` (Exceção Nativa do Java):** lançada ao tentar cadastrar um prato nulo, com código menor ou igual a zero, título/categoria vazios ou valor menor ou igual a zero.

## Execução e Capturas de Tela
![Captura de tela 5](./Captura%20de%20tela%202026-11-16%20222934.png)

## Como Executar o Programa

1. Certifique-se de ter o **JDK (Java Development Kit)** instalado.
2. Abra o terminal na pasta onde estão os arquivos `.java`.
3. Compile todos os arquivos:
   ```bash
   javac *.java
