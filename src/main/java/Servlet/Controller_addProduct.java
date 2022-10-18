package Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import Modal.Alert;

/**
 * Servlet implementation class Controller_addProduct
 */
public class Controller_addProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_addProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
			rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		Alert alert = new Alert();
//		Boolean control_session = alert.Alert(request, response);
//		if(control_session == true) {
			MongoClient Mongo = new MongoClient();
			MongoDatabase mb = Mongo.getDatabase("webprog");
			MongoCollection<Document> mc = mb.getCollection("products");
			int id = (int) mc.countDocuments()+1;
			String name = request.getParameter("name");
			String description = request.getParameter("description");
			String url = request.getParameter("url");
			if(name != "" && request.getParameter("price") != "" && request.getParameter("quantity") != "" && description != "") {
				Document doc = new Document();
				String priceStr = request.getParameter("price");
				priceStr = priceStr.replace(',', '.');
				Double price = Double.parseDouble(priceStr);
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				doc.append("id", id);
				doc.append("name", name);
				doc.append("price", price);
				doc.append("quantity", quantity);
				doc.append("description", description);
				doc.append("url", url);
				mc.insertOne(doc);
			}
			else {
				JOptionPane optionPane = new JOptionPane("Ürün bilgileri boþ býrakýlamaz!",JOptionPane.ERROR_MESSAGE);
				JDialog dialog = optionPane.createDialog("Warning!");
				dialog.setAlwaysOnTop(true);
				dialog.setVisible(true);
			}
//			Product product = new Product(id,name,price,quantity,description);
//			Controller_Login.products.add(product);
//			System.out.println(Controller_Login.products.size());
			RequestDispatcher rd = request.getRequestDispatcher("addProduct.jsp");
			rd.forward(request, response);
//		}
//		else {
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
//		}
	}

}
