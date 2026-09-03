package biblioteca;

public abstract class Usuario {

    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {

        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("Nome obrigatório");
        }

        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }

    public abstract int getLimiteItens();

    public boolean podeEmprestar() {
        return quantidadeEmprestada < getLimiteItens();
    }

    public void registrarEmprestimo() {
        quantidadeEmprestada++;
    }

    public void registrarDevolucao() {
        if (quantidadeEmprestada > 0) {
            quantidadeEmprestada--;
        }
    }
}