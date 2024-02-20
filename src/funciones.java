/**
 *
 * @author Verónica 
 * @author Jose
 * @version 1.0
 */

public class funciones {

    /**
     * A partir de un array desordenado y pivote, devuelve un array de números ordenados
     * 
     * @param data Array desordenado
     * @param pivot Número por el que va a cortar el array 
     * @return Devuelve un array de números ordenados
     */
    public static int[] ordenar(int[] data, int pivot) {
        // Si entra una lista que no tiene mas de un elemento la devolvemos inmediatamente (esto afecta sobre todo cuando un puntero selecciona uno de los bordes)
        if( data.length <= 1) {
            return data;
        }
        int pivotTimes = 0; // Necesitamos controlar cuantas veces se repite el pivot para despues añadirlo a la lista cuando las montemos despues de la recursividad
        int nMenores = 0;
        
        // En java al tener arrays fijos debemos conocer de antemano cuantos número habrá en cada sublista
        for (int i = 0; i < data.length; i++) {
            if(data[i] < pivot) {
                nMenores++; // n números menores que el pivot
            } else if (data[i] == pivot) {
                pivotTimes++; // n números iguales al pivot
            }
        }

        // Creamos las dos sublistas a partir de el valor nMenores
        int[] menores = new int[nMenores];
        int[] mayores = new int[data.length - (nMenores + pivotTimes)];// El número de n mayores es el resultado de la resta de los menores más el pivot
        
        // Dividimos la lista en una sublista de números menores y mayores al pivot
        for (int i = 0, m = 0, M = 0; i < data.length; i++) {
            if(data[i] > pivot ) {
                mayores[M] = data[i]; // Si es mayor que el pivote
                M++;
            } else if (data[i] != pivot) {
                menores[m] = data[i]; // Si es menor que el pivote
                m++;
            }
        }
        
        // Si cualquiera de las dos sublistas tienen mas de un elemento se ordenan recursivamente
        if( menores.length > 1 ||mayores.length > 1) {
            // alteramos el array menores y mayores con la salida recursiva, de no ser asi no se aplicarían los cambios al volver de la recursividad
            menores = ordenarRandomPivot(menores); 
            mayores = ordenarRandomPivot(mayores);
        }

        // Creamos el array donde montaremos la lista montada
        int[] aux = new int[data.length];
        int pos = 0; // Se utiliza para seguir escribiendo en el array donde montamos la lista ordenada sin pisarlo

        // Escribimos la lista de menores en la salida (aux)
        for ( int i = 0; i < menores.length; i++, pos++) {
            aux[pos] = menores[i];
        }
        // Escribimos los pivots necesarios en la salida (aux)
        for ( int i = 0; i < pivotTimes; i++, pos++) {
            aux[pos] = pivot;
        }
        // Escribimos la lista de mayores en la salida (aux)
        for ( int i = 0; i < mayores.length; i++, pos++) {
            aux[pos] = mayores[i];
        }

        return aux;
    }

    /**
     * Ordena un array de números, utilizando un pivote aleatorio
     * 
     * @param data Array desordenado
     * @return Devuelve un array ordenado
     */
    public static int[] ordenarRandomPivot(int[] data) {
        if(data.length == 0) {
            return data;
        }
        int x = (int) (Math.random() * data.length-1);
        return ordenar(data, data[x] );
    }

    /**
     * Ordena un array de números utilizando un pivote eficiente (la media de los números)
     * 
     * @param data Array desordenado
     * @return Devuelve un array ordenado
     */
    public static int[] ordenarEfficientPivot(int[] data) {
        int[] previa = new int[3];
        int pivot = 99999999;
        for (int i = 0; i < previa.length; i++) {
            previa[i] = (int) (Math.random() * data.length-1);
        }
        for (int i = 0; i < previa.length; i++) {
            if(data[previa[i]] < pivot) {
                pivot = data[previa[i]];
            }
        }
        return ordenar(data, pivot);
    }
}
