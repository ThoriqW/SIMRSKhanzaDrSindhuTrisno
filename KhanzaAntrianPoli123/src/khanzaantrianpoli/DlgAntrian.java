/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * DlgBiling.java
 *
 * Created on 07 Jun 10, 19:07:06
 */

package khanzaantrianpoli;

import fungsi.BackgroundMusic;
import fungsi.WarnaTable;
import fungsi.koneksiDB;
import fungsi.sekuel;
import fungsi.validasi;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author perpustakaan
 */
public class DlgAntrian extends javax.swing.JDialog implements ActionListener{    
    private Connection koneksi=koneksiDB.condb();
    private PreparedStatement pshapus,pssimpan,psselect;
    private final Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();   
    /** Creates new form DlgBiling
     * @param parent
     * @param modal */
    public DlgAntrian(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
        
        this.setSize(screen.width,screen.height);
        
        Object[] row={"No.Reg",
            "Nomer RM",
            "Pasien",
            "No.Rawat",
            "Dokter Dituju",
            "Jam Daftar"};
        tabMode1=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        Table1.setModel(tabMode1);

        Table1.setPreferredScrollableViewportSize(new Dimension(800,800));
        Table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 6; i++) {
            TableColumn column = Table1.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(60);
            }else if(i==1){
                column.setPreferredWidth(100);
            }else if(i==2){
                column.setPreferredWidth(200);
            }else if(i==3){
                column.setPreferredWidth(100);   
            }else if(i==4){
                column.setPreferredWidth(200);
            }else if(i==5){
                column.setPreferredWidth(100);
            }
        }
        Table1.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabMode2=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        Table2.setModel(tabMode2);

        Table2.setPreferredScrollableViewportSize(new Dimension(800,800));
        Table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 6; i++) {
            TableColumn column = Table2.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(60);
            }else if(i==1){
                column.setPreferredWidth(100);
            }else if(i==2){
                column.setPreferredWidth(200);
            }else if(i==3){
                column.setPreferredWidth(100);   
            }else if(i==4){
                column.setPreferredWidth(200);
            }else if(i==5){
                column.setPreferredWidth(100);
            }
        }
        Table2.setDefaultRenderer(Object.class, new WarnaTable());
        
        tabMode3=new DefaultTableModel(null,row){
              @Override public boolean isCellEditable(int rowIndex, int colIndex){return false;}
        };
        Table3.setModel(tabMode3);

        Table3.setPreferredScrollableViewportSize(new Dimension(800,800));
        Table3.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 6; i++) {
            TableColumn column = Table3.getColumnModel().getColumn(i);
            if(i==0){
                column.setPreferredWidth(60);
            }else if(i==1){
                column.setPreferredWidth(100);
            }else if(i==2){
                column.setPreferredWidth(200);
            }else if(i==3){
                column.setPreferredWidth(100);   
            }else if(i==4){
                column.setPreferredWidth(200);
            }else if(i==5){
                column.setPreferredWidth(100);
            }
        }
        Table3.setDefaultRenderer(Object.class, new WarnaTable());
        
        
        javax.swing.Timer timer = new javax.swing.Timer(100, this);
        timer.start();
    }
    
    private final DefaultTableModel tabMode1;
    private final DefaultTableModel tabMode2;
    private final DefaultTableModel tabMode3;
    private DlgCariDokter dokter=new DlgCariDokter(null,false);
    private sekuel Sequel=new sekuel();
    private validasi Valid=new validasi();
    private int pilihan=0;
    private DlgCariPoli poli=new DlgCariPoli(null,false);


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DlgDisplay = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        form1 = new widget.InternalFrame();
        labelantri1 = new widget.Label();
        jPanel6 = new javax.swing.JPanel();
        labelpas1 = new widget.Label();
        labeldokter1 = new widget.Label();
        form2 = new widget.InternalFrame();
        labelantri2 = new widget.Label();
        jPanel7 = new javax.swing.JPanel();
        labelpas2 = new widget.Label();
        labeldokter2 = new widget.Label();
        form3 = new widget.InternalFrame();
        labelantri3 = new widget.Label();
        jPanel8 = new javax.swing.JPanel();
        labelpas3 = new widget.Label();
        labeldokter3 = new widget.Label();
        internalFrame5 = new widget.InternalFrame();
        paneliklan = new usu.widget.glass.PanelGlass();
        panelruntext = new javax.swing.JPanel();
        labelruntext = new widget.Label();
        Popup1 = new javax.swing.JPopupMenu();
        ppAntri1 = new javax.swing.JMenuItem();
        ppUndo1 = new javax.swing.JMenuItem();
        Popup2 = new javax.swing.JPopupMenu();
        ppAntri2 = new javax.swing.JMenuItem();
        ppUndo2 = new javax.swing.JMenuItem();
        Popup3 = new javax.swing.JPopupMenu();
        ppAntri3 = new javax.swing.JMenuItem();
        ppUndo3 = new javax.swing.JMenuItem();
        Popup4 = new javax.swing.JPopupMenu();
        ppClose = new javax.swing.JMenuItem();
        norawat1 = new widget.TextBox();
        norawat2 = new widget.TextBox();
        norawat3 = new widget.TextBox();
        internalFrame1 = new widget.InternalFrame();
        panelisi1 = new widget.panelisi();
        BtnDisplay = new widget.Button();
        BtnKeluar = new widget.Button();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelisi2 = new widget.panelisi();
        BtnSeek2 = new widget.Button();
        Unit1 = new widget.TextBox();
        BtnSeek5 = new widget.Button();
        Dokter1 = new widget.TextBox();
        Scroll = new widget.ScrollPane();
        Table1 = new widget.Table();
        panelisi5 = new widget.panelisi();
        BtnAntri1 = new widget.Button();
        BtnBatal1 = new widget.Button();
        BtnBatal4 = new widget.Button();
        jPanel3 = new javax.swing.JPanel();
        panelisi3 = new widget.panelisi();
        BtnSeek3 = new widget.Button();
        Unit2 = new widget.TextBox();
        BtnSeek6 = new widget.Button();
        Dokter2 = new widget.TextBox();
        Scroll1 = new widget.ScrollPane();
        Table2 = new widget.Table();
        panelisi6 = new widget.panelisi();
        BtnAntri2 = new widget.Button();
        BtnBatal2 = new widget.Button();
        BtnBatal5 = new widget.Button();
        jPanel4 = new javax.swing.JPanel();
        panelisi4 = new widget.panelisi();
        BtnSeek4 = new widget.Button();
        Unit3 = new widget.TextBox();
        BtnSeek7 = new widget.Button();
        Dokter3 = new widget.TextBox();
        Scroll2 = new widget.ScrollPane();
        Table3 = new widget.Table();
        panelisi7 = new widget.panelisi();
        BtnAntri3 = new widget.Button();
        BtnBatal3 = new widget.Button();
        BtnBatal6 = new widget.Button();

        DlgDisplay.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        DlgDisplay.setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        DlgDisplay.setName("DlgDisplay"); // NOI18N

        jPanel5.setBackground(new java.awt.Color(150, 255, 150));
        jPanel5.setName("jPanel5"); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(550, 100));
        jPanel5.setLayout(new java.awt.GridLayout(3, 0));

        form1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), " Antrian Pasien 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 38), new java.awt.Color(50, 100, 50))); // NOI18N
        form1.setName("form1"); // NOI18N
        form1.setPreferredSize(new java.awt.Dimension(500, 110));
        form1.setWarnaBawah(new java.awt.Color(230, 255, 230));
        form1.setLayout(new java.awt.BorderLayout());

        labelantri1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "No.Antrian :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labelantri1.setForeground(new java.awt.Color(50, 100, 50));
        labelantri1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelantri1.setText("001");
        labelantri1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelantri1.setFont(new java.awt.Font("Serif", 0, 86)); // NOI18N
        labelantri1.setName("labelantri1"); // NOI18N
        labelantri1.setPreferredSize(new java.awt.Dimension(200, 50));
        form1.add(labelantri1, java.awt.BorderLayout.EAST);

        jPanel6.setName("jPanel6"); // NOI18N
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(2, 0));

        labelpas1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "Pasien :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labelpas1.setForeground(new java.awt.Color(50, 100, 50));
        labelpas1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelpas1.setText("Pasien 1");
        labelpas1.setFocusable(false);
        labelpas1.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labelpas1.setName("labelpas1"); // NOI18N
        labelpas1.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel6.add(labelpas1);

        labeldokter1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "Dokter :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labeldokter1.setForeground(new java.awt.Color(50, 100, 50));
        labeldokter1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeldokter1.setText("Dokter 1");
        labeldokter1.setFocusable(false);
        labeldokter1.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labeldokter1.setName("labeldokter1"); // NOI18N
        labeldokter1.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel6.add(labeldokter1);

        form1.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel5.add(form1);

        form2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), " Antrian Pasien 2", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 38), new java.awt.Color(50, 100, 50))); // NOI18N
        form2.setName("form2"); // NOI18N
        form2.setPreferredSize(new java.awt.Dimension(500, 110));
        form2.setWarnaBawah(new java.awt.Color(230, 255, 230));
        form2.setLayout(new java.awt.BorderLayout());

        labelantri2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "No.Antrian :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labelantri2.setForeground(new java.awt.Color(50, 100, 50));
        labelantri2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelantri2.setText("002");
        labelantri2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelantri2.setFont(new java.awt.Font("Serif", 0, 86)); // NOI18N
        labelantri2.setName("labelantri2"); // NOI18N
        labelantri2.setPreferredSize(new java.awt.Dimension(200, 50));
        form2.add(labelantri2, java.awt.BorderLayout.EAST);

        jPanel7.setName("jPanel7"); // NOI18N
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(2, 0));

        labelpas2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "Pasien :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labelpas2.setForeground(new java.awt.Color(50, 100, 50));
        labelpas2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelpas2.setText("Pasien 2");
        labelpas2.setFocusable(false);
        labelpas2.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labelpas2.setName("labelpas2"); // NOI18N
        labelpas2.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel7.add(labelpas2);

        labeldokter2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "Dokter :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labeldokter2.setForeground(new java.awt.Color(50, 100, 50));
        labeldokter2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeldokter2.setText("Dokter 2");
        labeldokter2.setFocusable(false);
        labeldokter2.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labeldokter2.setName("labeldokter2"); // NOI18N
        labeldokter2.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel7.add(labeldokter2);

        form2.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel5.add(form2);

        form3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), " Antrian Pasien 3", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 38), new java.awt.Color(50, 100, 50))); // NOI18N
        form3.setName("form3"); // NOI18N
        form3.setPreferredSize(new java.awt.Dimension(500, 110));
        form3.setWarnaBawah(new java.awt.Color(230, 255, 230));
        form3.setLayout(new java.awt.BorderLayout());

        labelantri3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "No.Antrian :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labelantri3.setForeground(new java.awt.Color(50, 100, 50));
        labelantri3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelantri3.setText("003");
        labelantri3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        labelantri3.setFont(new java.awt.Font("Serif", 0, 86)); // NOI18N
        labelantri3.setName("labelantri3"); // NOI18N
        labelantri3.setPreferredSize(new java.awt.Dimension(200, 50));
        form3.add(labelantri3, java.awt.BorderLayout.EAST);

        jPanel8.setName("jPanel8"); // NOI18N
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(2, 0));

        labelpas3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "Pasien :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labelpas3.setForeground(new java.awt.Color(50, 100, 50));
        labelpas3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelpas3.setText("Pasien 3");
        labelpas3.setFocusable(false);
        labelpas3.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labelpas3.setName("labelpas3"); // NOI18N
        labelpas3.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel8.add(labelpas3);

        labeldokter3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(150, 250, 150)), "Dokter :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Serif", 0, 26), new java.awt.Color(50, 100, 50))); // NOI18N
        labeldokter3.setForeground(new java.awt.Color(50, 100, 50));
        labeldokter3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labeldokter3.setText("Dokter 3");
        labeldokter3.setFocusable(false);
        labeldokter3.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labeldokter3.setName("labeldokter3"); // NOI18N
        labeldokter3.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel8.add(labeldokter3);

        form3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel5.add(form3);

        DlgDisplay.getContentPane().add(jPanel5, java.awt.BorderLayout.EAST);

        internalFrame5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), "::[ Informasi ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 24), new java.awt.Color(50, 100, 50))); // NOI18N
        internalFrame5.setComponentPopupMenu(Popup4);
        internalFrame5.setName("internalFrame5"); // NOI18N
        internalFrame5.setPreferredSize(new java.awt.Dimension(500, 110));
        internalFrame5.setWarnaBawah(new java.awt.Color(230, 255, 230));
        internalFrame5.setLayout(new java.awt.BorderLayout());

        paneliklan.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/picture/coba.gif"))); // NOI18N
        paneliklan.setBackgroundImageType(usu.widget.constan.BackgroundConstan.BACKGROUND_IMAGE_STRECT);
        paneliklan.setPreferredSize(new java.awt.Dimension(200, 140));
        paneliklan.setRound(false);
        paneliklan.setWarna(new java.awt.Color(150, 255, 150));
        paneliklan.setLayout(null);
        internalFrame5.add(paneliklan, java.awt.BorderLayout.CENTER);

        panelruntext.setBackground(new java.awt.Color(230, 255, 230));
        panelruntext.setName("panelruntext"); // NOI18N
        panelruntext.setPreferredSize(new java.awt.Dimension(100, 100));
        panelruntext.setLayout(new java.awt.BorderLayout());

        labelruntext.setBackground(new java.awt.Color(238, 255, 238));
        labelruntext.setForeground(new java.awt.Color(50, 100, 50));
        labelruntext.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        labelruntext.setText("Aku sayang sama kamu, maafin aku yaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        labelruntext.setFont(new java.awt.Font("Serif", 0, 26)); // NOI18N
        labelruntext.setName("labelruntext"); // NOI18N
        labelruntext.setPreferredSize(new java.awt.Dimension(853, 50));
        panelruntext.add(labelruntext, java.awt.BorderLayout.CENTER);

        internalFrame5.add(panelruntext, java.awt.BorderLayout.PAGE_END);

        DlgDisplay.getContentPane().add(internalFrame5, java.awt.BorderLayout.CENTER);

        Popup1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Popup1.setName("Popup1"); // NOI18N

        ppAntri1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppAntri1.setForeground(new java.awt.Color(102, 51, 0));
        ppAntri1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/011.png"))); // NOI18N
        ppAntri1.setText("Masukkan Antrian");
        ppAntri1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppAntri1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppAntri1.setIconTextGap(8);
        ppAntri1.setName("ppAntri1"); // NOI18N
        ppAntri1.setPreferredSize(new java.awt.Dimension(150, 25));
        ppAntri1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppAntri1ActionPerformed(evt);
            }
        });
        Popup1.add(ppAntri1);

        ppUndo1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppUndo1.setForeground(new java.awt.Color(102, 51, 0));
        ppUndo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/101.png"))); // NOI18N
        ppUndo1.setText("Batal Periksa");
        ppUndo1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppUndo1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppUndo1.setIconTextGap(8);
        ppUndo1.setName("ppUndo1"); // NOI18N
        ppUndo1.setPreferredSize(new java.awt.Dimension(150, 25));
        ppUndo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppUndo1ActionPerformed(evt);
            }
        });
        Popup1.add(ppUndo1);

        Popup2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Popup2.setName("Popup2"); // NOI18N

        ppAntri2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppAntri2.setForeground(new java.awt.Color(102, 51, 0));
        ppAntri2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/011.png"))); // NOI18N
        ppAntri2.setText("Masukkan Antrian");
        ppAntri2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppAntri2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppAntri2.setIconTextGap(8);
        ppAntri2.setName("ppAntri2"); // NOI18N
        ppAntri2.setPreferredSize(new java.awt.Dimension(150, 25));
        ppAntri2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppAntri2ActionPerformed(evt);
            }
        });
        Popup2.add(ppAntri2);

        ppUndo2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppUndo2.setForeground(new java.awt.Color(102, 51, 0));
        ppUndo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/101.png"))); // NOI18N
        ppUndo2.setText("Batal Periksa");
        ppUndo2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppUndo2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppUndo2.setIconTextGap(8);
        ppUndo2.setName("ppUndo2"); // NOI18N
        ppUndo2.setPreferredSize(new java.awt.Dimension(150, 25));
        ppUndo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppUndo2ActionPerformed(evt);
            }
        });
        Popup2.add(ppUndo2);

        Popup3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Popup3.setName("Popup3"); // NOI18N

        ppAntri3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppAntri3.setForeground(new java.awt.Color(102, 51, 0));
        ppAntri3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/011.png"))); // NOI18N
        ppAntri3.setText("Masukkan Antrian");
        ppAntri3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppAntri3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppAntri3.setIconTextGap(8);
        ppAntri3.setName("ppAntri3"); // NOI18N
        ppAntri3.setPreferredSize(new java.awt.Dimension(150, 25));
        ppAntri3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppAntri3ActionPerformed(evt);
            }
        });
        Popup3.add(ppAntri3);

        ppUndo3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppUndo3.setForeground(new java.awt.Color(102, 51, 0));
        ppUndo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/101.png"))); // NOI18N
        ppUndo3.setText("Batal Periksa");
        ppUndo3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppUndo3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppUndo3.setIconTextGap(8);
        ppUndo3.setName("ppUndo3"); // NOI18N
        ppUndo3.setPreferredSize(new java.awt.Dimension(150, 25));
        ppUndo3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppUndo3ActionPerformed(evt);
            }
        });
        Popup3.add(ppUndo3);

        Popup4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        Popup4.setName("Popup4"); // NOI18N

        ppClose.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        ppClose.setForeground(new java.awt.Color(102, 51, 0));
        ppClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/101.png"))); // NOI18N
        ppClose.setText("Tutup Display");
        ppClose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ppClose.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        ppClose.setIconTextGap(8);
        ppClose.setName("ppClose"); // NOI18N
        ppClose.setPreferredSize(new java.awt.Dimension(150, 25));
        ppClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppCloseActionPerformed(evt);
            }
        });
        Popup4.add(ppClose);

        norawat1.setEditable(false);
        norawat1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        norawat1.setName("norawat1"); // NOI18N
        norawat1.setPreferredSize(new java.awt.Dimension(230, 23));

        norawat2.setEditable(false);
        norawat2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        norawat2.setName("norawat2"); // NOI18N
        norawat2.setPreferredSize(new java.awt.Dimension(230, 23));

        norawat3.setEditable(false);
        norawat3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        norawat3.setName("norawat3"); // NOI18N
        norawat3.setPreferredSize(new java.awt.Dimension(230, 23));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModalExclusionType(java.awt.Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Antrian Periksa Pasien ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi1.setName("panelisi1"); // NOI18N
        panelisi1.setPreferredSize(new java.awt.Dimension(55, 55));
        panelisi1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        BtnDisplay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/editcopy.png"))); // NOI18N
        BtnDisplay.setMnemonic('D');
        BtnDisplay.setText("Display");
        BtnDisplay.setToolTipText("Alt+D");
        BtnDisplay.setIconTextGap(3);
        BtnDisplay.setName("BtnDisplay"); // NOI18N
        BtnDisplay.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnDisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDisplayActionPerformed(evt);
            }
        });
        panelisi1.add(BtnDisplay);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setIconTextGap(3);
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        panelisi1.add(BtnKeluar);

        internalFrame1.add(panelisi1, java.awt.BorderLayout.PAGE_END);

        jPanel1.setName("jPanel1"); // NOI18N
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(1, 3));

        jPanel2.setBackground(new java.awt.Color(245, 180, 245));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), ".: Antrian Pasien 1 :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        jPanel2.setName("jPanel2"); // NOI18N
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi2.setName("panelisi2"); // NOI18N
        panelisi2.setPreferredSize(new java.awt.Dimension(12, 74));
        panelisi2.setLayout(null);

        BtnSeek2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek2.setMnemonic('1');
        BtnSeek2.setToolTipText("ALt+1");
        BtnSeek2.setName("BtnSeek2"); // NOI18N
        BtnSeek2.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek2ActionPerformed(evt);
            }
        });
        panelisi2.add(BtnSeek2);
        BtnSeek2.setBounds(6, 10, 28, 23);

        Unit1.setEditable(false);
        Unit1.setName("Unit1"); // NOI18N
        Unit1.setPreferredSize(new java.awt.Dimension(230, 23));
        panelisi2.add(Unit1);
        Unit1.setBounds(39, 10, 230, 23);

        BtnSeek5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek5.setMnemonic('2');
        BtnSeek5.setToolTipText("ALt+2");
        BtnSeek5.setName("BtnSeek5"); // NOI18N
        BtnSeek5.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek5ActionPerformed(evt);
            }
        });
        panelisi2.add(BtnSeek5);
        BtnSeek5.setBounds(6, 42, 28, 23);

        Dokter1.setEditable(false);
        Dokter1.setName("Dokter1"); // NOI18N
        Dokter1.setPreferredSize(new java.awt.Dimension(230, 23));
        panelisi2.add(Dokter1);
        Dokter1.setBounds(39, 42, 230, 23);

        jPanel2.add(panelisi2, java.awt.BorderLayout.PAGE_START);

        Scroll.setComponentPopupMenu(Popup1);
        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        Table1.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        Table1.setComponentPopupMenu(Popup1);
        Table1.setName("Table1"); // NOI18N
        Scroll.setViewportView(Table1);

        jPanel2.add(Scroll, java.awt.BorderLayout.CENTER);

        panelisi5.setName("panelisi5"); // NOI18N
        panelisi5.setPreferredSize(new java.awt.Dimension(12, 44));
        panelisi5.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        BtnAntri1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Agenda-1-16x16.png"))); // NOI18N
        BtnAntri1.setMnemonic('7');
        BtnAntri1.setText("Antri");
        BtnAntri1.setToolTipText("Alt+7");
        BtnAntri1.setIconTextGap(3);
        BtnAntri1.setName("BtnAntri1"); // NOI18N
        BtnAntri1.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnAntri1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAntri1ActionPerformed(evt);
            }
        });
        panelisi5.add(BtnAntri1);

        BtnBatal1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnBatal1.setMnemonic('8');
        BtnBatal1.setText("Batal");
        BtnBatal1.setToolTipText("Alt+8");
        BtnBatal1.setIconTextGap(3);
        BtnBatal1.setName("BtnBatal1"); // NOI18N
        BtnBatal1.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnBatal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatal1ActionPerformed(evt);
            }
        });
        panelisi5.add(BtnBatal1);

        BtnBatal4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/plus_16.png"))); // NOI18N
        BtnBatal4.setMnemonic('8');
        BtnBatal4.setText("Ulang");
        BtnBatal4.setToolTipText("Alt+8");
        BtnBatal4.setIconTextGap(3);
        BtnBatal4.setName("BtnUlang1"); // NOI18N
        BtnBatal4.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnBatal4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatal4ActionPerformed(evt);
            }
        });
        panelisi5.add(BtnBatal4);

        jPanel2.add(panelisi5, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel2);

        jPanel3.setBackground(new java.awt.Color(245, 180, 245));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), ".: Antrian Pasien 2 :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        jPanel3.setName("jPanel3"); // NOI18N
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi3.setName("panelisi3"); // NOI18N
        panelisi3.setPreferredSize(new java.awt.Dimension(12, 74));
        panelisi3.setLayout(null);

        BtnSeek3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek3.setMnemonic('3');
        BtnSeek3.setToolTipText("ALt+3");
        BtnSeek3.setName("BtnSeek3"); // NOI18N
        BtnSeek3.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek3ActionPerformed(evt);
            }
        });
        panelisi3.add(BtnSeek3);
        BtnSeek3.setBounds(6, 10, 28, 23);

        Unit2.setEditable(false);
        Unit2.setName("Unit2"); // NOI18N
        Unit2.setPreferredSize(new java.awt.Dimension(230, 23));
        panelisi3.add(Unit2);
        Unit2.setBounds(39, 10, 230, 23);

        BtnSeek6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek6.setMnemonic('4');
        BtnSeek6.setToolTipText("ALt+4");
        BtnSeek6.setName("BtnSeek6"); // NOI18N
        BtnSeek6.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek6ActionPerformed(evt);
            }
        });
        panelisi3.add(BtnSeek6);
        BtnSeek6.setBounds(6, 42, 28, 23);

        Dokter2.setEditable(false);
        Dokter2.setName("Dokter2"); // NOI18N
        Dokter2.setPreferredSize(new java.awt.Dimension(230, 23));
        panelisi3.add(Dokter2);
        Dokter2.setBounds(39, 42, 230, 23);

        jPanel3.add(panelisi3, java.awt.BorderLayout.PAGE_START);

        Scroll1.setComponentPopupMenu(Popup2);
        Scroll1.setName("Scroll1"); // NOI18N
        Scroll1.setOpaque(true);

        Table2.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        Table2.setComponentPopupMenu(Popup2);
        Table2.setName("Table2"); // NOI18N
        Scroll1.setViewportView(Table2);

        jPanel3.add(Scroll1, java.awt.BorderLayout.CENTER);

        panelisi6.setName("panelisi6"); // NOI18N
        panelisi6.setPreferredSize(new java.awt.Dimension(12, 44));
        panelisi6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        BtnAntri2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Agenda-1-16x16.png"))); // NOI18N
        BtnAntri2.setMnemonic('9');
        BtnAntri2.setText("Antri");
        BtnAntri2.setToolTipText("Alt+9");
        BtnAntri2.setIconTextGap(3);
        BtnAntri2.setName("BtnAntri2"); // NOI18N
        BtnAntri2.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnAntri2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAntri2ActionPerformed(evt);
            }
        });
        panelisi6.add(BtnAntri2);

        BtnBatal2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnBatal2.setMnemonic('A');
        BtnBatal2.setText("Batal");
        BtnBatal2.setToolTipText("Alt+A");
        BtnBatal2.setIconTextGap(3);
        BtnBatal2.setName("BtnBatal2"); // NOI18N
        BtnBatal2.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnBatal2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatal2ActionPerformed(evt);
            }
        });
        panelisi6.add(BtnBatal2);

        BtnBatal5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/plus_16.png"))); // NOI18N
        BtnBatal5.setMnemonic('8');
        BtnBatal5.setText("Ulang");
        BtnBatal5.setToolTipText("Alt+8");
        BtnBatal5.setIconTextGap(3);
        BtnBatal5.setName("BtnBatal5"); // NOI18N
        BtnBatal5.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnBatal5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatal5ActionPerformed(evt);
            }
        });
        panelisi6.add(BtnBatal5);

        jPanel3.add(panelisi6, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel3);

        jPanel4.setBackground(new java.awt.Color(245, 180, 245));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), ".: Antrian Pasien 3 :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(50, 70, 40))); // NOI18N
        jPanel4.setName("jPanel4"); // NOI18N
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout(1, 1));

        panelisi4.setName("panelisi4"); // NOI18N
        panelisi4.setPreferredSize(new java.awt.Dimension(12, 74));
        panelisi4.setLayout(null);

        BtnSeek4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek4.setMnemonic('5');
        BtnSeek4.setToolTipText("ALt+5");
        BtnSeek4.setName("BtnSeek4"); // NOI18N
        BtnSeek4.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek4ActionPerformed(evt);
            }
        });
        panelisi4.add(BtnSeek4);
        BtnSeek4.setBounds(6, 10, 28, 23);

        Unit3.setEditable(false);
        Unit3.setName("Unit3"); // NOI18N
        Unit3.setPreferredSize(new java.awt.Dimension(230, 23));
        panelisi4.add(Unit3);
        Unit3.setBounds(39, 10, 230, 23);

        BtnSeek7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnSeek7.setMnemonic('6');
        BtnSeek7.setToolTipText("ALt+6");
        BtnSeek7.setName("BtnSeek7"); // NOI18N
        BtnSeek7.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnSeek7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSeek7ActionPerformed(evt);
            }
        });
        panelisi4.add(BtnSeek7);
        BtnSeek7.setBounds(6, 42, 28, 23);

        Dokter3.setEditable(false);
        Dokter3.setName("Dokter3"); // NOI18N
        Dokter3.setPreferredSize(new java.awt.Dimension(230, 23));
        panelisi4.add(Dokter3);
        Dokter3.setBounds(39, 42, 230, 23);

        jPanel4.add(panelisi4, java.awt.BorderLayout.PAGE_START);

        Scroll2.setComponentPopupMenu(Popup3);
        Scroll2.setName("Scroll2"); // NOI18N
        Scroll2.setOpaque(true);

        Table3.setToolTipText("Silahkan klik untuk memilih data yang mau diedit ataupun dihapus");
        Table3.setComponentPopupMenu(Popup3);
        Table3.setName("Table3"); // NOI18N
        Scroll2.setViewportView(Table3);

        jPanel4.add(Scroll2, java.awt.BorderLayout.CENTER);

        panelisi7.setName("panelisi7"); // NOI18N
        panelisi7.setPreferredSize(new java.awt.Dimension(12, 44));
        panelisi7.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        BtnAntri3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/Agenda-1-16x16.png"))); // NOI18N
        BtnAntri3.setMnemonic('B');
        BtnAntri3.setText("Antri");
        BtnAntri3.setToolTipText("Alt+B");
        BtnAntri3.setIconTextGap(3);
        BtnAntri3.setName("BtnAntri3"); // NOI18N
        BtnAntri3.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnAntri3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAntri3ActionPerformed(evt);
            }
        });
        panelisi7.add(BtnAntri3);

        BtnBatal3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/cross.png"))); // NOI18N
        BtnBatal3.setMnemonic('C');
        BtnBatal3.setText("Batal");
        BtnBatal3.setToolTipText("Alt+C");
        BtnBatal3.setIconTextGap(3);
        BtnBatal3.setName("BtnBatal3"); // NOI18N
        BtnBatal3.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnBatal3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatal3ActionPerformed(evt);
            }
        });
        panelisi7.add(BtnBatal3);

        BtnBatal6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/plus_16.png"))); // NOI18N
        BtnBatal6.setMnemonic('8');
        BtnBatal6.setText("Ulang");
        BtnBatal6.setToolTipText("Alt+8");
        BtnBatal6.setIconTextGap(3);
        BtnBatal6.setName("BtnBatal6"); // NOI18N
        BtnBatal6.setPreferredSize(new java.awt.Dimension(90, 30));
        BtnBatal6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatal6ActionPerformed(evt);
            }
        });
        panelisi7.add(BtnBatal6);

        jPanel4.add(panelisi7, java.awt.BorderLayout.PAGE_END);

        jPanel1.add(jPanel4);

        internalFrame1.add(jPanel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        System.exit(0);
}//GEN-LAST:event_BtnKeluarActionPerformed

