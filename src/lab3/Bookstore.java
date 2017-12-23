//import  package
package lab3;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;

public class Bookstore {
    //declare object
    private static Scanner scan = new Scanner(System.in);
    private static ArrayList<Book> bookList = new ArrayList<Book>();
    private static Book newBook = new Book();

    //decalre var
    private static int menu = 0;
    private static String title, author, isbn, input, subject, workbookISBN;
    private static int year = 0, numProblems;
    private static double price;
        
    public static void main(String[] args) {
        //loop until exit
        while(menu != 8){
            //display the options
            System.out.println("1. Add a unique book to the inventory");
            System.out.println("2. Print out information on each book");
            System.out.println("3. Print out all unique authors");
            System.out.println("4. Print out the average book price & total books");
            System.out.println("5. Print out all Textbook-Workbook pairs in the inventory");
            System.out.println("6. Save the state of the inventory to a file");
            System.out.println("7. Load the state of the inventory from a file");
            System.out.println("8. Quit");
            //ask the user
            do{
                System.out.print("Which option do you want? ");
                input = scan.nextLine();
                menu = tryCatchInt(input);
            }while(menu < 1 || menu > 8);
            //choose menu
            if(menu == 1){
                option1();
            }else if(menu == 2){
                option2();
            }else if(menu == 3){
                option3();
            }else if(menu == 4){
                option4();
            }else if(menu == 5){
                option5();
            }else if(menu == 6){
                option6();
            }else if(menu == 7){
                option7();
            }else if(menu == 8){
                System.out.println("Exiting program...");
            }//end if
        }//end while
    }//end main
    
    public static int tryCatchInt(String toBeConverted){
        int number = 0;
        try{
            number = Integer.parseInt(toBeConverted);
        }catch(NumberFormatException E){
            System.out.println("WRONG FORMAT");
            return number = -1;
        }//end catch
        return number;
    }//end  func
    
    public static double tryCatchDouble(String toBeConverted){
        double number = 0;
        try{
            number = Double.parseDouble(toBeConverted);
        }catch(NumberFormatException E){
            System.out.println("WRONG FORMAT");
            return number = -1;
        }//end catch
        return number;
    }//end  func
    
    public static void askTitle(){
        //enter title
        do{
            //ask the user of the book
            System.out.print("Enter the title: ");
            title = scan.nextLine();
        }while(title.equals(""));
    }//end func
    
    public static void askAuthor(){
        //enter author
        do{
            //ask the user of the book
            System.out.print("Enter the author: ");
            author = scan.nextLine();
        }while(author.equals(""));
    }//end func
    
    public static void askYear(){
        //enter year
        do{
            //ask the user of the book
            System.out.print("Enter the year: ");
            input = scan.nextLine();
            year = tryCatchInt(input);
        }while(year < -2600 || year > 2017);
    }//end func
    
    public static void askISBN(){
        //enter isbn
        boolean exit;
        do{
            exit = false;
            //ask the user of the book
            System.out.print("Enter the ISBN: ");
            isbn = scan.nextLine();
            if(isbn.length() == 10 || isbn.length() == 13){
                exit = true;
            }//end if
            for(int x = 0; x < bookList.size(); x++){
                if(bookList.get(x).getISBN().equals(isbn)){
                    System.out.println("Found existing ISBN");
                    exit = false;
                }//end if
            }//end for
        }while(exit == false);
    }//end func
    
    public static void askPrice(){
        //enter price
        do{
            //ask the user of the book
            System.out.print("Enter the Price: ");
            input = scan.nextLine();
            price = tryCatchDouble(input);
        }while(price < 0);
    }//end func
    
    public static void askSubject(){
        //enter subject
        do{
            //ask the user of the book
            System.out.print("Enter the subject: ");
            subject = scan.nextLine();
        }while(subject.equals(""));
    }//end func
    
    public static void askNumProblems(){
        //enter numproblem
        do{
            //ask the user of the book
            System.out.print("Enter the number of problems ");
            input = scan.nextLine();
            numProblems = tryCatchInt(input);
        }while(numProblems < 1);
    }//end func
    
    public static void askWorkbookISBN(){
        
        
        //enter isbn
        boolean exit;
        do{
            exit = false;
            //ask the workbook
            System.out.print("Enter the workbook ISBN: ");
            workbookISBN = scan.nextLine();
            if(workbookISBN.length() == 10 || workbookISBN.length() == 13){
                exit = true;
            }//end if
            for(int x = 0; x < bookList.size(); x++){
                if(bookList.get(x).getISBN().equals(isbn)){
                    System.out.println("Found existing ISBN");
                    exit = false;
                }//end if
            }//end for
        }while(exit == false);
    }//end func
    
    public static void askBookType(){
        //enter symbol
        do{
            //ask the user of the book
            System.out.println("1) Book");
            System.out.println("2) Textbook");
            System.out.println("3) Workbook");
            System.out.print("Enter 1, 2 or 3: ");
            input = scan.nextLine();
            menu = tryCatchInt(input);
        }while(menu < 1 || menu > 3);
    }//end method 
    
    public static void option1(){
        //ask the user
        askBookType();
        askTitle();
        askAuthor();
        askYear();
        askPrice();
        askISBN();
        //ask 
        if(menu == 1){
            bookList.add(new Book(title, author, year, price, isbn));
        }else if (menu == 2){
            askWorkbookISBN();
            askSubject();
            bookList.add(new Textbook(title, author, year, price, isbn, workbookISBN, subject));
            System.out.println("Textbook added...");
        }else if(menu == 3){
            askNumProblems();
            bookList.add(new Workbook(title, author, year, price, isbn, numProblems));
            System.out.println("Workbook added...");
        }//end if
    }//end func
    
