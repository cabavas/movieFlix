package tech.vascon.movieFlix.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.vascon.movieFlix.category.Category;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    List<Movie> findByCategories(List<Category> categories);
}
