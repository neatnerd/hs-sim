package instances.tier1;

import models.BaseCard;
import models.MinionRace;

public class TabbyCat extends BaseCard {

    public TabbyCat(){
        super();
        id = 6;
        Attack = 1;
        Health = 1;
        TavernTier = 1;
        Race = MinionRace.BEAST;
    }
}
