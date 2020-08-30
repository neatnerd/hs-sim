package models;

import instances.SimpleCard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BoardTest {

    private static BaseCard DummyCard(){
        return new SimpleCard(10,10);
    }

    @Test
    public void TestAddMinion(){
        Board board = new Board();
        BaseCard card = new SimpleCard(10, 10);
        board.addCard(card);
        assertEquals(1, board.size());
    }

    @Test
    public void TestAddMinionsToFullBoard(){
        Board board = new Board();
        for (int i=0; i<8; i++){
            board.addCard(DummyCard());
        }
        boolean res = board.addCard(DummyCard());
        assertEquals(8, board.size(), "Board allowed to insert more than maximum capacity cards");
        assertEquals(false, res, "Board did not inform about failure to insert");
    }

    @Test
    public void TestInsertMinionAtPos(){
        Board board = new Board();
        for (int i=0; i<2; i++){
            board.addCard(DummyCard());
        }
        boolean res;
        res = board.addCard(DummyCard(), 1);
        assertEquals(true, res, "Normal insert did not work");
        assertThrows(IndexOutOfBoundsException.class, () -> {board.addCard(DummyCard(), 5);},
                "did not throw out of bound");

    }

    @Test
    public void TestRemoveMinions(){
        Board board = new Board();
        BaseCard card = DummyCard();
        board.addCard(card);
        board.addCard(DummyCard());
        board.remove(card);
        assertEquals(1, board.size());
    }
}
