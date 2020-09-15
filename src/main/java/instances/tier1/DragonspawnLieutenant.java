package instances.tier1;

import models.BaseCard;
import models.MinionRace;

public class DragonspawnLieutenant extends BaseCard {
    public DragonspawnLieutenant(){
        super();
        id = 2;
        Attack = 2;
        Health = 3;
        Taunt = true;
        Race = MinionRace.DRAGON;
    }
}
