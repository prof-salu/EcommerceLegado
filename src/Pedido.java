public class Pedido {
    // Atributos privados e finais (Imutabilidade)
    private final String cliente;
    private final String enderecoEntrega;
    private final String produto;
    private final double valor;
    private final String cupomDesconto;
    private final boolean embalagemPresente;

    // 1. Construtor privado recebendo o Builder
    private Pedido(PedidoBuilder builder) {
        this.cliente = builder.cliente;
        this.enderecoEntrega = builder.enderecoEntrega;
        this.produto = builder.produto;
        this.valor = builder.valor;
        this.cupomDesconto = builder.cupomDesconto;
        this.embalagemPresente = builder.embalagemPresente;
    }

    public double getValor() { return valor; }

    @Override
    public String toString() {
        return "Pedido{cliente='" + cliente + "', produto='" + produto + "', valor=" + valor + ", presente=" + embalagemPresente + '}';
    }

    // 2. Classe Builder Estática Interna
    public static class PedidoBuilder {
        // Atributos obrigatórios podem ser passados no construtor do Builder
        private String cliente;
        private String produto;
        private double valor;

        // Atributos opcionais
        private String enderecoEntrega;
        private String cupomDesconto;
        private boolean embalagemPresente = false;

        // Métodos fluentes
        public PedidoBuilder comCliente(String cliente) {
            this.cliente = cliente;
            return this; // Retorna a si mesmo
        }

        public PedidoBuilder comProduto(String produto, double valor) {
            this.produto = produto;
            this.valor = valor;
            return this;
        }

        public PedidoBuilder comEndereco(String endereco) {
            this.enderecoEntrega = endereco;
            return this;
        }

        public PedidoBuilder comCupom(String cupom) {
            this.cupomDesconto = cupom;
            return this;
        }

        public PedidoBuilder embalarParaPresente() {
            this.embalagemPresente = true;
            return this;
        }

        // 3. Método de construção final
        public Pedido build() {
            if (cliente == null || produto == null) {
                throw new IllegalStateException("Cliente e Produto são obrigatórios!");
            }
            return new Pedido(this);
        }
    }
}