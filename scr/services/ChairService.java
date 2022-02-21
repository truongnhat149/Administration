package services;

import model.product.Chair;
import services.tools.IItemService;
import utils.file.TextFileUtil;
import utils.json.JacksonParser;

import java.util.ArrayList;
import java.util.List;

public class ChairService implements IItemService {
    private static String path = "data/chair.json";
    public ChairService() {
    }

    @Override
    public List<Chair> getItem() {
        String jsonString = TextFileUtil.read(path);
        if (jsonString != null && jsonString.trim().length() > 0)
            return JacksonParser.INSTANCE.toList(jsonString, Chair.class);
        return new ArrayList<>();
    }

    @Override
    public void addItem(Chair newChair) {
        List<Chair> chairs = getItem();
        chairs.add(newChair);
        String json = JacksonParser.INSTANCE.toJson(chairs);
        TextFileUtil.writeFile(json, path);
    }

    @Override
    public void update(Chair newChair) {
        List<Chair> chairs = getItem();
        //TODO:
        for (Chair chair : chairs) {
            if (chair.getProductID() == newChair.getProductID()) {
                chair.setPrice(newChair.getPrice());
                chair.setQuantity(newChair.getQuantity());
                chair.setProvideName(newChair.getProvideName());
            }
        }
        String json = JacksonParser.INSTANCE.toJson(chairs);
        TextFileUtil.writeFile(json, path);
    }

    @Override
    public void remove(Chair chair) {
        List<Chair> chairs = getItem();
        System.out.println((long) chairs.size());
        System.out.println(chair);
        chairs.remove(chair);
        System.out.println((long) chairs.size());
        String json = JacksonParser.INSTANCE.toJson(chairs);
        TextFileUtil.writeFile(json, path);
    }

    public Chair getChairByID(int id) {
        List<Chair> chairs = getItem();
        for (Chair chair : chairs) {
            if (chair.getProductID() == id) {
                return chair;
            }
        }
        return null;
    }

    @Override
    public boolean exists(int id) {
        return getChairByID(id) != null;
    }
}