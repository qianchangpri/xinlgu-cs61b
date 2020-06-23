package hw4.puzzle;

import java.util.Comparator;

public class ComparatorState implements Comparator<SearchNode> {
        @Override
        public int compare(SearchNode s1, SearchNode s2) {
            int distance1 = s1.movesSoFar + s1.worldState.estimatedDistanceToGoal();
            int distance2 = s2.movesSoFar + s2.worldState.estimatedDistanceToGoal();
            if (distance1 > distance2) {
                return 1;
            } else {
                return -1;
            }
        }
    }