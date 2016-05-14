<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="" lang="zh-cmn-Hans">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="keywords" content="有赞,移动电商服务平台">
<meta name="description" content="">
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="format-detection" content="telephone=no">
<meta http-equiv="cleartype" content="on">
<meta name="referrer" content="always">
<link rel="shortcut icon" href="https://b.yzcdn.cn/v2/image/yz_fc.ico">
<title>用户中心</title>

<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
<style>
@charset "UTF-8";

a,body {
	color: #333
}

.clearfix,.container .content {
	zoom: 1
}

.copyright .ft-links ~.ft-copyright,hr {
	border-image: url(https://b.yzcdn.cn/v2/image/wap/border-line.png) 2
		stretch
}

a,abbr,acronym,address,applet,article,aside,audio,b,big,blockquote,body,canvas,caption,center,cite,code,dd,del,details,dfn,div,dl,dt,em,embed,fieldset,figcaption,figure,footer,form,h1,h2,h3,h4,h5,h6,header,hgroup,html,i,iframe,img,ins,kbd,label,legend,li,mark,menu,nav,object,ol,output,p,pre,q,ruby,s,samp,section,small,span,strike,strong,sub,summary,sup,table,tbody,td,tfoot,th,thead,time,tr,tt,u,ul,var,video
	{
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	font-size: 100%;
	vertical-align: baseline
}

html {
	line-height: 1;
	-ms-text-size-adjust: 100%;
	-webkit-text-size-adjust: 100%;
	font-family: Helvetica, "STHeiti STXihei", "Microsoft JhengHei",
		"Microsoft YaHei", Tohoma, Arial
}

ol,ul {
	list-style: none
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

caption,td,th {
	font-weight: 400;
	vertical-align: middle
}

blockquote,q {
	quotes: none
}

blockquote:after,blockquote:before,q:after,q:before {
	content: "";
	content: none
}

.arrow-right::after,.clearfix:after,.container .content:after {
	content: ''
}

a img {
	border: none
}

article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section,summary
	{
	display: block
}

body {
	background-color: #eee;
	-webkit-backface-visibility: hidden
}

body.body-fixed-bottom {
	padding-bottom: 40px
}

.container {
	background-color: #f8f8f8
}

strong {
	font-weight: 700
}

a {
	background: 0 0;
	text-decoration: none;
	-webkit-tap-highlight-color: transparent
}

h1 {
	font-size: 2em;
	margin: .67em 0
}

h2 {
	font-size: 18px;
	line-height: 22px
}

h3 {
	font-size: 15px;
	line-height: 18px
}

button,input[type=number],input[type=text],input[type=password],input[type=email],input[type=search],select,textarea
	{
	font-family: inherit;
	font-size: 100%;
	margin: 0;
	-webkit-tap-highlight-color: transparent;
	-webkit-appearance: none;
	-moz-appearance: none
}

.c-orange {
	color: #f60 !important
}

.c-orange-dark {
	color: #f15a0c !important
}

.c-green {
	color: #06bf04 !important
}

.c-red {
	color: #ed5050 !important
}

.c-pink {
	color: #ee614b !important
}

.c-white {
	color: #fff !important
}

.c-gray-light {
	color: #e5e5e5 !important
}

.c-gray {
	color: #c9c9c9 !important
}

.c-gray-dark {
	color: #999 !important
}

.c-gray-darker {
	color: #666 !important
}

.c-black {
	color: #333 !important
}

.c-yellow {
	color: #f09000 !important
}

.c-light-yellow {
	color: #fcff00 !important
}

.c-blue {
	color: #00a0f8 !important
}

hr {
	margin: 10px 0;
	border: 0;
	-webkit-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line.png) 2 stretch;
	-moz-border-image: url(https://b.yzcdn.cn/v2/image/wap/border-line.png)
		2 stretch;
	border-top: 2px solid #e5e5e5
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	hr {
		border-top-width: 1px
	}
}

hr.margin-0 {
	margin: 0
}

hr.left-10 {
	margin-left: 10px
}

.relative {
	position: relative
}

.font-size-12 {
	font-size: 12px !important
}

.font-size-14 {
	font-size: 14px !important
}

.font-size-16 {
	font-size: 16px !important
}

.font-size-18 {
	font-size: 18px !important
}

.font-size-20 {
	font-size: 20px !important
}

.font-size-22 {
	font-size: 22px !important
}

.font-size-24 {
	font-size: 24px !important
}

.font-size-26 {
	font-size: 26px !important
}

.font-size-28 {
	font-size: 28px !important
}

.ellipsis {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis
}

.border-bottom-none {
	border-bottom: 0 !important
}

.border-top-none {
	border-top: 0 !important
}

.link,.link:active,.link:hover,.link:link,.link:visited {
	color: #07d
}

.clearfix:after {
	display: table;
	clear: both
}

.pull-left {
	float: left
}

.pull-right {
	float: right
}

.show {
	display: block
}

.hide {
	display: none !important;
	visibility: hidden
}

.center,.text-center {
	text-align: center
}

.text-left {
	text-align: left
}

.text-right {
	text-align: right
}

#right-icon .icon-txt,.btn,.btn-block,.copyright,.footer,.fullscreen-guide
	{
	text-align: center
}

.loading {
	background-image: url(https://b.yzcdn.cn/v2/image/loader.gif) !important;
	background-repeat: no-repeat !important;
	background-position: center center !important;
	background-size: 16px 16px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.loading {
		background-image: url(https://b.yzcdn.cn/v2/image/loader@2x.gif)
			!important
	}
}

.with-bs-bottom,.with-bs-top {
	background: url(https://b.yzcdn.cn/v2/image/wap/bottom_line.png) left
		top no-repeat;
	background-size: 100% 1px
}

.with-bs-bottom {
	background-position: left bottom
}

.arrow-right::after {
	position: absolute;
	width: 7px;
	height: 7px;
	border-top: 2px solid #cbc9cc;
	border-right: 2px solid #cbc9cc;
	-webkit-transform: rotate(45deg);
	-moz-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
	top: 50%;
	right: 3px;
	margin-top: -5px
}

.content,.wrapper {
	margin: 0 auto
}

.wrapper {
	width: 320px
}

.container .content:after {
	display: table;
	clear: both
}

.copyright {
	background-color: #f8f8f8;
	color: #999;
	font-size: 12px;
	line-height: 16px
}

.copyright .ft-links {
	padding: 15px
}

.copyright .ft-links>a {
	margin: 0 6px;
	color: #333
}

.copyright .ft-links ~.ft-copyright {
	-webkit-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line.png) 2 stretch;
	-moz-border-image: url(https://b.yzcdn.cn/v2/image/wap/border-line.png)
		2 stretch;
	border-top: 2px solid #e5e5e5
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.copyright .ft-links ~.ft-copyright {
		border-top-width: 1px
	}
}

.copyright .ft-copyright {
	padding: 50px 0 20px;
	margin: 0 15px;
	font-size: 12px;
	background: url(https://b.yzcdn.cn/v2/image/wap/common/logo@2x.png)
		center 20px no-repeat;
	background-size: 73px 24px
}

.copyright .ft-copyright>a {
	padding-top: 45px;
	color: #ccc
}

.copyright .pf-copyright {
	display: block;
	background: url(https://b.yzcdn.cn/v2/image/pf/ui/copyright.png) center
		20px no-repeat;
	background-size: 73px 24px
}

.footer {
	margin: 0;
	padding: 0;
	min-height: 1px;
	line-height: 16px;
	background-color: #f8f8f8
}

.footer .link-icon {
	display: inline-block;
	width: 16px;
	height: 16px;
	margin-bottom: -3px;
	margin-right: 10px;
	background-repeat: no-repeat;
	background-size: 16px
}

.footer .link-title {
	font-size: 16px
}

.full-screen .footer {
	margin-top: 0
}

.btn {
	display: inline-block;
	border-radius: 3px;
	padding: 5px 4px;
	margin: 0;
	font-size: 12px;
	cursor: pointer;
	line-height: 1.5;
	-webkit-appearance: none;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	color: #999
}

.fullscreen-guide.hide,.motify {
	display: none
}

.btn-disabled,.btn[disabled] {
	background-color: #c9c9c9 !important;
	background-image: none !important;
	border: 1px solid transparent !important;
	color: #fff !important
}

.btn-disabled:active,.btn[disabled]:active {
	background-color: #c9c9c9 !important;
	background-image: none !important;
	border: 1px solid #bcbcbc !important
}

.btn-default {
	color: #999;
	background-color: #fff;
	border: 1px solid #e5e5e5
}

.btn-blue {
	color: #fff;
	background-color: #00a0f8;
	border-color: #00a0f8
}

.btn-gray-dark {
	color: #333;
	background-color: #999;
	border-color: #999
}

.btn-green {
	color: #fff;
	background-color: #06bf04;
	border-color: #03b401
}

.btn-red {
	color: #fff;
	background-color: #ed5050;
	border-color: #ed5050
}

.btn-pink {
	color: #fff;
	background-color: #ee614b;
	border-color: #ee614b
}

.btn-white {
	color: #333;
	background-color: #fff;
	border-color: #e5e5e5
}

.btn-yellow {
	color: #fff;
	background-color: #f09000;
	border-color: #f09000
}

.btn-grayeee {
	color: #999;
	background-color: #eee;
	border-color: 1px solid #ebebeb
}

.btn-orange {
	color: #fff;
	border-color: #f60;
	background-color: #f60
}

.btn-orange-dark {
	color: #fff;
	border-color: #f15a0c;
	background-color: #f15a0c
}

.btn-block {
	width: 100%;
	padding: 11px 10px;
	font-size: 16px;
	line-height: 16px;
	border-radius: 4px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box
}

.btn-xsmall,.btn-xxsmall {
	line-height: 14px;
	width: auto;
	font-size: 12px
}

.btn-xsmall {
	padding: 8px 10px
}

.btn-xxsmall {
	padding: 4px 10px
}

.btn-l,.motify {
	font-size: 14px
}

.btn-l {
	padding: 9px 4px
}

.btn-opt {
	min-width: 50px
}

.motify {
	position: fixed;
	top: 35%;
	left: 50%;
	width: 220px;
	padding: 0;
	margin: 0 0 0 -110px;
	z-index: 9999;
	background: rgba(0, 0, 0, .8);
	color: #fff;
	line-height: 1.5em;
	border-radius: 6px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .2)
}

.motify .motify-inner {
	padding: 10px;
	text-align: center;
	word-wrap: break-word
}

.motify p {
	margin: 0 0 5px
}

.motify p:last-of-type {
	margin-bottom: 0
}

.fullscreen-guide {
	z-index: 2000;
	position: fixed;
	top: 0;
	left: 0;
	width: 100%;
	height: 100%;
	background-color: rgba(0, 0, 0, .9)
}

.fullscreen-guide .guide-close {
	position: absolute;
	top: 0;
	left: 10px;
	font-size: 40px;
	color: #fff;
	cursor: pointer
}

.fullscreen-guide .guide-arrow {
	position: absolute;
	top: 2px;
	right: 15px;
	background: url(https://b.yzcdn.cn/v2/image/wap/guide_arrow.png) top
		left no-repeat;
	width: 47px;
	height: 44px
}

.fullscreen-guide .guide-inner {
	padding-top: 48px;
	width: 320px;
	margin: 0 auto
}

.follow-guide .wxid,.fullscreen-guide .step {
	width: 260px;
	text-align: left;
	display: inline-block
}

.fullscreen-guide .step {
	margin-bottom: 15px
}

.follow-guide .guide-inner-title {
	color: #fff;
	border-bottom: 1px solid #ccc;
	margin: 10px;
	padding-bottom: 30px;
	font-size: 18px;
	font-weight: 400
}

.follow-guide .wxid {
	margin-bottom: 25px;
	padding-left: 65px;
	font-size: 18px
}

.follow-guide .wxid strong {
	padding: 1px 5px;
	background-color: #fff;
	color: #000;
	border-radius: 4px
}

.follow-guide .step-1,.follow-guide .step-2,.follow-guide .step-3 {
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none
}

.follow-guide .step-1 {
	height: 29px
}

.follow-guide .step-2 {
	margin-bottom: 10px;
	height: 64px;
	background: url(https://b.yzcdn.cn/v2/image/wap/step_2.png) no-repeat
}

.follow-guide .step-3 {
	margin-top: 10px;
	height: 68px;
	background: url(https://b.yzcdn.cn/v2/image/wap/step_3.png) no-repeat
}

.follow-guide .quick-subscribe {
	margin: 140px 15px 0;
	padding: 10px;
	background: #fff;
	border: 2px solid #f2f2f2;
	border-radius: 10px
}

.follow-guide .quick-subscribe h2 {
	font-size: 14px;
	border-bottom: 1px solid #f2f2f2;
	padding-bottom: 20px;
	margin: 12px 0
}

.follow-guide .quick-subscribe .btn {
	font-size: 14px;
	background: #4b0;
	color: #fff;
	display: inline-block;
	line-height: 38px;
	padding: 0 26px;
	border-radius: 4px
}

#right-icon,.fixed-icon {
	border-radius: 26px;
	position: fixed;
	right: 6px;
	z-index: 10;
	width: 50px
}

.fuck-taobao .step-1 {
	height: 29px;
	background: url(https://b.yzcdn.cn/v2/image/wap/step_1.png) no-repeat
}

.fuck-taobao .step-2 {
	height: 86px;
	background: url(https://b.yzcdn.cn/v2/image/wap/ftios_step_2.png)
		no-repeat
}

.fuck-taobao .step-and-2 {
	height: 62px;
	background: url(https://b.yzcdn.cn/v2/image/wap/ftand_step_2.png)
		no-repeat
}

.fav-guide .step-1 {
	height: 29px;
	background: url(https://b.yzcdn.cn/v2/image/wap/step_1.png) no-repeat
}

.fav-guide .step-2 {
	height: 86px;
	background: url(https://b.yzcdn.cn/v2/image/wap/fav_step_2.png)
		no-repeat
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
		(-o-min-device-pixel-ratio:3/2) , only screen and
	(min-device-pixel-ratio:1.5) {
	.fullscreen-guide .guide-arrow {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/guide_arrow@2x.png);
		background-size: 47px 44px
	}
	.follow-guide .step-2 {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/step_2@2x.png);
		background-size: 260px 64px
	}
	.follow-guide .step-3 {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/step_3@2x.png);
		background-size: 260px 68px
	}
	.fuck-taobao .step-1 {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/step_1@2x.png);
		background-size: 260px 29px
	}
	.fuck-taobao .step-2 {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/ftios_step_2@2x.png);
		background-size: 248px 86px
	}
	.fuck-taobao .step-and-2 {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/ftand_step_2@2x.png);
		background-size: 260px 62px
	}
	.fav-guide .step-1 {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/step_1@2x.png);
		background-size: 260px 29px
	}
	.fav-guide .step-2 {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/fav_step_2@2x.png);
		background-size: 260px 86px
	}
	.share-guide .step-1 {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/step_1@2x.png);
		background-size: 260px 29px
	}
	.share-guide .step-2 {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/share_step_2@2x.png);
		background-size: 260px 86px
	}
}

a#global-cart {
	z-index: 10;
	display: block
}

a#global-cart .icon-img {
	background:
		url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite_29025c38a6.png)
		-202px -4px no-repeat;
	background-size: 300px 150px
}

a#global-cart.hide {
	display: none
}

