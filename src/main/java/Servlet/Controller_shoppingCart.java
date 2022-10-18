package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

/**
 * Servlet implementation class Controller_shoppingCart
 */
public class Controller_shoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static List<Document> list = new ArrayList<Document>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_shoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		MongoClient Mongo = new MongoClient();
		MongoDatabase mb = Mongo.getDatabase("webprog");
		MongoCollection mc = mb.getCollection("products");
		MongoCursor<Document> cursor = mc.find(Filters.eq("id", id)).iterator();
		Document document = new Document(cursor.next());
		int quantity =(Integer) document.get("quantity");
		BasicDBObject query = new BasicDBObject();
		query.append("$set", new BasicDBObject().append("quantity", quantity+1));
		BasicDBObject searchQuery = new BasicDBObject().append("id", id);
		mc.updateOne(searchQuery, query);
		MongoCursor<Document> cursor2 = mc.find(Filters.eq("id", id)).iterator();
		list.remove(cursor2.next());
		System.out.println("geçti");
		response.sendRedirect("shoppingCart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		MongoClient Mongo = new MongoClient();
		MongoDatabase mb = Mongo.getDatabase("webprog");
		MongoCollection mc = mb.getCollection("products");
		MongoCursor<Document> cursor = mc.find(Filters.eq("id", id)).iterator();
		Document document = new Document(cursor.next());
		int quantity =(Integer) document.get("quantity");
		BasicDBObject query = new BasicDBObject();
		query.append("$set", new BasicDBObject().append("quantity", quantity-1));
		BasicDBObject searchQuery = new BasicDBObject().append("id", id);
		mc.updateOne(searchQuery, query);
		list.add(document);
		request.setAttribute("shoppingProducts", list);
		response.sendRedirect("shoppingCart.jsp");
	}

}
