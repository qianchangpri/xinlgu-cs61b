package hw4.puzzle;
import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;

public class Solver {
    private ArrayList<WorldState> states;
    private int moves;



    public Solver(WorldState initial) {
        class ComparatorState implements Comparator<SearchNode> {
            @Override
            public int compare(SearchNode s1, SearchNode s2) {
                int distance1 = s1.movesSoFar + s1.worldState.estimatedDistanceToGoal();
                int distance2 = s2.movesSoFar + s2.worldState.estimatedDistanceToGoal();
                if (distance1 > distance2) {
                    return 1;
                } else if (distance1 == distance2) {
                    return 0;
                } else {
                    return -1;
                }
            }
        }

        ComparatorState myComparator = new ComparatorState();
        MinPQ<SearchNode> searchNodes = new MinPQ(myComparator);
        searchNodes.insert(new SearchNode(initial, 0, null));
        states = new ArrayList<>(100);
        while (!searchNodes.min().worldState.isGoal()) {
            SearchNode currentState = searchNodes.delMin();
            for (WorldState neighbor : currentState.worldState.neighbors()) {
                if (currentState.prev != null) {
                    if (neighbor.equals(currentState.prev.worldState)) {
                        continue;
                    }
                }
                searchNodes.insert(new SearchNode(neighbor, currentState.movesSoFar + 1, currentState));
            }
        }
        addresult(searchNodes.min());
        states.add(searchNodes.min().worldState);
        moves = searchNodes.min().movesSoFar;

    }
    public int moves() {
        return moves;
    }
    public Iterable<WorldState> solution() {
        return states;
    }
    private SearchNode addresult(SearchNode p) {
        if (p.prev == null) {
            return p;
        }
        SearchNode x = addresult(p.prev);
        states.add(p.prev.worldState);
        return x;
    }
}
