package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrelloService {

    private final TrelloClient trelloClient;
    private final SimpleEmailService emailService;
    private final AdminConfig adminConfig; // Add this line

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createTrelloCard(final TrelloCardDto trelloCardDto) {
        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);
        if (newCard != null) {
            String subject = "New card: " + trelloCardDto.getName() + " has been created on your Trello account";
            Mail mail = Mail.builder()
                    .mailTo(adminConfig.getAdminMail())
                    .subject(subject)
                    .message(subject)
                    .build();
            emailService.send(mail);
        }
        return newCard;
    }
}
