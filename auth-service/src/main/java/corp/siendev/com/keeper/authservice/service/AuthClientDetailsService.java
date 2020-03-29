/*
 * Copyright (c) 2020
 * Ghost Rider aka Golubnichenko Yuriy
 */

package corp.siendev.com.keeper.authservice.service;

import corp.siendev.com.keeper.authservice.domain.client.ClientDetailsModel;
import corp.siendev.com.keeper.authservice.repository.ClientRepository;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class AuthClientDetailsService implements ClientDetailsService {

    private ClientRepository clientRepository;

    public AuthClientDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return clientRepository.findByClientId(clientId)
                .map(ClientDetailsModel::new)
                .orElseThrow(() -> new ClientRegistrationException("Client not found: " + clientId));
    }
}
