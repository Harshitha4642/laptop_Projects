package websites;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;
@WebServlet("/cardgame")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GameServlet() {
        super();
    }
    public static int count=0;
    public static Deck d = new Deck();
    public static Player player_1,player_2;
    Optional<Card> inCard, outCard;
    private JakartaServletWebApplication application;
    private TemplateEngine templateEngine;
    public static void setPlayers(Player player1, Player player2)
    {
    	player_1=player1;
    	player_2=player2;
    }
    private Player checkWinner(Optional<Card> c, String orientation)
    { 
    	System.out.println("i am fuction");
    	if (c.isEmpty()) {
    		System.out.println("i am empty");
    	}
    	if(player_1.card.equalsTo(c.get()) && player_1.bet.equals(orientation)) {
    		System.out.println("player 1 card:"+player_1.card.toString());
    		System.out.println("orientation of current card:"+orientation);
    		System.out.println("card on deck: "+c.get().toString());
    		return player_1;
    	}
    	if(player_2.card.equalsTo(c.get()) && player_2.bet.equals(orientation)) {
    		System.out.println("player 1 card:"+player_2.card.toString());
    		System.out.println("orientation of current card:"+orientation);
    		System.out.println("card on deck: "+c.get().toString());
    		System.out.println("player 2 card:"+player_2.card.toString());
    		
    		return player_2;
    	}
		return null;
    	
    }
    
    
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
		templateEngine.process("game", ctx, out1);	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		var out = response.getWriter();
	    final IWebExchange webExchange = 
	        this.application.buildExchange(request, response);
	    final WebContext ctx = new WebContext(webExchange);
	    
	    //ctx.setVariable("Player1name", player_1.name);
	    ctx.setVariable("bet1", player_1.bet);
	    ctx.setVariable("Player1card", player_1.card.toString());
	    
	    //ctx.setVariable("Player2name", player_2.name);
	    ctx.setVariable("bet2", player_2.bet);
	    ctx.setVariable("Player2card", player_2.card.toString());
 	    
	    Optional<Player> p;
	    if("Take".equals(request.getParameter("takeCard")))
	    {
	    	Optional<Card> c;
	    	System.out.println(this.count);
	    	if(this.count%2==0)
			{
				inCard=Optional.ofNullable(d.removeCardFromDeck());
				String inc = inCard.get().toString();
				ctx.setVariable("card", inc);	
				p =Optional.ofNullable(checkWinner(inCard, "in"));
			}
			else 
			{
				outCard=Optional.ofNullable(d.removeCardFromDeck());
				String outc = outCard.get().toString();
				ctx.setVariable("card1",outc);	
				p = Optional.ofNullable(checkWinner(outCard,"out"));
			}
			this.count++;
			if(p.isEmpty()) {
				System.out.println("no winner till now");
				templateEngine.process("game", ctx, out);
			}
			else if(d.empty())
			{
				out.println("Cards are over");
			}
			else {
				out.println(p.get().name+" won the bet");
				
			}
	    }
	}
}
