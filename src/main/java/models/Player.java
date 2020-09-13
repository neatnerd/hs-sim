package models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Player {
    private Board Board;
    private List<BaseCard> Hand;
    private int Health;

    public Player(){
        Board = new Board();
        Hand = new ArrayList<>();
        Health = 30;
    }
}
