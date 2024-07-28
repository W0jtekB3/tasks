package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatedTrelloCardTest {

    @Test
    public void testCreatedTrelloCard() {
        CreatedTrelloCard.Trello trello = new CreatedTrelloCard.Trello(5, 10);
        CreatedTrelloCard.AttachmentsByType attachmentsByType = new CreatedTrelloCard.AttachmentsByType(trello);
        CreatedTrelloCard.Badges badges = new CreatedTrelloCard.Badges(1, attachmentsByType);
        CreatedTrelloCard card = new CreatedTrelloCard("1", "Test Card", "http://test.com", badges);

        assertEquals("1", card.getId());
        assertEquals("Test Card", card.getName());
        assertEquals("http://test.com", card.getShortUrl());
        assertEquals(1, card.getBadges().getVotes());
        assertEquals(5, card.getBadges().getAttachmentsByType().getTrello().getBoard());
        assertEquals(10, card.getBadges().getAttachmentsByType().getTrello().getCard());
    }
}
