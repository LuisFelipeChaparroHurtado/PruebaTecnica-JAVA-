import java.util.ArrayList;
import java.util.List;

public class CodeNo1 {

    public static void main(String[] args) {
        // Ejemplos con S = 2
        List<Integer> lista1 = List.of(1, 2, 3, 4, 5, 6);  // -> [1]
        List<Integer> lista2 = List.of(10, 20, 30, 40);    // -> [10]
        List<Integer> lista3 = List.of(6);                 // -> []
        List<Integer> lista4 = List.of(66);                // -> []
        List<Integer> lista5 = List.of(65);                // -> []
        List<Integer> lista6 = List.of(6, 2, 1);           // -> [1]
        List<Integer> lista7 = List.of(60, 6, 5, 4, 3, 2, 7, 7, 29, 1);  // -> [1]

        int S = 2;

        List<Integer> resultado1 = procesarLista(lista1, S);
        List<Integer> resultado2 = procesarLista(lista2, S);
        List<Integer> resultado3 = procesarLista(lista3, S);
        List<Integer> resultado4 = procesarLista(lista4, S);
        List<Integer> resultado5 = procesarLista(lista5, S);
        List<Integer> resultado6 = procesarLista(lista6, S);
        List<Integer> resultado7 = procesarLista(lista7, S);

        imprimirLista(resultado1);  // Debería imprimir: [1]
        imprimirLista(resultado2);  // Debería imprimir: [10]
        imprimirLista(resultado3);  // Debería imprimir: []
        imprimirLista(resultado4);  // Debería imprimir: []
        imprimirLista(resultado5);  // Debería imprimir: []
        imprimirLista(resultado6);  // Debería imprimir: [1]
        imprimirLista(resultado7);  // Debería imprimir: [1]
    }

    /**
     * Procesa una lista de números, filtrando los dígitos de cada número según
     * un valor maximo y luego invierte la lista resultante.
     *
     * @param lista La lista de números a procesar.
     * @param S El valor maximo para filtrar los dígitos.
     * @return La lista procesada e invertida.
     */
    public static List<Integer> procesarLista(List<Integer> lista, int S) {

        // Se crea una nueva lista resultado que almacenará los números procesados.
        List<Integer> resultado = new ArrayList<>();

        for (int num : lista) {
            int nuevoNum = filtrarDigitos(num, S);
            if (nuevoNum != -1) {
                resultado.add(nuevoNum);
            }
        }

        // Invertir la lista manualmente
        invertirLista(resultado);

        return resultado;
    }

    /**
     * Filtra los dígitos de un número, dejando solo aquellos menores que el
     * valor maximo.
     *
     * @param num El número a filtrar.
     * @param S El valor maximo.
     * @return El número filtrado o -1 si todos los dígitos son mayores o
     * iguales al numero maximo.
     */
    public static int filtrarDigitos(int num, int S) {

        // Se crea un StringBuilder llamado nuevoNum para construir el nuevo número filtrado.
        StringBuilder nuevoNum = new StringBuilder();
        String numStr = String.valueOf(num);

        for (char c : numStr.toCharArray()) {
            if (Character.getNumericValue(c) < S) {
                // Si el valor numérico del carácter es menor que el umbral S, se añade al StringBuilder nuevoNum.
                nuevoNum.append(c);
            }
        }

        // Se verifica si el StringBuilder nuevoNum está vacío (no se añadieron dígitos menores que S).
        // Si está vacío, se retorna -1.
        if (nuevoNum.length() == 0) {
            return -1;
        }

        return Integer.parseInt(nuevoNum.toString());
    }

    /**
     * Invierte una lista de enteros in situ.
     *
     * @param lista La lista a invertir.
     */
    public static void invertirLista(List<Integer> lista) {
        int inicio = 0;
        int fin = lista.size() - 1;

        while (inicio < fin) {
            // Se guarda el valor del elemento en la posición inicio en una variable temporal temp.
            int temp = lista.get(inicio);
            // Se sobrescribe el valor en la posición inicio con el valor en la posición fin.
            lista.set(inicio, lista.get(fin));
            // Se sobrescribe el valor en la posición fin con el valor temporal temp.
            lista.set(fin, temp);

            // Se incrementa inicio (inicio++), moviéndolo hacia la derecha.
            inicio++;
            // Se decrementa fin (fin--), moviéndolo hacia la izquierda.
            fin--;
        }
    }

    /**
     * Imprime una lista de enteros.
     *
     * @param lista La lista a imprimir.
     */
    public static void imprimirLista(List<Integer> lista) {
        System.out.println(lista);
    }
}
