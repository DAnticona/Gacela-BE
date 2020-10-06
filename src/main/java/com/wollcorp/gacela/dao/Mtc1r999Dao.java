package com.wollcorp.gacela.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wollcorp.gacela.entity.Mtc1r999;

public interface Mtc1r999Dao extends JpaRepository<Mtc1r999, Long> {

	public Mtc1r999 findByFgActi(String fgActi);

	@Query("SELECT m FROM Mtc1r999 m WHERE m.fgActi <> :fgActi")
	public List<Mtc1r999> findAllNotFgActi(String fgActi);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Mtc1r999 m SET m.fgActi = :newFgActi WHERE m.fgActi = :fgActi")
	public void updateAllFgActi(String newFgActi, String fgActi);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("UPDATE Mtc1r999 m SET m.fgActi = :fgActi where m.idMtc1r999 = :id")
	public void updateFgActi(Long id, String fgActi);

}
