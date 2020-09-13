package instances.tier1;

import instances.SimpleCard;
import models.Event;
import models.EventType;
import models.GameState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScavengingHyenaTest {

    @Test
    public void BasicDeathAllyCat(){
        GameState gameState = new GameState();
        gameState.Trigger(EventType.PLAY, new Event(gameState.getPlayer1(), new AlleyCat(), null));
        gameState.Trigger(EventType.PLAY, new Event(gameState.getPlayer1(), new SimpleCard(1,1), null));
        gameState.Trigger(EventType.PLAY, new Event(gameState.getPlayer1(), new ScavengingHyena(), null));
        assertEquals(4, gameState.getPlayer1().getBoard().size());
        gameState.Trigger(EventType.DEATH, new Event(gameState.getPlayer1(),
                gameState.getPlayer1().getBoard().getCards().get(0), null));
        gameState.Trigger(EventType.DEATH, new Event(gameState.getPlayer1(),
                gameState.getPlayer1().getBoard().getCards().get(0), null));
        gameState.Trigger(EventType.DEATH, new Event(gameState.getPlayer1(),
                gameState.getPlayer1().getBoard().getCards().get(0), null));
        assertEquals(1, gameState.getPlayer1().getBoard().size());
        assertEquals(6, gameState.getPlayer1().getBoard().getCards().get(0).getAttack());
        assertEquals(4, gameState.getPlayer1().getBoard().getCards().get(0).getHealth());
    }
}
