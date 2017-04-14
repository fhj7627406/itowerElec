<%@ taglib uri="http://www.zkoss.org/dsp/web/core" prefix="c" %>
<%@ taglib uri="http://www.zkoss.org/dsp/zk/core" prefix="z" %>
<%@ taglib uri="http://www.zkoss.org/dsp/web/theme" prefix="t" %>
.btn-tip.z-popup{overflow:visible;background:#222;${t:borderRadius('5px') }}
.btn-tip.z-popup .z-popup-content{color:#fff;white-space:nowrap}
.btn-tip.z-popup:before{position:absolute;top:-6px;left:44%;display:inline-block;border-right:7px solid transparent;border-bottom:7px solid #222;border-left:7px solid transparent;border-bottom-color:#222;content:''}
.z-panel-head,.z-panel-header{padding:0;line-height:normal;${t:gradient('ver','#fdfdfd 0%; #eaeaea 100%') };${t:borderRadius('0px') };border-color:#cdcdcd}
.z-panel-header{padding:5px}.z-caption{height:auto}
.z-caption-content{float:left;opacity:.7;line-height:17px;padding:3px}
.z-caption-content:after{content:'';opacity:.7;border-right:1px solid #cdcdcd;height:100%;position:absolute;top:0;left:36px}
.z-caption-content+.z-label{color:#666;text-shadow:0 1px 0 #fff;float:left;padding:3px 12px;font-size:12px;font-weight:bold;line-height:19px;margin:0}
.z-caption-content ~ .z-button{float:right}
.site-stats{background-color:#f5f5f5;border:1px solid #ddd;cursor:pointer;margin:0 0 10px;padding:13px 20px 10px;position:relative;display:inline-block;font-size:20px;font-weight:bold;color:#333}
.site-stats i{margin:5px 12px 0 0}
.site-stats .z-label{margin-left:12px;font-size:12px;color:#888;font-style:italic}
.site-stats:hover{background-color:#ededed}
.z-panelchildren{padding:12px 15px;border-color:#cdcdcd}
.stat-boxes{margin:20px 0 10px;text-align:center}
.stat-boxes .z-a{${t:gradient('ver','#f9f9f9 0%; #ededed 100%') };border:1px solid #d5d5d5;border-radius:4px 4px 4px 4px;${t:boxShadow('0 1px 0 0 #FFFFFF inset, 0 1px 0 rgba(255,255,255,0.4)') };display:inline-block;line-height:18px;margin:0 10px 10px;padding:0 10px}.stat-boxes 
.z-a:hover{${t:gradient('ver','#fcfcfc 0%; #f1f1f1 100%') }}
.stat-boxes .peity_bar_good,.stat-boxes .peity_line_good{color:#459d1c}
.stat-boxes peity_bar_bad,.stat-boxes .peity_line_bad{color:#ba1e20}
.stat-boxes .left{border-right:1px solid #dcdcdc;box-shadow:1px 0 0 0 #fff;margin-right:12px;padding:10px 14px 6px 4px;font-size:10px;font-weight:bold}
.stat-boxes .left,.stat-boxes .right{float:left;text-shadow:0 1px 0 #fff}
.stat-boxes .left span,.stat-boxes .right span{display:block}.stat-boxes .right{font-size:12px;padding:12px 10px 7px 0;text-align:center;width:70px;color:#666}
.stat-boxes .right strong{font-size:26px;margin-bottom:3px;margin-top:6px}
.stat-boxes .z-label+.z-label span{display:block!important}
.stat-boxes .z-label+.z-label canvas{display:none}
.tip-right.z-label{float:right;margin-top:3px;padding:4px}
.separator.z-vlayout>.z-vlayout-inner:after{content:'';position:absolute;border-bottom:1px dotted #aebdc8;width:200%;bottom:12px;margin-left:-20px}
.separator.z-vlayout>.z-vlayout-inner:nth-child(3){padding:0!important}
.separator.z-vlayout>.z-vlayout-inner:nth-child(3):after{bottom:-10px}
.separator.z-vlayout>.z-vlayout-inner:last-child:after{display:none}
.more.z-a{padding:5px;text-align:center;display:block;color:#888;margin-top:10px}
.more.z-a:hover{background:#eee}