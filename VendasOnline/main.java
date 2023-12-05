import java.util.Scanner;

class Produto {
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

    public void mostrarQuantidadeEstoque() {
        System.out.println("Quantidade em estoque de " + nome + ": " + quantidadeEmEstoque);
    }

    public void atualizarQuantidadeEstoque(int novaQuantidade) {
        quantidadeEmEstoque = novaQuantidade;
        System.out.println("Quantidade em estoque de " + nome + " atualizada para " + novaQuantidade);
    }
}

class Eletronico extends Produto {
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

class Roupa extends Produto {
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

class Loja {
    private Produto[] produtos;

    public Loja(int capacidade) {
        produtos = new Produto[capacidade];
    }

    public void adicionarProduto(int indice, Produto produto) {
        if (indice >= 0 && indice < produtos.length) {
            produtos[indice] = produto;
        }
    }

    public void mostrarProdutos() {
        for (int i = 0; i < produtos.length; i++) {
            System.out.println((i + 1) + ". " + produtos[i].getNome());
        }
    }
}

public class SistemaVendasOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja(16);

        loja.adicionarProduto(0, new Eletronico("Notebook", 1500.0, 5, "220 V"));
        loja.adicionarProduto(1, new Roupa("Camiseta", 50.0, 10, "M"));

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Mostrar custo de envio de um produto");
            System.out.println("2. Mostrar quantidade em estoque de um produto");
            System.out.println("3. Atualizar quantidade em estoque de uma roupa ou eletrônico");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("\nProdutos disponíveis:");
                    loja.mostrarProdutos();
                    System.out.print("Escolha o número do produto para mostrar o custo de envio: ");
                    int escolhaProdutoEnvio = scanner.nextInt();
                    if (escolhaProdutoEnvio >= 1 && escolhaProdutoEnvio <= loja.getQuantidadeProdutos()) {
                        Produto produtoEscolhidoEnvio = loja.getProduto(escolhaProdutoEnvio - 1);
                        System.out.println("Custo de envio do " + produtoEscolhidoEnvio.getNome() + ": $" + produtoEscolhidoEnvio.calcularCustoEnvio());
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    System.out.println("\nProdutos disponíveis:");
                    loja.mostrarProdutos();
                    System.out.print("Escolha o número do produto para mostrar a quantidade em estoque: ");
                    int escolhaProdutoEstoque = scanner.nextInt();
                    if (escolhaProdutoEstoque >= 1 && escolhaProdutoEstoque <= loja.getQuantidadeProdutos()) {
                        Produto produtoEscolhidoEstoque = loja.getProduto(escolhaProdutoEstoque - 1);
                        produtoEscolhidoEstoque.mostrarQuantidadeEstoque();
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 3:
                    System.out.println("\nProdutos disponíveis para atualização de estoque:");
                    loja.mostrarProdutos();
                    System.out.print("Escolha o número do produto para atualizar o estoque: ");
                    int escolhaProduto = scanner.nextInt();
                    if (escolhaProduto >= 1 && escolhaProduto <= loja.getQuantidadeProdutos()) {
                        System.out.print("Digite a nova quantidade em estoque: ");
                        int novaQuantidade = scanner.nextInt();
                        Produto produtoEscolhido = loja.getProduto(escolhaProduto - 1);
                        produtoEscolhido.atualizarQuantidadeEstoque(novaQuantidade);
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 4);

        scanner.close();
    }
}
