
package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.MaterielGoodsInfo;
import cn.cfg.BMSpringBoot.model.PcbBomInfo;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月23日 下午9:15:11
*/
@Controller
public class PcbBomInfoController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/PcbBomInfo")
	public String MaterielBomSelect(Model model){
		List<PcbBomInfo> bomlist= mp.findbominfo();
		System.out.println("this is my bomlist "+bomlist);
		model.addAttribute("bomlist",bomlist);
		return "PcbBomInfoController";
	}
	
}
