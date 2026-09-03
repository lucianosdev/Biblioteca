package biblioteca;

public class Biblioteca {

    private ItemBiblioteca[] acervo;
    private Usuario[] usuarios;

    private int quantidadeItens;
    private int quantidadeUsuarios;

    public Biblioteca(int capacidadeAcervo, int capacidadeUsuarios) {
        acervo = new ItemBiblioteca[capacidadeAcervo];
        usuarios = new Usuario[capacidadeUsuarios];

        quantidadeItens = 0;
        quantidadeUsuarios = 0;
    }

    public void cadastrarItem(ItemBiblioteca item) {
        if (quantidadeItens < acervo.length) {
            acervo[quantidadeItens] = item;
            quantidadeItens++;

            System.out.println("Item cadastrado: " + item.getTitulo());
        } else {
            System.out.println("Acervo cheio.");
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        if (quantidadeUsuarios < usuarios.length) {
            usuarios[quantidadeUsuarios] = usuario;
            quantidadeUsuarios++;

            System.out.println("Usuário cadastrado: " + usuario.getNome());
        } else {
            System.out.println("Limite de usuários atingido.");
        }
    }

    public void emprestar(String codigo, Usuario usuario) {

        if (!usuario.podeEmprestar()) {
            System.out.println(
                    "Empréstimo recusado para " + usuario.getNome()
                            + ": limite de itens atingido."
            );
            return;
        }

        for (int i = 0; i < quantidadeItens; i++) {

            if (acervo[i].getCodigo().equals(codigo)) {

                if (!acervo[i].isDisponivel()) {
                    System.out.println("Item indisponível.");
                    return;
                }

                acervo[i].emprestar();
                usuario.registrarEmprestimo();

                System.out.println(
                        "Empréstimo realizado com sucesso!"
                );

                System.out.println(
                        "Usuário: " + usuario.getNome()
                );

                System.out.println(
                        "Item: " + acervo[i].getTitulo()
                );

                System.out.println(
                        "Prazo: " + acervo[i].getPrazoDias() + " dias."
                );

                return;
            }
        }

        System.out.println("Item não encontrado.");
    }

    public void devolver(String codigo, Usuario usuario) {

        for (int i = 0; i < quantidadeItens; i++) {

            if (acervo[i].getCodigo().equals(codigo)) {

                if (acervo[i].isDisponivel()) {
                    System.out.println("Este item já está disponível.");
                    return;
                }

                acervo[i].devolver();
                usuario.registrarDevolucao();

                System.out.println(
                        "Devolução realizada com sucesso!"
                );

                System.out.println(
                        "Item: " + acervo[i].getTitulo()
                );

                return;
            }
        }

        System.out.println("Item não encontrado.");
    }

    public void listarAcervo() {

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");

        for (int i = 0; i < quantidadeItens; i++) {
            System.out.println(acervo[i]);
        }

        System.out.println("===============================\n");
    }
}