package net.codejava.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/statepage")



public class StateController {
	
	@GetMapping({"","/"})
	public String index() {
		return "index";
	}
	@GetMapping({"","/ap"})
	public String showstate() {
		return "statepage/ap";
	}  
	
	
	@GetMapping({"","/delhi"})
	public String delhi() {
		return "statepage/delhi";
	}
	
	@GetMapping({"","/ar"})
	public String ar() {
		return "statepage/ar";
	}  
	
	@GetMapping({"","/assam"})
	public String assam() {
		return "statepage/assam";
	}  
	@GetMapping({"","/bihar"})
	public String bihar() {
		return "statepage/bihar";
	}  
	
	@GetMapping({"","/cg"})
	public String cg() {
		return "statepage/cg";
	}  
	
	@GetMapping({"","/goa"})
	public String goa() {
		return "statepage/goa";
	}  
	
	@GetMapping({"","/gj"})
	public String gj() {
		return "statepage/gj";
	}  
	
	@GetMapping({"","/hm"})
	public String hm() {
		return "statepage/hm";
	}  
	
	@GetMapping({"","/hr"})
	public String hr() {
		return "statepage/hr";
	}  
	
	@GetMapping({"","/jk"})
	public String jk() {
		return "statepage/jk";
	} 
	
	@GetMapping({"","/jh"})
	public String jh() {
		return "statepage/jh";
	} 
	
	@GetMapping({"","/ka"})
	public String ka() {
		return "statepage/ka";
	} 
	
	@GetMapping({"","/kl"})
	public String kl() {
		return "statepage/kl";
	} 
	
	@GetMapping({"","/mh"})
	public String mh() {
		return "statepage/mh";
	}
	
	
	@GetMapping({"","/ml"})
	public String ml() {
		return "statepage/ml";
	} 
	
	@GetMapping({"","/mg"})
	public String mg() {
		return "statepage/mg";
	} 
	
	@GetMapping({"","/mz"})
	public String mz() {
		return "statepage/mz";
	} 
	
	@GetMapping({"","/mp"})
	public String mp() {
		return "statepage/mp";
	} 
	
	@GetMapping({"","/ng"})
	public String ng() {
		return "statepage/ng";
	} 
	
	@GetMapping({"","/or"})
	public String or() {
		return "statepage/or";
	} 
	
	@GetMapping({"","/pb"})
	public String pb() {
		return "statepage/pb";
	} 
	
	@GetMapping({"","/rj"})
	public String rj() {
		return "statepage/rj";
	} 
	
	@GetMapping({"","/sk"})
	public String sk() {
		return "statepage/sk";
	} 
	
	@GetMapping({"","/tm"})
	public String tm() {
		return "statepage/tm";
	} 
	
	@GetMapping({"","/ts"})
	public String ts() {
		return "statepage/ts";
	}  
	
	
	@GetMapping({"","/tr"})
	public String tr() {
		return "statepage/tr";
	} 
	@GetMapping({"","uk"})
	public String uk() {
		return "statepage/uk";
	} 
	@GetMapping({"","/up"})
	public String up() {
		return "statepage/up";
	} 
	@GetMapping({"","/wb"})
	public String wb() {
		return "statepage/wb";
	} 
	
}