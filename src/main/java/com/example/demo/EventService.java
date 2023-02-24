package com.example.demo;

import com.azure.identity.*;
import com.azure.messaging.eventhubs.EventData;
import com.azure.messaging.eventhubs.EventDataBatch;
import com.azure.messaging.eventhubs.EventHubClientBuilder;
import com.azure.messaging.eventhubs.EventHubProducerClient;
import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class EventService {

    public String connectionString = "";
    public String eventHubName = "";
    public String namespaceName  = "";

    public void sentEvent (List<EventPayload> allEvents){
        // create a token using the default Azure credential
    //    DefaultAzureCredential credential = new DefaultAzureCredentialBuilder()
    //            .authorityHost(AzureAuthorityHosts.AZURE_PUBLIC_CLOUD)
    //            .build();
        ClientSecretCredential credential = new ClientSecretCredentialBuilder()
                .tenantId("")
                .clientId("")
                .clientSecret("")
                .build();

        EventHubProducerClient producer = new EventHubClientBuilder()
                //.connectionString(connectionString, eventHubName)
                .fullyQualifiedNamespace(namespaceName)
                .eventHubName(eventHubName)
                .credential(credential)
                .buildProducerClient();

        Gson gson = new Gson();
    EventDataBatch eventDataBatch = producer.createBatch();
    for (EventPayload payload : allEvents) {
        EventData eventData = new EventData(gson.toJson(payload));
        if (!eventDataBatch.tryAdd(eventData)) {
            producer.send(eventDataBatch);
            eventDataBatch = producer.createBatch();

            // Try to add that event that couldn't fit before.
            if (!eventDataBatch.tryAdd(eventData)) {
                throw new IllegalArgumentException("Event is too large for an empty batch. Max size: "
                        + eventDataBatch.getMaxSizeInBytes());
            }
        }
    }
    // send the last batch of remaining events
    if (eventDataBatch.getCount() > 0) {
            producer.send(eventDataBatch);
        }
    }
}
