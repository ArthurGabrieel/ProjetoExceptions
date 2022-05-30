public class ContatoNaoExisteException extends Exception{

    private String nomeContato;

    public ContatoNaoExisteException(String nomeContato) {
        this.nomeContato = nomeContato;
    }

    @Override
    public String getMessage() {
        return "\nContato "+ nomeContato +" nao existe na agenda!!!\n\n";
    }
}
