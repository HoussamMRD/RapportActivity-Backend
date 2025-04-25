package ma.srmanager.srrapportactivity.Activity.services.commandes.Planifier;


import ma.srmanager.srrapportactivity.Activity.models.Planifier.MainOeuvreDTO;


public interface MainOeuvreCommandService {
    MainOeuvreDTO createMainOeuvre(MainOeuvreDTO mainOeuvreDTO);
    MainOeuvreDTO updateMainOeuvre(Long id, MainOeuvreDTO mainOeuvreDTO);
    void deleteMainOeuvre(Long id);
}