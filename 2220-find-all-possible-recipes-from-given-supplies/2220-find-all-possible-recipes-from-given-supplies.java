import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> available = new HashSet<>(Arrays.asList(supplies)); // Store initial supplies
        List<String> result = new ArrayList<>();
        boolean addedNewRecipe = true; // To track if we are making progress

        while (addedNewRecipe) {
            addedNewRecipe = false;
            for (int i = 0; i < recipes.length; i++) {
                if (available.contains(recipes[i])) continue; // Skip if already added
                
                boolean canMake = true;
                for (String ing : ingredients.get(i)) {
                    if (!available.contains(ing)) {
                        canMake = false;
                        break;
                    }
                }
                
                if (canMake) {
                    result.add(recipes[i]);
                    available.add(recipes[i]); // Mark recipe as available
                    addedNewRecipe = true;
                }
            }
        }

        return result;
    }
}
