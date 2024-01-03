package emi.emifilmsbackend.repository;

import emi.emifilmsbackend.model.FavoriteMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRespository extends JpaRepository<FavoriteMovie,Long> {
    List<FavoriteMovie> findByUsername(String username);
}