private void BtnSeek2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek2ActionPerformed
        pilihan=1;
        poli.emptTeks();
        poli.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        poli.setLocationRelativeTo(internalFrame1);
        poli.setAlwaysOnTop(false);
        poli.setVisible(true);
}//GEN-LAST:event_BtnSeek2ActionPerformed

private void BtnDisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDisplayActionPerformed
       Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
       DlgDisplay.setSize(screen.width,screen.height);
       if(!Unit1.getText().equals("")){
           form1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), Unit1.getText()+" :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 36), new java.awt.Color(100, 150, 100)));
       }
       
       if(!Unit2.getText().equals("")){
           form2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), Unit2.getText()+" :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 36), new java.awt.Color(100, 150, 100)));
       }
       
       if(!Unit3.getText().equals("")){
           form3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(100, 200, 100)), Unit3.getText()+" :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 0, 36), new java.awt.Color(100, 150, 100)));
       }
       isTampil();
       DlgDisplay.setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());
       DlgDisplay.setAlwaysOnTop(false);
       DlgDisplay.setVisible(true);
}//GEN-LAST:event_BtnDisplayActionPerformed

private void ppAntri1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppAntri1ActionPerformed
        
        if(tabMode1.getRowCount()!=0){
            try {
                pshapus=koneksi.prepareStatement("delete from antripoli1");
                try {
                    pshapus.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(pshapus!=null){
                        pshapus.close();
                    }
                }
                pssimpan=koneksi.prepareStatement("insert into antripoli1 values(?,?,?,?,?)");
                try{
                    pssimpan.setString(1,Unit1.getText());
                    pssimpan.setString(2,tabMode1.getValueAt(0,0).toString());
                    pssimpan.setString(3,tabMode1.getValueAt(0,2).toString());
                    pssimpan.setString(4,tabMode1.getValueAt(0,4).toString());
                    pssimpan.setString(5,tabMode1.getValueAt(0,0).toString());
                    pssimpan.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(pssimpan!=null){
                        pssimpan.close();
                    }
                } 
            } catch (Exception e) {
                System.out.println(e);
            }
            Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode1.getValueAt(0,3).toString()+"'");
            tampil1();
