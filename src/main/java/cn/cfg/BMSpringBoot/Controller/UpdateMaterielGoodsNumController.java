
package cn.cfg.BMSpringBoot.Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.cfg.BMSpringBoot.mapper.MaterielGoodsSelectMapper;
import cn.cfg.BMSpringBoot.model.MaterielGoodsInfo;
import cn.cfg.BMSpringBoot.model.PcbBomInfo;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月24日 下午11:17:18
*/
@Controller
public class UpdateMaterielGoodsNumController {
	@Autowired
	MaterielGoodsSelectMapper mp;
	@RequestMapping("/UpdateMaterielGoodsNum")
	public String UpdateGoodsNumController(HttpServletRequest req,Model model) {
		System.out.println(req);
		System.out.println("哈哈哈哈哈");
		System.out.println(req.getParameter("id"));
		System.out.println(req.getParameter("updatenum"));
		String id = req.getParameter("id");
		String updatenum = req.getParameter("updatenum");
		int id_int = Integer.valueOf(id);
		int updatenum_int ;
		if (updatenum ==null ||updatenum.equals("")){
			updatenum_int = Integer.valueOf(req.getParameter("quantity"));
		}else {
			updatenum_int  = Integer.valueOf(updatenum);	
		}
		//updatenum_int  = Integer.valueOf(updatenum);
		System.out.println("this is submit paramter"+req.getParameter("submit"));
		System.out.println(req.getParameter("submit").equals("删除当前记录") );
		if (req.getParameter("submit").equals("删除当前记录")) {
			mp.DeleteMaterielGoodsInfo(id_int);
		}else {
			System.out.println("执行了修改库存的方法");
			System.out.println(updatenum_int);
			mp.UpdateMaterielGoodsNum(id_int,updatenum_int);
			}
		List<MaterielGoodsInfo> mgilist= mp.findall();
		System.out.println("here is upadtematerielgoodsinfo");
		System.out.println("this is "+mgilist);
		model.addAttribute("mgilist",mgilist);
		return "MaterielGoodsSelectController";
		
	}
}
