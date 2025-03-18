/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package surat;

import digitalsignature.DlgViewPdf;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import fungsi.akses;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import kepegawaian.DlgCariPetugas;


/**
 * 
 * @author windiartohugroho
 */
public final class SuratPernyataanTidakBisaFingerprint extends javax.swing.JDialog {
    private final DefaultTableModel tabMode;
    private Connection koneksi=koneksiDB.condb();
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private PreparedStatement ps;
    private ResultSet rs;
    private int i=0;
    private DlgCariPetugas petugas=new DlgCariPetugas(null,false);
    private String finger="",lokasifile="",namaDokter;
    DlgViewPdf berkas=new DlgViewPdf(null,true);
    
    public SuratPernyataanTidakBisaFingerprint(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocation(8,1);
        setSize(628,674);
//        BtnPrint1.setVisible(false);
        tabMode=new DefaultTableModel(null,new Object[]{
            "No.Pernyataan","No.Rawat","Nama","Tanggal Lahir","Tanggal","Alamat","Umur","Nomor KTP","Nomor BPJS","Diagnosa",
            "Keterangan 1","Keterangan 2","Keterangan 3"
        }){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        tbObat.setModel(tabMode);

        //tbObat.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbObat.getBackground()));
        tbObat.setPreferredScrollableViewportSize(new Dimension(500,500));
        tbObat.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (i = 0; i < 13; i++) {
            TableColumn column = tbObat.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(105);
            }else if(i==1){
                column.setPreferredWidth(105);
            }else if(i==2){
                column.setPreferredWidth(150);
            }else if(i==3){
                column.setPreferredWidth(150);
            }else if(i==4){
                column.setPreferredWidth(150);
            }else if(i==5){
                column.setPreferredWidth(150);
            }else if(i==6){
                column.setPreferredWidth(65);
            }else if(i==7){
                column.setPreferredWidth(150);
            }else if(i==8){
                column.setPreferredWidth(105);
            }else if(i==9){
                column.setPreferredWidth(150);
            }else if(i==10){
                column.setPreferredWidth(150);
            }else if(i==11){
                column.setPreferredWidth(55);
            }else if(i==12){
                column.setPreferredWidth(100);
            }
        }
        tbObat.setDefaultRenderer(Object.class, new WarnaTable());
        
        TNoRw.setDocument(new batasInput((byte)17).getKata(TNoRw));    
        NoSurat.setDocument(new batasInput((byte)20).getKata(NoSurat));
        TCari.setDocument(new batasInput((int)100).getKata(TCari));
        Alamat.setDocument(new batasInput((byte)50).getKata(Alamat));
        NoKTP.setDocument(new batasInput((byte)20).getKata(NoKTP)); 
        UmurPJ.setDocument(new batasInput((byte)3).getKata(UmurPJ));  
        Diagnosa.setDocument(new batasInput((byte)30).getKata(Diagnosa));
        Alamat.setDocument(new batasInput((byte)100).getKata(Alamat));
        NoKTP.setDocument(new batasInput((byte)100).getKata(NoKTP));
        NoBPJS.setDocument(new batasInput((byte)100).getKata(NoBPJS));
        
        if(koneksiDB.CARICEPAT().equals("aktif")){
            TCari.getDocument().addDocumentListener(new javax.swing.event.DocumentListener(){
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void removeUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
                @Override
                public void changedUpdate(DocumentEvent e) {
                    if(TCari.getText().length()>2){
                        tampil();
                    }
                }
            });
        }
    }
    
    
    
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JK = new widget.TextBox();
        Umur = new widget.TextBox();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        MnDigitalTTE = new javax.swing.JMenuItem();
        LaporanSuratPernyataanFingerpritn = new javax.swing.JMenuItem();
        internalFrame1 = new widget.InternalFrame();
        jPanel3 = new javax.swing.JPanel();
        panelGlass8 = new widget.panelisi();
        BtnSimpan = new widget.Button();
        BtnBatal = new widget.Button();
        BtnHapus = new widget.Button();
        BtnEdit = new widget.Button();
        BtnPrint = new widget.Button();
        BtnAll = new widget.Button();
        BtnKeluar = new widget.Button();
        panelGlass9 = new widget.panelisi();
        jLabel19 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel21 = new widget.Label();
        DTPCari2 = new widget.Tanggal();
        jLabel6 = new widget.Label();
        TCari = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel7 = new widget.Label();
        LCount = new widget.Label();
        PanelInput = new javax.swing.JPanel();
        FormInput = new widget.PanelBiasa();
        jLabel4 = new widget.Label();
        TNoRw = new widget.TextBox();
        TPasien = new widget.TextBox();
        TNoRM = new widget.TextBox();
        Alamat = new widget.TextBox();
        jLabel10 = new widget.Label();
        jLabel17 = new widget.Label();
        LahirPasien = new widget.TextBox();
        jLabel16 = new widget.Label();
        jLabel44 = new widget.Label();
        UmurPJ = new widget.TextBox();
        Tanggal = new widget.Tanggal();
        jLabel3 = new widget.Label();
        NoSurat = new widget.TextBox();
        jLabel15 = new widget.Label();
        NoKTP = new widget.TextBox();
        Diagnosa = new widget.TextBox();
        jLabel20 = new widget.Label();
        NoBPJS = new widget.TextBox();
        jLabel11 = new widget.Label();
        jLabel18 = new widget.Label();
        jLabel22 = new widget.Label();
        jLabel23 = new widget.Label();
        scrollPane7 = new widget.ScrollPane();
        text2 = new widget.TextArea();
        scrollPane8 = new widget.ScrollPane();
        text3 = new widget.TextArea();
        scrollPane9 = new widget.ScrollPane();
        text1 = new widget.TextArea();
        ChkInput = new widget.CekBox();
        Scroll = new widget.ScrollPane();
        tbObat = new widget.Table();

        JK.setHighlighter(null);
        JK.setName("JK"); // NOI18N

