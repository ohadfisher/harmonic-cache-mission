import model.NodeData;
import service.CacheService;

public class Main {
    public static void main(String[] args) {
        CacheService cacheService = new CacheService();

        NodeData nodeDataA = new NodeData(1, 100);
        NodeData nodeDataB = new NodeData(2, 200);
        NodeData nodeDataC = new NodeData(3, 300);
        NodeData nodeDataD = new NodeData(4, 400);
        NodeData nodeDataE = new NodeData(5, 500);


        cacheService.add(nodeDataA);
        cacheService.add(nodeDataB);
        cacheService.printCache("B->A");
        cacheService.add(nodeDataA);
        cacheService.printCache("A->B");
        cacheService.add(nodeDataB);
        cacheService.printCache("B->A");

        cacheService.add(nodeDataC);
        cacheService.printCache("C->B->A");
        cacheService.add(nodeDataB);
        cacheService.printCache("B->C->A");
        cacheService.add(nodeDataD);
        cacheService.printCache("D->B->C");


    }
}
