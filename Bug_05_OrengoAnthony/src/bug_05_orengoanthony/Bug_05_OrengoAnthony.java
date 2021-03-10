package bug_05_orengoanthony;
/*Description: This program displays the price per pound for food food grades
A, B, and C.
 *Programmer: Anthony Orengo
 *Date: 02.12.2020 
 */

import java.util.Scanner;
public class Bug_05_OrengoAnthony       
{
   public static void main(String[] args)
   {
      String input;     // To hold the user's input
      char foodGrade;   // Grade of pet food
      
      Scanner keyboard = new Scanner(System.in);
      System.out.println("Our pet food is available in three grades:");
      System.out.print("A, B, and C. Which do you want pricing for? ");
      input = keyboard.nextLine();
      foodGrade = input.charAt(0);
      switch(foodGrade)
      {
         case 'a':
         case 'A':
            System.out.println("30 cents per lb.");
            break;
         case 'b':
         case 'B':
            System.out.println("20 cents per lb.");
            break;
         case 'c':
         case 'C':
            System.out.println("15 cents per lb.");
            break;
         default:
            System.out.println("Invalid choice.");
        }
   }
}
