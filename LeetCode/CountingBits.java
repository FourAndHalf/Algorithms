import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'getOneBits' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER n as parameter.
     */

    public static List<Integer> getOneBits(int n) {
        int count = 0;
        int position = (int)(Math.floor(Math.log(n) / Math.log(2))) + 1;
               
        List<Integer> res = new ArrayList<>();
        
        while (n > 0) {
            int rem = n%2;
            
            if (rem != 0) {
                count++;
                res.add(position);
            }
            
            n = n/2;
            position--;
        }
        
        List<Integer> result = new ArrayList<>();
        
        result.add(count);
        
        for (int i = res.size()-1; i >=0;i--)
        {
            result.add(res.get(i));
        }
        
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> result = Result.getOneBits(n);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

