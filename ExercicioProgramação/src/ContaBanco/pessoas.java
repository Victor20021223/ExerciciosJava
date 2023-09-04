package ContaBanco;
public abstract class pessoas{
    private String nome;
    private String CPF;

    public pessoas() {
    }

    public pessoas(String nome, String cpf) {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public abstract String toString(String cpf, String nome);
}