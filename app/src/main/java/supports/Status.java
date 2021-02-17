package supports;


public enum Status {
    /***
     * SUCCESS : 交易成功
     * PENDING : 交易正在等待中 (等待直到设定价格)
     * BUY : 此交易是用于买入
     * SELL : 此交易是用于卖出
     * CANCEL : 订单被取消
     * INVALID_Number : 无效的价格或者数量
     * INVALID_Code : 无效的股票代码或者名字
     * INSUFFICIENT_Fund : account内资金不够
     * INSUFFICIENT_SHARES : account内卖出时 某一之股票数量小于卖出股票数量
     *
     * LOGIN_FAILED : incorrect password, unable to login in
     * LOGIN_SUCCESSES : successfully login
     *
     * REGISTRATION_SUCCESSES : successfully register
     * REGISTRATION_FAILED : exist an account with identical name
     *
     * CANCEL_SUCCESSES : successfully cancel order
     * CANCEL_FAILED : cancel order failed : it might be caused by not existing such order or the order is not in PENDING Status
     *
     * GETWatchListInfo_SUCCESSES : get request watchlist information (about the shares you subscribe) successfully
     * GETWatchListInfo_FAILED : fail to get the watchlist information (rarely happen,raise when there is an exception during parsing method)
     *
     * WatchlistOperation_SUCCESSES : watchlist operation successfully
     * WatchlistOperation_FAILED : watchlist operation failed due to (incorrect shares code or shares name) or unhandle exception (rarely happen)
     * WatchlistAddAlreadyExist : adding watchlist operation failed due to there are already been added
     * WatchlistDeleteNotExist : deleting watchlist failed due to there is not such share in the watchlist
     *
     * IMPOSSIBLE_STATUS : this should never show up (the purpose of this Enum is to alert that there exist an error in that method)
     */

    SUCCESS,
    PENDING,
    BUY,
    SELL,
    CANCEL,
    INVALID_Number,
    INVALID_Code,
    INSUFFICIENT_Fund,
    LOGIN_FAILED,
    LOGIN_SUCCESSES,
    REGISTRATION_SUCCESSES,
    REGISTRATION_FAILED,
    CANCEL_SUCCESSES,
    CANCEL_FAILED,
    GETWatchListInfo_SUCCESSES,
    GETWatchListInfo_FAILED,
    INSUFFICIENT_SHARES,
    IMPOSSIBLE_STATUS,
    WatchlistOperation_SUCCESSES,
    WatchlistOperation_FAILED,
    WatchlistAddAlreadyExist,
    WatchlistDeleteNotExist;



}

