<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.zkoss.org/dsp/zk/core" prefix="z" %>
<%@ taglib uri="http://www.zkoss.org/dsp/web/theme" prefix="t" %>
.nav-search {
  position: absolute;
  top: 0px;
  right: 5px;
  line-height: 24px;
}
.nav-search .z-bandbox-input {
  font-family: 'Open Sans';
  font-size: 13px;
  font-weight: normal;
  font-style: normal;
  color: #666666;
  width: 92px;
  height: 28px;
  border: 1px solid #6FB3E0;
   ${ t:borderRadius('4px') };
  padding-left: 24px;
  padding-right: 6px;
}
.nav-search .z-bandbox-input:focus {
   ${ t:boxShadow('none') };
}
.nav-search .z-bandbox-button {
  position: absolute;
  top: 1px;
  bottom: 1px;
  left: 3px;
  min-width: 19px;
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
  line-height: auto;
  padding: 0;
}
.nav-search .z-bandbox-button,
.nav-search .z-bandbox-button:hover,
.nav-search .z-bandbox-button:focus,
.nav-search .z-bandbox-button:active {
  background-color: transparent;
  border: 0;
   ${ t:boxShadow('none') };
}
.nav-search .z-bandbox-button [class*="z-icon-"] {
  font-size: 14px;
  color: #6fb3e0;
  line-height: 24px;
}
input[type="radio"], input[type="checkbox"] {
   margin: 0;
}
.z-datebox-input{
	font-size:14px;
	height:30px;
}
.z-datebox-button{
	font-size:14px;
	height:30px;
	text-align:left; 
	padding-top:7px;
}

