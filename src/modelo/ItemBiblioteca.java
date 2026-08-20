public abstract class ItemBiblioteca{

private final String codigo;
private final String titulo;
private boolean disponivel;

protect ItemBiblioteca(String codigo, String titulo){ //constructor
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

public abstract String prazo();

public abstract double multa();

}