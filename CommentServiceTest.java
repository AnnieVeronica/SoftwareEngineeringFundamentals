import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {
    private CommentService commentService;

    @BeforeEach
    public void setUp() {
        commentService = new CommentService();
    }

    @Test
    public void testAddCommentValidData() {
        Comment comment = commentService.addComment("This is a comment");
        assertEquals("This is a comment", comment.getText());
    }

    @Test
    public void testAddCommentEmptyText() {
        assertThrows(IllegalArgumentException.class, () -> {
            commentService.addComment("");
        });
    }

    @Test
    public void testAddCommentNullText() {
        assertThrows(IllegalArgumentException.class, () -> {
            commentService.addComment(null);
        });
    }

    @Test
    public void testAddCommentWithLeadingWhitespace() {
        Comment comment = commentService.addComment("   This is a comment with whitespace   ");
        assertEquals("This is a comment with whitespace", comment.getText());
    }

    @Test
    public void testAddMultipleComments() {
        Comment comment1 = commentService.addComment("First comment");
        Comment comment2 = commentService.addComment("Second comment");
        assertEquals("First comment", comment1.getText());
        assertEquals("Second comment", comment2.getText());
        assertEquals(2, commentService.getCommentsCount()); // Assuming you have a method to get comment count
    }

    @Test
    public void testAddDuplicateComment() {
        Comment firstComment = commentService.addComment("Duplicate comment");
        Comment duplicateComment = commentService.addComment("Duplicate comment");

        // Assuming the service returns null or throws an exception on duplicate addition
        assertNotNull(duplicateComment); // Modify this assertion based on actual behavior.
    }
}