        Umur.setHighlighter(null);
        Umur.setName("Umur"); // NOI18N

        jPopupMenu1.setName("jPopupMenu1"); // NOI18N

        MnDigitalTTE.setBackground(new java.awt.Color(255, 255, 254));
        MnDigitalTTE.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        MnDigitalTTE.setForeground(new java.awt.Color(50, 50, 50));
        MnDigitalTTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        MnDigitalTTE.setText("Sign Digital Signature");
        MnDigitalTTE.setToolTipText("");
        MnDigitalTTE.setComponentPopupMenu(jPopupMenu1);
        MnDigitalTTE.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MnDigitalTTE.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        MnDigitalTTE.setName("MnDigitalTTE"); // NOI18N
        MnDigitalTTE.setPreferredSize(new java.awt.Dimension(250, 26));
        MnDigitalTTE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnDigitalTTEActionPerformed(evt);
            }
        });
        jPopupMenu1.add(MnDigitalTTE);

        LaporanSuratPernyataanFingerpritn.setBackground(new java.awt.Color(255, 255, 254));
        LaporanSuratPernyataanFingerpritn.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        LaporanSuratPernyataanFingerpritn.setForeground(new java.awt.Color(50, 50, 50));
        LaporanSuratPernyataanFingerpritn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/category.png"))); // NOI18N
        LaporanSuratPernyataanFingerpritn.setText("Laporan Tidak Bisa Fingerprint");
        LaporanSuratPernyataanFingerpritn.setComponentPopupMenu(jPopupMenu1);
        LaporanSuratPernyataanFingerpritn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LaporanSuratPernyataanFingerpritn.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        LaporanSuratPernyataanFingerpritn.setName("LaporanSuratPernyataanFingerpritn"); // NOI18N
        LaporanSuratPernyataanFingerpritn.setPreferredSize(new java.awt.Dimension(250, 26));
        LaporanSuratPernyataanFingerpritn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LaporanSuratPernyataanFingerpritnActionPerformed(evt);
            }
        });
        jPopupMenu1.add(LaporanSuratPernyataanFingerpritn);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Surat Pernyataan Tidak Bisa Fingerprint ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout());

        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(44, 100));
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelGlass8.setName("panelGlass8"); // NOI18N
        panelGlass8.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

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

        BtnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Cancel-2-16x16.png"))); // NOI18N
        BtnBatal.setMnemonic('B');
        BtnBatal.setText("Baru");
        BtnBatal.setToolTipText("Alt+B");
        BtnBatal.setName("BtnBatal"); // NOI18N
        BtnBatal.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });
        BtnBatal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnBatalKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnBatal);

        BtnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/stop_f2.png"))); // NOI18N
        BtnHapus.setMnemonic('H');
        BtnHapus.setText("Hapus");
        BtnHapus.setToolTipText("Alt+H");
        BtnHapus.setName("BtnHapus"); // NOI18N
        BtnHapus.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });
        BtnHapus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnHapusKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnHapus);

        BtnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/inventaris.png"))); // NOI18N
        BtnEdit.setMnemonic('G');
        BtnEdit.setText("Ganti");
        BtnEdit.setToolTipText("Alt+G");
        BtnEdit.setName("BtnEdit"); // NOI18N
        BtnEdit.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        BtnEdit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnEditKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnEdit);

        BtnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/b_print.png"))); // NOI18N
        BtnPrint.setMnemonic('T');
        BtnPrint.setText("Cetak");
        BtnPrint.setToolTipText("Alt+T");
        BtnPrint.setName("BtnPrint"); // NOI18N
        BtnPrint.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPrintActionPerformed(evt);
            }
        });
        BtnPrint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnPrintKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnPrint);

        BtnAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Search-16x16.png"))); // NOI18N
        BtnAll.setMnemonic('M');
        BtnAll.setText("Semua");
        BtnAll.setToolTipText("Alt+M");
        BtnAll.setName("BtnAll"); // NOI18N
        BtnAll.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAllActionPerformed(evt);
            }
        });
        BtnAll.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnAllKeyPressed(evt);
            }
        });
        panelGlass8.add(BtnAll);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
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

        jPanel3.add(panelGlass8, java.awt.BorderLayout.CENTER);

        panelGlass9.setName("panelGlass9"); // NOI18N
        panelGlass9.setPreferredSize(new java.awt.Dimension(44, 44));
        panelGlass9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel19.setText("Tanggal :");
        jLabel19.setName("jLabel19"); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(57, 23));
        panelGlass9.add(jLabel19);

        DTPCari1.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "13-02-2025" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari1);

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("s.d.");
        jLabel21.setName("jLabel21"); // NOI18N
        jLabel21.setPreferredSize(new java.awt.Dimension(23, 23));
        panelGlass9.add(jLabel21);

        DTPCari2.setForeground(new java.awt.Color(50, 70, 50));
        DTPCari2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "13-02-2025" }));
        DTPCari2.setDisplayFormat("dd-MM-yyyy");
        DTPCari2.setName("DTPCari2"); // NOI18N
        DTPCari2.setOpaque(false);
        DTPCari2.setPreferredSize(new java.awt.Dimension(90, 23));
        panelGlass9.add(DTPCari2);

        jLabel6.setText("Key Word :");
        jLabel6.setName("jLabel6"); // NOI18N
        jLabel6.setPreferredSize(new java.awt.Dimension(70, 23));
        panelGlass9.add(jLabel6);

        TCari.setName("TCari"); // NOI18N
        TCari.setPreferredSize(new java.awt.Dimension(215, 23));
        TCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TCariKeyPressed(evt);
            }
        });
        panelGlass9.add(TCari);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('3');
        BtnCari.setToolTipText("Alt+3");
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
        panelGlass9.add(BtnCari);

        jLabel7.setText("Record :");
        jLabel7.setName("jLabel7"); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(65, 23));
        panelGlass9.add(jLabel7);

        LCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LCount.setText("0");
        LCount.setName("LCount"); // NOI18N
        LCount.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass9.add(LCount);

        jPanel3.add(panelGlass9, java.awt.BorderLayout.PAGE_START);

        internalFrame1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        PanelInput.setName("PanelInput"); // NOI18N
        PanelInput.setOpaque(false);
        PanelInput.setPreferredSize(new java.awt.Dimension(192, 275));
        PanelInput.setLayout(new java.awt.BorderLayout(1, 1));

        FormInput.setName("FormInput"); // NOI18N
        FormInput.setPreferredSize(new java.awt.Dimension(100, 275));
        FormInput.setLayout(null);

        jLabel4.setText("No.Rawat :");
        jLabel4.setName("jLabel4"); // NOI18N
        FormInput.add(jLabel4);
        jLabel4.setBounds(0, 10, 70, 23);

        TNoRw.setHighlighter(null);
        TNoRw.setName("TNoRw"); // NOI18N
        TNoRw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRwKeyPressed(evt);
            }
        });
        FormInput.add(TNoRw);
        TNoRw.setBounds(74, 10, 136, 23);

        TPasien.setEditable(false);
        TPasien.setHighlighter(null);
        TPasien.setName("TPasien"); // NOI18N
        TPasien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TPasienKeyPressed(evt);
            }
        });
        FormInput.add(TPasien);
        TPasien.setBounds(325, 10, 255, 23);

        TNoRM.setEditable(false);
        TNoRM.setHighlighter(null);
        TNoRM.setName("TNoRM"); // NOI18N
        TNoRM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TNoRMKeyPressed(evt);
            }
        });
        FormInput.add(TNoRM);
        TNoRM.setBounds(212, 10, 111, 23);

        Alamat.setName("Alamat"); // NOI18N
        Alamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                AlamatKeyPressed(evt);
            }
        });
        FormInput.add(Alamat);
        Alamat.setBounds(430, 40, 150, 23);

        jLabel10.setText("Nomor BPJS :");
        jLabel10.setName("jLabel10"); // NOI18N
        FormInput.add(jLabel10);
        jLabel10.setBounds(250, 70, 70, 23);

        jLabel17.setText("Tgl.Lahir :");
        jLabel17.setName("jLabel17"); // NOI18N
        FormInput.add(jLabel17);
        jLabel17.setBounds(584, 10, 60, 23);

        LahirPasien.setHighlighter(null);
        LahirPasien.setName("LahirPasien"); // NOI18N
        FormInput.add(LahirPasien);
        LahirPasien.setBounds(648, 10, 85, 23);

        jLabel16.setText("Tanggal :");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setVerifyInputWhenFocusTarget(false);
        FormInput.add(jLabel16);
        jLabel16.setBounds(0, 40, 70, 23);

        jLabel44.setText("Umur (Tahun) :");
        jLabel44.setName("jLabel44"); // NOI18N
        FormInput.add(jLabel44);
        jLabel44.setBounds(580, 40, 80, 23);

        UmurPJ.setName("UmurPJ"); // NOI18N
        UmurPJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UmurPJActionPerformed(evt);
            }
        });
        UmurPJ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                UmurPJKeyPressed(evt);
            }
        });
        FormInput.add(UmurPJ);
        UmurPJ.setBounds(660, 40, 70, 23);

        Tanggal.setForeground(new java.awt.Color(50, 70, 50));
        Tanggal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "13-02-2025" }));
        Tanggal.setDisplayFormat("dd-MM-yyyy");
        Tanggal.setName("Tanggal"); // NOI18N
        Tanggal.setOpaque(false);
        Tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TanggalKeyPressed(evt);
            }
        });
        FormInput.add(Tanggal);
        Tanggal.setBounds(74, 40, 90, 23);

        jLabel3.setText("No.Pernyataan :");
        jLabel3.setName("jLabel3"); // NOI18N
        FormInput.add(jLabel3);
        jLabel3.setBounds(170, 40, 90, 23);

        NoSurat.setHighlighter(null);
        NoSurat.setName("NoSurat"); // NOI18N
        NoSurat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoSuratActionPerformed(evt);
            }
        });
        NoSurat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoSuratKeyPressed(evt);
            }
        });
        FormInput.add(NoSurat);
        NoSurat.setBounds(260, 40, 119, 23);

        jLabel15.setText("KET 1 :");
        jLabel15.setName("jLabel15"); // NOI18N
        FormInput.add(jLabel15);
        jLabel15.setBounds(0, 110, 70, 23);

        NoKTP.setName("NoKTP"); // NOI18N
        NoKTP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoKTPKeyPressed(evt);
            }
        });
        FormInput.add(NoKTP);
        NoKTP.setBounds(80, 70, 170, 23);

        Diagnosa.setName("Diagnosa"); // NOI18N
        Diagnosa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DiagnosaKeyPressed(evt);
            }
        });
        FormInput.add(Diagnosa);
        Diagnosa.setBounds(540, 70, 190, 23);

        jLabel20.setText("Diagnosa :");
        jLabel20.setName("jLabel20"); // NOI18N
        FormInput.add(jLabel20);
        jLabel20.setBounds(470, 70, 60, 23);

        NoBPJS.setName("NoBPJS"); // NOI18N
        NoBPJS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoBPJSActionPerformed(evt);
            }
        });
        NoBPJS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                NoBPJSKeyPressed(evt);
            }
        });
        FormInput.add(NoBPJS);
        NoBPJS.setBounds(320, 70, 150, 23);

        jLabel11.setText("Alamat :");
        jLabel11.setName("jLabel11"); // NOI18N
        FormInput.add(jLabel11);
        jLabel11.setBounds(380, 40, 50, 23);

        jLabel18.setText("Nomor KTP :");
        jLabel18.setName("jLabel18"); // NOI18N
        FormInput.add(jLabel18);
        jLabel18.setBounds(0, 70, 70, 23);

        jLabel22.setText("KET 2 :");
        jLabel22.setName("jLabel22"); // NOI18N
        FormInput.add(jLabel22);
        jLabel22.setBounds(370, 110, 50, 23);

        jLabel23.setText("KET 3 :");
        jLabel23.setName("jLabel23"); // NOI18N
        FormInput.add(jLabel23);
        jLabel23.setBounds(0, 180, 70, 23);

        scrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane7.setName("scrollPane7"); // NOI18N

        text2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        text2.setColumns(20);
        text2.setRows(5);
        text2.setName("text2"); // NOI18N
        text2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text2KeyPressed(evt);
            }
        });
        scrollPane7.setViewportView(text2);

        FormInput.add(scrollPane7);
        scrollPane7.setBounds(430, 110, 290, 50);

        scrollPane8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane8.setName("scrollPane8"); // NOI18N

        text3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        text3.setColumns(20);
        text3.setRows(5);
        text3.setName("text3"); // NOI18N
        text3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text3KeyPressed(evt);
            }
        });
        scrollPane8.setViewportView(text3);

        FormInput.add(scrollPane8);
        scrollPane8.setBounds(80, 180, 640, 50);

        scrollPane9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scrollPane9.setName("scrollPane9"); // NOI18N

        text1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        text1.setColumns(20);
        text1.setRows(5);
        text1.setName("text1"); // NOI18N
        text1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                text1KeyPressed(evt);
            }
        });
        scrollPane9.setViewportView(text1);

        FormInput.add(scrollPane9);
        scrollPane9.setBounds(80, 110, 290, 50);

        PanelInput.add(FormInput, java.awt.BorderLayout.CENTER);
        FormInput.getAccessibleContext().setAccessibleName("");

        ChkInput.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setMnemonic('I');
        ChkInput.setText(".: Input Data");
        ChkInput.setToolTipText("Alt+I");
        ChkInput.setBorderPainted(true);
        ChkInput.setBorderPaintedFlat(true);
        ChkInput.setFocusable(false);
        ChkInput.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ChkInput.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ChkInput.setName("ChkInput"); // NOI18N
        ChkInput.setPreferredSize(new java.awt.Dimension(192, 20));
        ChkInput.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/143.png"))); // NOI18N
        ChkInput.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/145.png"))); // NOI18N
        ChkInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChkInputActionPerformed(evt);
            }
        });
        PanelInput.add(ChkInput, java.awt.BorderLayout.PAGE_END);

        internalFrame1.add(PanelInput, java.awt.BorderLayout.PAGE_START);

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);
        Scroll.setPreferredSize(new java.awt.Dimension(452, 200));

        tbObat.setAutoCreateRowSorter(true);
        tbObat.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        tbObat.setComponentPopupMenu(jPopupMenu1);
        tbObat.setName("tbObat"); // NOI18N
        tbObat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbObatMouseClicked(evt);
            }
        });
        tbObat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbObatKeyReleased(evt);
            }
        });
        Scroll.setViewportView(tbObat);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);
        internalFrame1.getAccessibleContext().setAccessibleName("::[ Surat Pernyataan Tidak Bisa Fingerprint ]::");
        internalFrame1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"Pasien");
        }else if(Alamat.getText().trim().equals("")){
            Valid.textKosong(Alamat,"Nama Penanggung Jawab");
        }else if(UmurPJ.getText().trim().equals("")){
            Valid.textKosong(UmurPJ,"Umur");
        }else if(Diagnosa.getText().trim().equals("")){
            Valid.textKosong(Diagnosa,"Nomor Telp");
        }else if(NoKTP.getText().trim().equals("")){
            Valid.textKosong(NoKTP,"Nomor KTP");
        }else if(NoSurat.getText().trim().equals("")){
            Valid.textKosong(NoSurat,"No.Pernyataan");
        }else{
             if(Sequel.menyimpantf("surat_pernyataan_fingerprint","?,?,?,?,?,?,?,?,?,?,?,?,?","Data",13,new String[]{
                    NoSurat.getText(),TNoRw.getText(),TPasien.getText(),LahirPasien.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+""),Alamat.getText(),UmurPJ.getText(),NoKTP.getText(),
                    NoBPJS.getText(),Diagnosa.getText(),text1.getText(),text2.getText(),text3.getText()
                })==true){
                tabMode.addRow(new String[]{
                    NoSurat.getText(),TNoRw.getText(),TPasien.getText(),LahirPasien.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+""),Alamat.getText(),UmurPJ.getText(),
                    NoKTP.getText(), NoBPJS.getText(),Diagnosa.getText(),text2.getText(),text3.getText(),text1.getText()
                });
                LCount.setText(""+tabMode.getRowCount());
                emptTeks();
            }
        }
}//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnSimpanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnSimpanActionPerformed(null);
        }
}//GEN-LAST:event_BtnSimpanKeyPressed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        emptTeks();
        ChkInput.setSelected(true);
        isForm();  
}//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnBatalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnBatalKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            emptTeks();
        }else{Valid.pindah(evt, BtnSimpan, BtnHapus);}
}//GEN-LAST:event_BtnBatalKeyPressed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        if(tbObat.getSelectedRow()>-1){
            if(akses.getkode().equals("Admin Utama")){
                hapus();
            }else{
                hapus();  
            }
        }else{
            JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
        }   

}//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnHapusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnHapusKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnHapusActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnBatal, BtnEdit);
        }
}//GEN-LAST:event_BtnHapusKeyPressed

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        if(TNoRw.getText().trim().equals("")||TPasien.getText().trim().equals("")){
            Valid.textKosong(TNoRw,"Pasien");
        }else if(Alamat.getText().trim().equals("")){
            Valid.textKosong(Alamat,"Nama Penanggung Jawab");
        }else if(UmurPJ.getText().trim().equals("")){
            Valid.textKosong(UmurPJ,"Umur");
        }else if(Diagnosa.getText().trim().equals("")){
            Valid.textKosong(Diagnosa,"Nomor Telp");
        }else if(NoKTP.getText().trim().equals("")){
            Valid.textKosong(NoKTP,"Nomor KTP");
        }else if(NoSurat.getText().trim().equals("")){
            Valid.textKosong(NoSurat,"No.Pernyataan");
        }else{
            if(tbObat.getSelectedRow()>-1){
                ganti();
            }else{
                JOptionPane.showMessageDialog(rootPane,"Silahkan anda pilih data terlebih dahulu..!!");
            }
        }
}//GEN-LAST:event_BtnEditActionPerformed

    private void BtnEditKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnEditKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnEditActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnHapus, BtnPrint);
        }
}//GEN-LAST:event_BtnEditKeyPressed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        petugas.dispose();
        dispose();
}//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnKeluarActionPerformed(null);
        }else{Valid.pindah(evt,BtnEdit,TCari);}
}//GEN-LAST:event_BtnKeluarKeyPressed

    private void BtnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPrintActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if(tabMode.getRowCount()==0){
            JOptionPane.showMessageDialog(null,"Maaf, data sudah habis. Tidak ada data yang bisa anda print...!!!!");
            BtnBatal.requestFocus();
        }else if(tabMode.getRowCount()!=0){
            Map<String, Object> param = new HashMap<>(); 
            param.put("namars",akses.getnamars());
            param.put("alamatrs",akses.getalamatrs());
            param.put("kotars",akses.getkabupatenrs());
            param.put("propinsirs",akses.getpropinsirs());
            param.put("kontakrs",akses.getkontakrs());
            param.put("emailrs",akses.getemailrs());   
            param.put("logo",Sequel.cariGambar("select setting.logo from setting")); 
            
            if(TCari.getText().trim().equals("")){
                Valid.MyReportqry("rptDataPersetujuanUmum.jasper","report","::[ Data Persetujuan Umum ]::",
                    "select surat_persetujuan_umum.no_surat,reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,reg_periksa.umurdaftar,"+
                    "reg_periksa.sttsumur,pasien.jk,pasien.tgl_lahir,surat_persetujuan_umum.tanggal,surat_persetujuan_umum.pengobatan_kepada,"+
                    "surat_persetujuan_umum.nilai_kepercayaan,surat_persetujuan_umum.nama_pj,surat_persetujuan_umum.umur_pj,surat_persetujuan_umum.no_ktppj,"+
                    "surat_persetujuan_umum.jkpj,surat_persetujuan_umum.bertindak_atas,surat_persetujuan_umum.no_telp,surat_persetujuan_umum.nip,"+
                    "petugas.nama from surat_persetujuan_umum inner join reg_periksa on surat_persetujuan_umum.no_rawat=reg_periksa.no_rawat "+
                    "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                    "inner join petugas on surat_persetujuan_umum.nip=petugas.nip where "+
                    "surat_persetujuan_umum.tanggal between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+"' order by surat_persetujuan_umum.tanggal",param);
            }else{
                Valid.MyReportqry("rptDataPersetujuanUmum.jasper","report","::[ Data Persetujuan Umum ]::",
                    "select surat_persetujuan_umum.no_surat,reg_periksa.no_rawat,pasien.no_rkm_medis,pasien.nm_pasien,reg_periksa.umurdaftar,"+
                    "reg_periksa.sttsumur,pasien.jk,pasien.tgl_lahir,surat_persetujuan_umum.tanggal,surat_persetujuan_umum.pengobatan_kepada,"+
                    "surat_persetujuan_umum.nilai_kepercayaan,surat_persetujuan_umum.nama_pj,surat_persetujuan_umum.umur_pj,surat_persetujuan_umum.no_ktppj,"+
                    "surat_persetujuan_umum.jkpj,surat_persetujuan_umum.bertindak_atas,surat_persetujuan_umum.no_telp,surat_persetujuan_umum.nip,"+
                    "petugas.nama from surat_persetujuan_umum inner join reg_periksa on surat_persetujuan_umum.no_rawat=reg_periksa.no_rawat "+
                    "inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                    "inner join petugas on surat_persetujuan_umum.nip=petugas.nip where "+
                    "surat_persetujuan_umum.tanggal between '"+Valid.SetTgl(DTPCari1.getSelectedItem()+"")+"' and '"+Valid.SetTgl(DTPCari2.getSelectedItem()+"")+"' and "+
                    "(reg_periksa.no_rawat like '%"+TCari.getText().trim()+"%' or pasien.no_rkm_medis like '%"+TCari.getText().trim()+"%' or pasien.nm_pasien like '%"+TCari.getText().trim()+"%' or "+
                    "surat_persetujuan_umum.no_telp like '%"+TCari.getText().trim()+"%' or surat_persetujuan_umum.nama_pj like '%"+TCari.getText().trim()+"%' or "+
                    "surat_persetujuan_umum.nip like '%"+TCari.getText().trim()+"%' or petugas.nama like '%"+TCari.getText().trim()+"%') "+
                    "order by surat_persetujuan_umum.tanggal",param);
            }  
        }
        this.setCursor(Cursor.getDefaultCursor());
}//GEN-LAST:event_BtnPrintActionPerformed

    private void BtnPrintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnPrintKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnPrintActionPerformed(null);
        }else{
            Valid.pindah(evt, BtnEdit, BtnKeluar);
        }
}//GEN-LAST:event_BtnPrintKeyPressed

    private void TCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            BtnCariActionPerformed(null);
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            BtnCari.requestFocus();
        }else if(evt.getKeyCode()==KeyEvent.VK_PAGE_UP){
            BtnKeluar.requestFocus();
        }
}//GEN-LAST:event_TCariKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        tampil();
}//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            BtnCariActionPerformed(null);
        }else{
            Valid.pindah(evt, TCari, BtnAll);
        }
}//GEN-LAST:event_BtnCariKeyPressed

    private void BtnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAllActionPerformed
        TCari.setText("");
        tampil();
}//GEN-LAST:event_BtnAllActionPerformed

    private void BtnAllKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnAllKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_SPACE){
            tampil();
            TCari.setText("");
        }else{
            Valid.pindah(evt, BtnCari, TPasien);
        }
}//GEN-LAST:event_BtnAllKeyPressed
   
                                  
    private void ChkInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChkInputActionPerformed
       isForm();
    }//GEN-LAST:event_ChkInputActionPerformed

    private void NoBPJSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoBPJSKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoBPJSKeyPressed

    private void NoBPJSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoBPJSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoBPJSActionPerformed

    private void DiagnosaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DiagnosaKeyPressed

    }//GEN-LAST:event_DiagnosaKeyPressed

    private void NoKTPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoKTPKeyPressed

    }//GEN-LAST:event_NoKTPKeyPressed

    private void NoSuratKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoSuratKeyPressed

    }//GEN-LAST:event_NoSuratKeyPressed

    private void NoSuratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoSuratActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NoSuratActionPerformed

    private void TanggalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TanggalKeyPressed
        Valid.pindah2(evt,TCari,NoSurat);
    }//GEN-LAST:event_TanggalKeyPressed

    private void UmurPJKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_UmurPJKeyPressed

    }//GEN-LAST:event_UmurPJKeyPressed

    private void UmurPJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UmurPJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UmurPJActionPerformed

    private void AlamatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AlamatKeyPressed
        Valid.pindah(evt,NoSurat,UmurPJ);
    }//GEN-LAST:event_AlamatKeyPressed

    private void TNoRMKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRMKeyPressed
        // Valid.pindah(evt, TNm, BtnSimpan);
    }//GEN-LAST:event_TNoRMKeyPressed

    private void TPasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TPasienKeyPressed
        Valid.pindah(evt,TCari,BtnSimpan);
    }//GEN-LAST:event_TPasienKeyPressed

    private void TNoRwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TNoRwKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_PAGE_DOWN){
            isRawat();
        }else{
            Valid.pindah(evt,TCari,Tanggal);
        }
    }//GEN-LAST:event_TNoRwKeyPressed

    private void text2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text2KeyPressed

    }//GEN-LAST:event_text2KeyPressed

    private void text3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_text3KeyPressed

    private void text1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_text1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_text1KeyPressed

    private void tbObatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbObatMouseClicked
        if(tabMode.getRowCount()!=0){
            try {
                getData();
            } catch (java.lang.NullPointerException e) {
            }
            try {
            } catch (java.lang.NullPointerException e) {
            }
        }
    }//GEN-LAST:event_tbObatMouseClicked

    private void tbObatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbObatKeyReleased
        if(tabMode.getRowCount()!=0){
            if((evt.getKeyCode()==KeyEvent.VK_ENTER)||(evt.getKeyCode()==KeyEvent.VK_UP)||(evt.getKeyCode()==KeyEvent.VK_DOWN)){
                try {
                    getData();
                } catch (java.lang.NullPointerException e) {
                }
            }
        }
    }//GEN-LAST:event_tbObatKeyReleased

    private void MnDigitalTTEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnDigitalTTEActionPerformed
        // TODO add your handling code here:
        if(tbObat.getSelectedRow()>-1){
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            String FileName =tbObat.getValueAt(tbObat.getSelectedRow(),0).toString().replaceAll("/","_") + ".pdf";
            if(Sequel.cariInteger("select count(no_rawat) from berkas_tte where no_dokumen='"+FileName+"' and kode='043'") > 0){
                berkas.tampilPdf(FileName,"berkastte/surat_pernyataan_fingerprint",tbObat.getValueAt(tbObat.getSelectedRow(),0).toString(),"043");
                berkas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
                berkas.setLocationRelativeTo(internalFrame1);
                berkas.setVisible(true);
            }else{
                createPdf(FileName);
            }

            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_MnDigitalTTEActionPerformed

    private void LaporanSuratPernyataanFingerpritnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LaporanSuratPernyataanFingerpritnActionPerformed
        // TODO add your handling code here:
        if(tbObat.getSelectedRow()>-1){
                if ("Admin Utama".equals(akses.getkode())){
                    namaDokter=akses.getkode();
                }else{
                    namaDokter=Sequel.cariIsi("select nama from pegawai where nik=?",akses.getkode());
                }
                Map<String, Object> param = new HashMap<>();
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());
                param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
                param.put("logobsre",Sequel.cariGambar("select setting.logo_bsre from setting"));
                param.put("nm_dokter",namaDokter);
            param.put("finger","Dikeluarkan di "+akses.getnamars()+", Kabupaten/Kota "+akses.getkabupatenrs()+"\nDitandatangani secara elektronik oleh "+namaDokter); 
                Valid.MyReportqry("rptSuratFingerprintKhanza.jasper","report","::[ Surat Pernyataan Fingerprint ]::",
                    "select nama, no_ktp, no_bpjs, umur, diagnosa, alamat, ket1, ket2, ket3, tanggal from surat_pernyataan_fingerprint where no_pernyataan='"+tbObat.getValueAt(tbObat.getSelectedRow(),0).toString()+"'",param);
            
        }else{
            JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih data terlebih dahulu..!!!!");
        }
    }//GEN-LAST:event_LaporanSuratPernyataanFingerpritnActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            SuratPernyataanTidakBisaFingerprint dialog = new SuratPernyataanTidakBisaFingerprint(new javax.swing.JFrame(), true);
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
    private widget.TextBox Alamat;
    private widget.Button BtnAll;
    private widget.Button BtnBatal;
    private widget.Button BtnCari;
    private widget.Button BtnEdit;
    private widget.Button BtnHapus;
    private widget.Button BtnKeluar;
    private widget.Button BtnPrint;
    private widget.Button BtnSimpan;
    private widget.CekBox ChkInput;
    private widget.Tanggal DTPCari1;
    private widget.Tanggal DTPCari2;
    private widget.TextBox Diagnosa;
    private widget.PanelBiasa FormInput;
    private widget.TextBox JK;
    private widget.Label LCount;
    private widget.TextBox LahirPasien;
    private javax.swing.JMenuItem LaporanSuratPernyataanFingerpritn;
    private javax.swing.JMenuItem MnDigitalTTE;
    private widget.TextBox NoBPJS;
    private widget.TextBox NoKTP;
    private widget.TextBox NoSurat;
    private javax.swing.JPanel PanelInput;
    private widget.ScrollPane Scroll;
    private widget.TextBox TCari;
    private widget.TextBox TNoRM;
    private widget.TextBox TNoRw;
    private widget.TextBox TPasien;
    private widget.Tanggal Tanggal;
    private widget.TextBox Umur;
    private widget.TextBox UmurPJ;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel10;
    private widget.Label jLabel11;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.Label jLabel18;
    private widget.Label jLabel19;
    private widget.Label jLabel20;
    private widget.Label jLabel21;
    private widget.Label jLabel22;
    private widget.Label jLabel23;
    private widget.Label jLabel3;
    private widget.Label jLabel4;
    private widget.Label jLabel44;
    private widget.Label jLabel6;
    private widget.Label jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private widget.panelisi panelGlass8;
    private widget.panelisi panelGlass9;
    private widget.ScrollPane scrollPane7;
    private widget.ScrollPane scrollPane8;
    private widget.ScrollPane scrollPane9;
    private widget.Table tbObat;
    private widget.TextArea text1;
    private widget.TextArea text2;
    private widget.TextArea text3;
    // End of variables declaration//GEN-END:variables

    public void tampil() {
        Valid.tabelKosong(tabMode);
        try{
            if(TCari.getText().trim().equals("")){
                ps=koneksi.prepareStatement(
                    "select * from surat_pernyataan_fingerprint where "+
                    "tanggal between ? and ? ORDER BY tanggal;");
            }else{
                ps = koneksi.prepareStatement(
                "SELECT * FROM surat_pernyataan_fingerprint WHERE " +
                "tanggal BETWEEN ? AND ? AND (" + // Added parentheses around OR condition
                "nama LIKE ? OR no_rawat LIKE ?) " + 
                "ORDER BY tanggal;");
            }
                
            try {
                if(TCari.getText().toString().trim().equals("")){
                    ps.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                    ps.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                }else{
                    ps.setString(1,Valid.SetTgl(DTPCari1.getSelectedItem()+""));
                    ps.setString(2,Valid.SetTgl(DTPCari2.getSelectedItem()+""));
                    ps.setString(3,"%"+TCari.getText()+"%");
                    ps.setString(4,"%"+TCari.getText()+"%");
                }
                  
                rs=ps.executeQuery();
                while(rs.next()){
                    tabMode.addRow(new String[]{
                        rs.getString("no_pernyataan"),rs.getString("no_rawat"),rs.getString("nama"),rs.getString("tanggal_lahir"),
                        rs.getString("tanggal"),rs.getString("alamat"),rs.getString("umur"),rs.getString("no_ktp"),
                        rs.getString("no_bpjs"),rs.getString("diagnosa"),rs.getString("ket1"),rs.getString("ket2"),
                        rs.getString("ket3")
                    });
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        }catch(Exception e){
            System.out.println("Notifikasi : "+e);
        }
        LCount.setText(""+tabMode.getRowCount());
    }

    public void emptTeks() {
        TNoRw.setText("");
        TNoRM.setText("");
        TPasien.setText("");
        LahirPasien.setText("");
        Alamat.setText("");
        UmurPJ.setText("");
        Diagnosa.setText("");
        NoKTP.setText("");
        Valid.autoNomer3("select ifnull(MAX(CONVERT(RIGHT(surat_pernyataan_fingerprint.no_pernyataan,3),signed)),0) from surat_pernyataan_fingerprint where surat_pernyataan_fingerprint.tanggal='"+Valid.SetTgl(Tanggal.getSelectedItem()+"")+"' ",
                "PF"+Tanggal.getSelectedItem().toString().substring(6,10)+Tanggal.getSelectedItem().toString().substring(3,5)+Tanggal.getSelectedItem().toString().substring(0,2),3,NoSurat);
        NoKTP.setText("");
        NoBPJS.setText("");
        Diagnosa.setText("");
        text2.setText("");
        text3.setText("");
        text1.setText("");
    }

 
    private void getData() {
         if(tbObat.getSelectedRow()!= -1){
            NoSurat.setText(tbObat.getValueAt(tbObat.getSelectedRow(),0).toString());
            TNoRw.setText(tbObat.getValueAt(tbObat.getSelectedRow(),1).toString());
            TPasien.setText(tbObat.getValueAt(tbObat.getSelectedRow(),2).toString());
            LahirPasien.setText(tbObat.getValueAt(tbObat.getSelectedRow(),3).toString());
            Valid.SetTgl(Tanggal,tbObat.getValueAt(tbObat.getSelectedRow(),4).toString());
            Alamat.setText(tbObat.getValueAt(tbObat.getSelectedRow(),5).toString());
            UmurPJ.setText(tbObat.getValueAt(tbObat.getSelectedRow(),6).toString());
            NoKTP.setText(tbObat.getValueAt(tbObat.getSelectedRow(),7).toString());
            NoBPJS.setText(tbObat.getValueAt(tbObat.getSelectedRow(),8).toString()); 
            Diagnosa.setText(tbObat.getValueAt(tbObat.getSelectedRow(),9).toString());
            text2.setText(tbObat.getValueAt(tbObat.getSelectedRow(),10).toString());
            text3.setText(tbObat.getValueAt(tbObat.getSelectedRow(),11).toString()); 
            text1.setText(tbObat.getValueAt(tbObat.getSelectedRow(),12).toString());
        }
    }

    private void isRawat() {
        try {
            ps=koneksi.prepareStatement(
                    "select reg_periksa.no_rkm_medis,pasien.nm_pasien,pasien.jk,pasien.no_ktp,pasien.no_peserta,pasien.tgl_lahir,pasien.alamat,reg_periksa.tgl_registrasi,"+
                    "reg_periksa.umurdaftar,reg_periksa.sttsumur from reg_periksa inner join pasien on reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                    "where reg_periksa.no_rawat=?");
            try {
                ps.setString(1,TNoRw.getText());
                rs=ps.executeQuery();
                if(rs.next()){
                    TNoRM.setText(rs.getString("no_rkm_medis"));
                    DTPCari1.setDate(rs.getDate("tgl_registrasi"));
                    TPasien.setText(rs.getString("nm_pasien"));
                    JK.setText(rs.getString("jk"));
                    LahirPasien.setText(rs.getString("tgl_lahir"));
                    UmurPJ.setText(rs.getString("umurdaftar")+" "+rs.getString("sttsumur"));
                    Alamat.setText(rs.getString("alamat"));
                    NoKTP.setText(rs.getString("no_ktp"));
                    NoBPJS.setText(rs.getString("no_peserta"));
                }
            } catch (Exception e) {
                System.out.println("Notif : "+e);
            } finally{
                if(rs!=null){
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notif : "+e);
        }
    }
    
    public void setNoRm(String norwt,Date tgl2) {
        TNoRw.setText(norwt);
        TCari.setText(norwt);
        DTPCari2.setDate(tgl2);
        isRawat();
        ChkInput.setSelected(true);
        isForm();
    }
    private void isForm(){
        if(ChkInput.isSelected()==true){
            ChkInput.setVisible(false);
            PanelInput.setPreferredSize(new Dimension(WIDTH,275));
            FormInput.setVisible(true);      
            ChkInput.setVisible(true);
        }else if(ChkInput.isSelected()==false){           
            ChkInput.setVisible(false);            
            PanelInput.setPreferredSize(new Dimension(WIDTH,20));
            FormInput.setVisible(false);      
            ChkInput.setVisible(true);
        }
    }
  
    private void ganti() {
        if(Sequel.mengedittf2("surat_pernyataan_fingerprint","no_pernyataan=?","no_pernyataan=?,no_rawat=?,tanggal=?,alamat=?,umur=?,no_ktp=?,no_bpjs=?,diagnosa=?,ket1=?,ket2=?,ket3=?",12,new String[]{
            NoSurat.getText(),TNoRM.getText(),Valid.SetTgl(Tanggal.getSelectedItem()+""),Alamat.getText(),UmurPJ.getText(),NoKTP.getText(),
            NoBPJS.getText(),Diagnosa.getText(),text1.getText(),text2.getText(),text3.getText(),NoSurat.getText(),
        })==true){
            System.out.println(NoSurat.getText());
            tbObat.setValueAt(NoSurat.getText(),tbObat.getSelectedRow(),0);
            tbObat.setValueAt(TNoRw.getText(),tbObat.getSelectedRow(),1);
            tbObat.setValueAt(Valid.SetTgl(Tanggal.getSelectedItem()+""),tbObat.getSelectedRow(),4);
            tbObat.setValueAt(Alamat.getText(),tbObat.getSelectedRow(),5);
            tbObat.setValueAt(UmurPJ.getText(),tbObat.getSelectedRow(),6);
            tbObat.setValueAt(NoKTP.getText(),tbObat.getSelectedRow(),7);
            tbObat.setValueAt(NoBPJS.getText(),tbObat.getSelectedRow(),8);
            tbObat.setValueAt(Diagnosa.getText(),tbObat.getSelectedRow(),9);
            tbObat.setValueAt(text2.getText(),tbObat.getSelectedRow(),10);
            tbObat.setValueAt(text3.getText(),tbObat.getSelectedRow(),11);
            tbObat.setValueAt(text1.getText(),tbObat.getSelectedRow(),12);
            
            emptTeks();
        }
    }

    private void hapus() {
        if(Sequel.queryu2tf("delete from surat_pernyataan_fingerprint where no_pernyataan=?",1,new String[]{
            tbObat.getValueAt(tbObat.getSelectedRow(),0).toString()
        })==true){
            tabMode.removeRow(tbObat.getSelectedRow());
            LCount.setText(""+tabMode.getRowCount());
            emptTeks();
        }else{
            JOptionPane.showMessageDialog(null,"Gagal menghapus..!!");
        }
    }
   
    
     void createPdf(String FileName){
        if(tbObat.getSelectedRow()>-1){
                if ("Admin Utama".equals(akses.getkode())){
                    namaDokter=akses.getkode();
                }else{
                    namaDokter=Sequel.cariIsi("select nama from pegawai where nik=?",akses.getkode());
                }
                Map<String, Object> param = new HashMap<>();
                param.put("namars",akses.getnamars());
                param.put("alamatrs",akses.getalamatrs());
                param.put("kotars",akses.getkabupatenrs());
                param.put("propinsirs",akses.getpropinsirs());
                param.put("kontakrs",akses.getkontakrs());
                param.put("emailrs",akses.getemailrs());
                param.put("logo",Sequel.cariGambar("select setting.logo from setting"));
                param.put("logobsre",Sequel.cariGambar("select setting.logo_bsre from setting"));
                param.put("nm_dokter",namaDokter);
                Valid.MyReportPDFWithName1("rptSuratFingerprint.jasper","report","tempfile",FileName,"::[ Surat Pernyataan Fingerprint ]::",
                    "select nama, no_ktp, no_bpjs, umur, diagnosa, alamat, ket1, ket2, ket3, tanggal from surat_pernyataan_fingerprint where no_pernyataan='"+tbObat.getValueAt(tbObat.getSelectedRow(),0).toString()+"'",param);
                berkas.tampilPdfLocal(FileName,"local","berkastte/surat_pernyataan_fingerprint",tbObat.getValueAt(tbObat.getSelectedRow(),0).toString(),"043");
                berkas.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
                berkas.setLocationRelativeTo(internalFrame1);
                berkas.setVisible(true);
            
        }else{
            JOptionPane.showMessageDialog(null,"Maaf, silahkan pilih data terlebih dahulu..!!!!");
        }
    }
}



