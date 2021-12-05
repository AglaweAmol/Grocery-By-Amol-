package com.grocerybyaa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocerybyaa.model.Product;
import com.grocerybyaa.model.ProductCategory;
import com.grocerybyaa.repository.ProductCategoryRepository;
import com.grocerybyaa.repository.ProductRepository;

@RestController
public class ProductCategoryController {

	@Autowired
	private ProductCategoryRepository productCategoryRepository;
	
	@GetMapping("/getallcategory")
	public List<ProductCategory> getAllProductCategory(){
		return productCategoryRepository.findAll();
		
	}
	
	
	    @GetMapping(value ="/getallcategory/{productcatid}")
	    public Optional<ProductCategory> getProductByCatID(@PathVariable("productcatid") Integer id)
	    {
	    	return productCategoryRepository.findById(id);
	    }
	
	    @DeleteMapping(value ="/getallcategory/{deletebycatid}")
	    public void deleteProductByCatId(@PathVariable("deletebycatid") Integer id)
	    {
	    	productCategoryRepository.deleteById(id);
	    }

	   @PutMapping(value ="/updatecatgory")
	   public ProductCategory updateProductByCatId(@RequestBody ProductCategory productcategory)
	    {
		   ProductCategory prodcat=productCategoryRepository.findById(productcategory.getCategoryId()).get();
		   prodcat.setCategoryName(productcategory.getCategoryName());
		   return productCategoryRepository.save(prodcat);
	    }
	
	
	
	
	
	
	
	
	
	
	
	
}
