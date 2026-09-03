package biblioteca;

public abstract class ItemBiblioteca {

    private String codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(String codigo, String titulo) {

        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Código obrigatório");
        }
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título obrigatório");
        }

        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        disponivel = false;
    }

    public void devolver() {
        disponivel = true;
    }

    public abstract int getPrazoDias();

    public abstract double calcularMulta(int diasAtraso);

    @Override
    public String toString() {
        return "Código: " + codigo
                + " | Título: " + titulo
                + " | Disponível: " + disponivel;
    }
}