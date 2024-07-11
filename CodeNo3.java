import java.util.Arrays;

public class CodeNo3 {

    public static void main(String[] args) {
        // Ejemplos de conjuntos de monedas
        int[] coins1 = {5, 7, 1, 1, 2, 3, 22};
        int[] coins2 = {1, 1, 1, 1, 1};
        int[] coins3 = {1, 5, 1, 1, 1, 10, 15, 20, 100};

        // Obtener el mínimo cambio para cada conjunto de monedas
        int result1 = minimumChange(coins1);
        int result2 = minimumChange(coins2);
        int result3 = minimumChange(coins3);

        // Imprimir los resultados
        System.out.println("Cambio mínimo para coins1: " + result1); // Debería imprimir 20
        System.out.println("Cambio mínimo para coins2: " + result2); // Debería imprimir 6
        System.out.println("Cambio mínimo para coins3: " + result3); // Debería imprimir 55
    }

    /**
     * Calcula el mínimo cambio que no se puede dar usando el conjunto de
     * monedas dado.
     *
     * @param coins Arreglo de enteros positivos que representan los valores de
     * las monedas disponibles.
     * @return El mínimo cambio que no se puede dar con las monedas disponibles.
     */
    public static int minimumChange(int[] coins) {
        Arrays.sort(coins); // Ordenar el arreglo de monedas

        int minChange = 1; // Iniciar con el mínimo cambio posible, que es 1

        for (int coin : coins) {
            if (coin > minChange) {
                break; // No podemos formar minChange usando coin, salir del bucle
            }
            minChange += coin; // Actualizar minChange sumando el valor de la moneda actual
        }

        return minChange;
    }
}
