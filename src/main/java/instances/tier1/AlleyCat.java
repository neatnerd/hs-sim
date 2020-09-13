package instances.tier1;

import models.BaseCard;
import models.Event;
import models.EventType;
import models.GameState;

public class AlleyCat extends BaseCard{

    public AlleyCat(){
        super();
        Attack = 1;
        Health = 1;
        TavernTier = 1;
    }

    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.PLAY){
            if (event.getCard() == this){
                // Summon TabbyCat
                state.Trigger(EventType.SUMMON, new Event(event.getPlayer(), new Tabbycat(), this));
            }
        }
    }
}
