package Main.Classes;

import java.sql.*;

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

    private Supermercado createSupermarket(String[] splitInfo) {
        final Supermercado supermercado = Supermercado.Builder.newInstance()
                                                  .code(Integer.parseInt(splitInfo[0]))
                                                  .NIF(splitInfo[1])
                                                  .CCAA(splitInfo[2])
                                                  .localitat(splitInfo[3])
                                                  .zipCode(splitInfo[4])
                                                  .address(splitInfo[5])
                                                  .phoneNumber(splitInfo[6])
                                                  .email(splitInfo[7])
                                                  .area(Integer.parseInt(splitInfo[8]))
                                                  .build();
        return supermercado;
    }

    public Supermercado createSupermarket(int supermarketCode) throws SQLException {
        ResultSet resultSet = getData(supermarketCode);
        resultSet.next();

        int code = resultSet.getInt(1);
        String NIF = resultSet.getString(2);
        String CCAA = resultSet.getString(3);
        String localitat = resultSet.getString(4);
        String zipCode = resultSet.getString(5);
        String address = resultSet.getString(6);
        String phoneNumber = resultSet.getString(7);
        String email = resultSet.getString(8);
        int area = resultSet.getInt(9);


        Supermercado supermercado = Supermercado.Builder.newInstance()
                                            .code(code)
                                            .NIF(NIF)
                                            .CCAA(CCAA)
                                            .localitat(localitat)
                                            .zipCode(zipCode)
                                            .address(address)
                                            .phoneNumber(phoneNumber)
                                            .email(email)
                                            .area(area)
                                            .build();

        resultSet.close();

        return supermercado;

    }

    private ResultSet getData(int code) throws SQLException {
            Connection connection = Herramientas.getConexion();

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUPERMERCADO WHERE Codigo_Supermercado = ?");
            preparedStatement.setInt(1, code);

            ResultSet resultSet = preparedStatement.executeQuery();

            preparedStatement.close();


            return resultSet;


    }

}
