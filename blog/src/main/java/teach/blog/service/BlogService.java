package teach.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import teach.blog.model.Comment;
import teach.blog.model.Entry;
import teach.blog.repository.CommentsRepository;
import teach.blog.repository.EntriesRepository;

import java.util.List;

@Service
@Transactional
public class BlogService {

    @Autowired
    private EntriesRepository entriesRepository;

    @Autowired
    private CommentsRepository commentsRepository;

    public List<Entry> getEntries() {
        return entriesRepository.getEntries();
    }

    public Entry getEntryById(Long id) {
        return entriesRepository.getEntryById(id);
    }

    public List<Comment> getCommentsForEntry(Entry entry) {
        return commentsRepository.getCommentsForEntry(entry);
    }

    public void removeEntryById(Long id) {
        entriesRepository.deleteEntryById(id);
    }

    public void saveEntry(Entry entry) {
        entriesRepository.save(entry);
    }
}
