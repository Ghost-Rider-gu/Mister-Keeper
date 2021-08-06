package corp.siendev.com.keeper.musicservice.service;

import corp.siendev.com.keeper.musicservice.config.ServiceConfig;
import corp.siendev.com.keeper.musicservice.model.Album;
import corp.siendev.com.keeper.musicservice.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    private AlbumRepository albumRepository;
    private ServiceConfig serviceConfig;

    @Autowired
    public AlbumService(AlbumRepository albumRepository, ServiceConfig serviceConfig) {
        this.albumRepository = albumRepository;
        this.serviceConfig = serviceConfig;
    }

    public void createAlbum() {
        albumRepository.save(new Album());
    }

    public List<Album> getAllAlbum() {
        return albumRepository.findAll();
    }
}
