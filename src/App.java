/**
 *
 * @author Verónica
 * @author Jose
 * @version 1.0
 */

public class App {
    public static void main(String[] args) throws Exception {
        // creamos la lista de números a ordenar de forma aleatoria
        int[] a = new int[25];
        for (int i = 0; i < a.length; i++) {
             a[i] = (int) (Math.random() * 875 + 1);            
        }

        // Mostramos la lista
        System.out.print("Lista desordenada: ");
        for (int i = 0; i < a.length; i++) {
            if(i != a.length-1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i]);
            }
        }
        System.out.println();

        // Ordenamos la lista
        int[] r = funciones.ordenarRandomPivot(a);

        // Mostramos la lista ordenada
        System.out.print("lista ordenada: ");
        for (int i = 0; i < r.length; i++) {
            if(i != r.length-1) {
                System.out.print(r[i] + ", ");
            } else {
                System.out.print(r[i]);
            }
        }
        System.out.println();

        test(5000);
    }  

    /**
     * Muestra los resultados de la ejecución para hacer una comparativa
     * 
     * @param ejecuciones Cantidades de veces que se va a ejecutar el resultado
     */
    public static void test(int ejecuciones) {

        int[][] data = new int[ejecuciones][25];

        Long dataStart = System.nanoTime();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = (int) (Math.random() * 875 + 1);            
            }
        }
        Long dataEnd = System.nanoTime();

        Long rStart = System.nanoTime(); 
        for (int i = 0; i < data.length; i++) {
            // Ordenamos la lista
            int[] r = funciones.ordenarRandomPivot(data[i]);
        }
        Long rEnd = System.nanoTime();

        Long eStart = System.nanoTime(); 
        for (int i = 0; i < data.length; i++) {
            // Ordenamos la lista
            int[] r = funciones.ordenarEfficientPivot(data[i]);
        }
        Long eEnd = System.nanoTime();

        System.out.println("Resultado: ");
        System.out.println("  Data: ");
        System.out.println("    Duración: " + (dataEnd - dataStart)/1000000);
        System.out.println("  Random: ");
        System.out.println("    Empieza: " + rStart);
        System.out.println("    Termina: " + rEnd);
        System.out.println("    Duración: " + (rEnd - rStart)/1000000);
        System.out.println("  Eficiente: ");
        System.out.println("    Empieza: " + eStart);
        System.out.println("    Termina: " + eEnd);
        System.out.println("    Duración: " + (eEnd - eStart)/1000000);
    }
}
