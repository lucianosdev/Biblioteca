package biblioteca;

public class DVD extends ItemBiblioteca {

    public DVD(String codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int getPrazoDias() {
        return 3;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        return diasAtraso * 2.00;
    }
}