import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Main class
        class Main {

                public String name;
                public int nationalID;
                
                
      // The template method is used by all the classes
    public void template(){

         System.out.println("Please enter name: ");

         Scanner input = new Scanner(System.in);
         name = input.nextLine();

         System.out.println("Please enter national ID number: ");
         nationalID = input.nextInt();

     }

    public class response extends Main {
            
            
            // Ticket number is written to the file
            public void takeResponse(){

                int ticketNumber =  (int)(Math.random() * 100);

                try{
                    FileWriter myResponse = new FileWriter(/*TYPE FILE PATH HERE(in quotes)*/name + nationalID + ".txt");
                    myResponse.write("Your ticket number is " + "'" +ticketNumber +"'"+ ". A teller will attend to you shortly.");
                    myResponse.close();
                    System.out.println("Your request has successfully been received");

                }catch(IOException e){

                    System.out.println("An unknown error occured");
                    e.printStackTrace();
                }

            }

    }

       // customer reads file to see ticket number
   public class viewResponse extends Main{

        public void readResponse(){

            try{
                File seeTicket = new File(name + nationalID + ".txt");
                Scanner readTicket = new Scanner(seeTicket);
                while(readTicket.hasNextLine()){
                    String info = readTicket.nextLine();
                    System.out.println(info);
                }
                readTicket.close();
            }catch(FileNotFoundException e){
                System.out.println("name or ID may be invalid.\nTicket may have not been requested");
                e.printStackTrace();
            }

        }

    }






    public static void main(String[] args) {

        int requestType;

        System.out.println("To request for ticket enter '0'");
        System.out.println("To get ticket number enter '1'");
        System.out.println("Enter response: ");

        Scanner takeRequest = new Scanner(System.in);
        requestType = takeRequest.nextInt();

            // Methods are called using conditional if statement
        if (requestType == 0){

            System.out.println("Hello cherished customer, we are glad to have you here today\nPlease fill the form below: \n");
            Main parent = new Main();
            Main.response myResponse = parent.new response();
            myResponse.template();
            myResponse.takeResponse();

        }else if (requestType == 1){
            Main parent = new Main();
            Main.viewResponse viewRes = parent.new viewResponse();
            viewRes.template();
            viewRes.readResponse();
        }else{
       
                System.out.println("Invalid input!")
        
        }
            




    }

}




