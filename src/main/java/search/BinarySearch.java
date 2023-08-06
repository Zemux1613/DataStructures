package search;

public class BinarySearch {

  public static void main(String[] args) {
    int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
    System.out.println("Index: " + search(numbers, 6));
  }

  /**
   * Naiver Algorithmus zur Suche.
   *
   * >> O(n)
   *
   * @param numbers Sortierte Datenstruktur (Array, List)
   * @param value   Element was gefunden werden soll
   * @return index des Elements im gegebenen Array, sonst -1 für Elemente welche nicht im Array
   * vorkommen
   */
  private static int naiveSuche(int[] numbers, int value) {
    int index = 0;
    for (int number : numbers) {
      if (number == value) {
        return index;
      }
      index++;
    }
    return -1;
  }

  /**
   * >> O(log_2(n))
   *
   * @param numbers Sortierte Datenstruktur (Array, List)
   * @param value   Element was gefunden werden soll
   * @return index des Elements im gegebenen Array, sonst -1 für Elemente welche nicht im Array
   * vorkommen
   */
  private static int search(int[] numbers, int value) {
    /*
     * _________________________
     * |   |   |   |   |   |   |
     * | 1 | 2 | 3 | 4 | 5 | 6 |
     * |___|___|___|___|___|___|
     *   ^                   ^
     *   |                   |
     *  low/                high/
     *  Erstes Element   Letztes Element
     *
     * Solange low < high  --> low != high, entsprechend muss der Suchraum optimiert werden
     * Wenn low = high --> Das gesuchte Element wurde gefunden, fertig!
     *
     */
    int low = 0;
    int high = numbers.length - 1;
    // low == high, ist das Abbruchkriterium, weil dann von links und von rechts auf die Mitte
    // zumarschiert wurde und das Element nicht gefunden wurde
    while (low <= high) {
      int mid = (low + high) / 2;
      if (numbers[mid] == value) {
        // Gebe den index heraus an welchen das Element ist und höre mit der Schleife auf
        return mid;
      } else if (numbers[mid] < value) {
        // erhöhe die untere Schranke um 1, mache alles nochmal
        low = ++mid;
      } else if (numbers[mid] > value) {
        // minimiere die obere Schranke um 1, mache alles nochmal
        high = --mid;
      }
    }
    // Das Element ist nicht in der gegebenen Datenstruktur(int[]) enthalten
    return -1;
  }

}
