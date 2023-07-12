package entidades;

public class Gato extends Animal{

    @Override
    public void hacerRuido() {
        super.hacerRuido();
        System.out.println("Miau, miau");
    }

}
