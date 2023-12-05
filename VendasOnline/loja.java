public class Loja {
    private Produto[] produtos;
    private int quantidadeProdutos;

    public Loja(int capacidade) {
        produtos = new Produto[capacidade];
        quantidadeProdutos = 0;
    }

    public void adicionarProduto(int indice, Produto produto) {
        if (indice >= 0 && indice < produtos.length && quantidadeProdutos < produtos.length) {
            produtos[indice] = produto;
            quantidadeProdutos++;
        } else {
            System.out.println("Índice inválido ou capacidade da loja excedida.");
        }
    }

    public void mostrarProdutos() {
        for (int i = 0; i < quantidadeProdutos; i++) {
            System.out.println((i + 1) + ". " + produtos[i].getNome());
        }
    }

    public Produto getProduto(int indice) {
        if (indice >= 0 && indice < quantidadeProdutos) {
            return produtos[indice];
        } else {
            System.out.println("Índice inválido.");
            return null;
        }
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }
}
