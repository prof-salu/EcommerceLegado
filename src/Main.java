public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE E-COMMERCE (REFATORADO) ===\n");

        System.out.println("--- 1. Testando o Singleton ---");
        // O banco será instanciado apenas na primeira chamada
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        System.out.println("db1 e db2 são a mesma instância em memória? " + (db1 == db2));
        System.out.println();

        System.out.println("--- 2. Testando o Builder ---");
        // Criação fluente, limpa e legível (sem construtores gigantes e confusos)
        Pedido pedido = new Pedido.PedidoBuilder()
                .comCliente("João Silva")
                .comProduto("Notebook Dell", 5500.0)
                .comEndereco("Rua das Flores, 123")
                .embalarParaPresente()
                .build();

        System.out.println("Criado: " + pedido.toString());
        System.out.println();

        System.out.println("--- 3. Testando o Factory Method ---");
        // O Main não sabe como instanciar o Pix, ele apenas pede à Fábrica
        try {
            Pagamento pagamento = PagamentoFactory.criarPagamento("PIX");
            pagamento.processar(pedido.getValor());

            // Salvando no banco de dados único
            db1.salvarPedido(pedido.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao processar pagamento: " + e.getMessage());
        }
    }
}