<%@ page language="java" import="java.util.*" pageEncoding="utf-8"  contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<!-- saved from url=(0027)http://www.moemao.com/krsma/ -->
<html>
 <!--<![endif]-->
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
  <meta charset="UTF-8" />
  <title>乖离性百万亚瑟王 自助招待系统 | 乖離性ミリオンアーサー</title>
  <script type="text/javascript" async="" src="<%=basePath%>resources/mar/invite/conversion_async.js"></script>
  <script type="text/javascript" async="" src="<%=basePath%>resources/mar/invite/analytics.js"></script>
  <script type="text/javascript" async="" src="<%=basePath%>resources/mar/invite/cse.js"></script>
  <script async="" src="<%=basePath%>resources/mar/invite/gtm.js"></script>
  <script src="<%=basePath%>resources/mar/invite/html5media.min.js"></script>
  <meta content="authenticity_token" name="csrf-param" /> 
  <meta content="0GzJWtkVKEK3qgfeGcNf/3g+P0lsjt1S98NW53Fnjk0=" name="csrf-token" />
  <meta content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=no" name="viewport" />
  <meta content="乖離性ミリオンアーサーの招待！" name="description" />
  <meta content="乖離性ミリオンアーサー,ミリオンアーサー,招待" name="keywords" />
  <meta content="summary" property="twitter:card" />
  <link rel="shortcut icon" href="favicon.ico">
  <link href="<%=basePath%>resources/mar/invite/style.css" media="all" rel="stylesheet" />
  <!--[if lt IE 9]><script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
  <link type="text/css" href="<%=basePath%>resources/mar/invite/default+ja.css" rel="stylesheet" />
  <link type="text/css" href="<%=basePath%>resources/mar/invite/minimalist.css" rel="stylesheet" />
  <link type="text/css" href="<%=basePath%>resources/mar/adaptive-placeholders/style.css" rel="stylesheet">
  <script type="text/javascript" src="<%=basePath%>resources/mar/invite/default+ja.I.js"></script>
  <style type="text/css">
    .gsc-control-cse {
    font-family: Arial, sans-serif;
    border-color: #FFFFFF;
    background-color: #FFFFFF;
    }
    .gsc-control-cse .gsc-table-result {
    font-family: Arial, sans-serif;
    }
    input.gsc-input {
    border-color: #BBBBBB;
    }
    input.gsc-search-button {
    border-color: #000000;
    background-color: #333333;
    }
    .gsc-tabHeader.gsc-tabhInactive {
    border-color: #777777;
    background-color: #777777;
    }
    .gsc-tabHeader.gsc-tabhActive {
    border-color: #333333;
    background-color: #333333;
    }
    .gsc-tabsArea {
    border-color: #333333;
    }
    .gsc-webResult.gsc-result,
    .gsc-results .gsc-imageResult {
    border-color: #FFFFFF;
    background-color: #FFFFFF;
    }
    .gsc-webResult.gsc-result:hover,
    .gsc-imageResult:hover {
    border-color: #000000;
    background-color: #FFFFFF;
    }
    .gsc-webResult.gsc-result.gsc-promotion:hover {
    border-color: #000000;
    background-color: #FFFFFF;
    }
    .gs-webResult.gs-result a.gs-title:link,
    .gs-webResult.gs-result a.gs-title:link b,
    .gs-imageResult a.gs-title:link,
    .gs-imageResult a.gs-title:link b {
    color: #444444;
    }
    .gs-webResult.gs-result a.gs-title:visited,
    .gs-webResult.gs-result a.gs-title:visited b,
    .gs-imageResult a.gs-title:visited,
    .gs-imageResult a.gs-title:visited b {
    color: #444444;
    }
    .gs-webResult.gs-result a.gs-title:hover,
    .gs-webResult.gs-result a.gs-title:hover b,
    .gs-imageResult a.gs-title:hover,
    .gs-imageResult a.gs-title:hover b {
    color: #444444;
    }
    .gs-webResult.gs-result a.gs-title:active,
    .gs-webResult.gs-result a.gs-title:active b,
    .gs-imageResult a.gs-title:active,
    .gs-imageResult a.gs-title:active b {
    color: #777777;
    }
    .gsc-cursor-page {
    color: #444444;
    }
    a.gsc-trailing-more-results:link {
    color: #444444;
    }
    .gs-webResult .gs-snippet,
    .gs-imageResult .gs-snippet,
    .gs-fileFormatType {
    color: #333333;
    }
    .gs-webResult div.gs-visibleUrl,
    .gs-imageResult div.gs-visibleUrl {
    color: #000000;
    }
    .gs-webResult div.gs-visibleUrl-short {
    color: #000000;
    }
    .gs-webResult div.gs-visibleUrl-short {
    display: none;
    }
    .gs-webResult div.gs-visibleUrl-long {
    display: block;
    }
    .gs-promotion div.gs-visibleUrl-short {
    display: none;
    }
    .gs-promotion div.gs-visibleUrl-long {
    display: block;
    }
    .gsc-cursor-box {
    border-color: #FFFFFF;
    }
    .gsc-results .gsc-cursor-box .gsc-cursor-page {
    border-color: #777777;
    background-color: #FFFFFF;
    color: #444444;
    }
    .gsc-results .gsc-cursor-box .gsc-cursor-current-page {
    border-color: #333333;
    background-color: #333333;
    color: #444444;
    }
    .gsc-webResult.gsc-result.gsc-promotion {
    border-color: #CCCCCC;
    background-color: #E6E6E6;
    }
    .gsc-completion-title {
    color: #444444;
    }
    .gsc-completion-snippet {
    color: #333333;
    }
    .gs-promotion a.gs-title:link,
    .gs-promotion a.gs-title:link *,
    .gs-promotion .gs-snippet a:link {
    color: #0000CC;
    }
    .gs-promotion a.gs-title:visited,
    .gs-promotion a.gs-title:visited *,
    .gs-promotion .gs-snippet a:visited {
    color: #0000CC;
    }
    .gs-promotion a.gs-title:hover,
    .gs-promotion a.gs-title:hover *,
    .gs-promotion .gs-snippet a:hover {
    color: #444444;
    }
    .gs-promotion a.gs-title:active,
    .gs-promotion a.gs-title:active *,
    .gs-promotion .gs-snippet a:active {
    color: #00CC00;
    }
    .gs-promotion .gs-snippet,
    .gs-promotion .gs-title .gs-promotion-title-right,
    .gs-promotion .gs-title .gs-promotion-title-right * {
    color: #333333;
    }
    .gs-promotion .gs-visibleUrl,
    .gs-promotion .gs-visibleUrl-short {
    color: #00CC00;
    }
    .gsc-input input.gsc-input {
    background: none repeat scroll 0% 0% white !important;
    }
    #inviteCode
    {
        margin-left: 20px;
        margin-top: 18px;
    }
    #password
    {
        margin-left: 30px;
        margin-top: 18px;
        width: 510px;
    }
    #inviteCodeLabel
    {
        margin-left: 10px;
        font-size: 14px;
    }
    #passwordLabel
    {
        margin-left: 20px;
        font-size: 14px;
    }
