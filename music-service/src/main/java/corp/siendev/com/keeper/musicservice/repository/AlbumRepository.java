package corp.siendev.com.keeper.musicservice.repository;

import corp.siendev.com.keeper.musicservice.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    public List<Album> findAlbumsByName(String albumName);
}
