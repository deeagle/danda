package e01;

public class OneThree {

    public static void nichts (int n)
    {
        int counter=0;
        for (int i=1; i <= n-1; i++)
            for (int j= i+1; j <= n; j++)
                for (int k= 1; k <= j; k++)
                  //  System.out.println("nichts");
                    counter++;
        System.out.println(counter);
    }
    public static void main(String args[]){
        for (int i = 0;i < 10;i++){
            nichts(i);
            System.out.println("----------");
        }
    }
}
