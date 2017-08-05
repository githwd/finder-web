/*
 * $RCSfile: IndexTemplate.java,v $
 * $Revision: 1.1 $
 * $Date: 2017-08-05 $
 *
 * JSP generated by JspCompiler-1.0.0 (built 2017-08-05 00:43:18 540)
 */
package com.skin.finder.servlet.template;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skin.finder.config.ConfigFactory;
import com.skin.finder.i18n.I18N;
import com.skin.finder.i18n.LocalizationContext;


/**
 * <p>Title: IndexTemplate</p>
 * <p>Description: </p>
 * @author JspKit
 * @version 1.0
 */
public class IndexTemplate extends com.skin.finder.web.servlet.JspServlet {
    private static final long serialVersionUID = 1L;
    private static final IndexTemplate instance = new IndexTemplate();


    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    public static void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        instance.service(request, response);
    }

    /**
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();


    LocalizationContext i18n = I18N.getBundle(request);

        out.write("<!DOCTYPE html>\r\n<html lang=\"en\">\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
        out.write("<title>Finder</title>\r\n<meta http-equiv=\"Pragma\" content=\"no-cache\"/>\r\n<meta http-equiv=\"Cache-Control\" content=\"no-cache\"/>\r\n");
        out.write("<meta http-equiv=\"Expires\" content=\"0\"/>\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=res&path=/finder/css/frame.css\"/>\r\n<script type=\"text/javascript\" src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=res&path=/finder/jquery-1.7.2.min.js\"></script>\r\n<script type=\"text/javascript\" src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=res&path=/finder/widget.js\"></script>\r\n<script type=\"text/javascript\" src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=res&path=/finder/fileupload.js\"></script>\r\n<script type=\"text/javascript\" src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=res&path=/finder/index.js\"></script>\r\n</head>\r\n<body>\r\n<div id=\"menu-bar\">\r\n");
        out.write("    <ul>\r\n        <li onclick=\"window.location.href=\'");
        this.print(out, request.getAttribute("requestURI"));
        out.write("\';\">");
        this.print(out, (i18n.format("finder.index.home")));
        out.write("</li>\r\n        <li onclick=\"window.location.href=\'");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=user.admin\';\">");
        this.print(out, (i18n.format("finder.index.user-admin")));
        out.write("</li>\r\n        <li onclick=\"window.location.href=\'");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=user.login\';\">");
        this.print(out, (i18n.format("finder.index.login")));
        out.write("</li>\r\n        <li onclick=\"window.location.href=\'");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=user.logout\';\">");
        this.print(out, (i18n.format("finder.index.logout")));
        out.write("</li>\r\n    </ul>\r\n</div>\r\n<div id=\"viewPanel\">\r\n    <div id=\"leftPanel\" class=\"left-panel\"><iframe id=\"leftFrame\" name=\"leftFrame\" class=\"left-frame\"\r\n");
        out.write("        src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=finder.tree\" frameborder=\"0\" scrolling=\"no\" marginwidth=\"0\" marginheight=\"0\"></iframe></div>\r\n");
        out.write("\r\n    <div id=\"mainPanel\" class=\"main-panel\"><iframe id=\"mainFrame\" name=\"mainFrame\" class=\"main-frame\"\r\n");
        out.write("        src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=finder.blank\" frameborder=\"0\" scrolling=\"auto\" marginwidth=\"0\" marginheight=\"0\"></iframe></div>\r\n");
        out.write("</div>\r\n<div id=\"statusBar\" class=\"status-bar hide\">\r\n    <div id=\"_task_bar\" class=\"widget-task-bar\"></div>\r\n");
        out.write("    <div style=\"float: right;\">\r\n        <img style=\"margin-top: -2px; margin-right: 4px;\" src=\"");
        this.print(out, request.getAttribute("requestURI"));
        out.write("?action=res&path=/finder/images/sound.gif\"/>Welcome ！\r\n    </div>\r\n</div>\r\n<!--\r\n");
        out.write("<div id=\"upgrade-tips\" style=\"position: fixed; bottom: 2px; right: 2px; padding: 6px; width: 300px; height: 16px; border: 1px solid #22b14c; background-color: #ffc90e;\">\r\n");
        out.write("    New Upgrade！<a href=\"");
        this.print(out, request.getAttribute("appDownloadUrl"));
        out.write("\" target=\"_blank\">click for download</a>\r\n</div>\r\n-->\r\n<div id=\"pageContext\" style=\"display: none;\" contextPath=\"");
        this.print(out, request.getAttribute("contextPath"));
        out.write("\" nav-bar=\"");
        this.print(out, (ConfigFactory.getBoolean("finder.display.nav-bar", true)));
        out.write("\"></div>\r\n</body>\r\n</html>\r\n");

        out.flush();
    }


}