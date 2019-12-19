package e01;

import java.util.Scanner;

public class OneOne {
    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        int n;

        System.out.println("Welche Schleife wollen Sie?");
        n = reader.nextInt();

        for(int rounds = 0;rounds <= 10;rounds++){

         switch (n){
             case 1: System.out.println(func1(rounds));
                  break;
                case 2: System.out.println(func2(rounds));
                   break;
                case 3: System.out.println(func3(rounds));
                   break;
                case 4: System.out.println(func4(rounds));
                    break;
            }
        }

    }

    private static int func1(int n){
        int count = 0;

        for(int i=0;i < n;i++){
            for(int j=0;j<n;j++){
                count++;
            }
        }
        return count;
    }

    private static int func2(int n){
        int count = 0;

        for(int i = n; i > 0;i--){
            for(int j=i;j<n;j++){
                count++;
            }
        }
        return count;
    }

    private static int func3(int n){
        int count = 0;

        for(int i=1;i <= n/2;i++){
            for(int j=1;j<n*n;j++){
                count++;
            }
        }
        return count;
    }

    private static int func4(int n){
        int count = 0;

        int i = n;
        do{
            count++;
            i = i/3;
        }while (i > 0);

        return count;
    }

}
