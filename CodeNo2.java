import java.util.ArrayList;
import java.util.List;

public class CodeNo2 {

    public static void main(String[] args) {
        // Ejemplos con S = 2
        int[] array1 = {1, 2, 3, 5, 6, 8, 9};     // -> [1, 4]
        int[] array2 = {-2, -1};                 // -> [1, 4]
        int[] array3 = {-6, -5, 0, 5, 6};        // -> [0]
        int[] array4 = {-10, 10};                // -> []

        int S = 2;

        int[] resultado1 = procesarArray(array1, S);
        int[] resultado2 = procesarArray(array2, S);
        int[] resultado3 = procesarArray(array3, S);
        int[] resultado4 = procesarArray(array4, S);

        imprimirArray(resultado1);  // Debería imprimir: [1, 4]
        imprimirArray(resultado2);  // Debería imprimir: [1, 4]
        imprimirArray(resultado3);  // Debería imprimir: [0]
        imprimirArray(resultado4);  // Debería imprimir: []
    }

    /**
     * Función para procesar un arreglo de enteros, calcular los cuadrados,
     * filtrar los cuadrados dentro del rango [0, S^2] y devolver el arreglo
     * ordenado en orden ascendente.
     *
     * @param array Arreglo de enteros ordenados en orden ascendente
     * @param S Valor límite para el cuadrado de los números
     * @return Arreglo de enteros con los cuadrados ordenados en orden
     * ascendente y filtrados
     */
    public static int[] procesarArray(int[] array, int S) {
        List<Integer> resultado = new ArrayList<>();

        // Calcular los cuadrados y agregar al resultado
        for (int num : array) {
            int cuadrado = num * num;
            if (cuadrado >= 0 && cuadrado <= S * S) {
                resultado.add(cuadrado);
            }
        }

        // Convertir resultado a arreglo y ordenar manualmente
        int[] sortedArray = new int[resultado.size()];
        for (int i = 0; i < resultado.size(); i++) {
            sortedArray[i] = resultado.get(i);
        }

        // Ordenar manualmente sin usar sort
        ordenarArray(sortedArray);

        return sortedArray;
    }

    /**
     * Función para ordenar un arreglo de enteros en orden ascendente utilizando
     * el método de ordenamiento de burbuja.
     *
     * @param array Arreglo de enteros a ordenar
     */
    public static void ordenarArray(int[] array) {
        // Ordenar manualmente sin usar sort
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // Intercambiar elementos
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * Función para imprimir un arreglo de enteros en formato de lista.
     *
     * @param array Arreglo de enteros a imprimir
     */
    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
