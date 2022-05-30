public class Agenda {

    private Contato[] contatos;

    public Agenda() {
        contatos = new Contato[2];
    }

    public void adicionarContato(Contato c) throws AgendaCheiaException {
        boolean cheia = true;
        for (int i = 0; i < contatos.length; i++){
            if (contatos[i] == null){
                contatos[i] = c;
                cheia = false;
                break;
            }
        }
        if (cheia){
            throw new AgendaCheiaException();
        }
    }

    public void consultarContato(String nome) throws ContatoNaoExisteException {
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i].getNome().equalsIgnoreCase(nome)){
                System.out.println(contatos[i].info());
                return;
            }
        }
    throw new ContatoNaoExisteException(nome);
    }
    public void lista(){
        System.out.println("Lista de contatos cadastradados:");
        for (Contato contato : contatos) {
            System.out.println("[id: " + contato.getId() +
                    ", nome: " + contato.getNome() +
                    ", telefone: " + contato.getTelefone() +
                    "]");
        }
    }
}

