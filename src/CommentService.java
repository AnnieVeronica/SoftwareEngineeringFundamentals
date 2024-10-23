import java.util.ArrayList;
import java.util.List;

public class CommentService {
    private final List<Comment> comments = new ArrayList<>();
    public Comment addComment(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Comment text cannot be empty");
        }
        return new Comment(text);
    }
    public int getCommentsCount() {
        return comments.size();
    }
}
