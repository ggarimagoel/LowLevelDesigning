package TicTacToe.models;

import TicTacToe.Strategies.BotPlayingStrategy;
import TicTacToe.Strategies.EasyBotPlayingStrategy;

public class Bot extends Player{
    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, char symbol,BotDifficultyLevel botDifficultyLevel){
        super(name, symbol,PlayerType.BOT);
        this.botDifficultyLevel = botDifficultyLevel;
        // TODO: better way is via factory based on the bot difficulty level
        this.botPlayingStrategy = new EasyBotPlayingStrategy();
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }
    public Move decideMove(Board board){
        return botPlayingStrategy.decideMove(board, this);
    }
}
