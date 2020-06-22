//package br.com.swapi.api.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//import br.com.swapi.api.model.Planeta;
//
//public interface StarwarsService {
//	
//	public static final StarwarsRepository starwarsRepo = null;
//	
//	public static void salvar(String name, String clima, String terreno, String shows) {
//		starwarsRepo.save(new Planeta(name, clima, terreno, shows));
//    }
// 
//    public static List<Planeta> findAll() {
//       return starwarsRepo.findAll();
//    }
// 
//    public static long count() {
//        return starwarsRepo.count();
//    }
// 
//    public static Optional<Planeta> findById(String id) {
//        return starwarsRepo.findById(id);
//    }
// 
//    public static void delete(String id) {
//    	starwarsRepo.deleteById(id);
//    }
//	
//	
//}
