public class Contato {
    private int id;
    private String nome;
    private String telefone;
    private static int identificador = 0;

    public Contato(String nome, String telefone){
        Contato.identificador++;
        this.id = identificador;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public static int getIdentificador() {
        return identificador;
    }

    public String info() {
        return "\n\n[id: " + this.id +
                ", nome: " + this.nome +
                ", telefone: " + this.telefone +
                "]\n\n";
    }
}
