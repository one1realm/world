package com.antwika;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PlayerRepository {
    private final Map<String, IPlayer> players = new HashMap<>();

    public IPlayer register(IPlayer player) {
        if (players.containsKey(player.getPlayerName())) throw new RuntimeException("Player already registered");
        return players.put(player.getPlayerName(), player);
    }

    public Optional<IPlayer> findByPlayerName(String playerName) {
        return Optional.ofNullable(players.get(playerName));
    }
}