    public static void option2(){
        //print the books in the list
        int bookNumber = 0;
        System.out.println("***************************************");
        for(int x=0; x < bookList.size(); x++){
            bookNumber++;
            System.out.println("Book Number: " + bookNumber);
            newBook = bookList.get(x);
            newBook.toString();
            System.out.println("***************************************");
        }//end for loop
    }//end func
    
    public static void option3(){
        boolean sameAuthor;
        System.out.println("***************************************");
        System.out.println("List of author available...");
        //check if any author is the same if not print
        for(int x=0; x < bookList.size(); x++){
            sameAuthor = false;
            for(int y=1+x; y < bookList.size(); y++){
                System.out.println(bookList.get(x).getAuthor() + " and " + bookList.get(y).getAuthor());
                if(bookList.get(x).getAuthor().equals(bookList.get(y).getAuthor())){
                    sameAuthor = true;
                    //System.out.println(sameAuthor);
                }//end if
            }//end loop
            if(sameAuthor == false){
                System.out.println(bookList.get(x).getAuthor());
            }//end if
        }//end for loop
        System.out.println("***************************************");
    }//end func
    
    public static void option4(){
        //set object of 2 decimal format
        DecimalFormat twoDecimal = new DecimalFormat();
        twoDecimal.setMaximumFractionDigits(2);
        //declare var
        double averagePrice = 0;
        for(int x=0; x < bookList.size(); x++){
            newBook = bookList.get(x);
            averagePrice = averagePrice + newBook.getPrice();
        }//end for loop
        averagePrice = averagePrice/bookList.size();
        System.out.println("***************************************");
        System.out.println("Calculating...");
        System.out.println("The average price of all book is $" + twoDecimal.format(averagePrice));
        System.out.println("And the total number of book is " + bookList.size());
        System.out.println("***************************************");
    }//end func
    
    public static void option5(){
        Workbook workbook;
        Textbook textbook;
        System.out.println("***************************************");
        System.out.println("List of pair books...");
        //check if any author is the same if not print
        for(int x=0; x < bookList.size(); x++){
            for(int y=0; y < bookList.size(); y++){
                if (bookList.get(y) instanceof Textbook) {
                    textbook = (Textbook)bookList.get(y);
                    //System.out.println("Comparing..." + textbook.getTitle() + " and " + bookList.get(x).getTitle());
                    if(textbook.equals(bookList.get(x)) == true){
                        System.out.println(bookList.get(y).getTitle() + " = " + bookList.get(x).getTitle());
                    }//end if
               }//end if
            }//end loop
        }//end for loop
        System.out.println("***************************************");
    }//end func
    
    public static void option6(){
        //declare var
        String fileName = "data.txt";
        Textbook textbook;
        Workbook workbook;
        Book book;
        // Write to a file
        BufferedWriter writer;
        try{
            writer = new BufferedWriter(new FileWriter(fileName));
            for(int x = 0; x < bookList.size(); x++){
                bookList.get(x);
                if(bookList.get(x) instanceof Textbook){
                    textbook = (Textbook)bookList.get(x);
                    writer.write(textbook.data());
                }else if(bookList.get(x) instanceof Workbook){
                    workbook = (Workbook)bookList.get(x);
                    writer.write(workbook.data());
                }else if(bookList.get(x) instanceof Book){
                    book = (Book)bookList.get(x);
                    writer.write(book.data());
                }//end if
                writer.newLine();
            }//end for
            System.out.println("Saving...");
            writer.close();
        } catch(IOException e){
            System.out.println("Failed to write to "+fileName+".");
        }//end try
    }//end func
    
    public static void option7(){
        //declare var
        String fileName = "data.txt";
        // Read the file
        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            int yearData = 0;
            double priceData = 0;
            int numProbData = 0;
            int count = 0;
            System.out.println("***************************************");
            System.out.println("Loading...");
            while (line != null){
                String[] data = line.split("@");
                
                //for debug
                System.out.println(line);
                /*for(int x=0; x < data.length; x++){
                    System.out.println("Split: " + data[x]);
                }*/
     
                if(data[0].equals("t")){
                   yearData = Integer.parseInt(data[3]);
                   priceData = Double.parseDouble(data[4]);
                   bookList.add(new Textbook(data[1], data[2], yearData, priceData, data[5], data[6], data[7])); 
                }//en if 
                if(data[0].equals("w")){
                   yearData = Integer.parseInt(data[3]);
                   priceData = Double.parseDouble(data[4]);
                   numProbData = Integer.parseInt(data[6]);
                   bookList.add(new Workbook(data[1], data[2], yearData, priceData, data[5], numProbData));
                }if(data[0].equals("b")){
                   yearData = Integer.parseInt(data[3]);
                   priceData = Double.parseDouble(data[4]);
                   bookList.add(new Book(data[1], data[2], yearData, priceData, data[5]));
                }//end if
                line = reader.readLine();
            }//end while
            System.out.println("***************************************");
            reader.close();
        } catch(IOException e){
            System.out.println("Failed to read "+fileName+".");
        }//end try
    }//end func
}//end class
