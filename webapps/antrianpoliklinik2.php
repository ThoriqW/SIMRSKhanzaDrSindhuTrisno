<?php
session_start();
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
<!doctype html>
<html lang="en">

<head>
    <title>Antrian Poliklinik</title>
    <link rel="icon" href="assets/img/rs.png" type="image/x-icon">
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
    <link type="text/css" rel="stylesheet" href="assets/css/materialize.min.css" media="screen,projection" />
    <link type="text/css" rel="stylesheet" href="assets/css/jquery-ui.css" media="screen,projection" />
    <link rel="stylesheet" href="assets/css/marquee.css" />
    <link rel="stylesheet" href="assets/css/example.css" />
    <link rel="stylesheet" href="assets/css/ok.css" />
    <style type="text/css">
                h1 {
            margin: 0.5rem;
        }

        h4 {
            margin: 0.3rem;
            font-weight: bolder;
        }

        .bg {
            height: 100vh;
            background-color: #004d40 ;
            color: #fff;
        }

        table {
            font-size: 1.3rem;
            text-transform: uppercase;
        }

        /* .bg::before {
            content: '';
            background-image: url('./assets/img/operasi.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: scroll;
            position: fixed;
            z-index: -1;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            opacity: 0.10;
            filter: alpha(opacity=10);
        } */

        .card-panel {
            margin: 0.75rem;
            display: flex;
            flex-direction: column;
            align-items: center;
            text-transform: uppercase;
            border: 2px solid #26a69a;
        }

        .list-pasien-poli {
            text-align: center;
            font-weight: bolder;
        }

        .table-poli {
            border: 2px solid #26a69a;
        }

        thead tr {
            background-color: #26a69a;
            color: #fff;
        }

        .slider {
            position: relative;
            width: 100%;
            height: 100%;
        }

        .slide {
            text-align: center;
            display: none;
            position: relative;
            width: 100%;
            height: 100%;
        }

        .active-slide {
            display: block;
        }
    </style>
    <!-- Global style END -->

</head>

<body class="bg">
    <header>
        <nav class="teal darken-4">
            <div class="nav-wrapper">
                <ul class="center hide-on-med-and-down" id="nv">
                    <li>
                        <a href="./" class="ams hide-on-med-and-down"><i
                                class="material-icons md-36">local_hospital</i>Antrian Poliklinik 2</a>
                    </li>
                    <li class="right" style="margin-right: 10px;">
                        <i class="material-icons">perm_contact_calendar</i>
                        <a href="" class="white-text">
                            <?php
                            $a_hari = array(1 => "Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu");
                            $hari = $a_hari[date("N")];
                            $tanggal = date("j");
                            $a_bulan = array(1 => "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember");
                            $bulan = $a_bulan[date("n")];
                            $tahun = date("Y");
                            echo $hari . ", " . $tanggal . " " . $bulan . " " . $tahun;
                            ?>
                        </a>
                        <i class="material-icons md-12">query_builder</i>
                        <a href="" class="white-text" id="jam"></a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <main>
        <!-- <div class="container-fluid" id="judul">
        </div> -->
        <div class="container-fluid" id="data">
        </div>
    </main>

    <script type="text/javascript" src="assets/js/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="assets/js/materialize.min.js"></script>
    <script type="text/javascript" src="assets/js/jquery-ui.min.js"></script>
    <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
    <script data-pace-options='{ "ajax": false }' src='assets/js/pace.min.js'></script>
    <script type="text/javascript" src="assets/js/marquee.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            jam();
        }

        function jam() {
            var e = document.getElementById('jam'),
                d = new Date(), h, m, s;
            h = d.getHours();
            m = set(d.getMinutes());
            s = set(d.getSeconds());

            e.innerHTML = h + ':' + m + ':' + s;

            setTimeout('jam()', 1000);
        }

        function set(e) {
            e = e < 10 ? '0' + e : e;
            return e;
        }

        var slideSpeed = 9000;

        var main = function () {
            //Carousel
            setInterval(function () { timedDelay1() }, slideSpeed);
            setInterval(function () { timedDelay2() }, slideSpeed);
        };

        //timedDelay carousel function
        function timedDelay1() {

            var currentSlide = $('.active-slide1');
            var nextTimedSlide = currentSlide.next();

            var currentDot = $('.active-dot1');
            var nextDot = currentDot.next();

            if (nextTimedSlide.length === 0) {
                nextTimedSlide = $('.slide1').first();
                nextDot = $('.dot1').first();
            }

            currentSlide.fadeOut(600, function () {
                $(this).removeClass('active-slide1');
                nextTimedSlide.fadeIn(600).addClass('active-slide1');

                currentDot.removeClass('active-dot1');
                nextDot.addClass('active-dot1');
            });
        }
        //timedDelay carousel function
        function timedDelay2() {

            var currentSlide = $('.active-slide2');
            var nextTimedSlide = currentSlide.next();

            var currentDot = $('.active-dot2');
            var nextDot = currentDot.next();

            if (nextTimedSlide.length === 0) {
                nextTimedSlide = $('.slide2').first();
                nextDot = $('.dot2').first();
            }

            currentSlide.fadeOut(600, function () {
                $(this).removeClass('active-slide2');
                nextTimedSlide.fadeIn(600).addClass('active-slide2');

                currentDot.removeClass('active-dot2');
                nextDot.addClass('active-dot2');
            });
        }

        function callPasien(nomor, poli) {
            if (poli == "POLIKLINIK ANAK") {
                var poliSound = new Audio('suara/anak.mp3');
                var nomorurut;
                for (var i = 1; i <= 50; i++) {
                    if (parseInt(nomor) === i) {
                        nomorurut = new Audio('suara/' + i + '.mp3');
                        nomorurut.onended = function () {
                            poliSound.play();
                        };
                        nomorurut.play();
                        break;
                    }
                }
            }
            if (poli == "POLIKLINIK KULIT DAN KELAMIN") {
                var poliSound = new Audio('suara/kulkel.mp3');
                var nomorurut;
                for (var i = 1; i <= 50; i++) {
                    if (parseInt(nomor) === i) {
                        nomorurut = new Audio('suara/' + i + '.mp3');
                        nomorurut.onended = function () {
                            poliSound.play();
                        };
                        nomorurut.play();
                        break;
                    }
                }
            }
            if (poli == "POLIKLINIK JANTUNG") {
                var poliSound = new Audio('suara/jantung.mp3');
                var nomorurut;
                for (var i = 1; i <= 50; i++) {
                    if (parseInt(nomor) === i) {
                        nomorurut = new Audio('suara/' + i + '.mp3');
                        nomorurut.onended = function () {
                            poliSound.play();
                        };
                        nomorurut.play();
                        break;
                    }
                }
            }
        }

        $(document).ready(main);
    </script>
    <script type="text/javascript" src="assets/js/jquery.js"></script>
    <script type="text/javascript">
        var auto_refresh = setInterval(
            function () {
                $('#data').load('data_antrianpoliklinik2.php').fadeIn("fast");
            }, 18000
        );
        var auto_refresh = setInterval(
            function () {
                $('#judul').load('data_antrianpoliklinikjudul2.php').fadeIn("fast");
            }, 2000
        );
        $('#judul').load('data_antrianpoliklinikjudul2.php').fadeIn("fast");
        $('#data').load('data_antrianpoliklinik2.php').fadeIn("fast");
    </script>
</body>

</html>