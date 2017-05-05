import java.io.*;
import java.util.*;

class Main{
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            // br.lines()
            //     .forEach(System.out::println);
            for(int i = 1;i <= 9; i++){
                for(int j = 1; j <= 9; j++){
                    System.out.println(i+"x"+j+"="+i*j);
                }
            }
        }catch(Exception e){

        }
    }
    public static void main(String[] args){
        new Main().run();
    }
}
