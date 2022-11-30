
package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.PcbBomInfo;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月26日 上午12:17:01
*/
@Controller
public class PcbBomInfoDealController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/PcbBomInfoDeal")
	public String MaterielBomInfoDetail(HttpServletRequest req,Model model) {
		String retrun_String = null;
		int bomid = Integer.valueOf(req.getParameter("bomid"));
		List<PcbBomInfo> singlebominfo = mp.selectsinglebominfo(bomid);
		System.out.println(singlebominfo);

		model.addAttribute("singlebominfo",singlebominfo);
		System.out.println("this is  my singlebominfo"+ singlebominfo);
		List<PcbBomInfo> singlebominfobak = mp.selectsinglebominfo(bomid);
		System.out.println("this is  my singlebominfobak"+ singlebominfobak);

		model.addAttribute("singlebominfobak",singlebominfobak);
		
		
		
		List bominfodetail = mp.selectbominfobybomid(bomid);

		System.out.println(bominfodetail);

		model.addAttribute("bominfodetail",bominfodetail);
		if (req.getParameter("submit").equals("查询元器件")) {
//			if (bominfodetail.size()==0) {
//				System.out.println("这个板子的清单是空的，赶紧改");
//			}
//			
			System.out.println();
			retrun_String = "PcbBomInfoDetailController"; 
		}else if (req.getParameter("submit").equals("删除主板信息")) {
			mp.deletesinglebominfo(bomid);
			List<PcbBomInfo> bomlist= mp.findbominfo();
			System.out.println("this is my PcbBomInfo_bomlist "+bomlist);
			model.addAttribute("bomlist",bomlist);
			
			retrun_String = "PcbBomInfoController"; 
		}else if (req.getParameter("submit").equals("添加板子数量")) {
			System.out.println("进入到了添加板子数量分支");
			String quantity = req.getParameter("updatepcbbomnum");
			int quantity_int = Integer.valueOf(quantity);
			mp.updatepcbbomnum(quantity_int, bomid);
			System.out.println("修改板子数量结束");
			List<PcbBomInfo> bomlist= mp.findbominfo();
			System.out.println("this is my PcbBomInfo_bomlist "+bomlist);
			mp.UpdateMaterielGoodsNumByBomid(quantity_int, bomid);
			System.out.println("扣减板子库存结束");
			model.addAttribute("bomlist",bomlist);
			System.out.println("添加板子数量结束");
			
			
			retrun_String = "PcbBomInfoController"; 
		}
		
		return retrun_String;
		
		
	}
}
