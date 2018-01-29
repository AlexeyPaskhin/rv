package com.utils;

public class User {
    private String login;
    private String pass;

    public User() {
    }

    public User(Builder builder) {
        this.login = builder.login;
        this.pass = builder.pass;
    }

    public String getLogin() {
        return login;
    }

    public String getPass() {
        return pass;
    }

    public User generateRandomUser(CustomDataProvider dp) {
        this.login = dp.generateRandomEmail();
        this.pass = dp.generateRandomPass();
        return this;
    }

    public static class Builder {
        private String login;
        private String pass;


        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withPass(String pass) {
            this.pass = pass;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    // for negative test cases
    public User generateRandomUserWithEmailWithoutAt(CustomDataProvider dp) {
        this.login = dp.generateRandomEmailWithoutAt();
        this.pass = dp.generateRandomPass();
        return this;
    }
}
