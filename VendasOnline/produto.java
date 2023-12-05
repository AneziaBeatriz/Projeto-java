package VendasOnline;


 public class Produto {
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidade) {
        this.quantidadeEmEstoque = quantidade;
    }

    public double calcularCustoEnvio() {
        return 5.0;
    }
}

public class SistemaVendasOnline {
    public static void main(String[] args) {
        // Aqui você pode criar instâncias de produtos e realizar operações
        Produto produto = new Produto("Produto A", 10.0, 50);
        
        // Exemplo de utilização
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: $" + produto.getPreco());
        System.out.println("Quantidade em Estoque: " + produto.getQuantidadeEmEstoque());
        System.out.println("Custo de Envio: $" + produto.calcularCustoEnvio());
    }
}
