package bj15649;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static int N, M;  
    static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        select = new boolean[N];  

        perm(0, "", bw);  
        
        br.close();
        bw.flush();   
        bw.close();
    }

    static void perm(int tgtIdx, String answer, BufferedWriter bw) throws IOException {
        if (tgtIdx == M) {
            bw.write(answer.trim() + "\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (select[i]) continue; 
            
            select[i] = true; 
            
            perm(tgtIdx + 1, answer + (i + 1) + " ", bw);

            select[i] = false;  
        }
    }
}

