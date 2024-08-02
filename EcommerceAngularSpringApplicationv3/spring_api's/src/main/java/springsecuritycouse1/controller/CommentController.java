package springsecuritycouse1.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.entities.Comments;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.services.CommentService;
import springsecuritycouse1.services.ShopService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api8/opinion")
@CrossOrigin(origins = "*")
public class CommentController {
    @Autowired
    private CommentService commentService;


    @GetMapping("/comments")
    public List<Comments> getAllComment() {
        return commentService.getAllComments();
    }




    @GetMapping("/comment/{id}")
    public ResponseEntity<Comments> getCommentById(@PathVariable Long id) {
        Optional<Comments> comment = commentService.getCommentById(id);
        return comment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/comment")
    public ResponseEntity<Comments> saveComment(@RequestBody Comments comment) {
        Comments savedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(savedComment);
    }


    @PutMapping("/comment/{id}")
    public ResponseEntity<Comments> updateComment(@PathVariable Long id, @RequestBody Comments comment) {
        if (!commentService.getCommentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        comment.setId(id);
        Comments updatedComment = commentService.saveComment(comment);
        return ResponseEntity.ok(updatedComment);
    }


    @DeleteMapping("/comment/{id}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long id) {
        if (!commentService.getCommentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        commentService.deleteComment(id);
        return ResponseEntity.ok().build();
    }
}
