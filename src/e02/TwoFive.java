package e02;

public class TwoFive {
    public static void main(String args[]){
        int[] a = {1,2,3,4,5,6,7,8,9};
        System.out.println(searchLin(a,6));


    }
    private static int searchLin(int[] a, int b){
        for (int c = 0; c < a.length;c++) {
            System.out.print("|");
            if(b == a[c]){
                System.out.println("");
                return c;
            }
        }
        return -1;
    }
}
