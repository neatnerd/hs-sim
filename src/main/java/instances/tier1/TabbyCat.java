package instances.tier1;

import models.BaseCard;
import models.MinionRace;

public class TabbyCat extends BaseCard {

    public TabbyCat(){
        super();
        Attack = 1;
        Health = 1;
        TavernTier = 1;
        Race = MinionRace.BEAST;
    }
}
