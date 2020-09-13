package instances.tier1;

import models.*;

public class ScavengingHyena extends BaseCard {

    public ScavengingHyena(){
        Attack = 2;
        Health = 2;
        TavernTier = 1;
        Race = MinionRace.BEAST;
    }

    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.DEATH && event.getCard().getRace() == MinionRace.BEAST){
            // TODO: refactor ugly solution for identifying friendly cards
            if (event.getPlayer().getBoard().isPresent(this)){ // if it is a friendly minion
                Attack += Golden ? 4 : 2;
                Health += Golden ? 2 : 1;
            }
        }
    }
}
