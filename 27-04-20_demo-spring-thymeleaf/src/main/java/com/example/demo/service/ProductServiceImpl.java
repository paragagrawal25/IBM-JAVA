package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DAO.ProductDAO;
import com.example.demo.entity.Product;

@Service
public class ProductServiceImpl implements ProductService
{
	private ProductDAO refProductDAO;

    @Autowired
	public ProductServiceImpl(ProductDAO refProductDAO) {
		super();
		this.refProductDAO = refProductDAO;
	}

	@Override
	public List<Product> listAllProducts() 
	{
		return (List<Product>) refProductDAO.findAll();
	}

	@Override
	public Product getProductById(Integer id) 
	{
		return refProductDAO.findById(id).get();
	}

	@Override
	public Product saveOrUpdateProduct(Product product) 
	{
		if (product != null)
		{
            /*if (product.getId() == null)
            {
                product.setId(getNextKey());
            }*/
			refProductDAO.save(product);
            //products.put(product.getId(), product);

            return product;
        } 
		else 
        {
            throw new RuntimeException("Product Can't be nill");
        }
	}

	@Override
	public Product updateProduct(Product product) 
	{
		if (product != null)
		{
			refProductDAO.save(product);
            return product;
        } 
		else 
        {
            throw new RuntimeException("Product Can't be nill");
        }
	}
	
	/*private Integer getNextKey(){
        return Collections.max(products.keySet()) + 1;
    }*/

    /*private void loadProducts(){
        products = new HashMap<>();

        Product product1 = new Product();
        product1.setId(1);
        product1.setDescription("Product 1");
        product1.setPrice(new BigDecimal("12.99"));
        product1.setImageUrl("http://example.com/product1");

        products.put(1, product1);

        Product product2 = new Product();
        product2.setId(2);
        product2.setDescription("Product 2");
        product2.setPrice(new BigDecimal("14.99"));
        product2.setImageUrl("http://example.com/product2");

        products.put(2, product2);

        Product product3 = new Product();
        product3.setId(3);
        product3.setDescription("Product 3");
        product3.setPrice(new BigDecimal("34.99"));
        product3.setImageUrl("http://example.com/product3");

        products.put(3, product3);

        Product product4 = new Product();
        product4.setId(4);
        product4.setDescription("Product 4");
        product4.setPrice(new BigDecimal("44.99"));
        product4.setImageUrl("http://example.com/product4");

        products.put(4, product4);

        Product product5 = new Product();
        product5.setId(5);
        product5.setDescription("Product 2");
        product5.setPrice(new BigDecimal("25.99"));
        product5.setImageUrl("http://example.com/product5");

        products.put(5, product5);
    }*/
}