a#global-cart.new .icon-img {
	background-position: -250px -4px
}

.no-text a#global-cart {
	background:
		url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite_29025c38a6.png)
		no-repeat;
	background-size: 300px 150px
}

.no-text a#global-cart.s0 {
	background-position: -200px -100px
}

.no-text a#global-cart.s1 {
	background-position: -150px -100px
}

.no-text a#global-cart.s2 {
	background-position: -100px -100px
}

.no-text a#global-cart.s3 {
	background-position: -50px -100px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.no-text a#global-cart,a#global-cart .icon-img {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite@2x_29025c38a6.png)
	}
	a#global-cart .icon-img {
		background-position: -200px -7px
	}
	a#global-cart.new .icon-img {
		background-position: -250px -7px
	}
}

.fixed-icon {
	height: 50px;
	bottom: 52px;
	cursor: pointer
}

.ds-btn {
	bottom: 115px
}

.ds-btn .icon-img {
	height: 100%;
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite_e4444b6200.png);
	background-repeat: no-repeat;
	background-size: 300px 150px;
	background-position: -250px -100px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.ds-btn .icon-img {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite@2x_6b9819545.png)
	}
}

a#global-wish {
	z-index: 10;
	display: block
}

#right-icon.no-text .icon-img,#right-icon.no-text .icon-txt,a#global-wish.hide
	{
	display: none
}

