public class Controller
{
   private Model m;
   private View v;
   //Inicializimi i ndryshoreve m dhe v
   public Controller(Model model,View view)
   {
      m=model;
      v=view;
   }
   /*Metoda getUserMove() merr nga perdorusi levizjen e tij derisa ai te shkruaj levizje valide
   return-levizjen valide te perdoruesit*/
   public String getUserMove()
   {
      String usermove = "";
      boolean isValidMove = false;
      while(!isValidMove)
      {  
         usermove=v.getUserMoveInterface();
         isValidMove = m.isvalidInput(usermove);
         if(!isValidMove)System.out.println("Illegal move, please enter a valid move");
      }
      if(!m.isCellFree('X', usermove)){
         usermove=getUserMove();
      }
   	
      return usermove;
   }
   //Metoda gameProcessing luan lojen 
   public void gameProccesing(){
      m.initializeBoard();
      v.printBoard(m.board);
      String gameStatus = "InProgress";
      boolean processing=true;				
      while(processing)
      {           
         String userMove= getUserMove();     
         m.markMoveOnBoard('X', userMove);
         v.printBoard(m.board);			
         gameStatus = m.getGameStatus(m.board);
         if(m.checkEnd())
         {
            gameStatus="Draw";
         }
         if (!gameStatus.equals("InProgress")) 
         {				
            processing=false;
         }
         else{
            String computerMove = m.getComputerMove();			
            System.out.println("computer move:"+ computerMove);
            m.markMoveOnBoard('O', computerMove);
            v.printBoard(m.board);			
            gameStatus = m.getGameStatus(m.board);
         }
         if(m.checkEnd())
         {
            gameStatus="Draw";
         }         
         if (!gameStatus.equals("InProgress")) 
         {				
            processing=false;
         }
      }
      System.out.println(gameStatus);
      String anotherGame=v.anotherGame();
      if(anotherGame.trim().toUpperCase().equals("Y"))
         gameProccesing();
   }
}