//            panggil(Integer.parseInt(tabMode1.getValueAt(0,0).toString()));
//                labelantri1.setText(tabMode1.getValueAt(0,0).toString());
//                labelpas1.setText(tabMode1.getValueAt(0,2).toString());
//                norawat1.setText(tabMode1.getValueAt(0,3).toString());
//                labeldokter1.setText(tabMode1.getValueAt(0,4).toString());
//                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode1.getValueAt(0,3).toString()+"'");
//                tampil1();
        }
}//GEN-LAST:event_ppAntri1ActionPerformed

private void ppAntri2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppAntri2ActionPerformed
       
        if(tabMode2.getRowCount()!=0){
            try {
                pshapus=koneksi.prepareStatement("delete from antripoli2");
                try {
                    pshapus.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(pshapus!=null){
                        pshapus.close();
                    }
                }
                pssimpan=koneksi.prepareStatement("insert into antripoli2 values(?,?,?,?,?)");
                try{
                    pssimpan.setString(1,Unit2.getText());
                    pssimpan.setString(2,tabMode2.getValueAt(0,0).toString());
                    pssimpan.setString(3,tabMode2.getValueAt(0,2).toString());
                    pssimpan.setString(4,tabMode2.getValueAt(0,4).toString());
                    pssimpan.setString(5,tabMode2.getValueAt(0,0).toString());
                    pssimpan.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(pssimpan!=null){
                        pssimpan.close();
                    }
                } 
            } catch (Exception e) {
                System.out.println(e);
            }
            Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode2.getValueAt(0,3).toString()+"'");
            tampil2();
