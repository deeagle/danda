package e06;

import java.util.Random;

public class SixOneAndThree {
    private static boolean debug = true;
    public static void main(String args[]){
        a3();
    }

    private static void a1(){
        System.out.println("------ Insertion Sort ------");
        int[] sortInsert = {56, 22, 79,27, 9, 30, 61, 4, 69, 38, 52, 89, 23, 17, 68, 30};
        System.out.print("Vorher: ");
        for (int e:sortInsert) {
            System.out.print(e+" ");
        }
        int[] outputInsert = insertionSort(sortInsert);
        System.out.print("Nachher: ");
        for (int e:outputInsert) {
            System.out.print(e+" ");
        }
        System.out.println();


        System.out.println("------ Selection Sort ------");
        int[] sortSlection = {56, 22, 79,27, 9, 30, 61, 4, 69, 38, 52, 89, 23, 17, 68, 30};
        System.out.print("Vorher: ");
        for (int e:sortSlection) {
            System.out.print(e+" ");
        }
        int[] outputSelect = selectionSort(sortSlection);
        System.out.print("Nachher: ");
        for (int e:outputSelect) {
            System.out.print(e+" ");
        }
        System.out.println();


        System.out.println("------ Better Bubble Sort ------");
        int[] sortBetterBubble = {56, 22, 79,27, 9, 30, 61, 4, 69, 38, 52, 89, 23, 17, 68, 30};
        System.out.print("Vorher: ");
        for (int e:sortBetterBubble) {
            System.out.print(e+" ");
        }
        int[] outputBubble = betterBubbleSort(sortBetterBubble);
        System.out.print("Nachher: ");
        for (int e:outputBubble) {
            System.out.print(e+" ");
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
        insertionSort(sort);
        System.out.println("Der Insertion Sort hat "+timer.stop()+"ms gedauert!");
        System.out.println();

        for(int i = 0;i < sort.length;++i){
            sort[i] = rn.nextInt(1000)+1;
        }
        timer.go();
        selectionSort(sort);
        System.out.println("Der Selection Sort hat "+timer.stop()+"ms gedauert!");
        System.out.println();

        for(int i = 0;i < sort.length;++i){
            sort[i] = rn.nextInt(1000)+1;
        }
        timer.go();
        betterBubbleSort(sort);
        System.out.println("Der Better Bubble Sort hat "+timer.stop()+"ms gedauert!");
        System.out.println();


    }

    private static int[] insertionSort(int[] a){
        int tmp,selected;
        int switches = 0;
        int elem1 = a[4];
        int elem2 = a[5];
        int elemCount = 0;
        for(int i = 1; i<a.length;++i){
            selected = i;
            for(int j = i;j >= 0;j--){
                if(a[selected] < a[j]){
                    if(debug){
                        ++switches;
                        if(a[j] == elem1 && a[selected] == elem2 || a[j] == elem2 && a[selected] == elem1){
                            ++elemCount;
                        }
                    }
                    tmp = a[j];
                    a[j] = a[selected];
                    a[selected] = tmp;
                    selected = j;
                }
            }
        }
        if(debug){
            System.out.println("Es wurden "+switches+" Vertauschungen durchgeführt.");
            System.out.println("Die Elemente "+elem1+" und "+elem2+" wurden "+elemCount+" mal verglichen.");
        }
        return a;
    }
    private static int[] selectionSort(int[] a){
        int small,tmp;
        int switches = 0;
        int elem1 = a[4];
        int elem2 = a[5];
        int elemCount = 0;
        for(int i = 0;i < a.length;++i){
            small = i;
            for(int j = i;j < a.length;++j){
                if(a[j] < a[small]){
                    if(debug){
                        if(a[j] == elem1 && a[small] == elem2 || a[j] == elem2 && a[small] == elem1){
                            ++elemCount;
                        }
                    }
                    small = j;
                }
            }
            if(debug){
                ++switches;
            }
            tmp = a[i];
            a[i] = a[small];
            a[small] = tmp;
        }
        if(debug){
            System.out.println("Es wurden "+switches+" Vertauschungen durchgeführt.");
            System.out.println("Die Elemente "+elem1+" und "+elem2+" wurden "+elemCount+" mal verglichen.");
        }
        return a;
    }
    private static int[] betterBubbleSort(int[] a) {
        int temp;
        int switches = 0;
        int elem1 = a[4];
        int elem2 = a[5];
        int elemCount = 0;
        boolean finish = true;
        for (int i = a.length; i > 1; --i) {
            for (int j = 0; j < i-1; j++) {
                if (a[j] > a[j + 1]) {
                    if(debug){
                        ++switches;
                        if(a[j] == elem1 && a[j+1] == elem2 || a[j] == elem2 && a[j+1] == elem1){
                            ++elemCount;
                        }
                    }
                    finish = false;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
            if(finish){
                return a;
            }
        }
        if(debug){
            System.out.println("Es wurden "+switches+" Vertauschungen durchgeführt.");
            System.out.println("Die Elemente "+elem1+" und "+elem2+" wurden "+elemCount+" mal verglichen.");
        }
        return a;
    }
}
