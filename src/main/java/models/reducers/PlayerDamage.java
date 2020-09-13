package models.reducers;

import models.Event;
import models.EventReducer;
import models.GameState;
import models.Player;

public class PlayerDamage implements EventReducer {
    @Override
    public void apply(Event event, GameState state) {
        Player player = event.getPlayer();
        player.setHealth(player.getHealth() + event.getCard().getAttack());
    }
}
