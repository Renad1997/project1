import java.util.InputMismatchException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try
        {
            char player = 'X';
            char computer = 'O';
            boolean isPlayerTurn = true;
            int rows = 3;
            int columns = 3;
            char[][] numbers = initGame();
            print2dArray(numbers, rows, columns);
            System.out.println("");
            while(true){
                if(isPlayerTurn){
                    System.out.println("Player turn");
                    int number = playerTurn();
                    System.out.println("you chose :" + number);
                    if(number == 0){break;}
                    if(number == -1)continue;
                    if(checkAvilablePosition(number,numbers)){
                        numbers =  assignValueIn2DArray(numbers , number,player);
                        print2dArray(numbers, rows, columns);
                        String checkWinner = checkWinner(numbers,rows,columns);
                        if(checkWinner.equals("Player Win")){
                            System.out.println("Congratulations! You won!");
                            numbers = initGame();
                            continue;
                        }else if(checkWinner.equals("Computer Win")){
                            System.out.println(" You lost!");
                            numbers = initGame();
                            continue;
                        }else if(checkWinner.equals("Draw")){
                            System.out.println("Draw!");
                            numbers = initGame();
                            continue;
                        }else{
                            isPlayerTurn = false;

                        }
                    }else{
                        System.out.println("you chose :" + number);
                        System.out.println("this position is not avilable :(");
                        continue;
                    }
                }else{
                    System.out.println("Computer turn");
                    int number = generateNumber(1,9);
                    System.out.println("computer chose :" + number);
                    if(checkAvilablePosition(number,numbers)){
                        numbers =  assignValueIn2DArray(numbers , number,computer);
                        print2dArray(numbers, rows, columns);
                        String checkWinner = checkWinner(numbers,rows,columns);
                        if(checkWinner.equals("Player Win")){
                            System.out.println("Congratulations! You won!");
                            numbers = initGame();
                            continue;
                        }else if(checkWinner.equals("Computer Win")){
                            System.out.println(" You lost!");
                            numbers = initGame();
                            continue;
                        }else if(checkWinner.equals("Draw")){
                            System.out.println("Draw!");
                            numbers = initGame();
                            continue;
                        }else{
                            isPlayerTurn = true;

                        }
                    }else{
                        System.out.println("computer chose :" + number);
                        System.out.println("this position is not avilable :(");
                        continue;
                    }
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }




    }
    /*this function create to initilization the value of game*/
    public static char[][] initGame(){
        char[][] numbers = new char[3][3];
        numbers[0][0] = '1';
        numbers[0][1] = '2';
        numbers[0][2] = '3';
        numbers[1][0] = '4';
        numbers[1][1] = '5';
        numbers[1][2] = '6';
        numbers[2][0] = '7';
        numbers[2][1] = '8';
        numbers[2][2] = '9';
        return numbers;
    }
    
    /*this function create to start the game*/
    public static int playerTurn(){
        try{

            System.out.println("chose number to play from 1 -> 9  or  0 to exit :");
            Scanner input = new Scanner(System.in);
            int number = input.nextInt();
            if(number >= 0 && number <= 9){
                return number;
            }else{
                return -1;
            }
        }catch(InputMismatchException e){
            System.out.println(e.getMessage()+"\nplease enter a valid number");
            return playerTurn();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return -1;
        }


}

    /*this function create to assign number to the game bord*/
    public static char[][] assignValueIn2DArray(char[][] arr, int n, char type) {
        switch (n) {
            case 1:
                arr[0][0] = type;
                break;
            case 2:
                arr[0][1] = type;
                break;
            case 3:
                arr[0][2] = type;
                break;
            case 4:
                arr[1][0] = type;
                break;
            case 5:
                arr[1][1] = type;
                break;
            case 6:
                arr[1][2] = type;
                break;
            case 7:
                arr[2][0] = type;
                break;
            case 8:
                arr[2][1] = type;
                break;
            case 9:
                arr[2][2] = type;
        }
        return arr;
    }

    /*this function create to print number on the game bord */
    public static void print2dArray(char[][] arr, int rows, int columns) {
        System.out.println("-----------------------------------------");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(arr[i][j] + "\t\t|\t\t");
            }
            System.out.println("\n");
        }
        System.out.println("-----------------------------------------");
    }

    /*this function create to generate random number from computer*/
    public static int generateNumber(int min , int max){
        int genratedNumber = 0;
        while(true){
            double number = Math.random() * 10;
            genratedNumber = (int) number;
            if(genratedNumber >= min && genratedNumber <= max){
                break;
            }
        }
        return genratedNumber;
    }

    /*this function create to check the Available position before play*/
    public static boolean checkAvilablePosition(int n,char[][] arr) {
        boolean isAvilable = true;
        switch (n) {
            case 1:
                if(arr[0][0] == 'X' ||arr[0][0] == 'O'){
                    isAvilable = false;
                }
                break;
                case 2:
                    if(arr[0][1] == 'X' ||arr[0][1] == 'O'){
                        isAvilable = false;
                    }
                    break;
                    case 3:
            if(arr[0][2] == 'X' ||arr[0][2] == 'O'){
                isAvilable = false;
            }
            break;
            case 4:
                if(arr[1][0] == 'X' ||arr[1][0] == 'O'){
                    isAvilable = false;
                }
                break;
                case 5:
                    if(arr[1][1] == 'X' ||arr[1][1] == 'O'){
                        isAvilable = false;
                    }
                    break;
                    case 6:
                        if(arr[1][2] == 'X' ||arr[1][2] == 'O'){
                            isAvilable = false;
                        }
                        break;
                        case 7:
                            if(arr[2][0] == 'X' ||arr[2][0] == 'O'){
                                isAvilable = false;
                            }
                            break;
                            case 8:
                                if(arr[2][1] == 'X' ||arr[2][1] == 'O'){
                                    isAvilable = false;
                                }
                                break;
                                case 9:
                                    if(arr[2][2] == 'X' ||arr[2][2] == 'O'){
                                        isAvilable = false;
                                    }
                                    break;
            default:
                isAvilable = false;
        }




        return isAvilable;
    }

    /*this function determine result of the games*/
    public static String checkWinner(char[][] arr, int rows, int columns) {
        String line = "";
        for (int i = 0; i < 8; i++) {
            switch (i) {
                case 0:
                    line = String.valueOf(arr[0][0])+String.valueOf(arr[0][1])+String.valueOf(arr[0][2]);
                    if (line.equals("XXX") ){
                       return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";
                    }

                case 1:
                    line = String.valueOf(arr[1][0])+String.valueOf(arr[1][1])+String.valueOf(arr[1][2]);
                    if (line.equals("XXX")){
                       return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";
                    }

                case 2:
                    line = String.valueOf(arr[2][0])+String.valueOf(arr[2][1])+String.valueOf(arr[2][2]);
                    if (line.equals("XXX")){
                       return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";
                    }

                case 3:
                    line = String.valueOf(arr[0][0])+String.valueOf(arr[1][0])+String.valueOf(arr[2][0]);
                    if (line.equals("XXX")){
                       return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";
                    }


                case 4:
                    line = String.valueOf(arr[0][1])+String.valueOf(arr[1][1])+String.valueOf(arr[2][1]);
                    if (line.equals("XXX")){
                        return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";

                    }

                case 5:
                    line = String.valueOf(arr[0][2])+String.valueOf(arr[1][2])+String.valueOf(arr[2][2]);
                    if (line.equals("XXX")){
                       return "Player Win";
                    }else if(line.equals("OOO") ){
                        return "Computer Win";
                    }

                case 6:
                    line = String.valueOf(arr[0][0])+String.valueOf(arr[1][1])+String.valueOf(arr[2][2]);
                    if (line.equals("XXX")){
                       return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";
                    }

                case 7:
                    line = String.valueOf(arr[0][2])+String.valueOf(arr[1][1])+String.valueOf(arr[2][0]);
                    if (line.equals("XXX")){
                       return "Player Win";
                    }else if(line.equals("OOO")){
                        return "Computer Win";
                    }
            }
        }
       ///// check if draw
        int counter = 0 ;
        for (int i = 0; i< rows; i++){
            for (int j = 0; j< columns; j++){
                if(arr[i][j] == 'X' || arr[i][j] == 'O'){
                    counter++;
                }
            }
        }
        if(counter == 9){
            return "Draw";
        }
        return "";
    }





}