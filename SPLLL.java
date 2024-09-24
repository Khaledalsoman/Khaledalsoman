


public class SPLLL {

    public static void main(String[] args) {
        
        LinkedList linkedList = new LinkedList();
        String[] ClubNames = {"alIttihad", "alAhli", "alEttifaq", "alFateh", "alFayha",
            "alHilal", "alKhaleej", "alKholood", "alNassr", "alOkhdood",
            "alOrobah", "alQadsiah", "alRaed", "alRiyadh", "alShabab",
            "alTaawoun", "alWehda", "damacFC"};
        for (int i = 0; i < ClubNames.length; i++) {
            linkedList.ClubInsertion(ClubNames[i]);

        }
         // Matchweek 1 Results
         linkedList.Matches("alOkhdood", "alHilal", 0, 3);
         linkedList.Matches("alShabab", "alEttifaq", 0, 1);
         linkedList.Matches("alKholood", "alIttihad", 0, 1);
         linkedList.Matches("alAhli", "alOrobah", 2, 0);
         linkedList.Matches("alQadsiah", "alFateh", 3, 0);
         linkedList.Matches("damacFC", "alKhaleej", 0, 1);
         linkedList.Matches("alNassr", "alRaed", 1, 1);
         linkedList.Matches("alWehda", "alRiyadh", 3, 3);
         linkedList.Matches("alTaawoun", "alFayha", 1, 0);
 
        // Matchweek 2 Results
        linkedList.Matches("alIttihad", "alTaawoun", 2, 1);
        linkedList.Matches("alKhaleej", "alShabab", 0, 1);
        linkedList.Matches("alRiyadh", "alKholood", 3, 1);
        linkedList.Matches("alHilal", "damacFC", 3, 2);
        linkedList.Matches("alWehda", "alOrobah", 2, 1);
        linkedList.Matches("alEttifaq", "alOkhdood", 1, 0);
        linkedList.Matches("alFayha", "alNassr", 1, 4);
        linkedList.Matches("alRaed", "alQadsiah", 0, 1);
        linkedList.Matches("alFateh", "alAhli", 1, 0);

        // Matchweek 3 Results
        linkedList.Matches("alIttihad", "alWehda", 7, 1);
        linkedList.Matches("alKholood", "alOrobah", 3, 3);
        linkedList.Matches("alQadsiah", "alShabab", 0, 1);
        linkedList.Matches("alRiyadh", "alHilal", 0, 3);
        linkedList.Matches("alFayha", "alRaed", 0, 5);
        linkedList.Matches("alFateh", "alEttifaq", 1, 2);
        linkedList.Matches("alNassr", "alAhli", 1, 1);
        linkedList.Matches("damacFC", "alOkhdood", 3, 1);
        linkedList.Matches("alTaawoun", "alKhaleej", 2, 0);

        // Matchweek 4 Results
        linkedList.Matches("alHilal", "alIttihad", 3, 1);
        linkedList.Matches("alRaed", "alRiyadh", 1, 2);
        linkedList.Matches("alShabab", "alTaawoun", 1, 0);
        linkedList.Matches("alEttifaq", "alNassr", 0, 3);
        linkedList.Matches("alAhli", "damacFC", 4, 2);
        linkedList.Matches("alKhaleej", "alFayha", 0, 0);
        linkedList.Matches("alWehda", "alKholood", 0, 1);
        linkedList.Matches("alOrobah", "alFateh", 1, 0);
        linkedList.Matches("alOkhdood", "alQadsiah", 0, 0);
        
         linkedList.print();
    }

}

class LinkedList {

    Node head;

    public LinkedList() {
        head = null;
    }

    public void ClubInsertion(String Name) {
        Node newClub = new Node(Name);
        if (head == null) {
            head = newClub;

        } else {
            Node helptr;
            helptr = head;
            while (helptr.next != null) {
                helptr = helptr.next;
            }
            helptr.next = newClub;
        }

    }

