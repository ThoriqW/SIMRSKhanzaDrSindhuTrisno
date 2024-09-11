/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package khanzahmsservicemandiri;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.koneksiDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;
import com.jcraft.jsch.*;
import static com.jcraft.jsch.ChannelSftp.SSH_FX_NO_SUCH_FILE;
import fungsi.sekuel;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author windiartonugroho
 */
public class frmUtama extends javax.swing.JFrame {
    private final Connection koneksi=koneksiDB.condb();
    private PreparedStatement ps;
    private ResultSet rs;
    private JSch jsch;
    private Session session;
    private Channel channel;
    private ChannelSftp sftpChannel;
    private String path;
    private Properties config;
    private File file;
    private FileWriter fileWriter;
    private final sekuel Sequel=new sekuel();
    private final SimpleDateFormat formattanggal = new SimpleDateFormat("yyyyMMdd");
    private Date date;
    private final String norekening=Sequel.cariIsi("select set_akun_mandiri.no_rekening from set_akun_mandiri"),kodemcm=Sequel.cariIsi("select set_akun_mandiri.kode_mcm from set_akun_mandiri");
    private Scanner sc;
    private StringBuffer data;
    private String json="";
    private JsonNode root;
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Creates new form frmUtama
     */
    public frmUtama() {
        initComponents();
        
        this.setSize(390,340);
        
        jam();
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
        TeksArea = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SIMKES Khanza Service Bank Mandiri");

        TeksArea.setColumns(20);
        TeksArea.setRows(5);
        jScrollPane1.setViewportView(TeksArea);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TeksArea;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    private void jam(){
        ActionListener taskPerformer = new ActionListener(){
            private int nilai_jam;
            private int nilai_menit;
            private int nilai_detik;
            public void actionPerformed(ActionEvent e) {
                String nol_jam = "";
                String nol_menit = "";
                String nol_detik = "";
                Date now = Calendar.getInstance().getTime();
                // Mengambil nilaj JAM, MENIT, dan DETIK Sekarang
                nilai_jam = now.getHours();
                nilai_menit = now.getMinutes();
                nilai_detik = now.getSeconds();
                // Jika nilai JAM lebih kecil dari 10 (hanya 1 digit)
                if (nilai_jam <= 9) {
                    // Tambahkan "0" didepannya
                    nol_jam = "0";
                }
                // Jika nilai MENIT lebih kecil dari 10 (hanya 1 digit)
                if (nilai_menit <= 9) {
                    // Tambahkan "0" didepannya
                    nol_menit = "0";
                }
                // Jika nilai DETIK lebih kecil dari 10 (hanya 1 digit)
                if (nilai_detik <= 9) {
                    // Tambahkan "0" didepannya
                    nol_detik = "0";
                }
                // Membuat String JAM, MENIT, DETIK
                String jam = nol_jam + Integer.toString(nilai_jam);
                String menit = nol_menit + Integer.toString(nilai_menit);
                String detik = nol_detik + Integer.toString(nilai_detik);
                if(jam.equals("01")&&menit.equals("01")&&detik.equals("01")){
                    TeksArea.setText("");
                }
                
                if(jam.equals("15")&&menit.equals("01")&&detik.equals("01")){
                    try {
                        date = new Date();
                        jsch = new JSch();
                        session = jsch.getSession(koneksiDB.SFTPMANDIRIUSER(),koneksiDB.SFTPMANDIRIHOST(),Integer.parseInt(koneksiDB.SFTPMANDIRIPORT()));
                        config = new Properties();
                        config.put("StrictHostKeyChecking", "no");
                        config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
                        session.setConfig(config);
                        session.setPassword(koneksiDB.SFTPMANDIRIPAS());
                        session.connect();
                        if(session.isConnected()==true){
                            TeksArea.append("Session berhasil terkoneksi\n");
                            session.setTimeout(30000);
                            channel = session.openChannel("sftp");
                            sftpChannel = (ChannelSftp) channel;
                            sftpChannel.connect();
                            if(sftpChannel.isConnected()==true){
                                TeksArea.append("SFTP berhasil terkoneksi\n");
                                TeksArea.append("Memeriksa direktori "+koneksiDB.SFTPMANDIRIPATHMT940()+"\n");
                                sftpChannel.cd(koneksiDB.SFTPMANDIRIPATHMT940());
                                TeksArea.append("Memeriksa file "+norekening+"MT940"+formattanggal.format(date)+"\n");
                                try {
                                    path = sftpChannel.ls(norekening+"MT940"+formattanggal.format(date)).toString();
                                    if (path.contains(norekening+"MT940"+formattanggal.format(date))) {
                                        TeksArea.append("--> File "+norekening+"MT940"+formattanggal.format(date)+" ditemukan, proses menyalin ke lokal\n");
                                        sftpChannel.get(koneksiDB.SFTPMANDIRIPATHMT940()+"/"+norekening+"MT940"+formattanggal.format(date),"./cache");
                                        file=new File("./cache/"+norekening+"MT940"+formattanggal.format(date));
                                        sc = new Scanner(file);  
                                        sc.useDelimiter(":");
                                        data=new StringBuffer();
                                        json="";
                                        while (sc.hasNext()){  
                                            json=sc.nextLine();
                                            if(json.contains(":61:")||json.contains(":86:")){
                                                data.append(json+";");
                                            }
                                        }   
                                        json="{"+data.toString().replaceAll(";:86:","\",\"referensi\":\"").replaceAll(";:61:","\"},{\"transaksi\":\"").replaceAll(":61:","\"transaksi\":\"")+"}";
                                        json="{\"data\":["+json.substring(0,json.length()-2)+"\"}]}";
                                        sc.close();   
                                        TeksArea.append("--> "+json+"\n");
                                        if(!json.equals("")){
                                            root = mapper.readTree(json);
                                            if(root.path("data").isArray()){
                                                for(JsonNode list:root.path("data")){
                                                    if(list.path("transaksi").asText().substring(6,7).equals("D")){
                                                        TeksArea.append("--> Melakukan pemrosesan \"Terkonfirmasi\" transaksi "+kodemcm+list.path("referensi").asText()+"\n");
                                                        Sequel.mengedit3("pembayaran_pihak_ke3_bankmandiri","nomor_pembayaran=?","status_transaksi='Terkonfirmasi'",1,new String[]{
                                                            kodemcm+list.path("referensi").asText()
                                                        });
                                                    }else if(list.path("transaksi").asText().substring(6,7).equals("R")){
                                                        if(list.path("transaksi").asText().substring(7,8).equals("D")){
                                                            TeksArea.append("--> Melakukan pemrosesan \"Pembayaran Gagal\" transaksi "+kodemcm+list.path("referensi").asText()+"\n");
                                                            Sequel.mengedit3("pembayaran_pihak_ke3_bankmandiri","nomor_pembayaran=?","status_transaksi='Pembayaran Gagal'",1,new String[]{
                                                                kodemcm+list.path("referensi").asText()
                                                            });
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        file.delete();
                                    }
                                } catch (SftpException w) {
                                    if (w.id == SSH_FX_NO_SUCH_FILE) {
                                        TeksArea.append("--> File "+norekening+"MT940"+formattanggal.format(date)+" tidak ditemukan\n");
                                    }
                                }
                            }else{
                                TeksArea.append("SFTP gagal terkoneksi\n");
                            }
                            sftpChannel.disconnect();
                        }else{
                            TeksArea.append("Session gagal terkoneksi\n");
                        }
                        session.disconnect();
                    } catch (Exception ex) {
                        System.out.println("Notif 1 : "+ex);
                    }
                }
                
                if(detik.equals("01")&&((nilai_menit%20)==0)){
                    try {
                        ps=koneksi.prepareStatement(
                            "select pembayaran_pihak_ke3_bankmandiri.nomor_pembayaran,pembayaran_pihak_ke3_bankmandiri.tgl_pembayaran,pembayaran_pihak_ke3_bankmandiri.no_rekening_sumber,"+
                            "pembayaran_pihak_ke3_bankmandiri.no_rekening_tujuan,pembayaran_pihak_ke3_bankmandiri.atas_nama_rekening_tujuan,pembayaran_pihak_ke3_bankmandiri.kota_atas_nama_rekening_tujuan,"+
                            "pembayaran_pihak_ke3_bankmandiri.nominal_pembayaran,pembayaran_pihak_ke3_bankmandiri.nomor_tagihan,metode_pembayaran_bankmandiri.nama_metode,bank_tujuan_transfer_bankmandiri.nama_bank,"+
                            "pembayaran_pihak_ke3_bankmandiri.kode_transaksi,pembayaran_pihak_ke3_bankmandiri.asal_transaksi,pembayaran_pihak_ke3_bankmandiri.status_transaksi,pembayaran_pihak_ke3_bankmandiri.kode_metode "+
                            "from pembayaran_pihak_ke3_bankmandiri inner join metode_pembayaran_bankmandiri on metode_pembayaran_bankmandiri.kode_metode=pembayaran_pihak_ke3_bankmandiri.kode_metode "+
                            "inner join bank_tujuan_transfer_bankmandiri on bank_tujuan_transfer_bankmandiri.kode_bank=pembayaran_pihak_ke3_bankmandiri.kode_bank where pembayaran_pihak_ke3_bankmandiri.status_transaksi='Baru'");
                        try {
                            rs=ps.executeQuery();
                            if(rs.next()){
                                jsch = new JSch();
                                session = jsch.getSession(koneksiDB.SFTPMANDIRIUSER(),koneksiDB.SFTPMANDIRIHOST(),Integer.parseInt(koneksiDB.SFTPMANDIRIPORT()));
                                config = new Properties();
                                config.put("StrictHostKeyChecking", "no");
                                config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
                                session.setConfig(config);
                                session.setPassword(koneksiDB.SFTPMANDIRIPAS());
                                session.connect();
                                if(session.isConnected()==true){
                                    TeksArea.append("Session berhasil terkoneksi\n");
                                    session.setTimeout(30000);
                                    channel = session.openChannel("sftp");
                                    sftpChannel = (ChannelSftp) channel;
                                    sftpChannel.connect();
                                    if(sftpChannel.isConnected()==true){
                                        TeksArea.append("SFTP berhasil terkoneksi\n");
                                        TeksArea.append("Memeriksa direktori "+koneksiDB.SFTPMANDIRIPATHPEMBAYARANPIHAKKETIGA()+"\n");
                                        sftpChannel.cd(koneksiDB.SFTPMANDIRIPATHPEMBAYARANPIHAKKETIGA());
                                        rs.beforeFirst();
                                        while(rs.next()){
                                            TeksArea.append("Memeriksa file "+rs.getString("nomor_pembayaran")+"\n");
                                            try {
                                                path = sftpChannel.ls(rs.getString("nomor_pembayaran")+".txt").toString();
                                                if (path.contains(rs.getString("nomor_pembayaran")+".txt")) {
                                                    TeksArea.append("--> File "+rs.getString("nomor_pembayaran")+".txt ditemukan, dilakukan proses validasi transaksi\n");
                                                    try {
                                                        sftpChannel.cd(koneksiDB.SFTPMANDIRIPATHACK());
                                                        path = sftpChannel.ls(rs.getString("nomor_pembayaran")+".txt.ack").toString();
                                                        if (path.contains(rs.getString("nomor_pembayaran")+".txt.ack")) {
                                                            TeksArea.append("--> File "+rs.getString("nomor_pembayaran")+".txt.ack ditemukan, update status data menjadi Menunggu Persetujuan\n");
                                                            Sequel.mengedit3("pembayaran_pihak_ke3_bankmandiri","nomor_pembayaran=?","status_transaksi='Menunggu Persetujuan'",1,new String[]{
                                                                rs.getString("nomor_pembayaran")
                                                            });
                                                        }
                                                    } catch (SftpException z) {
                                                        if (z.id == SSH_FX_NO_SUCH_FILE) {
                                                            try {
                                                                sftpChannel.cd(koneksiDB.SFTPMANDIRIPATHACK());
                                                                path = sftpChannel.ls(rs.getString("nomor_pembayaran")+".txt.nack").toString();
                                                                if (path.contains(rs.getString("nomor_pembayaran")+".txt.nack")) {
                                                                    TeksArea.append("--> File "+rs.getString("nomor_pembayaran")+".txt.nack ditemukan, update status data menjadi Gagal Terkirim\n");
                                                                    Sequel.mengedit3("pembayaran_pihak_ke3_bankmandiri","nomor_pembayaran=?","status_transaksi='Gagal Terkirim'",1,new String[]{
                                                                        rs.getString("nomor_pembayaran")
                                                                    });
                                                                }
                                                            }catch (SftpException w) {
                                                                if (w.id == SSH_FX_NO_SUCH_FILE) {
                                                                    TeksArea.append("--> File "+rs.getString("nomor_pembayaran")+".txt.ack dan "+rs.getString("nomor_pembayaran")+".txt.nack tidak ditemukan, menunggu dari server bank mandiri...\n");
                                                                }
                                                            }
                                                        }
                                                    }
                                                } 
                                            } catch (SftpException x) {
                                                if (x.id == SSH_FX_NO_SUCH_FILE) {
                                                    TeksArea.append("--> File "+rs.getString("nomor_pembayaran")+".txt tidak ditemukan, dilakukan proses generate file\n");
                                                    file=new File("./cache/"+rs.getString("nomor_pembayaran")+".txt");
                                                    file.createNewFile();
                                                    fileWriter = new FileWriter(file);
                                                    fileWriter.write(
                                                        "P;"+rs.getString("tgl_pembayaran").substring(0,10).replaceAll("-","")+";"+rs.getString("no_rekening_sumber")+";1;"+rs.getString("nominal_pembayaran")+"\r\n"+
                                                        rs.getString("no_rekening_tujuan")+";"+rs.getString("atas_nama_rekening_tujuan")+";"+rs.getString("kota_atas_nama_rekening_tujuan")+";;;IDR;"+rs.getString("nominal_pembayaran")+";"+rs.getString("nomor_tagihan")+";"+rs.getString("nomor_pembayaran").replaceAll(kodemcm,"")+";"+rs.getString("kode_metode")+";"+rs.getString("kode_transaksi")+";"+rs.getString("nama_bank")+";;;;;;;;;;;;;;;;;;;;;;;;;;;;;EPD1;"
                                                    );
                                                    fileWriter.flush();
                                                    fileWriter.close();
                                                    TeksArea.append("Proses uploud "+rs.getString("nomor_pembayaran")+".txt ke server tujuan\n");
                                                    sftpChannel.put("./cache/"+rs.getString("nomor_pembayaran")+".txt",koneksiDB.SFTPMANDIRIPATHPEMBAYARANPIHAKKETIGA());
                                                    file.delete();
                                                }
                                            }
                                        }
                                    }else{
                                        TeksArea.append("SFTP gagal terkoneksi\n");
                                    }
                                    sftpChannel.disconnect();
                                }else{
                                    TeksArea.append("Session gagal terkoneksi\n");
                                }
                                session.disconnect();
                            }
                        } catch (Exception ex) {
                            System.out.println("Notif 2 : "+ex);
                        } finally{
                            if(rs!=null){
                                rs.close();
                            }
                            if(ps!=null){
                                ps.close();
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println("Notif 1 : "+ex);
                    }
                }
            }
        };
        // Timer
        new Timer(1000, taskPerformer).start();
    }
}