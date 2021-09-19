import java.util.Arrays;
import java.util.Scanner;

public class DesertIsland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // available option to choose
        String[] optionsToChoose = {"Family", "Friends", "Netflix", "Laptop", "Guitar", "Cat", "Boat", "Bog", "Sofa", "Nothing"};
        int[] arrayToStoreInput = new int[optionsToChoose.length]; // array to store input values

        int numberOfPeopleSurveyed = 5; // To how many people we will ask the question

        // this loop will make sure that questions are asked to the required number of people
        for(int i = 0; i < numberOfPeopleSurveyed; i++) {

            //Ask the question
            System.out.println("Which thing would you most like to have on a Desert Island");
            for (int j = 0; j< optionsToChoose.length; j++) {
                System.out.print((j+1) + " = " + optionsToChoose[j] + ". ");
            }
            System.out.println();

            while (!scanner.hasNextInt()) {
                String wrongInput = scanner.nextLine();
                System.out.println("You have entered an invalid number or character" + " Please enter a valid number from above list");
            }
            int chosenOption = scanner.nextInt();

            //update array value based on chosen option
            arrayToStoreInput[chosenOption-1] = (arrayToStoreInput[chosenOption-1] + 1);

        } // end of for loop that control number of user input


        // check if more than one option has been chosen with most frequency
        int[] mostPopularOptionsIndexes = getIndexesOfMostPopularOption(arrayToStoreInput);
        int numberOfMostPopularOption = 0;
        //int mostPopularOptionIndex;
        for (int i = 0; i< mostPopularOptionsIndexes.length-1; i++) {
            if(mostPopularOptionsIndexes[i] == 1){
                numberOfMostPopularOption += 1;
            }
        }

        if(numberOfMostPopularOption == 1){
            System.out.println("Most popular option is: " );
        } else {
            System.out.println("These " + numberOfMostPopularOption+ " options have been chosen as most popular: ");
        }
        for(int i = 0; i < mostPopularOptionsIndexes.length-1; i++)  {
            if(mostPopularOptionsIndexes[i] == 1){
                System.out.println(optionsToChoose[i]);
            }
        }



    } // end of "public static void main(String[] args)"


    public static int[] getIndexesOfMostPopularOption(int[] givenArray){
        int valueOfPopularOption = givenArray[0];
        for(int j = 0; j <givenArray.length-1; j++){
            if(valueOfPopularOption < givenArray[j+1]){
                valueOfPopularOption = givenArray[j+1];
            }
        }

        int[] returnArray = new int[givenArray.length];
        for (int i = 0; i< givenArray.length-1; i++) {
            if(givenArray[i] == valueOfPopularOption){
                returnArray[i] = 1;
            }
        }

        return returnArray;
    }

} // end of ""public class DesertIsland
