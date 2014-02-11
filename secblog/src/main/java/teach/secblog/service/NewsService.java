package teach.secblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import teach.secblog.model.Comment;
import teach.secblog.model.News;
import teach.secblog.repository.Repository;

import java.util.List;

@Service
public class NewsService {
    @Autowired
    private Repository repository;

    public List<News> getAllNews() {
        return repository.getNews();
    }

    public News getNewsByIndex(Integer index) {
        return repository.getNewsByIndex(index);
    }

    public void addNews(News news) {
        repository.insertNews(news);
    }

    public void addComment(Integer newsindex, Comment comment) {
        repository.insertComment(repository.getNewsByIndex(newsindex), comment);
    }

    @Secured("ROLE_INEXISTENT")
    public void deleteNews(Integer index) {
        repository.deleteNews(repository.getNewsByIndex(index));
    }

    public void deleteComment(Integer newsindex, Integer commentindex) {
        News news = repository.getNewsByIndex(newsindex);
        repository.deleteComment(news, news.getComments().get(commentindex));
    }
}
