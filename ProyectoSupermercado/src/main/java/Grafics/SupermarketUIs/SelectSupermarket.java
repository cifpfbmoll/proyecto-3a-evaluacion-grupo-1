package Grafics.SupermarketUIs;

import Main.Classes.Supermercado;

import javax.swing.*;
import java.sql.*;

public class SelectSupermarket {
    private JLabel selectSupermarketLabel;
    private JComboBox<ComboItem> selectSupermarketCBox;
    private JButton selectSupermarketButton;
    private JPanel selectSupermarketPanel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("SelectSupermarket");
        frame.setContentPane(new SelectSupermarket().selectSupermarketPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public SelectSupermarket() {
        selectSupermarketButton.addActionListener(e -> {
            Object selection = selectSupermarketCBox.getSelectedItem();

            String info = selection.toString();
            String[] splitInfo = info.split(" ");

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
        });


        selectSupermarketCBox.addActionListener(e -> {
            try {
                retrieveDBData();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        });
    }

    private void retrieveDBData() throws SQLException {
       ResultSet resultSet = getData();

       while (resultSet.next()) {
            int code = resultSet.getInt(1);
            String NIF = resultSet.getString(2);
            String CCAA = resultSet.getString(3);
            String localitat = resultSet.getString(4);
            String zipCode = resultSet.getString(5);
            String address = resultSet.getString(6);
            String phoneNumber = resultSet.getString(7);
            String email = resultSet.getString(8);
            int area = resultSet.getInt(9);


            ComboItem item = new ComboItem(code, NIF, CCAA, localitat, zipCode, address, phoneNumber, email, area);
            selectSupermarketCBox.addItem(item);

       }

        resultSet.close();

    }

    private ResultSet getData() throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://51.178.152.220:3306/metradona", "admin1", "Tomeu21!")) {
            connection.setAutoCommit(connection.getAutoCommit());

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM SUPERMERCADO");
            ResultSet resultSet = preparedStatement.executeQuery();

            preparedStatement.close();
            connection.close();

            return resultSet;

        }
    }

    static class ComboItem {
        public ComboItem(int code, String NIF, String CCAA, String localitat, String zipCode, String address, String phoneNumber, String email, int area) {

        }
    }
}
