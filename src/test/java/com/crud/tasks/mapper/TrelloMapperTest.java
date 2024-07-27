package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrelloMapperTest {

    private final TrelloMapper trelloMapper = new TrelloMapper();

    @Test
    void testMapToBoards() {
        // Given
        TrelloBoardDto boardDto1 = new TrelloBoardDto("1", "Board1", Arrays.asList(new TrelloListDto("1", "List1", false)));
        TrelloBoardDto boardDto2 = new TrelloBoardDto("2", "Board2", Arrays.asList(new TrelloListDto("2", "List2", true)));
        List<TrelloBoardDto> boardDtos = Arrays.asList(boardDto1, boardDto2);

        // When
        List<TrelloBoard> boards = trelloMapper.mapToBoards(boardDtos);

        // Then
        assertEquals(2, boards.size());
        assertEquals("1", boards.get(0).getId());
        assertEquals("Board1", boards.get(0).getName());
        assertEquals(1, boards.get(0).getLists().size());
    }

    @Test
    void testMapToBoardsDto() {
        // Given
        TrelloBoard board1 = new TrelloBoard("1", "Board1", Arrays.asList(new TrelloList("1", "List1", false)));
        TrelloBoard board2 = new TrelloBoard("2", "Board2", Arrays.asList(new TrelloList("2", "List2", true)));
        List<TrelloBoard> boards = Arrays.asList(board1, board2);

        // When
        List<TrelloBoardDto> boardDtos = trelloMapper.mapToBoardsDto(boards);

        // Then
        assertEquals(2, boardDtos.size());
        assertEquals("1", boardDtos.get(0).getId());
        assertEquals("Board1", boardDtos.get(0).getName());
        assertEquals(1, boardDtos.get(0).getLists().size());
    }

    @Test
    void testMapToList() {
        // Given
        TrelloListDto listDto1 = new TrelloListDto("1", "List1", false);
        TrelloListDto listDto2 = new TrelloListDto("2", "List2", true);
        List<TrelloListDto> listDtos = Arrays.asList(listDto1, listDto2);

        // When
        List<TrelloList> lists = trelloMapper.mapToList(listDtos);

        // Then
        assertEquals(2, lists.size());
        assertEquals("1", lists.get(0).getId());
        assertEquals("List1", lists.get(0).getName());
        assertEquals(false, lists.get(0).isClosed());
    }

    @Test
    void testMapToListDto() {
        // Given
        TrelloList list1 = new TrelloList("1", "List1", false);
        TrelloList list2 = new TrelloList("2", "List2", true);
        List<TrelloList> lists = Arrays.asList(list1, list2);

        // When
        List<TrelloListDto> listDtos = trelloMapper.mapToListDto(lists);

        // Then
        assertEquals(2, listDtos.size());
        assertEquals("1", listDtos.get(0).getId());
        assertEquals("List1", listDtos.get(0).getName());
        assertEquals(false, listDtos.get(0).isClosed());
    }

    @Test
    void testMapToCardDto() {
        // Given
        TrelloCard card = new TrelloCard("Test task", "Test Description", "top", "test_id");

        // When
        TrelloCardDto cardDto = trelloMapper.mapToCardDto(card);

        // Then
        assertEquals("Test task", cardDto.getName());
        assertEquals("Test Description", cardDto.getDescription());
        assertEquals("top", cardDto.getPos());
        assertEquals("test_id", cardDto.getListId());
    }

    @Test
    void testMapToCard() {
        // Given
        TrelloCardDto cardDto = new TrelloCardDto("Test task", "Test Description", "top", "test_id");

        // When
        TrelloCard card = trelloMapper.mapToCard(cardDto);

        // Then
        assertEquals("Test task", card.getName());
        assertEquals("Test Description", card.getDescription());
        assertEquals("top", card.getPos());
        assertEquals("test_id", card.getListId());
    }
}