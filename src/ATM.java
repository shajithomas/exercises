import java.util.*;

public class ATM {
    private Map<String,Integer> denominations = new LinkedHashMap<>();
    private Map<Integer, Integer> billsRepo = new TreeMap<>(Comparator.reverseOrder());
    double balance;

    // To add a new denomination, enter A from the menu. Its not listed since its an admin only option
    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.init();
        char action = 'I';
        Scanner scanner = new Scanner(System.in);
        while (action != 'Q') {
            System.out.println("\nChoose from the following..\n D - For Deposit\n W - For Withdraw \n Q - Quit\n");
            String input = scanner.next();
            action = Character.toUpperCase(input.charAt(0));
            switch (action) {
                case 'D':
                    atm.deposit();
                    break;
                case 'W':
                    atm.withdraw();
                    break;
                // following is an admin only function and is listed in the options
                case 'A':
                    atm.addNewDenomination();
                    break;
                case 'Q':
                    System.exit(0);
            }
        }
    }

    private void deposit(){
        System.out.println("Enter the amount to deposit in the following format" );
        System.out.println("Denomination1:number of bills, Denomination2:number of bills, ...." );
        System.out.println("example: 20:3, 10:8,5:20,1:50");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] entries = input.split("\\s*,\\s*");
        if (!validateInput(entries)) {
            return;
        };
        int depositAmount = 0;

        for (String entry: entries) {
            String[] tokens = entry.split(":");
            String inputBill = tokens[0];
            int inputBillCount= Integer.parseInt(tokens[1]);
            Integer inputBillValue = denominations.get(inputBill);
            if ( inputBillValue == null || inputBillCount < 0) {
                System.out.println("Incorrect deposit amount");
            } else {
                Integer billCount = billsRepo.get(inputBillValue);
                billsRepo.put(inputBillValue, billCount + inputBillCount);
                depositAmount += inputBillValue * inputBillCount;
            }
        }
        if (depositAmount <= 0) {
            System.out.println("Deposit amount cannot be zero");
        } else {
            balance += depositAmount;
            System.out.print("Balance: ");
            for (Map.Entry<Integer, Integer> bill : billsRepo.entrySet()) {
                System.out.print(bill.getKey() + "=" + bill.getValue() + ",");
            }
            System.out.println("Total=" + balance);
        }

    }

    private boolean validateInput(String[] entries) {
        for (String entry : entries) {
            String[] tokens = entry.split(":");
            String inputBill = tokens[0];
            int inputBillCount = Integer.parseInt(tokens[1]);
            Integer inputBillValue = denominations.get(inputBill);
            if (inputBillValue == null || inputBillCount < 0) {
                System.out.println("Incorrect deposit amount");
                return false;
            }
        }
        return true;
    }

    private void withdraw(){
        System.out.println("balance = " + balance);
        System.out.println("Enter the amount to withdraw" );
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        if (amount > balance || amount <= 0 ) {
            System.out.println("Incorrect or insufficient funds");
        } else {
            dispenseBills(amount);
        }
    }

    private void dispenseBills(int amount){
        int balanceAmount = amount;
        System.out.print("Dispensed: ");
        for (Map.Entry<Integer, Integer> bill : billsRepo.entrySet()) {
            int billValue = bill.getKey();
            int billsCount = balanceAmount / billValue;
            if ( billsCount > bill.getValue()) {
                billsCount = bill.getValue();
            }
            billsRepo.put(billValue, bill.getValue() - billsCount);
            balanceAmount = balanceAmount - (billsCount * billValue);
            System.out.print(billValue + "=" + billsCount +",");
            if (balanceAmount <= 0) {
                break;
            }
        }
        balance -= amount;

        System.out.print("\nBalance: ");
        for (Map.Entry<Integer, Integer> entry : billsRepo.entrySet()) {
            System.out.print(entry.getKey() + "=" + entry.getValue() + ",");
        }
        System.out.printf("Total=%.0f\n",balance);

    }

    private void init() {
        denominations.put("20", 20);
        denominations.put("10", 10);
        denominations.put("5", 5);
        denominations.put("1", 1);

        //initialize the bill repo with 0 bill count
        for (Integer bill : denominations.values()) {
            billsRepo.put(bill, 0);
        }
        balance = 0;
    }

    private void addNewDenomination() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new denomination to add in the following format");
        System.out.println("denomination:count");
        System.out.println("Example: 50:50");
        String[] tokens = scanner.nextLine().split(":");
        String billName = tokens[0].trim();
        int billValue = Integer.parseInt(tokens[1].trim());
        addDenomination(billName, billValue);
    }

    // an admin can add new denominations by calling this function
    public void addDenomination(String valueStr, int value) {
        if (denominations.get(valueStr) != null) {
            System.out.println("This denomination already exists");
        } else {
            denominations.put(valueStr, value);
            billsRepo.put(value, 0);
        }
    }
}
