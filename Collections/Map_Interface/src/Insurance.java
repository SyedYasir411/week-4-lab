import java.time.LocalDate;
import java.util.*;

class Policy {
    String policyNumber;
    String policyholderName;
    LocalDate expiryDate;
    String coverageType;
    double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String toString() {
        return policyNumber + " | " + policyholderName + " | " + expiryDate + " | " + coverageType + " | $" + premiumAmount;
    }
}

public class Insurance {
    Map<String, Policy> hashMap = new HashMap<>();
    Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    public void addPolicy(Policy policy) {
        hashMap.put(policy.policyNumber, policy);
        linkedHashMap.put(policy.policyNumber, policy);

        treeMap.putIfAbsent(policy.expiryDate, new ArrayList<>());
        treeMap.get(policy.expiryDate).add(policy);
    }

    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    public void listExpiringPolicies() {
        LocalDate today = LocalDate.now();
        LocalDate threshold = today.plusDays(30);

        System.out.println("Policies expiring in next 30 days:");
        for (Map.Entry<LocalDate, List<Policy>> entry : treeMap.subMap(today, true, threshold, true).entrySet()) {
            for (Policy p : entry.getValue()) {
                System.out.println(p);
            }
        }
    }

    public void listPoliciesByHolder(String holderName) {
        System.out.println("Policies for " + holderName + ":");
        for (Policy p : hashMap.values()) {
            if (p.policyholderName.equalsIgnoreCase(holderName)) {
                System.out.println(p);
            }
        }
    }

    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<String, Policy>> iterator = hashMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Policy> entry = iterator.next();
            Policy policy = entry.getValue();

            if (policy.expiryDate.isBefore(today)) {
                iterator.remove();
                linkedHashMap.remove(entry.getKey());
                List<Policy> list = treeMap.get(policy.expiryDate);
                if (list != null) {
                    list.remove(policy);
                    if (list.isEmpty()) {
                        treeMap.remove(policy.expiryDate);
                    }
                }
            }
        }

        System.out.println("Expired policies removed.");
    }

    public void showInsertionOrder() {
        System.out.println("Policies in insertion order:");
        for (Policy p : linkedHashMap.values()) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        Insurance system = new Insurance();

        system.addPolicy(new Policy("P101", "Alice", LocalDate.now().plusDays(15), "Health", 1500.0));
        system.addPolicy(new Policy("P102", "Bob", LocalDate.now().plusDays(40), "Auto", 950.0));
        system.addPolicy(new Policy("P103", "Alice", LocalDate.now().minusDays(5), "Home", 1200.0));
        system.addPolicy(new Policy("P104", "David", LocalDate.now().plusDays(20), "Health", 1000.0));

        System.out.println();
        system.showInsertionOrder();

        System.out.println();
        System.out.println("Retrieved: " + system.getPolicyByNumber("P102"));

        System.out.println();
        system.listExpiringPolicies();

        System.out.println();
        system.listPoliciesByHolder("Alice");

        System.out.println();
        system.removeExpiredPolicies();

        System.out.println();
        system.showInsertionOrder();
    }
}
