package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.Comments;
import springsecuritycouse1.entities.Shop;
import springsecuritycouse1.repositories.CommentRepository;
import springsecuritycouse1.repositories.ShopRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comments> getAllComments() {
        return commentRepository.findAll();
    }

    public Optional<Comments> getCommentById(Long id) {
        return commentRepository.findById(id);
    }

    public Comments saveComment(Comments comments) {
        return commentRepository.save(comments);
    }



    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}
