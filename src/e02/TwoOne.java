package e02;

public class TwoOne {
    static int z = 0;

    public static void main(String args[]){

        for(int i = 0;i <=5;++i){

            System.out.print(i + " ");
            System.out.println(recursion(i));
        }
    }

    public static int recursion (int n)
    {
        ++z;
        if (n <= 0)
            return 1;
        else
            return ( recursion(n-1) + recursion(n-1) );
    }


}
