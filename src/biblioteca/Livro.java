package biblioteca;

public class Livro extends ItemBiblioteca {

    public Livro(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDias() {
        return 14;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 0.50;
    }
}