a#global-wish .icon-img {
	background:
		url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite_29025c38a6.png)
		-2px -4px no-repeat;
	background-size: 300px 150px
}

a#global-wish.new .icon-img {
	background-position: -45px -7px
}

.no-text a#global-wish {
	background:
		url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite_29025c38a6.png)
		-150px -50px;
	background-size: 300px 150px
}

.no-text a#global-wish.new {
	background-position: -200px -50px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.no-text a#global-wish,a#global-wish .icon-img {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite@2x_29025c38a6.png)
	}
	a#global-wish .icon-img {
		background-position: 3px -7px
	}
}

#right-icon {
	height: 50px;
	border: 1px solid #e1e1e1;
	bottom: 52px;
	overflow: hidden;
	-webkit-transition: width ease-in-out .3s;
	-moz-transition: width ease-in-out .3s;
	transition: width ease-in-out .3s;
	background-color: #fff;
	background-clip: padding-box
}

#right-icon .right-icon-container {
	position: absolute;
	height: 50px;
	right: 0;
	top: 0
}

#right-icon .icon {
	float: left;
	width: 50px;
	height: 50px
}

#right-icon .show-more-btn {
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite_29025c38a6.png);
	background-repeat: no-repeat;
	background-size: 300px 150px;
	background-position: 1px -50px
}

