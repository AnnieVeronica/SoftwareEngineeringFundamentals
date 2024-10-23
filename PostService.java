public class PostService {
    public Post addPost(String title, String content) {
        if (title == null || content == null || title.isEmpty() || content.isEmpty()) {
            throw new IllegalArgumentException("Title and content cannot be empty");
        }
        return new Post(title, content);
    }
}
