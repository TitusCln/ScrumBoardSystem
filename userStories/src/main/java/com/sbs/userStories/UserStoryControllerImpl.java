package com.sbs.userStories;

import com.sbs.contracts.dto.LabelDTO;
import com.sbs.contracts.dto.TaskDTO;
import com.sbs.contracts.dto.UserStoryDTO;
import com.sbs.userStories.services.LabelService;
import com.sbs.userStories.services.TaskService;
import com.sbs.userStories.services.UserStoryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserStoryControllerImpl implements UserStoryController {

  @Autowired
  private UserStoryService userStoryService;

  @Autowired
  private TaskService taskService;

  @Autowired
  private LabelService labelService;

  @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "Gets all User Stories")
  public Iterable<UserStoryDTO> getAllUsersStories() {
    return userStoryService.getAllUserStories();
  }

  @GetMapping(value = "/userstories", produces = MediaType.APPLICATION_JSON_VALUE, params = {"ids"})
  @ApiOperation(value = "Gets all the Users Stories that match the ids criteria")
  public Iterable<UserStoryDTO> getUserStoriesByIds(@RequestParam List<Long> ids) {
    return userStoryService.getByIds(ids);
  }

  @GetMapping(value = "/userstories/{userStoryId}")
  @ApiOperation(value = "Gets the User Story by its userStoryId")
  public UserStoryDTO getUserStory(@PathVariable Long userStoryId) {
    return userStoryService.getUserStoryById(userStoryId);
  }

  @PostMapping(value = "/userstories")
  @ApiOperation(value = "Creates the User Story")
  public UserStoryDTO createUserStory(@RequestBody UserStoryDTO UserStoryDTO) {
    return userStoryService.createUserStory(UserStoryDTO);
  }

  @PutMapping(value = "/userstories/{userStoryId}")
  @ApiOperation(value = "Updates the User Story with the userStoryId specified")
  public UserStoryDTO updateUserStory(@RequestBody UserStoryDTO UserStoryDTO, @PathVariable Long userStoryId) {
    return userStoryService.updateUserStory(UserStoryDTO, userStoryId);
  }

  @DeleteMapping(value = "/userstories/{userStoryId}")
  @ApiOperation(value = "Deletes the User Story identified by its userStoryId")
  public void deleteUserStory(@PathVariable Long userStoryId) {
    userStoryService.deleteUserStoById(userStoryId);
  }

  @GetMapping(value = "/userstories/{userStoryId}/tasks")
  @ApiOperation(value = "Gets all the User Stories's Tasks within the userStoryId")
  public Iterable<TaskDTO> getAllTaks(@PathVariable Long userStoryId) {
    return taskService.getAll(userStoryId);
  }

  @GetMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  @ApiOperation(value = "Gets the specified Task's with the taskId related to the User Story with the userStoryId")
  public TaskDTO getTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
    return taskService.getById(userStoryId, taskId);
  }

  @PostMapping(value = "/userstories/{userStoryId}/tasks")
  @ApiOperation(value = "Creates a new User Story's Task related to the specified userStoryId")
  public TaskDTO createTask(@PathVariable Long userStoryId, @RequestBody TaskDTO TaskDTO) {
    return taskService.create(userStoryId, TaskDTO);
  }

  @PutMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  @ApiOperation(value = "Updates the User Story's Task with the taskId related to the userStoryId")
  public TaskDTO updateTask(@PathVariable Long userStoryId, @PathVariable Long taskId, @RequestBody TaskDTO TaskDTO) {
    return taskService.updateUserStoryTask(userStoryId, taskId, TaskDTO);
  }

  @DeleteMapping(value = "/userstories/{userStoryId}/tasks/{taskId}")
  @ApiOperation(value = "Deletes the User Story's Task with the taskId related to the userStoryId")
  public void deleteTask(@PathVariable Long userStoryId, @PathVariable Long taskId) {
    taskService.deleteById(userStoryId, taskId);
  }

  @GetMapping(value = "/labels")
  @ApiOperation(value = "Gets all the labels saved")
  public Iterable<LabelDTO> getAllLabels() {
    return labelService.getAll();
  }
}
