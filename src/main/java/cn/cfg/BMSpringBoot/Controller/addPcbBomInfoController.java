package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.PcbBomInfo;

@Controller
public class addPcbBomInfoController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/addPcbBomInfo")
	public String addPcbBomInfo(HttpServletRequest req,Model model) {
		String bomid = req.getParameter("bomid");
		String bomname = req.getParameter("bomname");
		String bomquantity = req.getParameter("bomquantity");
		int bomid_int = Integer.valueOf(bomid);
		int bomquantity_int = Integer.valueOf(bomquantity);
		mp.addpcbbominfo(bomid_int, bomname,bomquantity_int);
		List<PcbBomInfo> bomlist = mp.findbominfo();
		model.addAttribute("bomlist",bomlist);
		return "PcbBomInfoController";
	}
}
