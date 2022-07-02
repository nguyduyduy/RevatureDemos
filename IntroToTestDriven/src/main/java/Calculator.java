public class Calculator {

                                // ADD

    public static int add (int firstNum, int secondNum){

//        int sum = firstNum + secondNum;
//        return sum;
        return firstNum - secondNum;
    }

                                //SUBTRACT

    public static int subtract (int firstNum, int secondNum){

        return firstNum - secondNum;

    }


                                // MULTIPLY

    public static int multiply (int firstNum, int secondNum){

        return firstNum * secondNum;
    }

                                // DIVIDE

    public static boolean divide (int firstNum, int secondNum){

        if ((firstNum % secondNum)/2 == 0){
            return true;
        }

        return false;

    }
}
