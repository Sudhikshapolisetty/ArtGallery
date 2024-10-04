package com.klef.jfsd.sdp.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klef.jfsd.sdp.model.Product;
import com.klef.jfsd.sdp.service.CustomerService;
import com.klef.jfsd.sdp.service.ProductManger;
import com.klef.jfsd.sdp.service.ProductService;

@RestController
@RequestMapping("/addproduct")
public class ProductController {

    @Autowired
    ProductManger productManager;

    @PostMapping("/product")
    public String register(@RequestParam("product_name") String productName,
                           @RequestParam("description") String description,
                           @RequestParam("price") double price,
                           @RequestParam("image") MultipartFile image) {
        // Process the uploaded image and other data here
        Product product = new Product();
        product.setProduct_name(productName);
        product.setDescription(description);
        product.setPrice(price);
        try {
            product.setImage(image.getBytes());
        } catch (IOException e) {
            // Handle the exception
        }
        return productManager.registration(product);
    }
    
    /*@GetMapping("displayartimg")
    public ResponseEntity<byte[]> displayprodimage(@RequestParam("id") int id) throws IOException, SQLException
    {
     Product art =CustomerService.viewartbyid(id);
      byte [] imageBytes = null;
      imageBytes = art.getImage().getBytes(1,(int)art.getImage().length());

      return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
    */

}
