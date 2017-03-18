import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class A{
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            br.lines()
                .forEach(n -> fib(n));
        }catch(Exception e){
        }
    }

    public void fib(String n){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(1);
        for(int i = 2;i <= Integer.parseInt(n);i++ ){
            list.add(list.get(i - 2) + list.get(i - 1));
        }
        System.out.println(list.get(Integer.parseInt(n)));
    }
    public static void main(String[] args){
        new A().run();
    }
}
