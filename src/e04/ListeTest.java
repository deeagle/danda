package e04;

public class ListeTest
{

   public static void main(String [] args)
   {
      Liste liste = new Liste();

System.out.println("Die Liste sollte leer sein.");
      liste.durchlaufe();
      System.out.println("Anzahl der Listenelemente = " + liste.zaehleElemente());

      liste.einfuegeKopf(3);
      liste.einfuegeKopf(2);
      liste.einfuegeKopf(1);
      liste.einfuegeEnde(4);
      liste.einfuegeEnde(5);
System.out.println("Die Liste sollte jetzt die Elemente 1, 2, 3, 4, 5 enthalten.");
      liste.durchlaufe();
      System.out.println("Anzahl der Listenelemente = " + liste.zaehleElemente());

      liste.loescheKopf();
      liste.loescheEnde();
System.out.println("Die Liste sollte jetzt die Elemente 2, 3, 4 enthalten.");
      liste.durchlaufe();

      liste.loescheKopf();
      liste.loescheEnde();
System.out.println("Die Liste sollte jetzt nur noch das Element 3 enthalten.");
      liste.durchlaufe();

      liste.loescheEnde();
System.out.println("Die Liste sollte jetzt leer sein.");
      liste.durchlaufe();
/*
System.out.println("Jetzt wird eine NullPointerException ausgeloest.");
      liste.loescheKopf();
*/

      liste.einfuegeKopf(5);
      liste.einfuegeKopf(4);
      liste.einfuegeKopf(3);
      liste.einfuegeKopf(2);
      liste.einfuegeKopf(1);
System.out.println("Die Liste sollte jetzt die Elemente 1, 2, 3, 4, 5 enthalten.");
      liste.durchlaufe();

      liste.finde(3);
      // liste.aktuell sollte jetzt auf das Element mit dem Inhalt 3 zeigen.
      liste.einfuegeHinter(33);
System.out.println("Die Liste sollte jetzt die Elemente 1, 2, 3, 33, 4, 5 enthalten.");
      liste.durchlaufe();

      liste.finde(33);
      // liste.aktuell sollte jetzt auf das Element mit dem Inhalt 33 zeigen.
      liste.loescheNachfolger();
System.out.println("Die Liste sollte jetzt die Elemente 1, 2, 3, 33, 5 enthalten.");
      liste.durchlaufe();

      liste.loescheNachfolger();
System.out.println("Die Liste sollte jetzt die Elemente 1, 2, 3, 33 enthalten.");
      liste.durchlaufe();

      // liste.aktuell sollte jetzt den Wert null haben.
      // (Knoten mit Attribut daten == 5 hat keinen Nachfolger.)
System.out.println("Jetzt wird eine NullPointerException ausgeloest.");

      liste.loescheNachfolger();
    }

}