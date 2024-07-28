package com.crud.tasks.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreatedTrelloCardDtoTest {

    @Test
    public void testCreatedTrelloCardDto() {
        CreatedTrelloCardDto.Trello trello = new CreatedTrelloCardDto.Trello(5, 10);
        CreatedTrelloCardDto.AttachmentsByType attachmentsByType = new CreatedTrelloCardDto.AttachmentsByType(trello);
        CreatedTrelloCardDto.Badges badges = new CreatedTrelloCardDto.Badges(1, attachmentsByType);
        CreatedTrelloCardDto cardDto = new CreatedTrelloCardDto("1", "Test Card", "https://test.com", badges);

        assertEquals("1", cardDto.getId());
        assertEquals("Test Card", cardDto.getName());
        assertEquals("https://test.com", cardDto.getShortUrl());
        assertEquals(1, cardDto.getBadges().getVotes());
        assertEquals(5, cardDto.getBadges().getAttachmentsByType().getTrello().getBoard());
        assertEquals(10, cardDto.getBadges().getAttachmentsByType().getTrello().getCard());
    }
}
