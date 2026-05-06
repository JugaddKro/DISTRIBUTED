import java.util.*;
public class PR5_TokenRing
{    public static void main(String[] args)
    {   Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number of Nodes You Want In The Ring: "); 
        int n= sc.nextInt();                
        System.out.println("Ring Formed Is As Below: ");   
        for(int i=0; i<n; i++)  
        {    System.out.print(i +" ");   
        }
        System.out.println("0");                    
        int choice = 0; 
        do
        {   System.out.print("Enter Sender: "); 
            int sender= sc.nextInt();           
            System.out.print("Enter Receiver: "); 
            int receiver= sc.nextInt();         
            System.out.print("Enter Data To Send: ");  
            int data= sc.nextInt();                    
            int token = 0;
            System.out.print("Token Passing: "); 
            for(int i=token; i<sender; i++) 
            {
                System.out.print(" "+i+"->"); 
            }
            System.out.println(" "+ sender);                 
            System.out.println("Sender: P" + sender+" Sending Data: "+ data);  
            for(int i=sender; i!=receiver; i= (i+1)%n)
            {
                System.out.println("Data: "+data+" Forwarded By: P"+i+" To P"+((i+1)%n));
            }
            System.out.println("Receiver: P"+ receiver +" Received The Data: "+ data);
            System.out.print("Do You Want To Send Data Again? If YES Enter 1, If NO Enter 0: ");
            choice =sc.nextInt();
        }
        while(choice == 1);
    }
}
/*OUTPUT:  run:
Enter Number of Nodes You Want In The Ring: 5
Ring Formed Is As Below: 
0 1 2 3 4 0
Enter Sender: 1
Enter Receiver: 4
Enter Data To Send: 100
Token Passing:  0-> 1
Sender: P1 Sending Data: 100
Data: 100 Forwarded By: P1 To P2
Data: 100 Forwarded By: P2 To P3
Data: 100 Forwarded By: P3 To P4
Receiver: P4 Received The Data: 100
Do You Want To Send Data Again? If YES Enter 1, If NO Enter 0: 1
Enter Sender: 3
Enter Receiver: 2
Enter Data To Send: 100
Token Passing:  0-> 1-> 2-> 3
Sender: P3 Sending Data: 100
Data: 100 Forwarded By: P3 To P4
Data: 100 Forwarded By: P4 To P0
Data: 100 Forwarded By: P0 To P1
Data: 100 Forwarded By: P1 To P2
Receiver: P2 Received The Data: 100
Do You Want To Send Data Again? If YES Enter 1, If NO Enter 0:0

 */