#right-icon .show-more-btn.new {
	background-position: -99px -50px
}

#right-icon .icon-img {
	height: 32px
}

#right-icon .icon-txt {
	line-height: 18px;
	font-size: 12px;
	color: #9f9f9f
}

#right-icon.show {
	padding-left: 12px
}

#right-icon.show .show-more-btn {
	background-position: -49px -50px
}

#right-icon.no-text {
	border: 0;
	background-color: transparent
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	#right-icon .show-more-btn {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/right_icon/icons_sprite/icons_sprite@2x_29025c38a6.png)
	}
}
</style>
<style>
@charset "UTF-8";

.custom-level {
	width: 100%;
	min-height: 100px;
	overflow: hidden;
	position: relative;
	background-image: #f8f8f8;
	background-size: 6px 6px
}

.custom-level-img {
	max-width: 100%;
	max-height: 160px;
	display: block;
	margin: auto
}

.custom-level-img-blur {
	filter: blur(10px);
	-webkit-filter: blur(10px);
	-moz-filter: blur(10px);
	-o-filter: blur(10px);
	-ms-filter: blur(10px)
}

.custom-level-title-section {
	position: absolute;
	bottom: 0;
	left: 0;
	min-height: 26px;
	margin: 0 auto;
	width: 100%;
	z-index: 10;
	background-color: rgba(51, 51, 51, .8)
}

