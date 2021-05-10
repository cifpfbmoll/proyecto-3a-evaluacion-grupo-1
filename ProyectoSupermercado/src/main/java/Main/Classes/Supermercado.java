package Main.Classes;

public class Supermercado {
    private int code;
    private String NIF;
    private String CCAA;
    private String localitat;
    private String zipCode;
    private String address;
    private String phoneNumber;
    private String email;
    private int area;



    public static class Builder { //Builder Pattern
        private int code;
        private String NIF;
        private String CCAA;
        private String localitat;
        private String zipCode;
        private String address;
        private String phoneNumber;
        private String email;
        private int area;

        public static Builder newInstance() {
            return new Builder();

        }

        public Builder code(int code) {
            this.code = code;
            return this;
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

        public Builder zipCode(String zipCode) {
            this.zipCode = zipCode;
            return this;

        }

        public Builder address(String address) {
            this.address = address;
            return this;

        }

        public Builder phoneNumber(String phoneNumber) {
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

        public Supermercado build() {
            Supermercado supermarket = new Supermercado();
            supermarket.code = this.code;
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

    private Supermercado() {

    }
}
