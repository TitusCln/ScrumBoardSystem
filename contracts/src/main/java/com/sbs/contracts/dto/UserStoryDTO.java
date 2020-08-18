package com.sbs.contracts.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Set;

@JsonDeserialize(builder = UserStoryDTO.Builder.class)
public class UserStoryDTO {

    private Long id;
    private String title;
    private String description;
    private int weight;
    private Set<LabelDTO> labelDTOS;
    private Set<TaskDTO> taskDTOS;

    public UserStoryDTO(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.description = builder.description;
        this.weight = builder.weight;
        this.labelDTOS = builder.labelDTOS;
        this.taskDTOS = builder.taskDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Set<LabelDTO> getLabels() {
        return labelDTOS;
    }

    public void setLabels(Set<LabelDTO> labelDTOS) {
        this.labelDTOS = labelDTOS;
    }

    public Set<TaskDTO> getTasks() {
        return taskDTOS;
    }

    public void setTasks(Set<TaskDTO> taskDTOS) {
        this.taskDTOS = taskDTOS;
    }

    public static class Builder {
        private Long id;
        private String title;
        private String description;
        private Integer weight;
        private Set<LabelDTO> labelDTOS;
        private Set<TaskDTO> taskDTOS;

        public Builder withId(Long id) {
            this.id=id;
            return this;
        }

        public Builder withTitle(String title){
            this.title=title;
            return this;
        }

        public Builder withDescription(String description){
            this.description=description;
            return this;
        }

        public Builder withWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Builder withLabels(Set<LabelDTO> labelDTOS) {
            this.labelDTOS = labelDTOS;
            return this;
        }

        public Builder withTasks(Set<TaskDTO> taskDTOS) {
            this.taskDTOS = taskDTOS;
            return this;
        }

        public UserStoryDTO build() {
            return new UserStoryDTO(this);
        }
    }
}
