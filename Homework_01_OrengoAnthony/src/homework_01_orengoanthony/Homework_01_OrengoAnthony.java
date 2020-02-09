/*Description: This program calculates the buy and sell transactions for stocks,
 using the JOptionPane method. 
 *Programmer: Anthony Orengo
 *Date: 01.25.2020 
 */
package homework_01_orengoanthony;

//Used to display JOptionPane Dialog box
import javax.swing.JOptionPane;
//Decimal format object for decimal variables
import java.text.DecimalFormat;
//Formats the date and time
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import java.util.Date;
//Object class to create random numbers
import java.util.Random;
import javax.swing.ImageIcon;



public class Homework_01_OrengoAnthony {

    
    //--------------Beginning of main method--------------------------//
    public static void main(String[] args) {
                
        stock();// Calls the method stock()
        
    } 
    //=============End of main method=================================//
    
    
    //------------------Beginning of stock method----------------------------//
    public static void stock(){
             
     //------Set random int gen,decimal format, date/time, and image icon----//
        
        //Random int generator (10)
        Random order = new Random(); 
        int order_Number = order.nextInt(1000000000); 
        int order_Number2 = order.nextInt(1000000000); 
        
        //Displays numbers in currency format
        DecimalFormat dollar = new DecimalFormat("$0.00");
        //Diplays numbers in decimal format using the first decimal place
        DecimalFormat dec = new DecimalFormat("0");

        //Date time format object to generate current time of transaction
        Date date = new Date();
        LocalDateTime currentTime = LocalDateTime.now(); 
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(
                                       "yyyy/MM/dd HH:mm:ss");         
              
        //Custom image icon for dialog box//
        ImageIcon tradeSymbol = new ImageIcon("OTResize.png");
        ImageIcon boxSymbol = new ImageIcon("OTResize2.png");
     //=======================================================================//
        
     //------------------------Declared Variables-----------------------------//
        //Constant variables
        double TRADE_FEE = .02d;       
         
        //Declared variables
        int shares = 0;
        double stockPrice = 0.0d;   
        String tickerSymbol;       
        String type;
        String input;
        String title = "Welcome to Orengo Trade";
          
     
     //**************Beginning of stock purchase transaction*****************//     
     
        //Welcome dialog box        
        JOptionPane.showMessageDialog(null,"Press OK to Enter",
               title, JOptionPane.INFORMATION_MESSAGE,tradeSymbol);
        
        //Get ticker/stock symbol from user
        tickerSymbol = JOptionPane.showInputDialog(null, 
                 "Enter Ticker Symbol: ","Ticker Symbol",JOptionPane.NO_OPTION);                                
        
        //Get fill type from user (Market or Limit)
        type = JOptionPane.showInputDialog(null, "Market/Limit", "Fill Type",
                                                    JOptionPane.NO_OPTION);
       
        //Get user to enter amount of ahres to be purchased
        input = JOptionPane.showInputDialog(null,"How many shares : ","Shares",
                                                    JOptionPane.NO_OPTION);
        shares = Integer.parseInt(input); //Converts String to Integer//
        
        //Get user to enter current stock price
        input = JOptionPane.showInputDialog(null,"Enter stock price: ","Shares",
                                                    JOptionPane.NO_OPTION);        
        stockPrice = Double.parseDouble(input);//Converts String to Double//
        
        
        //Declared variables to calculate stock purchase to include fees-----//
        double stockPurchase = shares * stockPrice;        
        double purchaseFee = TRADE_FEE * stockPurchase;
        double totalPurchase = stockPurchase + purchaseFee;
        
        
        //Object array to display stock purchase transaction
        String [] stockPur = {
           
           "******************************",
           "Order#:  " + order_Number,
           "Filled:  " + type,
           "Ticker Symbol:  " + tickerSymbol,
           "",
           "Account:  " + "OrengoA0000",
           "Expires:  " + "DAY",
           "Routing:  " + "SMART",
           "Special Inst: " + dtf.format(currentTime),
           "Purchase Shares:  " + shares,
           "Stock Price:  " +  dollar.format(stockPrice),
           "Total Price:  " + dollar.format(stockPurchase),
           "Commission Fee:  " + dollar.format(purchaseFee),
           "Total Purchase Price :  " + dollar.format(totalPurchase),
           "***********************************"
        };
        
            
            //Displays object array "stockPur in JOptionPane dialog box
            JOptionPane.showMessageDialog(null, stockPur,
               "Stock Purchase Transaction",JOptionPane.INFORMATION_MESSAGE,
                                                                 boxSymbol);
       
       //*************End of stock purchase transaction********************//
       
        
        
        /*This section of the program gives the user the option to sell 
        his/her shares or end the program.*/
        
            //Object array to display stock option menu
            Object [] menu = 
            {
                
                "Would you like to sell shares?",
                "Enter 1: Yes",
                "Enter 2: No"
            };
          
          //Displays object array "menu in JOptionPane dialog box  
          String purchaseChoice = JOptionPane.showInputDialog(null, menu, 
                                      "*WARNING*",JOptionPane.OK_CANCEL_OPTION);
          //Converts purchaseOption to int
          int purchaseOption = Integer.parseInt(purchaseChoice);
          
          //Gives user the option to continue or not.
          if(purchaseOption == 1)
          {
          }
          else if(purchaseOption == 2){
             JOptionPane.showMessageDialog(null, "Good Bye!"); 
             //Ends program
             System.exit(0);
          }   
          
     //*****************Beginning of stock sell transaction******************//
                      
        //---------------Declared Variables for stock sell----------//
        double percentShares;
        double sellPrice;     
        double sellAmount;  
       
        
       //Welcome back dialog box  
      JOptionPane.showMessageDialog(null,"Welcome Back to Orengo Trade",
                title, JOptionPane.OK_CANCEL_OPTION,tradeSymbol);  
      
     //tickerSymbol = JOptionPane.showInputDialog(null,"Enter Ticker Symbol: "); 
        
        // Get current stock price from user
       input = JOptionPane.showInputDialog(null,"Enter stock price: ",
                                  "Current Stock Price",JOptionPane.NO_OPTION);        
       stockPrice = Double.parseDouble(input); 
        
       //input = JOptionPane.showInputDialog(null,"Enter number of shares: ");
       // shares = Integer.parseInt(input);
        
       //Get percentage of shares the user wants to sell
        input = JOptionPane.showInputDialog(null,
                                    "What percentage would you like to sell? ", 
                                    "Percent of Shares",JOptionPane.NO_OPTION);
        percentShares = Double.parseDouble(input);
        
        //Calculates the percentage of shares to be sold
        double sharesPercent = percentShares / 100;
        double stockPurPercent = sharesPercent * totalPurchase;
        //Calculates the amount of shares to be sold
        double sharesToSell = sharesPercent * shares;       
        
        //Total amount from sell shares
        double sell = sharesToSell * stockPrice; 
        
        //Total fees equals totalSell + TRADE_FEE 
        double sellFee = sell * TRADE_FEE;
        /*Calculates the total profit by subtracting tade fees and 
        purchase price from total sell.*/
        double totalSell = sell - sellFee;
        double totalFees= sellFee+ purchaseFee;
        double profit = (totalSell - stockPurPercent); 
        
        //Totals shares left over//
        double sharesRemaining = shares - sharesToSell;
        //Current account value after transaction
        double currentValue = sharesRemaining * stockPrice; 
        
        //Object array to display stock sell transaction
         String[] stockSel = {
           
           "******************************",
           "Order#:  " + order_Number2,
           "Filled:  " + "Limit",
           "Ticker Symbol:  " + tickerSymbol,
           "",
           "Account:  " + "OrengoA0000",
           "Expires:  " + "DAY",
           "Routing:  " + "SMART",
           "Special Inst:  " + dtf.format(currentTime),
           "Sell Shares:  " + dec.format(sharesToSell),
           "Stock Price:  " +  dollar.format(stockPrice),
           "Sell Price:  " + dollar.format(sell),
           "Commission Fee: " + dollar.format(sellFee),
           "Total Sell Price:  "  + dollar.format(totalSell),
           "***********************************"
       };      
       
       
      JOptionPane.showMessageDialog(null, stockSel,"Stock Sell Transaction",
                                   JOptionPane.INFORMATION_MESSAGE,boxSymbol);
      
      Object [] menuSell = {
                
            "Do you wish to continue",
             "Enter 1: Yes",
             "Enter 2: No"
        };
      
      String sellChoice = JOptionPane.showInputDialog(null, menuSell, 
                                     "*WARNING*",JOptionPane.OK_CANCEL_OPTION);
          int sellOption = Integer.parseInt(sellChoice);
          
          
          //Gives user the option to continue or not.
          if(sellOption == 1)
          {
             
          }
          else if(sellOption == 2){
             JOptionPane.showMessageDialog(null, "Good Bye!"); 
             System.exit(0);
          }   
         
      //Object array to display stock transaction Summary 
      Object[] transactionSum = new Object[]
      {
          "*******************************",
          "     Transaction Summary",
          "*******************************",
          " ",
          "Stock Purchase Summary",
           stockPur,
          "Stock Sell Summary",
           stockSel,
          "Account Summary",
          "*******************",
          "Total Profit: " + dollar.format(profit),
          "Shares Remaining: " + dec.format(sharesRemaining),
          "Current Account Value: " + dollar.format(currentValue)
          
      };
      
     JOptionPane.showMessageDialog(null,transactionSum,"Stock Trade Summary",
                                   JOptionPane.INFORMATION_MESSAGE,boxSymbol);
     
     
            
     JOptionPane.showMessageDialog(null,"Thank you for using Orengo Trade!",
                                   "End of Transaction",
                                   JOptionPane.INFORMATION_MESSAGE,boxSymbol);

      //****************End of stock sell transaction***********************// 
      
    }    
    //================Ending of stock method================================//          
    
     
}//Ending of Homework_01_OrengoAnthony//
