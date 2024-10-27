
    public class GameRunner {
        BoardSetup board = new BoardSetup();
        Dice dice=new Dice(6,1);
        Player[] player = new Player[4];
        int[] PlayerMoved = new int[4];

        private void initializePlayers() {
            for (int i = 0; i < player.length; i++) {
                player[i] = new Player(); // Initialize each player object
                player[i].setName("Player " + (i + 1)); // Setting name as "Player 1", "Player 2", etc.
            }
        }


        int current_player = 0;
        int Won = 0;


        public GameRunner() {

            board.setNumberOfSnakes(7);
            board.setNumberOfLadders(7);
            dice.setNumberOfDice(5);
            board.PlaceladderRandomly();
            board.PlaceladderRandomly();


        }

        public void GameStart() {
            System.out.println("Game Started");

            while (Won == 0) {

                if(!isPlayerVaild(current_player)){
                    current_player=0;
                    continue;
                }

                System.out.println("Current player: " + " " + current_player + "is playing");


                int number_rolled = dice.RollDice();

                if(!isValidPosition(number_rolled,PlayerMoved,current_player)){
                   ChangeCurrentPlayer();
                    continue;
                }

                moveThePlayer(number_rolled);

                if(PlayerWon()){
                    System.out.println("Player " + current_player + " won");
                    Won++;
                    break;
                }

               ChangeCurrentPlayer();

            }

        }

        private boolean isPlayerVaild(int currentPlayer) {
            return currentPlayer<=3;
        }

        private boolean isValidPosition(int numberRoled, int[] playerMoved,int current_player) {
            return this.PlayerMoved[current_player]+numberRoled<=100;
        }

        private void moveThePlayer(int number_rolled) {
            this.PlayerMoved[current_player] = number_rolled+this.PlayerMoved[current_player];
        }
        private boolean PlayerWon() {
            return this.PlayerMoved[current_player]==100;
        }

        public void setNumberOfsnakes(int numberOfSnakes) {
            this.board.setNumberOfSnakes(numberOfSnakes);
        }
        public void PlaceSnakeRandomly() {
            this.board.PlaceSnakesRandomly();
        }
        public void setNumberOfLadders(int numberOfLadders) {
            this.board.setNumberOfLadders(numberOfLadders);
        }
        public void PlaceLadderRandomly() {
            this.board.PlaceladderRandomly();
        }
        public void setNumberOfDiy(int numberOfdiy){
            this.dice.setNumberOfDice(numberOfdiy);
        }

        public void PlaceSnakesOnspecificLocation(int head,int tail){
           this.board.placeSnakeOnCoords(head,tail);
        }
        public void PlaceLadderOnspecificLocation(int base,int top){
            this.board.placeLadderOnCoords(base,top);
        }
        private void ChangeCurrentPlayer(){
            current_player ++;
        }
        public void setBoardsize(int n){
            this.board.setboardSize(n);
        }
    }
