package testrectangulo;

import Entidad.Rectangulo;

public class TestRectangulo {

    public static void main(String[] args) {
        Rectangulo rect1 = new Rectangulo();
        rect1.crearRectangulo();
        System.out.println("La Base del Rectangulo es " + rect1.getBase());
        System.out.println("La Altura del Rectangulo es " + rect1.getAltura());

        System.out.println("La Superficie del Rectangulo es " + rect1.calcularSuperficie());
        System.out.println("El Perimetro del Rectangulo es " + rect1.calcularPerimetro());

        System.out.println("El Rectangulo se veria asi: ");
        rect1.dibujarRectangulo();
    }

}
