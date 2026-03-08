public class DatabaseConnection {

    // 1. Atributo estático que guarda a instância única
    private static DatabaseConnection instancia;

    // 2. Construtor privado: impede o uso de 'new' fora da classe
    private DatabaseConnection() {
        System.out.println("[BANCO DE DADOS] Nova conexão física criada! (Apenas uma vez)");
        try {
            Thread.sleep(500); // Simula lentidão de conexão
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 3. Ponto global de acesso
    public static DatabaseConnection getInstance() {
        if (instancia == null) {
            instancia = new DatabaseConnection();
        }
        return instancia;
    }

    public void salvarPedido(String dados) {
        System.out.println("[BANCO DE DADOS] Salvando pedido no banco: " + dados);
    }
}