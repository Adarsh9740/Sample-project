import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class BankGUI extends JFrame {
	private Bank bank;
	private JTextField pinField;
	private JLabel statusLabel;
	private JFrame frame;

	public BankGUI() {
		bank = new Bank();
		frame = new JFrame("SBI Bank");

		// Login Panel
		JPanel loginPanel = new JPanel(new GridLayout(3, 1));
		JLabel pinLabel = new JLabel("Enter your 4-digit PIN:");
		pinField = new JTextField(10);
		JButton loginButton = new JButton("Login");
		statusLabel = new JLabel("");

		loginButton.addActionListener(e -> validatePin());

		loginPanel.add(pinLabel);
		loginPanel.add(pinField);
		loginPanel.add(loginButton);
		loginPanel.add(statusLabel);

		frame.add(loginPanel);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	// Validate PIN
	private void validatePin() {
		int pin = Integer.parseInt(pinField.getText());
		if (bank.validatePin(pin)) {
			showMainMenu();
		} else {
			statusLabel.setText("Incorrect PIN. Try again.");
		}
	}

	// Show Main Menu
	private void showMainMenu() {
		frame.getContentPane().removeAll();
		frame.setLayout(new GridLayout(6, 1));

		JButton checkBalanceButton = new JButton("Check Balance");
		JButton depositButton = new JButton("Deposit");
		JButton withdrawButton = new JButton("Withdraw");
		JButton historyButton = new JButton("Transaction History");
		JButton resetPinButton = new JButton("Reset PIN");
		JButton interestButton = new JButton("Calculate Interest");

		checkBalanceButton.addActionListener(e -> showBalance());
		depositButton.addActionListener(e -> deposit());
		withdrawButton.addActionListener(e -> withdraw());
		historyButton.addActionListener(e -> showHistory());
		resetPinButton.addActionListener(e -> resetPin());
		interestButton.addActionListener(e -> calculateInterest());

		frame.add(checkBalanceButton);
		frame.add(depositButton);
		frame.add(withdrawButton);
		frame.add(historyButton);
		frame.add(resetPinButton);
		frame.add(interestButton);

		frame.revalidate();
		frame.repaint();
	}

	// Show Balance
	private void showBalance() {
		JOptionPane.showMessageDialog(frame, "Current Balance: " + bank.getBalance());
	}

	// Deposit
	private void deposit() {
		String amountStr = JOptionPane.showInputDialog(frame, "Enter the amount to deposit:");
		if (amountStr != null) {
			int amount = Integer.parseInt(amountStr);
			bank.deposit(amount);
			JOptionPane.showMessageDialog(frame, "Deposit Successful. New Balance: " + bank.getBalance());
		}
	}

	// Withdraw
	private void withdraw() {
		String amountStr = JOptionPane.showInputDialog(frame, "Enter the amount to withdraw:");
		if (amountStr != null) {
			int amount = Integer.parseInt(amountStr);
			if (bank.withdraw(amount)) {
				JOptionPane.showMessageDialog(frame, "Withdrawal Successful. New Balance: " + bank.getBalance());
			} else {
				JOptionPane.showMessageDialog(frame, "Insufficient Balance or Limit Exceeded.");
			}
		}
	}

	// Show Transaction History
	private void showHistory() {
		ArrayList<String> history = bank.getTransactionHistory();
		StringBuilder historyStr = new StringBuilder();
		for (String transaction : history) {
			historyStr.append(transaction).append("\n");
		}
		JOptionPane.showMessageDialog(frame, historyStr.toString(), "Transaction History",
				JOptionPane.INFORMATION_MESSAGE);
	}

	// Reset PIN
	private void resetPin() {
		String newPin = JOptionPane.showInputDialog(frame, "Enter new 4-digit PIN:");
		if (newPin != null && newPin.length() == 4) {
			bank.setPin(Integer.parseInt(newPin));
			JOptionPane.showMessageDialog(frame, "PIN reset successful.");
		} else {
			JOptionPane.showMessageDialog(frame, "Invalid PIN entered.");
		}
	}

	// Calculate Interest
	private void calculateInterest() {
		String rateStr = JOptionPane.showInputDialog(frame, "Enter interest rate:");
		if (rateStr != null) {
			double rate = Double.parseDouble(rateStr);
			double interest = bank.calculateInterest(rate);
			JOptionPane.showMessageDialog(frame, "Calculated Interest: " + interest);
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(BankGUI::new);
	}
}

class Bank {
	private int pin = 1111;
	private int balance = 1000;
	private final int dailyWithdrawalLimit = 500;
	private int dailyWithdrawnAmount = 0;
	private ArrayList<String> transactionHistory = new ArrayList<>();

	public boolean validatePin(int enteredPin) {
		return enteredPin == pin;
	}

	public int getBalance() {
		return balance;
	}

	public void deposit(int amount) {
		if (amount > 0) {
			balance += amount;
			addTransaction("Deposit: " + amount);
		}
	}

	public boolean withdraw(int amount) {
		if (amount > 0 && balance >= amount && dailyWithdrawnAmount + amount <= dailyWithdrawalLimit) {
			balance -= amount;
			dailyWithdrawnAmount += amount;
			addTransaction("Withdraw: " + amount);
			return true;
		}
		return false;
	}

	public ArrayList<String> getTransactionHistory() {
		return transactionHistory;
	}

	public void setPin(int newPin) {
		pin = newPin;
		addTransaction("PIN changed.");
	}

	public double calculateInterest(double rate) {
		double interest = balance * (rate / 100);
		addTransaction("Interest calculated: " + interest);
		return interest;
	}

	private void addTransaction(String transaction) {
		if (transactionHistory.size() >= 10) { // Limit to last 10 transactions
			transactionHistory.remove(0);
		}
		transactionHistory.add(transaction);
	}
}
