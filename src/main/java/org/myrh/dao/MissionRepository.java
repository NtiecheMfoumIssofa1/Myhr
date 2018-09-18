package org.myrh.dao;

import java.util.List;

import org.myrh.entities.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MissionRepository  extends JpaRepository<Mission, Long>{
	@Transactional
	@Modifying
	@Query(" update Mission m set m.etat=false where m.id=:x")
	public void deleteMission(@Param("x")Long id);
	@Query("select m from Mission m where m.etat=true")
	public List<Mission> getAllMission();
  @Query("select m from Mission m where (m.description like :x or m.source like :x) and m.etat=true")
	public Page<Mission> getMissionPArMc(@Param("x")String mc,Pageable pageable);
}
