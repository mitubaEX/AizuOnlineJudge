import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class D{
    Map<Integer, List<Integer>> map = new HashMap<>();
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int line = Integer.parseInt(br.readLine().split(" ")[1]);
            for(int i = 0; i < line; i++){
                String[] inputString = br.readLine().split(" ");
                if(map.containsKey(Integer.parseInt(inputString[0])))
                    map.get(Integer.parseInt(inputString[0])).add(Integer.parseInt(inputString[1]));
                else{
                    map.put(Integer.parseInt(inputString[0]), new ArrayList<Integer>());
                    map.get(Integer.parseInt(inputString[0])).add(Integer.parseInt(inputString[1]));
                }
            }
            br.readLine();
            br.lines()
                .filter(n -> !Objects.equals("", n))
                .map(n -> n.split(" "))
                .forEach(n -> yesOrNo(checker(Integer.parseInt(n[0]), Integer.parseInt(n[1]))));
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public boolean checker(int key, int target){

        if(!map.containsKey(key))
            return false;
        if(map.get(key).contains(target)){
            return true;
        }
        else{
            for(int a : map.get(key))
                if(checker(a, target))
                    return true;
        }
        return false;
    }

    public void yesOrNo(boolean b){
        if(b)
            System.out.println("yes");
        else
            System.out.println("no");
    }
    public static void main(String[] args){
        new D().run();
    }
}
