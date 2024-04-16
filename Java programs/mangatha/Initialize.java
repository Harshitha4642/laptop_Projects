package websites;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
@WebServlet("/initialize")
public class Initialize extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Initialize() {
        super();
    }
    private JakartaServletWebApplication application;
    private TemplateEngine templateEngine;
    
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
		templateEngine.process("registration", ctx, out1);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		var out = response.getWriter();
		final IWebExchange webExchange = 
		        this.application.buildExchange(request, response);
		    final WebContext ctx = new WebContext(webExchange);
		String name1 = request.getParameter("p1_name");
		String rank1 = request.getParameter("rank1");
		String value1 = request.getParameter("value1");
		String category1 = request.getParameter("category1");
		
		Card card1 = new Card(rank1, value1);
		
		String name2 = request.getParameter("p2_name");
		String rank2 = request.getParameter("rank2");
		String value2 = request.getParameter("value2");
		String category2 = request.getParameter("category2");
		Card card2 = new Card(rank2, value2);
		
		if(card1.equalsTo(card2) && category1.equals(category2))
		{
			out.println("invalid, choose another card or another category");
		}		
		else {
			Player player1 = new Player(name1,card1,category1);
			Player player2 = new Player(name2,card2,category2);
			
			GameServlet.setPlayers(player1, player2);
			
			ctx.setVariable("Player1card", player1.card.toString());
			ctx.setVariable("Player2card", player2.card.toString());
			
			templateEngine.process("game", ctx, out);
		}
	}
	
	

}
