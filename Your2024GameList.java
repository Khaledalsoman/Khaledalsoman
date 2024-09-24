import java.util.Scanner;

public class Your2024GameList {
    
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.insert("Dragon's Dogma 2", 60, 100);
        linkedList.insert("Luigi's Mansion 2 HD", 15, 25);
         linkedList.insert("Prince of Persia: The Lost Crown", 15, 20);
        linkedList.insert("Shin Megami Tensei V: Vengeance", 40, 80);
        linkedList.insert("Final Fantasy 7 Rebirth", 70, 200);
        linkedList.insert("Like a Dragon: Infinite Wealth", 40, 100);
        linkedList.insert("Persona 3 Reload", 45, 100);
        linkedList.insert("Tekken 8", 30, 50);
        linkedList.insert("Elden Ring: Shadow of the Erdtree", 50, 100);
        linkedList.insert("Stellar Blade", 15, 25);
        linkedList.insert("Astro Bot", 10, 15);
        linkedList.insert("Rise of the Ronin", 30, 60); 
        linkedList.enterRatings();
        linkedList.print();
        
    }
}

class LinkedList {
    
    Node head;
    
    public Node search(String gameName) {
        Node helptr = head;
        while(helptr!=null){
            if(helptr.game.equalsIgnoreCase(gameName)){
                return helptr;
            }
            helptr=helptr.next;
        }
        return null;
    }
    public void insert(String game, int finishTime, int completionList){
        Node addGame=new Node(game, finishTime, completionList);
        if(head==null){
            head=addGame;
        }
        else{
            Node helptr=head;
            while (helptr.next!=null) {
                helptr=helptr.next;
            }
            helptr.next=addGame;
        }
    }
 
    public void enterRatings() {
        Node helptr = head;
        Scanner scanner = new Scanner(System.in);

        while (helptr != null) {
            System.out.print("Enter rating out of 100 for " + helptr.game + ": ");
            helptr.rating = scanner.nextInt(); 
       
            helptr = helptr.next;  
        }
        scanner.close();  
    }
    


    public void print() {
        Node helptr = head;

        // Print the header
        System.out.printf("%-40s %-10s %-10s %-10s %n", "Game", "Duration", "100%", "Rating");

        // Print each game's information
        while (helptr != null) {
            System.out.printf("%-40s %-10d %-10d %-10d %n", helptr.game, helptr.finishTime, helptr.completionList, helptr.rating);
            helptr = helptr.next;
        }
    }
            
    public void sort(){
        
    }
        }
    
    
    class Node {
        
        Node next;
        String game;
        int finishTime;
        int completionList;
        int rating;
        
        
        public Node(String game, int finishTime, int completionList) {
            this.game = game;
            this.finishTime = finishTime;
            this.completionList = completionList;
            this.rating=0;
            this.next = null;
        }
    }
