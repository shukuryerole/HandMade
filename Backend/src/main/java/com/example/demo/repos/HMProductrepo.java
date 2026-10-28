package com.example.demo.repos;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.HMProduct;

@Repository
public interface HMProductrepo extends JpaRepository <HMProduct, Integer> {

	List<HMProduct> findByAvilTrue();
	
	
	//-----------GetByid is missing above

	List<HMProduct> findByCategoryAndAvilTrue(String category);

	List<HMProduct> findByCategoryAndColorAndAvilTrue(String category, String color);

	List<HMProduct> findByPriceBetweenAndAvilTrue(Double min, Double max);

	List<HMProduct> findByTitleContainingIgnoreCaseAndAvilTrue(String keyword);

	List<HMProduct> findByQuantityLessThan(Integer quantity);

	List<HMProduct> findByCategoryAndPriceBetweenAndAvilTrue(String category, Double min, Double max);

	HMProduct findBySku(String sku);

	List<HMProduct> findByIsEcoFriendlyTrue();

	List<HMProduct> findByIsHandmadeTrue();


	List<HMProduct> findAllByOrderByPriceAsc();


	List<HMProduct> findAllByOrderByPriceDesc();


	List<HMProduct> findByQuantityGreaterThan(Integer quantity);


	List<HMProduct> findByOriginDistrict(String district);


	List<HMProduct> findByOriginState(String state);


	List<HMProduct> findByArtisanName(String artisan);


	List<HMProduct> findByCreatedAtBefore(LocalDateTime date);


	List<HMProduct> findByCreatedAtAfter(LocalDateTime date);


	List<HMProduct> findByGiTagNumber(String giTagNumber);


	List<HMProduct> findByCategoryAndPriceBetweenAndAvil(String category, Double min, Double max, boolean available);


	List<HMProduct> findTop10ByOrderByCreatedAtDesc();


	List<HMProduct> findTop10ByOrderByPriceDesc();


	List<HMProduct> findByGiproductTrue();

	
}
