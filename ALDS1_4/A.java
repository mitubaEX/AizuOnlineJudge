import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class A{
    private String[] S;
    private String[] T;

    int count = 0;
    public void run(){
        int seqCount = 0;
        List<String> existStringList = new ArrayList<>();
        parseInput().stream()
            .forEach(n -> resultPrint(n, count));
        for(int i = 0; i < S.length;i++){
            for(int j = 0;j < T.length; j++){
                if(Objects.equals(S[i],T[j]) && !existStringList.contains(T[j])){
                    seqCount++;
                    existStringList.add(T[j]);
                }
            }
        }
        System.out.println(seqCount);
    }
    public void resultPrint(String str, int count){
        if(count == 1)
            S = str.split(" ");
        else if(count == 3)
            T = str.split(" ");
        this.count++;
    }

    public List<String> parseInput(){
        return new BufferedReader(new InputStreamReader(System.in)).lines()
            .filter(n -> !Objects.equals(n, ""))
            .collect(Collectors.toList());
    }
    public static void main(String[] args){
        new A().run();
    }
}
