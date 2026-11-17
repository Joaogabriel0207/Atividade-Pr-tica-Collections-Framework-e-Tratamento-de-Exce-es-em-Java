public class Prato {
    private int codigo;
    private String categoria;
    private String titulo;
    private String descricao;
    private double valor;

    public Prato(int codigo, String categoria, String titulo, String descricao, double valor) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.titulo = titulo;
        this.descricao = descricao;
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return String.format("Cód: %d | [%s] %s - R$ %.2f (%s)",
                codigo, categoria, titulo, valor, descricao);
    }
}