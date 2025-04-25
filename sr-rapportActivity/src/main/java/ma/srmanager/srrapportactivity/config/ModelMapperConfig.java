package ma.srmanager.srrapportactivity.config;
import ma.srmanager.srrapportactivity.Activity.entities.Suivi.LotSuivi;
import ma.srmanager.srrapportactivity.Activity.models.Suivi.LotSuiviDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;






@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);



        // Explicitly map idTacheSuivi
        modelMapper.typeMap(LotSuivi.class, LotSuiviDTO.class)
                .addMapping(src -> src.getTacheSuivi().getIdTacheSuivi(), LotSuiviDTO::setIdTacheSuivi);







        return modelMapper;
    }
}