.custom-level-title {
	color: #fff;
	font-size: 15px;
	padding: 5px 15px;
	line-height: 1.5;
	margin: 0
}

@charset "UTF-8";

.block,.block-item {
	border-image: url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2
		stretch;
	display: block;
	overflow: hidden
}

.block.block-list,.form {
	list-style: none;
	font-size: 14px
}

.block,.block p,.block-item {
	overflow: hidden
}

.block-item {
	position: relative;
	padding: 10px;
	line-height: 1.5;
	border: 0;
	-webkit-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2 stretch;
	-moz-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2 stretch;
	border-top: 2px solid #e5e5e5
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.block-item {
		border-top-width: 1px
	}
}

.block-item .btn-auth-code {
	position: absolute;
	top: 6px;
	right: 0;
	height: 30px;
	line-height: 30px;
	padding-left: 7px;
	padding-right: 7px;
	font-weight: 700
}

.block-item .verify-image {
	position: absolute;
	width: 80px;
	height: 30px;
	right: 10px;
	top: 7px
}

.block-item.border-none {
	border-bottom: 0
}

.block-item ul {
	padding-right: 50px
}

.block-item ul em {
	color: #999
}

.block-item h4.block-item-title {
	line-height: 22px;
	float: left;
	margin-right: 10px
}

.block {
	-webkit-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2 stretch;
	-moz-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2 stretch;
	border-top: 2px solid #e5e5e5;
	border-bottom: 2px solid #e5e5e5;
	margin: 10px 0;
	background-color: #fff;
	position: relative;
	font-size: 14px
}

.block.top-0,.block:first-child {
	margin-top: 0
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.block {
		border-top-width: 1px;
		border-bottom-width: 1px
	}
}

.block.border-0,.block.border-top-0 {
	border-top: 0
}

.block.border-0,.block.border-bottom-0 {
	border-bottom: 0
}

.block.bottom-0 {
	margin-bottom: 0
}

.block .bottom {
	padding: 10px;
	height: 18px;
	line-height: 18px
}

.block .bottom .price {
	float: right;
	color: #f60
}

.block.block-list {
	margin: 0;
	padding: 0 0 0 10px;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box
}

.form,.order-related .uc-order {
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box
}

.block.block-list.margin-top-normal {
	margin-top: 20px
}

.block-list.wf {
	padding-left: 0
}

.block-list.wf .b-list {
	padding-left: 10px;
	background-color: #fff
}

.block-list>.block-item {
	padding: 10px 10px 10px 0
}

.block-list>.block-item:first-child {
	border-top: 0 none
}

