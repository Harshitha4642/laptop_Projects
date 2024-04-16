package websites;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
@WebServlet("/odo")
public class OdoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OdoServlet() {
        super();
    }
    private odoController odo;
    private JakartaServletWebApplication application;
    private TemplateEngine templateEngine;
    int read, read1;
    
    odoController o = new odoController();
    @Override
    public void init(ServletConfig config) throws ServletException {
      super.init(config);
      
      application = JakartaServletWebApplication.buildApplication(getServletContext());
      final WebApplicationTemplateResolver templateResolver = 
          new WebApplicationTemplateResolver(application);
      templateResolver.setTemplateMode(TemplateMode.HTML);
      templateResolver.setPrefix("/WEB-INF/templates/");
      templateResolver.setSuffix(".html");
      templateEngine = new TemplateEngine();
      templateEngine.setTemplateResolver(templateResolver);
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		var out1 = response.getWriter();
		 final IWebExchange webExchange = 
			        this.application.buildExchange(request, response);
		final WebContext ctx = new WebContext(webExchange);
		templateEngine.process("odo", ctx, out1);	
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    //int next = odo.nextReading(Integer.parseInt(req.getParameter("reading")));
	    var out = resp.getWriter();
	    final IWebExchange webExchange = 
	        this.application.buildExchange(req, resp);
	    final WebContext ctx = new WebContext(webExchange);
	    int number = Integer.valueOf(req.getParameter("reading"));
	    if("Next".equals(req.getParameter("action")))	{
			read = o.nextReading(number);
			ctx.setVariable("read", read);
	    }
		else if("Previous".equals(req.getParameter("action"))) {
			read1 = o.prevReading(number);
			ctx.setVariable("read1", read1);
		}
	    templateEngine.process("odo", ctx, out);
	    //out.print(String.format(getHtmlPage(), hlc.feedback()));
	  }

}
