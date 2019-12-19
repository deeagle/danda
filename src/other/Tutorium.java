package other;

public class Tutorium {
    public static void main(String args[]){
        System.out.println(functionX(5));
        System.out.println(functionX(22));
    }

    private static int fib(int n){
        if (n == 0) {
            return 0;
        }
        if (n == 1){
            return 1;
        }else{
            return fib(n-1)+fib(n-2);
        }
    }

    private static int functionX(int a){
        if (a < 1) return 1;
        return functionX(a-1) * functionX(a-2);
    }
}
