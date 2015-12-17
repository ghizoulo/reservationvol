package reservation.presentation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import reservation.metier.CompagnieManager;
import reservation.model.Compagnie;


@Controller
@RequestMapping(value="/compagnie")
@MultipartConfig(maxFileSize = 16177215) 
public class CompagnieController {
protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	CompagnieManager service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listCompagnie(Model model) throws Exception {
		if(service.list().isEmpty())
			return new ModelAndView("compagnie");
		else{
			try {
		    	ArrayList<Compagnie> listes = new ArrayList<>();
				  for(Compagnie compagnie:service.list()){
					  if(!compagnie.isDeleted()){
						  listes.add(compagnie);
					  }
				  }  
				  model.addAttribute("listeCompagnie",listes);
		    	  return new ModelAndView("compagnie");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				logger.info("erreeeeu");
			}
		}
		return null; 
	}
	
	@RequestMapping(path="add", method = RequestMethod.POST)
	public ModelAndView addCompagnie(Model model, HttpServletRequest request) {
		String UPLOAD_DIRECTORY= "C:/Users/Ghiz LOTFI/Documents/workspaceJEE/Reservation_Vol";
		String name = null;
		String nom = null;
		//process only if its multipart content
		        if(ServletFileUpload.isMultipartContent(request)){
		            try {
		                @SuppressWarnings("unchecked")
						List<FileItem> multiparts = new ServletFileUpload(  new DiskFileItemFactory()).parseRequest(request);
		                for(FileItem item : multiparts){
		                    if(!item.isFormField()){
		                        name = new File(item.getName()).getName();
		                        item.write( new File(UPLOAD_DIRECTORY+"/src/main/webapp/WEB-INF/images" + File.separator + name));
		                    }else{
		                    	String fieldName = item.getFieldName();
		                        nom = item.getString();
		                        System.out.println("test = "+fieldName+" "+nom);
		                    }
		                }
		               //File uploaded successfully
		                System.out.println("File Uploaded Successfully");
		               request.setAttribute("message", "File Uploaded Successfully");
		            } catch (Exception ex) {
		            	System.out.println("File Upload Failed due to");
		               request.setAttribute("message", "File Upload Failed due to " + ex);
		            }         
		        }else{
		            request.setAttribute("message", "Sorry this Servlet only handles file upload request");
		        }

	    try {
		    Compagnie a= new Compagnie(nom, name, false);
		    service.add(a);
		    ArrayList<Compagnie> listes = new ArrayList<>();
			  for(Compagnie compagnie:service.list()){
				  if(!compagnie.isDeleted()){
					  listes.add(compagnie);
					  
				  }
			  }
			    
			  model.addAttribute("listeCompagnie",listes);
		    return new ModelAndView("compagnie");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}
	
	@RequestMapping(path="delete", method = RequestMethod.GET)
	public ModelAndView deleteCompagnie(Model model,@RequestParam int id) {
	    try {
	    	service.delete(id);
		   // Assurance a=service.getAssuranceById(id);
		    //boolean b =a.isDeleted();
		  // System.out.println(b);
	    	ArrayList<Compagnie> listes = new ArrayList<>();
			  for(Compagnie compagnie:service.list()){
				  if(!compagnie.isDeleted()){
					  listes.add(compagnie); 
				  }
			  }  
			  model.addAttribute("listeCompagnie",listes);
		    return new ModelAndView("compagnie"); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("erreeeeu");
		}
		return null;
	}

}
