package instances.tier1;

import models.*;

public class AlleyCat extends BaseCard{

    public AlleyCat(){
        super();
        id = 1;
        Attack = 1;
        Health = 1;
        TavernTier = 1;
        Race = MinionRace.BEAST;
    }

    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.PLAY){
            if (event.getCard() == this){
                // Summon TabbyCat
                state.Trigger(EventType.SUMMON, new Event(event.getPlayer(), new TabbyCat(), this));
            }
        }
    }
}
