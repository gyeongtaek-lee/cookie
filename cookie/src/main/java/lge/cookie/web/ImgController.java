package lge.cookie.web;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImgController {

	@RequestMapping("/imgTest")
    public String listAttach(HttpSession session,HttpServletResponse response, HttpServletRequest request) throws Exception {
    	
    	String referer 	= request.getParameter("referer");
    	String model	= request.getParameter("model");
          
    	response.setContentType( "image/gif" );
    	
    	Cookie[] cookies = request.getCookies();
     
    	Cookie cookie1 = new Cookie("test", "lge");
    	cookie1.setMaxAge(60*60);
    	response.addCookie(cookie1);
//    	ResponseCookie cookie = ResponseCookie.from("sameSiteCookie", "sameSiteCookieValue").sameSite("None").secure(true).path("/").build();
//    	response.addHeader("Set-Cookie", cookie.toString());
    	
    	if (referer != null) {
//    		Cookie cookie2 = new Cookie("referer", referer);
//    		cookie2.setMaxAge(60*60);
//    		response.addCookie(cookie2);
    		ResponseCookie cookie2 = ResponseCookie.from("referer", referer).sameSite("None").secure(true).path("/").maxAge(60*60).build();
        	response.addHeader("Set-Cookie", cookie2.toString());
    	}
    	
    	if (model != null) {
//    		Cookie cookie3 = new Cookie("model", model);
//    		cookie3.setMaxAge(60*60);
//    		response.addCookie(cookie3);
    		ResponseCookie cookie3 = ResponseCookie.from("model", model).sameSite("None").secure(true).path("/").maxAge(60*60).build();
        	response.addHeader("Set-Cookie", cookie3.toString());
    	}    	
     
    	ServletOutputStream bout = response.getOutputStream();
     
    	String imgpath = File.separator+"src"+File.separator+"main"+File.separator+"resources"+File.separator+"static"+ File.separator +"img" + File.separator + "img1.jpg";
     
//     String[] exts = {".bmp", ".jpg", ".gif", ".png", ".jpeg"};

//     String imgpath = "img1.jpg";
     
	     InputStream inputStream = null;
	     ServletOutputStream outputStream = null;
     
	     try {
	         inputStream = new URL("https://www.lge.co.kr/kr/main/main/assets/byme_main_pc.jpg").openStream();
	         outputStream = response.getOutputStream();
	         
	         int length;
	         byte[] buffer = new byte[12288]; // 12K
	         while ((length = inputStream.read(buffer)) != -1) {
	             outputStream.write(buffer, 0, length);
	         }
	         
	     } catch (Exception e) {
	         e.printStackTrace();
	         
	     } finally {
	         try {
	             if (outputStream != null) {
	                 outputStream.close();
	             }
	         } catch (NullPointerException e) {
	         } catch (Exception e) {
	         }
	         
	         try {
	             if (inputStream != null) {
	                 inputStream.close();
	             }
	         } catch (NullPointerException e) {
	         } catch (Exception e) {
	         }
	     }
     
//     FileInputStream f = new FileInputStream("D:\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\review\\WEB-INF\\classes\\static\\img");
		/*
		 * URL url = new
		 * URL("https://www.lge.co.kr/kr/main/main/assets/byme_main_pc.jpg");
		 * 
		 * 
		 * int length;
		 * 
		 * byte[] buffer = new byte[10];
		 * 
		 * while ( ( length = f.read( buffer ) ) != -1 ) {
		 * 
		 * bout.write( buffer, 0, length );
		 * 
		 * }
		 */
     
	     return null;
     
    }
	
}
