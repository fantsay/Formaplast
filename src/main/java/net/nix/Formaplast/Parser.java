package net.nix.Formaplast;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by fantsay on 8/7/15.
 */
public class Parser {

    private List<GlassEntity> glassEntities;
    private Map<Integer, List<String>> glString;

    public Parser(Map<Integer, List<String>> glassString) {
        this.glString = glassString;
        this.glassEntities = new LinkedList<>();

    }

    public List<GlassEntity> getGlass() {

        glString.values().forEach(this::getG); // For every List do getG, that returns net.nix.Formaplast.GlassEntity Object

        return glassEntities;
    }

    private void getG(List<String> strings) {

        GlassEntity glassEntity = new GlassEntity();
        glassEntity.setCode(strings.get(1));
        glassEntity.setDescription(strings.get(2));
        glassEntity.setManufact(strings.get(3));
        glassEntity.setQuality(strings.get(4));
        glassEntity.setPrice(strings.get(5));
        glassEntity.setDescription(strings.get(6));
        glassEntity.setVal(strings.get(7));
        glassEntity.setNote(strings.get(8));
        glassEntities.add(glassEntity);

    }

}
