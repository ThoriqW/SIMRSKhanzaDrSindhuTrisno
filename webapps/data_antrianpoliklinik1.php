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
<div class="row container-pasien">
    <div class="col s6 list-pasien-poli">
        <div class="slider">
            <div class="slide slide1 active-slide active-slide1">
                <h1>POLIKLINIK BEDAH</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK BEDAH' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
            <div class="slide slide1">
                <h1>POLIKLINIK SARAF</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK SARAF' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
            <div class="slide slide1">
                <h1>POLIKLINIK GIGI ENDODONSI</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK GIGI ENDODONSI' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
            <div class="slide slide1">
                <h1>POLIKLINIK PENYAKIT DALAM</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK PENYAKIT DALAM' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <div class="col s6 list-pasien-poli">
        <div class="slider">
            <div class="slide slide2 active-slide active-slide2">
                <h1>POLIKLINIK GIGI DAN MULUT</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK GIGI DAN MULUT' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
            <div class="slide slide2">
                <h1>POLIKLINIK THT</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK THT' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
            <div class="slide slide2">
                <h1>POLIKLINIK GIGI PERIODONTI</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK GIGI PERIODONTI' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
            <div class="slide slide2">
                <h1>POLIKLINIK OBGYN</h1>
                <table class="responsive-table table-poli">
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Dokter</th>
                            <th>No</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $_sql = "select reg_periksa.no_reg,reg_periksa.no_rkm_medis,pasien.nm_pasien,reg_periksa.no_rawat,dokter.nm_dokter,reg_periksa.jam_reg 
                        from reg_periksa inner join dokter inner join pasien inner join poliklinik on reg_periksa.kd_dokter=dokter.kd_dokter 
                        and reg_periksa.no_rkm_medis=pasien.no_rkm_medis 
                        and reg_periksa.kd_poli=poliklinik.kd_poli 
                        where reg_periksa.tgl_registrasi=current_date() 
                        and poliklinik.nm_poli='POLIKLINIK OBGYN' 
                        and stts='Belum' 
                        order by reg_periksa.no_reg asc limit 15";
                        $hasil = bukaquery($_sql);

                        if (mysqli_num_rows($hasil) > 0) {
                            while ($data = mysqli_fetch_array($hasil)) {
                                echo "<tr class='isi7'>
                                      <td>" . $data['nm_pasien'] . "</td>
                                      <td>" . $data['nm_dokter'] . "</td>
                                      <td>" . $data['no_reg'] . "</td>
                                  </tr>";
                            }
                            if(mysqli_num_rows($hasil) > 14){
                                echo "<td>.  .  .  .  .  .  .</td>";
                            }
                        } else {
                            echo "<td>TIDAK ADA ANTRIAN</td>";
                        }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>