//            panggil(Integer.parseInt(tabMode2.getValueAt(0,0).toString()));
//                labelantri2.setText(tabMode2.getValueAt(0,0).toString());
//                labelpas2.setText(tabMode2.getValueAt(0,2).toString());
//                norawat2.setText(tabMode2.getValueAt(0,3).toString());
//                labeldokter2.setText(tabMode2.getValueAt(0,4).toString());
//                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode2.getValueAt(0,3).toString()+"'");               
        }
}//GEN-LAST:event_ppAntri2ActionPerformed

private void ppAntri3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppAntri3ActionPerformed
       
        if(tabMode3.getRowCount()!=0){
            try {
                pshapus=koneksi.prepareStatement("delete from antripoli3");
                try {
                    pshapus.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(pshapus!=null){
                        pshapus.close();
                    }
                }
                pssimpan=koneksi.prepareStatement("insert into antripoli3 values(?,?,?,?,?)");
                try{
                    pssimpan.setString(1,Unit3.getText());
                    pssimpan.setString(2,tabMode3.getValueAt(0,0).toString());
                    pssimpan.setString(3,tabMode3.getValueAt(0,2).toString());
                    pssimpan.setString(4,tabMode3.getValueAt(0,4).toString());
                    pssimpan.setString(5,tabMode3.getValueAt(0,0).toString());
                    pssimpan.executeUpdate();
                } catch (Exception e) {
                    System.out.println("Notif : "+e);
                } finally{
                    if(pssimpan!=null){
                        pssimpan.close();
                    }
                } 
            } catch (Exception e) {
                System.out.println(e);
            }
            Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode3.getValueAt(0,3).toString()+"'");
            tampil3();
