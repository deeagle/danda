package e02;

public class test {
    public static void main(String args[]){
        System.out.println(mod(175,4));
        System.out.println(175%4);


    }
    private static int mod(int a, int b){
        int z = a/b;
        return a-b*z;
    }
}
