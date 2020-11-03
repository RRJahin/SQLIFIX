class Dummy{
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String mesg = request.getParameter("mesg");
    try {
        Connection conn = (Connection) getServletContext().getAttribute("conn");
        if (conn != null) {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("insert into message (mesg) values ('" + mesg + "')");
        }
    } catch (Exception ee) {
        System.out.println(ee.toString());
    }
    ServletContext servletContext = getServletContext();
    List<AsyncContext> asyncs = (List) servletContext.getAttribute("asyncs");
    synchronized (asyncs) {
        for (AsyncContext asyncContext : asyncs) {
            System.out.println("send");
            HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out = resp.getWriter();
            out.print(mesg);
            asyncContext.complete();
        }
        asyncs.clear();
    }
    ;
    response.sendRedirect("brad93.html");
}}

