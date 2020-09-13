package instances.tier1;

import instances.SimpleCard;
import models.BaseCard;
import models.Event;
import models.EventType;
import models.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiendishServantTest {

    @Test
    public void TestDeath(){
        GameState gameState = new GameState();
        gameState.getPlayer1().getBoard().addCard(new SimpleCard(10, 10));
        BaseCard control = new FiendishServant();
        gameState.getPlayer1().getBoard().addCard(control);
        gameState.Trigger(EventType.DEATH, new Event(gameState.getPlayer1(), control, null));
        assertEquals(1, gameState.getPlayer1().getBoard().size());
        assertEquals(12, gameState.getPlayer1().getBoard().getCards().get(0).getAttack());
    }
}
