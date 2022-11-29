
package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.MaterielGoodsInfo;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月23日 下午9:15:11
*/
//@RestController
@Controller
public class MaterielGoodsSelectController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/MaterielGoodsSelect")
	public String MaterielGoodsSelect(Model model){
		System.out.println("here1");
		List<MaterielGoodsInfo> mgilist= mp.findall();
		System.out.println("here2");
		System.out.println("this is "+mgilist);
		model.addAttribute("mgilist",mgilist);
		return "MaterielGoodsSelectController";
		//return mgilist;
	}
	
}
