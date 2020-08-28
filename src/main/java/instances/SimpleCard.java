package instances;

import models.BaseCard;

public class SimpleCard extends BaseCard {

    public SimpleCard(int attack, int health){
        this.setAttack(attack);
        this.setHealth(health);

    }
}
