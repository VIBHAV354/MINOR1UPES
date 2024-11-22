import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create nodes
        List<Node> nodes = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            nodes.add(new Node("node" + i + ".txt"));
        }

        // Initialize BFTServer with nodes
        BFTServer server = new BFTServer(nodes);

        // Command-line interface
        Scanner scanner = new Scanner(System.in);
        System.out.println("Commands: PROPOSE:<value>, TOGGLE:<nodeId>, VIEW");

        while (true) {
            String input = scanner.nextLine();

            if (input.startsWith("PROPOSE:")) {
                int value = Integer.parseInt(input.split(":")[1]);
                server.proposeValue(value);
            } else if (input.startsWith("TOGGLE:")) {
                int nodeId = Integer.parseInt(input.split(":")[1]);
                server.toggleNodeMalicious(nodeId);
            } else if (input.equals("VIEW")) {
                for (Node node : nodes) {
                    System.out.println("Node " + node.getFilePath() + ": " + node.getReceivedValues());
                }
            } else {
                System.out.println("Invalid command. Use PROPOSE:<value>, TOGGLE:<nodeId>, or VIEW.");
            }
        }
    }
}
