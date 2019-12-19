package e05;

public class FiveOne {

    private static int[] union(int a[], int b[]){
        int vergleichCounter = 0;
        int c[] = new int[a.length+b.length];
        int pointC = 0;
        int j = 0;
        int i = 0;
        if(a.length < b.length){
            ++vergleichCounter;
            int help[] = a;
            a = b;
            b = help;
        }
        while(i < a.length){
            ++vergleichCounter;
            while( j < b.length){
                ++vergleichCounter;
                if(a[i] == b[j]){
                    ++vergleichCounter;
                    c[pointC++] = a[i];
                    ++i;
                    ++j;
                    break;
                }
                else if(a[i] > b[j]){
                    ++vergleichCounter;
                    c[pointC++] = b[j];
                    ++j;
                }
                else{
                    c[pointC++] = a[i];
                    ++i;
                    break;
                }
            }
            if(j == b.length){
                ++vergleichCounter;
                break;
            }
        }
        if(j >= b.length-1){
            ++vergleichCounter;
            for(; i < a.length;++i){
                ++vergleichCounter;
                c[pointC++] = a[i];
            }
        }
        if(i >= a.length-1){
            ++vergleichCounter;
            for(; j < b.length;++j){
                ++vergleichCounter;
                c[pointC++] = b[j];
            }
        }
        System.out.println(vergleichCounter);
        return c;
    }

    public static int[] intersect(int a[], int b[]){
        int vergleichCounter = 0;
        int c[] = new int[a.length+b.length];
        int pointC = 0;
        int j = 0;
        int i = 0;
        if(a.length < b.length){
            ++vergleichCounter;
            int help[] = a;
            a = b;
            b = help;
        }
        while(i < a.length){
            ++vergleichCounter;
            while( j < b.length){
                ++vergleichCounter;
                if(a[i] == b[j]){
                    ++vergleichCounter;
                    c[pointC++] = a[i];
                    ++i;
                    ++j;
                    break;
                }
                else if(a[i] > b[j]){
                    ++vergleichCounter;
                    ++j;
                }
                else{
                    ++i;
                    break;
                }
            }
            if(j == b.length){
                ++vergleichCounter;
                break;
            }
        }
        System.out.println(vergleichCounter);
        return c;
    }


    public static void main(String args[]){
        int a[] = {-1,4,6,8,12,45,200,210};
        int b[] = {2,6,10,40,45,120,200,240};

        int c[] = union(a,b);
        for (int d:c) {
            System.out.print(d + " ");
        }
        System.out.println();
        int f[] = intersect(a,b);
        for (int d:f) {
            System.out.print(d + " ");
        }
    }
}

/*
Schreiben Sie eine Java-Methode mit entsprechendem main-Programm, die in linearer
Zeit den Durchschnitt C der beiden sortierten Mengen A und B (repräsentiert in den
Feldern a[] und b[]) bestimmt. Dabei hat die Menge A die Größe n, die Menge B hat
die Größe m. Ermitteln Sie den Aufwand der Methode als Anzahl der Vergleichs-
operationen zwischen Mengenelementen. Fügen Sie dazu einen entsprechenden Zähler
in den Programmcode ein.
Beispiel :
Für die Mengen A = {6,8,11,12,23,56,78,90} und B = {4,7,8,12,13,23} (d.h. n = 8 und
m = 6) lautet das Ergebnis
C = A ∩ B = {8, 12, 23} mit der Initialisierung
int[] a = {6,8,11,12,23,56,78,90} und int[] b = {4,7,8,12,13,23}.
 */