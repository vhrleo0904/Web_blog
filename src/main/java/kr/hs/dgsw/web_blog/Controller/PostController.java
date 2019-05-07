package kr.hs.dgsw.web_blog.Controller;

import kr.hs.dgsw.web_blog.Domain.Post;
import kr.hs.dgsw.web_blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/list")
    public List<Post> listPost() {
        return postService.listPost();
    }

    @GetMapping("/getpost/{postId}")
    public Post getPost(@PathVariable Long postId) {
        return postService.getPost(postId);
    }

    @GetMapping("/listpost/{userId}")
    public List<Post> listPostByUserId(@PathVariable Long userId) {
        return postService.listPost(userId);
    }

    @PostMapping("/addpost")
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @DeleteMapping("/removepost/{postId}")
    public boolean removePost(@PathVariable Long postId) {
        return postService.removePost(postId);
    }

    @PutMapping("/modifypost/{postId}")
    public Post modifyPost(@PathVariable Long postId, @RequestBody Post post) {
        return postService.modifyPost(postId, post);
    }
}
