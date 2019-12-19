package e02;

public class TwoSix {
    public static void main(String args[]){

        int a[] = new int[10000];
        for(int i = 0; i < 10000;i++){
            a[i] = i;
        }
        //System.out.println(searchBin(a,9999));
        System.out.println(searchBinRek(a,40,0,9999));


    }
    private static int searchBin(int[] a, int b){

        int start = a.length/2;
        int lastRound = 0;
        while(lastRound != start){
            lastRound = start;
            if(b == a[start]){
                return start;
            }
            else if(b < a[start]){
                start = start/2;
            }else{
                start = (a.length-start)/2+start;
            }
        }
        return -1;
    }

    private static int searchBinRek(int a[],int b,int anfang,int ende){
        int grenze = (anfang + ende)/2;

        if(b == a[grenze]){
            return grenze;
        }
        else if(b > a[grenze]){
            return searchBinRek(a,b,grenze+1,ende);
        }
        else if(b < a[grenze]){
            return searchBinRek(a,b,grenze-1,ende);
        }
        else{
            return -1;
        }
    }
}
/*
Die sequentielle Suche (auch lineare Suche genannt) auf Feldern kann dadurch
verbessert werden, dass der in der Praxis oft anzutreffende Fall vorausgesetzt wird, dass
das Feld bereits entsprechend sortiert ist. Man teilt dann den Suchbereich in der Mitte
und stellt durch einen Vergleich fest, ob sich das gesuchte Element im unteren oder
oberen Intervall befindet, sofern es überhaupt in dem Feld enthalten ist. Auf diese
Weise fährt man durch fortgesetzte Unterteilung der entsprechenden Intervalle fort, bis
das Element gefunden ist oder keine weitere Unterteilung mehr möglich ist. Diesen
Algorithmus nennt man binäre Suche.
Schreiben Sie ein Java-Programm, das die binäre Suche auf einem aufsteigend
sortierten Feld von integer-Werten realisiert. Implementieren Sie eine iterative und
eine rekursive Methode.
Zählen Sie in Ihrem Programm für unterschiedliche Testfälle die Anzahl der
Vergleiche, bis die gesuchte Zahl gefunden ist oder festgestellt wird, dass sie nicht im
Feld enthalten ist. Verwenden Sie anschließend ein 100.000-stelliges Feld, das mit den
entsprechenden integer-Werten von 0 – 99.999 initialisiert ist. Von welcher
Laufzeitkomplexität ist der Algorithmus „binäre Suche“?
 */
