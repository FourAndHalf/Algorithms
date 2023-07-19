public class fizzBuzz {
    public static void main(String[] args) {

    //* Brute Force Method
        for(int i = 1; i <= 100; i++) {                  //! Time Complexity = O(n)                     
            if(i%3 == 0 && i%5 == 0) {
                System.out.println("FizzBuzz");
            } else if(i%3 == 0) {
                System.out.println("Fizz");
            } else if(i%5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }                                               //! Total Time Complexity = O(n)
        
    //* Optimized Method
        for (int i = 1; i <= 100; i++) {                //! Time Complexity = O(n)
            String result = "";
            if(i%3 == 0) result += "Fizz";
            if(i%5 == 0) result += "Buzz";
            if(result == "") {
                System.out.println(i);
            } else {
                System.out.println(result);             //! Total Time Complexity = O(n)
            }
        }
    }
}