    public void print() {
        Node helptr = head;
        System.out.printf("%-6s %-15s %-10s %-6s %-6s %-6s %-13s %-15s %-7s%n",
        "Rank", "Club", "Matches", "Wins", "Draw", "Loss", "Scored", "Received", "Points");
        int rank=1;
        while (helptr != null) {
            System.out.printf("%n %-6d %-15s %-10d %-6d %-6d %-6d %-13d %-15d %-7d%n",
            rank,
            helptr.Club,
            helptr.matchPlayed,
            helptr.wins,
            helptr.draw,
            helptr.loss,
            helptr.ScoredGoals,
            helptr.ReceivedGoals,
            helptr.Points);
        helptr = helptr.next; 
        rank++;
        }
    }

    public void Matches(String Club1, String Club2, int ScoredGoals1, int ScoredGoals2) {
        Node c1=search(Club1);
        Node c2=search(Club2);
        c1.matchPlayed+=1;
        c2.matchPlayed+=1;
        c1.ScoredGoals+=ScoredGoals1;
        c1.ReceivedGoals+=ScoredGoals2;
        c2.ScoredGoals+=ScoredGoals2;
        c2.ReceivedGoals+=ScoredGoals1;
        if (ScoredGoals1 > ScoredGoals2) {
            c1.Points+=3;
            c1.wins+=1;
            c2.loss+=1;
            

        }
        else if(ScoredGoals2 > ScoredGoals1){
            
            c2.Points+=3;
            c2.wins+=1;
            c1.loss+=1;

        }
        else{
            
            c1.Points+=1;
            c2.Points+=1; 
            c1.draw+=1;
            c2.draw+=1;

        }
        sort();

    }

    public Node search(String ClubName) {
        Node helptr = head;
        while (helptr != null) {
            if (helptr.Club.equalsIgnoreCase(ClubName)) {
                return helptr;
            }

            helptr = helptr.next;
        }
        return null;
    }
   public void sort() {
    if (head == null || head.next == null) {
        return; 
    }
    
    boolean swapped;
    Node helptr;
    Node previous = null; 
    
   
    do {
        swapped = false;
        helptr = head;
        
        while (helptr.next != previous) {
            if (helptr.Points < helptr.next.Points) {
               
                String tempClub = helptr.Club;
                int tempMatchPlayed=helptr.matchPlayed;
                int tempWins=helptr.wins;
                int tempDraw=helptr.draw;
                int tempLoss=helptr.loss;
                int tempPoints = helptr.Points;
                int tempScoredGoals = helptr.ScoredGoals;
                int tempReceivedGoals = helptr.ReceivedGoals;
                 

                helptr.matchPlayed=helptr.next.matchPlayed;
                helptr.wins=helptr.next.wins;
                helptr.draw=helptr.next.draw;
                helptr.loss=helptr.next.loss;
                helptr.Club = helptr.next.Club;
                helptr.Points = helptr.next.Points;
                helptr.ScoredGoals = helptr.next.ScoredGoals;
                helptr.ReceivedGoals = helptr.next.ReceivedGoals;

                helptr.next.matchPlayed=tempMatchPlayed;
                helptr.next.wins=tempWins;
                helptr.next.draw=tempDraw;
                helptr.next.loss=tempLoss;
                helptr.next.Club = tempClub;
                helptr.next.Points = tempPoints;
                helptr.next.ScoredGoals = tempScoredGoals;
                helptr.next.ReceivedGoals = tempReceivedGoals;

                swapped = true;
            }
            helptr = helptr.next;
        }
        previous = helptr; 
    } while (swapped);
}
}

class Node {

    Node next;
    int Points;
    String Club;
    int ScoredGoals;
    int ReceivedGoals;
    int wins;
    int loss;
    int draw;
    int matchPlayed;

    public Node(String Club) {
        this.Club = Club;
         Points = 0;
         ScoredGoals = 0;
         ReceivedGoals = 0;
         wins=0;
         loss=0;
         draw=0;
         matchPlayed=0;
        next = null;
    }

}
