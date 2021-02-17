package supports;

public class Share {
    String currency;
    String stock_name;
    String stock_code;
    Double currentPrice;
    Double change_value;
    Double change_percentage;
    Double price_lowest;
    Double price_highest;
    String PERate_TTM;
    String PERate_static;
    String amplitude;
    Double price_begin;
    String trade_status;
    String currentTime;
    Boolean tradable;
    String url;
    String url_ALL;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

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

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getChange_value() {
        return change_value;
    }

    public void setChange_value(Double change_value) {
        this.change_value = change_value;
    }

    public Double getChange_percentage() {
        return change_percentage;
    }

    public void setChange_percentage(Double change_percentage) {
        this.change_percentage = change_percentage;
    }

    public Double getPrice_lowest() {
        return price_lowest;
    }

    public void setPrice_lowest(Double price_lowest) {
        this.price_lowest = price_lowest;
    }

    public Double getPrice_highest() {
        return price_highest;
    }

    public void setPrice_highest(Double price_highest) {
        this.price_highest = price_highest;
    }

    public String getPERate_TTM() {
        return PERate_TTM;
    }

    public void setPERate_TTM(String PERate_TTM) {
        this.PERate_TTM = PERate_TTM;
    }

    public String getPERate_static() {
        return PERate_static;
    }

    public void setPERate_static(String PERate_static) {
        this.PERate_static = PERate_static;
    }

    public String getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(String amplitude) {
        this.amplitude = amplitude;
    }

    public Double getPrice_begin() {
        return price_begin;
    }

    public void setPrice_begin(Double price_begin) {
        this.price_begin = price_begin;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Boolean getTradable() {
        return tradable;
    }

    public void setTradable(Boolean tradable) {
        this.tradable = tradable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl_ALL() {
        return url_ALL;
    }

    public void setUrl_ALL(String url_ALL) {
        this.url_ALL = url_ALL;
    }

    public String simpleString(){
        return stock_code+" "+stock_name+" "+currentPrice+" "+change_value;
    }


    @Override
    public String toString() {
        return "Share{" +
                "currency='" + currency + '\'' +
                ", stock_name='" + stock_name + '\'' +
                ", currentPrice=" + currentPrice +
                ", change_value=" + change_value +
                ", change_percentage=" + change_percentage +
                ", price_lowest=" + price_lowest +
                ", price_highest=" + price_highest +
                ", PERate_TTM='" + PERate_TTM + '\'' +
                ", PERate_static='" + PERate_static + '\'' +
                ", amplitude='" + amplitude + '\'' +
                ", price_begin=" + price_begin +
                ", trade_status='" + trade_status + '\'' +
                ", currentTime='" + currentTime + '\'' +
                ", tradable=" + tradable +
                '}';
    }

}
