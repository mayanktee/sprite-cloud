package utils;

import requestPojo.Category;
import requestPojo.Order;
import requestPojo.Pet;
import requestPojo.Tag;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {

    public Order createPetStoreIdPayload(int id, int petId){
        Order order = new Order();

        order.setId(id);
        order.setPetId(petId);
        order.setQuantity(1);
        order.setStatus("placed");
        order.setComplete(true);

        return order;
    }

    public Pet addPetPayload(long id,String categoryId,String categoryName,String petName,String img){
        Pet pet = new Pet();

        pet.setId(id);

        Category category = new Category();
        category.setId(Integer.valueOf(categoryId));
        category.setName(categoryName);

        pet.setCategory(category);

        pet.setName(petName);

        List<String> photoUrls = new ArrayList<>();
        photoUrls.add(img);
        pet.setPhotoUrls(photoUrls);

        Tag tag = new Tag();
        tag.setId(0);
        tag.setName("male");

        List<Tag> tags = new ArrayList<>();
        pet.setTags(tags);

        pet.setStatus("available");

        return pet;
    }

    public String createPetStoreOrderPayloadRaw(long id, int petId, int quantity, String status){
        return "{\n" +
                "  \"id\":"+id+",\n" +
                "  \"petId\":"+petId+",\n" +
                "  \"quantity\":"+quantity+",\n" +
                "  \"shipDate\": \"2023-07-17T20:10:00.511Z\",\n" +
                "  \"status\": "+status+",\n" +
                "  \"complete\": true\n" +
                "}";
    }

}
