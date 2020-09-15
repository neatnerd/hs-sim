package instances.tier1;

import models.BaseCard;
import models.MinionRace;

public class RedWhelp extends BaseCard {
    public RedWhelp() {
        super();
        id = 4;
        Attack = 1;
        Health = 2;
        TavernTier = 1;
        Race = MinionRace.DRAGON;
    }
}