.block.block-list+.block.block-list {
	margin-top: 12px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
		(-o-min-device-pixel-ratio:3/2) , only screen and
	(min-device-pixel-ratio:1.5) {
	.block.block-list li span.clear {
		background: url(https://b.yzcdn.cn/v2/image/wap/icon_clear@2x.png)
			center center no-repeat;
		background-size: 100%
	}
}

.form {
	width: 100%;
	margin: 0;
	padding: 0 10px;
	box-sizing: border-box
}

.form.mg-top-20 {
	margin-top: 20px
}

.form.mg-bottom-20 {
	margin-bottom: 20px
}

.form .block-item.no-top-border {
	border-top-width: 0
}

.form>.block-item:first-child {
	border-top: 0 none
}

.form .block-item {
	display: table;
	width: 100%;
	padding: 0
}

.form .block-item label {
	display: table-cell;
	width: 90px;
	line-height: 28px;
	padding: 10px 0
}

.form .block-item a,.form .block-item input,.form .block-item select,.form .block-item span,.form .block-item textarea
	{
	display: table-cell;
	overflow: hidden;
	padding: 10px 0;
	min-height: 28px;
	line-height: 28px;
	font-size: 14px
}

.form .block-item input,.form .block-item select,.form .block-item textarea
	{
	width: 99%;
	background-color: #fff;
	border: 0;
	outline: 0
}

.form .block-item textarea {
	height: 50px;
	-webkit-box-sizing: content-box;
	-moz-box-sizing: content-box;
	box-sizing: content-box;
	resize: none
}

.form .block-item:last-child {
	border-bottom: 0 none
}

.order-related .other-shop {
	font-size: 12px
}

.order-related .other-shop a {
	color: #07d
}

.order-related {
	margin-bottom: 12px
}

.order-related .uc-order {
	width: 100%;
	padding: 10px 0;
	box-sizing: border-box;
	background: #fff
}

.order-related .uc-order p {
	line-height: 20px
}

.order-related .uc-order.list-horizon {
	padding: 10px 0
}

.order-related .uc-order.list-horizon>li {
	display: inline-block;
	width: 20%;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
	float: left
}

.order-related .uc-order.list-horizon .link {
	display: block;
	padding: 42px 0 10px;
	background-size: 24px 24px;
	background-repeat: no-repeat;
	background-position: center 12px
}

.order-related .uc-order.list-horizon .title-num {
	position: absolute;
	left: 50%;
	top: 2px;
	height: 16px;
	line-height: 16px;
	padding: 0 5px;
	margin-left: 1px;
	border-radius: 10px;
	border: 2px solid #fff;
	font-size: 10px;
	color: #fff;
	background-color: #f76161
}

.order-related .uc-order.list-horizon .link-topay {
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/uc/order_list/icon_topay@2x.png)
}

.order-related .uc-order.list-horizon .link-totuan {
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/uc/order_list/icon_daijiedan@2x.png)
}

.order-related .uc-order.list-horizon .link-tosend {
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/uc/order_list/icon_tosend@2x.png)
}

.order-related .uc-order.list-horizon .link-send {
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/uc/order_list/icon_send@2x.png)
}

