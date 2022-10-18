package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

/**
 * Servlet implementation class Controller_customerLogin
 */
public class Controller_customerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_customerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		MongoClient Mongo = new MongoClient();
		MongoDatabase mb = Mongo.getDatabase("webprog");
		MongoCollection mc = mb.getCollection("users");
		String customerName = request.getParameter("customerName");
		String customerPassword = request.getParameter("customerPassword");
		List<BasicDBObject> list = new ArrayList<BasicDBObject>();
		list.add(new BasicDBObject("name",customerName));
		list.add(new BasicDBObject("password", customerPassword));
		BasicDBObject query = new BasicDBObject();
		query.put("$and", list);
		MongoCursor<Document> cursor = mc.find(query).iterator();
		String url = "";
		if(cursor.hasNext()) {
			url = "./home";
		}
		else {
			url ="customer_noLogin.jsp";
		}
		response.sendRedirect(url);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
