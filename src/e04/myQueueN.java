package e04;

import util.TastaturEingabe;
/*
eine Queue wird mit Hilfe eines Array implementiert, wobei das Array zirkulaer genutzt wird,
d.h. sowohl der Anfang als auch das Ende der Queue wandern durch das Array. Dazu werden
die Positionen des Anfangs und des Endes in Attributen gehalten. Liegen Anfang und Ende
auf der gleichen Position im Array, so kann die Queue entweder voll oder leer sein, deshalb
gibt es ein weiteres Attribut, das die Anzahl der Elemente beinhaltet und damit genutzt werden
kann, um zu ueberpruefen, ob die Queue voll ist.
*/

public class myQueueN
{
    final int max = 5;
    int feld[] = new int[max];	// Schlange fuer max Zahlen erzeugen
    int first, last;			// "Indexzeiger" auf das erste bzw letzte Element
    int anzahl;					// AnzahlElemente-Zaehler

    myQueueN()               // Konstruktor
    {
        first = 0;			// erstes Element an Pos. 0
        last = 0;			// letztes Element an Pos. 0
        anzahl = 0;
    }

    boolean istLeer()
    {
        return first==last && anzahl != max;
    }

    boolean istVoll()
    {
        return anzahl == max;
    }

    public int front()
    {
        return feld[first];
    }


    public void enqueue(int elem)
    {
        if(!istVoll()){
            anzahl++;
            feld[last] = elem;
            if(++last >= max){
                last = 0;
            }
        }else{
            System.out.println("Queue voll!");
        }

    }
    public void dequeue()
    {
        if(!istLeer()){
            anzahl--;
            if(++first >= max){
                first = 0;
            }
        }else{
            System.out.println("Queue leer!");
        }
    }

    public void show()
    {
        int i = 0;
        int counter = first;
        System.out.print(feld[counter]+ " ");
        while(i < anzahl-1){
            if(++counter >= max){
                counter = 0;
            }
            System.out.print(feld[counter]+" ");
            ++i;
        }
        System.out.println();
    }


    public static void main(String args[])
    {
        myQueueN queue = new myQueueN();

        boolean doneFlag = false;

        while(!doneFlag)
        {
            System.out.println("\n1 Zahl in Queue ablegen");
            System.out.println("2 Zahl aus Queue holen");
            System.out.println("3 gesamte Queue anzeigen");
            System.out.println("jede andere Eingabe beendet das Programm\n");

            int i = TastaturEingabe.readInt("\nBitte waehlen Sie: ");

            switch(i)
            {
                case 1:
                {
                    i = TastaturEingabe.readInt("Bitte einen int-Wert eingeben: ");
                    queue.enqueue(i);
                    break;
                }
                case 2:
                {
                    queue.dequeue();
                    break;
                }
                case 3:
                {
                    queue.show();
                    break;
                }
                default:
                {
                    doneFlag = true;
                }
            }
        }
    }
}
