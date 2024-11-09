import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CircuitSolverGUI extends JFrame {

    private JTextField nodeField, branchField;
    private JTextArea aMatrixArea, impedanceArea, voltageArea, outputArea;

    public CircuitSolverGUI() {
        setTitle("Electric Circuit Solver");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(5, 2, 5, 5));

        nodeField = new JTextField();
        branchField = new JTextField();
        aMatrixArea = new JTextArea(5, 10);
        impedanceArea = new JTextArea(5, 10);
        voltageArea = new JTextArea(5, 10);
        outputArea = new JTextArea(10, 40);
        outputArea.setEditable(false);

        // Input fields
        inputPanel.add(new JLabel("Number of Nodes:"));
        inputPanel.add(nodeField);
        inputPanel.add(new JLabel("Number of Branches:"));
        inputPanel.add(branchField);
        inputPanel.add(new JLabel("A Matrix (one row per line):"));
        inputPanel.add(new JScrollPane(aMatrixArea));
        inputPanel.add(new JLabel("Impedances (Z) for each branch:"));
        inputPanel.add(new JScrollPane(impedanceArea));
        inputPanel.add(new JLabel("Voltage sources (V) for each branch:"));
        inputPanel.add(new JScrollPane(voltageArea));

        // Calculate button
        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateActionListener());

        // Adding components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.CENTER);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        setVisible(true);
    }

    private class CalculateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int nodes = Integer.parseInt(nodeField.getText().trim());
                int branches = Integer.parseInt(branchField.getText().trim());

                double[][] A = new double[nodes][branches];
                String[] aMatrixRows = aMatrixArea.getText().split("\n");
                for (int i = 0; i < nodes; i++) {
                    String[] values = aMatrixRows[i].trim().split("\\s+");
                    for (int j = 0; j < branches; j++) {
                        A[i][j] = Double.parseDouble(values[j]);
                    }
                }

                double[] impedances = parseInputArray(impedanceArea.getText().split("\\s+"), branches);
                double[] voltages = parseInputArray(voltageArea.getText().split("\\s+"), branches);

                double[] currents = new double[branches];
                double[] branchVoltages = new double[branches];

                for (int i = 0; i < branches; i++) {
                    if (impedances[i] != 0) {
                        currents[i] = voltages[i] / impedances[i];
                    } else {
                        currents[i] = 0;
                    }
                    branchVoltages[i] = currents[i] * impedances[i];
                }

                // Output results
                StringBuilder result = new StringBuilder();
                result.append("Branch Currents (A):\n");
                for (int i = 0; i < branches; i++) {
                    result.append(String.format("Branch %d: %.2f A\n", i + 1, currents[i]));
                }
                result.append("\nBranch Voltages (V):\n");
                for (int i = 0; i < branches; i++) {
                    result.append(String.format("Branch %d: %.2f V\n", i + 1, branchVoltages[i]));
                }

                outputArea.setText(result.toString());

            } catch (Exception ex) {
                outputArea.setText("Error in input or calculation: " + ex.getMessage());
            }
        }

        private double[] parseInputArray(String[] input, int size) throws NumberFormatException {
            double[] array = new double[size];
            for (int i = 0; i < size; i++) {
                array[i] = Double.parseDouble(input[i]);
            }
            return array;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CircuitSolverGUI::new);
    }
}

