<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Home</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- Meta tag Keywords -->
<!-- css files -->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all">
<link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<!-- //css files -->
<!-- online-fonts -->
<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&subset=latin-ext,vietnamese" rel="stylesheet">
<link href="http://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900iSource+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i&subset=cyrillic,cyrillic-ext,greek,greek-ext,latin-ext,vietnamese" rel="stylesheet">
<!-- js -->
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<!-- //js -->
<script type="text/javascript" src="js/bootstrap-3.1.1.min.js"></script>

	<script src="js/jquery.chocolat.js"></script>
	<link rel="stylesheet" href="css/chocolat.css" type="text/css" media="screen">
	<!--light-box-files -->
	<script>
	$(function() {
		$('.gallery-grid a').Chocolat();
	});
	</script>

<!-- //js -->
<script src="js/responsiveslides.min.js"></script>
	<script>
			$(function () {
				$("#slider").responsiveSlides({
					auto: true,
					pager:false,
					nav: true,
					speed: 1000,
					namespace: "callbacks",
					before: function () {
						$('.events').append("<li>before event fired.</li>");
					},
					after: function () {
						$('.events').append("<li>after event fired.</li>");
					}
				});
			});
		</script>
		

<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
jQuery(document).ready(function($) {
	$(".scroll").click(function(event){		
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
	});
});
</script>
<!-- start-smoth-scrolling -->



</head>
<body>
<div class="header" id="home">
<div class="logo">
	<a href="#"><h1>Education Hub</h1></a>
</div>
<!-- navigation -->
	<div class="ban-top-con">
		<div class="top_nav_left">
			<nav class="navbar navbar-default">
			  <div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
				  <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				  </button>
				</div>
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse menu--shylock" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav menu__list">
						<li class="active menu__item menu__item--current"><a class="menu__link" href="index.html">HOME <span class="sr-only">(current)</span></a></li>
						<li class=" menu__item"><a class="menu__link scroll" href="#about">About ZHBIT</a></li>
						<li class=" menu__item"><a class="menu__link scroll" href="#management">Faculty</a></li>
						<li class=" menu__item"><a class="menu__link scroll" href="#activities">Activities</a></li>
						<li class=" menu__item"><a class="menu__link scroll" href="#faculties">Faculties</a></li>
						<li class=" menu__item"><a class="menu__link scroll" href="#contact">CONTACT US</a></li>
					</ul>
				</div>
			  </div>
			</nav>	
			
		</div>
		<div class="clearfix"></div>
		</div>
<!-- //navigation -->
<!-- Slider -->
	<div class="slider">
		<div class="callbacks_container">
			<ul class="rslides" id="slider">
				<li>
					<div class="slider-img">
						<img src="images/bg2.jpg" class="img-responsive" alt="education">
					</div>
					<div class="slider-info">
						<h3>Education</h3>
						<p>Education is the most powerful weapon which you can use to change the world.</p>
					</div>
				</li>
				<li>
					<div class="slider-img">
						<img src="images/bg3.jpg" class="img-responsive" alt="education">
					</div>
					<div class="slider-info">
						<h3>Education</h3>
						<p>The purpose of education is to replace   an empty mind with an open one.</p>
					</div>
				</li>
				<li>
					<div class="slider-img">
						<img src="images/bg1.jpg" class="img-responsive" alt="education">
					</div>
					<div class="slider-info">
						<h3>Education</h3>
						<p>Education is the most powerful weapon which you can use to change the world.</p>
					</div>
				</li>
				<li>
					<div class="slider-img">
						<img src="images/bg4.jpg" class="img-responsive" alt="education">
					</div>
					<div class="slider-info">
						<h3>Education</h3>
						<p>The purpose of education is to replace   an empty mind with an open one.</p>
					</div>
				</li>
				<li>
					<div class="slider-img">
						<img src="images/bg5.jpg" class="img-responsive" alt="education">
					</div>
					<div class="slider-info">
						<h3>Education</h3>
						<p>The goal of education is the advancement of knowledge and the dissemination of truth.</p>
					</div>
				</li>
			</ul>
		</div>
		<div class="clearfix"></div>
	</div>
	<!-- //Slider -->
