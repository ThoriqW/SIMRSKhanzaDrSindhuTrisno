<?php
    if(strpos($_SERVER['REQUEST_URI'],"pages")){
        exit(header("Location:../index.php"));
    }
    
    $_sql    = "SELECT * FROM set_tahun";
    $hasil   = bukaquery($_sql);
    $baris   = mysqli_fetch_row($hasil);
    $tahun   = empty($baris[0])?date("Y"):$baris[0];
    $bulan   = empty($baris[1])?date("m"):$baris[1];
?>

<div id="post">
    <div align="center" class="link">
        <a href=?act=ListAkte>| List Akte |</a>
        <a href=?act=HomeAdmin>| Menu Utama |</a>
    </div>  
    <div class="entry">
        <form name="frm_pelatihan" onsubmit="return validasiIsi();" method="post" action="" enctype=multipart/form-data>
            <?php
                $action          = isset($_GET['action'])?$_GET['action']:NULL;
                $pendapatan_akte = 0;
                if($action == "UBAH"){
                    $_sql               = "SELECT set_akte.pendapatan_akte,set_akte.persen_rs,set_akte.bagian_rs,set_akte.persen_kry,set_akte.bagian_kry FROM set_akte WHERE set_akte.tahun='$tahun' and set_akte.bulan='$bulan'";
                    $hasil              = bukaquery($_sql);
                    $baris              = mysqli_fetch_row($hasil);
                    $pendapatan_akte    = $baris[0];
                    $persen_rs          = $baris[1];
                    $bagian_rs          = $baris[2];
                    $persen_kry         = $baris[3];
                    $bagian_kry         = $baris[4];
                }
                echo"<input type=hidden name=pendapatan_akte value=$pendapatan_akte><input type=hidden name=action value=$action>";
            ?>
            <table width="100%" align="center">
                <tr class="head">
                    <td width="31%" >Pendapatan Akte</td><td width="">:</td>
                    <td width="67%">Rp.<input name="pendapatan_akte" class="text" onkeydown="setDefault(this, document.getElementById('MsgIsi1'));" type=text id="TxtIsi1" class="inputbox" value="<?php echo $pendapatan_akte;?>" size="30" maxlength="15" pattern="[0-9-]{1,15}" title=" 0-9- (Maksimal 15 karakter)" autocomplete="off" autofocus>
                    <span id="MsgIsi1" style="color:#CC0000; font-size:10px;"></span>
                    </td>
                </tr>
                <tr class="head">
                    <td width="31%" >Prosentase RS</td><td width="">:</td>
                    <td width="67%"><input name="persen_rs" class="text" onkeydown="setDefault(this, document.getElementById('MsgIsi2'));" type=text id="TxtIsi2" class="inputbox" value="<?php echo $persen_rs;?>" size="10" maxlength="6" pattern="[0-9-]{1,6}" title=" 0-9- (Maksimal 6 karakter)" autocomplete="off"/>%
                    <span id="MsgIsi2" style="color:#CC0000; font-size:10px;"></span>
                    </td>
                </tr>
                <tr class="head">
                    <td width="31%" >Prosentase Kry</td><td width="">:</td>
                    <td width="67%"><input name="persen_kry" class="text" onkeydown="setDefault(this, document.getElementById('MsgIsi3'));" type=text id="TxtIsi3" class="inputbox" value="<?php echo $persen_kry;?>" size="10" maxlength="6" pattern="[0-9-]{1,6}" title=" 0-9- (Maksimal 6 karakter)" autocomplete="off"/>%
                    <span id="MsgIsi3" style="color:#CC0000; font-size:10px;"></span>
                    </td>
                </tr>
            </table>
            <div align="center"><input name=BtnSimpan type=submit class="button" value="SIMPAN">&nbsp<input name=BtnKosong type=reset class="button" value="KOSONG"></div>
            <?php
                $BtnSimpan=isset($_POST['BtnSimpan'])?$_POST['BtnSimpan']:NULL;
                if (isset($BtnSimpan)) {
                    $pendapatan_akte    = trim($_POST['pendapatan_akte']);
                    $pendapatan_akte    = validangka($pendapatan_akte);
                    $persen_rs          = trim($_POST['persen_rs']);
                    $persen_rs          = validangka($persen_rs);
                    $persen_kry         = trim($_POST['persen_kry']);
                    $persen_kry         = validangka($persen_kry);
                    if ((isset($pendapatan_akte))&&(isset($persen_rs))&&(isset($persen_kry))) {
                        @$bagian_rs          = ($persen_rs/100)*$pendapatan_akte;
                        @$bagian_kry         = ($persen_kry/100)*$pendapatan_akte;
                        switch($action) {
                            case "TAMBAH":
                                Tambah(" set_akte ","'$tahun','$bulan','$pendapatan_akte','$persen_rs','$bagian_rs','$persen_kry','$bagian_kry' ", " Pendapatan Akte" );
                                echo"<html><head><title></title><meta http-equiv='refresh' content='1;URL=?act=InputAkte&action=TAMBAH'></head><body></body></html>";
                                break;
                            case "UBAH":
                                Ubah(" set_akte ","pendapatan_akte='$pendapatan_akte',persen_rs='$persen_rs',bagian_rs='$bagian_rs',persen_kry='$persen_kry',
                                                bagian_kry='$bagian_kry' WHERE tahun='$tahun' and bulan='$bulan'  ", " Pendapatan Akte");
                                echo"<html><head><title></title><meta http-equiv='refresh' content='2;URL=?act=ListAkte'></head><body></body></html>";
                                break;
                        }
                    }else{
                        echo 'Semua field harus isi..!!';
                    }
                }
            ?>
        </form>
    </div>
</div>
