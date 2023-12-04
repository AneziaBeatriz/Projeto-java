package VendasOnline;

public class Roupa extends Produto {
    private String tamanho;

    public Roupa(String nome, double preco, int quantidadeEmEstoque, String tamanho) {
        super(nome, preco, quantidadeEmEstoque);
        this.tamanho = tamanho;
    }


    @Override
    public double calcularCustoEnvio() {
        return super.calcularCustoEnvio() + 1.0;
    }
}
