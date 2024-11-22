import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String filePath;
    private boolean isMalicious;
    private final List<Integer> receivedValues;

    public Node(String filePath) {
        this.filePath = filePath;
        this.isMalicious = false;
        this.receivedValues = new ArrayList<>();
    }

    public String getFilePath() {
        return filePath;
    }

    public boolean isMalicious() {
        return isMalicious;
    }

    public void toggleMalicious() {
        this.isMalicious = !this.isMalicious;
    }

    public List<Integer> getReceivedValues() {
        return receivedValues;
    }

    public void addReceivedValue(int value) {
        receivedValues.add(value);
    }

    public int generateValue(int proposedValue) {
        if (isMalicious) {
            return proposedValue + 3; // Arbitrary manipulation for malicious behavior
        }
        return proposedValue;
    }

    public void setReceivedValues(List<Integer> values) {
        receivedValues.clear();
        receivedValues.addAll(values);
    }
}
