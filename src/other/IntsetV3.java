package other;

public class IntsetV3 {
  /**
  * Kapazit�t f�r Intset-Objekte
  */
  static final int N = 10;
  
  /**
  * Array f�r die Elemente der Menge vom Typ Intset
  * 
  */
  int daten[];
  
  /**
  * aktuelle Anzahl g�ltiger Daten im Array
  */
  int anzahlElemente;
  
  /**
  * Konstruktor f�r Intset
  * 
  * @return Referenz auf Intset Objekt als int[N] mit Kapazit�t N
  */
  public static IntsetV3 empty() {
    IntsetV3 menge = new IntsetV3();
    menge.daten = new int[N];
    menge.anzahlElemente = 0;
    return menge;
  }
  
  /**
  * F�gt eine gegebenenes Element sortiert in eine Menge ein
  * @param menge - Menge bestehend aus int Elementen
  * @param element - int
  * @return Menge menge um das Element element erweitert, falls menge gro� genug; andernfalls menge unver�ndert
  */
  public static IntsetV3 insert(IntsetV3 menge, int element) {
    if (isEmpty(menge)) {
      menge.daten[0] = element;
      menge.anzahlElemente++;
    } else {
      System.out.println("menge: "); 
      ausgabe(menge);
      System.out.println("element: " + element);
      System.out.println("anzahlElemente vor dem Einfuegen: " + menge.anzahlElemente);
      int einfuegepos = binsuch(menge, element, 0, menge.anzahlElemente - 1);
      if (menge.daten[einfuegepos] == element) // Element bereits
      // enthalten
      return menge;
      else {
        if (menge.anzahlElemente == menge.daten.length)
        System.out.println("Feld ist voll !!!");
        else {
          if (menge.daten[einfuegepos] < element)
          einfuegepos++;
          shiftright(menge, einfuegepos);
          menge.daten[einfuegepos] = element;
          menge.anzahlElemente++;
        }
      }
    }
    return menge;
  }
  
  /**
  * L�scht ein Vorkommen eines gegebenen Elementes in einer Menge
  * @param menge - Menge vom Typ IntsetV3
  * @param element - int
  * @return Referenz auf menge, bei der alle Vorkommen von element gel�scht sind; Gr��e der menge wird angepasst
  */
  public static IntsetV3 delete(IntsetV3 menge, int element) {
    if (isEmpty(menge))
    return menge;
    else {
      int loeschpos = binsuch(menge, element, 0, menge.anzahlElemente - 1);
      if (menge.daten[loeschpos] != element)//Abfangen 
      return menge;
      else {
        shiftleft(menge, loeschpos);
        menge.anzahlElemente--;
        return menge;
      }
    }
  }
  
  /**
  * Pr�ft, ob ein Element in einer gegebenen Menge enthalten ist
  * @param menge - Menge vom Typ IntsetV3
  * @param element - int
  * @return TRUE, wenn element in menge vorhanden; andernfalls FALSE
  */
  public static boolean contains(IntsetV3 menge, int element) {
    int position = binsuch(menge, element, 0, menge.anzahlElemente - 1);
    return menge.daten[position] == element;
  }
  
  /**
  * Pr�ft, ob eine Menge die leere Menge ist
  * @param menge
  * @return TRUE, wenn menge die leere Menge; anderfalls FALSE
  */
  public static boolean isEmpty(IntsetV3 menge) {
    return menge.anzahlElemente == 0;
  }
  
  /**
  * L�scht Element aus Menge menge an Position position
  * @param menge 
  * @param position 
  */
  private static void shiftleft(IntsetV3 menge, int position) {
    for (int i = position; i < menge.anzahlElemente - 1; i++)
    menge.daten[i] = menge.daten[i + 1];
  }
  
  /**
  * Shiftet alle Elemente der Menge menge ab Position position eins nach rechts
  * @param menge
  * @param position
  */
  private static void shiftright(IntsetV3 menge, int position) {
    for (int i = menge.anzahlElemente; i > position; i--)
    menge.daten[i] = menge.daten[i - 1];
  }
  
  /**
  * Sucht das Element element in IntsetV3 menge zwischen den Positionen low und high
  * @param menge
  * @param element
  * @param low
  * @param high
  * @return Position in IntsetV3, an der das Element vorkommt oder eingef�gt wird 
  */
  private static int binsuch(IntsetV3 menge, int element, int low, int high) {
    int mitte = (low + high)/2;
    if (menge.daten[mitte] != element && low < high) {
      
      if (menge.daten[mitte] < element)
      return binsuch(menge, element, mitte + 1, high);
      else
      return binsuch(menge, element, low, mitte - 1);
    } else
    return mitte;
  }
  
  /**
  * Ausgabe der Elemente des Typs IntsetV3 menge auf STDOUT
  * @param menge
  */
  public static void ausgabe(IntsetV3 menge) {
    for (int i = 0; i < menge.anzahlElemente; i++) {
      System.out.print(menge.daten[i]+ " ");
    }
    System.out.println("\n" + "-------------------------");
    
  }
  
    
  
  public static void main(String[] args) {
    IntsetV3 menge;
    boolean leereMengeTest;
    
    menge = empty();
    menge = insert(menge, 1);
    ausgabe(menge);
    menge = insert(menge, 3);
    ausgabe(menge);
    menge = insert(menge, 0);
    ausgabe(menge);
    menge = insert(menge, 4);
    ausgabe(menge);
    menge = insert(menge, 4); 
    ausgabe(menge);
    menge = insert(menge, 2);
    ausgabe(menge);
    menge = delete(menge, 4);
    ausgabe(menge);
    menge = delete(menge, 6);
    ausgabe(menge);
    menge = delete(menge, 1);
    ausgabe(menge);
    
    leereMengeTest = isEmpty(menge);
    System.out.println("leereMengeTest: " + leereMengeTest);
    
    IntsetV3 leereMenge = empty();
    
    System.out.println("1.te Ausgabe:");
    System.out.println("Leere Menge: " + leereMenge);
    
    System.out.println("2.te Ausgabe:");
    ausgabe(leereMenge);
    
    System.out.println("3.te Ausgabe:");
    for (int i = 0; i<leereMenge.daten.length; i++)
    System.out.print( leereMenge.daten[i] + " ");
    
    System.out.println("\n\n Fertig!");
    
    
    
  }
}