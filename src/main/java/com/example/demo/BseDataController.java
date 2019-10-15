package com.example.demo;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/Bse")
public class BseDataController {

	@Autowired
	private BseDataService bseDataService;
	
	@GetMapping("/all")
	public List<BseData> getAllBseData(){
		return bseDataService.findAll();
	}
	
	@PostMapping("/save")
	public BseData saveBsedata(@RequestBody BseData bseData) {
		
		return bseDataService.save(bseData);
	}
	
	@GetMapping("/excel")
	public List<BseData> getDataFromExcel(){
		return bseDataService.getDataFromExcel();
	}
	
	

}