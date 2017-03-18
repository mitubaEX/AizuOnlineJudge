import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
class C{
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            br.lines()
                .forEach(n -> met(n));
        }catch(Exception e){
        }
    }

    public void met(String n){
        int ans = 0;
        int max = Integer.parseInt(n);
        for(int i = 1; i <= Integer.parseInt(n); i++){
            if((ans + i) < max){
                ans += i;
            }
            else if((ans + i) > max){
                ans = 0;
                ans += i;
            }
            System.out.println(ans+":"+max);

            if(ans == max){
                System.out.println(i);
                break;
            }

        }
    }


    public static void main(String[] args){
        new C().run();
    }
}
