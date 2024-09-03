/*
  Dilarang keras menggandakan/mengcopy/menyebarkan/membajak/mendecompile 
  Software ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */

package digitalsignature;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.PreparedStatement;
import java.util.Properties;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import kepegawaian.DlgCariDokter;
import kepegawaian.DlgCariPetugas;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpServerErrorException;

/**
 *
 * @author perpustakaan
 */
public class DlgMappingAkunTTE extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private String link="",URL="",requestJson="",FileName="",NIK;
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private HttpHeaders headers;
    private HttpEntity requestEntity;
    private ObjectMapper mapper = new ObjectMapper();
    private JsonNode root;
    private JsonNode nameNode,code,metadata;
    private JsonNode response;
    private int i;
    private TteApi apiTte=new TteApi();
    private Connection koneksi=koneksiDB.condb();
    private static final Properties prop = new Properties();
//    

    /** Creates new form DlgPemberianObat
     * @param parent
     * @param modal */
    public DlgMappingAkunTTE(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,350);
        
        Object[] row={"Nama","NIK","QrCode"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbListKodeAntrian.setModel(tabMode);
        //tbPenyakit.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbPenyakit.getBackground()));
        tbListKodeAntrian.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbListKodeAntrian.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 3; i++) {
            TableColumn column = tbListKodeAntrian.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(150);
            }else if(i==1){
                column.setPreferredWidth(150);
            }else if(i==2){
                column.setPreferredWidth(200);
            }
        }
        tbListKodeAntrian.setDefaultRenderer(Object.class, new WarnaTable()); 
        
        dlgdokter.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(dlgdokter.getTable().getSelectedRow()!= -1){
                    NIK = Sequel.cariIsi("select no_ktp from pegawai where nik='"+dlgdokter.getTable().getValueAt(dlgdokter.getTable().getSelectedRow(),0).toString()+"'");
                    TNama.setText(dlgdokter.getTable().getValueAt(dlgdokter.getTable().getSelectedRow(),1).toString());
                    TNik.setText(NIK);
                    TQrCode.setText(NIK);
                }  
                TNik.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
        
        dlgpetugas.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(dlgpetugas.getTable().getSelectedRow()!= -1){
                    NIK = Sequel.cariIsi("select no_ktp from pegawai where nik='"+dlgpetugas.getTable().getValueAt(dlgpetugas.getTable().getSelectedRow(),0).toString()+"'");
                    TNama.setText(dlgpetugas.getTable().getValueAt(dlgpetugas.getTable().getSelectedRow(),1).toString());
                    TNik.setText(NIK);
                    TQrCode.setText(NIK);
                }  
                TNik.requestFocus();
            }
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }
    
        
    
        DlgCariDokter dlgdokter=new DlgCariDokter(null,false);
        DlgCariPetugas dlgpetugas=new DlgCariPetugas(null,false);
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        jPanel1 = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jLabel3 = new widget.Label();
        jLabel4 = new widget.Label();
        TQrCode = new widget.TextBox();
        TNik = new widget.TextBox();
        BtnPasien1 = new widget.Button();
        BtnPasien = new widget.Button();
        TNama = new widget.TextBox();
        jLabel5 = new widget.Label();
        intListKodeAntrian = new widget.ScrollPane();
        tbListKodeAntrian = new widget.Table();
        panelGlass8 = new widget.panelisi();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        BtnSimpan = new widget.Button();
        BtnKeluar = new widget.Button();
        BtnDeleteTTE = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "::[ Mapping Akun TTE ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(70, 70, 70))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setPreferredSize(new java.awt.Dimension(875, 200));
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setName("panelInput"); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(490, 120));
        FormInput.setLayout(null);

        jLabel3.setText("Dokter/Petugas");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(0, 12, 100, 23);

        jLabel4.setText("NIK");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 40, 100, 23);

        TQrCode.setHighlighter(null);
        TQrCode.setName("TQrCode"); // NOI18N
        TQrCode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TQrCodeKeyPressed(evt);
            }
        });
        FormInput.add(TQrCode);
        TQrCode.setBounds(110, 70, 370, 23);

        TNik.setHighlighter(null);
        TNik.setName("TNik"); // NOI18N
        TNik.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNikActionPerformed(evt);
            }
        });
        TNik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNikKeyPressed(evt);
            }
        });
        FormInput.add(TNik);
        TNik.setBounds(110, 40, 370, 23);

        BtnPasien1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnPasien1.setMnemonic('1');
        BtnPasien1.setToolTipText("ALt+1");
        BtnPasien1.setName("BtnPasien1"); // NOI18N
        BtnPasien1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPasien1ActionPerformed(evt);
            }
        });
        FormInput.add(BtnPasien1);
        BtnPasien1.setBounds(480, 10, 28, 23);

        BtnPasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnPasien.setMnemonic('1');
        BtnPasien.setToolTipText("ALt+1");
        BtnPasien.setName("BtnPasien"); // NOI18N
        BtnPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPasienActionPerformed(evt);
            }
        });
        FormInput.add(BtnPasien);
        BtnPasien.setBounds(510, 10, 28, 23);

        TNama.setHighlighter(null);
        TNama.setName("TNama"); // NOI18N
        TNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNamaActionPerformed(evt);
            }
        });
        TNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNamaKeyPressed(evt);
            }
        });
        FormInput.add(TNama);
        TNama.setBounds(110, 10, 370, 23);

        jLabel5.setText("QrCode");
        jLabel5.setName("jLabel5"); // NOI18N
        FormInput.add(jLabel5);
        jLabel5.setBounds(0, 70, 100, 23);

        jPanel1.add(FormInput, java.awt.BorderLayout.CENTER);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.PAGE_START);
        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel1.getAccessibleContext().setAccessibleDescription("");

        intListKodeAntrian.setName("intListKodeAntrian"); // NOI18N
        intListKodeAntrian.setOpaque(true);

        tbListKodeAntrian.setAutoCreateRowSorter(true);
        tbListKodeAntrian.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbListKodeAntrian.setName("tbListKodeAntrian"); // NOI18N
        tbListKodeAntrian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListKodeAntrianMouseClicked(evt);
            }
        });
        tbListKodeAntrian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbListKodeAntrianKeyPressed(evt);
            }
        });
        intListKodeAntrian.setViewportView(tbListKodeAntrian);

        internalFrame1.add(intListKodeAntrian, java.awt.BorderLayout.CENTER);
        intListKodeAntrian.getAccessibleContext().setAccessibleName("");

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(100, 56));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(310, 23));
        TCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TCariActionPerformed(evt);
            }
        });
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass8.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('2');
        BtnCari.setToolTipText("Alt+2");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnCari);

        BtnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/save-16x16.png"))); // NOI18N
        BtnSimpan.setMnemonic('S');
        BtnSimpan.setText("Simpan");
        BtnSimpan.setToolTipText("Alt+S");
        BtnSimpan.setName("BtnSimpan"); // NOI18N
        BtnSimpan.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        BtnSimpan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnSimpanKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnSimpan);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnKeluar.setMnemonic('T');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+T");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnKeluar);

        BtnDeleteTTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/delete-16x16.png"))); // NOI18N
        BtnDeleteTTE.setMnemonic('S');
        BtnDeleteTTE.setText("Hapus");
        BtnDeleteTTE.setToolTipText("Alt+S");
        BtnDeleteTTE.setName("BtnDeleteTTE"); // NOI18N
        BtnDeleteTTE.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnDeleteTTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteTTEActionPerformed(evt);
            }
        });
        BtnDeleteTTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnDeleteTTEKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnDeleteTTE);

        internalFrame1.add(panelGlass8, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);
        internalFrame1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            dispose();
        }
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      
    }//GEN-LAST:event_formWindowActivated

    private void tbListKodeAntrianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListKodeAntrianMouseClicked
        getData();
    }//GEN-LAST:event_tbListKodeAntrianMouseClicked

    private void tbListKodeAntrianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbListKodeAntrianKeyPressed
     if(tabMode.getRowCount()!=0){
            if(evt.getKeyCode()==KeyEvent.VK_SPACE){
                dispose();
            }else if(evt.getKeyCode()==KeyEvent.VK_SHIFT){
                
            }
        }
    }//GEN-LAST:event_tbListKodeAntrianKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
         tampil();
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            tampil();
        }else{

        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed

    }//GEN-LAST:event_TCariKeyPressed

    private void TCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TCariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TCariActionPerformed

    private void TQrCodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TQrCodeKeyPressed

    }//GEN-LAST:event_TQrCodeKeyPressed

    private void BtnPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPasienActionPerformed
        dlgpetugas.emptTeks();
        dlgpetugas.isCek();
        //petugas.setModal(true);
        dlgpetugas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dlgpetugas.setLocationRelativeTo(internalFrame1);
        dlgpetugas.setVisible(true);
    }//GEN-LAST:event_BtnPasienActionPerformed

    private void TNikKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNikKeyPressed
        Valid.pindah(evt,TCari,TQrCode);
    }//GEN-LAST:event_TNikKeyPressed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        try {
            link=apiTte.URLTTE();
            URL = link+"postAkunTTE";
            headers= new HttpHeaders();
            System.out.println(URL);
            headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.add("X-Cons-ID",koneksiDB.CONSIDAPIBPJS());
