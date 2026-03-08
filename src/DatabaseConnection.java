public class DatabaseConnection {
    // ERRO: O construtor é público! Qualquer classe pode instanciar uma nova conexão.
    public DatabaseConnection() {
        System.out.println("[BANCO DE DADOS] Nova conexão física criada! (Consumindo recursos...)");
        try {
            // Simulando o tempo de abertura de uma conexão pesada
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void salvarPedido(String dados) {
        System.out.println("[BANCO DE DADOS] Salvando pedido no banco: " + dados);
    }
}
