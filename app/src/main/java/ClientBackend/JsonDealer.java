package ClientBackend;

import supports.*;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class JsonDealer {
    Account account;
    Client client;

    public JsonDealer(Client client) {
        this.client = client;
    }

    private JSONObject getJsonModel(){
        /***
         * 获取request Json模板 (without login)
         [JsonObject] * User : null
         [String] * RequestType : null
         [JsonObject]   * RequestInfo : null

         * 获取request Json模板 (with login)
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String]           * RequestType : null
         [JsonObject]       * RequestInfo : null
         */
        JSONObject object = new JSONObject();
        if(account == null){
            object.put("User","null");
            object.put("RequestType","null");
            object.put("RequestInfo","null");
        }else {
            JSONObject user = new JSONObject();
            user.put("UserName",account.accountName);
            user.put("UserID",account.accountID);
            object.put("User",user);
            object.put("RequestType","null");
            object.put("RequestInfo","null");
        }

        return object;
    }


    public JSONObject getJsonLogin(String name,String password){
        /***
         * 获取request Login
         [JsonObject] * User : null
         [String] * RequestType : Login
         [JsonObject]   * RequestInfo :
         *              *[String] Name : name
         *              *[String] Password : password
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","Login");
        JSONObject loginInfo = new JSONObject();

        loginInfo.put("Name",name);
        loginInfo.put("Password",password);
        jsonModel.put("RequestInfo",loginInfo);
        return jsonModel;
    }

    public JSONObject getJsonRegistration(String name,String password,Double balance){
        /***
         * 获取request Registration
         [JsonObject] * User : null
         [String] * RequestType : Registration
         [JsonObject]   * RequestInfo :
         [String]             Name : name
         [String]             Password : password
         [Double]             Balance : balance
         */

        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","Registration");
        JSONObject registrationInfo = new JSONObject();

        registrationInfo.put("Name",name);
        registrationInfo.put("Password",password);
        registrationInfo.put("Balance",balance);

        jsonModel.put("RequestInfo",registrationInfo);
        return jsonModel;

    }

    public JSONObject getJsonCancelTransaction(Integer transactionId){
        /***
         * 获取request CancelTransaction
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * Request type : CancelTransaction

         [JsonObject]   * RequestInfo :
         * [String]  TransactionId : transactionId
         */

        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","CancelTransaction");
        JSONObject cancelInfo = new JSONObject();

        cancelInfo.put("TransactionId",transactionId);

        jsonModel.put("RequestInfo",cancelInfo);
        return jsonModel;
    }

    public JSONObject getJsonBuy(String code,Integer numberOfShares, Double price) {
        /***
         * 获取request BuyShare
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : Buy

         [JsonObject]   * RequestInfo :
         * [String] Code : code
         * [Integer] Number : numberOfShares
         * [Double]  Price : price
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","Buy");
        JSONObject shareInfo = new JSONObject();

        shareInfo.put("Code",code);
        shareInfo.put("Number",numberOfShares);
        shareInfo.put("Price",price);

        jsonModel.put("RequestInfo",shareInfo);
        return jsonModel;

    }


    public JSONObject getJsonSell(String code,Integer numberOfShares, Double price) {
        /***
         * 获取request SellShare
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : Sell

         [JsonObject]   * RequestInfo :
         *              * [String] Code : code
         *              * [Integer] Number : numberOfShares
         *              * [Double]  Price : price
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","Sell");
        JSONObject shareInfo = new JSONObject();

        shareInfo.put("Code",code);
        shareInfo.put("Number",numberOfShares);
        shareInfo.put("Price",price);

        jsonModel.put("RequestInfo",shareInfo);
        return jsonModel;

    }

    public JSONObject getJsonAddWatchlist(String code) {
        /***
         * 获取request AddWatchlist
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : AddWatchlist

         [JsonObject]   * RequestInfo :
         *              * [String] Code : code
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","AddWatchlist");
        JSONObject watchlistInfo = new JSONObject();

        watchlistInfo.put("Code",code);

        jsonModel.put("RequestInfo",watchlistInfo);
        return jsonModel;

    }

    public JSONObject getJsonDeleteWatchlist(String code) {
        /***
         * 获取request AddWatchlist
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : DeleteWatchlist

         [JsonObject]   * RequestInfo :
         *              * [String] Code : code
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","DeleteWatchlist");
        JSONObject watchlistInfo = new JSONObject();

        watchlistInfo.put("Code",code);

        jsonModel.put("RequestInfo",watchlistInfo);
        return jsonModel;

    }

    public JSONObject getFussySearch(String code) {
        /***
         * 获取request AddWatchlist
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : FussySearch

         [JsonObject]   * RequestInfo :
         *              * [String] Code : code
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","FussySearch");
        JSONObject watchlistInfo = new JSONObject();

        watchlistInfo.put("Code",code);

        jsonModel.put("RequestInfo",watchlistInfo);
        return jsonModel;

    }

    public JSONObject getJsonGetWatchListInfo() {
        /***
         * 获取request WatchListInfo
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : GetWatchListInfo

         [JsonObject]   * RequestInfo : null
         *
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","GetWatchListInfo");

        return jsonModel;

    }

    public JSONObject getJsonGetStockInfo() {
        /***
         * 获取request StockInfo
         [JsonObject] * User :
         *                  * [String] UserName
         *                  * [String] UserID
         [String] * RequestType : GetStockInfo

         [JsonObject]   * RequestInfo : null
         *
         */
        JSONObject jsonModel = getJsonModel();
        jsonModel.put("RequestType","GetStockInfo");

        return jsonModel;

    }

    public Package mainParser(String jsonString){
        /***  JsonFormat
         * [String]        responseType : LoginResponse
         * [Status]        responseStatus : status
         * [JSONObject]    responseInfo : null
         */
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String responseType = jsonObject.getString("responseType");
        Package aPackage = new Package();
        switch (responseType){
            case "LoginResponse":
                Boolean loginResult = parseLogin(jsonString);
                client.login = loginResult ? true : false;
                Status loginStatus = client.login ? Status.LOGIN_SUCCESSES : Status.LOGIN_FAILED;

                aPackage.setType(TypeInformation.LOGIN);
                aPackage.setValue(loginStatus);
                return aPackage;
            case "RegistrationResponse":
                Boolean registrationResult = parseRegistration(jsonString);
                Status registrationStatus =  registrationResult ? Status.REGISTRATION_SUCCESSES : Status.REGISTRATION_FAILED;

                aPackage.setType(TypeInformation.REGISTRATION);
                aPackage.setValue(registrationStatus);
                return aPackage;
            case "CancelTransaction":
                Boolean cancelTransactionResult = parseCancelTransaction(jsonString);
                Status cancelTransactionStatus = cancelTransactionResult ? Status.CANCEL_SUCCESSES : Status.CANCEL_FAILED;

                aPackage.setType(TypeInformation.TRANSACTION_CANCEL);
                aPackage.setValue(cancelTransactionStatus);
                return aPackage;
            case "WatchListInfo":
                ArrayList<Share> shares = null;
                try {
                    shares = parseGetWatchList(jsonString);
                    aPackage.setType(TypeInformation.WATCHLIST_INFO);
                    aPackage.setValue(shares, Status.GETWatchListInfo_SUCCESSES);
                }catch (Exception e){
                    // the status would be failed there is an exception raised during the execution
                    aPackage.setValue(shares, Status.GETWatchListInfo_FAILED);
                }
                return aPackage;
            case "BUYShares":
                Status buyStatus = parseBuyShare(jsonString);
                aPackage.setType(TypeInformation.TRADING_BUY);
                aPackage.setValue(buyStatus);
                return aPackage;
            case "SELLShares":
                Status sellStatus = parseSellShare(jsonString);
                aPackage.setType(TypeInformation.TRADING_SELL);
                aPackage.setValue(sellStatus);
                return aPackage;
            case "AddWatchList":
            case "DeleteWatchList":
                Status addWatchlistStatus = parseWatchlistOperation(jsonString);
                aPackage.setType(TypeInformation.WATCHLIST_EDIT);
                aPackage.setValue(addWatchlistStatus);
                return aPackage;
            case "FussySearch":
                ArrayList<Share> fuzzyResult = parseFuzzySearch(jsonString);
                aPackage.setType(TypeInformation.FUZZY_INFO);
                aPackage.setValue(fuzzyResult,Status.SUCCESS);
                return aPackage;
            case "StocksInfo":
                ArrayList<StockShare> stockShares = parseStocksInfo(jsonString);
                aPackage.setType(TypeInformation.STOCK_INFO);
                aPackage.setValue(stockShares,Status.SUCCESS);
                return aPackage;
        }
        return null;
    }


    private Boolean parseLogin(String jsonString){
        /***  JsonFormat
         * [String]        responseType : LoginResponse
         * [Status]        responseStatus : status
         * [JSONObject]    responseInfo : null
         */
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String status = jsonObject.getString("responseStatus");
        JSONObject responseInfo = jsonObject.getJSONObject("responseInfo");

        if(status.equals(Status.LOGIN_SUCCESSES.toString())){
            account = new Account(responseInfo.getDouble("Balance"),responseInfo.getString("Name"),responseInfo.getInteger("ID"));

        }
        return status.equals(Status.LOGIN_SUCCESSES.toString()) ? true : false;
    }
    private Boolean parseRegistration(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String status = jsonObject.getString("responseStatus");
        return status.equals(Status.REGISTRATION_SUCCESSES.toString()) ? true : false;
    }
    private Boolean parseCancelTransaction(String jsonString) {
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String status = jsonObject.getString("responseStatus");
        return status.equals(Status.CANCEL_SUCCESSES.toString()) ? true : false;
    }
    private ArrayList<Share> parseGetWatchList(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONObject responseInfo = jsonObject.getJSONObject("responseInfo");
        JSONArray sharesInfo = responseInfo.getJSONArray("SharesInfo");
        ArrayList<Share> watchlistShares = new ArrayList<>();
        for (Object share : sharesInfo) {
            if(share != null){
                Share share1 = JSON.parseObject(share.toString(), Share.class);
                watchlistShares.add(share1);
            }

        }
        return watchlistShares;
    }
    private Status parseBuyShare(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String status = jsonObject.getString("responseStatus");
        return Status.valueOf(status);
    }
    private Status parseSellShare(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String status = jsonObject.getString("responseStatus");
        return Status.valueOf(status);
    }
    private Status parseWatchlistOperation(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String status = jsonObject.getString("responseStatus");
        return Status.valueOf(status);
    }


    private ArrayList<StockShare> parseStocksInfo(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONObject responseInfo = jsonObject.getJSONObject("responseInfo");
        JSONArray sharesInfo = responseInfo.getJSONArray("StocksInfo");
        ArrayList<StockShare> stockShares = new ArrayList<>();

        for (Object share : sharesInfo) {
            JSONObject jsonStockShare = (JSONObject) share;
            if(share != null){
                StockShare stockShare = JSON.parseObject(jsonStockShare.toJSONString(), StockShare.class);
                stockShare.setAccountId(jsonStockShare.getInteger("accountId"));
                stockShare.setAccount(account);
                stockShares.add(stockShare);
            }
        }

        return stockShares;
    }


    private ArrayList<Share> parseFuzzySearch(String jsonString){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        JSONObject responseInfo = jsonObject.getJSONObject("responseInfo");
        JSONArray sharesInfo = responseInfo.getJSONArray("FuzzySharesInfo");
        ArrayList<Share> stockShares = new ArrayList<>();

        for (Object share : sharesInfo) {
            JSONObject jsonStockShare = (JSONObject) share;
            if(share != null){
                Share stockShare = JSON.parseObject(jsonStockShare.toJSONString(), Share.class);

                stockShares.add(stockShare);
            }
        }

        return stockShares;
    }


    public static void main(String[] args) {
        JsonDealer classFactory = new JsonDealer(null);
        JSONObject pkdyc = classFactory.getJsonLogin("pkdyc", "123456");
        System.out.println(pkdyc);

    }
}