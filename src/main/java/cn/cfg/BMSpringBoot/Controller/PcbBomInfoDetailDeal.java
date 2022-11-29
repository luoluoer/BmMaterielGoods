package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.MaterielGoodsInfo;
import cn.cfg.BMSpringBoot.model.PcbBomInfo;
@Controller
public class PcbBomInfoDetailDeal {
	@Autowired
	MaterielGoodsSelectMapper mp ;
	@RequestMapping("/addPcbBomInfoDetail")
	public String addPcbBomInfoDetail(HttpServletRequest req,Model model) {
		String bomid = req.getParameter("addbomid");
		String skuid = req.getParameter("addskuid");
		String quantity = req.getParameter("addnum");
		int bomid_int = Integer.valueOf(bomid);
		int skuid_int  = Integer.valueOf(skuid);
		int quantity_int  = Integer.valueOf(quantity);
		List<MaterielGoodsInfo> singlegoodsinfo =  mp.singlegoodsinfo(skuid_int);
		System.out.println(singlegoodsinfo);
		if(singlegoodsinfo.size() == 0 ) {
			System.out.println("走到这里是不对的");
		}else if(singlegoodsinfo.size()!=0) {
			mp.addbominfodetail(bomid_int, skuid_int, quantity_int);
		}
		List<PcbBomInfo> singlebominfo = mp.selectsinglebominfo(bomid_int);
		model.addAttribute("singlebominfo",singlebominfo);
		List<PcbBomInfo> singlebominfobak = mp.selectsinglebominfo(bomid_int);
		model.addAttribute("singlebominfobak",singlebominfobak);		
		List bominfodetail = mp.selectbominfobybomid(bomid_int);
		model.addAttribute("bominfodetail",bominfodetail);
		return "PcbBomInfoDetailController";
	}
}
