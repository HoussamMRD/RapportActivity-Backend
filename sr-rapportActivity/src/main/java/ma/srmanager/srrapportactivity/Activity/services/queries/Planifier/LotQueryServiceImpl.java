package ma.srmanager.srrapportactivity.Activity.services.queries.Planifier;

import ma.srmanager.srrapportactivity.Activity.entities.Planifier.Lot;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.LotDTO;
import ma.srmanager.srrapportactivity.Activity.repositories.Planifier.LotRepository;
import ma.srmanager.srrapportactivity.Activity.models.Planifier.ArticleDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;




@Service
public class LotQueryServiceImpl implements LotQueryService {
    @Autowired
    private LotRepository lotRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LotDTO getLotById(Long id) {
        Lot lot = lotRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Lot not found"));

        LotDTO lotDTO = modelMapper.map(lot, LotDTO.class);
        lotDTO.setArticles(lot.getArticles().stream()
                .map(article -> modelMapper.map(article, ArticleDTO.class))
                .collect(Collectors.toList()));

        return lotDTO;

    }

    @Override
    public List<LotDTO> getAllLots() {
        return lotRepository.findAll().stream()
                .map(lot -> {
                    LotDTO lotDTO = modelMapper.map(lot, LotDTO.class);
                    lotDTO.setArticles(lot.getArticles().stream()
                            .map(article -> {
                                ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
                                articleDTO.setIdLot(lot.getIdLot()); // Ensure correct mapping
                                return articleDTO;
                            })
                            .collect(Collectors.toList()));
                    return lotDTO;
                })
                .collect(Collectors.toList());
    }
}
