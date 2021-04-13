import java.util.concurrent.atomic.AtomicInteger;

public class Supermarket {

    public class Builder {
        private AtomicInteger code;
        private String NIF;
        private String CCAA;
        private String localitat;
        private int zipCode;
        private String address;
        private int phoneNumber;
        private String email;
        private float area;

        public Builder(AtomicInteger code) {
            this.code = code;

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
        /*
        public Supermarket build() {
            final Supermarket supermarket = new Supermarket();

        }

         */
    }

}
