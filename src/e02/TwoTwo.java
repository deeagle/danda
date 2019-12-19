package e02;

public class TwoTwo {

    public static void main(String args[]){
        System.out.println(g(5,5));
    }

    public static int f(int x, int y){
        if(x == 0){
            return y;
        }else{
            return f(x-1,y+1);
        }
    }
    public static int g(int x, int y){
        if(x == 1){
            return y;
        }else{
            return g(x-1,y)+y;
        }
    }

}
