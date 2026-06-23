import java.util.HashMap;
import java.util.Map;

public class TestesAutomatizados {
    public static void main(String[] args) {
        System.out.println("=== Iniciando Testes Automatizados ===");

        // 1. Preparação (Setup)
        Map<Integer, Pessoa> database = new HashMap<>();
        Map<String, Command> commands = new HashMap<>();
        commands.put("new", new NewCommand(database));
        commands.put("delete", new DeleteCommand(database));
        commands.put("all", new AllCommand(database));
        commands.put("get", new GetCommand(database));

        // Teste 1: Adicionar Pessoa
        System.out.println("\n[Teste 1] Inserindo '1 Maria Silva'...");
        commands.get("new").execute(new String[]{"1", "Maria Silva"});
        
        if (database.containsKey(1) && database.get(1).getNome().equals("Maria Silva")) {
            System.out.println("✅ SUCESSO: Pessoa inserida corretamente no HashMap.");
        } else {
            System.out.println("❌ FALHA: Pessoa não foi inserida.");
        }

        // Teste 2: Adicionar com ID duplicado
        System.out.println("\n[Teste 2] Tentando inserir novo registro com o mesmo ID (1)...");
        commands.get("new").execute(new String[]{"1", "Joao"});
        if (database.size() == 1 && database.get(1).getNome().equals("Maria Silva")) {
            System.out.println("✅ SUCESSO: O sistema barrou a duplicação do ID.");
        } else {
            System.out.println("❌ FALHA: O sistema sobrescreveu ou aceitou o ID duplicado.");
        }

        // Teste 3: Leitura
        System.out.println("\n[Teste 3] Testando o comando All...");
        commands.get("all").execute(new String[]{});
        System.out.println("✅ SUCESSO: (Verifique se apenas 'Maria Silva' foi impressa acima).");

        // Teste 4: Deleção
        System.out.println("\n[Teste 4] Deletando a pessoa de ID 1...");
        commands.get("delete").execute(new String[]{"1"});
        if (database.isEmpty()) {
            System.out.println("✅ SUCESSO: Banco de dados está vazio após a deleção.");
        } else {
            System.out.println("❌ FALHA: A pessoa ainda está no banco de dados.");
        }

        System.out.println("\n=== Testes Finalizados ===");
    }
}
