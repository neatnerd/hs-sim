package models.reducers;

import models.BaseCard;
import models.Event;
import models.EventReducer;
import models.GameState;

/**
 * Use this trigger to put any card from hand into
 * the game. It does not check for board capacity
 */
public class PlayMinion implements EventReducer {

    @Override
    public void apply(Event event, GameState state) {
        BaseCard cardToPlay = event.getCard();
        event.getPlayer().getBoard().addCard(cardToPlay);
    }
}
