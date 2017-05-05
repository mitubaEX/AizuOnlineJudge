import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class A{
    int weight = 0;
    public void run(){
        Scanner scan = new Scanner(System.in);
        int width = scan.nextInt();
        int[][] array = new int[width][width];
        for(int i = 0; i < width; i++){
            for(int j = 0; j < width; j++){
                array[i][j] = scan.nextInt();
                // System.out.println(array[i][j]);
            }
            // System.out.println();
        }
        solve(width, array);
    }

    public void solve(int width, int[][] array){
        for(int i = 0; i < width; i++){
            for(int j = 0; j < i+1; j++){
                if(array[i][j] >= 0){
                    weight += array[i][j];
                    System.out.println(array[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println(weight);
    }

    public void check(Integer a){
        System.out.println(a);
        if(a >= 0){
            weight += a;
        }
    }

    public static void main(String[] args){
        new A().run();
    }
}
