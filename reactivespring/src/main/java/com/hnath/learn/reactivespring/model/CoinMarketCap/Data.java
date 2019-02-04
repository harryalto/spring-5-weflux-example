package com.hnath.learn.reactivespring.model.CoinMarketCap;

public class Data {

    private BTC BTC;

    public BTC getBTC() {
        return BTC;
    }

    public void setBTC(BTC BTC) {
        this.BTC = BTC;
    }

    @Override
    public String toString() {
        return "ClassPojo [BTC = " + BTC + "]";
    }

}
