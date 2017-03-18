import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
class C{
    public void run(){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int term = Integer.parseInt(br.readLine());
            for(int i = 0;i < term;i++){
                String a = br.readLine();
                String b = br.readLine();
                lcs(a, b);
            }
        }catch(Exception e){
        }
    }

    public void lcs(String a, String b){
        int aLength = a.length();
        int bLength = b.length();
        String[] aArray = a.split("");
        String[] bArray = b.split("");
        Integer[][] strMap = new Integer[1001][1001];

        for(int i = 0;i <= aLength; i++){
            strMap[i][0] = 0;
        }
        for(int j = 0; j <= aLength; j++){
            strMap[0][j] = 0;
        }

        int maxLCS = 0;

        for(int i = 1;i <= aLength; i++){
            for(int j = 1; j <= bLength; j++){
                if(Objects.equals(aArray[i - 1], bArray[j - 1])){
                    strMap[i][j] = strMap[i-1][j-1] + 1;
                }
                else
                    strMap[i][j] = Math.max(strMap[i-1][j],strMap[i][j-1]);
                maxLCS = Math.max(maxLCS, strMap[i][j]);
            }
        }
        for(int i = 1;i <= aLength; i++){
            for(int j = 1; j <= bLength; j++){
                System.out.print(strMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(maxLCS);
    }

    public static void main(String[] args){
        new C().run();
    }
}
