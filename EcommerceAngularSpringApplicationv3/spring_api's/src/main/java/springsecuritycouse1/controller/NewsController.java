package springsecuritycouse1.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springsecuritycouse1.entities.Inventory;
import springsecuritycouse1.entities.News;
import springsecuritycouse1.entities.PriceUpdates;
import springsecuritycouse1.services.NewsService;

import java.util.List;

@RestController
@RequestMapping("/api3")
@CrossOrigin(origins = "*")
public class NewsController {


    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @PostMapping("/newInfo")
    public News postNews(@RequestBody News news) {
        return newsService.postNews(news);
    }

    @GetMapping("/news")
    public List<News> getAllNews(){
        return newsService.getAllNews();
    }

    @GetMapping("/newInfo/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id){
        News news= newsService.getNewsById(id);
        if(news ==null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(news);
    }

    @PutMapping("/newInfo/{id}")
    public ResponseEntity<Long> updateNews(@PathVariable Long id, @RequestBody News news) {
        News existingNews = newsService.getNewsById(id);
        if (existingNews == null)
            return ResponseEntity.notFound().build();

        existingNews.setNews(news.getNews());

        News updateNews = newsService.updateNews(existingNews);
        // Returning the ID after a successful update
        return ResponseEntity.ok(id);
    }



    @DeleteMapping("/newInfo/{id}")
    public  ResponseEntity<News> deleteNews(@PathVariable Long id){
        News existingNews = newsService.getNewsById(id);
        if(existingNews == null)
            return  ResponseEntity.notFound().build();
        newsService.deleteNews(id);
        return  ResponseEntity.ok().build();

    }


}
