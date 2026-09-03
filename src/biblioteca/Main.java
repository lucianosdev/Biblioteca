package biblioteca;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca(10, 10);

        // =========================
        // CADASTRO DOS ITENS
        // =========================

        Livro livro1 = new Livro("L001", "Java para Iniciantes");
        Livro livro2 = new Livro("L002", "Programação Orientada a Objetos");

        Revista revista1 = new Revista("R001", "Tecnologia Hoje");
        Revista revista2 = new Revista("R002", "Mundo da Programação");

        DVD dvd = new DVD("D001", "Java em Vídeo");



        biblioteca.cadastrarItem(livro1);
        biblioteca.cadastrarItem(livro2);
        biblioteca.cadastrarItem(revista1);
        biblioteca.cadastrarItem(revista2);

        biblioteca.cadastrarItem(dvd);

        // =========================
        // CADASTRO DOS USUÁRIOS
        // =========================

        Aluno aluno = new Aluno("João");
        Professor professor = new Professor("Professor Pedro");

        biblioteca.cadastrarUsuario(aluno);
        biblioteca.cadastrarUsuario(professor);

        // =========================
        // LISTANDO O ACERVO
        // =========================

        biblioteca.listarAcervo();

        // =========================
        // EMPRÉSTIMO BEM-SUCEDIDO
        // =========================

        System.out.println("===== TESTE DE EMPRÉSTIMO =====");

        biblioteca.emprestar("L001", aluno);

        // =========================
        // OUTROS EMPRÉSTIMOS
        // =========================

        biblioteca.emprestar("L002", aluno);
        biblioteca.emprestar("R001", aluno);

        // =========================
        // TENTATIVA ALÉM DO LIMITE
        // =========================

        System.out.println("\n===== TESTE DE LIMITE =====");

        biblioteca.emprestar("R002", aluno);

        // =========================
        // LISTANDO NOVAMENTE
        // =========================

        biblioteca.listarAcervo();

        // =========================
        // DEVOLUÇÃO
        // =========================

        System.out.println("===== TESTE DE DEVOLUÇÃO =====");

        biblioteca.devolver("L001", aluno);

        biblioteca.listarAcervo();
    }
}