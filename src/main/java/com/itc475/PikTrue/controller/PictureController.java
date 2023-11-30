package com.itc475.PikTrue.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itc475.PikTrue.domain.Picture;
import com.itc475.PikTrue.mapper.PictureRepository;

@Controller
public class PictureController {
	
	@Autowired
	PictureRepository pictureRepo;
	
	@GetMapping("/displayImages")
	public String displayImages(Model model) {
		List<Picture> pictures = pictureRepo.findAll();
		model.addAttribute("pictures", pictures);
		for(Picture picture:pictures) {
			System.out.println(picture.getPictureName());
		}
		return "image-display";
	}

	
	@GetMapping("/searchBar")
	public String searchBar(Model model, @RequestParam String searchTerm) {
	    List<Picture> pictures = pictureRepo.searchBar(searchTerm);
	    model.addAttribute("pictures", pictures);
	    return "image-display";
	}
}
