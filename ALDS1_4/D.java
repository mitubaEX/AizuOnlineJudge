import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class D{
    List<Integer> inputList = new ArrayList<>();
    int sum = 0;
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] strArray = br.readLine().split(" ");
            System.out.println(strArray[0] + " "+ strArray[1]);
            br.lines()
                .filter(n -> !Objects.equals(n, ""))
                .forEach(n -> addList(n));
            int limit = createLimit(Integer.parseInt(strArray[1]));

        }catch(Exception e){

        }
    }
    public void addList(String arg){
        inputList.add(Integer.parseInt(arg));
    }
    public void createLimit(int trackNum){
        inputList.stream()
            .forEach(n -> sum += n);
        return sum/trackNum + sum%trackNum;
    }
    public static void main(String[] args){
        new D().run();
    }
}
