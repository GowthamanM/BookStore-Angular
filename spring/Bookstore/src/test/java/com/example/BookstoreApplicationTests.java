package com.example;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

//import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.repository.ProductsRepository;
import com.example.model.ProductModel;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class BookstoreApplicationTests {
	
	@Autowired
    private MockMvc mockMvc;	
//	
//	@Autowired
//	public ProductsRepository productRepo;
//	
//	static List<ProductModel> sampleList = null;
//	
//	public List<ProductModel> getAllProductsSample() {
//		return productRepo.findAll();
//	}

	
	
//	 //Testing Login by checking whether the user details are sent and get response data
//	 @Test
//	 public void checkUserTest() throws Exception {
//	 	String userOne = "{\"email\":\"Monorail\",\"password\":\"Something\"}";
//	    mockMvc.perform(MockMvcRequestBuilders.post("/login")
//	    	.contentType(MediaType.APPLICATION_JSON)
//	        .content(userOne)
//	        .accept(MediaType.APPLICATION_JSON))
//	        .andExpect(status().isOk())
//	        .andExpect(jsonPath("$").value("true"))
//	        .andReturn();
//	 }
	 
	 //Testing Login and Sign Up 
	 @Test
	 public void saveUserTest() throws Exception {
		 
		//Sign Up
	 	String userOne = "{\"email\":\"Test@gmail.com\",\"username\":\"TestSignup\",\"mobileNumber\":\"1234598760\",\"password\":\"Testing\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/signup")
	    	.contentType(MediaType.APPLICATION_JSON)
	        .content(userOne)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$").value("true"))
	        .andReturn();
	    
	    //Login
	    String dataOne = "{\"email\":\"Test@gmail.com\",\"password\":\"Testing\"}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/login")
	    	.contentType(MediaType.APPLICATION_JSON)
	        .content(dataOne)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$").value("true"))
	        .andReturn();
	 }
	 
	 
	//Add Product
	@Test
	public void productSaveTest() throws Exception {
	 	String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL\",\"productName\":\"TestingName\",\"price\":\"100\",\"description\":\"TestingDescription\",\"quantity\":10}";
	    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
	    	.contentType(MediaType.APPLICATION_JSON)
	        .content(prodOne)
	        .accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andReturn();
	    
	 }
	 
	 
	 //Home
	 @Test
	 public void getHomeProductTest() throws Exception {
		 
		 String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL1\",\"productName\":\"TestingName1\",\"price\":\"100\",\"description\":\"TestingDescription1\",\"quantity\":10}";
		    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
		    	.contentType(MediaType.APPLICATION_JSON)
		        .content(prodOne)
		        .accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andReturn();
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/home")
			.accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andDo(print())
	        .andExpect(MockMvcResultMatchers.jsonPath("$[*].productName").exists())
//	        .andExpect(jsonPath("$[0].productName").value("me"))
//	        .andExpect(jsonPath().length > 0)
	        .andReturn();
		 
		    
	 }
	 
	 @Test
	 public void getProductTest() throws Exception {
		 
		 String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL1\",\"productName\":\"TestingName1\",\"price\":\"100\",\"description\":\"TestingDescription1\",\"quantity\":10}";
		    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
		    	.contentType(MediaType.APPLICATION_JSON)
		        .content(prodOne)
		        .accept(MediaType.APPLICATION_JSON))
		        .andExpect(status().isOk())
		        .andReturn();
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/admin")
			.accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andDo(print())
	        .andExpect(MockMvcResultMatchers.jsonPath("$[*].productName").exists())
