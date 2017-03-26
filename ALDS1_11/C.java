import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Pair{
    private int file;
    private int time;
}

class C{
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
            calc(width);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void calc(int width){
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> timeList = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int time = 0;
        deque.addFirst(0);
        map.put(1, 0);
        while(deque.size() != 0){
            for(int j = 0; j < width; j++){
                if(array[i][j] == 1){
                    deque.addLast(j);
                }
            }
            System.out.println(i);
            int key = deque.removeFirst() + 1;
            if(map.containsKey(key))
                map.put(key, Math.min(map.get(key), time));
            else
                map.put(key, time);
            if(deque.size() == 0)
                break;
            i = deque.peekFirst();
            time++;
        }
        for(Integer a : map.keySet())
            System.out.println(a + " " + map.get(a));
    }

    public void createMap(String[] n){
        for(int i = 2; i < n.length ; i++){
            array[Integer.parseInt(n[0]) - 1][Integer.parseInt(n[i]) - 1] = 1;
        }
    }
    public static void main(String[] args){
        new C().run();
    }
}
