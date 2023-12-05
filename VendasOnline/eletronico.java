package VendasOnline;

public class Eletronico extends Produto {
    private String voltagem;

    public Eletronico(String nome, double preco, int quantidadeEmEstoque, String voltagem) {
        super(nome, preco, quantidadeEmEstoque);
        this.voltagem = voltagem;
    }

    @Override
    public double calcularCustoEnvio() {
        return super.calcularCustoEnvio() + 2.0;
    }
}
