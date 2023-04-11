package com.discovermarket.claimservice.clients;


import java.util.Optional;

public interface CommonClient {
    Optional<LobResponse> getLobDetails(String lobId);
}
