package Main.Classes;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private ArrayList <StockProducto> stockSupermercado;

    public int getCode() {
        return code;
    }

    public ArrayList<StockProducto> getStockSupermercado() {
        return stockSupermercado;
    }

    public String getLocalitat() {
        return localitat;
    }

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
        private ArrayList <StockProducto> stockSupermercado;
        
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
        
        public Builder stockSupermercado(ArrayList <StockProducto> stockSupermercado) {
            this.stockSupermercado = stockSupermercado;
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
            supermarket.stockSupermercado = this.stockSupermercado;
            return supermarket;

        }


    }

    private Supermercado() {

    }


    private static Supermercado instantiateSupermarketFromDB(int supermarketCode) throws SQLException {
        Connection connection = Herramientas.getConexion();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUPERMERCADO WHERE Codigo_Supermercado = ?");
        preparedStatement.setInt(1, supermarketCode);
        ResultSet resultSet=preparedStatement.executeQuery();

        resultSet.next();

        Supermercado supermercado = Builder.newInstance()
                                            .code(resultSet.getInt(1))
                                            .NIF(resultSet.getString(2))
                                            .CCAA(resultSet.getString(3))
                                            .localitat(resultSet.getString(4))
                                            .zipCode(resultSet.getString(5))
                                            .address(resultSet.getString(6))
                                            .phoneNumber(resultSet.getString(7))
                                            .email(resultSet.getString(8))
                                            .area(resultSet.getInt(9))
                                            .stockSupermercado(StockProducto.obtenerStockSupermercado(supermarketCode))
                                            .build();

        resultSet.close();
        preparedStatement.close();

        return supermercado;


    }
    
    public void restarStock(LineaCompra lc1) throws SQLException, Excepciones{
        
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("UPDATE stock_supermercado SET cantidad=? "
                + "WHERE codigo_supermercado=? AND codigo_producto=?")) {
            int i=0;
            boolean encontrado=false;
            while(i<this.getStockSupermercado().size() && !encontrado){
                if(this.getStockSupermercado().get(i).getCodigoProducto()==lc1.getCodigo_producto()){
                    if((this.getStockSupermercado().get(i).getCantidad()-lc1.getCantidad())<0){
                        throw new Excepciones(2);
                    }
                    else{
                        query.setInt(1, this.getStockSupermercado().get(i).getCantidad()-lc1.getCantidad());
                        this.getStockSupermercado().get(i).setCantidad(
                        this.getStockSupermercado().get(i).getCantidad()-lc1.getCantidad());
                    }
                    encontrado=true;
                }
                i++;
            }
            query.setInt(2, this.getCode());
            query.setInt(3, lc1.getCodigo_producto());
            query.executeUpdate();
        }

    }
    
    public void devolverStock(int codigoProducto, int cantidad) throws SQLException{
        
        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("UPDATE stock_supermercado SET cantidad=? "
                + "WHERE codigo_supermercado=? AND codigo_producto=?")) {
            int i=0;
            boolean encontrado=false;
            while(i<this.getStockSupermercado().size() && !encontrado){
                if(this.getStockSupermercado().get(i).getCodigoProducto()==codigoProducto){
                        query.setInt(1, this.getStockSupermercado().get(i).getCantidad()+cantidad);
                        this.getStockSupermercado().get(i).setCantidad(
                        this.getStockSupermercado().get(i).getCantidad()+cantidad);
                        encontrado=true;
                }
                i++;
            }
            query.setInt(2, this.getCode());
            query.setInt(3, codigoProducto);
            query.executeUpdate();
        }

    }
    
    public static class addSupermarket {

        private JTextField NIFTextField;
        private JTextField CCAATextField;
        private JTextField localitatTextField;
        private JTextField zipCodeTextField;
        private JTextField addressTextField;
        private JTextField phoneNumberTextField;
        private JTextField emailTextField;
        private JTextField areaTextField;

        private JButton addSupermarketButton;


        public JTextField getNIFTextField() {
            return NIFTextField;
        }

        public JTextField getCCAATextField() {
            return CCAATextField;
        }

        public JTextField getLocalitatTextField() {
            return localitatTextField;
        }

        public JTextField getZipCodeTextField() {
            return zipCodeTextField;
        }

        public JTextField getAddressTextField() {
            return addressTextField;
        }

        public JTextField getPhoneNumberTextField() {
            return phoneNumberTextField;
        }

        public JTextField getEmailTextField() {
            return emailTextField;
        }

        public JTextField getAreaTextField() {
            return areaTextField;
        }

        public addSupermarket() {
            addSupermarketButton.addActionListener(e -> {
                try {
                    insertSupermarketIntoDB();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            });
        }

        private void insertSupermarketIntoDB() throws SQLException {
            Supermercado supermercado = Builder.newInstance()
                                                .code(getLastCode()+1)
                                                .NIF(getNIFTextField().getText())
                                                .CCAA(getCCAATextField().getText())
                                                .localitat(getLocalitatTextField().getText())
                                                .zipCode(getZipCodeTextField().getText())
                                                .address(getAddressTextField().getText())
                                                .phoneNumber(getPhoneNumberTextField().getText())
                                                .email(getEmailTextField().getText())
                                                .area(Integer.parseInt(getAreaTextField().getText()))
                                                .build();

            Connection connection = Herramientas.getConexion();
            PreparedStatement insertSupermarketPreparedStatement = connection.prepareStatement("INSERT INTO SUPERMERCADO VALUES (?, ?, ?, ?, ?, ?, ?, ?. ?)");

            insertSupermarketPreparedStatement.setInt(1, supermercado.code);
            insertSupermarketPreparedStatement.setString(2, supermercado.NIF);
            insertSupermarketPreparedStatement.setString(3, supermercado.CCAA);
            insertSupermarketPreparedStatement.setString(4, supermercado.localitat);
            insertSupermarketPreparedStatement.setString(5, supermercado.zipCode);
            insertSupermarketPreparedStatement.setString(6, supermercado.address);
            insertSupermarketPreparedStatement.setString(7, supermercado.phoneNumber);
            insertSupermarketPreparedStatement.setString(8, supermercado.email);
            insertSupermarketPreparedStatement.setInt(9, supermercado.area);


            insertSupermarketPreparedStatement.executeUpdate();
            insertSupermarketPreparedStatement.close();

        }

        private int getLastCode() throws SQLException {
            Connection connection = Herramientas.getConexion();

            PreparedStatement getCodePreparedStatement = connection.prepareStatement("SELECT MAX(Codigo_supermercado) FROM SUPERMERCADO");
            ResultSet lastCodeValue = getCodePreparedStatement.executeQuery();

            if (lastCodeValue.next()) {
                int codeValue = lastCodeValue.getInt(1);
                getCodePreparedStatement.close();
                lastCodeValue.close();

                return codeValue;
            } else {
                throw new SQLException("Query error, code not found.");
            }

        }

    }

    public class removeSupermarket {

        public removeSupermarketFromDB(int supermarketCode) {
            Connection connection = Herramientas.getConexion();

            PreparedStatement removeSupmerkaretPreparedStatement = null;
            PreparedStatement getEmployeesList = null;
            Boolean autoCommitValue = null;
            Savepoint savepoint = null;

            try {
                autoCommitValue = connection.getAutoCommit();
                connection.setAutoCommit(false);
                savepoint = connection.setSavepoint("Start Removing");

                //Get Employees
                getEmployeesList = connection.prepareStatement("SELECT  ID_EMPLEADO FROM EMPLEADO WHERE Codigo_supermercado = ?");
                getEmployeesList.setInt(1, supermarketCode);
                ResultSet getEmployeesResultSet = getEmployeesList.executeQuery();

                //Delete Empleado and Nominas
                while (getEmployeesResultSet.next()) {
                    Empleado.borrarEmpleadoYNominas(connection, getEmployeesResultSet.getInt(1) ,false);

                }

                //Delete Stock
                StockProducto.deleteStockSupermercado(supermarketCode);

                //Delete Supermarket
                PreparedStatement removeSupermarketPreparedStatement = connection.prepareStatement("DELETE FROM SUPERMERCADO WHERE Codigo_supermercado = ?");

                removeSupermarketPreparedStatement.setInt(1, supermarketCode);
                removeSupermarketPreparedStatement.executeUpdate();

                connection.commit();

            } catch (SQLException sqlException) {
                sqlException.printStackTrace();

                try {
                    connection.rollback(savepoint);

                } catch (SQLException throwables) {
                    throwables.printStackTrace();

                }


            } finally {
                try {
                    removeSupmerkaretPreparedStatement.close();
                    connection.setAutoCommit(autoCommitValue);

                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();

                }

            }



        }
    }

}
