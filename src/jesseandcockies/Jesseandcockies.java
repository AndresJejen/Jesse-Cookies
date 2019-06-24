/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jesseandcockies;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author andres
 */
public class Jesseandcockies {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) throws IOException{
         
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String line = br.readLine();
            String[] palabras=line.split(" ");
            int N=Integer.parseInt(palabras[0].trim());
            int K=Integer.parseInt(palabras[1].trim());
           
            
            String num = br.readLine();
            String[] numeros = num.split(" ");
            
            int[] A = new int[N];
            
            for (int i = 0; i < A.length; i++) {
                    A[i] = Integer.parseInt(numeros[i].trim());
            }
            System.out.println(solve(A, K));

            br.close();
    }

    static int solve(int[] A, int K) {            

            MinHeap sweetnesses = new MinHeap(A.length);
            
            for(int i = 0; i < A.length; i++){
                sweetnesses.insert(A[i]);
            }
            
            /*
            System.out.println("Arbol en con nuevo dato");
            sweetnesses.print();
            System.out.println("-----------");
            */

            sweetnesses.minheap();
            
            int operationNum = 0;
            while (sweetnesses.peek() < K && sweetnesses.getSize()>= 2) {
                    int leastSweetness = sweetnesses.poll();
                    int secondLeastSweetness = sweetnesses.poll();
                    
                    System.out.println("Least: " + leastSweetness);
                    System.out.println("Second least: " + secondLeastSweetness);

                    sweetnesses.insert(leastSweetness + 2 * secondLeastSweetness);
                    System.out.println("Arbol en con nuevo dato");
                    sweetnesses.print();
                    System.out.println("-----------");
                    operationNum++;
            }

            return (sweetnesses.peek() >= K) ? operationNum : -1;
    }
    
}