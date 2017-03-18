import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class A{
    List<Integer> A = new ArrayList<Integer>();
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            br.lines()
                .forEach(n -> met(n));
        }catch(Exception e){
        }
    }

    public void met(String n){
        String[] tmp = n.split(" ");
        if(Objects.equals(tmp[0],tmp[1]))
            System.out.println("H");
        else
            System.out.println("D");

        // Arrays.stream(n.split(" "))
        //     .forEach(n -> {
        //         if(Objects.equals(n[0],n[1]))
        //             System.out.println("H");
        //         else
        //             System.out.println("D");
        //     });
    }


    public static void main(String[] args){
        new A().run();
    }
}
