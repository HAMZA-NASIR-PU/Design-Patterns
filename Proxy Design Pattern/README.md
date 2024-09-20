# Proxy Design Pattern

The Proxy Design Pattern is a structural design pattern that provides a surrogate or placeholder object to control access to another object. This can help manage resource-intensive objects, provide access control, logging, or lazy initialization.

## Types of Proxy Patterns

- `Virtual Proxy`: Used when creating an expensive object on demand (lazy initialization).

- `Protection Proxy`: Controls access to the original object, useful in scenarios where objects should have different access rights.

- `Remote Proxy`: Used when the object being proxied is in a different address space (e.g., across a network).

- `Cache Proxy`: Adds caching behavior to avoid duplicate calls for costly or time-consuming operations.

## Real-Life Example: Bank Account Access

Imagine you are working in a banking system. In this system, not every customer is allowed to directly access their bank account details. For instance, a customer service representative (CSR) can access limited details, whereas a bank manager has full access to the account information.

Here, you can use a proxy to control access to the sensitive bank account data.

### Scenario

1. `Bank Account (Real Object)`: The actual bank account object that contains sensitive information like balance, account number, and transaction history.

2. `Proxy (Access Control)`: The proxy object controls who can access which parts of the bank account data.

   - When a CSR requests data, the proxy limits the information to the account holder's name and contact details.

   - When a bank manager accesses it, the proxy grants full access to all account details.


```java
// The interface for bank account access
interface BankAccount {
    void getAccountDetails();
}

// Real bank account class that contains sensitive information
class RealBankAccount implements BankAccount {
    private String accountNumber;
    private double balance;
    
    public RealBankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
    
    @Override
    public void getAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);
    }
}

// Proxy class that controls access to the RealBankAccount
class BankAccountProxy implements BankAccount {
    private RealBankAccount realBankAccount;
    private String role;  // Role: CSR or Manager

    public BankAccountProxy(String accountNumber, double balance, String role) {
        this.realBankAccount = new RealBankAccount(accountNumber, balance);
        this.role = role;
    }

    @Override
    public void getAccountDetails() {
        if (role.equalsIgnoreCase("Manager")) {
            realBankAccount.getAccountDetails();
        } else if (role.equalsIgnoreCase("CSR")) {
            System.out.println("Access Denied: Insufficient Privileges for Full Details");
        } else {
            System.out.println("Invalid Role");
        }
    }
}

// Test the proxy
public class ProxyPatternTest {
    public static void main(String[] args) {
        BankAccount managerAccess = new BankAccountProxy("12345", 10000.0, "Manager");
        managerAccess.getAccountDetails(); // Full access
        
        BankAccount csrAccess = new BankAccountProxy("12345", 10000.0, "CSR");
        csrAccess.getAccountDetails(); // Limited access
    }
}
```

### Explanation

1. `RealBankAccount`: Represents the actual bank account object containing sensitive data.

2. `BankAccountProxy`: Acts as a proxy to the real object, controlling access based on the user's role.

3. `CSR`: Limited access (e.g., unable to view balance).

4. `Manager`: Full access to account details.

This example is relevant in interviews because:

- It shows an understanding of real-world access control scenarios (common in banking or secure applications).

- It demonstrates how the Proxy Design Pattern can be used to enhance security and access control, which is a common requirement in software engineering.