//            panggil(Integer.parseInt(tabMode3.getValueAt(0,0).toString()));
//                labelantri3.setText(tabMode3.getValueAt(0,0).toString());
//                labelpas3.setText(tabMode3.getValueAt(0,2).toString());
//                norawat3.setText(tabMode3.getValueAt(0,3).toString());
//                labeldokter3.setText(tabMode3.getValueAt(0,4).toString());
//                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode3.getValueAt(1,3).toString()+"'");
//                tampil3();
        }
}//GEN-LAST:event_ppAntri3ActionPerformed

private void ppCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppCloseActionPerformed
    DlgDisplay.setVisible(false);
    DlgDisplay.dispose();
}//GEN-LAST:event_ppCloseActionPerformed

private void ppUndo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppUndo1ActionPerformed
       if(tabMode1.getRowCount()>=5){                
                Sequel.queryu("update reg_periksa set stts='Belum',jam_reg='"+tabMode1.getValueAt(4,5).toString()+"' where no_rawat='"+norawat1.getText()+"'");
                labelantri1.setText(tabMode1.getValueAt(0,0).toString());
                labelpas1.setText(tabMode1.getValueAt(0,2).toString());
                norawat1.setText(tabMode1.getValueAt(0,3).toString());
                labeldokter1.setText(tabMode1.getValueAt(0,4).toString());
                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode1.getValueAt(0,3).toString()+"'");
                tampil1();
        }else if(tabMode1.getRowCount()<=5){  
                Sequel.queryu("update reg_periksa set stts='Belum',jam_reg=current_time() where no_rawat='"+norawat1.getText()+"'");
                labelantri1.setText(tabMode1.getValueAt(0,0).toString());
                labelpas1.setText(tabMode1.getValueAt(0,2).toString());                
                norawat1.setText(tabMode1.getValueAt(0,3).toString());
                labeldokter1.setText(tabMode1.getValueAt(0,4).toString());
                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode1.getValueAt(0,3).toString()+"'");
                tampil1();
        }
}//GEN-LAST:event_ppUndo1ActionPerformed

