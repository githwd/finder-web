<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<meta http-equiv="Pragma" content="no-cache"/>
<meta http-equiv="Cache-Control" content="no-cache"/>
<meta http-equiv="Expires" content="0"/>
<title>Finder - ${path}</title>
<link rel="stylesheet" type="text/css" href="${requestURI}?action=res&path=/finder/plugins/media/css/media.css"/>
<script type="text/javascript" src="${requestURI}?action=res&path=/finder/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="${requestURI}?action=res&path=/finder/widget.js"></script>
<script type="text/javascript" src="${requestURI}?action=res&path=/finder/plugins/media/index.js"></script>
<script type="text/javascript">
<!--
jQuery(function() {
    jQuery(document.body).css("margin", "0px");
    jQuery(document.body).css("padding", "0px");
    jQuery(document.body).css("backgroundColor", "#333333");
    jQuery(document.body).css("overflow", "hidden");
});

jQuery(function() {
    var playList = new PlayList();
    var host = document.body.getAttribute("host");
    var workspace = document.body.getAttribute("workspace");
    var path = document.body.getAttribute("path");
    var requestURI = window.location.pathname;

    var prefix = requestURI + "?action=finder.download&host=" + encodeURIComponent(host) + "&workspace=" + encodeURIComponent(workspace);
    playList.add({"title": "test", "url": prefix + "&path=" + encodeURIComponent(path)});

    var videoPlayer = new VideoPlayer({"container": "finder-videodialog"});
    var container = videoPlayer.getContainer();
    var parent = jQuery(container);
    parent.css("top", "0px");
    parent.css("left", "0px");
    parent.css("width", "100%");
    parent.css("height", "auto");
    parent.css("position", "static");
    parent.css("border", "none");
    parent.find("div.title").remove();
    parent.find("video").attr("width", "100%");
    parent.find("video").attr("height", "100%");

    videoPlayer.setPlayList(playList);
    videoPlayer.play(0);
    parent.show();
});

jQuery(function() {
    /**
     * jQuery-1.7.2版本的paste事件获取不到clipboardData
     * 该事件尽可能放到jQuery事件之前
     * bug: IE11不触发paste事件
     */
    EventUtil.addEventListener(document, "paste", function(event) {
        return DialogManager.dispatch("paste", event);
    });

    jQuery(document).click(function(event) {
        return DialogManager.dispatch("click", event);
    });

    jQuery(document).dblclick(function(event) {
        return DialogManager.dispatch("dblclick", event);
    });

    /**
     * keydown事件先于paste触发
     * 因此要保证paste被触发必须使Ctrl + V操作返回true
     * 如果Ctrl + V事件存在弹框, 那么root将无法捕获到paste事件
     * 因为当弹框出现的时候, 弹框是活动窗口, 因此paste事件不会被传递到root
     */
    jQuery(document).keydown(function(event) {
        var flag = DialogManager.dispatch("keydown", event);
        return flag;
    });

    jQuery(document).bind("contextmenu", function(event) {
        var e = (event || window.event);
        var src = (e.srcElement || e.target);
        var nodeName = src.nodeName.toLowerCase();

        if(nodeName == "input" || nodeName == "textarea") {
            return true;
        }
        else {
            return DialogManager.dispatch("contextmenu", e);
        }
    });
});
//-->
</script>
</head>
<body loacalIp="${loacalIp}" contextPath="${contextPath}" host="${host}" workspace="${workspace}" work="${work}" parent="${parent}" path="${path}">
<div id="finder-videodialog" class="media-dialog" contextmenu="false" style="z-index: 1010; margin-top: 0px; margin-left: 0px; display: block;">
    <div class="video-player" style="overflow: hidden;">
        <div style="position: relative;">
            <video webkit-playsinline="true">您的浏览器不支持视频播放。</video>
            <div class="loading" style="display: none;"></div>
        </div>
        <div style="padding: 4px 8px 0px 8px;">
            <div class="ctrl">
                <div class="tag" style="display: none;"><strong>&nbsp;</strong></div>
                <div class="control">
                    <div class="left">
                        <div class="rewind icon"></div>
                        <div class="playback icon playing"></div>
                        <div class="fastforward icon"></div>
                    </div>
                    <div class="right volume">
                        <div class="left mute icon"></div>
                        <div class="slider left">
                            <div class="pace" style="width: 96%;"></div>
                            <a class="dot" href="#" style="left: 96%;"></a>
                        </div>
                    </div>
                </div>
                <div class="progress">
                    <div class="slider">
                    <div class="loaded" style="width: 100%;"></div>
                    <div class="pace" style="width: 13.3025%;"></div>
                        <a class="dot" href="#" style="left: 0%;"></a>
                    </div>
                    <div class="timer left">00:00/00:00</div>
                    <div class="right">
                        <div class="repeat icon enable" mode="1" title="列表循环"></div>
                        <div class="shuffle icon" mode="2" title="随机播放"></div>
                        <div class="repeat once icon" mode="3" title="单曲循环"></div>
                        <div class="fullscreen icon" title="全屏"></div>
                    </div>
                </div>
            </div>
        </div>
        <div class="play-list"><ul></ul></div>
    </div>
</div>
</body>
</html>
