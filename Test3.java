public class Test3 {
    public static void main(String[] args) {
        int difficulty = Integer.parseInt(Game.readDifficultyInput());
        Game game = new Game(difficulty);
        System.out.println(game.getDesiredWord().toString());
        game.start();
    }
}
