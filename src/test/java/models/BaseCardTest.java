package models;

import instances.SimpleCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BaseCardTest {

    // TODO: add tests for transitivity

    @Test
    public void TestHashCodeNonKeyFields(){
        BaseCard card1 = new SimpleCard(10, 10);
        BaseCard card2 = new SimpleCard(10, 10);
        assertEquals(card1.hashCode(), card2.hashCode());
        card2.setTavernTier(22);
        assertEquals(card1.hashCode(), card2.hashCode());
        card1.setRace(MinionRace.DEMON);
        assertEquals(card1.hashCode(), card2.hashCode());
    }

    @Test
    public void TestEquality(){
        BaseCard card1 = new SimpleCard(10, 10);
        BaseCard card2 = new SimpleCard(10, 10);
        assertEquals(card1, card2);
        card1.setAttack(11);
        assertNotEquals(card1, card2);
    }
}
