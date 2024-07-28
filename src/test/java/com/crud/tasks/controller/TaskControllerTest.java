package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private TaskController taskController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = standaloneSetup(taskController).build();
    }

    @Test
    public void shouldFetchEmptyTaskList() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/v1/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void shouldFetchTask() throws Exception {
        // Given & When & Then
        mockMvc.perform(get("/v1/tasks/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("test title")))
                .andExpect(jsonPath("$.content", is("test_content")));
    }

    @Test
    public void shouldDeleteTask() throws Exception {
        // Given & When & Then
        mockMvc.perform(delete("/v1/tasks/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateTask() throws Exception {
        // Given & When & Then
        TaskDto taskDto = new TaskDto(1L, "Edited test title", "Test content");

        mockMvc.perform(put("/v1/tasks")
                        .contentType("application/json")
                        .content("{\"id\":1,\"title\":\"Edited test title\",\"content\":\"Test content\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.title", is("Edited test title")))
                .andExpect(jsonPath("$.content", is("Test content")));
    }

    @Test
    public void shouldCreateTask() throws Exception {
        // Given & When & Then
        TaskDto taskDto = new TaskDto(1L, "test title", "test_content");

        mockMvc.perform(post("/v1/tasks")
                        .contentType("application/json")
                        .content("{\"id\":1,\"title\":\"test title\",\"content\":\"test_content\"}"))
                .andExpect(status().isOk());
    }
}