</div>
<!--main-content-->
<div class="agile-main" id="about">
<div class="container">
	<div class="about">
		<h2>about ZHBIT</h2>
		<h4>BITZH is located in the City of Zhuhai, Guangdong Province, next to Macau and Hong Kong, easily accessible via Beijing-Hongkong-Macau highway, West Guangdong highway, Guangzhou-Zhuhai express train and also by air travel. The campus covers a scenic area of over 3.3 million square meters with more than 80% of green coverage. It has a reputation for being one of the most naturally beautiful campuses in Zhuhai.
		</h4>
		<img src="images/su.jpg" alt="sucess">
		<p>"On May 8, 2004, BITZH was jointly established by Beijing Institute of Technology (BIT) and Guangda Strategic Investment Co., Ltd under the approval of the Ministry of Education of the People’s Republic of China and with the support of Zhuhai Municipal Government. BITZH is a legally and financially independent college and an academic affiliated college of BIT.
			".</p>
		<p>" With the cultural tradition and high-qualifying teaching resources derived from BIT, BITZH is committed to cultivating the overall quality of talented students to meet the needs of the economic development and the society. BITZH strives to turn itself into a top-notch applied university which attaches great importance to the construction of disciplines and majors such as engineering, management, liberal arts, economics, law, art and so on.". </p>
	</div>
	<div class="clearfix"></div>
<!--//about-->
</div>
</div>
<!--meet our management-->
<div class="team" id="management">
	<div class="container">
		<h3>meet our faculty</h3>
		<p>With strong teachers and hardware and software resources..</p>
		<div class="w3grids">
			<div class="w3grid col-md-3">
				<img src="images/t1.jpg" alt="team1" class="img1-w3l">
				<h5>Jenny </h5>
				<p>Key teachers at the first level in Cambridge for 10 years.</p>
				<div class="socialw3-icons">
					<i class=" so1 fa fa-facebook" aria-hidden="true"></i>
					<i class=" so2 fa fa-twitter" aria-hidden="true"></i>
					<i class=" so3 fa fa-google" aria-hidden="true"></i>
				</div>
			</div>
			<div class="w3grid col-md-3">
				<img src="images/t2.jpg" alt="team1" class="img2-w3l">
				<h5>JadeDoe</h5>
				<p>Key teachers at the first level in Cambridge for 14 years.</p>
				<div class="socialw3-icons">
					<i class=" so1 fa fa-facebook" aria-hidden="true"></i>
					<i class=" so2 fa fa-twitter" aria-hidden="true"></i>
					<i class=" so3 fa fa-google" aria-hidden="true"></i>
				</div>
			</div>
			<div class="w3grid col-md-3">
				<img src="images/t3.jpg" alt="team1" class="img3-w3l">
				<h5>James Doe</h5>
				<p>Key teachers at the first level in Cambridge for 18 years.</p>
				<div class="socialw3-icons">
					<i class=" so1 fa fa-facebook" aria-hidden="true"></i>
					<i class=" so2 fa fa-twitter" aria-hidden="true"></i>
					<i class=" so3 fa fa-google" aria-hidden="true"></i>
				</div>
			</div>
			<div class="w3grid col-md-3">
				<img src="images/t4.jpg" alt="team1" class="img4-w3l">
				<h5>Hailey joy</h5>
				<p>Key teachers at the first level in Cambridge for 5 years.</p>
				<div class="socialw3-icons">
					<i class=" so1 fa fa-facebook" aria-hidden="true"></i>
					<i class=" so2 fa fa-twitter" aria-hidden="true"></i>
					<i class=" so3 fa fa-google" aria-hidden="true"></i>
				</div>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
</div>
<!--//meet our management-->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/" >手机网站模板</a></div>
<!--welcome-->

