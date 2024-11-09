# Electric Circuit Solver (GUI)

This Java application calculates the branch voltages and currents of an electric circuit based on user-input impedance values, voltage sources, and an incidence matrix (A matrix) for a simple circuit graph. The program uses a graphical user interface (GUI) built with Swing to make it easy to input circuit data and view results.

## Features

Input the number of nodes, branches, A matrix, impedances, and voltage sources.
Calculate and display the currents and voltages for each branch.
Handles simple circuit graphs using resistors (impedances) and DC voltage sources.

## Prerequisites
Java Development Kit (JDK) 8 or higher installed.
A Java IDE (such as IntelliJ IDEA, Eclipse, or NetBeans) or the ability to run Java files from the command line.

## Running the Application
### Steps
1. Clone or Download the Repository Download or clone this repository to your local machine. 
2. Compile the Program Open a terminal or command prompt, navigate to the folder containing CircuitSolverGUI.java, and compile it with the following command:
   project CircuitSolverGUI.java
3. Run the Program Once compiled, run the application with:
   java CircuitSolverGUI


4. Input Data and Calculate

* Enter the number of nodes: The total number of nodes in the circuit.
* Enter the number of branches: The total number of branches in the circuit.
* Enter the A matrix: Input each row of the matrix in separate lines, where each row corresponds to a node and each column to a branch.
* Enter impedances for each branch: The impedance (resistance in ohms) for each branch.
* Enter voltage sources for each branch: Voltage sources (in volts) for each branch.
* Press Calculate to see the resulting branch currents and voltages.

## Example Input

To test the application, try the following example:

* Number of Nodes: 2
* Number of Branches: 3
* A Matrix:
*         1 -1 0
          0 1 -1
* Impedances: 5 10 15
* Voltage Sources: 10 0 0
* After clicking Calculate, the output should display the currents and voltages for each branch.

## Output Example

The output area will show something similar to:
* Branch Currents (A):
* Branch 1: 2.00 A
* Branch 2: 0.00 A
* Branch 3: 0.00 A


* Branch Voltages (V):
* Branch 1: 10.00 V
* Branch 2: 0.00 V
* Branch 3: 0.00 V

## Customizing the Code

To extend this code for more complex circuits, modify the CalculateActionListener class to handle additional components (e.g., capacitors, inductors) or to include time-dependent analysis if using AC sources.

## Troubleshooting

Ensure that the A matrix, impedances, and voltage sources are all entered correctly and match the number of branches.
For any parsing or format errors, check the output area for details on the error.
