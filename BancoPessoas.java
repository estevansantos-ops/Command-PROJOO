import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BancoPessoas {
    public static void main(String[] args) {
        // Banco de dados simulado
        Map<Integer, Pessoa> database = new HashMap<>();

        // Inicialização dos comandos
        Map<String, Command> commands = new HashMap<>();
        commands.put("new", new NewCommand(database));
        commands.put("delete", new DeleteCommand(database));
        commands.put("all", new AllCommand(database));
        commands.put("get", new GetCommand(database));

        if (args.length > 0) {
            // Execução via argumentos passados diretamente na chamada
            executeCommand(args, commands);
        } else {
            // Modo interativo
            // Necessário para poder realizar múltiplas operações no banco simulado (HashMap) 
            // sem que o programa seja encerrado (o que esvaziaria o banco de dados em memória).
            System.out.println("Modo interativo iniciado. Digite 'exit' para sair.");
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("> ");
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
                if (!input.isEmpty()) {
                    String[] inputArgs = input.split("\\s+");
                    executeCommand(inputArgs, commands);
                }
            }
            scanner.close();
        }
    }

    private static void executeCommand(String[] args, Map<String, Command> commands) {
        String commandName = args[0].toLowerCase();
        Command command = commands.get(commandName);

        if (command != null) {
            String[] commandArgs = Arrays.copyOfRange(args, 1, args.length);
            command.execute(commandArgs);
        } else {
            System.out.println("Comando desconhecido: " + commandName);
        }
    }
}
