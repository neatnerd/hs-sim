package models.reducers;

import models.Event;
import models.EventReducer;
import models.GameState;

public class MinionSummon implements EventReducer {
    @Override
    public void apply(Event event, GameState state) {
        int pos = event.getPlayer().getBoard().getCards().indexOf(event.getOriginator());
        if (pos > -1){
            event.getPlayer().getBoard().addCard(event.getCard(), pos + 1);
        }
    }
}
