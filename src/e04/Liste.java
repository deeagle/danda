package e04;

class Liste
{
   private ListElement kopf;
   private ListElement aktuell;
   private ListElement vorgaenger;


   boolean istLeer()
   {
      return kopf == null;
   }


   void durchlaufe()
   {
      // Die lokale Variable elem verweist auf das gerade betrachtete Listenelement.
      ListElement elem = kopf;
      while (elem != null)
      {
         // bearbeite aktuelles Element, z.B.
         System.out.print(elem.getDaten() + " ");
         // gehe ein Element weiter
         elem = elem.getNaechstes();
      }
      System.out.println();
   }

   int zaehleElemente()
   {
      int counter =0;
      ListElement elem = kopf;
      while(elem != null){
         ++counter;
         elem = elem.getNaechstes();
      }
      return counter;
   }


   boolean finde(int einObject)
   {
      vorgaenger = null;
      aktuell = kopf;
      while (aktuell != null)
      {
         if (einObject == aktuell.getDaten())
            return true;
         else
         {
            vorgaenger = aktuell;
            aktuell = aktuell.getNaechstes();
         }
      }
      return false;
   }

   // letztes und vorletztes Listenelement ermitteln
   void findeEnde()
   {
       vorgaenger = null;
       aktuell = kopf;
       while (aktuell.getNaechstes() != null)
       {
               vorgaenger = aktuell;
               aktuell = aktuell.getNaechstes();
       }
   }


   int getAktuelleDaten()
   {
      // aktuelles Element muss vorhanden sein
      if (aktuell == null)
         throw new NullPointerException("kein aktuelles Element");

      return aktuell.getDaten();
   }

   int getKopfDaten()
   {
       return kopf.getDaten();
   }

   int getEndeDaten()
   {
       findeEnde();
       return aktuell.getDaten();
   }


   void einfuegeKopf(int neuesObject)
   {
       if(kopf != null){
           ListElement neu = new ListElement(neuesObject, kopf);
           aktuell = neu;
           kopf = neu;
           vorgaenger = null;
       }else{
           ListElement neu = new ListElement(neuesObject,null);
           aktuell = neu;
           kopf = neu;
           vorgaenger = null;
       }

   }

   void einfuegeHinter(int neuesObject)
   {
      // Vorhandenes Element muss angegeben sein
      if (aktuell == null)
         throw new NullPointerException();

      // Einfuegen hinter Element aktuell
      ListElement neu =
         new ListElement(neuesObject, aktuell.getNaechstes());
      aktuell.setNaechstes(neu);
   }

   void einfuegeVor(int neuesObject)
   {
       if (aktuell == null)
           throw new NullPointerException();
       ListElement neu = new ListElement(neuesObject,aktuell);

   }

   void einfuegeEnde(int neuesObject)
   {
       findeEnde();
       ListElement neu = new ListElement(neuesObject,null);
       aktuell.setNaechstes(neu);
       vorgaenger = aktuell;
       aktuell = neu;
   }


   void loescheNachfolger()
   {
       ListElement elem = aktuell.getNaechstes().getNaechstes();
       aktuell.setNaechstes(elem);
   }

   void loescheElement()
   {
       ListElement elem = aktuell.getNaechstes();
       vorgaenger.setNaechstes(elem);
   }

   void loescheKopf()
   {
       kopf = kopf.getNaechstes();
   }

   void loescheEnde()
   {
       vorgaenger = null;
       aktuell = kopf;
       if(aktuell.getNaechstes() == null){
           kopf = null;
           aktuell = null;
           vorgaenger = null;
       }else{
           ListElement vorvor = vorgaenger;
           while (aktuell.getNaechstes() != null)
           {
               vorvor = vorgaenger;
               vorgaenger = aktuell;
               aktuell = aktuell.getNaechstes();
           }
           aktuell = vorgaenger;
           vorgaenger = vorvor;
           aktuell.setNaechstes(null);
       }


   }

}