<div class="gallery" id="activities">
	<div class="container">
		<div class="gallery-main">
			<div class="gallery-top">
				<h3>Education NEWS</h3>
			</div>
			<div class="gallery-bott">
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g1.jpg" class="b-link-stripe b-animate-go  thickbox">

						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g1.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“University of Windsor Visited BITZH and Signed Cooperation Agreement.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g2.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g2.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“Information Session by Ashland University Successfully Held in BITZH.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g3.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g3.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“Deputy Vice Chancellor of the National Energy University Visits BITZH.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g4.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g4.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“College of Arts and Sciences, University of Kentucky, USA Visits SINO-US College BITZH.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g5.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g5.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“University of Leicester Visits BITZH.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g6.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g6.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“BITZH Visits American University of Sharjah.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g7.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g7.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“University of Alabama in Huntsville Visits BITZH.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g8.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g8.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“BITZH’s Delegation VisitsUK Partner Universities.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="col-md-4 col1 gallery-grid">
					<a href="images/g9.jpg" class="b-link-stripe b-animate-go  thickbox">
						<figure class="effect-bubba">
							<img class="img-responsive" src="images/g9.jpg" alt="">
							<figcaption>
								<h4 class="gal">Educational NEWS</h4>
								<p class="gal1">“The First Board Meeting Successfully Held for the Alliance of Design and Art Schools.” </p>
							</figcaption>
						</figure>
					</a>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
</div>
<!--//activities-->

<!-- opening -->
<div class="agile-open">
<div class="open-head">
	<h6>our university opening in</h6>
	<p>“A university is just a group of buildings gathered around a library.” </p>
</div>
<!-- Countdown-timer -->

			<div class="examples">
				<div class="simply-countdown-losange" id="simply-countdown-losange"></div>
			</div>
	
		<div class="clearfix"></div>

<!-- //Countdown-timer -->

<!-- Custom-JavaScript-File-Links -->
<!-- Countdown-Timer-JavaScript -->
		<script src="js/simplyCountdown.js"></script>
		<script>
			var d = new Date(new Date().getTime() + 48 * 120 * 120 * 2000);

			// default example
			simplyCountdown('.simply-countdown-one', {
				year: d.getFullYear(),
				month: d.getMonth() + 1,
				day: d.getDate()
			});

			// inline example
			simplyCountdown('.simply-countdown-inline', {
				year: d.getFullYear(),
				month: d.getMonth() + 1,
				day: d.getDate(),
				inline: true
			});

			//jQuery example
			$('#simply-countdown-losange').simplyCountdown({
				year: d.getFullYear(),
				month: d.getMonth() + 1,
				day: d.getDate(),
				enableUtc: false
			});
		</script>
		
	<!-- //Countdown-Timer-JavaScript -->
<!-- //Custom-JavaScript-File-Links -->
</div>	
<!--// opening -->

<!--faculty-->
<div class="w3-faculty" id="faculties">
<div class="container">
	<div class="faculty-head">
		<h5>our great faculties</h5>
		<p>“Books are the quietest and most constant of friends; they are the most accessible and wisest of counselors, and the most patient of teachers.” </p>
	</div>
	<div class="main-faculty">
		<div class="f1 col-md-3 faculty1">
			<ul class="demo-2 effect">
				<li>
				   <h3 class="zero">COMPUTER SCIENCE</h3>
				   <p class="zero">Lorem ipsum dolor sit amet.</p>
				</li>
				 <li><img class="top" src="images/f1.jpg" alt=""/></li>
			</ul>
			<h4>John Roy</h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
			<div class="social-icons">
				<i class="s1 fa fa-facebook" aria-hidden="true"></i>
				<i class="s2 fa fa-twitter" aria-hidden="true"></i>
				<i class="s3 fa fa-google" aria-hidden="true"></i>
			</div>
		</div>
		<div class="f2 col-md-3 faculty1">
			<ul class="demo-2 effect">
				<li>
				   <h3 class="zero">COMMUNICATION SKILLS</h3>
				   <p class="zero">Lorem ipsum dolor sit amet.</p>
				</li>
				 <li><img class="top" src="images/f6.jpg" alt=""/></li>
			</ul>
			<h4>Jesse Roy</h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
			<div class="social-icons">
				<i class=" s1 fa fa-facebook" aria-hidden="true"></i>
				<i class=" s2 fa fa-twitter" aria-hidden="true"></i>
				<i class=" s3 fa fa-google" aria-hidden="true"></i>
			</div>
		</div>
		<div class="f3 col-md-3 faculty1">
			<ul class="demo-2 effect">
				<li>
				   <h3 class="zero">GENERAL SCIENCE</h3>
				   <p class="zero">Lorem ipsum dolor sit amet.</p>
				</li>
				 <li><img class="top" src="images/f3.jpg" alt=""/></li>
			</ul>
			<h4>Xena Wob</h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
			<div class="social-icons">
				<i class=" s1 fa fa-facebook" aria-hidden="true"></i>
				<i class=" s2 fa fa-twitter" aria-hidden="true"></i>
				<i class=" s3 fa fa-google" aria-hidden="true"></i>
			</div>
		</div>
		<div class="f4 col-md-3 faculty1">
			<ul class="demo-2 effect">
				<li>
				   <h3 class="zero">MATHEMATICS</h3>
				   <p class="zero">Lorem ipsum dolor sit amet.</p>
				</li>
				 <li><img class="top" src="images/f4.jpg" alt=""/></li>
			</ul>
			<h4>Victor Hi</h4>
			<p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
			<div class="social-icons">
				<i class="s1 fa fa-facebook" aria-hidden="true"></i>
				<i class="s2 fa fa-twitter" aria-hidden="true"></i>
				<i class="s3 fa fa-google" aria-hidden="true"></i>
			</div>
		</div>
		
		<div class="clearfix"></div>
	</div>
