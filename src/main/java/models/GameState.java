package models;

import lombok.Getter;
import models.reducers.CardDeath;
import models.reducers.MinionSummon;
import models.reducers.PlayMinion;

import java.util.Map;
import static java.util.Map.entry;

public class GameState {
    @Getter
    private final Player Player1;
    @Getter
    private final Player Player2;


    public GameState(){
        Player1 = new Player();
        Player2 = new Player();
    }

    private static final Map<EventType, EventReducer> ReducersMap = Map.ofEntries(
            entry(EventType.PLAY, new PlayMinion()),
            entry(EventType.DEATH, new CardDeath()),
            entry(EventType.SUMMON, new MinionSummon())
    );
    public void Trigger(EventType type, Event event){
        // first reducers have a standard work to do
        ReducersMap.get(type).apply(event, this);
        // let every card know about the event
        // start with player that has originated it
        for (int i = 0; i<event.getPlayer().getBoard().getCards().size(); i++){
            BaseCard card = event.getPlayer().getBoard().getCards().get(i);
            card.EventProcessor(type, event, this);
        }
    }

}
