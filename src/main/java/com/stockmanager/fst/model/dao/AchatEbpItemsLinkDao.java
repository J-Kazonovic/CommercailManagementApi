package com.stockmanager.fst.model.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stockmanager.fst.bean.AchatEbpItemsLink;



@Repository
public interface AchatEbpItemsLinkDao extends JpaRepository<AchatEbpItemsLink, Long> {
	
	List<AchatEbpItemsLink> findByAchatItemId(Long id);
	
}
