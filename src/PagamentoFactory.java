public class PagamentoFactory {

    // Oculta a complexidade dos if/else do cliente (Main/Checkout)
    public static Pagamento criarPagamento(String tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("Tipo de pagamento não pode ser nulo.");
        }

        switch (tipo.toUpperCase()) {
            case "CREDITO":
                return new PagamentoCredito();
            case "BOLETO":
                return new PagamentoBoleto();
            case "PIX":
                return new PagamentoPix();
            default:
                throw new IllegalArgumentException("Meio de pagamento desconhecido: " + tipo);
        }
    }
}