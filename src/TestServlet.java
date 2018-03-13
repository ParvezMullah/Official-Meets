

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String txt=request.getParameter("txt");
		
		
		
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Set factory constraints
		//factory.setSizeThreshold(yourMaxMemorySize);
		//factory.setRepository(yourTempDirectory);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Set overall request size constraint
		//upload.setSizeMax(yourMaxRequestSize);

		// Parse the request
		List<FileItem> items;
		try {
			items = upload.parseRequest(request);
			for (FileItem item : items) {
			    // processes only fields that are not form fields
			    if (!item.isFormField()) {
			        String fileName = new File(item.getName()).getName();
			        //fileName1+=fileName;
			        //String filePath = uploadPath + File.separator + fileName;
			        //File storeFile = new File(filePath);
			        // saves the file on disk
			        //item.write(storeFile);
			    } else {
			        //here...
			        String fieldname = item.getFieldName();
			        String fieldvalue = item.getString();
			        if (fieldname.equals("txt")) {
			        	PrintWriter out=response.getWriter();
			    		out.print(fieldvalue);
			            //logic goes here...
			        } else if (fieldname.equals("upload_wall_gallery")) {
			            //next logic goes here...
			        }
			    }
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
