package instances.tier1;

import instances.SimpleCard;
import models.BaseCard;
import models.Event;
import models.EventType;
import models.GameState;

public class VulgarHomunculus extends BaseCard {
    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.PLAY && event.getCard() == this){
            state.Trigger(EventType.DAMAGE_PLAYER,
                    new Event(event.getPlayer(), new SimpleCard(-2, 0), null));
        }
    }
}
