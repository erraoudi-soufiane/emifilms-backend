package emi.emifilmsbackend.controller;

import emi.emifilmsbackend.model.FavoriteMovie;
import emi.emifilmsbackend.repository.FavoriteRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {
    @Autowired
    private FavoriteRespository favoriteRespository;

    @GetMapping("/{username}")
    public List<FavoriteMovie> getFavoritesByUsername(@PathVariable String username) {
        return favoriteRespository.findByUsername(username);
    }

    @PostMapping("/")
    public FavoriteMovie saveFavorite(@RequestBody FavoriteMovie favoriteMovie) {
        return favoriteRespository.save(favoriteMovie);
    }
    @DeleteMapping("/{id}")
    public void deleteFavorite(@PathVariable Long id) {
        favoriteRespository.deleteById(id);
    }

}
