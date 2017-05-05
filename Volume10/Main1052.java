import java.io.*;
import java.util.*;


public class Main1052{
    Map<Integer, Integer> map = new TreeMap<>();
    Map<Integer, Integer> indexMap = new TreeMap<>();
    boolean checkFlag = false;
    public void check(int key, int weight, List<Integer> arriveList){
        //keyをweightに足す
        //ifでweightがvalueより大きい場合，return false
        //else if arrivelistに今のkeyを入れて次のkeyでこの関数を呼ぶ
        if(key == -1)
            return;
        if(map.size() == arriveList.size()){
            checkFlag = true;
            return;
        }
        System.out.println("h");
        weight += key;
        if(weight > map.get(key))return;
        else if(weight <= map.get(key) && !arriveList.contains(key)){
            arriveList.add(key);
            // System.out.println(indexMap.get(key));
            check(getNextKey(key, arriveList), weight, arriveList);
            // for(Integer a: arriveList)
            //     System.out.println(a);
            return;
        }
    }

    public Integer getNextKey(int key, List<Integer> arriveList){
        boolean flag = false;
        for(Integer a : map.keySet()){
            if(flag == true)
                return a;
            if(a == key)
                flag = true;
        }
        return -1;
    }

    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int weight = 0;
            while(true){
                Integer n =  Integer.parseInt(br.readLine());
                if(n == 0)break;
                int tmpNum = 0;
                for(int i = 0; i < n;i++){
                    String[] arg = br.readLine().split(" ");
                    map.put(Integer.parseInt(arg[0]), Integer.parseInt(arg[1]));
                    if(i > 0)
                        indexMap.put(tmpNum, Integer.parseInt(arg[0]));
                    tmpNum = Integer.parseInt(arg[0]);
                    System.out.println(tmpNum);
                }
                System.out.println();
                for(Integer key: indexMap.keySet()){
                    System.out.println(key);
                }
                for(Integer key: map.keySet()){
                    check(key, weight, new ArrayList<Integer>());
                    // weight += key;
                    // if(weight > map.get(key)){
                    //     System.out.println("NO");
                    //     weight = 0;
                    //     break;
                    // }
                }
                if(checkFlag == true){
                    System.out.println("YES");
                    checkFlag = false;
                }else{
                    System.out.println("NO");
                }

                // if(weight != 0){
                //     System.out.println("YES");
                //     weight = 0;
                // }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String... args){
        new Main1052().run();
    }
}