private void ppUndo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppUndo2ActionPerformed
       if(tabMode2.getRowCount()>=5){                
                Sequel.queryu("update reg_periksa set stts='Belum',jam_reg='"+tabMode2.getValueAt(4,5).toString()+"' where no_rawat='"+norawat2.getText()+"'");
                labelantri2.setText(tabMode2.getValueAt(0,0).toString());
                labelpas2.setText(tabMode2.getValueAt(0,2).toString());
                norawat2.setText(tabMode2.getValueAt(0,3).toString());
                labeldokter2.setText(tabMode2.getValueAt(0,4).toString());
                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode2.getValueAt(0,3).toString()+"'");
                tampil2();
        }else if(tabMode2.getRowCount()<=5){  
                Sequel.queryu("update reg_periksa set stts='Belum',jam_reg=current_time() where no_rawat='"+norawat2.getText()+"'");
                labelantri2.setText(tabMode2.getValueAt(0,0).toString());
                labelpas2.setText(tabMode2.getValueAt(0,2).toString());                
                norawat2.setText(tabMode2.getValueAt(0,3).toString());
                labeldokter2.setText(tabMode2.getValueAt(0,4).toString());
                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode2.getValueAt(0,3).toString()+"'");
                tampil2();
        }
}//GEN-LAST:event_ppUndo2ActionPerformed

private void ppUndo3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppUndo3ActionPerformed
       if(tabMode3.getRowCount()>=5){                
                Sequel.queryu("update reg_periksa set stts='Belum',jam_reg='"+tabMode3.getValueAt(4,5).toString()+"' where no_rawat='"+norawat3.getText()+"'");
                labelantri3.setText(tabMode3.getValueAt(0,0).toString());
                labelpas3.setText(tabMode3.getValueAt(0,2).toString());
                norawat3.setText(tabMode3.getValueAt(0,3).toString());
                labeldokter3.setText(tabMode3.getValueAt(0,4).toString());
                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode3.getValueAt(0,3).toString()+"'");
                tampil3();
        }else if(tabMode3.getRowCount()<=5){  
                Sequel.queryu("update reg_periksa set stts='Belum',jam_reg=current_time() where no_rawat='"+norawat3.getText()+"'");
                labelantri3.setText(tabMode3.getValueAt(0,0).toString());
                labelpas3.setText(tabMode3.getValueAt(0,2).toString());                
                norawat3.setText(tabMode3.getValueAt(0,3).toString());
                labeldokter3.setText(tabMode3.getValueAt(0,4).toString());
                Sequel.queryu("update reg_periksa set stts='Sudah' where no_rawat='"+tabMode3.getValueAt(0,3).toString()+"'");
                tampil3();
        }
}//GEN-LAST:event_ppUndo3ActionPerformed

