import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class D{
    Deque<Integer> num = new ArrayDeque<>();
    int area = 0;
    int lakeIndex = 0;
    int lakeArea = 0;
    List<Integer> lakes = new ArrayList<>();
    public void run(){
        parseInput().stream()
            .forEach(n -> resultPrint(n));
    }
    public void resultPrint(String[] array){
        IntStream.rangeClosed(1,array.length)
            .forEach(n -> addStack(array[n-1], n));
        System.out.println(area);
        area = 0;
        lakeIndex = 0;
        lakeArea = 0;
    }
    public void addStack(String str, int index){
        if(Objects.equals(str, "\\")){
            num.addFirst(index);
            System.out.println(area);
            lakeIndex = 0;
            lakeArea = 0;
        }
        else if(Objects.equals(str, "/") && !num.isEmpty()){
            int tmpIndex = num.removeFirst();
            area += index - tmpIndex;
            if(lakeIndex > tmpIndex){
                lakeIndex = tmpIndex;
                lakeArea = area;
            }
        }
    }

    public List<String[]> parseInput(){
        return new BufferedReader(new InputStreamReader(System.in)).lines()
            .filter(n -> !Objects.equals(n, ""))
            .map(i -> i.split(""))
            .collect(Collectors.toList());
    }

    public static void main(String[] args){
        new D().run();
    }
}
