package com.movie.Repository;

import java.util.UUID;

import com.movie.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Album, UUID>{}
