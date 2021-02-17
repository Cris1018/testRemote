package supports;
public class StockShare {
    String stock_name;
    String stock_code;
    Account account;
    Integer accountId;



    Integer numberOfHolding = 0;
    Double margin_profit = 0.0;
    Double profit = 0.0;
    Double profit_rate = 0.0;
    Double cost = 0.0;
    Double total_value = 0.0;




    public String getStock_name() {
        return stock_name;
    }

    public void setStock_name(String stock_name) {
        this.stock_name = stock_name;
    }

    public String getStock_code() {
        return stock_code;
    }

    public void setStock_code(String stock_code) {
        this.stock_code = stock_code;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }



    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getNumberOfHolding() {
        return numberOfHolding;
    }

    public void setNumberOfHolding(Integer numberOfHolding) {
        this.numberOfHolding = numberOfHolding;
    }

    public Double getMargin_profit() {
        return margin_profit;
    }

    public void setMargin_profit(Double margin_profit) {
        this.margin_profit = margin_profit;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getProfit_rate() {
        return profit_rate;
    }

    public void setProfit_rate(Double profit_rate) {
        this.profit_rate = profit_rate;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Double total_value) {
        this.total_value = total_value;
    }


    public StockShare(String stock_name, String stock_code, Integer numberOfHolding, Double cost,Integer accountId) {
        this.stock_name = stock_name;
        this.stock_code = stock_code;
        this.numberOfHolding = numberOfHolding;
        this.cost = cost;
        this.accountId = accountId;
    }






    @Override
    public String toString() {
        return "StockShare{" +
                "stock_name='" + stock_name + '\'' +
                ", stock_code='" + stock_code + '\'' +
                ", account=" + account +
                ", numberOfHolding=" + numberOfHolding +
                ", margin_profit=" + margin_profit +
                ", profit=" + profit +
                ", profit_rate=" + profit_rate +
                ", cost=" + cost +
                ", total_value=" + total_value +
                '}';
    }



}
