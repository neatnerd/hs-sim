package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Event {
    private final Player player;
    private final BaseCard card;
    private final BaseCard originator;
}
