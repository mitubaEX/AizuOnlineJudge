import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class B{
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
        Deque<Integer> sendTimeDeque = new ArrayDeque<>();
        Deque<Integer> arrivalDeque = new ArrayDeque<>();
        Map<Integer, String> map = new TreeMap<>();
        int sendTime = 1;
        boolean flag = false;
        int i = 0;
        deque.addFirst(1);
        sendTimeDeque.addFirst(1);
        while(deque.size() != 0){
            flag = false;
            for(int j = 0; j < width; j++){
                if(array[i][j] == 1 && !arrivalDeque.contains(j + 1)){
                    deque.addFirst(j + 1);
                    sendTime += 1;
                    sendTimeDeque.addFirst(sendTime);
                    flag = true;
                    break;
                }
            }
            if(flag)
                i = deque.peekFirst() - 1;
            else{
                arrivalDeque.addFirst(deque.removeFirst());
                if(deque.size() != 0){
                    i = deque.peekFirst() - 1;
                }
                sendTime += 1;
                map.put(arrivalDeque.peekFirst(), sendTimeDeque.removeFirst() + " " + sendTime);
                // System.out.println(arrivalDeque.peekFirst() + " " + sendTimeDeque.removeFirst() + " " + sendTime);
            }
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
        new B().run();
    }
}
