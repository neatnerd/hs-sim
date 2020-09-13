package models.reducers;

import models.Event;
import models.EventReducer;
import models.EventType;
import models.GameState;

public class CardDeath implements EventReducer {

    @Override
    public void apply(Event event, GameState state) {
        event.getPlayer().getBoard().remove(event.getCard());
    }
}
