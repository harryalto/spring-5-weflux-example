package com.hnath.learn.reactivespring.model.coinMarketCap;

public class CoinMarketCapResponse
{
    private Data data;

    private Status status;

    public Data getData ()
    {
        return data;
    }

    public void setData (Data data)
    {
        this.data = data;
    }

    public Status getStatus ()
    {
        return status;
    }

    public void setStatus (Status status)
    {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [data = "+data+", status = "+status+"]";
    }
}

