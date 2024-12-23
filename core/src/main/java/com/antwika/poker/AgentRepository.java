package com.antwika.poker;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class AgentRepository {
    private final Map<UUID, IAgent> uuidToAgentMap = new HashMap<>();
    private final Map<IAgent, UUID> agentToUuidMap = new HashMap<>();

    public UUID register(IAgent agent) {
        final var uuid = agent.getUuid();
        if (uuidToAgentMap.containsKey(uuid)) throw new RuntimeException("Agent uuid already registered");
        if (uuidToAgentMap.containsValue(agent)) throw new RuntimeException("Agent already registered");
        if (agentToUuidMap.containsKey(agent)) throw new RuntimeException("Agent uuid already registered");
        if (agentToUuidMap.containsValue(uuid)) throw new RuntimeException("Agent already registered");
        uuidToAgentMap.put(uuid, agent);
        agentToUuidMap.put(agent, uuid);
        return uuid;
    }

    public Optional<IAgent> findAgentByUuid(UUID uuid) {
        return Optional.ofNullable(uuidToAgentMap.get(uuid));
    }

    public Optional<UUID> findUuidByAgent(IAgent agent) {
        return Optional.ofNullable(agentToUuidMap.get(agent));
    }
}
