import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> available = new HashSet<>(Arrays.asList(supplies)); 
        List<String> result = new ArrayList<>();
        boolean addedNewRecipe = true;

        while (addedNewRecipe) {
            addedNewRecipe = false;
            for (int i = 0; i < recipes.length; i++) {
                if (available.contains(recipes[i])) continue; 
                
                boolean canMake = true;
                for (String ing : ingredients.get(i)) {
                    if (!available.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }
                
                if (canMake) {
                    result.add(recipes[i]);
                    available.add(recipes[i]); 
                    addedNewRecipe = true;
                }
            }
        }

        return result;
    }
}
