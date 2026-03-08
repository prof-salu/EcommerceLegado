public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE E-COMMERCE (LEGADO) ===\n");

        // ------------------------------------------------------------------------
        // LABORATÓRIO 1: O Problema do Singleton
        // O sistema está abrindo 3 conexões diferentes. Se 1000 clientes
        // comprarem ao mesmo tempo, o banco de dados vai cair.
        // ------------------------------------------------------------------------
        System.out.println("--- Conectando ao Banco de Dados ---");
        DatabaseConnection db1 = new DatabaseConnection();
        DatabaseConnection db2 = new DatabaseConnection();
        DatabaseConnection db3 = new DatabaseConnection();

        System.out.println("O db1 é igual ao db2? " + (db1 == db2)); // Imprime 'false' (São instâncias diferentes)
        System.out.println();


        // ------------------------------------------------------------------------
        // LABORATÓRIO 3: O Problema do Builder
        // Um pesadelo de ler e manter. O que significa "null, true, false"?
        // ------------------------------------------------------------------------
        System.out.println("--- Criando Pedido ---");
        Pedido pedido = new Pedido("João Silva", "Rua das Flores, 123", "Notebook Dell",
                5500.0, null, true, false, 50.0);
        System.out.println("Criado: " + pedido.toString());
        System.out.println();


        // ------------------------------------------------------------------------
        // LABORATÓRIO 2: O Problema do Factory Method
        // Alto acoplamento. Toda vez que um novo meio de pagamento for criado (ex: Criptomoeda),
        // precisaremos abrir a classe Main (ou Checkout) e adicionar um novo 'else if'.
        // ------------------------------------------------------------------------
        System.out.println("--- Processando Pagamento ---");
        String tipoPagamentoEscolhido = "PIX"; // Simula a escolha do utilizador na tela
        Pagamento pagamento = null;

        if (tipoPagamentoEscolhido.equals("CREDITO")) {
            pagamento = new PagamentoCredito();
        } else if (tipoPagamentoEscolhido.equals("BOLETO")) {
            pagamento = new PagamentoBoleto();
        } else if (tipoPagamentoEscolhido.equals("PIX")) {
            pagamento = new PagamentoPix();
        } else {
            System.out.println("Meio de pagamento desconhecido!");
        }

        if (pagamento != null) {
            pagamento.processar(pedido.getValor());
            // Salvando no banco (usando uma das várias conexões criadas)
            db1.salvarPedido(pedido.toString());
        }
    }
}