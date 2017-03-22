import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class A{
    Integer[][] array = new Integer[1000][1000];
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int width = Integer.parseInt(br.readLine());
            for(int i = 0; i < width; i++){
                for(int j = 0; j < width; j++){
                    array[i][j] = 0;
                }
            }
            br.lines()
                .forEach(n -> createMap(n.split(" ")));
            for(int i = 0; i < width; i++){
                System.out.print(array[i][0]);
                for(int j = 1; j < width; j++){
                    System.out.print(" " + array[i][j]);
                }
                System.out.println();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void createMap(String[] n){
        for(int i = 2; i < n.length ; i++){
            array[Integer.parseInt(n[0]) - 1][Integer.parseInt(n[i]) - 1] = 1;
        }
    }
    public static void main(String[] args){
        new A().run();
    }
}
