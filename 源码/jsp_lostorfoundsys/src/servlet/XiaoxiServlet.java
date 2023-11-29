package servlet;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;

import com.jspsmart.upload.SmartUpload;

import bean.Xiaoxi;
import dao.XiaoxiDao;
import dao.photoDao;
import utils.SensitiveWordFilter;

/**
 * Servlet implementation class XiaoxiServlet
 */
@WebServlet("/xiaoxiServlet")
@MultipartConfig
public class XiaoxiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public XiaoxiServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312");
		String methodName = request.getParameter("method");

		try {
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class,
					HttpServletResponse.class);
			method.setAccessible(true);
			method.invoke(this, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	
	/*寻物*/
	protected void add_Searchxiaoxi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("text/html;charset=UTF-8");
		String zhuti = request.getParameter("zhuti");
		String neirong = request.getParameter("neirong");
		String wupin = request.getParameter("wupin");
        String lianxiren = request.getParameter("lianxiren");
        String tel = request.getParameter("tel");


//        System.out.println(zhuti+" "+neirong+" "+wupin+" "+lianxiren+" "+tel);
        
        Part part = request.getPart("pic");
		String fileName = photoDao.getPhotoNewName();
		String savePath = request.getSession().getServletContext().getRealPath("/imgs");
//		String savePath = "D:\\eclipse\\SearchAndFindPlatform(源码)\\WebContent\\imgs";
		System.out.println("保存路径："+savePath);
		File f = new File(savePath+"/");
		if(!f.exists()) {
			f.mkdirs();
		}
		part.write(savePath+"/"+fileName);
		
		
        Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = sdf.format(d);
		
//		处理敏感词问题
		String t = request.getSession().getServletContext().getRealPath("sensitiveWords.txt");
//		String t = getServletContext.getRealPath("/sensitiveWords.txt");  
		SensitiveWordFilter filter = new SensitiveWordFilter(t);
		System.out.println("敏感词的数量：" + filter.sensitiveWordMap.size());
		Set<String> set = filter.getSensitiveWord(neirong, 1);
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
		System.out.println("替换关敏感词");
		String newNeirong = filter.replaceSensitiveWord(neirong,2,"*");
		System.out.println(newNeirong);
		

		
		Xiaoxi xiaoxi = new Xiaoxi();
		xiaoxi.setZhuti(zhuti);
		xiaoxi.setNeirong(newNeirong);
		xiaoxi.setShijian(dateNow);
		xiaoxi.setWupin(wupin);
		xiaoxi.setLianxiren(lianxiren);
		xiaoxi.setTel(tel);
		xiaoxi.setImagesName(fileName);
//		System.out.println(zhuti+" "+neirong+" "+wupin+" "+lianxiren+" "+tel+" "+"\n"+fileName);
		XiaoxiDao xiaoxiDao = new XiaoxiDao();
		int b=xiaoxiDao.insertsearch(xiaoxi);
        if(b==1) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
		
	}
	
	/*招领*/
	protected void add_Findxiaoxi(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8"); 
		String zhuti = request.getParameter("zhuti");
		String neirong = request.getParameter("neirong");
		String wupin = request.getParameter("wupin");
        String lianxiren = request.getParameter("lianxiren");
        String tel = request.getParameter("tel");

        String imagePath =request.getParameter("");
        
        Part part = request.getPart("pic");
        System.out.println("______________>"+part);
		String fileName = photoDao.getPhotoNewName();
		String savePath = request.getSession().getServletContext().getRealPath("/imgs");
//		String savePath = "D:\\eclipse\\SearchAndFindPlatform(源码)\\WebContent\\imgs";
		System.out.println("保存路径："+savePath);
		File f = new File(savePath+"/");
		if(!f.exists()) {
			f.mkdirs();
		}
		part.write(savePath+"/"+fileName);
        
//		处理敏感词问题
//		String t = getServletContext().getRealPath("/sensitiveWords.txt");

		String t = request.getSession().getServletContext().getRealPath("sensitiveWords.txt");
		SensitiveWordFilter filter = new SensitiveWordFilter(t);
		System.out.println("敏感词的数量：" + filter.sensitiveWordMap.size());
		Set<String> set = filter.getSensitiveWord(neirong, 1);
		System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
		System.out.println("替换关敏感词");
		String newNeirong = filter.replaceSensitiveWord(neirong,2,"*");
		System.out.println(newNeirong);
        
        Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateNow = sdf.format(d);
		Xiaoxi xiaoxi = new Xiaoxi();
		xiaoxi.setZhuti(zhuti);
		xiaoxi.setNeirong(newNeirong);
//		xiaoxi.setNeirong(neirong);
		xiaoxi.setShijian(dateNow);
		xiaoxi.setWupin(wupin);
		xiaoxi.setLianxiren(lianxiren);
		xiaoxi.setTel(tel);
		xiaoxi.setImagesName(fileName);
		XiaoxiDao xiaoxiDao = new XiaoxiDao();
		int b=xiaoxiDao.insertfind(xiaoxi);
        if(b==1) {
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
		
	}

	
	//模糊查询
	protected void findMohu_Xiaoxi(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312"); 
        String zhuti = request.getParameter("zhuti");  
        XiaoxiDao xiaoxiDao = new XiaoxiDao();
        ArrayList<Xiaoxi> xiaoxi =null;
        xiaoxi = xiaoxiDao.findmohuAll("%"+zhuti+"%");
        System.out.println("%"+zhuti+"%");
        if(xiaoxi==null){  
            request.setAttribute("msg", "没有该物品信息！");  
            request.getRequestDispatcher("/found.jsp").forward(request, response);  
        }  else {
        	request.setAttribute("zhuti", zhuti); 
            request.setAttribute("xiaoxi", xiaoxi); 
            request.getRequestDispatcher("/found.jsp").forward(request, response);  
            //response.setHeader("Refresh","1;url=welcome.jsp");  
        }
    }
	
//	删除寻物信息
	protected void deleteById_xiaoxi1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312"); 
		XiaoxiDao xiaoxiDao = new XiaoxiDao();
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		int b = xiaoxiDao.delete(idInt);
		if(b==1) {
			request.getRequestDispatcher("/search-manager.jsp").forward(request, response);
		}
	}
	
//	删除招领信息
	
	protected void deleteById_xiaoxi2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("GB2312"); 
		XiaoxiDao xiaoxiDao = new XiaoxiDao();
		String id = request.getParameter("id");
		int idInt = Integer.parseInt(id);
		int b = xiaoxiDao.delete(idInt);
		if(b==1) {
			request.getRequestDispatcher("/find-manager.jsp").forward(request, response);
		}
	}
	
	

}
