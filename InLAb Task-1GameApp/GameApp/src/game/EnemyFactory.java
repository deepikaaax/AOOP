package game;

public class EnemyFactory {
    public static Enemy createEnemy(String enemyType) {
        if (enemyType.equalsIgnoreCase("Zombie")) {
            return new Zombie();
        } else if (enemyType.equalsIgnoreCase("Robot")) {
            return new Robot();
        }
        return null;
    }
}
