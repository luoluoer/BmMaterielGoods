package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.MaterielGoodsInfo;

@Controller
public class addMaterielGoodsInfoController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/addMaterielGoodsInfo")
	public String addMaterielGoodsInfo(HttpServletRequest req,Model model) {
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
		List<MaterielGoodsInfo> mgilist= mp.findall();
		System.out.println("here2");
		System.out.println("this is "+mgilist);
		model.addAttribute("mgilist",mgilist);
		return "MaterielGoodsSelectController";
	}
	
}
