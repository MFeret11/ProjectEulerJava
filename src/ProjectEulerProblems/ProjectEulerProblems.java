package ProjectEulerProblems;

import java.util.ArrayList;

/**
 * @author matthewferet
 */
public class ProjectEulerProblems {

    /**
     * this is the main class to run these Euler solutions in java.
     * Problems can be found at https://projecteuler.net/archives.
     * I have more completed in Java. Will upload later.
     */
    public static void main(String[] args) {
        multiples(); // Problem 1
        evenFibAdder(); // Problem 2
        largestPrimeFactor(); // Problem 3
        largestPalindrome(); // Problem 4
        smallestMultiple(); // Problem 5
        SumSquareDifference(); // Problem 6
        thousandthPrime(); // Problem 7
    }

    //Euler Problem 1: Summing the multiples of 3 & 5 up to 1000
    public static void multiples() {
        int sum = 0;
        final int max = 1000;
        final int term1 = 3;
        final int term2 = 5;

        for (int i = 0; i < max; i++) {
            if ((i % term1 == 0) || (i % term2 == 0)) {
                sum += i;
            }
        }
        System.out.println("Problem 1 Sum: " + sum);
    }

    //Euler Problem 2: Adding even Fib numbers up to 4 million
    public static void evenFibAdder() {
        final int max = 4000000;
        int n1 = 1;
        int n2 = 1;
        int n3;
        int sum = 0;
        for (int i = 0; i < max; i++) {
            n3 = n1 + n2;
            n1 = n2;
            n2 = n3;
            if (n3 >= 4000000) {
                break;
            }
            if (n3 % 2 == 0) {
                sum = sum + n3;
            }
        }
        System.out.println("Problem 2 sum: " + sum);
    }

    //Euler Problem 3: Finding Largest Prime Factor
    public static void largestPrimeFactor() {
        long n = 600851475143L;
        long limit = (int) Math.sqrt(n) + 1; //largest possible prime factor

        for (int i = 3; i < limit; i += 2) {
            if (n % i == 0) {
                n /= i;
                limit = (int) Math.sqrt(n) + 1;
                i -= 2; 
            }    
        }
        System.out.println("Problem 3 Composite: " + n);
    }

    //Euler Problem 4: Largest Palindrome that is the product of two 3-digit numbers
    public static void largestPalindrome() {
        final int lowerLimit = 100;
        final int upperLimit = 999;
        int product;
        String productString;
        String reverse;
        int palindrome = -1;

        for (int i = lowerLimit; i <= upperLimit; i++) {
            for (int j = lowerLimit; j <= upperLimit; j++) {
                product = i * j;
                if (product > (lowerLimit * lowerLimit * 10)) {
                    productString = Integer.toString(product);
                    reverse = new StringBuilder(productString).reverse().toString();
                    if (productString.compareTo(reverse) == 0
                            && product > palindrome) {
                        palindrome = product;
                    }
                }
            }
        }
        System.out.println("Problem 4 palindrome: " + palindrome);
    }

    //Euler Problem 5 smallest multiple 
    // Compute prime factorization of 1-20 
    // and multiple greatest power of each prime
    public static void smallestMultiple() {
        int j = 2;
        for (int i = 20; i <= 232792560; i += 20) {
            if (i % 11 == 0 && i % 12 == 0 && i % 13 == 0
                    && i % 14 == 0 && i % 15 == 0 && i % 16 == 0
                    && i % 17 == 0 && i % 18 == 0 && i % 19 == 0
                    && i % 20 == 0) {
                System.out.println("Problem 5 Answer: " + i);
            }
        }
    }

    //Euler Problem 6 
    public static void SumSquareDifference() {
        long sumSquares = 0;
        long squareSums = 0;
        long answer;

        for (int i = 1; i <= 100; i++) {
            sumSquares = sumSquares + (i * i);
        }
        for (int j = 1; j <= 100; j++) {
            squareSums = squareSums + j;
        }

        squareSums = squareSums * squareSums;
        answer = (squareSums - sumSquares);
        System.out.println("Problem 6 Answer: " + answer);
    }

    //Euler Problem 7
    public static void thousandthPrime() {
        final int highPrime = 10001;
        int value = 0;
        int numOfPrimes = 0;
        for(int i = 1; i <= 2147483646; i += 2){
            if((isPrime(i)))
                numOfPrimes+=1;
            if(numOfPrimes == highPrime){
                System.out.println("Problem 7 answer: " + i);
                break;
            }
        }
    }
    //helper method for problem 7.
    private static boolean isPrime(int n){
         //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
        
    //Euler Problem 14
    public static void collatzGenerator() {
        int largest = 0;
        int seedVal = -1;

        int counter;

        for (int seed = 2; seed < 1000000; seed++) {

            counter = collatzTest(seed);
            
            if (counter > largest) {
                largest = counter;
                seedVal = seed;
            }
        }
        System.out.println("Largest chain is: " + largest + " Occuring at seed: " + seedVal);
    }
    //helper method for problem 14
    private static int collatzTest(double seed) {
        int sequenceCounter = 1;
        while (seed > 1) {
            if (seed % 2 == 0) {
                seed = seed / 2;
            } else {
                seed = (3 * seed) + 1;
            }
            sequenceCounter++;
        }
        return sequenceCounter++;
    }
    
    


}
