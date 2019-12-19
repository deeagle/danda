package e02;

public class TwoThree {
    public static void main(String args[]){
        System.out.println(g(6,9));
        System.out.println(g(12,18));
        System.out.println(g(21,13));
        System.out.println(g(50,20));
    }

     private static int g(int x,int y){
        if(y == 0){
            return x;
        }
        else if(x > y){
            return g(y , (x%y));
        }else{
            return g(x , (y%x));
        }
    }
}
