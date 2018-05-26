import java.util.Scanner;
public class View
{
   /*Metoda printon ne konzole tabelen e lojes 
   @param tabela e cila do te printohet
   */
   public void printBoard(char[][] board)
   {
      for(int r=0;r<board.length;r++)
      {
         System.out.println();
         for(int c=0;c<board[r].length;c++)
         {
            System.out.print(board[r][c]);
            System.out.print("    ");
         }
      }
      System.out.println("\n");
   }
   /*Metoda paraqet intefejsin per te marre levizjen e perdoruesit
   return -levizjen e lojtarit*/
   public String getUserMoveInterface()
   {
      Scanner scanner = new Scanner(System.in);
      System.out.println("user move:");
      String usermove = scanner.next();
      return usermove;
   }
   /*Metoda kerkon nga lojtari te perseris lojen apo jo
   return- pergjigjen e lojtarit*/
   public String anotherGame()
   {
      Scanner scanner = new Scanner(System.in);
      System.out.print("Do you want to play again, pres Y if yes:");
      String x=scanner.next();
      return x;
   }
}