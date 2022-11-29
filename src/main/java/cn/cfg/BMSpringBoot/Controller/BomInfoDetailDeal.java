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
public class BomInfoDetailDeal {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/BomInfoDetailDeal")
	public String UpdateBomDetailNum(HttpServletRequest req,Model model){
		String button = req.getParameter("submit");
		String bomid = req.getParameter("bomid");
		String skuid = req.getParameter("skuid");
		String updatenum = req.getParameter("updatenum");
		int bomid_int = Integer.valueOf(bomid);
		int skuid_int = Integer.valueOf(skuid);
		int updatenum_int = Integer.valueOf(updatenum);
		if(button.equals("修改数量")) {
			mp.updatebominfodetailbybomidandskuid(bomid_int,skuid_int,updatenum_int);
		}else if (button.equals("删除所需物资")) {
			mp.deletebominfodetailbybomidandskuid(bomid_int,skuid_int);
		}
		List<PcbBomInfo> singlebominfo = mp.selectsinglebominfo(bomid_int);
		model.addAttribute("singlebominfo",singlebominfo);
		List bominfodetail = mp.selectbominfobybomid(bomid_int);
		System.out.println(bominfodetail);
		model.addAttribute("bominfodetail",bominfodetail);
		
		
		return "PcbBomInfoDetailController";
	}
}
