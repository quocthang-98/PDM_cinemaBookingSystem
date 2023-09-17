package cinemabookingsystem2;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CJFrame2 extends javax.swing.JFrame {

    /**
     * Creates new form CJFrame2
     */
    private String movieName;
    private String[] showTimeList = new String[10];

    private CJFrame frm;
    private String duration;
    
    private String timeStart;
    private String roomName;
    private String showtimeID;
    
    private CJFrame3 room101;
    private CJFrame3 room105;
    private CJFrame3 room203;
    
    public CJFrame2(String movieName, String duration, CJFrame frm) {
        initComponents();
        this.duration = duration;
        this.movieName = movieName;
        this.getContentPane().setBackground(new Color (255, 255, 255));
        
        btnNext.setBackground(Color.decode("#ff5555")); 
        btnNext.setForeground(Color.white);  
        
        btnBack.setToolTipText("Back to previous page");
        
        lblMovieName.setText("Movie: " + movieName);
        
        this.showTimeReset();
        this.showTimes(); 
        
        this.frm = frm;
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jlistshowTimeList = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblMovieName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select Showing Time");
        setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));

        jlistshowTimeList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = showTimeList;
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jlistshowTimeList);

        jLabel2.setFont(new java.awt.Font("UTM Avo", 0, 14)); // NOI18N
        jLabel2.setText("Choose your desired showing time:");

        btnNext.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        lblMovieName.setFont(new java.awt.Font("UTM Avo", 0, 12)); // NOI18N
        lblMovieName.setText("movieName");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNext, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(lblMovieName, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblMovieName)
                .addGap(2, 2, 2)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNext))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        if (jlistshowTimeList.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(null, "You have not selected a showing time.", "Please select a showing time", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        System.out.println(jlistshowTimeList.getSelectedValue());
        
        String[] tokens = jlistshowTimeList.getSelectedValue().split( "  //  " );
        try {
            timeStart = tokens[1];
            roomName = tokens[3];
            showtimeID = tokens[4];
            
            if (tokens[3].equals("Room 105")) {
                room105 = new CJFrame3(this, duration, movieName, timeStart, roomName, showtimeID);
                room105.setVisible(true);
                this.setVisible(false);
            }
            else if (tokens[3].equals("Room 203")) {
                room203 = new CJFrame3(this, duration, movieName, timeStart, roomName, showtimeID);
                room203.setVisible(true);
                this.setVisible(false);
            }
            else if (tokens[3].equals("Room 101")) {
                room101 = new CJFrame3(this, duration, movieName, timeStart, roomName, showtimeID);
                room101.setVisible(true);
                this.setVisible(false);
            }
        }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        } 
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        frm.getContentPane().setBackground(new Color (255, 255, 255));
        frm.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnBackActionPerformed

    
    public void showTimes () {
        String connectionUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=CinemaBookingSystem;user=sa;password=090803;encrypt=false";

        try (Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();) {
            
//          String SQL = txtQuery.getText();
            String searchQuery = "SELECT Movie.movieName, Showtimes.timeStart, Showtimes.timeEnd, Room.roomName, Showtimes.showtimeID FROM Showtimes JOIN Movie ON Movie.movieID = Showtimes.movieID "
                            + "JOIN Room ON Room.roomID = Showtimes.roomID WHERE Movie.movieName = '" + movieName + "'";
            ResultSet rs = stmt.executeQuery(searchQuery);
            
            
            ResultSetMetaData metaData = rs.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            
            int showTimeCount = 0;
            
            while (rs.next()) {
                for (int i = 1; i <= numberOfColumns; i++) {
                    if (i < 4)
                        showTimeList[showTimeCount] = showTimeList[showTimeCount] + rs.getObject(i) + "  //  ";
                    
                    if (i == 4) {
                        showTimeList[showTimeCount] = showTimeList[showTimeCount] + "Room " + rs.getObject(i) + "  //  ";
                    }
                    
                    if (i == 5) {
                        showTimeList[showTimeCount] = showTimeList[showTimeCount] + rs.getObject(i);
                        showTimeCount++;
                    }
                }
            }    
            jlistshowTimeList = new javax.swing.JList<>();

            jlistshowTimeList.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = showTimeList;
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });

            jScrollPane1.setViewportView(jlistshowTimeList);
        }
        catch (SQLException e) {            
        }

    }
    
    public void showTimeReset () {
        for (int i = 0; i < 10; i++) {
            showTimeList[i] = "";
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlistshowTimeList;
    private javax.swing.JLabel lblMovieName;
    // End of variables declaration//GEN-END:variables
}
