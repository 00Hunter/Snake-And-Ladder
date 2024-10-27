//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        GameRunner game = new GameRunner();
        game.setBoardsize(12);
        game.setNumberOfLadders(2);
        game.setNumberOfsnakes(3);
        game.setNumberOfDiy(3);
        game.PlaceLadderRandomly();
        game.PlaceSnakeRandomly();
        game.PlaceLadderOnspecificLocation(8,99);
        game.PlaceSnakesOnspecificLocation(45,23);
//        game.PlaceSnakesOnspecificLocation(9,22);
        game.GameStart();

    }
}