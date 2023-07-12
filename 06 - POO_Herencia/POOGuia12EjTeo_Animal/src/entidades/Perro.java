package entidades;

public class Perro extends Animal{

    @Override
    public void hacerRuido() {
        super.hacerRuido();
        System.out.println("Guau guau");
    }
    
}
