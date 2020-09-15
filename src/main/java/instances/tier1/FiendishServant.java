package instances.tier1;

import models.*;
import random.RandomGenerator;

public class FiendishServant extends BaseCard {

    public FiendishServant(){
        super();
        id = 3;
        Attack = 2;
        Health = 1;
        TavernTier = 1;
        Race = MinionRace.DEMON;
    }

    @Override
    public void EventProcessor(EventType eventType, Event event, GameState state) {
        super.EventProcessor(eventType, event, state);
        if (eventType == EventType.DEATH && event.getCard() == this){ // if we die
            GiveRandomMinionMyAttack(event.getPlayer().getBoard());
            // if we are golden - do it again
            if (Golden){
                GiveRandomMinionMyAttack(event.getPlayer().getBoard());
            }
        }
    }

    private void GiveRandomMinionMyAttack(Board board){
        if (board.size() <= 1) return; // we are alone on the board -> do nothing
        BaseCard card = this;
        while (card == this){
            int index = RandomGenerator.NumberBetween(0, board.size() - 1);
            card = board.getCards().get(index);
        }
        card.setAttack(card.getAttack() + Attack);
    }
}
