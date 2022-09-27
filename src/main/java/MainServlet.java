import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
@WebServlet(name = "BasicServlet", urlPatterns = "/basic_servlet")
public class MainServlet implements Servlet {
    private static Logger logger = LoggerFactory.getLogger(MainServlet.class);
    private transient ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        Product[] products = new Product[10];
        products[0] = new Product(0, "Milk", 79);
        products[1] = new Product(1, "Butter", 130);
        products[2] = new Product(2, "Chips", 85);
        products[3]= new Product(3, "Cola", 60);
        products[4] = new Product(4, "Fanta", 60);
        products[5] = new Product(5, "Juice", 90);
        products[6] = new Product(6, "Pringles", 135);
        products[7] = new Product(7, "Nice", 69);
        products[8] = new Product(8, "Grechka", 30);
        products[9] = new Product(9, "Sprite", 60);

        for (Product product: products) {
            res.getWriter().println("Id: " + product.getId() + "   Title: " + product.getTitle() + "   Price: " + product.getCost());
        }
    }

    @Override
    public String getServletInfo() {
        return "BasicServlet";
    }

    @Override
    public void destroy() {
        logger.info("Servlet {} destroyed", getServletInfo());
    }
}