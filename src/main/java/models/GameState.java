package models;

import lombok.Getter;
import models.reducers.*;

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

    private static final Map<EventType, EventReducer> PreProcessors = Map.ofEntries(
            entry(EventType.PLAY, new PlayMinion()),
            entry(EventType.SUMMON, new MinionSummon()),
            entry(EventType.ATTACK, new EmptyReducer()),
            entry(EventType.TAKE_DAMAGE, new EmptyReducer()),
            entry(EventType.TURN_START, new EmptyReducer()),
            entry(EventType.TURN_END, new EmptyReducer()),
            entry(EventType.DAMAGE_PLAYER, new PlayerDamage())
    );
    private static final Map<EventType, EventReducer> PostProcessors = Map.ofEntries(
            entry(EventType.DEATH, new CardDeath())
    );

    public void Trigger(EventType type, Event event){
        // first reducers have a standard work to do
        applyReducers(PreProcessors, type, event);
        // let every card know about the event
        // start with player that has originated it
        for (int i = 0; i < event.getPlayer().getBoard().getCards().size(); i++){
            BaseCard card = event.getPlayer().getBoard().getCards().get(i);
            card.EventProcessor(type, event, this);
        }
        // run post-processors
        applyReducers(PostProcessors, type, event);
    }

    private void applyReducers(Map<EventType, EventReducer> map, EventType type, Event event){
        EventReducer reducer = map.get(type);
        if (reducer != null){
            reducer.apply(event, this);
        }
    }
}
