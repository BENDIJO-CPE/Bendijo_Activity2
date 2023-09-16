package bendijo_act2.bookworm;

import java.util.Scanner;

class Node{
             
    String author, title, ISBN;
        Node next;
        
Node (String author, String title, String ISBN){
        this.author = author;
        this.title = title;
        this.ISBN = ISBN;

        next = null;
        }
    }

public class Bendijo_Act2Bookworm {
    
private Node head;
private int size;

public Node insertNode (String author, String title, String ISBN){
    Node newNode = new Node (author, title, ISBN);
    newNode.next = head;
    head = newNode;
    size++;
    return head;
    }        

public void display(){
         Node node = head;
            while (node != null){
                System.out.println("Author: " + node.author + ", Title: " + node.title + ", ISBN: " + node.ISBN);
                node = node.next;
     }
         System.out.println();
     }

public void searchAuthor(String targetAuthor){
        Node current = head;
        
        boolean found = false;

        while (current != null ) {
            if (current.author.equalsIgnoreCase(targetAuthor)) {
                found = true;
                System.out.println("\nThe author" + "'" + current.author + "'" + " is FOUND in the BOOK: \n");
                System.out.println("Author: " + current.author + ", Title: " + current.title + ", ISBN: " + current.ISBN + "\n" );
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("Author is UNKNOWN");
        }
    }

public void searchTitle(String targetTitle) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.title.equalsIgnoreCase(targetTitle)) {
                found = true;
                System.out.println("\nBook " + "'" + current.title + "'" + " is FOUND \n");
                System.out.println("Author: " + current.author + ", Title: " + current.title + ", ISBN: " + current.ISBN + "\n" );
                System.out.println();
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("THERES NO SUCH TITLE OF THE BOOK");
        }
    }

public void searchIsbn(String targetIsbn) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.ISBN.equalsIgnoreCase(targetIsbn)) {
                found = true;
                System.out.println("\nBook " + "'" + current.ISBN + "'" + " is FOUND \n");
                System.out.println("Author: " + current.author + ", Title: " + current.title + ", ISBN: " + current.ISBN + "\n" );
                System.out.println();
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("ISBN is not FOUND");
        }
    }
   
public static void main(String[] args) throws Exception{
        Bendijo_Act2Bookworm main = new Bendijo_Act2Bookworm ();
        
        Scanner scan = new Scanner (System.in);
        boolean start = true;
        

        while(start){
            
        System.out.println("==========MENU=========");
        System.out.println("[1] Add a Book");
        System.out.println("[2] Search a Book");
        System.out.println("[3] Display Library\n");
        int menuInput = scan.nextInt();
        
            switch (menuInput) {
                case 1:
                    System.out.println("Author's name: ");
                    String addauthor = scan.next();
                    System.out.println("Book title: ");
                    String addtitle = scan.next();
                    System.out.println("Enter the ISBN");
                    String addISBN = scan.next();
                    System.out.println("\n\nNew Added Book Details: \nAuthor's Name: " + addauthor + "\nTitle: " + addtitle + "\nISBN: " + addISBN + "\n");
                    main.insertNode(addauthor, addtitle, addISBN );
                    break;

                default:
                    
                case 2:                    
                        System.out.println("====Search=====");
                        System.out.println("[1] Author");
                        System.out.println("[2] Title");
                        System.out.println("[3] ISBN\n");
                        int searchInput = scan.nextInt();
                        
                        switch (searchInput) {
                            case 1:
                                
                                System.out.println("Search the author's name: ");
                                scan.nextLine();
                                String searchAUTHOR = scan.nextLine();                      
                                main.searchAuthor(searchAUTHOR);
                                break;
                                

                            case 2:
                                System.out.println("Search the title of the book: ");
                                scan.nextLine();
                                String searchTITLE = scan.nextLine();
                                main.searchTitle(searchTITLE);
                                break;
                                
                            case 3:
                                System.out.println("Search the ISBN: ");
                                scan.nextLine();
                                String searchISBN = scan.nextLine();
                                main.searchIsbn(searchISBN);
                                break;
                                
                            default:
                        }
                case 3: 
                    main.display();
                    break;
                case 4: 
                    throw new Exception("Invalid input");
                
                        }
                    }
            }
    }
    

