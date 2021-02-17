package ClientBackend;

import supports.*;
import java.util.ArrayList;

public class Package {
    public TypeInformation type;
    public Status status;
    private ArrayList<StockShare> stockShares;
    private ArrayList<Share> fuzzyResults;
    public ArrayList<Share> shares;
    private ArrayList<Transaction> transactions;
    private ArrayList<WatchList> watchLists;
    private Share shares_single;

    public Package(TypeInformation type) {
        this.type = type;
    }
    public Package(){

    }

    public void setType(TypeInformation type) {
        this.type = type;
    }

    public void setValue(Status status) {
        this.status = status;
    }

    public void setValue(Object information, Status status) {
        this.status = status;
        switch (type){
            case STOCK_INFO:
                stockShares = (ArrayList<StockShare>) information;
                break;
            case WATCHLIST_INFO:
                shares = (ArrayList<Share>) information;
                break;
            case SHARE_INFO:
                shares_single = (Share) information;
            case FUZZY_INFO:
                fuzzyResults = (ArrayList<Share>) information;

        }
    }

    public Object getValue(TypeInformation type){
        switch (type){
            case STOCK_INFO:
                return stockShares;
            case WATCHLIST_INFO:
                return shares;
            case SHARE_INFO:
                return shares_single;
            case FUZZY_INFO:
                return fuzzyResults;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Package{" +
                "type=" + type +
                ", status=" + status +
                ", stockShares=" + stockShares +
                ", shares=" + shares +
                ", transactions=" + transactions +
                ", watchLists=" + watchLists +
                ", shares_single=" + shares_single +
                '}';
    }
}
