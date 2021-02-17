package ClientBackend;

import com.alibaba.fastjson.JSONObject;
import supports.*;

import java.io.IOException;
import java.util.ArrayList;

public class MainControl {
    public Client client;

    public MainControl(){
        client = Client.mainEntrance();
    }

    public ArrayList<Share> getWatchListShares(){
        /**
         * return all the shares information (depends on your own subscription)
         *
         *  the status of package could be only :
         *      * GETWatchListInfo_SUCCESSES : get request watchlist information (about the shares you subscribe) successfully
         *      * GETWatchListInfo_FAILED : fail to get the watchlist information (rarely happen,raise when there is an exception during parsing method)
         *
         *      ---- only could be use after log on
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonGetWatchListInfo().toString());
            Package aPackage = client.getPackage();
            if(aPackage.status == Status.GETWatchListInfo_SUCCESSES){
                return aPackage.shares;
                // return (ArrayList<Share>) aPackage.getValue(TypeInformation.WATCHLIST_INFO);
            }else {
                System.out.println("error raising!!! \n");
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error raising!!! \n Reason : " + e);
        }
        return null;
    }

    public Status login(String name, String password){
        /**
         * use for login
         * the return value would be
         *      * LOGIN_FAILED : incorrect password, unable to login in
         *      * LOGIN_SUCCESSES : successfully login
         *
         *      ---- only could be use after log on
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonLogin(name,password).toString());
            Package aPackage = client.getPackage();
            return aPackage.status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public Status registration(String name, String password, Double balance){
        /**
         * use for registration
         * the return value would be
         *      * REGISTRATION_SUCCESSES : successfully register
         *      * REGISTRATION_FAILED : exist an account with identical name
         *
         *      ---- only could be use after log on
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonRegistration(name,password,balance).toString());
            Package aPackage = client.getPackage();
            return aPackage.status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public Status buyShares(String code, Integer numbers, Double price){
        /**
         * use for purchasing shares
         * the return value would be
         *       * INVALID_Number : 无效的价格或者数量
         *       * I NVALID_Code : 无效的股票代码或者名字
         *       * INSUFFICIENT_Fund : account内资金不够
         *       * SUCCESS : 交易成功
         *       * PENDING : 交易正在等待中 (等待直到设定价格)
         *
         *       ---- only could be use after log on
         *       ---- in this version : you could only use shares code for trading (begin with SZ or SH)
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonBuy(code,numbers,price).toJSONString());
            return client.getPackage().status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public Status SellShares(String code, Integer numbers, Double price){
        /**
         * use for selling shares
         * the return value would be
         *       * INVALID_Number : 无效的价格或者数量
         *       * I NVALID_Code : 无效的股票代码或者名字
         *       * INSUFFICIENT_SHARES : account内卖出时 某一之股票数量小于卖出股票数量
         *       * SUCCESS : 交易成功
         *       * PENDING : 交易正在等待中 (等待直到设定价格)
         *
         *       ---- only could be use after log on
         *       ---- in this version : you could only use shares code for trading (begin with SZ or SH)
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonSell(code,numbers,price).toJSONString());
            return client.getPackage().status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public Status cancelTransaction(Integer transactionID){
        /**
         *      used to cancel a transaction which in pending status
         *
         *      the return value would be
         *      * CANCEL_SUCCESSES : successfully cancel order
         *      * CANCEL_FAILED : cancel order failed : it might be caused by not existing such order or the order is not in PENDING Status
         *        ---- only could be use after log on
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonCancelTransaction(33).toString());
            return client.getPackage().status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public Status addWatchlist(String code){
        /**
         *      used to add a share to the watchlist
         *
         *      the return value would be
         *      * WatchlistOperation_SUCCESSES : watchlist operation successfully
         *      * WatchlistOperation_FAILED : watchlist operation failed due to (incorrect shares code or shares name) or unhandle exception (rarely happen)
         *      * WatchlistAddAlreadyExist : adding watchlist operation failed due to there are already been added
         *        ---- only could be use after log on
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonAddWatchlist(code).toString());
            return client.getPackage().status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public Status deleteWatchlist(String code){
        /**
         *      used to delete a share from the watchlist
         *
         *      the return value would be
         *      * WatchlistOperation_SUCCESSES : watchlist operation successfully
         *      * WatchlistOperation_FAILED : watchlist operation failed due to (incorrect shares code or shares name) or unhandle exception (rarely happen)
         *      * WatchlistDeleteNotExist : deleting watchlist failed due to there is not such share in the watchlist
         *        ---- only could be use after log on
         */
        try {
            client.sendRequest(client.jsonDealer.getJsonDeleteWatchlist(code).toString());
            return client.getPackage().status;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Status.IMPOSSIBLE_STATUS;
    }

    public ArrayList<StockShare> getStocks(){
        /**
         * it is used to get all the stocks information in the current login account
         * it will return an empty arraylist when there is no stock in the shares (or when raising unexceptional error)
         * ---- only could be use after log on
         */
        JSONObject jsonGetStockInfo = client.jsonDealer.getJsonGetStockInfo();
        try {
            client.sendRequest(jsonGetStockInfo.toString());
            ArrayList<StockShare> value = (ArrayList<StockShare>) client.getPackage().getValue(TypeInformation.STOCK_INFO);
            return value;
        }catch (Exception e){
            System.out.println("error raising during steps");
            return new ArrayList<StockShare>();
        }

    }

    public ArrayList<Share> getFuzzySearch(String code){

        /**
         * it is used for Fuzzy searching
         * it will return an empty arraylist when
         *  1 : there is no related shares
         *  2 : when raising unexceptional error
         *  3 : when the input code is empty : for instance : mainControl.getFuzzySearch("") or mainControl.getFuzzySearch(null)
         * ---- only could be use after log on
         */
        try {
            if(code == null){
                return new ArrayList<Share>();
            }
            client.sendRequest(client.jsonDealer.getFussySearch(code).toString());
            ArrayList<Share> value = (ArrayList<Share>) client.getPackage().getValue(TypeInformation.FUZZY_INFO);
            return value;
        }catch (Exception e){
            System.out.println("error raising during Fuzzy searching");
            return new ArrayList<Share>();
        }

    }




    
}
