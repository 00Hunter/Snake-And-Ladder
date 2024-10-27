import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class BoardSetup {
  private int board_size=10*10;
    public   int [] board = new int[board_size];
    private  int  numberOfSnakes;
    private  int  numberOfLadders;
    private  int lowerBoundForSnake=10;
    int lowerBoundForLadder=2;


    Random random = new Random();
    Set<Integer>usedPositions=new HashSet<>();

    public void setboardSize(int n){
        this.board_size=n*n;
    }
    public BoardSetup() {
        for(int i=0;i<board_size;i++){
            board[i] = 0;
        }

    }

    public void PlaceSnakesRandomly() {
        int SnakesPlaced=0;
        while(numberOfSnakes>SnakesPlaced){

            int positionOfSnake=randomnumberGen(board_size-1,lowerBoundForSnake);

            if(!isAlreadyUsed(positionOfSnake)){
                int TailOfSnake=randomnumberGen(positionOfSnake,1);
                if(!isAlreadyUsed(TailOfSnake)){
                    setSnakeonBoard(positionOfSnake,TailOfSnake);
                    setUsedPositions(positionOfSnake,TailOfSnake);
                    SnakesPlaced++;
                }
            }

        }

    }


    public void PlaceladderRandomly(){
       int ladderPlaced=0;

       while(ladderPlaced<numberOfLadders){

           int positionOfLadder_base=randomnumberGen(board_size-2,lowerBoundForLadder);
           if(!isAlreadyUsed(positionOfLadder_base)){
               int Ladder_head=randomnumberGen(board_size,positionOfLadder_base);
               if(!isAlreadyUsed(Ladder_head)){
                   setLadderOnBoard(positionOfLadder_base,Ladder_head);
                   setUsedPositions(positionOfLadder_base,Ladder_head);
                   ladderPlaced++;
               }
           }
       }
    }

    public void placeSnakeOnCoords(int head,int tail){
        // Need to throw an exception if there is mutliple heads or tails
        if(!isAlreadyUsed(head)){
            if(head>tail){
                this.board[head] =-tail;

            }else{
                System.out.println("Not a vaild position for snake");

            }

        }else{
            System.out.println("This place is already in use for Snake");
            return ;
        }

    }
    public void placeLadderOnCoords(int base,int top){
            if(!isAlreadyUsed(base)){
                if(base<top){
                    this.board[base] =top;
                }else{
                    System.out.println("Not a vaild position for ladder");
                }


        }else{
                System.out.println("This place is already in use for Ladder");
                return;
            }
    }





    public void printBoard(){
        for(int i=0;i<10;i++){
                System.out.print(board[i]+" ");
            System.out.println();
        }
    }


private int randomnumberGen(int upperBound,int lowerBound){
        return random.nextInt(upperBound-lowerBound+1)+lowerBound;
}

private Boolean isAlreadyUsed(int index){
          return usedPositions.contains(index);
}
private void setUsedPositions(int Head,int base){
    usedPositions.add(Head);
    usedPositions.add(base);
}
    public void setNumberOfLadders(int numberOfLadders) {
        this.numberOfLadders = numberOfLadders;
    }

    public void setNumberOfSnakes(int numberOfSnakes) {
        this.numberOfSnakes=numberOfSnakes;
    }
    private void setSnakeonBoard(int snakeCoords,int SnakeTail) {
       this.board[snakeCoords]=-SnakeTail;
    }

    private void setLadderOnBoard(int ladder_base,int Ladder_head) {
        board[ladder_base]=Ladder_head;
    }
    public int[]getBoard(){
        return this.board;
    }
}
