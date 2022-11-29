package cn.cfg.BMSpringBoot.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UpdateBomDetailNum {
	@RequestMapping("/UpdateBomDetailNum")
	public String UpdateBomDetailNum(HttpServletRequest req){
		String button = req.getParameter("submit");
		if(button.equals("提交")) {
			
		}else if (button.equals("删除所需物资")) {
			
		}
		return "MaterielBomInfoDetail";
	}
}
