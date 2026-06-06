import java.util.Scanner;

// TAREA - CALCULADORA TRIGONOMÉTRICA INVERSA

public class CalculadoraTrigonometricaInversa {

    // Funciones trigonométricas inversas
    static double arcoseno(double valor) {
        return Math.toDegrees(Math.asin(valor));
    }

    static double arcocoseno(double valor) {
        return Math.toDegrees(Math.acos(valor));
    }

    static double arcotangente(double valor) {
        return Math.toDegrees(Math.atan(valor));
    }


    //Imprimir menú de opciones
    static void Menu() {
        System.out.println("  Funciones Inversas:");
        System.out.println("    1. Arcoseno");
        System.out.println("    2. Arcocoseno");
        System.out.println("    3. Arcotangente");
        System.out.println("    4. Apagar calculadora");
        System.out.println();

        System.out.print("  Seleccione la operación que desea utilizar: ");
    }

    public static void main(String[] args) { 

        Scanner scanner = new Scanner(System.in); //Para leer valores desde la terminal
        int operacion = -1;

        while (operacion != 4) {

            System.out.println();
            Menu();

            while (!scanner.hasNextInt()) {
                System.out.print("Debe ingresar un número entero, inténtelo nuevamente: ");
                scanner.next();
            }
            
            System.out.print("Ingrese el valor: ");

            //Validar que haya entrado un número que se pueda convertir a entero (no letras ni signos)
            while (!scanner.hasNextDouble()) {
                System.out.print("Debe ingresar un número válido: ");
                scanner.next(); //Eliminar el número inválido
            }

            operacion = scanner.nextInt();

            //Apagar calculadora con la opción 4
            if (operacion == 4) {
                System.out.println("\nCalculadora apagada");
                break;
            }

            //Validar que se escoja una opción válida
            if (operacion < 1 || operacion > 3) {
                System.out.println("Debe seleccionar una opción del 1 al 4");
                continue;
            }

            double valor = scanner.nextDouble(); //Guardar el valor como double

            // Restricciones del dominio de arcsin y de arccos
            if ((operacion == 1 || operacion == 2) && //Definir el rango permitido
                (valor < -1 || valor > 1)) {

                System.out.println("Debe ingresar un valor entre -1 y 1.");
                continue;
            }
            
            //Declarar variables para más adelante
            double resultado = 0;
            String funcion = "";

            switch (operacion) {

                case 1:
                    resultado = arcoseno(valor);
                    funcion = "arcsin(" + valor + ")";
                    break;

                case 2:
                    resultado = arcocoseno(valor);
                    funcion = "arccos(" + valor + ")";
                    break;

                case 3:
                    resultado = arcotangente(valor);
                    funcion = "arctan(" + valor + ")";
                    break;
            }

            System.out.printf("Resultado: %s = %.2f°%n", //Imprimir resultado de la operación
                    funcion, resultado); 
        }

        scanner.close(); //Cerrar scanner 
    }
}