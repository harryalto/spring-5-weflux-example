package com.hnath.learn.reactivespring.model.coinMarketCap;

public class Quote
{
    private USD USD;

    public USD getUSD ()
    {
        return USD;
    }

    public void setUSD (USD USD)
    {
        this.USD = USD;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [USD = "+USD+"]";
    }
}

