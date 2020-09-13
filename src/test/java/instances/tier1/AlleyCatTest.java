package instances.tier1;

import models.Event;
import models.EventType;
import models.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlleyCatTest {
    @Test
    public void TestEmptyBoard(){
        GameState gameState = new GameState();
        Event playEvent = new Event(gameState.getPlayer1(), new AlleyCat(), null);
        gameState.Trigger(EventType.PLAY, playEvent);
        assertEquals(gameState.getPlayer1().getBoard().size(), 2, "");
        assertEquals(gameState.getPlayer1().getBoard().getCards().get(0) instanceof AlleyCat, true, "First card is not alley cat");
        assertEquals(gameState.getPlayer1().getBoard().getCards().get(1) instanceof Tabbycat, true, "First card is not tabby cat");
    }
}
