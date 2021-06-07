package Main.Classes;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;


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
    private ArrayList<StockProducto> stockSupermercado;

    public int getCode() {
        return code;
    }

    public ArrayList<StockProducto> getStockSupermercado() {
        return stockSupermercado;
    }

    public String getLocalitat() {
        return localitat;
    }

    public String getNIF() {
        return NIF;
    }

    public String getCCAA() {
        return CCAA;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getArea() {
        return area;
    }
    
    

    @Override
    public String toString() {
        return "Supermercado" + code + '\'' +
                " con NIF " + NIF +
                " en la comunidad autónoma de " + CCAA +
                " y localidad de " + localitat +
                ", con código postal " + zipCode +
                " en " + address +
                ". Con teléfono " + phoneNumber +
                ", email " + email +
                " y área " + area + '.' + '\'' +
                " Su stock es " + stockSupermercado;
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
        private ArrayList<StockProducto> stockSupermercado;

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

        public Builder stockSupermercado(ArrayList<StockProducto> stockSupermercado) {
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


    /**
     * This method is used to write the data from a Supermercado Object into an external .txt file.
     * @param supermercado A Supermercado Object from which to get data and execute toString, in order for the Writer to output its data.
     */
    public static void writeDataToFile(Supermercado supermercado) {
        LocalDateTime localDateTime = LocalDateTime.now();
        File file = new File("SupermarketInfo.txt");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(String.valueOf(localDateTime));
            bufferedWriter.newLine();
            bufferedWriter.write(supermercado.toString());

        } catch (IOException ioException) {
            Herramientas.aviso("Error inesperado al escribir información al archivo de texto de Supermercados!");
            Excepciones.pasarExcepcionLog("Error inesperado al escribir información al archivo de texto de Supermercados!", ioException);
        }

    }

    /**
     * This method grabs all the data the user has manually added in the UI in order to then insert it to the database.
     * @param NIFTextField TextField containing the NIF String.
     * @param CCAATextField TextField containing the CCAA String.
     * @param localitatTextField TextField containing the Localitat String.
     * @param zipCodeTextField TextField containing the Zip Code String
     * @param addressTextField TextField containing the Address String
     * @param phoneNumberTextField TextField containing the Phone Number String.
     * @param emailTextField TextField containing the Email String.
     * @param areaTextField TextField containing the Area Integer.
     * @throws SQLException SQLException from Database's possible errors.
     */
    public static void insertSupermarketIntoDB(JTextField NIFTextField, JTextField CCAATextField, JTextField localitatTextField, JTextField zipCodeTextField,
            JTextField addressTextField, JTextField phoneNumberTextField, JTextField emailTextField, JTextField areaTextField ) throws SQLException {

        
            Supermercado supermercado = Builder.newInstance()
                    .code(getLastCode() + 1)
                    .NIF(NIFTextField.getText())
                    .CCAA(CCAATextField.getText())
                    .localitat(localitatTextField.getText())
                    .zipCode(zipCodeTextField.getText())
                    .address(addressTextField.getText())
                    .phoneNumber(phoneNumberTextField.getText())
                    .email(emailTextField.getText())
                    .area(Integer.parseInt(areaTextField.getText()))
                    .build();

            Connection connection = Herramientas.getConexion();
            PreparedStatement insertSupermarketPreparedStatement = connection.prepareStatement("INSERT INTO SUPERMERCADO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

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
            
            StockProducto.inicializarStock(supermercado.code, connection);
        }

    /**
     * This method selects the highest value for Codigo_supermercado in the database, and returns it as an int.
     * @return Integer containing the highest value to be found in the Database's Codigo_supermercado field.
     * @throws SQLException SQLException from Database's possible errors.
     */
    public static int getLastCode() throws SQLException {
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

    /**
     * This method gets data from Database in order to instantiate a Supermercado Object with its specific data.
     * @param supermarketCode int, used to identify the Supermercado in the database.
     * @return A Supermercado Object, instantiaded with values from the database corresponding to its code.
     * @throws SQLException SQLException from Database's possible errors.
     */
    public static Supermercado instantiateSupermarketFromDB(int supermarketCode) throws SQLException {
        Connection connection = Herramientas.getConexion();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUPERMERCADO WHERE Codigo_Supermercado = ?");
        preparedStatement.setInt(1, supermarketCode);
        ResultSet resultSet = preparedStatement.executeQuery();

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
    
    /**
     * Metodo que sirve para restar del stock de un supermercado una cantidad de un
     * producto concreto. Se le pasa por parametro una lineaCompra, que es una linea
     * compra de un carrito de compra para que el metodo vea cual es el codigo del producto
     * y la cantidad a restar del producto. Actualiza la cantidad tanto en el programa
     * como en la base de datos.
     * @param lc1 lineaCompra del carrito de la que se recoge la informacion
     * @throws SQLException Puede lanzar una SQLException ya que se comunica con la
     * base de datos
     * @throws Excepciones lanza una excepcion si la cantidad que se quiere restar
     * es mayor a la cantidad en stock, para que el stock no se quede en negativo
     */
    public void restarStock(LineaCompra lc1) throws SQLException, Excepciones {

        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("UPDATE stock_supermercado SET cantidad=? "
                + "WHERE codigo_supermercado=? AND codigo_producto=?")) {
            int i = 0;
            boolean encontrado = false;
            while (i < this.getStockSupermercado().size() && !encontrado) {
                if (this.getStockSupermercado().get(i).getCodigoProducto() == lc1.getCodigo_producto()) {
                    if ((this.getStockSupermercado().get(i).getCantidad() - lc1.getCantidad()) < 0) {
                        throw new Excepciones(2);
                    } else {
                        query.setInt(1, this.getStockSupermercado().get(i).getCantidad() - lc1.getCantidad());
                        this.getStockSupermercado().get(i).setCantidad(
                        this.getStockSupermercado().get(i).getCantidad() - lc1.getCantidad());
                    }
                    encontrado = true;
                }
                i++;
            }
            query.setInt(2, this.getCode());
            query.setInt(3, lc1.getCodigo_producto());
            query.executeUpdate();
        }

    }
    /**
     * Metodo que sirve para añadir al stock de un supermercado una cantidad de 
     * un producto concreto. Se pasa por parametro el codigo del producto al cual
     * se le quiere añadir y la cantidad a añadir. El metodo actualiza la cantidad
     * tanto en el programa como en la base de datos.
     * @param codigoProducto int que identifica el producto
     * @param cantidad int cantidad que se sumara al stock de ese producto
     * @throws SQLException Puede lanzar una SQLException ya que se comunica con la
     * base de datos
     */
    public void añadirStock(int codigoProducto, int cantidad) throws SQLException {

        try (PreparedStatement query = Herramientas.getConexion().prepareStatement("UPDATE stock_supermercado SET cantidad=? "
                + "WHERE codigo_supermercado=? AND codigo_producto=?")) {
            int i = 0;
            boolean encontrado = false;
            while (i < this.getStockSupermercado().size() && !encontrado) {
                if (this.getStockSupermercado().get(i).getCodigoProducto() == codigoProducto) {
                    query.setInt(1, this.getStockSupermercado().get(i).getCantidad() + cantidad);
                    this.getStockSupermercado().get(i).setCantidad(
                    this.getStockSupermercado().get(i).getCantidad() + cantidad);
                    encontrado = true;
                }
                i++;
            }
            query.setInt(2, this.getCode());
            query.setInt(3, codigoProducto);
            query.executeUpdate();
        }

    }

    /**
     * This method deletes the information related to the supermarketCode parameter in the database.
     * It also deletes anything that depends on its existence, such as its employees, or their paysheets (Transaction).
     * @param supermarketCode int, used to identify which Supermercado you want to delete.
     */
    public static void removeSupermarketFromDB(int supermarketCode) {
        Connection connection = Herramientas.getConexion();
        Boolean autoCommitValue = null;
        Savepoint savepoint = null;

        try (PreparedStatement removeSupermarketPreparedStatement = connection.prepareStatement("DELETE FROM SUPERMERCADO WHERE Codigo_supermercado = ?");
            PreparedStatement getEmployeesList = connection.prepareStatement("SELECT  ID_EMPLEADO FROM EMPLEADO WHERE Codigo_supermercado = ?")) {
            autoCommitValue = connection.getAutoCommit();
            connection.setAutoCommit(false);
            savepoint = connection.setSavepoint("Start Removing");

            //Get Employees
            getEmployeesList.setInt(1, supermarketCode);
            ResultSet getEmployeesResultSet = getEmployeesList.executeQuery();

            //Delete Empleado and Nominas
            while (getEmployeesResultSet.next()) {
                Empleado.borrarEmpleadoYNominas(connection, getEmployeesResultSet.getInt(1), false);

            }

            //Delete Stock
            StockProducto.deleteStockSupermercado(supermarketCode);

            //Delete Supermarket
            removeSupermarketPreparedStatement.setInt(1, supermarketCode);
            removeSupermarketPreparedStatement.executeUpdate();

            connection.commit();

        } catch (SQLException sqlException) {
            Herramientas.aviso("Se ha producido un error durante la transacción de Eliminar Supermercado!");
            Excepciones.pasarExcepcionLog("Se ha producido un error durante la transacción de Eliminar Supermercado!", sqlException);

            try {
                connection.rollback(savepoint);

            } catch (SQLException sqlException1) {
                Herramientas.aviso("Error inesperado al intentar hacer rollback!");
                Excepciones.pasarExcepcionLog("Error inesperado al intentar hacer rollback!", sqlException1);
            }

        } finally {
            try {
                connection.setAutoCommit(autoCommitValue);

            } catch (SQLException sqlException) {
                Herramientas.aviso("Error inesperado durante la reactivación del AutoCommit!");
                Excepciones.pasarExcepcionLog("Error inesperado durante la reactivación del AutoCommit!", sqlException);

            }

        }
    }

    /**
     * This method is intended to collect some data from the database, and make a String out of it, which then will be saved in the returned ArrayList.
     * Its main function is to populate a JComboBox.
     * @return An ArrayList containing a String for each different entry on the Supermercado Table in the database.
     */
   public static ArrayList<String> getSupermarketsFromDatabase() {
    ArrayList<String> supermarketInfo = new ArrayList<>();

    try (PreparedStatement getSupermarketsPs = Herramientas.getConexion().prepareStatement("SELECT Codigo_supermercado, localidad FROM SUPERMERCADO")) {
        ResultSet getSupermarketsResultSet = getSupermarketsPs.executeQuery();

        while(getSupermarketsResultSet.next()) {
            String value = (getSupermarketsResultSet.getInt(1)) + "- " + getSupermarketsResultSet.getString(2);
            supermarketInfo.add(value);

        }

        getSupermarketsResultSet.close();

        } catch (SQLException sqlException) {
            Herramientas.aviso("Error inesperado al recojer información de los supermercados!");
            Excepciones.pasarExcepcionLog("Error inesperado al recojer información de los supermercados!", sqlException);

        }

    return supermarketInfo;

    }
    
    
}
