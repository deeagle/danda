package e06;

import java.util.Random;

public class SixTwoAndThree {

    protected static boolean debug = true;
    private static int counter = 0;
    protected static int mergeCounter = 0;


    public static void main(String args[]) {
        a3();
    }

    private static void a2(){
        System.out.println("------ QuickSort Sort ------");
        int[] sortInsert = {56, 22, 79, 27, 9, 30, 61, 4, 69, 38, 52, 89, 23, 17, 68, 30};
        System.out.print("Vorher: ");
        for (int e : sortInsert) {
            System.out.print(e + " ");
        }
        int[] outputInsert = quickSort(sortInsert, 0, sortInsert.length-1);
        System.out.print("Nachher: ");
        for (int e : outputInsert) {
            System.out.print(e + " ");
        }
        System.out.println();

        System.out.println("------ MergeSort Sort ------");
        int[] sortMerge = {56, 22, 79, 27, 9, 30, 61, 4, 69, 38, 52, 89, 23, 17, 68, 30};
        System.out.print("Vorher: ");
        for (int e : sortMerge) {
            System.out.print(e + " ");
        }

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(sortMerge);
        System.out.print("Nachher: ");
        for (int e : sortMerge) {
            System.out.print(e + " ");
        }
        System.out.println();
    }
    private static void a3(){
        int[] sort = new int[10000];
        Random rn = new Random();
        for(int i = 0;i < sort.length;++i){
            sort[i] = rn.nextInt(1000)+1;
        }
        MyTimer timer = new MyTimer();
        timer.go();
        quickSort(sort,0,sort.length-1);
        System.out.println("Der Quick Sort hat "+timer.stop()+"ms gedauert!");
        System.out.println();
        if(debug) System.out.println("Es wurden "+counter+" Vergleiche benötigt.");


        int[] sort2 = new int[10000];
        for(int i = 0;i < sort.length;++i){
            sort[i] = rn.nextInt(1000)+1;
        }
        timer.go();
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(sort2);
        System.out.println("Der Merge Sort hat "+timer.stop()+"ms gedauert!");
        System.out.println();
        if(debug) System.out.println("Es wurden "+mergeCounter+" Vergleiche benötigt.");


    }


    private static int[] quickSort(int list[], int low, int high) {
        /* Sortiere list[low] ... list[high] in nicht absteigender Form
        der Schlüsselfelder.
        list[high] wird als Pivotelement gewählt. */
        int i, j;
        int hilf;
        if (low < high) {
            i = low;
        /* Länge der Folge > 1 */
            j = high;
            do /* Aufspalten in 2 Teillisten */ {
                while (list[i] < list[high]){
                    if(debug) counter++;
                    i++;
                }

                while (list[j] > list[high] && i < j){
                    if(debug) counter++;
                    j--;
                }

                if (i < j){

                    hilf = list[i];
                    list[i] = list[j];
                    list[j] = hilf;
                    i++;
                    j--;
                }
        /*Vertausche list[i] und list[j] */ {
                }
            } while (i < j);
        /* Positionieren des Pivotelementes */
            hilf = list[high];
            list[high] = list[i];
            list[i] = hilf;
        /* Aufruf für die beiden erzeugten Teillisten */
            quickSort(list, low, i - 1);
            quickSort(list, i + 1, high);
        }
        return list;
    }

}
