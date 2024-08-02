package springsecuritycouse1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springsecuritycouse1.entities.News;
import springsecuritycouse1.entities.PriceUpdates;
import springsecuritycouse1.repositories.NewsRepository;

import java.util.List;

@Service
public class NewsService {

    @Autowired
    private final NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public News postNews(News news){
        return  newsRepository.save(news);
    }

    public List<News> getAllNews(){
        return  newsRepository.findAll();
    }


    public  News getNewsById(Long id){
        return newsRepository.findById(id).orElse(null);
    }

    public News  updateNews(News news){
        return newsRepository.save(news);
    }

    public  void deleteNews(Long id){
        newsRepository.deleteById(id);
    }


}