.blue {
  color: #478FCA!important;
}
.green {
  color: #69AA46 !important;
}
.grey {
  color: #777 !important;
}
.purple {
  color: #A069C3 !important;
}
.red {
  color: #DD5A43 !important;
}
.orange {
  color: #FF892A !important;
}
.lighter {
  font-weight: lighter;
}
.form-control {
	padding: 6px 6px;
}
.col-xs-1, .col-sm-1, .col-md-1, .col-lg-1, .col-xs-2, .col-sm-2, .col-md-2, .col-lg-2, .col-xs-3, .col-sm-3, .col-md-3, .col-lg-3, .col-xs-4, .col-sm-4, .col-md-4, .col-lg-4, .col-xs-5, .col-sm-5, .col-md-5, .col-lg-5, .col-xs-6, .col-sm-6, .col-md-6, .col-lg-6, .col-xs-7, .col-sm-7, .col-md-7, .col-lg-7, .col-xs-8, .col-sm-8, .col-md-8, .col-lg-8, .col-xs-9, .col-sm-9, .col-md-9, .col-lg-9, .col-xs-10, .col-sm-10, .col-md-10, .col-lg-10, .col-xs-11, .col-sm-11, .col-md-11, .col-lg-11, .col-xs-12, .col-sm-12, .col-md-12, .col-lg-12 {
  padding-right: 8px;
  padding-left: 8px;
}
.center {
 	width: auto; 
 	display: table; 
 	margin-left: auto;
	margin-right: auto; 
} 
body{
	padding: 0;
	background-color: #ffffff;	
	font-size:14px;
}
.z-window {
    border: 0;
    -webkit-border-radius: 0px;
    border-radius: 1px;
    padding: 4px;
    background: #62a8d1;
}
.z-window-modal.z-window-shadow, .z-window-highlighted.z-window-shadow {
	-webkit-border-radius: 0px;
    border-radius: 0px;
    -webkit-box-shadow: none;
    box-shadow: none;
}
.z-window-icon{
	border:0;
	background:none;
	color:#FFF;
}
.z-window-header {
    font-size: 12px;
    font-weight: normal;
    font-style: normal;
    color: #FFF;
    padding: 3px 0 5px 10px;
}
.z-window-content {
    border: 0;
}
.z-window-content .z-hbox tr{
    vertical-align: middle;
}
.itBill.z-listbox {
	border:0;
}
.itBill.z-listbox .z-listitem .z-listcell-content {
	font-size:14px;
	padding:4px 3px;
} 
.itBill.z-listbox .z-listbox-header{ 
	background:none;
	border-bottom:0; 
} 
.itBill.z-listbox .z-listheader{ 
	background:none;
	border-bottom:0; 
}
.itBill.z-listbox .z-listitem-checkable{
	width: 14px;
	height:14px;
}
.itBill.z-listbox .z-listitem-selected .z-listitem-icon.z-icon-radio{
	width: 6px;
	height:6px;
}
.itBill.z-listbox .z-listitem .z-listcell{
	border-left:0;
}
.itBill.z-listbox .z-listcell-content{
	line-height:20px;
}
.itBill.z-listbox .z-listbox-emptybody td{
	font-size:14px;
	padding-top:10px;
}
.itBill.z-listbox .z-listitem .z-listcell{
	border-bottom: 1px dotted #E2E2E2;
}
.myoddrow{
	background-color: #f2f6fb;
	background-image: none;
}
.navbar {
  margin-bottom: 0;
  padding-left: 0;
  padding-right: 0;
  margin: 0;
  border: none;
   ${ t:boxShadow('none') };
  border-radius: 0;
  min-height: 45px;
  position: relative;
  background: #337ab7;
}
.navbar .navbar-brand {
  color: #ffffff;
  font-size: 20px;
  letter-spacing:1px;
  text-shadow: none;
 // padding-top: 10px;
  //padding-bottom: 10px;
}
.navbar .navbar-brand:hover,
.navbar .navbar-brand:focus {
  color: #ffffff;
}
.nav-user > div > a,
.nav-user > div .user-menu {
 // background-color: #2e6589;
  color: #FFF;
  display: block;
  line-height: 45px;
  height: 45px;
  border-left: 1px solid #DDD;
  text-align: center;
  height: 100%;
  width: auto;
  min-width: 50px;
  padding: 0 8px;
  position: relative;
}
.nav-user > div > a .z-menu-selected,
.nav-user > div .user-menu .z-menu-selected {
  color: #FFF !important;
}
.nav-user > div > a.grey,
.nav-user > div .user-menu.grey {
  background-color: #555555 ! important;
}
.nav-user > div > a.grey.open,
.nav-user > div .user-menu.grey.open,
.nav-user > div > a.grey:hover,
.nav-user > div .user-menu.grey:hover,
.nav-user > div > a.grey:focus,
.nav-user > div .user-menu.grey:focus,
.nav-user > div > a.grey .z-menu-selected,
.nav-user > div .user-menu.grey .z-menu-selected {
  background-color: #4b4b4b ! important;
}
.nav-user > div > a.purple,
.nav-user > div .user-menu.purple {
  background-color: #892e65 ! important;
}
.nav-user > div > a.purple.open,
.nav-user > div .user-menu.purple.open,
.nav-user > div > a.purple:hover,
.nav-user > div .user-menu.purple:hover,
.nav-user > div > a.purple:focus,
.nav-user > div .user-menu.purple:focus,
.nav-user > div > a.purple .z-menu-selected,
.nav-user > div .user-menu.purple .z-menu-selected {
  background-color: #762c59 ! important;
}
.nav-user > div > a.green,
.nav-user > div .user-menu.green {
  background-color: #2e8965 ! important;
}
.nav-user > div > a.green.open,
.nav-user > div .user-menu.green.open,
.nav-user > div > a.green:hover,
.nav-user > div .user-menu.green:hover,
.nav-user > div > a.green:focus,
.nav-user > div .user-menu.green:focus,
.nav-user > div > a.green .z-menu-selected,
.nav-user > div .user-menu.green .z-menu-selected {
  background-color: #2c7659 ! important;
}
.nav-user > div > a.light-blue,
.nav-user > div .user-menu.light-blue {
  background-color: #62a8d1 ! important;
}
.nav-user > div > a.light-blue.open,
.nav-user > div .user-menu.light-blue.open,
.nav-user > div > a.light-blue:hover,
.nav-user > div .user-menu.light-blue:hover,
.nav-user > div > a.light-blue:focus,
.nav-user > div .user-menu.light-blue:focus,
.nav-user > div > a.light-blue .z-menu-selected,
.nav-user > div .user-menu.light-blue .z-menu-selected {
  background-color: #579ec8 ! important;
}
.nav-user > div > a.margin-4,
.nav-user > div .user-menu.margin-4 {
  margin-left: 4px;
}
.nav-user > div > a.margin-3,
.nav-user > div .user-menu.margin-3 {
  margin-left: 3px;
}
.nav-user > div > a.margin-2,
.nav-user > div .user-menu.margin-2 {
  margin-left: 2px;
}
.nav-user > div > a.margin-1,
.nav-user > div .user-menu.margin-1 {
  margin-left: 1px;
}
.nav-user > div > a.no-border,
.nav-user > div .user-menu.no-border {
  border: none !important;
}
.nav-user > div .badge {
  position: relative;
  top: -4px;
  left: 3px;
  padding-right: 5px;
  padding-left: 5px;
}
.nav-user > div > a:hover,
.nav-user > div > a:focus {
  //background-color: #2c5976;
}
.nav-user > div .user-menu.z-menubar {
  padding: 0;
  border: 0;
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
  border-left: 1px solid #DDD;
}
.nav-user > div .user-menu.z-menubar img {
  margin: -4px 8px 0 0;
   ${ t:borderRadius('100%') };
  border: 2px solid #FFF;
  max-width: 40px;
}
.nav-user > div .user-menu.z-menubar .z-menu-content {
  line-height: 55px;
  height: 55px;
  border: 0;
  padding: 0 8px;
}
.nav-user > div .user-menu.z-menubar .z-menu-content [class*="z-icon-"] {
  display: inline-block;
  width: 1.25em;
  text-align: center;
}
.nav-user > div .user-menu.z-menubar .z-menu:hover,
.nav-user > div .user-menu.z-menubar .z-menu-content:hover,
.nav-user > div .user-menu.z-menubar .z-menu:focus,
.nav-user > div .user-menu.z-menubar .z-menu-content:focus {
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
}
.nav-user > div .user-menu.z-menubar .z-menu {
  margin: 0;
}
.nav-user > div .user-menu.z-menubar .z-menu-selected > .z-menu-content,
.nav-user > div .user-menu.z-menubar .z-menu-content:active {
  border: 0;
   ${ t:boxShadow('none') };
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
}
.nav-user > div .user-menu.z-menubar .z-menu-text {
  max-width: 80px;
  display: inline-block;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: normal;
  text-align: left;
  vertical-align: top;
  line-height: 15px;
  position: relative;
  top: 6px;
  color: #FFF;
  font-size: 13px;
}
.nav-user > div .user-menu.z-menubar .z-menu-icon {
  top: 0;
  right: 8px;
}
.nav-user > div .user-menu.z-menubar .z-menu-text {
  text-shadow: none;
}
.nav-user > div [class*="z-icon-"] {
  font-size: 16px;
  color: #ffffff;
  display: inline-block;
  width: 20px;
  text-align: center;
}
.nav-user > div:first-child > a {
  border-left: none;
}
.z-popup,.z-menupopup {
  background: none;
  background-color: #FFF;
}
.z-popup-content,
.z-menupopup-content {
  padding: 5px 0;
}
.z-popup:before,
.z-menupopup:before {
  border-bottom: 7px solid rgba(0, 0, 0, 0.2);
  border-left: 7px solid transparent;
  border-right: 7px solid transparent;
  content: "";
  display: inline-block;
  right: 9px;
  position: absolute;
  top: -7px;
}
.z-popup:after,
.z-menupopup:after {
  border-bottom: 6px solid #FFFFFF;
  border-left: 6px solid transparent;
  border-right: 6px solid transparent;
  content: "";
  display: inline-block;
  right: 10px;
  position: absolute;
  top: -6px;
}
.z-popup {
  overflow: visible;
  border:0;
}
.menu.z-popup .z-popup-content {
  padding: 0;
}
.menu.z-popup .z-popup-content .header {
  padding: 0 8px;
  display: block;
  background-color: #ECF2F7;
  border-bottom: 1px solid #BCD4E5;
  color: #8090A0;
  font-weight: bold;
  line-height: 34px;
  cursor: default;
}
.menu.z-popup .z-popup-content .z-vlayout-inner {
  padding: 0 8px;
}
.menu.z-popup .z-popup-content .z-vlayout-inner:hover {
  background-color: #F4F9FC;
  color: #555;
}
.menu.z-popup .z-popup-content .z-vlayout-inner .z-a {
  display: block;
  padding: 10px 2px;
  color: #555;
  border-bottom: 1px solid #E4E6E9;
}
.menu.z-popup .z-popup-content .z-vlayout-inner .z-a .z-label {
  font-size: 14px;
  line-height: 16px;
  padding-left:5px;
  padding-right:5px;
  height: 16px;
}
.menu.z-popup .z-popup-content .z-vlayout-inner .z-a .z-progressmeter {
  margin-top: 4px;
}
.menu.z-popup .z-popup-content .z-vlayout-inner:last-child > .z-a {
  border-bottom-width: 0;
  border-top: 1px dotted transparent;
  color: #4F99C6;
  font-size:14px;
  text-align: center;
}
.menu.z-popup .z-popup-content .z-vlayout-inner:last-child > .z-a:hover {
  text-decoration: underline;
}
.menu.z-popup .z-popup-content .z-vlayout-inner:last-child > .z-a:hover [class*="z-icon-"] {
  text-decoration: none;
}
.menu.z-popup .z-popup-content .z-vlayout-inner:last-child > .z-a [class*="z-icon-"] {
  margin-left: 6px;
  color: #555;
}
.menu.z-popup .z-popup-content .msg-photo {
  margin-right: 6px;
  max-width: 42px;
}
.menu.z-popup .z-popup-content .msg-body {
  display: inline-block;
  line-height: 20px;
  white-space: normal;
  vertical-align: middle;
  max-width: 170px;
  font-size: 12px;
}
.menu.z-popup .z-popup-content .msg-title {
  display: inline-block;
  line-height: 14px;
}
.menu.z-popup .z-popup-content .msg-time {
  display: block;
  font-size: 11px;
  color: #777;
}
.menu.z-popup .z-popup-content .msg-time > [class*="z-icon-"] {
  font-size: 14px;
  color: #555555;
  margin-right: 2px;
}
.menu-pink.z-popup .z-popup-content .header {
  background-color: #F7ECF2;
  border-bottom: 1px solid #E5BCD4;
  color: #B471A0;
}
.menu-pink.z-popup .z-popup-content .header > [class*="z-icon-"] {
  color: #C06090;
}
.menu-pink.z-popup .z-popup-content .z-vlayout-inner:hover {
  background-color: #FCF4F9;
}
.menu-pink.z-popup .z-popup-content .z-vlayout-inner .z-a {
  border-bottom: 1px solid #F3E4EC;
}
.menu-pink.z-popup .z-popup-content .z-vlayout-inner:last-child > .z-a {
  color: #4F99C6;
}
.badge {
  text-shadow: none;
  font-size: 12px;
  padding-top: 1px;
  padding-bottom: 1px;
  font-weight: normal;
  line-height: 15px;
  background-color: #abbac3 !important;
}
.label-grey,
.badge-grey {
  background-color: #a0a0a0 !important;
}
.label-info,
.badge-info {
  background-color: #3a87ad !important;
}
.label-primary,
.badge-primary {
  background-color: #428bca !important;
}
.label-success,
.badge-success {
  background-color: #5bb75b !important;
}
.label-danger,
.badge-danger {
  background-color: #d9534f !important;
}
.label-important,
.badge-important {
  background-color: #d15b47 !important;
}
.label-inverse,
.badge-inverse {
  background-color: #333333 !important;
}
.label-warning,
.badge-warning {
  background-color: #f89406 !important;
}
.label-pink,
.badge-pink {
  background-color: #d6487e !important;
}
.label-purple,
.badge-purple {
  background-color: #9585bf !important;
}
.label-yellow,
.badge-yellow {
  background-color: #fee188 !important;
}
.label-light,
.badge-light {
  background-color: #e7e7e7 !important;
}
.badge-yellow,
.label-yellow {
  color: #996633 !important;
  border-color: #fee188;
}

