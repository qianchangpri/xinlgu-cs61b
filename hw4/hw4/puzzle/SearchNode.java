package hw4.puzzle;

public class SearchNode {
    WorldState worldState;
    int movesSoFar;
    SearchNode prev;

    public SearchNode(WorldState state, int moves, SearchNode p) {
        worldState = state;
        movesSoFar = moves;
        prev = p;
    }
}
