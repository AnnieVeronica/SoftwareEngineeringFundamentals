import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PostServiceTest {
    private final PostService postService = new PostService();

    @org.junit.Test
    @Test
    public void testAddPostValidData() {
        Post post = postService.addPost("My Title", "My Content");
        assertEquals("My Title", post.getTitle());
        assertEquals("My Content", post.getContent());
    }

    @Test
    public void testAddPostEmptyTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            postService.addPost("", "My Content");
        });
    }

    @Test
    public void testAddPostNullContent() {
        assertThrows(IllegalArgumentException.class, () -> {
            postService.addPost("My Title", null);
        });
    }

    @Test
    public void testAddPostEmptyContent() {
        assertThrows(IllegalArgumentException.class, () -> {
            postService.addPost("My Title", "");
        });
    }

    @Test
    public void testAddPostNullTitle() {
        assertThrows(IllegalArgumentException.class, () -> {
            postService.addPost(null, "My Content");
        });
    }

    @Test
    public void testAddPostBothNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            postService.addPost(null, null);
        });
    }
}
