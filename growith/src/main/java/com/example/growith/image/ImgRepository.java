package com.example.growith.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImgRepository extends JpaRepository<Image, Integer> {
    Optional<Image> findBySelected(boolean selected);
}

