package game;

//Concrete Factory for Easy Level
public class EasyLevelFactory implements GameItemFactory {
@Override
public Weapon createWeapon() {
   return new EasyWeapon(); // Easy weapon for easy level
}

@Override
public PowerUp createPowerUp() {
   return new EasyPowerUp(); // Easy power-up for easy level
}
}

