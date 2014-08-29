package cn.cnic.dp.controller;

import cn.cnic.dp.bean.Customer;
import cn.cnic.dp.service.CustomerService;
import cn.cnic.dp.util.PageUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@Scope("prototype")
@RequestMapping("/customer")
public class CustomerController extends BaseControllor {

	@Resource
	private CustomerService customerService;
	
	/**
	 * transient ----> persist
	 * @return
	 */
	@RequestMapping("/save")
	public @ResponseBody Customer saveCustomer() {
		Customer c = new Customer();
		c.setName("bvc");
		customerService.save(c);
		return c;
	}
	/**
	 * detached ----> persist
	 * @return
	 */
	@RequestMapping("/merge")
	public @ResponseBody Customer mergeCustomer() {
		Customer c = new Customer();
		c.setId(6);
		c.setName("pangbo");
		customerService.merge(c);
		return c;
	}
	
	/**
	 * persist ----> persist
	 * refresh方法可以保证当前的实例与数据库中的实例的内容一致。
	 * @return
	 */
	@RequestMapping("/refresh")
	public @ResponseBody Customer refreshCustomer() {
		Customer c = new Customer();
		c.setName("tuck");
		customerService.refresh(c);
		return c;
	}
	
	/**
	 * persist ----> removed
	 * @return
	 */
	@RequestMapping("/remove")
	public void removeCustomer() {
        Customer c = new Customer();
        c.setId(2);
		customerService.remove(c);
	}
	
	@RequestMapping("/list")
	public String getAllApplication(Model model, @RequestParam(defaultValue="1", required=false, value="pageNo")int pageNo, @RequestParam(defaultValue=PAGE_SIZE, required=false, value="pageSize")int pageSize, HttpServletRequest request) {
		String requestUrl = request.getRequestURL().toString();
		String parameter = request.getQueryString()==null?"1=1":request.getQueryString();
		
		PageUtil<Customer> customers = customerService.findCustomerPage(pageNo, pageSize);
		
		model.addAttribute("page", customers);
		model.addAttribute("url", requestUrl + "?" + parameter);
		model.addAttribute("location", "客户信息预览");
		return "user/list";
		
	}
}