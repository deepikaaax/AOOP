package game;

//Concrete Weapon classes
public class EasyWeapon extends Weapon {
 @Override
 public void use() {
     System.out.println("Easy Weapon used: Low damage");
 }
}
