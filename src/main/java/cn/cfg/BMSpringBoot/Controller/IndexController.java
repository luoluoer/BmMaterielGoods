
package cn.cfg.BMSpringBoot.Controller;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* 这是文档注释
* @author 柴方贵
* @version 创建时间：2022年11月23日 下午6:52:13
*/
@Controller
public class IndexController {
	
	@GetMapping("/")
	@RequestMapping("/")
	public String hello(Model model) {
		String warring = "我也不知道哪天就不能用了";
		model.addAttribute("message",warring);
		return "index";
	}
	
	
	//private UserService userService;
}
