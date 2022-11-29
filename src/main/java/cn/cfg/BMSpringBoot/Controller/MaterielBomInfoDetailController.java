
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
public class MaterielBomInfoDetailController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/PcbBomInfoDetail")
	public String MaterielBomInfoDetail(HttpServletRequest req,Model model) {
		int bomid = Integer.valueOf(req.getParameter("bomid"));
		List<PcbBomInfo> singlebominfo = mp.selectsinglebominfo(bomid);
		System.out.println(singlebominfo);
		System.out.println("执行1");
		model.addAttribute("singlebominfo",singlebominfo);
		System.out.println("执行2");
		List bominfodetail = mp.selectbominfobybomid(bomid);
		System.out.println("执行3");
		System.out.println(bominfodetail);
		System.out.println("执行4");
		model.addAttribute("bominfodetail",bominfodetail);
		return "MaterielBomInfoDetailController";
	}
}