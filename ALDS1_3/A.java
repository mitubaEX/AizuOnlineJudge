import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class A{
    public void run(){
        parseInput().stream()
            .forEach(n -> resultPrint(n));
    }
    public void resultPrint(String[] array){
        Deque<Integer> num = new ArrayDeque<>();
        Arrays.stream(array).forEach(n -> {
            if(Objects.equals(n ,"+")){
                num.addFirst(num.removeFirst() + num.removeFirst());
            }
            else if(Objects.equals(n ,"-")){
                int a = num.removeFirst();
                int b = num.removeFirst();
                num.addFirst((b - a));
            }
            else if(Objects.equals(n ,"*")){
                num.addFirst((num.removeFirst() * num.removeFirst()));
            }else{
                num.addFirst(Integer.parseInt(n));
            }
        });
        System.out.println(num.removeFirst());
    }

    public List<String[]> parseInput(){
        return new BufferedReader(new InputStreamReader(System.in)).lines()
            .filter(n -> !Objects.equals(n, ""))
            .map(i -> i.split(" "))
            .collect(Collectors.toList());
    }
    public static void main(String[] args){
        new A().run();
    }
}
