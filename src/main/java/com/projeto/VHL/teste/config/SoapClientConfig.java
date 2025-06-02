package com.projeto.VHL.teste.config;


import br.jus.tjsc.selo.SeloService;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfig {

    @Value("${selo.service.username}")
    private String username;

    @Value("${selo.service.password}")
    private String password;

    @Value("${selo.service.address}")
    private String address;

    @Bean
    public SeloService getSeloServiceClient() {
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(SeloService.class);
        factory.setAddress(address);

        SeloService client = (SeloService) factory.create();

        Client proxy = ClientProxy.getClient(client);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();

        AuthorizationPolicy auth = new AuthorizationPolicy();
        auth.setUserName(username);
        auth.setPassword(password);
        auth.setAuthorizationType("Basic");

        conduit.setAuthorization(auth);
        return client;
    }
}
