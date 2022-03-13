public class Test3 {
    public static void main(String[] args) {
        Game.showRules();
        int difficulty = Integer.parseInt(Game.readDifficultyInput());
        Game game = new Game(difficulty);
        game.start();
    }
}
