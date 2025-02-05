package game;

//Concrete PowerUp classes
public class EasyPowerUp extends PowerUp {
 @Override
 public void activate() {
     System.out.println("Easy PowerUp activated: Boosts health!");
 }
}
