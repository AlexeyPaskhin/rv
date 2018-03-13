package com.utils;

public class Card {
    private String number;
    private String holder;
    private String cvv;

    public Card() {
    }

    public Card(Builder builder) {
        this.number = builder.number;
        this.holder = builder.holder;
        this.cvv = builder.cvv;
    }

    public String getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public String getCvv() {
        return cvv;
    }

    public static class Builder {
        private String number;
        private String holder;
        private String cvv;


        public Builder withNumber(String number) {
            this.number = number;
            return this;
        }

        public Builder withHolder(String holder) {
            this.holder = holder;
            return this;
        }

        public Builder withCvv(String cvv) {
            this.cvv = cvv;
            return this;
        }

        public Card build() {
            return new Card(this);
        }
    }
}
