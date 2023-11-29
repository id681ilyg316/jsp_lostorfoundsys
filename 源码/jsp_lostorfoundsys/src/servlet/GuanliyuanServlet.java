package servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Xiaoxi;
import dao.GuanliyuanDao;
import dao.XiaoxiDao;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/guanliyuanServlet")
public class GuanliyuanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuanliyuanServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		 response.setCharacterEncoding("GB2312");
		 String methodName = request.getParameter("method");
			
			try {
				Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
				method.setAccessible(true);
				method.invoke(this, request, response);
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	
	/*用户登录*/
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312"); 
        String zhanghao = request.getParameter("zhanghao");  
        String mima = request.getParameter("mima");
        GuanliyuanDao guanliyuanDao = new GuanliyuanDao();
        String psw =guanliyuanDao.getPassword(zhanghao);
        if(psw ==null){  
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
        }  
        if(psw!=null&&!psw.equals(mima)){ 
            request.getRequestDispatcher("/login.jsp").forward(request, response);  
        }  
        if(psw.equals(mima)){  
            request.getRequestDispatcher("/admin.jsp").forward(request, response);  
            //response.setHeader("Refresh","1;url=welcome.jsp");  
        }
        
	}
	
	
	/*查找用户消息*/
	protected void finf_UserXiaoxi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312"); 
        String id1 = request.getParameter("id");  
        int user_id = Integer.getInteger(id1);
        XiaoxiDao xiaoxiDao = new XiaoxiDao();
        Xiaoxi xiaoxi=xiaoxiDao.findByUser(user_id);
            request.setAttribute("xiaoxi", xiaoxi); 
            request.getRequestDispatcher("/edit-employee.jsp").forward(request, response);  
            //response.setHeader("Refresh","1;url=welcome.jsp");  
	}
}