private void BtnSeek5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek5ActionPerformed
       pilihan=1;
       dokter.emptTeks();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
}//GEN-LAST:event_BtnSeek5ActionPerformed

private void BtnBatal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatal1ActionPerformed
      ppUndo1ActionPerformed(evt);
}//GEN-LAST:event_BtnBatal1ActionPerformed

private void BtnAntri1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAntri1ActionPerformed
      ppAntri1ActionPerformed(evt);
}//GEN-LAST:event_BtnAntri1ActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        poli.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(poli.getTable().getSelectedRow()!= -1){
                    if(pilihan==1){
                        Unit1.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(),1).toString());
                        tampil1();
                        Unit1.requestFocus();
                    }else if(pilihan==2){
                        Unit2.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(),1).toString());
                        tampil2();
                        Unit2.requestFocus();
                    }else if(pilihan==3){
                        Unit3.setText(poli.getTable().getValueAt(poli.getTable().getSelectedRow(),1).toString());
                        tampil3();
                        Unit3.requestFocus();
                    }  
                }                
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
        
        dokter.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {}
            @Override
            public void windowClosed(WindowEvent e) {
                if(dokter.getTable().getSelectedRow()!= -1){
                    if(pilihan==1){                    
                        Dokter1.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(),1).toString());
                        tampil1();
                        Dokter1.requestFocus();
                    }else if(pilihan==2){
                        Dokter2.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(),1).toString());
                        tampil2();
                        Dokter2.requestFocus();
                    }else if(pilihan==3){
                        Dokter3.setText(dokter.getTable().getValueAt(dokter.getTable().getSelectedRow(),1).toString());
                        tampil3();
                        Dokter3.requestFocus();
                    }
                }                
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
        
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        poli.removeWindowListener(null);        
        dokter.removeWindowListener(null);
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tampil1();
        tampil2();
        tampil3();
    }//GEN-LAST:event_formWindowOpened

    private void BtnBatal4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatal4ActionPerformed
        if(!labelantri1.getText().equals("")){
            Sequel.queryu("update antripoli1 set antrian='1'");
        }            
    }//GEN-LAST:event_BtnBatal4ActionPerformed

    private void BtnBatal6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatal6ActionPerformed
        if(!labelantri3.getText().equals("")){
            Sequel.queryu("update antripoli3 set antrian='1'");
        }
    }//GEN-LAST:event_BtnBatal6ActionPerformed

    private void BtnBatal3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatal3ActionPerformed
        ppUndo3ActionPerformed(evt);
    }//GEN-LAST:event_BtnBatal3ActionPerformed

    private void BtnAntri3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAntri3ActionPerformed
        ppAntri3ActionPerformed(evt);
    }//GEN-LAST:event_BtnAntri3ActionPerformed

    private void BtnSeek7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek7ActionPerformed
        pilihan=3;
        dokter.emptTeks();

        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnSeek7ActionPerformed

    private void BtnSeek4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek4ActionPerformed
        pilihan=3;
        poli.emptTeks();

        poli.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        poli.setLocationRelativeTo(internalFrame1);
        poli.setAlwaysOnTop(false);
        poli.setVisible(true);
    }//GEN-LAST:event_BtnSeek4ActionPerformed

    private void BtnBatal5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatal5ActionPerformed
        if(!labelantri2.getText().equals("")){
            Sequel.queryu("update antripoli2 set antrian='1'");
        }
    }//GEN-LAST:event_BtnBatal5ActionPerformed

    private void BtnBatal2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatal2ActionPerformed
        ppUndo2ActionPerformed(evt);
    }//GEN-LAST:event_BtnBatal2ActionPerformed

    private void BtnAntri2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAntri2ActionPerformed

        ppAntri2ActionPerformed(evt);
    }//GEN-LAST:event_BtnAntri2ActionPerformed

    private void BtnSeek6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek6ActionPerformed
        pilihan=2;
        dokter.emptTeks();
        dokter.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        dokter.setLocationRelativeTo(internalFrame1);
        dokter.setAlwaysOnTop(false);
        dokter.setVisible(true);
    }//GEN-LAST:event_BtnSeek6ActionPerformed

    private void BtnSeek3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSeek3ActionPerformed
        pilihan=2;
        poli.emptTeks();
        poli.setSize(internalFrame1.getWidth()-20,internalFrame1.getHeight()-20);
        poli.setLocationRelativeTo(internalFrame1);
        poli.setAlwaysOnTop(false);
        poli.setVisible(true);
    }//GEN-LAST:event_BtnSeek3ActionPerformed



    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                DlgAntrian dialog = new DlgAntrian(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnAntri1;
    private widget.Button BtnAntri2;
    private widget.Button BtnAntri3;
    private widget.Button BtnBatal1;
    private widget.Button BtnBatal2;
    private widget.Button BtnBatal3;
    private widget.Button BtnBatal4;
    private widget.Button BtnBatal5;
    private widget.Button BtnBatal6;
    private widget.Button BtnDisplay;
    private widget.Button BtnKeluar;
    private widget.Button BtnSeek2;
    private widget.Button BtnSeek3;
    private widget.Button BtnSeek4;
    private widget.Button BtnSeek5;
    private widget.Button BtnSeek6;
    private widget.Button BtnSeek7;
    private javax.swing.JDialog DlgDisplay;
    private widget.TextBox Dokter1;
    private widget.TextBox Dokter2;
    private widget.TextBox Dokter3;
    private javax.swing.JPopupMenu Popup1;
    private javax.swing.JPopupMenu Popup2;
    private javax.swing.JPopupMenu Popup3;
    private javax.swing.JPopupMenu Popup4;
    private widget.ScrollPane Scroll;
    private widget.ScrollPane Scroll1;
    private widget.ScrollPane Scroll2;
    private widget.Table Table1;
    private widget.Table Table2;
    private widget.Table Table3;
    private widget.TextBox Unit1;
    private widget.TextBox Unit2;
    private widget.TextBox Unit3;
    private widget.InternalFrame form1;
    private widget.InternalFrame form2;
    private widget.InternalFrame form3;
    private widget.InternalFrame internalFrame1;
    private widget.InternalFrame internalFrame5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private widget.Label labelantri1;
    private widget.Label labelantri2;
    private widget.Label labelantri3;
    private widget.Label labeldokter1;
    private widget.Label labeldokter2;
    private widget.Label labeldokter3;
    private widget.Label labelpas1;
    private widget.Label labelpas2;
    private widget.Label labelpas3;
    private widget.Label labelruntext;
    private widget.TextBox norawat1;
    private widget.TextBox norawat2;
    private widget.TextBox norawat3;
    private usu.widget.glass.PanelGlass paneliklan;
    private widget.panelisi panelisi1;
    private widget.panelisi panelisi2;
    private widget.panelisi panelisi3;
    private widget.panelisi panelisi4;
    private widget.panelisi panelisi5;
    private widget.panelisi panelisi6;
    private widget.panelisi panelisi7;
    private javax.swing.JPanel panelruntext;
    private javax.swing.JMenuItem ppAntri1;
    private javax.swing.JMenuItem ppAntri2;
    private javax.swing.JMenuItem ppAntri3;
    private javax.swing.JMenuItem ppClose;
    private javax.swing.JMenuItem ppUndo1;
    private javax.swing.JMenuItem ppUndo2;
    private javax.swing.JMenuItem ppUndo3;
    // End of variables declaration//GEN-END:variables
    
    private void tampil1(){
        Valid.tabelKosong(tabMode1);
        try{     
            ResultSet rs=koneksi.createStatement().executeQuery("select reg_periksa.no_reg,reg_periksa.no_rkm_medis, "+
                   "pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg "+
                   "from reg_periksa inner join dokter inner join pasien inner join poliklinik "+
                   "on reg_periksa.kd_dokter=dokter.kd_dokter "+
                   "and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                   "and reg_periksa.kd_poli=poliklinik.kd_poli "+
                   "where reg_periksa.tgl_registrasi=current_date() "+
                   "and poliklinik.nm_poli='"+Unit1.getText()+"' "+
                   "and dokter.nm_dokter='"+Dokter1.getText()+"' "+
                   "and stts='Belum' "+
                   "order by reg_periksa.jam_reg asc limit 10");
            while(rs.next()){
                String[] data={rs.getString(1),
                               rs.getString(2),
                               rs.getString(3),
                               rs.getString(4),
                               rs.getString(5),
                               rs.getString(6)};
                tabMode1.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    
    private void tampil2(){
        Valid.tabelKosong(tabMode2);
        try{     
            ResultSet rs=koneksi.createStatement().executeQuery("select reg_periksa.no_reg,reg_periksa.no_rkm_medis, "+
                   "pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg "+
                   "from reg_periksa inner join dokter inner join pasien inner join poliklinik "+
                   "on reg_periksa.kd_dokter=dokter.kd_dokter "+
                   "and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                   "and reg_periksa.kd_poli=poliklinik.kd_poli "+
                   "where reg_periksa.tgl_registrasi=current_date() "+
                   "and poliklinik.nm_poli='"+Unit2.getText()+"' "+
                   "and dokter.nm_dokter='"+Dokter2.getText()+"' "+
                   "and stts='Belum' "+
                   "order by reg_periksa.jam_reg asc limit 10");
            while(rs.next()){
                String[] data={rs.getString(1),
                               rs.getString(2),
                               rs.getString(3),
                               rs.getString(4),
                               rs.getString(5),
                               rs.getString(6)};
                tabMode2.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    
    private void tampil3(){
        Valid.tabelKosong(tabMode3);
        try{
            ResultSet rs=koneksi.createStatement().executeQuery("select reg_periksa.no_reg,reg_periksa.no_rkm_medis, "+
                   "pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg "+
                   "from reg_periksa inner join dokter inner join pasien inner join poliklinik "+
                   "on reg_periksa.kd_dokter=dokter.kd_dokter "+
                   "and reg_periksa.no_rkm_medis=pasien.no_rkm_medis "+
                   "and reg_periksa.kd_poli=poliklinik.kd_poli "+
                   "where reg_periksa.tgl_registrasi=current_date() "+
                   "and poliklinik.nm_poli='"+Unit3.getText()+"' "+
                   "and dokter.nm_dokter='"+Dokter3.getText()+"' "+
                   "and stts='Belum' "+
                   "order by reg_periksa.jam_reg asc limit 10");
            while(rs.next()){
                String[] data={rs.getString(1),
                               rs.getString(2),
                               rs.getString(3),
                               rs.getString(4),
                               rs.getString(5),
                               rs.getString(6)};
                tabMode3.addRow(data);
            }
        }catch(SQLException e){
            System.out.println("Error : "+e);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        paneliklan.repaint();
        String oldText = labelruntext.getText();
        String newText = oldText.substring(1) + oldText.substring(0, 1);
        labelruntext.setText( newText );
    }
    
    private  void isTampil(){
        try{
            ResultSet rs=koneksi.createStatement().executeQuery("select teks, aktifkan, gambar from runtext");
            while(rs.next()){
                labelruntext.setText(rs.getString(1));
                if(rs.getString(2).equals("Yes")){
                    Blob blob = rs.getBlob(3);
                    paneliklan.setBackgroundImage(new javax.swing.ImageIcon(blob.getBytes(1, (int) (blob.length()))));
                    
                }
            }
        }catch(SQLException e){
            System.out.println(e+"Error : Silahkan Set Aplikasi");
        }
    } 
    
    private void panggil(int antrian){
        String[] urut={"","./suara/satu.mp3","./suara/dua.mp3","./suara/tiga.mp3","./suara/empat.mp3",
                       "./suara/lima.mp3","./suara/enam.mp3","./suara/tujuh.mp3","./suara/delapan.mp3",
                       "./suara/sembilan.mp3","./suara/sepuluh.mp3","./suara/sebelas.mp3"};
        
        if (antrian < 12){
            try {
                BackgroundMusic bm = new BackgroundMusic(urut[antrian]);
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }            
        }else if (antrian < 20){
            try {
                BackgroundMusic bm = new BackgroundMusic(urut[antrian-10]);
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            try {
                BackgroundMusic bm = new BackgroundMusic("./suara/belas.mp3");
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }else if (antrian < 100){
            try {
                BackgroundMusic bm = new BackgroundMusic(urut[antrian/10]);
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            try {
                BackgroundMusic bm = new BackgroundMusic("./suara/puluh.mp3");
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            panggil(antrian%10);
        }else if (antrian < 200){
            try {
                BackgroundMusic bm = new BackgroundMusic("./suara/seratus.mp3");
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            panggil(antrian-100);
        }else if (antrian < 1000){
            panggil(antrian/100);
            
            try {
                BackgroundMusic bm = new BackgroundMusic("./suara/ratus.mp3");
                bm.start();
                Thread.sleep(1500);
                bm.stop();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
            
            panggil(antrian%100);
        }
    }
}
