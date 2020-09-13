package models;

import lombok.Getter;

import java.util.ArrayList;

public class Board {
    private final int MAX_CAPACITY = 8;
    @Getter
    private final ArrayList<BaseCard> Cards = new ArrayList<BaseCard>(MAX_CAPACITY);
    public boolean addCard(BaseCard card){
       return addCard(card, Cards.size());
    }

    /**
     * Adds a card to the board. If maximum capacity is reached, card is not inserted
     * @param card Card to be inserted
     * @param pos position at which to insert the card
     * @return false, if capacity has been reached
     * @throws IndexOutOfBoundsException
     */
    public boolean addCard(BaseCard card, int pos){
        if (Cards.size() >= MAX_CAPACITY){
            return false;
        }
        if (pos > Cards.size()){
            throw new IndexOutOfBoundsException("Cannot add card at postion:" + pos + ", size of board is " + Cards.size());
        }
        Cards.add(pos, card);
        return true;
    }

    public void remove(BaseCard card){
        Cards.remove(card);
    }

    public void remove(int pos){
        Cards.remove(pos);
    }

    public boolean isPresent(BaseCard card) { return Cards.contains(card); }

    public int size() {
        return Cards.size();
    }
}
