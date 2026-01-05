package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	// Внедрение зависимости через конструктор
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// Получить все продукты
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	// Найти продукт по ID
	public Product getProductById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Продукт с id " + id + " не найден"));
	}

	// Сохранить новый продукт
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	// Удалить продукт
	public void deleteProduct(Long id) {
		productRepository.deleteById(id);
	}

	public Product updateProduct(Long id, Product productDetails) {
		// 1. Ищем существующий продукт
		Product existingProduct = productRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Продукт с id " + id + " не найден"));

		// 2. Обновляем поля (кроме ID)
		existingProduct.setName(productDetails.getName());
		existingProduct.setPrice(productDetails.getPrice());
		// добавьте остальные поля вашего класса Product

		// 3. Сохраняем обновленный объект
		return productRepository.save(existingProduct);
	}
}
