/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafics;

import Main.Classes.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author jaume
 */
public class VerTickets extends javax.swing.JFrame {

    /**
     * Creates new form VerTickets
     */
    public VerTickets() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        try{
            ArrayList <Ticket> listaTickets=Ticket.verTicket(Main.getClienteActivo().getNif());
            for(int i=0;i<listaTickets.size();i++){
                this.añadirTicket(listaTickets.get(i), Supermercado.instantiateSupermarketFromDB(listaTickets.get(i).getCodigoSupermercado()));
            }
        } 
        catch(SQLException ex){
            Herramientas.aviso("Ha habido un error al recoger sus tickets de la base de datos");
            Excepciones.pasarExcepcionLog("Ha habido un error al recoger sus tickets de la base de datos", ex);
        }
    }
    
    public Image getIconImage(){
        Image miIcono=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/logo1.png"));
        return miIcono;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelCabezeraTicket = new javax.swing.JPanel();
        labelSupermercado = new javax.swing.JLabel();
        labelNombreSupermercado = new javax.swing.JLabel();
        labelCodigoSupermercado = new javax.swing.JLabel();
        labelNifSupermercado = new javax.swing.JLabel();
        labelCalleSupermercado = new javax.swing.JLabel();
        labelTelefonoSupermercado = new javax.swing.JLabel();
        labelLocalidadSupermercado = new javax.swing.JLabel();
        labelCodigoPostalSupermercado = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        labelHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelLineaTicket = new javax.swing.JPanel();
        labelLineaTicket = new javax.swing.JLabel();
        finalTicket = new javax.swing.JPanel();
        labelImporteTotal = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panelBlanco = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();

        panelCabezeraTicket.setBackground(new java.awt.Color(255, 255, 255));
        panelCabezeraTicket.setMaximumSize(new java.awt.Dimension(398, 155));
        panelCabezeraTicket.setMinimumSize(new java.awt.Dimension(398, 155));
        panelCabezeraTicket.setPreferredSize(new java.awt.Dimension(398, 155));

        labelSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelSupermercado.setText("SUPERMERCADOS METRADONA");

        labelNombreSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelNombreSupermercado.setText("METRADONA BARCELONA");

        labelCodigoSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelCodigoSupermercado.setText("COD 9");

        labelNifSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelNifSupermercado.setText("NIF A11222333");

        labelCalleSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelCalleSupermercado.setText("C/DE LA GENERALITAT, 45");

        labelTelefonoSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelTelefonoSupermercado.setText("TEL. 677999001");

        labelLocalidadSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelLocalidadSupermercado.setText("BARCELONA");

        labelCodigoPostalSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelCodigoPostalSupermercado.setText("08340");

        labelFecha.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelFecha.setText("22/05/2022");

        labelHora.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelHora.setText("14:23");

        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jLabel1.setText("      ARTICULO                   CANTIDAD      IMPORTE EUR");

        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jLabel2.setText("----------------------------------------------------------");

        javax.swing.GroupLayout panelCabezeraTicketLayout = new javax.swing.GroupLayout(panelCabezeraTicket);
        panelCabezeraTicket.setLayout(panelCabezeraTicketLayout);
        panelCabezeraTicketLayout.setHorizontalGroup(
            panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                        .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                                .addComponent(labelSupermercado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCodigoSupermercado))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabezeraTicketLayout.createSequentialGroup()
                                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombreSupermercado)
                                    .addComponent(labelCalleSupermercado)
                                    .addComponent(labelLocalidadSupermercado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTelefonoSupermercado)
                                    .addComponent(labelNifSupermercado)
                                    .addComponent(labelCodigoPostalSupermercado))))
                        .addGap(35, 35, 35))
                    .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                        .addComponent(labelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                        .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelCabezeraTicketLayout.setVerticalGroup(
            panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSupermercado)
                    .addComponent(labelCodigoSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreSupermercado)
                    .addComponent(labelNifSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalleSupermercado)
                    .addComponent(labelTelefonoSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLocalidadSupermercado)
                    .addComponent(labelCodigoPostalSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha)
                    .addComponent(labelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        panelLineaTicket.setBackground(new java.awt.Color(255, 255, 255));
        panelLineaTicket.setMaximumSize(new java.awt.Dimension(398, 16));
        panelLineaTicket.setMinimumSize(new java.awt.Dimension(398, 16));
        panelLineaTicket.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));

        labelLineaTicket.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelLineaTicket.setText("                                                      ");
        panelLineaTicket.add(labelLineaTicket);

        finalTicket.setBackground(new java.awt.Color(255, 255, 255));
        finalTicket.setMaximumSize(new java.awt.Dimension(398, 80));
        finalTicket.setMinimumSize(new java.awt.Dimension(398, 80));
        finalTicket.setPreferredSize(new java.awt.Dimension(398, 80));

        labelImporteTotal.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        labelImporteTotal.setText("TOTAL                                                 ");

        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jLabel4.setText("----------------------------------------------------------");

        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 11)); // NOI18N
        jLabel3.setText("N. REFERENCIA TICKET:                                   ");

        javax.swing.GroupLayout finalTicketLayout = new javax.swing.GroupLayout(finalTicket);
        finalTicket.setLayout(finalTicketLayout);
        finalTicketLayout.setHorizontalGroup(
            finalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(finalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(labelImporteTotal))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        finalTicketLayout.setVerticalGroup(
            finalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImporteTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        panelBlanco.setMaximumSize(new java.awt.Dimension(398, 80));
        panelBlanco.setMinimumSize(new java.awt.Dimension(398, 80));

        javax.swing.GroupLayout panelBlancoLayout = new javax.swing.GroupLayout(panelBlanco);
        panelBlanco.setLayout(panelBlancoLayout);
        panelBlancoLayout.setHorizontalGroup(
            panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        panelBlancoLayout.setVerticalGroup(
            panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("  METRADONA©");
        setIconImage(getIconImage());
        setMaximumSize(new java.awt.Dimension(650, 458));
        setMinimumSize(new java.awt.Dimension(650, 458));
        setResizable(false);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setMaximumSize(new java.awt.Dimension(999999999, 999999999));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(400, 458));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 458));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(999932767, 999932767));
        jPanel1.setMinimumSize(new java.awt.Dimension(398, 456));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void añadirTicket(Ticket ticket, Supermercado supermercado) throws SQLException{
        DateTimeFormatter formatoFecha=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoHora=DateTimeFormatter.ofPattern("HH:mm");
        
        this.añadirCabezeraTicket(supermercado.getLocalitat(), supermercado.getCode(), 
        supermercado.getNIF(), supermercado.getAddress(), supermercado.getPhoneNumber(),
        supermercado.getZipCode(), ticket.getFechaCompra().format(formatoFecha), ticket.getHoraCompra().format(formatoHora));
        for(int i=0;i<ticket.getLineasTicket().size();i++){
            try (PreparedStatement query = Herramientas.getConexion().prepareStatement("SELECT nombre_producto FROM linea_ticket WHERE codigo_producto=?")) {
                query.setInt(1, ticket.getLineasTicket().get(i).getCodigo_producto());
                try (ResultSet resultado = query.executeQuery()) {
                    resultado.next();
                    this.añadirLineaTicket(resultado.getString(1),
                    ticket.getLineasTicket().get(i).getCantidad(), ticket.getLineasTicket().get(i).getPrecio_linea());
                }
            }
        }
        this.añadirFinalTicket(ticket.getCodigo(), ticket.getPrecioTotal());
    }
    
    public void añadirCabezeraTicket(String localidad, int codigo, String NIF, 
    String direccio, String telefono, String codigoPostal, String fecha, String hora){
        
        javax.swing.JPanel panelCabezeraTicket = new javax.swing.JPanel();
        javax.swing.JLabel labelSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelNombreSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelCodigoSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelNifSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelCalleSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelTelefonoSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelLocalidadSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelCodigoPostalSupermercado = new javax.swing.JLabel();
        javax.swing.JLabel labelFecha = new javax.swing.JLabel();
        javax.swing.JLabel labelHora = new javax.swing.JLabel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        
        panelCabezeraTicket.setBackground(new java.awt.Color(255, 255, 255));
        panelCabezeraTicket.setMaximumSize(new java.awt.Dimension(398, 155));
        panelCabezeraTicket.setMinimumSize(new java.awt.Dimension(398, 155));
        panelCabezeraTicket.setPreferredSize(new java.awt.Dimension(398, 155));

        labelSupermercado.setText("SUPERMERCADOS METRADONA");
        labelSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelNombreSupermercado.setText("METRADONA "+localidad.toUpperCase());
        labelNombreSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelCodigoSupermercado.setText("COD "+Integer.toString(codigo).toUpperCase());
        labelCodigoSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelNifSupermercado.setText("NIF "+NIF.toUpperCase());
        labelNifSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelCalleSupermercado.setText(direccio.toUpperCase());
        labelCalleSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelTelefonoSupermercado.setText("TEL. "+telefono.toUpperCase());
        labelTelefonoSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelLocalidadSupermercado.setText(localidad.toUpperCase());
        labelLocalidadSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelCodigoPostalSupermercado.setText(codigoPostal.toUpperCase());
        labelCodigoPostalSupermercado.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelFecha.setText(fecha);
        labelFecha.setFont(new java.awt.Font("Monospaced", 0, 11));

        labelHora.setText(hora);
        labelHora.setFont(new java.awt.Font("Monospaced", 0, 11));

        jLabel1.setText("      ARTICULO                   CANTIDAD      IMPORTE EUR");
        jLabel1.setFont(new java.awt.Font("Monospaced", 0, 11));

        jLabel2.setText("----------------------------------------------------------");
        jLabel2.setFont(new java.awt.Font("Monospaced", 0, 11));

        javax.swing.GroupLayout panelCabezeraTicketLayout = new javax.swing.GroupLayout(panelCabezeraTicket);
        panelCabezeraTicket.setLayout(panelCabezeraTicketLayout);
        panelCabezeraTicketLayout.setHorizontalGroup(
            panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                        .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                                .addComponent(labelSupermercado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelCodigoSupermercado))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCabezeraTicketLayout.createSequentialGroup()
                                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNombreSupermercado)
                                    .addComponent(labelCalleSupermercado)
                                    .addComponent(labelLocalidadSupermercado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTelefonoSupermercado)
                                    .addComponent(labelNifSupermercado)
                                    .addComponent(labelCodigoPostalSupermercado))))
                        .addGap(35, 35, 35))
                    .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                        .addComponent(labelFecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelHora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                        .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        panelCabezeraTicketLayout.setVerticalGroup(
            panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCabezeraTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSupermercado)
                    .addComponent(labelCodigoSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombreSupermercado)
                    .addComponent(labelNifSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCalleSupermercado)
                    .addComponent(labelTelefonoSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLocalidadSupermercado)
                    .addComponent(labelCodigoPostalSupermercado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCabezeraTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelFecha)
                    .addComponent(labelHora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        jPanel1.add(panelCabezeraTicket);
    }
    
    public void añadirLineaTicket(String nombreProducto, int cantidad, double precioLinea){
        javax.swing.JPanel panelLineaTicket = new javax.swing.JPanel();
        javax.swing.JLabel labelLineaTicket = new javax.swing.JLabel();
        
        panelLineaTicket.setBackground(new java.awt.Color(255, 255, 255));
        panelLineaTicket.setMaximumSize(new java.awt.Dimension(398, 16));
        panelLineaTicket.setMinimumSize(new java.awt.Dimension(398, 16));
        panelLineaTicket.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 0));
        
        String cantidadStr=Integer.toString(cantidad);
        String precioLineaStr=Double.toString(precioLinea);
        String linea=""+nombreProducto.toUpperCase();
        for (int i=0;i<38-nombreProducto.length()-cantidadStr.length();i++){
            linea+=" ";
        }
        linea+=cantidadStr;
        for(int i=0;i<16-precioLineaStr.length();i++){
            linea+=" ";
        }
        linea+=precioLineaStr;
        
        labelLineaTicket.setText(linea);
        labelLineaTicket.setFont(new java.awt.Font("Monospaced", 0, 11));
        panelLineaTicket.add(labelLineaTicket);
        

        jPanel1.add(panelLineaTicket);
    }
    
    public void añadirFinalTicket(int codigoTicket, double precioTotal){
        javax.swing.JPanel finalTicket = new javax.swing.JPanel();
        javax.swing.JLabel labelImporteTotal = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JPanel panelBlanco = new javax.swing.JPanel();
        
        finalTicket.setBackground(new java.awt.Color(255, 255, 255));
        finalTicket.setMaximumSize(new java.awt.Dimension(398, 80));
        finalTicket.setMinimumSize(new java.awt.Dimension(398, 80));
        finalTicket.setPreferredSize(new java.awt.Dimension(398, 80));
        
        String lineaTotal="TOTAL                                       ";
        String codigoTicketStr=Integer.toString(codigoTicket);
        String precioTotalStr=Double.toString(precioTotal);
        
        for(int i=0;i<10-precioTotalStr.length();i++){
            lineaTotal+=" ";
        }
        lineaTotal+=precioTotalStr;
        
        labelImporteTotal.setText(lineaTotal);
        labelImporteTotal.setFont(new java.awt.Font("Monospaced", 0, 11));
        
        String lineaCodigoTicket="N. REFERENCIA TICKET:                        ";
        
        for(int i=0;i<11-codigoTicketStr.length();i++){
            lineaCodigoTicket+=" ";
        }
        lineaCodigoTicket+=codigoTicketStr;

        jLabel4.setText("----------------------------------------------------------");
        jLabel4.setFont(new java.awt.Font("Monospaced", 0, 11));

        jLabel3.setText(lineaCodigoTicket);
        jLabel3.setFont(new java.awt.Font("Monospaced", 0, 11));

        javax.swing.GroupLayout finalTicketLayout = new javax.swing.GroupLayout(finalTicket);
        finalTicket.setLayout(finalTicketLayout);
        finalTicketLayout.setHorizontalGroup(
            finalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(finalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImporteTotal)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        finalTicketLayout.setVerticalGroup(
            finalTicketLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(finalTicketLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelImporteTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(20, 20, 20))
        );

        jPanel1.add(finalTicket);

        panelBlanco.setBackground(new java.awt.Color(255, 255, 255));
        panelBlanco.setMaximumSize(new java.awt.Dimension(398, 80));
        panelBlanco.setMinimumSize(new java.awt.Dimension(398, 80));

        javax.swing.GroupLayout panelBlancoLayout = new javax.swing.GroupLayout(panelBlanco);
        panelBlanco.setLayout(panelBlancoLayout);
        panelBlancoLayout.setHorizontalGroup(
            panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        panelBlancoLayout.setVerticalGroup(
            panelBlancoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jPanel1.add(panelBlanco);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel finalTicket;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCalleSupermercado;
    private javax.swing.JLabel labelCodigoPostalSupermercado;
    private javax.swing.JLabel labelCodigoSupermercado;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JLabel labelHora;
    private javax.swing.JLabel labelImporteTotal;
    private javax.swing.JLabel labelLineaTicket;
    private javax.swing.JLabel labelLocalidadSupermercado;
    private javax.swing.JLabel labelNifSupermercado;
    private javax.swing.JLabel labelNombreSupermercado;
    private javax.swing.JLabel labelSupermercado;
    private javax.swing.JLabel labelTelefonoSupermercado;
    private javax.swing.JPanel panelBlanco;
    private javax.swing.JPanel panelCabezeraTicket;
    private javax.swing.JPanel panelLineaTicket;
    // End of variables declaration//GEN-END:variables
}
