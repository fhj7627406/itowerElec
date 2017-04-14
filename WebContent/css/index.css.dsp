<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.zkoss.org/dsp/zk/core" prefix="z" %>
<%@ taglib uri="http://www.zkoss.org/dsp/web/theme" prefix="t" %>

body{overflow-x:hidden;margin-top:-20px;padding:0!important}
#tooltip{position:absolute;display:none;border:0;padding:3px 8px;border-radius:3px;font-size:10px;background-color:#222;color:#fff;z-index:25}
a:hover,a:active,a:visited,a:focus{text-decoration:none;cursor:pointer;color:#333}
.header{height:80px;position:relative}
.header h1{padding-left:165px;left:10px;overflow:hidden;position:relative;top:10px;width:15px;background:url(${c:encodeURL('../img/logo-201305-b3.png')}) no-repeat #eee; background-position:20px -3px;  }
.header h1 a{color:#1f1f1f;text-shadow:0 1px #fff;font-size:22px;display:block;font-weight:normal;line-height:44px}
.search{position:absolute;z-index:20;top:6px;left:230px}
.user-nav{position:absolute;right:30px;top:5px;z-index:20;margin:0}
.user-nav i{top:0px;color: #999;}
.sidebar{display:block;float:left;position:relative;width:220px;z-index:16}
.content{background:#eee;margin-left:220px;margin-right:0;padding-bottom:25px;position:relative;min-height:500px;width:auto;-webkit-background-clip:padding-box;border-top-left-radius:8px;z-index:20}
.content-header{${t:gradient('ver','#ffffff 0%; #eeeeee 100%') };border-top-left-radius:8px;min-height:80px;padding-top:5px;width:100%;margin-top:-38px;z-index:20}
.content-header h1{color:#555;font-size:26px;font-weight:normal;text-shadow:0 1px 0 #fff;margin-left:20px;margin-top:20px}
.content-header .btn-group{float:right;right:20px;position:absolute;margin-top:-50px}
.breadcrumb{background-color:#e5e5e5;box-shadow:0 0 1px #fff;border-top:1px solid #d6d6d6;border-bottom:1px solid #d6d6d6;padding-left:10px;padding:0}
.breadcrumb a{padding:8px 20px 8px 10px;display:inline-block;font-size:11px;color:#666}
.breadcrumb a i{opacity:.6;margin-right:6px;vertical-align:text-bottom}
.breadcrumb a:hover i{opacity:1}
.breadcrumb a:after{content:"\f054";display:inline-block;font-family:FontAwesome;font-weight:normal;font-style:normal;text-decoration:inherit;-webkit-font-smoothing:antialiased;margin:0 -20px 0 13px}
.breadcrumb a:last-child:after{display:none}
.style-switcher{position:absolute;width:250px;height:30px;background-color:#000;z-index:30;right:0;top:129px;border-radius:5px 0 0 5px;margin-right:-220px}
.style-switcher i{display:inline-block;margin:-4px 10px 0 10px;cursor:pointer;color:#FFFFFF;top: -2px;}
.style-switcher span{font-weight:bold;color:#fff;display:inline-block;margin:-11px 20px 0 0;vertical-align:middle}
.style-switcher a{display:inline-block;width:20px;height:20px;margin-top:4px;border-style:solid;border-width:1px;border-color:transparent}
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

.z-listbox-header{
	background:none;
}
.z-listhead th{
	background:#fff;
}
.ie8 .z-row:hover > .z-row-inner {
  background: transparent;
}
.ie8 .z-listitem:hover > .z-listcell {
  background-color: transparent;
}
.ie8 .z-listitem.z-listitem-selected .z-listcell {
  background-color: transparent;
}
.ie8 .z-listitem.z-listitem-selected:hover > .z-listcell {
  background-color: transparent;
}
.z-grid,
.z-listbox {
  border: 0;
}
.z-listbox-odd.z-listitem,
.z-listbox-odd.z-listitem:hover {
  background-color: #f1f1f1;
  background-image: none;
}
.z-listcell-content {
  font-size: 13px;
  word-break:normal;
}
.z-listitem,
.z-listitem:hover {
  background-color: transparent;
  background-image: none;
}
.z-listitem > .z-listcell,
.z-listitem:hover > .z-listcell {
  background-color: transparent;
  background-image: none;
}

.z-grid .z-row > .z-row-inner,
.z-grid .z-row > .z-cell {
  background-image: none;
}
.z-grid .z-row:hover > .z-row-inner,
.z-grid .z-row:hover > .z-cell {
  background-image: none;
}
.z-grid .z-column-content {
  padding: 8px;
  line-height: 1.5;
}
.z-grid .z-row.z-grid-odd > .z-row-inner,
.z-grid .z-row.z-grid-odd > .z-row-inner:hover {
  background-color: transparent;
}
.z-grid .z-grid-header,
.z-grid .z-column {
  background: none;
  filter: progid:DXImageTransform.Microsoft.gradient(enabled=false);
}
.z-grid .z-column-content {
  font-family: 'Open Sans';
  font-size: 13px;
  color: #707070;
}
.z-grid .z-column-content [class*="z-icon-"] {
  margin-right: 2px;
}
.queryGrid .z-checkbox input{
	vertical-align: text-bottom;
	padding-left:5px;
	margin-right:5px;
	border-color: #FF893C;
}
.queryGrid .z-row-inner{
  vertical-align: bottom;
}
.queryGrid .z-row-inner .z-row-content{
 vertical-align: bottom;
 line-height:15px;
}

.queryGrid .z-hbox tr,
.queryGrid .z-hbox tr td,
.queryGrid .z-hbox tr td table tr{
	vertical-align: bottom;
}
.queryGrid .z-button[disabled]{
	background:none;
}
.task.z-listbox {
  padding:5px 5px 5px 5px;
}
.task.z-listbox .z-listbox-header{
  background: none;
  border-color: #DDD;
}
.task.z-listbox .z-listitem:hover .z-listitem-checkable {
  border-color: #FF893C;
}
.task.z-listbox .z-listitem-checkbox {
  width: 18px;
  height: 10px;
}
.task.z-listbox .z-listitem {
  border-bottom: 1px solid #DDD;
  border-left:1px solid #DDD;
  border-left-width: 3px;
}
.task.z-listbox .z-listitem-selected {
  color: #8090A0;
  background-color: #d3edfa;
}
.task.z-listbox .z-listitem-selected > .z-listcell,
.task.z-listbox .z-listitem-selected:hover > .z-listcell {
  background-image: none;
}
.task.z-listbox .z-listitem-selected .z-listcell.text .z-listcell-content {
  text-decoration: line-through;
  color: #8090A0;
}
.task.z-listbox .z-listitem .z-listcell + .z-listcell {
  border-left: 0;
}
.task.z-listbox .z-listitem .z-listcell-content {
  padding: 5px;
  line-height:18px;
  color:#000;
  font-family: 'Open Sans';
  font-size: 12px;
}
.task.z-listbox .z-listitem-icon {
  width: 16px;
  height: 16px;
  line-height: 16px;
  text-align: center;
  padding: 0;
}
.task.z-listbox .z-listitem .z-listitem-icon.z-icon-check:before {
  content: "\f00c";
}
.task.z-listbox .z-listitem,
.task.z-listbox .z-listitem:hover {
  border-left-width: 3px;
}
.task.z-listbox .task-orange {
  border-left-color: #FF892A;
  
}
.task.z-listbox .task-red {
  border-left-color: #d53f40;
}
.task.z-listbox .task-yellow {
  border-left-color: #e8b110;
}
.task.z-listbox .task-green {
  border-left-color: #5bb75b;
}
.task.z-listbox .task-blue {
  border-left-color: #4f99c6;
}
.task.z-listbox .task-pink {
  border-left-color: #cb6fd7;
}
.task.z-listbox .task-grey {
  border-left-color: #a0a0a0;
}
.task.z-listbox .task-default {
  border-left-color: #abbac3;
}
.task .z-listbox-body{
	padding-bottom:17px;
}
.task .z-listbox-footer {
	border-top:0; 
	background-color: #FFF;
}
.label {
   ${ t:borderRadius('0') };
  text-shadow: none;
  font-weight: normal;
  display: inline-block;
  background-color: #abbac3 !important;
}
.badge {
  text-shadow: none;
  font-size: 12px;
  /*padding-top: 1px;*/
  padding-bottom: 3px;
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
  background-color: #82af6f !important;
}
.label-danger,
.badge-danger {
  background-color: #d15b47 !important;
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
.label.arrowed,
.label.arrowed-in {
  position: relative;
  z-index: 1;
}
.label.arrowed:before,
.label.arrowed-in:before {
  display: inline-block;
  content: "";
  position: absolute;
  top: 0;
  z-index: -1;
  border: 1px solid transparent;
  border-right-color: #abbac3;
}
.label.arrowed-in:before {
  border-color: #abbac3;
  border-left-color: transparent !important;
}
.label.arrowed-right,
.label.arrowed-in-right {
  position: relative;
  z-index: 1;
}
.label.arrowed-right:after,
.label.arrowed-in-right:after {
  display: inline-block;
  content: "";
  position: absolute;
  top: 0;
  z-index: -1;
  border: 1px solid transparent;
  border-left-color: #abbac3;
}
.label.arrowed-in-right:after {
  border-color: #abbac3;
  border-right-color: transparent !important;
}
.label-info.arrowed:before {
  border-right-color: #3a87ad;
}
.label-info.arrowed-in:before {
  border-color: #3a87ad;
}
.label-info.arrowed-right:after {
  border-left-color: #3a87ad;
}
.label-info.arrowed-in-right:after {
  border-color: #3a87ad;
}
.label-primary.arrowed:before {
  border-right-color: #428bca;
}
.label-primary.arrowed-in:before {
  border-color: #428bca;
}
.label-primary.arrowed-right:after {
  border-left-color: #428bca;
}
.label-primary.arrowed-in-right:after {
  border-color: #428bca;
}
.label-success.arrowed:before {
  border-right-color: #82af6f;
}
.label-success.arrowed-in:before {
  border-color: #82af6f;
}
.label-success.arrowed-right:after {
  border-left-color: #82af6f;
}
.label-success.arrowed-in-right:after {
  border-color: #82af6f;
}
.label-warning.arrowed:before {
  border-right-color: #f89406;
}
.label-warning.arrowed-in:before {
  border-color: #f89406;
}
.label-warning.arrowed-right:after {
  border-left-color: #f89406;
}
.label-warning.arrowed-in-right:after {
  border-color: #f89406;
}
.label-important.arrowed:before {
  border-right-color: #d15b47;
}
.label-important.arrowed-in:before {
  border-color: #d15b47;
}
.label-important.arrowed-right:after {
  border-left-color: #d15b47;
}
.label-important.arrowed-in-right:after {
  border-color: #d15b47;
}
.label-danger.arrowed:before {
  border-right-color: #d15b47;
}
.label-danger.arrowed-in:before {
  border-color: #d15b47;
}
.label-danger.arrowed-right:after {
  border-left-color: #d15b47;
}
.label-danger.arrowed-in-right:after {
  border-color: #d15b47;
}
.label-inverse.arrowed:before {
  border-right-color: #333333;
}
.label-inverse.arrowed-in:before {
  border-color: #333333;
}
.label-inverse.arrowed-right:after {
  border-left-color: #333333;
}
.label-inverse.arrowed-in-right:after {
  border-color: #333333;
}
.label-pink.arrowed:before {
  border-right-color: #d6487e;
}
.label-pink.arrowed-in:before {
  border-color: #d6487e;
}
.label-pink.arrowed-right:after {
  border-left-color: #d6487e;
}
.label-pink.arrowed-in-right:after {
  border-color: #d6487e;
}
.label-purple.arrowed:before {
  border-right-color: #9585bf;
}
.label-purple.arrowed-in:before {
  border-color: #9585bf;
}
.label-purple.arrowed-right:after {
  border-left-color: #9585bf;
}
.label-purple.arrowed-in-right:after {
  border-color: #9585bf;
}
.label-yellow.arrowed:before {
  border-right-color: #fee188;
}
.label-yellow.arrowed-in:before {
  border-color: #fee188;
}
.label-yellow.arrowed-right:after {
  border-left-color: #fee188;
}
.label-yellow.arrowed-in-right:after {
  border-color: #fee188;
}
.label-light.arrowed:before {
  border-right-color: #e7e7e7;
}
.label-light.arrowed-in:before {
  border-color: #e7e7e7;
}
.label-light.arrowed-right:after {
  border-left-color: #e7e7e7;
}
.label-light.arrowed-in-right:after {
  border-color: #e7e7e7;
}
.label-grey.arrowed:before {
  border-right-color: #a0a0a0;
}
.label-grey.arrowed-in:before {
  border-color: #a0a0a0;
}
.label-grey.arrowed-right:after {
  border-left-color: #a0a0a0;
}
.label-grey.arrowed-in-right:after {
  border-color: #a0a0a0;
}
.label {
  font-size: 12px;
  line-height: 1.15;
  height: 20px;
}
.label.arrowed {
  margin-left: 5px;
}
.label.arrowed:before {
  left: -10px;
  border-width: 10px 5px;
}
.label.arrowed-in {
  margin-left: 5px;
}
.label.arrowed-in:before {
  left: -5px;
  border-width: 10px 5px;
}
.label.arrowed-right {
  margin-right: 5px;
}
.label.arrowed-right:after {
  right: -10px;
  border-width: 10px 5px;
}
.label.arrowed-in-right {
  margin-right: 5px;
}
.label.arrowed-in-right:after {
  right: -5px;
  border-width: 10px 5px;
}
.label-sm {
  padding: 0.2em 0.4em 0.3em;
  font-size: 11px;
  line-height: 1;
  height: 18px;
}
.label-sm.arrowed {
  margin-left: 4px;
}
.label-sm.arrowed:before {
  left: -8px;
  border-width: 9px 4px;
}
.label-sm.arrowed-in {
  margin-left: 4px;
}
.label-sm.arrowed-in:before {
  left: -4px;
  border-width: 9px 4px;
}
.label-sm.arrowed-right {
  margin-right: 4px;
}
.label-sm.arrowed-right:after {
  right: -8px;
  border-width: 9px 4px;
}
.label-sm.arrowed-in-right {
  margin-right: 4px;
}
.label-sm.arrowed-in-right:after {
  right: -4px;
  border-width: 9px 4px;
}
.label > span,
.label > [class*="z-icon-"] {
  line-height: 1;
  vertical-align: bottom;
}
.icon-refresh {
	color:#fff;
}
.z-window-header{
	padding-left:10px;
}
.alarm-red{
	background-color: #d53f40 !important;
}
.alarm-orange{
	background-color: #FF892A !important;
}
.alarm-yellow{
 	 background-color: #e8b110 !important;
}
.alarm-green{
 	background-color: #5bb75b !important;
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
  background-color: #006dcc;
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
