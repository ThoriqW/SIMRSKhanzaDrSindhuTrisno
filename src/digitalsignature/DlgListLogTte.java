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
import java.util.Properties;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

/**
 *
 * @author perpustakaan
 */
public class DlgListLogTte extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private sekuel Sequel=new sekuel();
    private String link="",URL="",requestJson="",FileName="";
    private validasi Valid=new validasi();
    private HttpHeaders headers;
    private HttpEntity requestEntity;
    private ObjectMapper mapper = new ObjectMapper();
    private JsonNode root;
    private JsonNode nameNode,code,metadata;
    private JsonNode response;
    private TteApi apiTte=new TteApi();
    private Connection koneksi=koneksiDB.condb();
    private static final Properties prop = new Properties();
//    

    /** Creates new form DlgPemberianObat
     * @param parent
     * @param modal */
    public DlgListLogTte(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(885,350);
        
        Object[] row={"User","Tgl. Sign","File","Kode","Lokasi File","Status"};
        tabMode=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbListKodeAntrian.setModel(tabMode);
        //tbPenyakit.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbPenyakit.getBackground()));
        tbListKodeAntrian.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbListKodeAntrian.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 5; i++) {
            TableColumn column = tbListKodeAntrian.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(150);
            }else if(i==1){
                column.setPreferredWidth(150);
            }else if(i==2){
                column.setPreferredWidth(300);
            }else if(i==3){
                column.setPreferredWidth(100);
            }else if(i==4){
                column.setPreferredWidth(300);
            }else if(i==5){
                column.setPreferredWidth(100);
            }
        }
        tbListKodeAntrian.setDefaultRenderer(Object.class, new WarnaTable()); 
        
//        tampil();
         
    }

    //private DlgCariObatPenyakit dlgobtpny=new DlgCariObatPenyakit(null,false);
    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        intListKodeAntrian = new widget.ScrollPane();
        tbListKodeAntrian = new widget.Table();
        panelGlass8 = new widget.panelisi();
        label11 = new widget.Label();
        Tgl1 = new widget.Tanggal();
        label18 = new widget.Label();
        Tgl2 = new widget.Tanggal();
        BtnCari = new widget.Button();
        BtnKeluar = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "::[ List Log Signature User ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(70, 70, 70))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setPreferredSize(new java.awt.Dimension(875, 200));
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

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

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(100, 56));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        label11.setText("Periode :");
        label11.setName("label11"); // NOI18N
        label11.setPreferredSize(new java.awt.Dimension(80, 23));
        panelGlass8.add(label11);

        Tgl1.setDisplayFormat("dd-MM-yyyy");
        Tgl1.setName("Tgl1"); // NOI18N
        Tgl1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass8.add(Tgl1);

        label18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label18.setText("s.d.");
        label18.setName("label18"); // NOI18N
        label18.setPreferredSize(new java.awt.Dimension(30, 23));
        panelGlass8.add(label18);

        Tgl2.setDisplayFormat("dd-MM-yyyy");
        Tgl2.setName("Tgl2"); // NOI18N
        Tgl2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass8.add(Tgl2);

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

        internalFrame1.add(panelGlass8, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void berhasilSimpan() {  
   
} 
    
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

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgListLogTte dialog = new DlgListLogTte(new javax.swing.JFrame(), true);
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
    private widget.Button BtnKeluar;
    private widget.Tanggal Tgl1;
    private widget.Tanggal Tgl2;
    private widget.ScrollPane intListKodeAntrian;
    private widget.InternalFrame internalFrame1;
    private widget.Label label11;
    private widget.Label label18;
    private widget.panelisi panelGlass8;
    private widget.Table tbListKodeAntrian;
    // End of variables declaration//GEN-END:variables
    

    private void isPsien() {
//        Sequel.cariIsi("select nm_pasien from pasien where no_rkm_medis=? ",TPasien,TNoRM.getText());
    }
    public void tampil() {
        Valid.tabelKosong(tabMode);
        try {
            link=apiTte.URLTTE();
            URL = link+"signlog";
            System.out.println(URL);
            headers= new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
//	    headers.add("X-Cons-ID",koneksiDB.CONSIDAPIBPJS());
//	    headers.add("X-Timestamp",utc);  
//          headers.add("user_key",koneksiDB.USERKEYAPIBPJS());
//	    utc=String.valueOf(api.GetUTCdatetimeAsString());
//          headers.add("X-Signature",api.getHmac(utc));
            requestJson =" {" +
                "\"start_date\":\""+Valid.SetTgl(Tgl1.getSelectedItem()+"")+"\","+
                "\"last_date\":\""+Valid.SetTgl(Tgl2.getSelectedItem()+"")+"\""+
            "}" ;
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
//                     System.out.println(list.path("kd_poli").asText());
                       tabMode.addRow(new Object[]{
                            list.path("nik").asText(),list.path("tanggal").asText(),list.path("nama_berkas").asText(),list.path("status_code").asText(),list.path("lokasi_file").asText(),list.path("status").asText()
                        }); 
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
//        int b=tabMode.getRowCount();
//        LCount.setText(""+b);
    }
    public JTable getTable(){
        return tbListKodeAntrian;
    }

   public JTable getTable(String FileName){
        return tbListKodeAntrian;
    }
    
    void clicList(String FileName){
       
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        DlgViewPdf berkas=new DlgViewPdf(null,true);
        berkas.tampilPdf2(FileName);
        berkas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        berkas.setLocationRelativeTo(internalFrame1);
        berkas.setVisible(true);
        
        this.setCursor(Cursor.getDefaultCursor());
        
    }

}
