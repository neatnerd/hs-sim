package models;

@FunctionalInterface
public interface EventReducer {
    void apply(Event event, GameState state);
}