</div>
</div>
<!--//faculty-->

<!--contact-->
<div class="agile-contact" id="contact">
<div class="left-contact">

		<h6>contact us</h6>
		<ul>
			<li><i class="fa fa-envelope" aria-hidden="true"></i><a href="mailto:info@example.com">info@example.com</a></li>
			<li><i class="fa fa-phone" aria-hidden="true"></i>+2158 85467</li>
			<li><i class="fa fa-map-marker" aria-hidden="true"></i>BD 2 Mars, N° 136, Morocco Casablanca</li>
		</ul>

</div>
<div class="right-contact">
	<div class="map">
		<iframe src="" frameborder="0" style="border:0" allowfullscreen></iframe>
		<form action="#" method="post">
			<input placeholder="Name" name="Name" class="name" type="text" required=""><br>
			<input placeholder="E-mail" name="Name" class="name" type="text" required=""><br>
			<textarea placeholder="Message"></textarea><br>
			<input type="submit" value="send message">
		</form>
	</div>
</div>
<div class="clearfix"></div>
</div>
<!--//contact-->
<!--//main-content-->

<!--footer-->
<div class="w3l-footer">
<div class="container">
	<div class="left-w3">
		<a href="#">education hub</a>
	</div>
	<div class="right-social">
		<i class="fa fa-facebook-square" aria-hidden="true"></i>
		<i class="fa fa-twitter-square" aria-hidden="true"></i>
		<i class="fa fa-google-plus-square" aria-hidden="true"></i>
	</div>
	<div class="clearfix"></div>
	<div class="footer-nav">
		<ul>
			<li><a class="menu__link scroll" href="#home">home</a></li>
			<li><a class="menu__link scroll" href="#about">about</a></li>
			<li><a class="menu__link scroll" href="#management">management</a></li>
			<li><a class="menu__link scroll" href="#activities">activities</a></li>
			<li><a class="menu__link scroll" href="#faculties">faculties</a></li>
			<li><a class="menu__link scroll" href="#contact">contact</a></li>
		</ul>
	</div>
	<div class="copyright-agile">
		<p>Copyright &copy; 2016.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
	</div>
</div>
</div>
<!--//footer-->
<!-- smooth scrolling -->
<script type="text/javascript">
	$(document).ready(function() {
	/*
		var defaults = {
		containerID: 'toTop', // fading element id
		containerHoverID: 'toTopHover', // fading element hover id
		scrollSpeed: 1200,
		easingType: 'linear' 
		};
	*/								
	$().UItoTop({ easingType: 'easeOutQuart' });
	});
</script>
<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!-- //smooth scrolling -->
</body>
</html>