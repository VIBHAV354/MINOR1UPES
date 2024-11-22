import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BFTServer {
    private final List<Node> nodes;

    public BFTServer(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void toggleNodeMalicious(int nodeId) {
        Node node = nodes.get(nodeId - 1); 
        node.toggleMalicious();           
        System.out.println("Node " + nodeId + " malicious state: " + node.isMalicious());
    }

    public void proposeValue(int value) {
        List<Integer> proposedValues = new ArrayList<>();
        for (Node node : nodes) {
            proposedValues.add(node.generateValue(value));
        }

        int majorityValue = findMajorityValue(proposedValues);
        for (Node node : nodes) {
            node.setReceivedValues(Collections.singletonList(majorityValue));
        }

        System.out.println("Consensus reached on value: " + majorityValue);
    }

    private int findMajorityValue(List<Integer> values) {
        int majorityValue = 0;
        int maxCount = 0;

        for (int value : values) {
            int count = 0;
            for (int other : values) {
                if (value == other) {
                    count++;
                }
            }

            if (count > maxCount) {
                maxCount = count;
                majorityValue = value;
            }
        }

        return majorityValue;
    }
}
