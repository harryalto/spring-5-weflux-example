package com.hnath.learn.reactivespring.model;

public class CoinBaseResponse {

    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(final Data data) {
        this.data = data;
    }

    public  static  class Data {

        private String base;
        private String currency;
        private String amount;


        public String  getBase() {
            return base;
        }

        void setBase(final String base) {
            this.base = base;
        }

        String getCurrency() {
            return currency;
        }

        void setCurrency(final String currency) {
            this.currency = currency;
        }

        public String  getAmount() {
            return amount;
        }

        void setAmount(final String amount) {
            this.amount = amount;
        }
    }


}
