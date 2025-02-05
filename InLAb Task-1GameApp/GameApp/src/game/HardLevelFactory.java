package game;

//Concrete Factory for Hard Level
public class HardLevelFactory implements GameItemFactory {
@Override
public Weapon createWeapon() {
   return new HardWeapon(); // Hard weapon for hard level
}

@Override
public PowerUp createPowerUp() {
   return new HardPowerUp(); // Hard power-up for hard level
}
}
