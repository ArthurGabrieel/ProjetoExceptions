import java.util.Scanner;

public class Main {
    public static Scanner ler = new Scanner(System.in);
    static Agenda agenda = new Agenda();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        int op;
        do {
            menu();
                op = ler.nextInt();
                switch (op) {
                    case 1 -> consultar();
                    case 2 -> adicionar();
                    case 3 -> System.out.println("tchauuuuu");
                    default -> System.out.println(ANSI_YELLOW +"Opcao invalida, tente novamente!"+ ANSI_RESET);
                }
        } while (op != 3);
    }

    private static void menu(){
            System.out.println("\n * * * * * * * * MENU * * * * * * * * *");
            System.out.println("| 1- Consultar um contato existente   |");
            System.out.println("| 2- Adicionar um contato na agenda   |");
            System.out.println("| 3- Encerrar programa                |");
            System.out.println(" * * * * * * * * * * * * * * * * * * *");
    }

    private static void consultar(){
        if (Contato.getIdentificador() == 0){
            System.out.println(ANSI_YELLOW + "Nenhum contato foi cadastrado ainda!\n\n" + ANSI_RESET);
            return;
        }
        try {
            System.out.println("Insira o nome do contato que deseja procurar!");
            String nome = ler.next();
            agenda.consultarContato(nome);
        }catch (ContatoNaoExisteException e){
            System.out.println(ANSI_YELLOW + e.getMessage() + ANSI_RESET);
        }catch (NullPointerException e){
            System.out.println(ANSI_YELLOW + "Contato nao encontrado na agenda!" + ANSI_RESET);
        }
    }
    private static void adicionar() {
        String nome;
        String telefone;

        System.out.println("Criando contato, entre com as informacoes:");
        System.out.print("Nome: ");
        nome = ler.next();

        System.out.print("Telefone: ");
        telefone = ler.next();

        Contato contato = new Contato(nome, telefone);

        try {
            agenda.adicionarContato(contato);
        } catch (AgendaCheiaException e) {
            System.out.println(ANSI_YELLOW + e.getMessage() + ANSI_RESET);
            agenda.lista();
            return;
        }
        System.out.println(contato.info());
    }
}
