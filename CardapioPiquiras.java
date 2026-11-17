import java.util.ArrayList;

public class CardapioPiquiras {
    private ArrayList<Prato> pratos;

    public CardapioPiquiras() {
        this.pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) throws CadastroDuplicadoException {
        if (prato == null) {
            throw new IllegalArgumentException("O prato não pode ser nulo.");
        }
        if (prato.getCodigo() <= 0) {
            throw new IllegalArgumentException("O código do prato deve ser maior que zero.");
        }
        if (prato.getTitulo() == null || prato.getTitulo().trim().isEmpty()) {
            throw new IllegalArgumentException("O título do prato é obrigatório.");
        }
        if (prato.getCategoria() == null || prato.getCategoria().trim().isEmpty()) {
            throw new IllegalArgumentException("A categoria do prato é obrigatória.");
        }
        if (prato.getValor() <= 0) {
            throw new IllegalArgumentException("O valor do prato deve ser maior que zero.");
        }

        for (Prato p : pratos) {
            if (p.getCodigo() == prato.getCodigo()) {
                throw new CadastroDuplicadoException(
                        "Já existe um prato cadastrado com o código " + prato.getCodigo() + ".");
            }
        }

        pratos.add(prato);
    }

    public ArrayList<Prato> listarPratos() {
        return pratos;
    }

    public Prato buscarPorCodigo(int codigo) throws PratoNaoEncontradoException {
        for (Prato p : pratos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        throw new PratoNaoEncontradoException("Nenhum prato encontrado com o código " + codigo + ".");
    }

    public void removerPrato(int codigo) throws PratoNaoEncontradoException {
        Prato pratoEncontrado = buscarPorCodigo(codigo);
        pratos.remove(pratoEncontrado);
    }
}