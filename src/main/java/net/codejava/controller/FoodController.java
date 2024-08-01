package net.codejava.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/food")
public class FoodController {
	
	@GetMapping({"","/apveg"}) 
		public String apveg() {
		return "food/apveg";
	}
	
	@GetMapping({"","/apnon"})
	public String apnon() {
		return "food/apnon";
	}
	
	
	@GetMapping({"","/arveg"})
	public String arveg() {
		return "food/arveg";
	}
	@GetMapping({"","/arnon"})
	public String arnon() {
		return "food/arnon";
	}
	
	@GetMapping({"","/assamveg"})
	public String assamveg() {
		return "food/assamveg";
	}
	@GetMapping({"","/assamnon"})
	public String assamnon() {
		return "food/assamnon";
	}
	
	@GetMapping({"","/biharveg"})
	public String biharveg() {
		return "food/biharveg";
	}
	@GetMapping({"","/biharnon"})
	public String biharnon() {
		return "food/biharnon";
	}
	
	@GetMapping({"","/cgveg"})
	public String cgveg() {
		return "food/cgveg";
	}
	@GetMapping({"","/cgnon"})
	public String cgnon() {
		return "food/cgnon";
	}
	

	@GetMapping({"","/delhiveg"})
	public String delhiveg() {
		return "food/delhiveg";
	}
	@GetMapping({"","/delhinon"})
	public String delhinon() {
		return "food/delhinon";
	}
	
	
	@GetMapping({"","/goaveg"})
	public String goaveg() {
		return "food/goaveg";
	}
	@GetMapping({"","/goanon"})
	public String goanon() {
		return "food/goanon";
	}
	
	@GetMapping({"","/gjveg"})
	public String gjveg() {
		return "food/gjveg";
	}
	@GetMapping({"","/gjnon"})
	public String gjnon() {
		return "food/gjnon";
	}
	
	@GetMapping({"","/hmveg"})
	public String hmveg() {
		return "food/hmveg";
	}
	@GetMapping({"","/hmnon"})
	public String hmnon() {
		return "food/hmnon";
	}
	
	
	@GetMapping({"","/hrveg"})
	public String hrveg() {
		return "food/hrveg";
	}
	@GetMapping({"","/hrnon"})
	public String hrnon() {
		return "food/hrnon";
	}
	
	@GetMapping({"","/jkveg"})
	public String jkveg() {
		return "food/jkveg";
	}
	@GetMapping({"","/jknon"})
	public String jknon() {
		return "food/jknon";
	}
	
	@GetMapping({"","/jhveg"})
	public String jhveg() {
		return "food/jhveg";
	}
	@GetMapping({"","/jhnon"})
	public String jhnon() {
		return "food/jhnon";
	}
	
	@GetMapping({"","/kaveg"})
	public String kaveg() {
		return "food/kaveg";
	}
	@GetMapping({"","/kanon"})
	public String kanon() {
		return "food/kanon";
	}
	
	@GetMapping({"","/klveg"})
	public String klveg() {
		return "food/klveg";
	}
	@GetMapping({"","/klnon"})
	public String klnon() {
		return "food/klnon";
	}
	
	@GetMapping({"","/mhveg"})
	public String mhveg() {
		return "food/mhveg";
	}
	@GetMapping({"","/mhnon"})
	public String mhnon() {
		return "food/mhnon";
	}
	
	@GetMapping({"","/mgveg"})
	public String mgveg() {
		return "food/mgveg";
	}
	@GetMapping({"","/mgnon"})
	public String mgnon() {
		return "food/mgnon";
	}
	
	@GetMapping({"","/mzveg"})
	public String mzveg() {
		return "food/mzveg";
	}
	@GetMapping({"","/mznon"})
	public String mznon() {
		return "food/mznon";
	}
	
	@GetMapping({"","/mpveg"})
	public String mpveg() {
		return "food/mpveg";
	}
	@GetMapping({"","/mpnon"})
	public String mpnon() {
		return "food/mpnon";
	}

	@GetMapping({"","/ngveg"})
	public String ngveg() {
		return "food/ngveg";
	}
	@GetMapping({"","/ngnon"})
	public String ngnon() {
		return "food/ngnon";
	}
	
	@GetMapping({"","/orveg"})
	public String orveg() {
		return "food/orveg";
	}
	@GetMapping({"","/ornon"})
	public String ornon() {
		return "food/ornon";
	}
	
	@GetMapping({"","/pbveg"})
	public String pbveg() {
		return "food/pbveg";
	}
	@GetMapping({"","/pbnon"})
	public String pbnon() {
		return "food/pbnon";
	}
	
	@GetMapping({"","/rjveg"})
	public String rjveg() {
		return "food/rjveg";
	}
	@GetMapping({"","/rjnon"})
	public String rjnon() {
		return "food/rjnon";
	}
	
	@GetMapping({"","/skveg"})
	public String skveg() {
		return "food/skveg";
	}
	@GetMapping({"","/sknon"})
	public String sknon() {
		return "food/sknon";
	}
	
	@GetMapping({"","/tmveg"})
	public String tmveg() {
		return "food/tmveg";
	}
	@GetMapping({"","/tmnon"})
	public String tmnon() {
		return "food/tmnon";
	}
	
	@GetMapping({"","/tsveg"})
	public String tsveg() {
		return "food/tsveg";
	}
	@GetMapping({"","/tsnon"})
	public String tsnon() {
		return "food/tsnon";
	}
	
	@GetMapping({"","/trveg"})
	public String trveg() {
		return "food/trveg";
	}
	@GetMapping({"","/trnon"})
	public String trnon() {
		return "food/trnon";
	}
	
	@GetMapping({"","/upveg"})
	public String upveg() {
		return "food/upveg";
	}
	@GetMapping({"","/upnon"})
	public String upnon() {
		return "food/upnon";
	}
	
	@GetMapping({"","/ukveg"})
	public String ukveg() {
		return "food/ukveg";
	}
	@GetMapping({"","/uknon"})
	public String uknon() {
		return "food/uknon";
	}
	
	@GetMapping({"","/wbveg"})
	public String wbveg() {
		return "food/wbveg";
	}
	@GetMapping({"","/wbnon"})
	public String wbnon() {
		return "food/wbnon";
	}
}