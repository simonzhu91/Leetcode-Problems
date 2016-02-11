import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Count {
  
  
  // =================================================== //
  
  // Part 1 of Question
  // Algorithm: Brute Force
  public static long count(int N){
    long total = 0;
    
    for(int i = 0; i <= N; i++){
      for(Character c : String.valueOf(i).toCharArray()){
        if(c == '7'){
          // System.out.println(i);
          total++;
          break;
        }
      }
    }
    return total;
  }
  
    // =================================================== //

  // Part 2 of Question
  // Idea: Follow Algorithm below
  public static long countPart2(int v){
    
    // count number of 0's
    int count = 0;
    int val = v;
    while(val % 10 == 0){
      val /= 10;
      count++;
    }

    return (long)countPart2Helper(v, count - 1);
  }

  // (1000 / 10) * 1 + (1000 / 100) * 10 + (1000 / 1000) * 100 = 300
  // 1 in every 10 numbers is 7
  // 10 in 
  
  // 10 -> 1 seven
  // 100 -> 19 sevens
  // 1000 -> 271 sevens
  // 10000 -> 3439 sevens
  // f(100) = 10 * f(10) + 9
  // f(1000) = 10 * (10 * f(10) + 9) + 81
  // f(10000) = 10 * ( 10 * (10 * f(10) + 9) + 81) + 729
  
  // Part 2 of Question
  // Idea: Follow Algorithm above
  public static long countPart2Helper(int curr, int i){
    
    if(curr == 1){
      return 0;
    }
    
    if(curr == 10){
      return 1;
    }else{
      return 10 * countPart2Helper(curr/10, i-1) + (long)Math.pow(9, i);
      // return 10 * F(n/10)
    }  
  }
  
    // =================================================== //
  

  public static void main(String[] args) {
    
    // System.out.println("Hello");

    int N = 100;

    System.out.println("Count Part 1: " + Count.count(N));

    N = 1000;

    System.out.println("Count Part 1: " + Count.count(N));

    N = 1000;

    System.out.println("Count Part 2: " + Count.countPart2(N));

    N = 100;

    System.out.println("Count Part 2: " + Count.countPart2(N));

    N = 10;

    System.out.println("Count Part 2: " + Count.countPart2(N));

    N = 1;

    System.out.println("Count Part 2: " + Count.countPart2(N));

    // System.out.println((int)Count.count2(N, numZeros - 1));
    
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
  }
}


// # 0..100 how many numbers have at least one '7'
// # ie. 7, 27, 72


// # V0.1
// # Brute force solution.
// def num_sevens_brute(num):
//     # /todo
//     return 1

// assert num_sevens(65) == 6
// assert num_sevens(75) == 13
// assert num_sevens(80) == 17
// assert num_sevens(85) == 17





// # V0.2
// # Find # how many numbers have at least one '7' between 0 and a power of ten (10, 100, 1000 etc). Input is gauranteed to be a power of ten. 

// def num_sevens_pow_ten(pow10):
//     return 1

// assert num_sevens(10) == 1
// #assert num_sevens(100) == ??
// #assert num_sevens(1000) == ???





// # V0.3
// # Find # of sevens between 0 and an positive integer. Assume
// # input is gauranteed to be a positive integer.
// def num_sevens(num):
//     return 1   

// assert num_sevens(10) == 1
// #assert num_sevens(65) == 6
// #assert num_sevens(75) == 13
// #assert num_sevens(80) == 17
// #assert num_sevens(85) == 17