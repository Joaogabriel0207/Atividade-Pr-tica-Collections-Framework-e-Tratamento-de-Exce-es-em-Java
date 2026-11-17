public class Main {
    public static void main(String[] args) {
        CardapioPiquiras cardapio = new CardapioPiquiras();

        System.out.println("=== 1. CADASTRANDO PRATOS DO RESTAURANTE PIQUIRAS ===");
        try {
            cardapio.adicionarPrato(new Prato(101, "Saladas", "Piquiras Caesar Salad",
                    "Para uma pessoa | Salada de Frango com Alface Romana, Mussarela de Bufala...", 78.00));
            cardapio.adicionarPrato(new Prato(102, "Carnes", "Filé à Piquiras",
                    "Para uma pessoa | Nosso Clássico Mignon ao Molho Madeira acompanhado de Arroz...", 120.00));
            cardapio.adicionarPrato(new Prato(103, "Peixes e Frutos do Mar", "Paella Piquiras",
                    "Para duas pessoas | Típico Prato de Arroz Espanhol com Lagosta, Camarão, Polvo...", 350.00));
            cardapio.adicionarPrato(new Prato(104, "Risottos", "Risotto do Cerrado",
                    "Para duas pessoas | Premiado no concurso Pratos do Dia em 1999...", 190.00));

            System.out.println("Pratos cadastrados com sucesso!\n");
        } catch (CadastroDuplicadoException | IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar: " + e.getMessage());
        }

        System.out.println("=== 2. LISTANDO TODOS OS PRATOS ===");
        for (Prato p : cardapio.listarPratos()) {
            System.out.println(p);
        }

        System.out.println("\n=== 3. BUSCANDO PRATO POR CÓDIGO (102) ===");
        try {
            Prato buscado = cardapio.buscarPorCodigo(102);
            System.out.println("Encontrado: " + buscado);
        } catch (PratoNaoEncontradoException e) {
            System.out.println("Erro na busca: " + e.getMessage());
        }

        System.out.println("\n=== 4. REMOVENDO PRATO POR CÓDIGO (101) ===");
        try {
            cardapio.removerPrato(101);
            System.out.println("Prato código 101 removido com sucesso!");
        } catch (PratoNaoEncontradoException e) {
            System.out.println("Erro ao remover: " + e.getMessage());
        }

        System.out.println("\n=== 5. TESTANDO ERRO: CADASTRO DUPLICADO ===");
        try {
            cardapio.adicionarPrato(new Prato(102, "Carnes", "Ancho Negro",
                    "Para uma pessoa | Bife Ancho de Angus...", 120.00));
        } catch (CadastroDuplicadoException | IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\n=== 6. TESTANDO ERRO: DADOS INVÁLIDOS (VALOR NEGATIVO) ===");
        try {
            cardapio.adicionarPrato(new Prato(105, "Massas", "Gnocchi ao Stracchino",
                    "Para uma pessoa | Tradicional Gnocchi...", -50.00));
        } catch (CadastroDuplicadoException | IllegalArgumentException e) {
            System.out.println("Exceção capturada: " + e.getMessage());
        }

        System.out.println("\n=== 7. TESTANDO ERRO: BUSCA E REMOÇÃO DE CÓDIGO INEXISTENTE ===");
        try {
            cardapio.buscarPorCodigo(999);
        } catch (PratoNaoEncontradoException e) {
            System.out.println("Exceção capturada na busca: " + e.getMessage());
        }

        try {
            cardapio.removerPrato(999);
        } catch (PratoNaoEncontradoException e) {
            System.out.println("Exceção capturada na remoção: " + e.getMessage());
        }

        System.out.println("\n=== 8. CONTINUIDADE APÓS ERROS: NOVO CADASTRO E LISTAGEM FINAL ===");
        try {
            cardapio.adicionarPrato(new Prato(105, "Massas", "Gnocchi ao Stracchino",
                    "Para uma pessoa | Tradicional Gnocchi Elaborado em nossa cozinha...", 80.00));
            System.out.println("Novo prato adicionado normalmente após os erros!\n");
        } catch (CadastroDuplicadoException | IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }

        for (Prato p : cardapio.listarPratos()) {
            System.out.println(p);
        }
    }
}