import java.util.*;

public class Voting {
    private Map<String, Integer> votes = new HashMap<>();
    private Map<String, Integer> orderOfVotes = new LinkedHashMap<>();
    private TreeMap<Integer, List<String>> sortedVotes = new TreeMap<>(Collections.reverseOrder());
    public void vote(String candidate) {
        votes.put(candidate, votes.getOrDefault(candidate, 0) + 1);
        orderOfVotes.put(candidate, orderOfVotes.getOrDefault(candidate, 0) + 1);
        sortedVotes.computeIfAbsent(votes.get(candidate), k -> new ArrayList<>()).add(candidate);
    }

    public void showVotesInOrder() {
        System.out.println("Votes in the order they were cast:");
        for (Map.Entry<String, Integer> entry : orderOfVotes.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue() + " vote(s)");
        }
    }

    public void showSortedResults() {
        System.out.println("\nVoting Results (sorted by votes):");
        for (Map.Entry<Integer, List<String>> entry : sortedVotes.entrySet()) {
            for (String candidate : entry.getValue()) {
                System.out.println(candidate + " -> " + entry.getKey() + " vote(s)");
            }
        }
    }

    public static void main(String[] args) {
        Voting votingSystem = new Voting();

        votingSystem.vote("Alice");
        votingSystem.vote("Bob");
        votingSystem.vote("Alice");
        votingSystem.vote("Charlie");
        votingSystem.vote("Bob");
        votingSystem.vote("Bob");

        votingSystem.showVotesInOrder();
        votingSystem.showSortedResults();
    }
}
