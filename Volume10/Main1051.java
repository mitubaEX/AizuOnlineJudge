import java.io.*;
import java.util.*;


public class Main1051{

    public void run(){
        Scanner scan = new Scanner(System.in);
        while(true){
            int n = scan.nextInt();
            if(n == 0)
                break;

            boolean firstFlag = false;
            Integer first = 0;
            Integer last = 0;
            Integer tmpNum = 0;
            Integer latestNum = 0;
            List<String> resultStringList = new ArrayList<>();
            for(int i = 0; i < n; i++){
                tmpNum = scan.nextInt();
                if(firstFlag == false){
                    first = tmpNum;
                    firstFlag = true;
                }
                else if(tmpNum - latestNum > 1 || tmpNum - latestNum < 0){
                    resultStringList.add(first + "-" + latestNum);
                    first = tmpNum;
                }else if(tmpNum == latestNum){
                    resultStringList.add(tmpNum.toString());
                }
                latestNum = tmpNum;
            }
            resultStringList.add(first + "-" + latestNum);
            System.out.println(String.join(" ", resultStringList));
        }
    }
    public static void main(String[] args){
        new Main1051().run();
    }
}
