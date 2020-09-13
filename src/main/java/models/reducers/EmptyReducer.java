package models.reducers;

import models.Event;
import models.EventReducer;
import models.GameState;

public class EmptyReducer implements EventReducer {
    @Override
    public void apply(Event event, GameState state) {
        //do nothing
    }
}
