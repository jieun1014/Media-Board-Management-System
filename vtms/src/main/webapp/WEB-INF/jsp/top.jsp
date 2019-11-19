<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<meta charset="utf-8">
	    <meta http-equiv="x-ua-compatible" content="ie=edge">
	    <title>미디어 보드 관리 시스템</title>
	    <meta name="description" content="">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <!-- favicon
			============================================ -->
	    <link rel="shortcut icon" type="image/x-icon" href="img/favicon.ico">
	    <!-- Google Fonts
			============================================ -->
	    <link href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,700,900" rel="stylesheet">
	    <!-- Bootstrap CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/bootstrap.min.css">
	    <!-- font awesome CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/font-awesome.min.css">
	    <!-- owl.carousel CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/owl.carousel.css">
	    <link rel="stylesheet" href="/assets/css/owl.theme.css">
	    <link rel="stylesheet" href="/assets/css/owl.transitions.css">
	    <!-- meanmenu CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/meanmenu/meanmenu.min.css">
	    <!-- animate CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/animate.css">
	    <!-- normalize CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/normalize.css">
		<!-- wave CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/wave/waves.min.css">
	    <link rel="stylesheet" href="/assets/css/wave/button.css">
	    <!-- mCustomScrollbar CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/scrollbar/jquery.mCustomScrollbar.min.css">
	    <!-- Notika icon CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/notika-custom-icon.css">
	    <!-- main CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/main.css">
	    <!-- style CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/style.css">
	    <!-- responsive CSS
			============================================ -->
	    <link rel="stylesheet" href="/assets/css/responsive.css">
	    <!-- modernizr JS
			============================================ -->
	    <script src="/assets/js/vendor/modernizr-2.8.3.min.js"></script>
	    <!-- bootstrap select CSS
			============================================ -->
    	<link rel="stylesheet" href="/assets/css/bootstrap-select/bootstrap-select.css">
	</head>

	<body>
	    <!--[if lt IE 8]>
	            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
	        <![endif]-->
	    <!-- Start Header Top Area -->
	    <div class="header-top-area">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
	                    <div class="logo-area">
	                        <a href="<%= this.getServletContext().getContextPath()%>/device"><img src="/assets/img/logo/logo.png" alt="" /></a>
	                    </div>
	                </div>
	                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
	                    <div class="header-top-menu">
	                        <ul class="nav navbar-nav notika-top-nav">
	                            <li class="nav-item dropdown">
	                                <a href="<%= this.getServletContext().getContextPath()%>/logout" style="">로그아웃</a>
	                            </li>
	                        </ul>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
	    <!-- End Header Top Area -->
	    <!-- Main Menu area start-->
	    <div class="main-menu-area mg-tb-40">
	        <div class="container">
	            <div class="row">
	                <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	                    <ul class="nav nav-tabs notika-menu-wrap menu-it-icon-pro">
	                        <li class="active"><a data-toggle="tab" href="#Home">디바이스 정보 관리</a></li>
	                        <li><a data-toggle="tab" href="#mailbox">전송 이력</a></li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </div>
	    <!-- Main Menu area End-->
