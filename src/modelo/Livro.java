public class Livro extends ItemBiblioteca{
    private int prazo = 14;
    private double multa = 0.50;

   super Livro(String codigo, String titulo);

    @Override
    public String prazo(int prazo){
        if (prazo > this.prazo){
            System.out.println("Passou do prazo de entrega! A multa será aplicada!");
        }else{
            System.out.println("Prazo para devolução em dia!");
        }
        return prazo;
    }

    @Override
    public double multa(int prazo){
        int dias = prazo - this.prazo;
        double resultado = multa * dias;
        System.out.println("Multado com total de: " + resultado);
    }


}