import java.util.Map;

public class DeleteCommand implements Command {
    private Map<Integer, Pessoa> database;

    public DeleteCommand(Map<Integer, Pessoa> database) {
        this.database = database;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: delete <id>");
            return;
        }
        try {
            int id = Integer.parseInt(args[0]);
            if (database.remove(id) != null) {
                System.out.println("Pessoa com ID " + id + " removida com sucesso.");
            } else {
                System.out.println("Erro: Pessoa com ID " + id + " não encontrada.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        }
    }
}
