import java.util.Map;

public class NewCommand implements Command {
    private Map<Integer, Pessoa> database;

    public NewCommand(Map<Integer, Pessoa> database) {
        this.database = database;
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: new <id> <nome>");
            return;
        }
        try {
            int id = Integer.parseInt(args[0]);
            String nome = args[1];
            // Se o nome tiver espaços, precisamos juntar os args restantes
            if (args.length > 2) {
                StringBuilder sb = new StringBuilder(nome);
                for (int i = 2; i < args.length; i++) {
                    sb.append(" ").append(args[i]);
                }
                nome = sb.toString();
            }

            if (database.containsKey(id)) {
                System.out.println("Erro: Já existe uma pessoa com o ID " + id);
            } else {
                database.put(id, new Pessoa(id, nome));
                System.out.println("Pessoa adicionada com sucesso: ID=" + id + ", Nome=" + nome);
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: O ID deve ser um número inteiro.");
        }
    }
}