.z-progressmeter {
  height: 9px;
  border: 0;
  background-image: none;
  background-color: #DADADA;
}
.z-progressmeter-image {
  display: inline-block;
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
  background-color: #2A91D8;
}
.z-progressmeter.striped .z-progressmeter-image {
  background-image: -webkit-gradient(linear, 0 100%, 100% 0, color-stop(0.25, rgba(255, 255, 255, 0.15)), color-stop(0.25, transparent), color-stop(0.5, transparent), color-stop(0.5, rgba(255, 255, 255, 0.15)), color-stop(0.75, rgba(255, 255, 255, 0.15)), color-stop(0.75, transparent), to(transparent));
  background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: -moz-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-size: 40px 40px;
}
.z-progressmeter.active .z-progressmeter-image {
  -webkit-animation: progress-bar-stripes 2s linear infinite;
  -moz-animation: progress-bar-stripes 2s linear infinite;
  -ms-animation: progress-bar-stripes 2s linear infinite;
  -o-animation: progress-bar-stripes 2s linear infinite;
  animation: progress-bar-stripes 2s linear infinite;
}
.progressmeter-danger .z-progressmeter-image {
  background-color: #ca5952;
}
.progress-striped .progressmeter-danger .z-progressmeter-image {
  background-image: -webkit-gradient(linear, 0 100%, 100% 0, color-stop(0.25, rgba(255, 255, 255, 0.15)), color-stop(0.25, transparent), color-stop(0.5, transparent), color-stop(0.5, rgba(255, 255, 255, 0.15)), color-stop(0.75, rgba(255, 255, 255, 0.15)), color-stop(0.75, transparent), to(transparent));
  background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: -moz-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
}
.progressmeter-success .z-progressmeter-image {
  background-color: #59a84b;
}
.progress-striped .progressmeter-success .z-progressmeter-image {
  background-image: -webkit-gradient(linear, 0 100%, 100% 0, color-stop(0.25, rgba(255, 255, 255, 0.15)), color-stop(0.25, transparent), color-stop(0.5, transparent), color-stop(0.5, rgba(255, 255, 255, 0.15)), color-stop(0.75, rgba(255, 255, 255, 0.15)), color-stop(0.75, transparent), to(transparent));
  background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: -moz-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
}
.progressmeter-warning .z-progressmeter-image {
  background-color: #f2bb46;
}
.progress-striped .progressmeter-warning .z-progressmeter-image {
  background-image: -webkit-gradient(linear, 0 100%, 100% 0, color-stop(0.25, rgba(255, 255, 255, 0.15)), color-stop(0.25, transparent), color-stop(0.5, transparent), color-stop(0.5, rgba(255, 255, 255, 0.15)), color-stop(0.75, rgba(255, 255, 255, 0.15)), color-stop(0.75, transparent), to(transparent));
  background-image: -webkit-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: -moz-linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
  background-image: linear-gradient(45deg, rgba(255, 255, 255, 0.15) 25%, transparent 25%, transparent 50%, rgba(255, 255, 255, 0.15) 50%, rgba(255, 255, 255, 0.15) 75%, transparent 75%, transparent);
}
.btn-xs, .btn-group-xs > .btn {
    font-size: 14px;
}
.mask {       
	position: absolute; top: 0px; filter: alpha(opacity=60); background-color: #777;     
	z-index: 1799; 
	left: 0px;     
	opacity:0.5; 
	-moz-opacity:0.5;     
} 
.rtab.z-tabbox {
  position: absolute;
  top: 0;
}
.rtab.z-tabbox .z-tabs-content {
  border-bottom:0;
  padding: 0 10px 0 3px;
  width:auto;
  margin-left:auto;
  margin-right:auto;
}
.rtab.z-tabbox .z-tab {
  border: 0;
   ${ t:borderRadius('0') };
  padding-top: 0;
  font-family: 'Open Sans';
}
.rtab.z-tabbox .z-tab,
.rtab.z-tabbox .z-tab:hover,
.rtab.z-tabbox .z-tab:focus,
.rtab.z-tabbox .z-tab:active {
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
  background-color: transparent;
}
.rtab.z-tabbox .z-tab .z-tab-content {
	font-size:14px;
}
.rtab.z-tabbox .z-tab-text {
	line-height:34px;
} 
.rtab.z-tabbox .z-tab-selected {
 // border-width: 2px 1px 0 1px;
 // border-color: #DCE8F1;
 // border-top-color: #4C8FBD;
 // border-style: solid;
}
.rtab.z-tabbox .z-tab-selected .z-tab-text {
 //font-weight: normal;
 	font-size:16px;
}
.rtab.z-tabbox .z-tabpanel {
  border: 0;
  //padding: 8px 6px;
}
.rtab.z-tabbox .rcaption {
  display: block;
  width: auto;
  height: 18px;
  margin: 10px 0;
  font-size: 17px;
  line-height: normal;
}
.rtab.z-tabbox .z-tab:first-child.z-tab-selected + .z-tab {
   ${ t:boxShadow('none') };
}
a:hover{
   text-decoration:none;
}
.heavy{
	font-weight:bold;
}
.nav-user > div [class*="z-icon-home"]{
	font-size:22px;
}
.nav-user > div [class*="z-icon-task"]{
	font-size:20px;
}