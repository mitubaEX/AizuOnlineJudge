import java.io.*;
import java.util.*;


class B{
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int count = 0;
            int n = 0,q = 0;
            String line;
            Deque<String> name = new ArrayDeque<>();
            Deque<Integer> time = new ArrayDeque<>();
            String[] tmp;
            int spentTime = 0;
            while((line = br.readLine()) != null){
                // System.out.println(line);
                if(Objects.equals(line,"")){
                    break;
                }
                tmp = line.split(" ");
                if(count == 0){
                    n = Integer.parseInt(tmp[0]);
                    q = Integer.parseInt(tmp[1]);
                    count++;
                }
                else{
                    name.addLast(tmp[0]);
                    time.addLast(Integer.parseInt(tmp[1]));
                }
            }

            String temp_name;
            int temp_time;
            while(name.size() != 0){
                temp_name = name.removeFirst();
                temp_time = time.removeFirst();

                if(temp_time > q){
                    temp_time -= q;
                    name.addLast(temp_name);
                    time.addLast(temp_time);
                    spentTime += q;
                }else{
                    System.out.println(temp_name + " " + (spentTime + temp_time));
                    spentTime += temp_time;
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        new B().run();
    }
}
