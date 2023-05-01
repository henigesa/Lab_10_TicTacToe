import java.util.Scanner;

public class SafeInput
{
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        boolean done = false;
        int retValue = 0;
        String trash = "";

        do {

            System.out.print("\n" + prompt + "[" + low + " - " + high + "]: ");
            if(pipe.hasNextInt())
            {
                retValue = pipe.nextInt();
                pipe.nextLine();
                if(retValue >= low && retValue <= high)
                    done = true;
                else
                    System.out.println("You must enter a value in range: " + trash);

            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid int: " + trash);
            }

        }while(!done);

        return retValue;

    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotAVal = false;

        do
        {
            System.out.print("\n" + prompt + "(y or n)");
            response = pipe.nextLine();
            if (response.equalsIgnoreCase("n"))
            {
                gotAVal = true;
                retVal = true;
            } else if (response.equalsIgnoreCase("n")) {
                gotAVal = true;
                retVal = false;
            }
            else {
                System.out.println("(y or n) " + response);
            }
        }
        while (!gotAVal);
        return retVal;
    }
}
