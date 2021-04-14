package main.java.Main.Classes;

import java.util.concurrent.atomic.AtomicInteger;

public class Supermarket {
    private AtomicInteger amount = new AtomicInteger(0);
    private int code;
    private String NIF;
    private String CCAA;
    private String localitat;
    private int zipCode;
    private String address;
    private int phoneNumber;
    private String email;
    private float area;



    public static class Builder { //Builder Pattern
        private String NIF;
        private String CCAA;
        private String localitat;
        private int zipCode;
        private String address;
        private int phoneNumber;
        private String email;
        private float area;

        public static Builder newInstance() {
            return new Builder();

        }

        public Builder NIF(String NIF) {
            this.NIF = NIF;
            return this;

        }

        public Builder CCAA(String CCAA) {
            this.CCAA = CCAA;
            return this;

        }

        public Builder localitat(String localitat) {
            this.localitat = localitat;
            return this;

        }

        public Builder zipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;

        }

        public Builder address(String address) {
            this.address = address;
            return this;

        }

        public Builder phoneNumber(int phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;

        }

        public Builder email(String email) {
            this.email = email;
            return this;

        }

        public Builder area(int area) {
            this.area = area;
            return this;

        }

        public Supermarket build() {
            Supermarket supermarket = new Supermarket();
            supermarket.code = supermarket.amount.getAndIncrement();
            supermarket.NIF = this.NIF;
            supermarket.CCAA = this.CCAA;
            supermarket.localitat = this.localitat;
            supermarket.zipCode = this.zipCode;
            supermarket.address = this.address;
            supermarket.phoneNumber = this.phoneNumber;
            supermarket.email = this.email;
            supermarket.area = this.area;
            return supermarket;

        }


    }

    private Supermarket() {
        this.code = amount.getAndIncrement();

    }
}
