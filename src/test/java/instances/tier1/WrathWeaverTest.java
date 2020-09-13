package instances.tier1;

import models.BaseCard;
import models.Event;
import models.EventType;
import models.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WrathWeaverTest {

    @Test
    public void BasicTest(){
        GameState state = new GameState();
        BaseCard card = new WrathWeaver();
        state.Trigger(EventType.PLAY, new Event(state.getPlayer1(), card, null));
        state.Trigger(EventType.PLAY, new Event(state.getPlayer1(), new FiendishServant(), null));
        assertEquals(3, card.getAttack(), "Wrath Weaver Attack did not increase");
        assertEquals(3, card.getHealth(), "Wrath Weaver Health did not increase");
        assertEquals(29, state.getPlayer1().getHealth());
    }
}
