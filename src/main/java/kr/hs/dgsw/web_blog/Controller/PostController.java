package kr.hs.dgsw.web_blog.Controller;

import kr.hs.dgsw.web_blog.Domain.Post;
import kr.hs.dgsw.web_blog.Protocol.ResponseFormat;
import kr.hs.dgsw.web_blog.Protocol.ResponseType;
import kr.hs.dgsw.web_blog.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/listpost")
    public ResponseFormat listPost() {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        List<Post> postList = postService.listPost();
        if (postList != null) {
            rf = new ResponseFormat(
                    ResponseType.POST_LIST,
                    postList,
                    (long) postList.size()
            );
        }
        return rf;
    }

    @GetMapping("/getpost/{postId}")
    public ResponseFormat getPost(@PathVariable Long postId) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        Post post = postService.getPost(postId);
        if (post != null) {
            rf = new ResponseFormat(
                    ResponseType.POST_GET,
                    post,
                    post.getId()
            );
        }
        return rf;
    }


    @PostMapping("/addpost")
    public ResponseFormat addPost(@RequestBody Post post) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        Post p = postService.addPost(post);
        if (p != null) {
            rf = new ResponseFormat(
                    ResponseType.POST_ADD,
                    p,
                    p.getId()
            );
        }
        return rf;
    }

    @DeleteMapping("/removepost/{postId}")
    public ResponseFormat removePost(@PathVariable Long postId) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);

        if (postService.removePost(postId)) {
            rf = new ResponseFormat(
                    ResponseType.POST_DELETE,
                    true,
                    postId
            );
        }
        return rf;
    }

    @PutMapping("/modifypost/{postId}")
    public ResponseFormat modifyPost(@PathVariable Long postId, @RequestBody Post post) {
        ResponseFormat rf = new ResponseFormat(ResponseType.FAIL, null);
        Post p = postService.modifyPost(postId, post);
        if (p != null) {
            rf = new ResponseFormat(
                    ResponseType.POST_UPDATE,
                    p,
                    p.getId()
            );
        }
        return rf;
    }
}
