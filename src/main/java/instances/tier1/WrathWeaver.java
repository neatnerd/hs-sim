package instances.tier1;

import instances.SimpleCard;
import models.*;

public class WrathWeaver extends BaseCard {

    public WrathWeaver(){
        super();
        Attack = 1;
        Health = 1;
        Race = MinionRace.NEUTRAL;
        TavernTier = 1;
    }

    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.PLAY && event.getCard().getRace() == MinionRace.DEMON) {
            // TODO: refactor ugly solution for identifying friendly cards
            if (event.getPlayer().getBoard().isPresent(this)) { // if it is a friendly minion
                Attack += Golden ? 4 : 2;
                Health += Golden ? 4 : 2;
                state.Trigger(EventType.DAMAGE_PLAYER,
                        new Event(state.getPlayer1(), new SimpleCard(-1, 0), null));
            }
        }
    }
}
