<?php
require_once ('conf/conf.php');
header("Expires: Mon, 26 Jul 1997 05:00:00 GMT");
header("Last-Modified: " . gmdate("D, d M Y H:i:s") . " GMT");
header("Cache-Control: no-store, no-cache, must-revalidate");
header("Cache-Control: post-check=0, pre-check=0", false);
header("Pragma: no-cache"); // HTTP/1.0
date_default_timezone_set("Asia/Bangkok");
$tanggal = mktime(date("m"), date("d"), date("Y"));
$jam = date("H:i");
?>
<div class="card-panel teal darken-4 white-text">
    <?php
    $_sql = "select * from antripoli2";
    $hasil = bukaquery($_sql);
    while ($data = mysqli_fetch_array($hasil)) {
        if ($data['antrian'] != "0") {
            echo "<h4>" . $data['nama_pasien'] . "</h4>";
            echo "<h4>" . $data['no_reg'] . "</h4>";
            echo "<h4>" . $data['poli'] . "</h4>";
            echo "<h4>" . $data['nama_dokter'] . "</h4>";
            echo "<script>callPasien('" . $data['no_reg'] . "','" . $data['poli'] . "');</script>";
            bukaquery2("update antripoli2 set antripoli2.antrian='0'");
        }
        if($data['antrian'] == "0"){
            echo "<h4>" . $data['nama_pasien'] . "</h4>";
            echo "<h4>" . $data['no_reg'] . "</h4>";
            echo "<h4>" . $data['poli'] . "</h4>";
            echo "<h4>" . $data['nama_dokter'] . "</h4>";
        }
    }
    ?>
</div>
</div>