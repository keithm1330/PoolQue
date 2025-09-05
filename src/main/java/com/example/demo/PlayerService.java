package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class PlayerService {
    private final LinkedList<Player> players = new LinkedList<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    // Get all players
    public List<Player> getPlayers() {
        return players;
    }

    public Player addPlayer(String name) {
        // Capitalize first letter
        if (name != null && !name.isBlank()) {
            name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
        }
        Player p = new Player(idCounter.incrementAndGet(), name);
        players.add(p);
        return p;
    }


    // Remove a player by ID
    public void removePlayer(int id) {
        players.removeIf(p -> p.getId() == id);
    }

    // Move a player to the end
    public void moveToEnd(int id) {
        Player found = players.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
        if (found != null) {
            players.remove(found);
            players.add(found);
        }
    }

    // Move a player down by one position
    public void moveDown(int id) {
        for (int i = 0; i < players.size() - 1; i++) {
            if (players.get(i).getId() == id) {
                // swap with the next player
                Player temp = players.get(i + 1);
                players.set(i + 1, players.get(i));
                players.set(i, temp);
                break;
            }
        }
    }
}