</style>
 </head>
 <body>
  <!--Google Tag Manager-->
  <noscript>
   &lt;iframe height=&quot;0&quot; src=&quot;//www.googletagmanager.com/ns.html?id=GTM-KK989P&quot; style=&quot;display:none;visibility:hidden&quot; width=&quot;0&quot;&gt;&lt;/iframe&gt;
  </noscript>
  <script type="text/javascript">(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-KK989P');</script>
  <!--End Google Tag Manager-->
  <div id="wrapper">
   <div id="sqexHeader-black">
    <a href="http://www.square-enix.com/jp/" id="sqexlogo" target="_blank"><img alt="SQUARE ENIX" border="0" height="14" src="<%=basePath%>resources/mar/invite/logo-black.gif" width="130" /></a>
   </div>
   <div id="container" style="margin: 50px 0px; opacity: 1;">
    <div id="bg_line_e">
     <div id="bg_line">
      <img alt="Bg gold lt" class="bg_lt" src="<%=basePath%>resources/mar/invite/bg_gold_lt.png" />
      <img alt="Bg gold rt" class="bg_rt" src="<%=basePath%>resources/mar/invite/bg_gold_rt.png" />
      <img alt="Bg gold lb" class="bg_lb" src="<%=basePath%>resources/mar/invite/bg_gold_lb.png" />
      <img alt="Bg gold rb" class="bg_rb" src="<%=basePath%>resources/mar/invite/bg_gold_rb.png" />
      <div id="bg_light">
       <div class="twinkle" id="twinkle1"></div>
       <div class="twinkle" id="twinkle2"></div>
       <div data-pjax-container="true" id="contents" style="opacity: 1;">
        <section class="indexPage">
         <h1><span>乖离性MA 自助招待系统</span></h1>
         <h2>乖離性ミリオンアーサー事前登録キャンペーン、豪華声優陣のボイスが聞ける！ 乖離性ミリオンアーサーに事前登録して、レアな騎士を手に入れよう！</h2>
         <div id="term">
          test
         </div>
         <div id="term_finished">
          ☆ 请在输入框中填写您的 招待ID（9位数字 中间请勿加逗号空格）以及 神秘代码 ，点击获取招待按钮即可 ☆
         </div>
         <div id="contentsBox">
          <div id="countBox">
           <!-- 招待form -->
			<div class="ui-widget">
			    <form id="inviteReq" action="../mar/invite.action" method="post">
			        <table>
			            <tr>
			                <td>
								<div style="width:300px;height:100px;margin:0px auto">
									<input class="invite_code" type="text" required="" name="inviteCode" id="inviteCode" />
									<label alt="请输入招待号码（9位数字）" placeholder="招待号码"  id="inviteCodeLabel"></label>
								</div>
			                </td>
                            <td>
								<div style="width:300px;height:100px;margin:0px auto">
								    <input class="password_code" type="text" required="" name="password" id="password" />
								    <label alt="请输入神秘代码（很长的那串）" placeholder="神秘代码" id="passwordLabel" ></label>
								</div>
                            </td>
			            </tr>
			        </table>
			    </form>
			</div>
          </div>
          <div id="achieve">
           <ul class="nav sp">
            <li class="twitter"><a href="https://pre.kairisei-ma.jp/users/auth/twitter">招待┏ (゜ω゜)=☞</a></li>
           </ul>
           <figure class="sp">
            <img alt="Achieve01" class="achieve01" src="<%=basePath%>resources/mar/invite/bigleft.png" />
           </figure>
           <figure class="sp">
            <img alt="Achieve02" class="achieve02" src="<%=basePath%>resources/mar/invite/bigright.png" />
           </figure>
           <ul class="nav">
            <li class="twitter"><a href="https://pre.kairisei-ma.jp/users/auth/twitter">招待┏ (゜ω゜)=☞</a></li>
           </ul>
          </div>
         </div>
        </section>
       </div>
      </div>
     </div>
    </div>
   </div>
   <div id="foot_home">
    <div class="bannerLink">
     <ul>
      <li>
       <figure>
        <a href="http://item.taobao.com/item.htm?id=42502732828" target="_blank"><img alt="招待神秘代码购买" class="banner01" src="<%=basePath%>resources/mar/invite/banner01.png" /></a>
       </figure>
       </li>
      <li>
       <figure>
        <a href="http://item.taobao.com/item.htm?id=42441167875" target="_blank"><img alt="初始账号列表" class="banner02" src="<%=basePath%>resources/mar/invite/banner02.png" /></a>
       </figure>
       </li>
     </ul>
    </div>
    <div class="sqex-footer-black" id="sqexFooter">
     <div id="sqex-footer-contents">
      <div id="sqex-footer-contents-inner" class="clearfix">
       <div class="sqex-footer-logos">
        <img src="<%=basePath%>resources/mar/invite/sp_iphone_k.gif" alt="iPhone" />
        <img src="<%=basePath%>resources/mar/invite/sp_android_k.gif" alt="Android" />
       </div>
       <div class="sqex-footer-shares-wrap clearfix">
        <dl class="sqex-footer-shares">
         <dt>
          <img src="<%=basePath%>resources/mar/invite/share_k.gif" alt="share" />
         </dt>
         <dd>
          <a class="facebook" title="Facebookでシェア"><img src="<%=basePath%>resources/mar/invite/sp_share_fb_k.gif" alt="Facebookにシェアする" height="25" /></a>
         </dd>
         <dd>
          <a class="twitter" title="Twitterでシェア"><img src="<%=basePath%>resources/mar/invite/sp_share_tw_k.gif" alt="Twitterにシェアする" height="25" /></a>
         </dd>
         <dd>
          <a class="mixi" title="mixiチェックに追加"><img src="<%=basePath%>resources/mar/invite/sp_share_mx_k2.gif" alt="mixiチェック" height="25" /></a>
         </dd>
         <dd>
          <a class="googleplus" title="Google+でシェア"><img src="<%=basePath%>resources/mar/invite/sp_share_gp.png" alt="Google+にシェアする" height="25" /></a>
         </dd>
         <dd>
          <a href="http://line.naver.jp/R/msg/text/?%E4%B9%96%E9%9B%A2%E6%80%A7%E3%83%9F%E3%83%AA%E3%82%AA%E3%83%B3%E3%82%A2%E3%83%BC%E3%82%B5%E3%83%BC%E3%80%80%E4%BA%8B%E5%89%8D%E7%99%BB%E9%8C%B2%E3%82%AD%E3%83%A3%E3%83%B3%E3%83%9A%E3%83%BC%E3%83%B3%20http://sqex.to/nt4" class="line" target="_blank"><img src="<%=basePath%>resources/mar/invite/share_line.png" alt="LINEで送る" title="LINEで送る" style="vertical-align:top!important; width:25px;" /></a>
         </dd>
        </dl>
       </div>
      </div>
      <ul class="clearfix">
       <li><a href="http://item.taobao.com/item.htm?id=42502732828">自助招待</a></li>
       <li><a href="http://item.taobao.com/item.htm?id=42441167875">初始账号</a></li>
       <li><a href="http://item.taobao.com/item.htm?id=42749120053">CD特典</a></li>
       <li><a href="http://wiki.famitsu.com/kairi/">WIKI攻略</a></li>
      </ul>
      <div class="sqex-footer-copy-logo">
       <p class="sqex-footer-copyright">&copy; 2014 MOEMAO CO., LTD. ALL Rights Reserved.</p>
      </div>
     </div>
    </div>
   </div>
  </div>
  <div id="background" style="opacity: 1;">
   <video autoplay="autoplay" class="bg_video" id="bg_top_movie" loop="loop" poster="https://cache.pre.kairisei-ma.jp/pre/assets/bg_top-acfccc2232f64f5206ce10bf45933836.jpg" style="width: 1855px; height: 1045.0704225352113px; margin-left: -927.5px; margin-top: -522.5352112676056px;">
    <source src="https://cache.pre.kairisei-ma.jp/pre/assets/top-2489964cb8f93ed2ed5b4a9cf5de644d.webm" type="video/webm"></source>
    <source src="https://cache.pre.kairisei-ma.jp/pre/assets/top-e540b692f4602b98247a8e6b24e0a6d8.mp4" type="video/mp4"></source>
   </video>
   <video autoplay="autoplay" class="bg_video" id="bg_gacha_movie" loop="loop" poster="https://cache.pre.kairisei-ma.jp/pre/assets/bg_gacha-e02c43781720983733f7fe0217baef9c.jpg" style="width: 1855px; height: 1045.0704225352113px; margin-left: -927.5px; margin-top: -522.5352112676056px; display: none;">
    <source src="https://cache.pre.kairisei-ma.jp/pre/assets/gacha_avant_movie-bc742eb541f853c1c69375aa1b1cdc53.webm" type="video/webm"></source>
    <source src="https://cache.pre.kairisei-ma.jp/pre/assets/gacha_avant_movie-00b3643c99837321eef7011f6dc2a26d.mp4" type="video/mp4"></source>
   </video>
  </div>
  <div id="animation_layer"></div>
  <script src="<%=basePath%>resources/mar/invite/application.js"></script>
  <div id="sqexFooterDialog"></div>
 </body>
</html>