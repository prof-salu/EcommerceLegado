public class Pedido {
    private String cliente;
    private String enderecoEntrega;
    private String produto;
    private double valor;
    private String cupomDesconto;
    private boolean embalagemPresente;
    private boolean entregaExpressa;
    private double taxaFrete;

    // É muito difícil lembrar a ordem dos booleanos e strings ao instanciar esta classe.
    public Pedido(String cliente, String enderecoEntrega, String produto, double valor,
                  String cupomDesconto, boolean embalagemPresente, boolean entregaExpressa, double taxaFrete) {
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.produto = produto;
        this.valor = valor;
        this.cupomDesconto = cupomDesconto;
        this.embalagemPresente = embalagemPresente;
        this.entregaExpressa = entregaExpressa;
        this.taxaFrete = taxaFrete;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "cliente='" + cliente + '\'' +
                ", produto='" + produto + '\'' +
                ", valor=" + valor +
                ", presente=" + embalagemPresente +
                '}';
    }
}