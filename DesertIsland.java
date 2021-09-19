import java.util.Arrays;
import java.util.Scanner;

public class DesertIsland {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // available options to choose
        String[] optionsToChoose = {"Family", "Friends", "Netflix", "Laptop", "Guitar", "Cat", "Boat", "Bog", "Sofa", "Nothing"};
        int numberOfOptions = optionsToChoose.length;
        // array to store choices. Length of array depends on length of options to choose from
        int[] arrayToStoreChoices = new int[numberOfOptions];
        int chosenOption; // scan and store respective value for the chosen option

        int numberOfPeopleSurveyed = 10; // To how many people we will ask the questions

        // this loop will make sure that questions are asked to the required number of people
        for(int i = 0; i < numberOfPeopleSurveyed; i++) {
            System.out.println("Which thing would you most like to have on a Desert Island");
            for (int j = 0; j< numberOfOptions; j++) { //Ask the question. For loop will print all the options to choose from
                System.out.print((j+1) + " = " + optionsToChoose[j] + ". ");
            }
            System.out.println(); // make the line break after printing options

            chosenOption = isChosenOptionValid(numberOfOptions); //Get the value of the chosen option after validating the given data
            arrayToStoreChoices[chosenOption-1] = (arrayToStoreChoices[chosenOption-1] + 1); //update array value based on chosen option

        } // end of for loop that control number of user input


        // check if more than one options have been chosen as popular
        int[] mostPopularOptionsIndexes = getIndexesOfMostPopularOption(arrayToStoreChoices);
        int numberOfMostPopularOption = 0;
        for (int i = 0; i< mostPopularOptionsIndexes.length-1; i++) {
            if(mostPopularOptionsIndexes[i] == 1){
                numberOfMostPopularOption += 1;
            }
        }


        //print final result(s). check if there is more than one options were chosen as most popular
        if(numberOfMostPopularOption == 1){
            System.out.println("Most popular option is: " );
        } else {
            System.out.println("These " + numberOfMostPopularOption+ " options have been chosen as most popular: ");
        }
        for(int i = 0; i < mostPopularOptionsIndexes.length-1; i++)  { // find and print the option(s) that was chosen as most popular
            if(mostPopularOptionsIndexes[i] == 1){
                System.out.println("Option number " + (i+1) + ". " + (optionsToChoose[i]));
            }
        }

    } // end of "public static void main(String[] args)"



    // get the choice from the user and check if user has entered a number
    // plus check if the number is within range given or not
    public static int isChosenOptionValid(int numberOfOptions){
        Scanner scanner = new Scanner(System.in);
        int chosenOption = 0;
        while (true){
            while (!scanner.hasNextInt()) { //make sure that user has entered a number
                String wrongInput = scanner.nextLine();
                System.out.println("You have entered character as \"" + wrongInput + "\" Please enter a valid number from above list");
            }
            chosenOption = scanner.nextInt();
            if((chosenOption > 0) && (chosenOption <= numberOfOptions)){ // make sure that user has entered the right number within range
                break;
            } else {
                System.out.println("Please enter a valid number from above list");
            }
        }
        return chosenOption;
    }


    //this method calculate the most popular options
    public static int[] getIndexesOfMostPopularOption(int[] givenArray){
        //first check the highest value in the given array
        int valueOfPopularOption = givenArray[0];
        for(int j = 0; j <givenArray.length-1; j++){
            if(valueOfPopularOption < givenArray[j+1]){
                valueOfPopularOption = givenArray[j+1];
            }
        }

        //then check if there is more than one options have the same value
        //finally construct an array by assigning value 1 to the specific index if value of most popular option found there
        int[] returnArray = new int[givenArray.length];
        for (int i = 0; i< givenArray.length-1; i++) {
            if(givenArray[i] == valueOfPopularOption){
                returnArray[i] = 1;
            }
        }
        return returnArray;
    }

} // end of ""public class DesertIsland