.order-related .uc-order.list-horizon .link-sign {
	background-image:
		url(https://b.yzcdn.cn/v2/image/wap/uc/order_list/icon_sign@2x.png)
}

.order-related .uc-order.list-horizon .title-info {
	text-align: center;
	line-height: 20px
}

.order-related .block.block-list.list-vertical>a.link {
	padding-left: 38px;
	padding-right: 28px
}

.order-related .block.block-list.list-vertical>a.link::before {
	content: '';
	position: absolute;
	top: 8px;
	left: 5px;
	width: 25px;
	height: 25px;
	background-image: url(https://b.yzcdn.cn/v2/image/wap/uc/uc_icon.png);
	background-repeat: no-repeat;
	background-size: 18px 218px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.order-related .block.block-list.list-vertical>a.link::before {
		background-image: url(https://b.yzcdn.cn/v2/image/wap/uc/uc_icon@2x.png)
	}
}

.order-related .block.block-list.list-vertical>a.link.ico-saler-center::before
	{
	background-image: url(/v2/image/wap/uc/sale_new.png);
	background-size: 19px 18px;
	left: 6px
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.order-related .block.block-list.list-vertical>a.link.ico-saler-center::before
		{
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/uc/sale_new@2x.png)
	}
}

.order-related .block.block-list.list-vertical>a.link.ico-order::before
	{
	background-position: 3px 4px
}

.order-related .block.block-list.list-vertical>a.link.ico-record::before
	{
	background-position: 3px -18px
}

.order-related .block.block-list.list-vertical>a.link.ico-backs::before
	{
	background-position: 3px -41px
}

.order-related .block.block-list.list-vertical>a.link.ico-wish::before {
	background-position: 3px -63px
}

.order-related .block.block-list.list-vertical>a.link.ico-membercard::before
	{
	background-position: 3px -85px
}

.order-related .block.block-list.list-vertical>a.link.ico-gift::before {
	background-position: 3px -108px
}

.order-related .block.block-list.list-vertical>a.link.ico-coupon::before
	{
	background-position: 3px -130px
}

.order-related .block.block-list.list-vertical>a.link.ico-promocode::before
	{
	background-position: 3px -153px
}

.order-related .block.block-list.list-vertical>a.link.ico-present::before
	{
	background-position: 3px -176px
}

.order-related .block.block-list.list-vertical>a.link.ico-taobao::before
	{
	background-image:
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAAAqFBMVEUAAAAzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMv3fmxAAAAN3RSTlMANhAL6PuyjvXEqZeSfUYW+fDSvYB4WS8fGwfYrpuIdGteVT0sJN6FUEtDA+LMyrm2o2QyzSnjzR56fAAAAYBJREFUOMvFk1eSg0AMRBlyNsmATcYB4xy373+zDdhlwrC1f6svRD2pNT0a5l9jciu0tF5yvzFFBPA2cCajyEyFc90+gtoT7OkIw4mQ2OZzqWCEypC9CxSLqriUT+w7C2SXpUCebLZTSaa1EvlOqQl/yMyjYycPBW8IsWu364egU+Sc/bydEmQUSJWDdpqjpEAmpLZ65ExoRilCywN9xPKbzb8ozsB5zlBjyyMlXyKheYIyYUYiUMEf43NkWQbLjMV8iiasfGztVpVsOa6WX9P4ADld0ZjNHm7JPlv6MWiGT4V10RpkR8IhI0HtzzrwoMCF68ynlyvVZMmmnr230lbY7oBQKkSX1NPu+e5psCsse++PXK01pBk3EYXVq67qySeXQhc/jrFmGFg0J0n4Wf+G7vpDyeD4iym2zRLa0uC0CydIEuw179WpRD2A9Dg/EIiSm4E830nfOM7DwoAGXuRV3H5++f5gHYQDE0piZfiJvR5bGq781tgxoXZSCfO3+ARz6SK431pDWQAAAABJRU5ErkJggg==);
	background-size: 18px 18px;
	background-position: center center
}

.order-related .block.block-list.list-vertical>a.link.ico-pointsstore::before
	{
	background-image:
		url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACQAAAAkCAMAAADW3miqAAAAnFBMVEUAAAAzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzMzM+ZMmGAAAAM3RSTlMAA/ZiDu6XeT/X0fqjnpFnLhPf27ypilM6JB8IsHRZKuVvXk9KxcK3g34ZyZo0y6pIrEse3WpOAAABu0lEQVQ4y7WS15KjQAxFTUNDk3MwJpqM48z9/3/bKUKt2YXH0YtEcdQKV6dfsXPN96KWJNo9MCuL+x+4MONJ8WFE1ip7y1xbALQT+/JavzNzMF4OAFkSPup0gCKGm0SBBS2gsPX74eBWCTstRD5ItuQoCC4Hs/CEWHMA8XhiE/rkdTU/HZvjTu6uWscM58iTz+AfQymMeYgWmr2PXCQU5zmMG7imvYOELQq27u2tAzThN3KdQ70AvCxeensVF5YQgDw935D4axpoXUMBNBnny3OJGuLPE3nqFxuBu55NS5QmKFCX3uz8u+wNXTcCKbRGbi7j3iYvkvh0bPK8pyuGY+Yb+ipwecTUlCxyWDKSiNu7ZwMkXPWpPcBL/+Fy0ydQ+PXORNfmFQDyfTCryMqjmpeMGwHcQdCfMxXhxZ04FigqPs3Rw5//5bKnXs1XJVJD++q8RBOl7HFZTqXZ2xO3bU2RlwtNj/cUqdrkR1e9HjEPV43miFGI5z1klMjfKg8FxDfjbTN2dXdAP2oIkgPAk/iQWfGYs4ovfQpQMd7mZYkLAFApJVNQtOXOdQiMHzSvUeSb9xWY7/H0C/YH+lAx6LUq3XwAAAAASUVORK5CYII=);
	background-size: 18px 18px;
	background-position: center center
}

.order-related .block.block-list.list-vertical>a.link.ico-manage::before
	{
	background-position: 3px -198px
}

.order-related .block.block-list.list-vertical>a.link.ico-wish-gift::before
	{
	background-image: url(https://b.yzcdn.cn/v2/image/wap/uc/wish_gift.png);
	background-size: 20px 20px;
	top: 11px;
	left: 7px
}

.order-related .block.block-list.list-vertical>a.link p::after {
	content: '';
	position: absolute;
	width: 7px;
	height: 7px;
	border-top: 2px solid #cbc9cc;
	border-right: 2px solid #cbc9cc;
	-webkit-transform: rotate(45deg);
	-moz-transform: rotate(45deg);
	-ms-transform: rotate(45deg);
	transform: rotate(45deg);
	top: 16px;
	right: 12px
}

.order-related .block.block-list.list-vertical>a.link .present-num {
	float: right;
	color: #f60;
	font-size: 13px
}

@charset "UTF-8";

.custom-store {
	position: relative;
	padding: 10px;
	background-color: #fff
}

.custom-store .custom-store-img {
	position: absolute;
	top: 11px;
	left: 10px;
	height: 18px;
	width: 18px;
	background:
		url(https://b.yzcdn.cn/v2/image/wap/showcase/goods/goods_c9431a6d41.png)
		-40px 0 no-repeat;
	background-size: 58px 48px
}

.custom-store .custom-store-link {
	display: block
}

.custom-store .custom-store-name {
	float: left;
	padding: 0 0 0 25px;
	height: 22px;
	line-height: 22px;
	font-size: 14px;
	color: #333;
	max-width: 210px;
	overflow: hidden;
	text-overflow: ellipsis;
	white-space: nowrap
}

.custom-store .custom-store-enter {
	float: right;
	height: 14px;
	line-height: 14px;
	margin: 4px 0;
	font-size: 12px;
	color: #999;
	padding-right: 15px
}

.custom-store:after {
	content: '';
	position: absolute;
	top: 15px;
	right: 10px;
	width: 6px;
	height: 11px;
	background:
		url(https://b.yzcdn.cn/v2/image/wap/showcase/goods/goods_c9431a6d41.png)
		-40px -18px no-repeat;
	background-size: 58px 48px
}

.custom-store.border {
	-webkit-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2 stretch;
	-moz-border-image:
		url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2 stretch;
	border-image: url(https://b.yzcdn.cn/v2/image/wap/border-line-2.png) 2
		stretch;
	border-top: 2px solid #e5e5e5;
	border-bottom: 2px solid #e5e5e5
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.custom-store.border {
		border-top-width: 1px;
		border-bottom-width: 1px
	}
}

.custom-store.border:last-child {
	border-bottom: 2px solid #e5e5e5
}

@media only screen and (-webkit-min-device-pixel-ratio:1.5) , only screen and
		(min--moz-device-pixel-ratio:1.5) , only screen and
	(min-device-pixel-ratio:1.5) {
	.custom-store.border:last-child {
		border-bottom-width: 1px
	}
	.custom-store .custom-store-img,.custom-store:after {
		background-image:
			url(https://b.yzcdn.cn/v2/image/wap/showcase/goods/goods@2x_c9431a6d41.png)
	}
}
</style>

<link rel="stylesheet" onerror="_cdnFallback(this)">
</head>
<body class="body-fixed-bottom">

	<div class="container " style="min-height: 643px;">
		<div class="header"></div>
		<div class="content ">
			<div class="content-body">
				<!-- 等级/积分 -->
				<div class="custom-level">
					<img class="custom-level-img js-lazy "
						data-src="https://img.yzcdn.cn/upload_files/2015/07/25/Fu2xGNDGJhjApEVH84Ysy3Y6pcB0.jpg"
						src="${userInfoFull.headImageUrl}" style="display: block;">
					<div
						class="custom-level-title-section js-custom-level-title-section">
						<h5 class="custom-level-title">
							亲爱的 ${userInfoFull.nickName}
							<span class="js-custom-level">同学</span>
							<br>
							您拥有的积分为：
							<span class="js-custom-point">${totalPoint}</span>
						</h5>
					</div>
				</div>

				<div class="order-related">
					<ul class="uc-order list-horizon clearfix">
						<li>
							<a class="link clearfix relative link-topay"
								href="http://www.ntujtxy.top/ntujtxy/pointSort.htm?scopeType=full">
								<p class="title-info c-black font-size-12">积分榜</p>
							</a>
						</li>
						<li>
							<a class="link clearfix relative link-totuan"
								href="http://www.ntujtxy.top/ntujtxy/pointSort.htm?scopeType=full">
								<p class="title-info c-black font-size-12">上传作品</p>
							</a>
						</li>
						<li>
							<a class="link clearfix relative link-tosend"
								href="http://www.ntujtxy.top/ntujtxy/daliyQuestionShow.htm?scopeType=full">
								<p class="title-info c-black font-size-12">每日一题</p>
							</a>
						</li>
						<li>
							<a class="link clearfix relative link-send"
								href="http://www.ntujtxy.top/ntujtxy/lottery.htm?scopeType=full">
								<p class="title-info c-black font-size-12">幸运大转盘</p>
							</a>
						</li>
						<li>
							<a class="link clearfix relative link-sign"
								href="http://www.ntujtxy.top/ntujtxy/worksList.htm?scopeType=full">
								<p class="title-info c-black font-size-12">点赞留言</p>
							</a>
						</li>
					</ul>

					<div class="block block-list list-vertical">
						<a class="block-item link clearfix ico-order">
							<p class="title-info c-black font-size-14">姓名:${userInfoFull.realName}</p>
						</a>
						<a class="block-item link clearfix ico-record">
							<p class="title-info c-black font-size-14">学号:${userInfoFull.stuNo}</p>
						</a>
						<a class="block-item link clearfix ico-backs" target="_blank">
							<p class="title-info c-black font-size-14">身份证:${userInfoFull.idNo}</p>
						</a>

						<a class="block-item link clearfix ico-gift">
							<p class="title-info c-black font-size-14">手机:${userInfoFull.phone}</p>
						</a>
						<a class="block-item link clearfix ico-coupon">
							<p class="title-info c-black font-size-14">地区:${userInfoFull.loc}</p>
						</a>
						<a class="block-item link clearfix ico-promocode">
							<p class="title-info c-black font-size-14">班级信息:${userInfoFull.school}-${userInfoFull.department}-${userInfoFull.classNo}
							</p>
						</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>