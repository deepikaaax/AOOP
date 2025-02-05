package game;

public class GameState {
    private static GameState instance;
    private int currentLevel;
    private String currentDifficulty;

    private GameState() {
        // Private constructor to prevent instantiation
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public void setCurrentLevel(int level) {
        this.currentLevel = level;
    }

    public void setCurrentDifficulty(String difficulty) {
        this.currentDifficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Level: " + currentLevel + ", Difficulty: " + currentDifficulty;
    }
}

