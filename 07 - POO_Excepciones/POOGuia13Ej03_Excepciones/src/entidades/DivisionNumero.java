package entidades;

public class DivisionNumero {
    /**
     * Metodo que intenta realizar una division, previa conversion de numeros recibidos como String
     * y pasados a enteros.
     * Dos posibles tipos de excepciones 
     * 1. AritmeticException (division por 0)
     * 2. NumberFormarException (intento de pasar una letra a numero)
     * @param n1
     * @param n2 
     */
    public void test(String n1, String n2) {
        try {
            int num1 = Integer.parseInt(n1);
            int num2 = Integer.parseInt(n2);
            double res = (double) num1 / num2;
            System.out.println("EL EL RESULTADO ES " + res);
        }catch(ArithmeticException a){
            System.out.println(a.fillInStackTrace());
        }catch(NumberFormatException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getLocalizedMessage());
        }finally{
            System.out.println("BYE.............");
        }
    }
}
