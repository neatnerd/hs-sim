package instances.tier1;

import models.Event;
import models.EventType;
import models.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VulgarHomunculusTest {

    @Test
    public void BasicTest(){
        GameState state = new GameState();
        int initialHealth = state.getPlayer1().getHealth();
        state.Trigger(EventType.PLAY, new Event(state.getPlayer1(), new VulgarHomunculus(), null));
        assertEquals(initialHealth - 2, state.getPlayer1().getHealth(), "Card did not reduce health");
    }
}
