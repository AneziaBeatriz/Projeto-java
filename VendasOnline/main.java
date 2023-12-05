import java.util.Scanner;

public class SistemaVendasOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja(16);

        loja.adicionarProduto(0, new Eletronico("Notebook", 1500.0, 5, "220 V"));
        loja.adicionarProduto(1, new Roupa("Camiseta", 50.0, 10, "M"));
        loja.adicionarProduto(2, new Eletronico("Smartphone", 800.0, 3, "110 V"));
        loja.adicionarProduto(3, new Roupa("Calça", 100.0, 20, "M"));

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
