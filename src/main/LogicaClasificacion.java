package main;

import java.util.*;
import java.util.Stack;

public class LogicaClasificacion {

    /**
     * Invierte una cadena de texto utilizando una pila (Stack).
     *
     * @param texto Cadena original a invertir.
     * @return Cadena invertida.
     *
     *         Ejemplo:
     *         Entrada: "Hola Mundo"
     *         Salida: "odnuM aloH"
     */
    public String invertirCadena(String texto) {
        Stack<Character> pila = new Stack<>();
        for (char c : texto.toCharArray()) {
            pila.push(c);
        }
        StringBuilder invertido = new StringBuilder();
         while (!pila.isEmpty()) {
            invertido.append(pila.pop());
        }
        return invertido.toString();
    }
    /**
     * Verifica si los símbolos de paréntesis, corchetes y llaves están bien
     * balanceados.
     *
     * @param expresion Cadena con símbolos.
     * @return true si está balanceada, false en caso contrario.
     *
     *         Ejemplo:
     *         Entrada: "{[()]}"
     *         Salida: true
     */
    public boolean validarSimbolos(String expresion) {
        Stack<Character> pila = new Stack<>();
        for (int i = 0; i < expresion.length(); i++) {
            char character = expresion.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                pila.push(character);
            } else {
                if (pila.isEmpty()) {
                    return false;
                }
                char top = pila.pop();
                if ((character == ')' && top != '(') ||
                (character == '}' && top != '{') ||
                (character == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return pila.isEmpty();
    }
    /**
     * Ordena una pila de enteros en orden ascendente usando otra pila auxiliar.
     *
     * @param pila Pila original con enteros desordenados.
     * @return Lista con los elementos ordenados en orden ascendente.
     *
     *         Ejemplo:
     *         Entrada: [3, 1, 4, 2]
     *         Salida: [1, 2, 3, 4]
     */
    public List<Integer> ordenarPila(Stack<Integer> pila) {
        Stack<Integer> auxiliar = new Stack<>();
        while (!pila.isEmpty()) {
            int top = pila.pop();
            while (!auxiliar.isEmpty() && auxiliar.peek() > top) {
                pila.push(auxiliar.pop());
            }
            auxiliar.push(top);
        }
        List<Integer> resultado = new ArrayList<>();
        while (!auxiliar.isEmpty()) {
            resultado.add(auxiliar.pop());
        }
        return resultado;
    }
    /**
     * Clasifica una lista de enteros separando pares e impares.
     * Usa LinkedList para mantener el orden de inserción.
     *
     * @param original Lista original con enteros.
     * @return Lista con pares primero, luego impares.
     *
     *         Ejemplo:
     *         Entrada: [1, 2, 3, 4, 5, 6]
     *         Salida: [2, 4, 6, 1, 3, 5]
     */
    public List<Integer> clasificarPorParidad(LinkedList<Integer> original) {
        LinkedList<Integer> pares = new LinkedList<>();
        LinkedList<Integer> impar = new LinkedList<>();

        for (Integer numero : original) {
            if (numero % 2 == 0) {
                pares.add(numero);
            } else {
                impar.add(numero);
            }
        }
        pares.addAll(impar);
        return pares;
    }
}
