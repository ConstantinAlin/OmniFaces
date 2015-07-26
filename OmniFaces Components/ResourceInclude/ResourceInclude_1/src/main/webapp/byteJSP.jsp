<%@ page import="java.io.InputStream"%>
<%@ page import="java.io.OutputStream"   %>
<%@ page import="java.io.File"           %>
<%@ page contentType="image/png" %>
<%@ page trimDirectiveWhitespaces="true" %>

<% displayImage(response);%>

<%!
    public void displayImage(HttpServletResponse response) throws Exception {

        OutputStream out = response.getOutputStream();

        response.setContentType("image/png");

        InputStream in = getServletContext().getResourceAsStream("/resources/default/images/omnifaces_logo.png");
        byte[] buf = new byte[1024];
        int count;
        while ((count = in.read(buf)) >= 0) {
            out.write(buf, 0, count);
        }

        in.close();             
        out.flush();
        out.close();
        return;
    }
%>


