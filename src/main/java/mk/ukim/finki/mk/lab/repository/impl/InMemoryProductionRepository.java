//package mk.ukim.finki.mk.lab.repository.impl;
//
//import jakarta.annotation.PostConstruct;
//import mk.ukim.finki.mk.lab.model.Production;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class InMemoryProductionRepository {
//
//    public static List<Production> productionList = new ArrayList<>(5);
//
//    @PostConstruct
//    public void init() {
//        productionList.add(new Production("Televizija Zdravkin", "Macedonia", "Veles"));
//        productionList.add(new Production("Disney", "India", "Mumbai"));
//        productionList.add(new Production("Universal Studios", "England", "London"));
//        productionList.add(new Production("Bethesda", "Sweden", "Malmo"));
//        productionList.add(new Production("Rockstar Games", "USA", "San Francisco"));
//    }
//
//    public List<Production> findAll(){
//        return productionList;
//    }
//    public Optional<Production> findById(Long id){
//        return productionList.stream().filter(l -> l.getId().equals(id)).findFirst();
//    }
//}
