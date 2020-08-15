/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package userStories;

import com.sbs.dto.UserStory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import userStories.services.UserStoryService;

import java.util.stream.StreamSupport;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = UserStoriesApplication.class)
public class UserStoryServiceTest {

    @Autowired
    private UserStoryService userStoryService;

    @Test
    public void testUserStoryCreation() {
        UserStory storyToAdd = new UserStory.Builder()
                .withDescription("Description")
                .withTitle("Title")
                .withWeight(0)
                .withLabels(null)
                .withTasks(null)
                .build();
        UserStory userStoryCreated = userStoryService.createUserStory(storyToAdd);
        Assert.assertNotNull(userStoryCreated);
        Assert.assertTrue(userStoryCreated.getLabels().isEmpty());
        Assert.assertTrue(userStoryCreated.getTasks().isEmpty());
        Assert.assertEquals(storyToAdd.getTitle(), userStoryCreated.getTitle());
    }

    @Test
    public void testGetAllUsersStories() {
        UserStory storyToAdd = new UserStory.Builder()
                .withDescription("Description")
                .withTitle("Title")
                .withWeight(0)
                .withLabels(null)
                .withTasks(null)
                .build();
        userStoryService.createUserStory(storyToAdd);
        userStoryService.createUserStory(storyToAdd);
        userStoryService.createUserStory(storyToAdd);
        userStoryService.createUserStory(storyToAdd);
        Assert.assertEquals(4, StreamSupport.stream(userStoryService.getAllUserStories().spliterator(), false).count());
    }
}
