package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    // Get all players
    @GetMapping
    public List<Player> getPlayers() {
        return service.getPlayers();
    }

    // Add a player
    @PostMapping
    public Player addPlayer(@RequestParam String name) {
        return service.addPlayer(name);
    }

    // Remove a player
    @DeleteMapping("/{id}")
    public void removePlayer(@PathVariable int id) {
        service.removePlayer(id);
    }

    // Move to end
    @PutMapping("/{id}/moveToEnd")
    public void moveToEnd(@PathVariable int id) {
        service.moveToEnd(id);
    }

    // Move down by one
    @PutMapping("/{id}/moveDown")
    public void moveDown(@PathVariable int id) {
        service.moveDown(id);
    }
}
