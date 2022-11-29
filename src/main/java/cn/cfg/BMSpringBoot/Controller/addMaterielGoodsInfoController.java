package cn.cfg.BMSpringBoot.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;

@Controller
public class addMaterielGoodsInfoController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/addMaterielGoodsInfo")
	public String addMaterielGoodsInfo(HttpServletRequest req) {
		System.out.println(req);
		System.out.println(req.getParameter("id"));
		//int id = Integer.valueOf(req.getParameter("id"));
		String comment = req.getParameter("comment");
		System.out.println(comment);
		String description = req.getParameter("description");
		String designator = req.getParameter("designator");
		String footprint = req.getParameter("footprint");
		int  quantity = Integer.valueOf(req.getParameter("quantity"));
		
		mp.addMaterielGoodsInfo(comment, description, designator, footprint, quantity);
		return "index";
	}
	
}
