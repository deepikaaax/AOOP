package game;

public class Main {
    public static void main(String[] args) {
        // Singleton GameState
        GameState gameState = GameState.getInstance();
        System.out.println("Initial Game State: " + gameState);

        // Create enemies using Factory Method
        Enemy enemy1 = EnemyFactory.createEnemy("Zombie");
        enemy1.attack();

        Enemy enemy2 = EnemyFactory.createEnemy("Robot");
        enemy2.attack();

        // Create weapons and power-ups using Abstract Factory
        GameItemFactory easyFactory = new EasyLevelFactory();
        Weapon easyWeapon = easyFactory.createWeapon();
        PowerUp easyPowerUp = easyFactory.createPowerUp();

        easyWeapon.use();
        easyPowerUp.activate();

        GameItemFactory hardFactory = new HardLevelFactory();
        Weapon hardWeapon = hardFactory.createWeapon();
        PowerUp hardPowerUp = hardFactory.createPowerUp();

        hardWeapon.use();
        hardPowerUp.activate();

        // Update game state
        gameState.setCurrentLevel(2);
        gameState.setCurrentDifficulty("HARD");
        System.out.println("Updated Game State: " + gameState);
    }
}

