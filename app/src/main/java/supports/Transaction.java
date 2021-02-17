package supports;

import java.sql.Connection;

public class Transaction {
    Account account;
    Status type;
    String type_string;
    String code;
    String name;
    Double price;
    Integer amount;
    Status executionStatus;
    Boolean complete = false;
    Connection connection;
    String time;
    Share share;
    Double total_price;
    String status_string;
    Integer account_id;
    Integer transactionPrimaryKey = null;
    public Transaction(Account account, Double price, Integer amount, String code,Status type, Connection connection) {
        this.account = account;
        this.price = price;
        this.amount = amount;
        this.code = code;
        this.connection = connection;
        this.type = type;
    }

    public Transaction(String type, String code, String name, Double price, Integer amount, String time, Double total_price, String status, Integer account_id , Integer transactionPrimaryKey ) {
        this.type_string = type;
        this.code = code;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.time = time;
        this.total_price = total_price;
        this.status_string = status;
        this.account_id = account_id;
        this.transactionPrimaryKey = transactionPrimaryKey;
    }



    @Override
    public String toString() {
        return "Transaction{" +
                "type=" + type +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", time='" + time + '\'' +
                ", total_price=" + total_price +
                ", status_string='" + status_string + '\'' +
                ", account_id=" + account_id +
                '}';
    }

}
