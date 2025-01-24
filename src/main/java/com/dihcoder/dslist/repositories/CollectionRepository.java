package com.dihcoder.dslist.repositories;

import com.dihcoder.dslist.entities.GameCollection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<GameCollection, Long> {
}
