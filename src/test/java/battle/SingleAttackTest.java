package battle;

import instances.SimpleCard;
import models.BaseCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleAttackTest {

    @Test
    public void TestSimpleAttack(){
        BaseCard attacker = new SimpleCard(10, 100);
        BaseCard defender = new SimpleCard(5, 200);
        SingleAttack attack = new SingleAttack(attacker, defender);
        attack.Execute();
        assertEquals(attacker.getHealth(), 95);
        assertEquals(defender.getHealth(), 190);
    }

    @Test
    public void TestDivineShield(){
        BaseCard attacker = new SimpleCard(10, 100);
        BaseCard defender = new SimpleCard(5, 200);
        attacker.setDivineShield(true);
        defender.setDivineShield(true);
        SingleAttack attack = new SingleAttack(attacker, defender);
        attack.Execute();
        assertEquals(attacker.getHealth(), 100);
        assertEquals(defender.getHealth(), 200);
    }
}
