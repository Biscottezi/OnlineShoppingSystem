/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import user.UserDTO;

/**
 *
 * @author ASUS
 */
@WebFilter(filterName = "filterAuthorization", urlPatterns = {"/*"})
public class filterAuthorization implements Filter {
    
    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;
    
    public filterAuthorization() {
    }    
    
    private void doBeforeProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("filterAuthorization:DoBeforeProcessing");
        }

        // Write code here to process the request and/or response before
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log items on the request object,
        // such as the parameters.
        /*
	for (Enumeration en = request.getParameterNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    String values[] = request.getParameterValues(name);
	    int n = values.length;
	    StringBuffer buf = new StringBuffer();
	    buf.append(name);
	    buf.append("=");
	    for(int i=0; i < n; i++) {
	        buf.append(values[i]);
	        if (i < n-1)
	            buf.append(",");
	    }
	    log(buf.toString());
	}
         */
    }    
    
    private void doAfterProcessing(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (debug) {
            log("filterAuthorization:DoAfterProcessing");
        }

        // Write code here to process the request and/or response after
        // the rest of the filter chain is invoked.
        // For example, a logging filter might log the attributes on the
        // request object after the request has been processed. 
        /*
	for (Enumeration en = request.getAttributeNames(); en.hasMoreElements(); ) {
	    String name = (String)en.nextElement();
	    Object value = request.getAttribute(name);
	    log("attribute: " + name + "=" + value.toString());

	}
         */
        // For example, a filter might append something to the response.
        /*
	PrintWriter respOut = new PrintWriter(response.getWriter());
	respOut.println("<P><B>This has been appended by an intrusive filter.</B>");
         */
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest rq = (HttpServletRequest) request;
        ServletContext context = rq.getServletContext();
        ArrayList<String> marketingPages = (ArrayList<String>) context.getAttribute("MARKETING_PAGES");
        ArrayList<String> saleMemberPages = (ArrayList<String>) context.getAttribute("SALE_MEMBER_PAGES");
        ArrayList<String> saleManagerPages = (ArrayList<String>) context.getAttribute("SALE_MANAGER_PAGES");
        ArrayList<String> adminPages = (ArrayList<String>) context.getAttribute("ADMIN_PAGES");
        ArrayList<String> customerPages = (ArrayList<String>) context.getAttribute("CUSTOMER_PAGES");
        HashMap<String, String> sitemap = (HashMap<String, String>) context.getAttribute("SITE_MAP_ATTRI");
        
        String uri = rq.getRequestURI();

        String resource = uri.substring(uri.lastIndexOf("/") + 1);
        
        
        UserDTO user = (UserDTO)context.getAttribute("USER");
        int role = 9;
        if(user != null){
            role = user.getRole();
        }
        
        boolean result = false;
        
        if (rq.getRequestURI().endsWith(".png")||rq.getRequestURI().endsWith(".jpg")||rq.getRequestURI().endsWith(".css")||rq.getRequestURI().endsWith(".js")) {
                chain.doFilter(request, response);
        }else{
        
        switch (role){
            case 0:
                for(int i = 0; i < marketingPages.size(); i++){
                    if(resource.equals(marketingPages.get(i))){
                        result = true;
                    }
                        
                }
                if(result == true){
                    chain.doFilter(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("MarketingDashboard.jsp");
                    rd.forward(request, response);
                }
                break;
            case 1:
                for(int i = 0; i < saleMemberPages.size(); i++){
                    if(resource.equals(saleMemberPages.get(i))){
                        result = true;
                    }
                        
                }
                if(result == true){
                    chain.doFilter(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("SaleMemberDashboard.jsp");
                    rd.forward(request, response);
                }
                break;
            case 2:
                for(int i = 0; i < saleManagerPages.size(); i++){
                    if(resource.equals(saleManagerPages.get(i))){
                        result = true;
                    }
                        
                }
                if(result == true){
                    chain.doFilter(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("SaleManagerDashboard.jsp");
                    rd.forward(request, response);
                }
                break;
            case 3:
                for(int i = 0; i < adminPages.size(); i++){
                    if(resource.equals(adminPages.get(i))){
                        result = true;
                    }
                        
                }
                if(result == true){
                    chain.doFilter(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("AdminDashboard.jsp");
                    rd.forward(request, response);
                }
                break;
            case 4:
                for(int i = 0; i < customerPages.size(); i++){
                    if(resource.equals(customerPages.get(i))){
                        result = true;
                    }
                        
                }
                if(result == true){
                    chain.doFilter(request, response);
                }else{
                    RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
                    rd.forward(request, response);
                }
                break;
            default:
                RequestDispatcher rd = request.getRequestDispatcher("viewHomePageServlet");
                rd.forward(request, response);
                break;
        }
        }
    }

    /**
     * Return the filter configuration object for this filter.
     */
    public FilterConfig getFilterConfig() {
        return (this.filterConfig);
    }

    /**
     * Set the filter configuration object for this filter.
     *
     * @param filterConfig The filter configuration object
     */
    public void setFilterConfig(FilterConfig filterConfig) {
        this.filterConfig = filterConfig;
    }

    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
        if (filterConfig != null) {
            if (debug) {                
                log("filterAuthorization:Initializing filter");
            }
        }
    }

    /**
     * Return a String representation of this object.
     */
    @Override
    public String toString() {
        if (filterConfig == null) {
            return ("filterAuthorization()");
        }
        StringBuffer sb = new StringBuffer("filterAuthorization(");
        sb.append(filterConfig);
        sb.append(")");
        return (sb.toString());
    }
    
    private void sendProcessingError(Throwable t, ServletResponse response) {
        String stackTrace = getStackTrace(t);        
        
        if (stackTrace != null && !stackTrace.equals("")) {
            try {
                response.setContentType("text/html");
                PrintStream ps = new PrintStream(response.getOutputStream());
                PrintWriter pw = new PrintWriter(ps);                
                pw.print("<html>\n<head>\n<title>Error</title>\n</head>\n<body>\n"); //NOI18N

                // PENDING! Localize this for next official release
                pw.print("<h1>The resource did not process correctly</h1>\n<pre>\n");                
                pw.print(stackTrace);                
                pw.print("</pre></body>\n</html>"); //NOI18N
                pw.close();
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        } else {
            try {
                PrintStream ps = new PrintStream(response.getOutputStream());
                t.printStackTrace(ps);
                ps.close();
                response.getOutputStream().close();
            } catch (Exception ex) {
            }
        }
    }
    
    public static String getStackTrace(Throwable t) {
        String stackTrace = null;
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            t.printStackTrace(pw);
            pw.close();
            sw.close();
            stackTrace = sw.getBuffer().toString();
        } catch (Exception ex) {
        }
        return stackTrace;
    }
    
    public void log(String msg) {
        filterConfig.getServletContext().log(msg);        
    }
    
}