//	    headers.add("X-Timestamp",utc);  
//          headers.add("user_key",koneksiDB.USERKEYAPIBPJS());
//	    utc=String.valueOf(api.GetUTCdatetimeAsString());
//          headers.add("X-Signature",api.getHmac(utc));
            requestJson =" {" +
                            "\"name\":\""+TNama.getText()+"\","+
                            "\"nik\":\""+TNik.getText()+"\","+
                            "\"sign_image\":\""+TQrCode.getText()+"\""+
                        "}" ;
            System.out.println(requestJson);
                requestEntity = new HttpEntity(requestJson,headers);
                root = mapper.readTree(apiTte.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
    //          System.out.println(response.path("policlinics").asText());
                metadata = root.path("metadata");
                response =root.path("response");
    //              System.out.println(response);
    //                System.out.println(response.path("policlinics").asText());
                if(metadata.path("code").asText().equals("200")){
                    TNama.setText("");
                    TNik.setText("");
                    TQrCode.setText(""); 
                 }else if(metadata.path("code").asText().equals("400")){
                     JOptionPane.showMessageDialog(null,metadata.path("message").asText());
                 } 
                tampil();
        }catch (HttpServerErrorException e) {
        // Handle HTTP server error responses
            System.out.println("HTTP Error: " + e.getStatusCode() + " " + e.getStatusText());
            JOptionPane.showMessageDialog(null, "Server Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed

    }//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnPasien1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPasien1ActionPerformed
        // TODO add your handling code here:
        dlgdokter.emptTeks();
        dlgdokter.isCek();
        dlgdokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dlgdokter.setLocationRelativeTo(internalFrame1);
        dlgdokter.setVisible(true);
    }//GEN-LAST:event_BtnPasien1ActionPerformed

    private void TNikActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNikActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNikActionPerformed

    private void TNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNamaActionPerformed

    private void TNamaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNamaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNamaKeyPressed

    private void BtnDeleteTTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteTTEActionPerformed
        // TODO add your handling code here:
                try {
            link=apiTte.URLTTE();
            URL = link+"deleteAkunTTE";
            headers= new HttpHeaders();
            System.out.println(URL);
            headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.add("X-Cons-ID",koneksiDB.CONSIDAPIBPJS());
//	    headers.add("X-Timestamp",utc);  
//          headers.add("user_key",koneksiDB.USERKEYAPIBPJS());
//	    utc=String.valueOf(api.GetUTCdatetimeAsString());
//          headers.add("X-Signature",api.getHmac(utc));
            requestJson ="{" +
                            "\"nik\":\""+TNik.getText()+"\""+
                         "}" ;
            System.out.println(requestJson);
            
	    requestEntity = new HttpEntity(requestJson,headers);
	    root = mapper.readTree(apiTte.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
//          System.out.println(response.path("policlinics").asText());
            metadata = root.path("metadata");
            response =root.path("response");
//              System.out.println(response);
//                System.out.println(response.path("policlinics").asText());
            if(metadata.path("code").asText().equals("200")){
                TNama.setText("");
                TNik.setText("");
                TQrCode.setText(""); 
             }else if(metadata.path("code").asText().equals("400")){
                 JOptionPane.showMessageDialog(null,metadata.path("message").asText());
             } 
            JOptionPane.showMessageDialog(null,metadata.path("message").asText());
            tampil();
        }catch (HttpServerErrorException e) {
        // Handle HTTP server error responses
            System.out.println("HTTP Error: " + e.getStatusCode() + " " + e.getStatusText());
            JOptionPane.showMessageDialog(null, "Server Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e);
        }  
    }//GEN-LAST:event_BtnDeleteTTEActionPerformed

    private void BtnDeleteTTEKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnDeleteTTEKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnDeleteTTEKeyPressed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgMappingAkunTTE dialog = new DlgMappingAkunTTE(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnCari;
    private widget.Button BtnDeleteTTE;
    private widget.Button BtnKeluar;
    private widget.Button BtnPasien;
    private widget.Button BtnPasien1;
    private widget.Button BtnSimpan;
    private widget.PanelBiasa FormInput;
    private widget.TextBox TCari;
    private widget.TextBox TNama;
    private widget.TextBox TNik;
    private widget.TextBox TQrCode;
    private widget.ScrollPane intListKodeAntrian;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel3;
    private widget.Label jLabel4;
    private widget.Label jLabel5;
    private javax.swing.JPanel jPanel1;
    private widget.panelisi panelGlass8;
    private widget.Table tbListKodeAntrian;
    // End of variables declaration//GEN-END:variables
    

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            link=apiTte.URLTTE();
            URL = link+"getAkunTTE";
            headers= new HttpHeaders();
            System.out.println(URL);
            headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.add("X-Cons-ID",koneksiDB.CONSIDAPIBPJS());
//	    headers.add("X-Timestamp",utc);  
//          headers.add("user_key",koneksiDB.USERKEYAPIBPJS());
//	    utc=String.valueOf(api.GetUTCdatetimeAsString());
//          headers.add("X-Signature",api.getHmac(utc));
	    requestEntity = new HttpEntity(requestJson,headers);
	    root = mapper.readTree(apiTte.getRest().exchange(URL, HttpMethod.POST, requestEntity, String.class).getBody());
            metadata = root.path("metadata");
            response =root.path("response");
//              System.out.println(response);
//                System.out.println(response.path("policlinics").asText());
            if(metadata.path("code").asText().equals("200")){
                //  Valid.tabelKosong(tabMode);
                if(response.path("list").isArray()){                    
                    for(JsonNode list:response.path("list")){
                        String name = list.path("name").asText();
                        String nik = list.path("nik").asText();
                        String signImage = list.path("sign_image").asText();
                    
                        // Tambahkan filter pencarian berdasarkan kata kunci di TCari
                        if (TCari.getText().trim().isEmpty() || 
                            name.toLowerCase().contains(TCari.getText().toLowerCase()) || 
                            nik.toLowerCase().contains(TCari.getText().toLowerCase())) {
                            tabMode.addRow(new Object[]{name, nik, signImage});
                        }
                    }  
                }
//              LCountImportDataUmbal.setText(""+tabModeUploadUmbal.getRowCount());
//              LCountSelectedImportUmbal.setText(""+tabModeUploadUmbal.getRowCount());
//              txfile.setText("");   
             }else{
                 
             }   
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    private void getData() {
        i=tbListKodeAntrian.getSelectedRow();
        if(i!= -1){
            TNama.setText(tbListKodeAntrian.getValueAt(i,0).toString());
            TNik.setText(tbListKodeAntrian.getValueAt(i,1).toString());
            TQrCode.setText(tbListKodeAntrian.getValueAt(i,2).toString());            
        }
    }
    
    public JTable getTable(){
        return tbListKodeAntrian;
    }

    public JTable getTable(String FileName){
        return tbListKodeAntrian;
    }

}
