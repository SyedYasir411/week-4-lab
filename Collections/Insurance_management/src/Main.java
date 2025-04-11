import java.time.LocalDate;
import java.util.*;

public class Main {

    static class Policy implements Comparable<Policy> {
        private String policyNumber;
        private String policyholderName;
        private LocalDate expiryDate;
        private String coverageType;
        private double premiumAmount;

        public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                      String coverageType, double premiumAmount) {
            this.policyNumber = policyNumber;
            this.policyholderName = policyholderName;
            this.expiryDate = expiryDate;
            this.coverageType = coverageType;
            this.premiumAmount = premiumAmount;
        }

        public String getPolicyNumber() { return policyNumber; }
        public LocalDate getExpiryDate() { return expiryDate; }
        public String getCoverageType() { return coverageType; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Policy)) return false;
            Policy policy = (Policy) o;
            return policyNumber.equals(policy.policyNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(policyNumber);
        }

        @Override
        public int compareTo(Policy o) {
            return this.expiryDate.compareTo(o.expiryDate);
        }

        @Override
        public String toString() {
            return String.format("Policy[%s, %s, %s, %s, %.2f]",
                    policyNumber, policyholderName, expiryDate, coverageType, premiumAmount);
        }
    }

    // Sets for different behavior
    private static Set<Policy> hashSet = new HashSet<>();
    private static Set<Policy> linkedHashSet = new LinkedHashSet<>();
    private static Set<Policy> treeSet = new TreeSet<>();

    public static void main(String[] args) {
        List<Policy> samplePolicies = generateSamplePolicies();
        for (Policy p : samplePolicies) {
            hashSet.add(p);
            linkedHashSet.add(p);
            treeSet.add(p);
        }

        System.out.println("=== All Policies (HashSet) ===");
        displayAllPolicies(hashSet);

        System.out.println("\n=== Policies Expiring in Next 30 Days (TreeSet) ===");
        displayPoliciesExpiringSoon(treeSet);

        System.out.println("\n=== Policies with Coverage Type 'Auto' (LinkedHashSet) ===");
        displayPoliciesByCoverage(linkedHashSet, "Auto");

        System.out.println("\n=== Duplicate Policies Based on Policy Number ===");
        findDuplicatePolicies(samplePolicies);

        System.out.println("\n=== Performance Comparison ===");
        comparePerformance();
    }

    public static List<Policy> generateSamplePolicies() {
        List<Policy> policies = new ArrayList<>();
        policies.add(new Policy("P001", "Alice", LocalDate.now().plusDays(15), "Health", 1200.0));
        policies.add(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 800.0));
        policies.add(new Policy("P003", "Charlie", LocalDate.now().plusDays(5), "Home", 950.0));
        policies.add(new Policy("P004", "Diana", LocalDate.now().plusDays(25), "Health", 1000.0));
        policies.add(new Policy("P005", "Eve", LocalDate.now().plusDays(10), "Auto", 870.0));
        policies.add(new Policy("P001", "Alice", LocalDate.now().plusDays(15), "Health", 1200.0)); // Duplicate
        return policies;
    }

    public static void displayAllPolicies(Set<Policy> set) {
        set.forEach(System.out::println);
    }

    public static void displayPoliciesExpiringSoon(Set<Policy> set) {
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);
        set.stream()
                .filter(p -> !p.getExpiryDate().isAfter(threshold))
                .forEach(System.out::println);
    }

    public static void displayPoliciesByCoverage(Set<Policy> set, String coverageType) {
        set.stream()
                .filter(p -> p.getCoverageType().equalsIgnoreCase(coverageType))
                .forEach(System.out::println);
    }

    public static void findDuplicatePolicies(Collection<Policy> policies) {
        Set<String> seen = new HashSet<>();
        policies.stream()
                .filter(p -> !seen.add(p.getPolicyNumber()))
                .forEach(System.out::println);
    }

    public static void comparePerformance() {
        List<Policy> samplePolicies = generateSamplePolicies();
        Map<String, Long> results = new LinkedHashMap<>();

        long start;

        // HashSet
        Set<Policy> hs = new HashSet<>();
        start = System.nanoTime();
        samplePolicies.forEach(hs::add);
        results.put("HashSet Add", System.nanoTime() - start);

        // LinkedHashSet
        Set<Policy> lhs = new LinkedHashSet<>();
        start = System.nanoTime();
        samplePolicies.forEach(lhs::add);
        results.put("LinkedHashSet Add", System.nanoTime() - start);

        // TreeSet
        Set<Policy> ts = new TreeSet<>();
        start = System.nanoTime();
        samplePolicies.forEach(ts::add);
        results.put("TreeSet Add", System.nanoTime() - start);

        results.forEach((k, v) -> System.out.println(k + ": " + v + " ns"));
    }
}
