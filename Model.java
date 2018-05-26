public class Model
{
   public char[][] board;//tabela e lojes
   
   //krijimi i tabeles
   public Model()
   {
      board=new char[3][3];
   }
   /*Metoda isvalidInput kontrollon se a eshte valide levizja e perdoruesit
   @param move- levizja e perdoruesit
   return -kthen true nese eshte valide false perndryshe
   */
   public static boolean isvalidInput(String move){
      boolean result=true;
      if(move.trim().length()>=6){
         int row = Character.getNumericValue(move.trim().charAt(1));
         int column = Character.getNumericValue(move.trim().charAt(4));
         if(row<0||row>2)result=false;
         if(column<0||column>2)result=false;
      }
      else 
      {
         result=false;
      }
      return result;
   }
   //Metoda initializeBoard() inicializon tabelen
   public void initializeBoard() {
      for (int r = 0; r<=2; r++)
      {
         for (int c = 0; c<=2; c++)
         {
            board[r][c] = '-';
         }
      }
   }
   /* Metoda getComputerMove ben levizjen e kompjuterit
    return- kthen levizjen e kompjuteri*/
     public String getComputerMove() {		
      char[][] boardcopy = createBoardCopy(board);
   
   	//Zgjedh levizje fituese nese eshte e mundur
      for(int row = 0; row <= 2; row++) {
         for(int column = 0; column <= 2; column++) {
            if(boardcopy[row][column] == '-') {
               boardcopy[row][column] = 'O';
               if(isWinning('O', boardcopy)) {
                  return ("[" + row + "][" + column + "]");
               }
               else {
                  boardcopy[row][column] = '-';
               }
            }
         }
      }
   
   	//Zgjedh levizje bllokuese nese eshte e mundur
      for(int row = 0; row <= 2; row++) {
         for(int column = 0; column <= 2; column++) {
            if(boardcopy[row][column] == '-') {
               boardcopy[row][column] = 'X';
               if(isWinning('X', boardcopy)) {
                  return "[" + row + "][" + column + "]";
               }
               else {
                  boardcopy[row][column] = '-';
               }
            }
         }
      }
   
   	//Zgjedh levizjen ne qender nese eshte e mundur
      if(boardcopy[1][1] == '-') {
         return "[1][1]";
      }
   
   	//Zgjedh qoshet nese eshte e mundur
      if(boardcopy[0][0] == '-') {
         return "[0][0]";
      }	
   
      if(boardcopy[0][2] == '-') {
         return "[0][2]";
      }
   
      if(boardcopy[2][0] == '-') {
         return "[2][0]";
      }
   
      if(boardcopy[2][2] == '-') {
         return "[2][2]";
      }
   
   	//Zgjedh qelizen e pare qe gjen 
      for(int row = 0; row <= 2; row++) {
         for(int column = 0; column <=2; column++) {
            if(boardcopy[row][column] == '-') {
               return "[" + row + "][" + column + "]";
            }
         }
      }
      return "no move found";
   }
   /*Metoda isCellFree kontrollon se a eshte qeliza e tabeles e lire 
   @param player -lojtari qe deshiron te levize
   @param move - levizja qe eshiron te beje lojtari
   return - true nese eshte e lire,false perndryshe */
   public boolean isCellFree(char player, String move)
   {
      boolean result = false;
      int row = Character.getNumericValue(move.charAt(1));
      int column = Character.getNumericValue(move.charAt(4));
      if(board[row][column] == '-')
      {
         result = true;
      }
      else
      {
         System.out.println("Invalid Move!");
      }
   	 
      return result;
   }
   /*Metoda markMoveOnBoard shkruan levizjen e lojtarit ne tabele
   @param player - lojtari X ose O
   @param move - qelizen ne te cilen deshiron te levize lojtari*/	
   public void markMoveOnBoard(char player, String move)
   {
      int row = Character.getNumericValue(move.charAt(1));
      int column = Character.getNumericValue(move.charAt(4));
      board[row][column] = player;	
   }
   /*Metoda getGameStatus tregon statusi e lojes ne tabelen e dhene
   @param board-tabela e dhene
   return- statusi i lojes*/
   public String getGameStatus(char[][] board)
   {
      boolean userWins = isWinning('X', board);
      if(userWins)
      {
         return "User Wins!";
      }
      boolean computerWins = isWinning('O', board);
      if(computerWins) {
         return "Computer Wins!";
      }
      if (isDraw())
      {
         return "Draw";
      }
      return "InProgress";
   }
   /*Metoda isWinning tregon se a ka fituar lojtari 
   @param player -lojtari X ose O
   @param inputboard - tabela e dhene
   return- true nese ka fituar lojtari, false perndryshe*/
   public static boolean isWinning(char player, char[][] inputboard) {
      for(int r = 0; r <= 2; r++)
      {
         if(inputboard[r][0]==player && inputboard[r][1]==player && inputboard[r][2]==player)
         {
            return true;
         }
      }
   
      for(int c = 0; c <= 2; c++)
      {
         if(inputboard[0][c]==player && inputboard[1][c]==player && inputboard[2][c]==player)
         {
            return true;
         }
      }
      if (inputboard[0][0]==player && inputboard[1][1]==player && inputboard[2][2]==player)
      {
         return true;
      }
      if (inputboard[0][2]==player && inputboard[1][1]==player && inputboard[2][0]==player)
      {
         return true;
      }
      return false;
   }
   //Metoda isDraw() tregon se ka perfunduar loja ne barazim
   public boolean isDraw() {
      for (int r = 0; r<=2; r++)
      {
         for (int c = 0; c<=2; c++)
         {
            if(board[r][c] =='-')
            {
               return false;
            }
         }
      }
   
      return true;	
   }
   /*Metoda createBoardCopy ben nje kopje identike te tabeles se dhene
   @param board- tabela e dhene
   return- matricen identike me tabelen e dhene*/
   private static char[][] createBoardCopy(char[][] board) {
      char[][] boardcopy = new char[3][3];
      for(int row = 0; row <= 2; row++) {
         for(int column = 0; column <= 2; column++) {
            boardcopy[row][column] = board[row][column];
         }
      }
      return boardcopy;
   }
   //Metoda checkEnd tregon se a mund te fitoj ndonjeri nga lojtaret para se te perfundoj loja
   public boolean checkEnd(){
     boolean result=false;
       int count=0;
       for(int row=0;row<=2;row++){
          for(int column=0;column<=2;column++){
             if(board[row][column]=='-')
                count++;
          }
       }
       if(count==1)
       {  result=true;
          char[][] boardcopy = createBoardCopy(board);
          for(int row = 0; row <= 2; row++) {
             for(int column = 0; column <= 2; column++) {
                if(boardcopy[row][column] == '-') {
                   boardcopy[row][column] = 'X';
                   if(isWinning('X', boardcopy)) {
                      result=false;                   
                   }
                   else{
                   boardcopy[row][column] = '-';
                   }
                }
             }
          }  
       }
       return result;
    }
}