//	        .andExpect(jsonPath("$[0].productName").value("me"))
//	        .andExpect(jsonPath().length > 0)
	        .andReturn();
		 
		    
	 }
	 
	 @Test
	 public void getProductsTest() throws Exception {
		 
		 mockMvc.perform(MockMvcRequestBuilders.get("/admin/orders")
			.accept(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
//	        .andDo(print())
//	        .andExpect(MockMvcResultMatchers.jsonPath("$[*].productName").exists())
//	        .andExpect(jsonPath("$[0].productName").value("me"))
//	        .andExpect(jsonPath().length > 0)
	        .andReturn();
		 
		    
	 }
	 
	 
//	//Add to Cart
//		 @Test
//		 public void addToCartByNameTest() throws Exception {
//			    String dtOne = "2 Test@gmail.com";
//			    mockMvc.perform(MockMvcRequestBuilders.post("/home/dup/TestingName")
//			    	.contentType(MediaType.APPLICATION_JSON)
//			        .content(dtOne)
//			        .accept(MediaType.APPLICATION_JSON))
//			        .andExpect(status().isOk());
////			        .andReturn();	
//			    
//			    
//			    
//		 }
	 
	 
//	 @Test
//	 public void productSave1Test() throws Exception {
//	 	String prodOne = "{\"productId\":\"12\",\"imageUrl\":\"Test1\",\"productName\":\"Test2\",\"description\":\"Test3\"}";
//	    mockMvc.perform(MockMvcRequestBuilders.post("/addProduct")
//	    	.contentType(MediaType.APPLICATION_JSON)
//	        .content(prodOne)
//	        .accept(MediaType.APPLICATION_JSON))
//	        .andExpect(status().isOk())
//	        .andReturn();
//	 }
	 
	 //CartList
//	 @Test
//	 public void showCartTest() throws Exception {
//		 
//		 String userOne = "{\"email\":\"Test1@gmail.com\",\"username\":\"TestSignup1\",\"mobileNumber\":\"1234598760\",\"password\":\"Testing1\"}";
//		    mockMvc.perform(MockMvcRequestBuilders.post("/signup")
//		    	.contentType(MediaType.APPLICATION_JSON)
//		        .content(userOne)
//		        .accept(MediaType.APPLICATION_JSON));
////		        .andExpect(status().isOk())
////		        .andExpect(jsonPath("$").value("true"))
////		        .andReturn();
//		    
//		    String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL2\",\"productName\":\"TestingName2\",\"price\":\"100\",\"description\":\"TestingDescription2\",\"quantity\":10}";
//		    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
//		    	.contentType(MediaType.APPLICATION_JSON)
//		        .content(prodOne)
//		        .accept(MediaType.APPLICATION_JSON));
////		        .andExpect(status().isOk())
////		        .andReturn();
//		 
//		 String dtOne = "4 Test1@gmail.com";
//		    mockMvc.perform(MockMvcRequestBuilders.post("/home/dup/TestingName2")
//		    	.contentType(MediaType.APPLICATION_JSON)
//		        .content(dtOne)
//		        .accept(MediaType.APPLICATION_JSON));
////		        .andExpect(status().isOk());
////		    	.andReturn();
//		    
//		 mockMvc.perform(MockMvcRequestBuilders.get("/cart/Test1@gmail.com")
//			.accept(MediaType.APPLICATION_JSON))
//	        .andExpect(status().isOk())
//	        .andExpect(MockMvcResultMatchers.jsonPath("$[*].userId").exists())
////	        .andExpect(jsonPath("$[0].userId").value("Test@gmail.com"))
//	        .andReturn();
//	 }
//	 	
//	//Save Order
////		 @Test
////		 public void saveOrdersTest() throws Exception {
////			 
////			 String userOne = "{\"email\":\"Test2@gmail.com\",\"username\":\"TestSignup2\",\"mobileNumber\":\"1234598760\",\"password\":\"Testing2\"}";
////			    mockMvc.perform(MockMvcRequestBuilders.post("/signup")
////			    	.contentType(MediaType.APPLICATION_JSON)
////			        .content(userOne)
////			        .accept(MediaType.APPLICATION_JSON))
////			        .andExpect(status().isOk())
////			        .andExpect(jsonPath("$").value("true"))
////			        .andReturn();
////			    
////			    String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL3\",\"productName\":\"TestingName3\",\"price\":\"100\",\"description\":\"TestingDescription3\",\"quantity\":10}";
////			    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
////			    	.contentType(MediaType.APPLICATION_JSON)
////			        .content(prodOne)
////			        .accept(MediaType.APPLICATION_JSON))
////			        .andExpect(status().isOk())
////			        .andReturn();
////			 
////			 String dtTwo = "2 Test2@gmail.com";
////			    mockMvc.perform(MockMvcRequestBuilders.post("/home/dup/TestingName2")
////			    	.contentType(MediaType.APPLICATION_JSON)
////			        .content(dtTwo)
////			        .accept(MediaType.APPLICATION_JSON))
////			        .andExpect(status().isOk());
//////			        .andReturn();	
////			    
////		 	String dataOne = "Test2@gmail.com";
////		    mockMvc.perform(MockMvcRequestBuilders.post("/saveOrder")
////		    	.contentType(MediaType.APPLICATION_JSON)
////		        .content(dataOne)
////		        .accept(MediaType.APPLICATION_JSON))
////		        .andExpect(status().isOk())
////		        .andReturn();
////		 }
//	 
//	 //OrdersList
//	 @Test
//	 public void getOrdersTest() throws Exception {
//		 
//		 String userOne = "{\"email\":\"Test3@gmail.com\",\"username\":\"TestSignup3\",\"mobileNumber\":\"1234598760\",\"password\":\"Testing3\"}";
//		    mockMvc.perform(MockMvcRequestBuilders.post("/signup")
//		    	.contentType(MediaType.APPLICATION_JSON)
//		        .content(userOne)
//		        .accept(MediaType.APPLICATION_JSON));
////		        .andExpect(status().isOk())
////		        .andExpect(jsonPath("$").value("true"))
////		        .andReturn();
//		    
//		    String prodOne = "{\"productId\":\"123\",\"imageUrl\":\"TestingURL4\",\"productName\":\"TestingName4\",\"price\":\"100\",\"description\":\"TestingDescription4\",\"quantity\":10}";
//		    mockMvc.perform(MockMvcRequestBuilders.post("/admin/addProduct")
//		    	.contentType(MediaType.APPLICATION_JSON)
//		        .content(prodOne)
//		        .accept(MediaType.APPLICATION_JSON));
////		        .andExpect(status().isOk())
////		        .andReturn();
//		 
//		 String dtTwo = "2 Test3@gmail.com";
//		    mockMvc.perform(MockMvcRequestBuilders.post("/home/dup/TestingName4")
//		    	.contentType(MediaType.APPLICATION_JSON)
//		        .content(dtTwo)
//		        .accept(MediaType.APPLICATION_JSON));
////		        .andExpect(status().isOk())
////		        .andReturn();	
//		    
//	 	String dataOne = "Test3@gmail.com";
//	    mockMvc.perform(MockMvcRequestBuilders.post("/saveOrder")
//	    	.contentType(MediaType.APPLICATION_JSON)
//	        .content(dataOne)
//	        .accept(MediaType.APPLICATION_JSON))
//	        .andExpect(status().isOk())
//	        .andReturn();
//		 
//	 	String datasOne = "Test3@gmail.com";
//	    mockMvc.perform(MockMvcRequestBuilders.post("/orders")
//	    	.contentType(MediaType.APPLICATION_JSON)
//	        .content(datasOne)
//	        .accept(MediaType.APPLICATION_JSON))
//	        .andExpect(status().isOk())
//	        .andExpect(MockMvcResultMatchers.jsonPath("$[*].productName").exists())
////	        .andExpect(jsonPath("$[0].productName").value("TestingName1"))
//	        .andReturn();
//	 }
	 
//	 @Test
//	 public void getUserProducts1Test() throws Exception {
//	 	String dataOne = "tg";
//	    mockMvc.perform(MockMvcRequestBuilders.post("/orders")
//	    	.contentType(MediaType.APPLICATION_JSON)
//	        .content(dataOne)
//	        .accept(MediaType.APPLICATION_JSON))
//	        .andExpect(status().isOk())
//	        .andExpect(jsonPath("$[0].productName").value("Half Girlfriend"))
//	        .andReturn();
//	 }
	 
	 
}
